/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mymc.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.mcreator.mymc.item.SteelSwordItem;
import net.mcreator.mymc.item.SteelShovelItem;
import net.mcreator.mymc.item.SteelPickaxeItem;
import net.mcreator.mymc.item.SteelIngotItem;
import net.mcreator.mymc.item.SteelHoeItem;
import net.mcreator.mymc.item.SteelFengItem;
import net.mcreator.mymc.item.SteelAxeItem;
import net.mcreator.mymc.item.SteelArmorItem;
import net.mcreator.mymc.MymcMod;

public class MymcModItems {
	public static Item STEEL_ARMOR_HELMET;
	public static Item STEEL_ARMOR_CHESTPLATE;
	public static Item STEEL_ARMOR_LEGGINGS;
	public static Item STEEL_ARMOR_BOOTS;
	public static Item STEEL_INGOT;
	public static Item STEEL_AXE;
	public static Item STEEL_PICKAXE;
	public static Item STEEL_SWORD;
	public static Item STEEL_SHOVEL;
	public static Item STEEL_HOE;
	public static Item STEEL_FENG;

	public static void load() {
		STEEL_ARMOR_HELMET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_armor_helmet"), new SteelArmorItem.Helmet());
		STEEL_ARMOR_CHESTPLATE = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_armor_chestplate"), new SteelArmorItem.Chestplate());
		STEEL_ARMOR_LEGGINGS = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_armor_leggings"), new SteelArmorItem.Leggings());
		STEEL_ARMOR_BOOTS = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_armor_boots"), new SteelArmorItem.Boots());
		STEEL_INGOT = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_ingot"), new SteelIngotItem());
		STEEL_AXE = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_axe"), new SteelAxeItem());
		STEEL_PICKAXE = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_pickaxe"), new SteelPickaxeItem());
		STEEL_SWORD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_sword"), new SteelSwordItem());
		STEEL_SHOVEL = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_shovel"), new SteelShovelItem());
		STEEL_HOE = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_hoe"), new SteelHoeItem());
		STEEL_FENG = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MymcMod.MODID, "steel_feng"), new SteelFengItem());
	}

	public static void clientLoad() {
	}
}
