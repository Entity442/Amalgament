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

            if ((Math.random() < 0.2) && (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.AIR) {

             if (world.getBlockState(new BlockPos((int) (1 + x), (int) y, (int) z))
                    .canOcclude() && world.getBlockState(new BlockPos((int) (1 + x), (int) y, (int) z))
                    .getDestroySpeed(world, new BlockPos((int) (1 + x), (int) y, (int) z)) <= 1.5) {
                    world.setBlock(new BlockPos((int) (1 + x), (int) y, (int) z), aBlocks.AMALGAM.get().defaultBlockState(), 3);
            }
            if (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))
                    .canOcclude() && world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))
                    .getDestroySpeed(world, new BlockPos((int) (x - 1), (int) y, (int) z)) <= 1.5) {
                    world.setBlock(new BlockPos((int) (x - 1), (int) y, (int) z), aBlocks.AMALGAM.get().defaultBlockState(), 3);
            }
            if (world.getBlockState(new BlockPos((int) x, (int) (1 + y), (int) z))
                    .canOcclude() && world.getBlockState(new BlockPos((int) x, (int) (1 + y), (int) z))
                    .getDestroySpeed(world, new BlockPos((int) x, (int) (1 + y), (int) z)) <= 1.5) {
                    world.setBlock(new BlockPos((int) x, (int) (1 + y), (int) z), aBlocks.AMALGAM.get().defaultBlockState(), 3);
            }
            if (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))
                    .canOcclude() && world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))
                    .getDestroySpeed(world, new BlockPos((int) x, (int) (y - 1), (int) z)) <= 1.5) {
                    world.setBlock(new BlockPos((int) x, (int) (y - 1), (int) z), aBlocks.AMALGAM.get().defaultBlockState(), 3);
            }
            if (world.getBlockState(new BlockPos((int) x, (int) y, (int) (1 + z)))
                    .canOcclude() && world.getBlockState(new BlockPos((int) x, (int) y, (int) (1 + z)))
                    .getDestroySpeed(world, new BlockPos((int) x, (int) y, (int) (1 + z))) <= 1.5)
                    world.setBlock(new BlockPos((int) x, (int) y, (int) (1 + z)), aBlocks.AMALGAM.get().defaultBlockState(), 3);
            }
            if (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))
                    .canOcclude() && world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))
                    .getDestroySpeed(world, new BlockPos((int) x, (int) y, (int) (z - 1))) <= 1.5) {
                    world.setBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), aBlocks.AMALGAM.get().defaultBlockState(), 3);
                }
            if ((Math.random() < 0.2)) {
                (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock();
                {
                    world.setBlock(new BlockPos((int) x, (int) (1 + y), (int) z), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }

            }
        }
    }
    }


