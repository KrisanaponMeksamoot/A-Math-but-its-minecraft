package net.kris.amath.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class TilesBlock extends Block implements Waterloggable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 6, 14);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public final int point;
    public final String value;

    public TilesBlock(String value, int point) {
        super(FabricBlockSettings.of(Material.WOOD).hardness(.1f));
        this.point = point;
        this.value = value;
        setDefaultState(getDefaultState().with(Properties.WATERLOGGED, false));
    }

    public int getPoint(World world, BlockPos pos) {
        Block block = world.getBlockState(pos.down()).getBlock();
        if (block == ModBlock.DOUBLE_PIECE) {
            return point * 2;
        } else if (block == ModBlock.TRIPLE_PIECE || block == ModBlock.TRIPLE_PIECE_CENTER) {
            return point * 3;
        } else {
            return point;
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public String getValue(BlockState state) {
        return value;
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return state.get(WATERLOGGED) == false;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return Fluids.EMPTY.getDefaultState();
    }
}
