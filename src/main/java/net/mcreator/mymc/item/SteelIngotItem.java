
package net.mcreator.mymc.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcreator.mymc.procedures.SteelIngotWanJiaWanChengShiYongWuPinShiProcedure;
import net.mcreator.mymc.procedures.SteelIngotDangWuPinBeiHeChengHuoShaoLianShiProcedure;
import net.mcreator.mymc.init.MymcModTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class SteelIngotItem extends Item {
	public SteelIngotItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(-10).saturationMod(-1f).alwaysEat()

				.build()));
		ItemGroupEvents.modifyEntriesEvent(MymcModTabs.TAB_MYSTERIOUSCRAFTSMANSHIP).register(content -> content.accept(this));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public boolean isFoil(ItemStack itemstack) {
//		return true;
//	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A79SteelIngot"));
		list.add(Component.literal("\u00A79&nThis seems to contain mysterious energy?"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = InteractionResultHolder.success(entity.getItemInHand(hand));
		entity.startUsingItem(hand);
		return ar;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		SteelIngotWanJiaWanChengShiYongWuPinShiProcedure.execute(world, x, y, z);
		return retval;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		SteelIngotDangWuPinBeiHeChengHuoShaoLianShiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void onUseTick(Level world, LivingEntity entity, ItemStack itemstack, int count) {
		if (!world.isClientSide() && entity instanceof ServerPlayer player) {
			ItemStack stack = ProjectileWeaponItem.getHeldProjectile(entity, e -> e.getItem() == Items.ARROW);
			if (stack == ItemStack.EMPTY) {
				for (int i = 0; i < player.getInventory().items.size(); i++) {
					ItemStack teststack = player.getInventory().items.get(i);
					if (teststack != null && teststack.getItem() == Items.ARROW) {
						stack = teststack;
						break;
					}
				}
			}
			if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
				Arrow projectile = new Arrow(world, entity);
				projectile.shootFromRotation(entity, entity.getXRot(), entity.getYRot(), 0, 3.15f, 1.0F);
				world.addFreshEntity(projectile);
				world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries
						.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
						SoundSource.PLAYERS, 1, 1f / (world.getRandom().nextFloat() * 0.5f + 1));
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				if (player.getAbilities().instabuild) {
					projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
				} else {
					if (stack.isDamageableItem()) {
						if (stack.hurt(1, world.getRandom(), player)) {
							stack.shrink(1);
							stack.setDamageValue(0);
							if (stack.isEmpty())
								player.getInventory().removeItem(stack);
						}
					} else {
						stack.shrink(1);
						if (stack.isEmpty())
							player.getInventory().removeItem(stack);
					}
				}
			}
			entity.releaseUsingItem();
		}
	}
}
