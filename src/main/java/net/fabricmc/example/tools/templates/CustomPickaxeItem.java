package net.fabricmc.example.tools.templates;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

// `PickaxeItem` , `HoeItem` and `AxeItem` have protected constructors, which means you will need to create your own sub-class with a public constructor
public class CustomPickaxeItem extends PickaxeItem {
    public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
