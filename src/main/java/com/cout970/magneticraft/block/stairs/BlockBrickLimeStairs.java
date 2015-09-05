package com.cout970.magneticraft.block.stairs;

import com.cout970.magneticraft.ManagerBlocks;

public class BlockBrickLimeStairs extends BlockMgStairs {
    public BlockBrickLimeStairs() {
        super(ManagerBlocks.brickLime, ManagerBlocks.brickLime.getUnlocalizedName() + "Stairs");
        setHardness(1.5F);
        setStepSound(soundTypeStone);
        setBlockTextureName("magneticraft:brick_limestone");
    }
}
