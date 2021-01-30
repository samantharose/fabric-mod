package de.netflam.gemstones;

import de.netflam.gemstones.items.RegisterItems;
import de.netflam.gemstones.ores.*;
import de.netflam.gemstones.tools.AmethystWeapon;
import de.netflam.gemstones.tools.RoseQuartzWeapon;
import de.netflam.gemstones.tools.RubyWeapon;
import de.netflam.gemstones.tools.SapphireWeapon;
import de.netflam.gemstones.tools.templates.CustomAxeItem;
import de.netflam.gemstones.tools.templates.CustomHoeItem;
import de.netflam.gemstones.tools.templates.CustomPickaxeItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class GemstonesMod implements ModInitializer {

    // oh god no // Oh God YES
    public static final Identifier ARMOUR_EQUIP = new Identifier("gemstones:armour_equip_sound");
    public static SoundEvent ARMOUR_EQUIP_EVENT = new SoundEvent(ARMOUR_EQUIP);

    // Ruby blocks, items and tools
    public static final Block RUBY_ORE = RubyOre.getOre();
    public static final Item RUBY = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(10.0F));
    public static final ToolItem RUBY_SWORD = new SwordItem(RubyWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem RUBY_PICKAXE = new CustomPickaxeItem(RubyWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem RUBY_AXE = new CustomAxeItem(RubyWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem RUBY_HOE = new CustomHoeItem(RubyWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));


    // Sapphire blocks, items and tools
    public static final Block SAPPHIRE_ORE = SapphireOre.getOre();
    public static final Item SAPPHIRE = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Block SAPPHIRE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(10.0F));
    public static final ToolItem SAPPHIRE_SWORD = new SwordItem(SapphireWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem SAPPHIRE_PICKAXE = new CustomPickaxeItem(SapphireWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem SAPPHIRE_SHOVEL = new ShovelItem(SapphireWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem SAPPHIRE_AXE = new CustomAxeItem(SapphireWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem SAPPHIRE_HOE = new CustomHoeItem(SapphireWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));


    // Rose quartz blocks, items and tools
    public static final Block ROSE_QUARTZ_ORE = RoseQuartzOre.getOre();
    public static final Item ROSE_QUARTZ = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Block ROSE_QUARTZ_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(10.0F));
    public static final ToolItem ROSE_QUARTZ_SWORD = new SwordItem(RoseQuartzWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem ROSE_QUARTZ_PICKAXE = new CustomPickaxeItem(RoseQuartzWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem ROSE_QUARTZ_SHOVEL = new ShovelItem(RoseQuartzWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem ROSE_QUARTZ_AXE = new CustomAxeItem(RoseQuartzWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem ROSE_QUARTZ_HOE = new CustomHoeItem(RoseQuartzWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));


    // Amethyst blocks, items and tools
    public static final Block AMETHYST_ORE = AmethystOre.getOre();
    public static final Item AMETHYST = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
    public static final Block AMETHYST_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0F));
    public static final ToolItem AMETHYST_SWORD = new SwordItem(AmethystWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem AMETHYST_PICKAXE = new CustomPickaxeItem(AmethystWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_SHOVEL = new ShovelItem(AmethystWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_AXE = new CustomAxeItem(AmethystWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_HOE = new CustomHoeItem(AmethystWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));


    // ItemGroup
    public static final ItemGroup GemstonesMod = FabricItemGroupBuilder.build(
            new Identifier("gemstones", "items"),
            () -> new ItemStack(RUBY_BLOCK));


    @Override
    public void onInitialize() {
        System.out.println("Gemstones mod starting...");

        // Register ruby blocks/items in registry system and generate ore
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby"), RUBY);
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_sword"), RUBY_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_axe"), RUBY_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_hoe"), RUBY_HOE);
        RegistryKey<ConfiguredFeature<?, ?>> rubyOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("gemstones", "ruby_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOreOverworld.getValue(), RubyOre.getConfiguredOreFeature());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOreOverworld);


        // Register sapphire blocks/items in registry system and generate ore
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire"), SAPPHIRE);
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "sapphire_ore"), SAPPHIRE_ORE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "sapphire_block"), SAPPHIRE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_sword"), SAPPHIRE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_pickaxe"), SAPPHIRE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_shovel"), SAPPHIRE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_axe"), SAPPHIRE_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_hoe"), SAPPHIRE_HOE);
        RegistryKey<ConfiguredFeature<?, ?>> sapphireOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("gemstones", "sapphire_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sapphireOreOverworld.getValue(), SapphireOre.getConfiguredOreFeature());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sapphireOreOverworld);


        // Register rose quartz blocks/items in registry system and generate ore
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz"), ROSE_QUARTZ);
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "rose_quartz_ore"), ROSE_QUARTZ_ORE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_ore"), new BlockItem(ROSE_QUARTZ_ORE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "rose_quartz_block"), ROSE_QUARTZ_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_block"), new BlockItem(ROSE_QUARTZ_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_sword"), ROSE_QUARTZ_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_pickaxe"), ROSE_QUARTZ_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_shovel"), ROSE_QUARTZ_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_axe"), ROSE_QUARTZ_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_hoe"), ROSE_QUARTZ_HOE);
        RegistryKey<ConfiguredFeature<?, ?>> roseQuartzOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("gemstones", "rose_quartz_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, roseQuartzOreOverworld.getValue(), RoseQuartzOre.getConfiguredOreFeature());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, roseQuartzOreOverworld);


        // Register amethyst blocks/items in registry system and generate ore
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst"), AMETHYST);
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "amethyst_ore"), AMETHYST_ORE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_ore"), new BlockItem(AMETHYST_ORE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("gemstones", "amethyst_block"), AMETHYST_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_block"), new BlockItem(AMETHYST_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_sword"), AMETHYST_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_pickaxe"), AMETHYST_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_shovel"), AMETHYST_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_axe"), AMETHYST_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_hoe"), AMETHYST_HOE);
        RegistryKey<ConfiguredFeature<?, ?>> amethystOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("gemstones", "amethyst_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, amethystOreOverworld.getValue(), AmethystOre.getConfiguredOreFeature());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, amethystOreOverworld);


        // Register armour equip sound
        Registry.register(Registry.SOUND_EVENT, ARMOUR_EQUIP, ARMOUR_EQUIP_EVENT);


        // Register armour
        RegisterItems.register();
    }
}
