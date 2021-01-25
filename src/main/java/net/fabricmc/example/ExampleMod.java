package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.block.Material;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.GenerationStep;
import net.fabricmc.example.items.RegisterItems;
import net.minecraft.sound.SoundEvent;

public class ExampleMod implements ModInitializer {
	// oh god no
	public static final Identifier ARMOUR_EQUIP = new Identifier("minecraftmod:armour_equip_sound");
	public static SoundEvent ARMOUR_EQUIP_EVENT = new SoundEvent(ARMOUR_EQUIP);

	// Ruby blocks, items and tools
	public static final Item RUBY = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
	public static final Block RUBY_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0F));
	public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(10.0F));
	public static final ToolItem RUBY_SWORD = new SwordItem(RubyWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
	public final ToolItem RUBY_PICKAXE = new CustomPickaxeItem(RubyWeapon.INSTANCE,2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
	public final ToolItem RUBY_AXE = new CustomAxeItem(RubyWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
	public final ToolItem RUBY_HOE = new CustomHoeItem(RubyWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));


	// Sapphire blocks, items and tools
	public static final Item SAPPHIRE = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));
	public static final Block SAPPHIRE_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0F));
	public static final Block SAPPHIRE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(10.0F));
	public static final ToolItem SAPPHIRE_SWORD = new SwordItem(SapphireWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
	public final ToolItem SAPPHIRE_PICKAXE = new CustomPickaxeItem(SapphireWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_SHOVEL = new ShovelItem(SapphireWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
	public final ToolItem SAPPHIRE_AXE = new CustomAxeItem(SapphireWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
	public final ToolItem SAPPHIRE_HOE = new CustomHoeItem(SapphireWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));


	// Ruby ore generation
	private static ConfiguredFeature<?, ?> RUBY_ORE_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					RUBY_ORE.getDefaultState(),
					6))
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0,
					0,
					64)))
			.spreadHorizontally()
			.repeat(5);

	// Sapphire ore generation
	private static ConfiguredFeature<?, ?> SAPPHIRE_ORE_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					SAPPHIRE_ORE.getDefaultState(),
					6))
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0,
					0,
					64)))
			.spreadHorizontally()
			.repeat(5);


	// `PickaxeItem` , `HoeItem` and `AxeItem` have protected constructors, which means you will need to create your own sub-class with a public constructor
	public class CustomPickaxeItem extends PickaxeItem {
		public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}

	public class CustomHoeItem extends HoeItem {
		public CustomHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}

	public class CustomAxeItem extends AxeItem {
		public CustomAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}


	// ItemGroup
	public static final ItemGroup MinecraftMod = FabricItemGroupBuilder.build(
			new Identifier("minecraftmod", "stuff"),
			() -> new ItemStack(RUBY_BLOCK));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		System.out.println("Hello fellow fags!");

		// Register ruby in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby"), RUBY);

		// Register ruby ore in registry system
		Registry.register(Registry.BLOCK, new Identifier("minecraftmod", "ruby_ore"), RUBY_ORE);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings().group(ItemGroup.MISC)));

		// Add ruby ore generation to registry system
		RegistryKey<ConfiguredFeature<?, ?>> rubyOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
				new Identifier("minecraftmod", "ruby_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOreOverworld.getValue(), RUBY_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOreOverworld);

		// Register ruby block in registry system
		Registry.register(Registry.BLOCK, new Identifier("minecraftmod", "ruby_block"), RUBY_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings().group(ItemGroup.MISC)));

		// Register ruby sword in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_sword"), RUBY_SWORD);

		// Register ruby pickaxe in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_pickaxe"), RUBY_PICKAXE);

		// Register ruby shovel in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_shovel"), RUBY_SHOVEL);

		// Register ruby axe in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_axe"), RUBY_AXE);

		// Register ruby hoe in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_hoe"), RUBY_HOE);


		// Register sapphire blocks/items in registry system and generate ore
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire"), SAPPHIRE);
		Registry.register(Registry.BLOCK, new Identifier("minecraftmod", "sapphire_ore"), SAPPHIRE_ORE);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("minecraftmod", "sapphire_block"), SAPPHIRE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_sword"), SAPPHIRE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_pickaxe"), SAPPHIRE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_shovel"), SAPPHIRE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_axe"), SAPPHIRE_AXE);
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "sapphire_hoe"), SAPPHIRE_HOE);
		RegistryKey<ConfiguredFeature<?, ?>> sapphireOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
				new Identifier("minecraftmod", "sapphire_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sapphireOreOverworld.getValue(), SAPPHIRE_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sapphireOreOverworld);


		Registry.register(Registry.SOUND_EVENT, ExampleMod.ARMOUR_EQUIP, ARMOUR_EQUIP_EVENT);


		// Register armour
		RegisterItems.register();
	}
}
