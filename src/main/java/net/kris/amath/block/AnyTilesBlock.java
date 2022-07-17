package net.kris.amath.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.EnumProperty;

public class AnyTilesBlock extends TilesBlock {
    protected static final EnumProperty<Tile> VALUE = EnumProperty.of("value", Tile.class);

    public AnyTilesBlock() {
        super("", 0);
        setDefaultState(getDefaultState().with(VALUE, Tile.UNDEFINED));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(VALUE);
    }

    @Override
    public String getValue(BlockState state) {
        return state.get(VALUE).block.getValue(state);
    }
}
