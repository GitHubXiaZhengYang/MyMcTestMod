
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mymc.init;

import net.mcreator.mymc.MymcMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MymcModTabs {
	public static ResourceKey<CreativeModeTab> TAB_MYSTERIOUSCRAFTSMANSHIP = ResourceKey.create(Registries
			.CREATIVE_MODE_TAB, new ResourceLocation(MymcMod.MODID, "mysteriouscraftsmanship"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_MYSTERIOUSCRAFTSMANSHIP,
				FabricItemGroup.builder().title(Component.translatable("item_group." +
						MymcMod.MODID + ".mysteriouscraftsmanship")).icon(() ->
						new ItemStack(MymcModItems.STEEL_INGOT)).build());
	}
}
