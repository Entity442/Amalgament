package com.harbinger.amalgament.aBlocks.custom;

import com.harbinger.amalgament.aBlocks.aBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class AmalgaCore extends Block {
    public AmalgaCore() {
        super(BlockBehaviour.Properties.of(Material.DIRT).strength(5f,5f).randomTicks());
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

        Update.execute(world, x, y, z);
        world.scheduleTick(pos, this, 100);
    }

    public static class Update {
        public static void execute(LevelAccessor world, double x, double y, double z) {
             if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x, y + 1, z), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }
        }
    }



}
