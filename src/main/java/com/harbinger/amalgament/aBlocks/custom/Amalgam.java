package com.harbinger.amalgament.aBlocks.custom;

import com.harbinger.amalgament.aBlocks.aBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class Amalgam extends Block {
    public Amalgam() {
        super(BlockBehaviour.Properties.of(Material.DIRT).strength(2f,2f));
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 100);
    }


    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
        super.tick(blockstate, world, pos, random);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        GoreSpread.execute(world, x, y, z);
        world.scheduleTick(pos, this, 100);
    }
    public static class GoreSpread {
        public static void execute(LevelAccessor world, double x, double y, double z) {
            double posX = 0;
            double posY = 0;
            double posZ = 0;
            boolean block = false;
            if ((Math.random() < 0.2) &&
                    ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR) ||
                    ((world.getBlockState(new BlockPos(x, y - 1, z))).getMaterial() == Material.AIR)||
                    ((world.getBlockState(new BlockPos(x - 1, y, z))).getMaterial() == Material.AIR)||
                    ((world.getBlockState(new BlockPos(x + 1, y, z))).getMaterial() == Material.AIR)||
                    ((world.getBlockState(new BlockPos(x, y, z + 1))).getMaterial() == Material.AIR)||
                    ((world.getBlockState(new BlockPos(x, y, z - 1))).getMaterial() == Material.AIR)) {


                    posX = x - 1;
                    posY = y - 1;
                    posZ = z - 1;

                    for (int index0 = 0; index0 < (int) (3); index0++) {
                        for (int index1 = 0; index1 < (int) (3); index1++) {
                            for (int index2 = 0; index2 < (int) (3); index2++) {
                                posX = posX + 1;
                                    if (Math.random() < 0.5) {
                                        if (world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ))
                                                .canOcclude() && world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ))
                                                .getDestroySpeed(world, new BlockPos((int) posX, (int) posY, (int) posZ)) <= 1.5 &&
                                                (!((world.getBlockState(new BlockPos(posX, posY, posZ))).getBlock() == Blocks.BEDROCK)) &&
                                                (((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == Material.DIRT) ||
                                                ((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == Material.STONE) ||
                                                ((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == Material.SAND)))

                                        {
                                            if (Math.random() < 0.5) {
                                            block = true;
                                            world.setBlock(new BlockPos((int) posX, (int) posY, (int) posZ), aBlocks.AMALGAM.get().defaultBlockState(), 3);
                                            if (block == true) {
                                                break;
                                            }
                                    }
                                }
                            }
                            posX = x - 1;
                            posZ = posZ + 1;
                            if (block == true) {
                                break;
                            }
                        }
                        posX = x - 1;
                        posZ = z - 1;
                        posY = posY + 1;
                        if (block == true) {
                            break;
                        }
                    }
                }
            }

        }
    }
}



