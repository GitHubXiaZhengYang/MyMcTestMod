
package net.mcreator.mymc.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcreator.mymc.procedures.SteelIngotDangWuPinBeiHeChengHuoShaoLianShiProcedure;
import net.mcreator.mymc.init.MymcModTabs;
import net.mcreator.mymc.init.MymcModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class SteelHoeItem extends HoeItem {
	public SteelHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 6280;
			}

			public float getSpeed() {
				return 24f;
			}

			public float getAttackDamageBonus() {
				return 18f;
			}

			public int getLevel() {
				return 20;
			}

			public int getEnchantmentValue() {
				return 140;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MymcModItems.STEEL_INGOT));
			}
		}, 0, -3f, new Item.Properties().fireResistant());
		ItemGroupEvents.modifyEntriesEvent(MymcModTabs.TAB_MYSTERIOUSCRAFTSMANSHIP).register(content -> content.accept(this));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		SteelIngotDangWuPinBeiHeChengHuoShaoLianShiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}

//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public boolean isFoil(ItemStack itemstack) {
//		return true;
//	}
}
