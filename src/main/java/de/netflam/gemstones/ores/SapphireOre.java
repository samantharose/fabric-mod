package de.netflam.gemstones.ores;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class SapphireOre extends Block {

    public SapphireOre() {
        super(FabricBlockSettings.of(Material.STONE)
                .requiresTool()
                .breakByHand(false)
                .breakByTool(FabricToolTags.PICKAXES, 2)
                .hardness(5f)
                .resistance(1.5f)
        );
    }
}
