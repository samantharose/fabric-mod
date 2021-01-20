package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
import org.lwjgl.system.CallbackI;

import javax.tools.Tool;

public class ExampleMod implements ModInitializer {

	// Ruby item
	public static final Item RUBY = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));

	// Ruby ore
	public static final Block RUBY_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0F));

	// Ruby block
	public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(10.0F));

	// Ruby sword
	// TODO: ruby sword

	// Ruby pickaxe
	public ToolItem RUBY_PICKAXE = new CustomPickaxeItem(RubyWeapon.INSTANCE,2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));

	// Ruby shovel
	public ToolItem RUBY_SHOVEL = new CustomShovelItem(RubyWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));


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

	// `PickaxeItem` , `HoeItem` and `AxeItem` have protected constructors, which means you will need to create your own sub-class with a public constructor
	public class CustomPickaxeItem extends PickaxeItem {
		public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}

	public class CustomShovelItem extends PickaxeItem {
		public CustomShovelItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}


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

		// Register ruby pickaxe in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_pickaxe"), RUBY_PICKAXE);

		// Register ruby shovel in registry system
		Registry.register(Registry.ITEM, new Identifier("minecraftmod", "ruby_shovel"), RUBY_SHOVEL);
	}
}
