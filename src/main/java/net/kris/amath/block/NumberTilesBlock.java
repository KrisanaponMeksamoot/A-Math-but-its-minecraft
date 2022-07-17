package net.kris.amath.block;

public class NumberTilesBlock extends TilesBlock {

    public final int intValue;

    public NumberTilesBlock(int value, int point) {
        super(Integer.toString(value), point);
        this.intValue = value;
    }
}
