package com.harbinger.amalgament.aBlocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AmalgaSpread extends Block implements SimpleWaterloggedBlock {
    public AmalgaSpread() {
        super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0,0));
    }


    public VoxelShape getShape(BlockState p_57291_, BlockGetter p_57292_, BlockPos p_57293_, CollisionContext p_57294_) {
        return Block.box(0.1D, 0.0D, 0.1D, 15.9D, 2.0D, 15.9D);
    }
    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return place.execute(world, x, y, z);
        }
        return super.canSurvive(blockstate, worldIn, pos);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
                                  BlockPos facingPos) {
        return !state.canSurvive(world, currentPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
    public static class place {
        public static boolean execute(LevelAccessor world, double x, double y, double z) {
            return world.getBlockState(new BlockPos(x, y - 1, z)).canOcclude();
        }
    }



}

