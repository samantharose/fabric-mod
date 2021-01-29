package de.netflam.gemstones.items;

import de.netflam.gemstones.GemstonesMod;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class AmethystArmourMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {3, 6, 8, 3};

    @Override
    public int getDurability(EquipmentSlot slot) { return BASE_DURABILITY[slot.getEntitySlotId()] * 10; }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) { return PROTECTION_VALUES[slot.getEntitySlotId()]; }

    @Override
    public int getEnchantability() { return 10; }

    @Override
    public SoundEvent getEquipSound() { return GemstonesMod.ARMOUR_EQUIP_EVENT; }

    @Override
    public Ingredient getRepairIngredient() { return Ingredient.ofItems(GemstonesMod.AMETHYST); }

    @Override
    public String getName() { return "rose_quartz"; }

    @Override
    public float getToughness() { return 10.0F; }

    @Override
    public float getKnockbackResistance() { return 0.10F; }
}
