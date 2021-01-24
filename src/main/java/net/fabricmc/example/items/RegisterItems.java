package net.fabricmc.example.items;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.RubyArmorMaterial;
import net.fabricmc.example.SapphireArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    public static final ArmorMaterial rubyArmorMaterial = new RubyArmorMaterial();
    public static final Item RUBY_MATERIAL = new RubyItem(new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_HELMET = new ArmorItem(rubyArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_CHESTPLATE = new ArmorItem(rubyArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_LEGGINGS = new ArmorItem(rubyArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item RUBY_BOOTS = new ArmorItem(rubyArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ExampleMod.MinecraftMod));

    public static final ArmorMaterial sapphireArmorMaterial = new SapphireArmorMaterial();
    public static final Item SAPPHIRE_MATERIAL = new SapphireItem(new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item SAPPHIRE_HELMET = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ExampleMod.MinecraftMod));
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ExampleMod.MinecraftMod));


    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_item"), RUBY_MATERIAL);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_boots"), RUBY_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_item"), SAPPHIRE_MATERIAL);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_boots"), SAPPHIRE_BOOTS);
    }
}