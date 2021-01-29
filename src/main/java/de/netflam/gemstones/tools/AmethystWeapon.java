package de.netflam.gemstones.tools;

import de.netflam.gemstones.GemstonesMod;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AmethystWeapon implements ToolMaterial {

    public static final AmethystWeapon INSTANCE = new AmethystWeapon();

    @Override
    public int getDurability() { return 500; }

    @Override
    public float getMiningSpeedMultiplier() { return 5.0F; }

    @Override
    public float getAttackDamage() { return 3.0F; }

    @Override
    public int getMiningLevel() { return 2; }

    @Override
    public int getEnchantability() { return 15; }

    public Ingredient getRepairIngredient() { return Ingredient.ofItems(GemstonesMod.AMETHYST); }
}
