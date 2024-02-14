
package net.mcreator.mymc.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcreator.mymc.init.MymcModTabs;
import net.mcreator.mymc.init.MymcModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class SteelSwordItem extends SwordItem {
	public SteelSwordItem() {
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
		}, 3, -3f, new Item.Properties());
		ItemGroupEvents.modifyEntriesEvent(MymcModTabs.TAB_MYSTERIOUSCRAFTSMANSHIP).register(content -> content.accept(this));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public boolean isFoil(ItemStack itemstack) {
//		return true;
//	}
}
