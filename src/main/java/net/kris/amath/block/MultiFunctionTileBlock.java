package net.kris.amath.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.EnumProperty;

public class MultiFunctionTileBlock extends TilesBlock {
    private static EnumProperty<Tile> VALUE0;
    private final EnumProperty<Tile> VALUE;

    private MultiFunctionTileBlock(String value, EnumProperty<Tile> VALUE) {
        super(value, 1);
        this.VALUE = VALUE;
        setDefaultState(getDefaultState().with(VALUE, Tile.UNDEFINED));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(VALUE0);
    }

    @Override
    public String getValue(BlockState state) {
        return state.get(VALUE).block.getValue(state);
    }

    public static synchronized MultiFunctionTileBlock construct(String value, Tile[] list) {
        VALUE0 = EnumProperty.of("value", Tile.class, list);
        return new MultiFunctionTileBlock(value, VALUE0);
    }
}
