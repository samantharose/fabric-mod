package net.fabricmc.example;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyWeapon implements ToolMaterial {

    public static final RubyWeapon INSTANCE = new RubyWeapon();

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ExampleMod.RUBY);
    }
}
