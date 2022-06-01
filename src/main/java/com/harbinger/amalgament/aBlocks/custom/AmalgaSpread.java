package com.harbinger.amalgament.aBlocks.custom;

import com.harbinger.amalgament.aBlocks.aBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class AmalgaSpread extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public AmalgaSpread() {
        super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0,0));
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));

    }


    public VoxelShape getShape(BlockState p_57291_, BlockGetter p_57292_, BlockPos p_57293_, CollisionContext p_57294_) {
        return Block.box(0.1D, 0.0D, 0.1D, 15.9D, 1.0D, 15.9D);
    }
    public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        boolean additionalCondition = true;
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.getX();
            int y = pos.getY() + 1;
            int z = pos.getZ();
            BlockState blockstate = world.getBlockState(pos.above());
            additionalCondition = Place.execute(world, x, y, z);
        }
        return

                additionalCondition;
    }

    public static class Place {
        public static boolean execute(LevelAccessor world, double x, double y, double z) {
            return world.getBlockState(new BlockPos(x, y - 1, z)).getDestroySpeed(world, new BlockPos(x, y, z)) <= 1.8
                    && world.getBlockState(new BlockPos(x, y - 1, z)).canOcclude()
                    && !(((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.MAGMA_BLOCK)
            || ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == aBlocks.AMALGAM_SPREAD.get()));
        }
    }


    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        return this.mayPlaceOn(groundState, worldIn, blockpos);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, flag);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
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
            if ((world.getBlockState(new BlockPos(x + 1, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x + 1, y, z), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            } else if ((world.getBlockState(new BlockPos(x - 1, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x - 1, y, z), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            } else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x, y, z - 1), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            } else if ((world.getBlockState(new BlockPos(x, y, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x, y, z + 1), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }

            else if ((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x, y + 1, z + 1), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }else if ((world.getBlockState(new BlockPos(x, y + 1, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x, y + 1, z - 1), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }else if ((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x + 1, y + 1, z ), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }else if ((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x - 1, y + 1, z), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }

            else if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x, y - 1, z + 1), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }else if ((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x, y - 1, z - 1), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }else if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x + 1, y - 1, z ), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }else if ((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
                if (Math.random() < 0.1) {
                    world.setBlock(new BlockPos(x - 1, y - 1, z), aBlocks.AMALGAM_SPREAD.get().defaultBlockState(), 3);
                }
            }
        }
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 100);
    }
}

