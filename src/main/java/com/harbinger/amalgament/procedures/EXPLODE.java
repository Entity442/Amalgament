package com.harbinger.amalgament.procedures;

import com.harbinger.amalgament.aBlocks.aBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EXPLODE {


    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double posX = 0;
        double posY = 0;
        double posZ = 0;
        if (Math.random() < 0.5) {
        posX = x - 1;
        posY = y - 1;
        posZ = z - 1;

            for (int index0 = 0; index0 < (int) (3); index0++) {
                for (int index1 = 0; index1 < (int) (3); index1++) {
                    for (int index2 = 0; index2 < (int) (3); index2++) {
                        posX = posX + 1;
                        if ((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == net.minecraft.world.level.material.Material.AIR
                                && world.getBlockState(new BlockPos(posX, posY - 1, posZ)).canOcclude()) {
                            if (Math.random() < 0.5) {
                            world.setBlock(new BlockPos(posX, posY, posZ), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);

                            }
                        }
                    }
                    posX = x - 3;
                    posZ = posZ + 1;
                }
                posX = x - 3;
                posZ = z - 3;
                posY = posY + 1;
            }
        }
    }
}


