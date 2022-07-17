package net.kris.amath.block;

import net.minecraft.block.Block;
import net.minecraft.util.StringIdentifiable;

public enum Tile implements StringIdentifiable {
    NUM_0("num_0", ModBlock.NUMBER_TILES[0]),
    NUM_1("num_1", ModBlock.NUMBER_TILES[1]),
    NUM_2("num_2", ModBlock.NUMBER_TILES[2]),
    NUM_3("num_3", ModBlock.NUMBER_TILES[3]),
    NUM_4("num_4", ModBlock.NUMBER_TILES[4]),
    NUM_5("num_5", ModBlock.NUMBER_TILES[5]),
    NUM_6("num_6", ModBlock.NUMBER_TILES[6]),
    NUM_7("num_7", ModBlock.NUMBER_TILES[7]),
    NUM_8("num_8", ModBlock.NUMBER_TILES[8]),
    NUM_9("num_9", ModBlock.NUMBER_TILES[9]),
    NUM_10("num_10", ModBlock.NUMBER_TILES[10]),
    NUM_11("num_11", ModBlock.NUMBER_TILES[11]),
    NUM_12("num_12", ModBlock.NUMBER_TILES[12]),
    NUM_13("num_13", ModBlock.NUMBER_TILES[13]),
    NUM_14("num_14", ModBlock.NUMBER_TILES[14]),
    NUM_15("num_15", ModBlock.NUMBER_TILES[15]),
    NUM_16("num_16", ModBlock.NUMBER_TILES[16]),
    NUM_17("num_17", ModBlock.NUMBER_TILES[17]),
    NUM_18("num_18", ModBlock.NUMBER_TILES[18]),
    NUM_19("num_19", ModBlock.NUMBER_TILES[19]),
    NUM_20("num_20", ModBlock.NUMBER_TILES[20]),
    OP_ADD("add", ModBlock.ADD_TILE),
    OP_SUBTRACT("subtract", ModBlock.SUBTRACT_TILE),
    OP_MULTIPLY("multiply", ModBlock.MULTIPLY_TILE),
    OP_DIVIDE("divide", ModBlock.DIVIDE_TILE),
    OP_EQUAL("equal", ModBlock.EQUAL_TILE),
    UNDEFINED("none", null);

    public final TilesBlock block;
    private final String name;

    private Tile(String name, Block block) {
        this.block = (TilesBlock) block;
        this.name = name;
    }

    @Override
    public String asString() {
        return name;
    }
}
