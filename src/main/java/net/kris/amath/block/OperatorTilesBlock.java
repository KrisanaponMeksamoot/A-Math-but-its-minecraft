package net.kris.amath.block;

import java.util.function.DoubleBinaryOperator;

public class OperatorTilesBlock extends TilesBlock {
    public final DoubleBinaryOperator operation;
    public final int priority;

    public OperatorTilesBlock(String value, DoubleBinaryOperator operation, int priority) {
        super(value, 2);
        this.operation = operation;
        this.priority = priority;
    }
}
