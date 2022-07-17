package net.kris.amath;

import java.util.HexFormat;

import net.kris.amath.block.ModBlock;
import net.minecraft.block.Block;

public class AMathBoard {
    public static final byte[][] defaultBoardByte = {
            HexFormat.of().parseHex("230000120000002300000012000023"),
            HexFormat.of().parseHex("002200000013000000130000002200"),
            HexFormat.of().parseHex("000022000000120012000000220000"),
            HexFormat.of().parseHex("120000220000001200000022000012"),
            HexFormat.of().parseHex("000000001300000000001300000000"),
            HexFormat.of().parseHex("001300000013000000130000001300"),
            HexFormat.of().parseHex("000012000000120012000000120000"),
            HexFormat.of().parseHex("230000120000004300000012000023"),
            HexFormat.of().parseHex("000012000000120012000000120000"),
            HexFormat.of().parseHex("001300000013000000130000001300"),
            HexFormat.of().parseHex("000000001300000000001300000000"),
            HexFormat.of().parseHex("120000220000001200000022000012"),
            HexFormat.of().parseHex("000022000000120012000000220000"),
            HexFormat.of().parseHex("002200000013000000130000002200"),
            HexFormat.of().parseHex("230000120000002300000012000023")
    };

    public static AMathSlotType format(byte arg0) {
        switch (arg0) {
            case 0x23:
                return AMathSlotType.TRIPLE_EQUATION;
            case 0x13:
                return AMathSlotType.TRIPLE_PIECE;
            case 0x43:
                return AMathSlotType.TRIPLE_PIECE_CENTER;
            case 0x22:
                return AMathSlotType.DOUBLE_EQUATION;
            case 0x12:
                return AMathSlotType.DOUBLE_PIECE;
            case 0x00:
                return AMathSlotType.BLANK_SLOT;
            default:
                return null;
        }
    }

    public static final AMathSlotType[][] defaultBoard = new AMathSlotType[15][15];

    public static final int[] TILE_COUNT_LIST = { 5, 6, 6, 5, 5, 4, 4, 4, 4, 4, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4,
            5, 4, 4, 4, 11, 4 };

    static {
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                defaultBoard[y][x] = format(defaultBoardByte[y][x]);
            }
        }
    }

    public static void init() {
    }

    public enum AMathSlotType {
        TRIPLE_EQUATION(ModBlock.TRIPLE_EQUATION),
        TRIPLE_PIECE(ModBlock.TRIPLE_PIECE),
        TRIPLE_PIECE_CENTER(ModBlock.TRIPLE_PIECE_CENTER),
        DOUBLE_EQUATION(ModBlock.DOUBLE_EQUATION),
        DOUBLE_PIECE(ModBlock.DOUBLE_PIECE),
        BLANK_SLOT(ModBlock.BLANK_SLOT);

        public final Block block;

        private AMathSlotType(Block block) {
            this.block = block;
        }
    }
}
