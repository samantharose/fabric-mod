package de.netflam.gemstones.items;

import de.netflam.gemstones.GemstonesMod;
import de.netflam.gemstones.SapphireArmorMaterial;
import de.netflam.gemstones.RubyArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    public static final ArmorMaterial rubyArmorMaterial = new RubyArmorMaterial();
    public static final Item RUBY_MATERIAL = new RubyItem(new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item RUBY_HELMET = new ArmorItem(rubyArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item RUBY_CHESTPLATE = new ArmorItem(rubyArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item RUBY_LEGGINGS = new ArmorItem(rubyArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item RUBY_BOOTS = new ArmorItem(rubyArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(GemstonesMod.GemstonesMod));

    public static final ArmorMaterial sapphireArmorMaterial = new SapphireArmorMaterial();
    public static final Item SAPPHIRE_MATERIAL = new SapphireItem(new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item SAPPHIRE_HELMET = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(sapphireArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(GemstonesMod.GemstonesMod));


    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_item"), RUBY_MATERIAL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_boots"), RUBY_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_item"), SAPPHIRE_MATERIAL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_boots"), SAPPHIRE_BOOTS);
    }
}