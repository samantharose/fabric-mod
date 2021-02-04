package de.netflam.gemstones.tools;

import de.netflam.gemstones.GemstonesMod;
import de.netflam.gemstones.tools.templates.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterTools {
    public static final ToolItem RUBY_SWORD = new SwordItem(RubyWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final ToolItem RUBY_PICKAXE = new CustomPickaxeItem(RubyWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyWeapon.INSTANCE, 2, 3, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final ToolItem RUBY_AXE = new CustomAxeItem(RubyWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(GemstonesMod.GemstonesMod));
    public static final ToolItem RUBY_HOE = new CustomHoeItem(RubyWeapon.INSTANCE, 1, 2, new Item.Settings().group(GemstonesMod.GemstonesMod));

    public static final ToolItem SAPPHIRE_SWORD = new SwordItem(SapphireWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem SAPPHIRE_PICKAXE = new CustomPickaxeItem(SapphireWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem SAPPHIRE_SHOVEL = new ShovelItem(SapphireWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem SAPPHIRE_AXE = new CustomAxeItem(SapphireWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem SAPPHIRE_HOE = new CustomHoeItem(SapphireWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));

    public static final ToolItem ROSE_QUARTZ_SWORD = new SwordItem(RoseQuartzWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem ROSE_QUARTZ_PICKAXE = new CustomPickaxeItem(RoseQuartzWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem ROSE_QUARTZ_SHOVEL = new ShovelItem(RoseQuartzWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem ROSE_QUARTZ_AXE = new CustomAxeItem(RoseQuartzWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem ROSE_QUARTZ_HOE = new CustomHoeItem(RoseQuartzWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));

    public static final ToolItem AMETHYST_SWORD = new SwordItem(AmethystWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem AMETHYST_PICKAXE = new CustomPickaxeItem(AmethystWeapon.INSTANCE, 2, 2.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_SHOVEL = new ShovelItem(AmethystWeapon.INSTANCE, 2, 3, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_AXE = new CustomAxeItem(AmethystWeapon.INSTANCE, 3, 4.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_HOE = new CustomHoeItem(AmethystWeapon.INSTANCE, 1, 2, new Item.Settings().group(ItemGroup.TOOLS));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_sword"), RUBY_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_axe"), RUBY_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "ruby_hoe"), RUBY_HOE);

        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_sword"), SAPPHIRE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_pickaxe"), SAPPHIRE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_shovel"), SAPPHIRE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_axe"), SAPPHIRE_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "sapphire_hoe"), SAPPHIRE_HOE);

        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_sword"), ROSE_QUARTZ_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_pickaxe"), ROSE_QUARTZ_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_shovel"), ROSE_QUARTZ_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_axe"), ROSE_QUARTZ_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "rose_quartz_hoe"), ROSE_QUARTZ_HOE);

        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_sword"), AMETHYST_SWORD);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_pickaxe"), AMETHYST_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_shovel"), AMETHYST_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_axe"), AMETHYST_AXE);
        Registry.register(Registry.ITEM, new Identifier("gemstones", "amethyst_hoe"), AMETHYST_HOE);
    }
}
