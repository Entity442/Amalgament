package com.harbinger.amalgament.aBlocks.custom;

import com.harbinger.amalgament.aBlocks.aBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class Amalgam extends Block {
    public Amalgam() {
        super(BlockBehaviour.Properties.of(Material.DIRT).strength(2f, 2f).sound(SoundType.SLIME_BLOCK).randomTicks());
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 10);
    }


    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        GoreSpread.execute(world, x, y, z);
        world.scheduleTick(pos, this, 10);
    }

    public static class GoreSpread {
        public static void execute(LevelAccessor world, double x, double y, double z) {

            if
                    (((world.getBlockState(new BlockPos(x, 2 + y, z))).getBlock() == Blocks.AIR) ||
                            ((world.getBlockState(new BlockPos(x, y - 2, z))).getMaterial() == Material.AIR) ||
                            ((world.getBlockState(new BlockPos(x - 2, y, z))).getMaterial() == Material.AIR) ||
                            ((world.getBlockState(new BlockPos(2 + x, y, z))).getMaterial() == Material.AIR) ||
                            ((world.getBlockState(new BlockPos(x, y, 2 + z))).getMaterial() == Material.AIR) ||
                            ((world.getBlockState(new BlockPos(x, y, z - 2))).getMaterial() == Material.AIR)) {
                double posX = 0;
                double posY = 0;
                double posZ = 0;
                if (Math.random() < 0.01) {
                    posX = x - 1;
                    posY = y - 2;
                    posZ = z - 1;
                    for (int index0 = 0; index0 < (int) (3); index0++) {
                        for (int index1 = 0; index1 < (int) (3); index1++) {
                            for (int index2 = 0; index2 < (int) (3); index2++) {
                                posX = posX + 1;
                                    if (world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ))
                                            .canOcclude() && world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ))
                                            .getDestroySpeed(world, new BlockPos((int) posX, (int) posY, (int) posZ)) <= 1.5 &&
                                            (!((world.getBlockState(new BlockPos(posX, posY, posZ))).getBlock() == Blocks.BEDROCK)) &&
                                            (((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == Material.GRASS) ||
                                                    ((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == Material.DIRT) ||
                                                    ((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == Material.STONE) ||
                                                    ((world.getBlockState(new BlockPos(posX, posY, posZ))).getMaterial() == Material.SAND)))
                                        if (Math.random() < 0.25) {
                                            world.setBlock(new BlockPos((int) posX, (int) posY, (int) posZ), aBlocks.AMALGAM.get().defaultBlockState(), 3);
                                        }}

                                posX = x - 1;
                                posZ = posZ + 1;
                            }
                            posX = x - 1;
                            posZ = z - 1;
                            posY = posY + 1;
                        }
                    }


                }
            }
        }
    }



