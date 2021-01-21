package net.fabricmc.example.items;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.RubyArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    public static final ArmorMaterial customArmorMaterial = new RubyArmorMaterial();
    public static final Item RUBY_MATERIAL = new RubyItem(new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_HELMET = new ArmorItem(customArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_CHESTPLATE = new ArmorItem(customArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_LEGGINGS = new ArmorItem(customArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_BOOTS = new ArmorItem(customArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ExampleMod.MinecraftMod));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_item"), RUBY_MATERIAL);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_boots"), RUBY_BOOTS);
    }
}