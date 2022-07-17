package net.kris.amath.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kris.amath.AMath;
import net.kris.amath.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlock {
        private static final float slot_hardness = .7f;

        public static final Block TRIPLE_EQUATION = registerBlock("triple_equation",
                        new Block(FabricBlockSettings.of(Material.WOOD).hardness(slot_hardness)), ModItemGroup.A_MATH);
        public static final Block DOUBLE_EQUATION = registerBlock("double_equation",
                        new Block(FabricBlockSettings.of(Material.WOOD).hardness(slot_hardness)), ModItemGroup.A_MATH);
        public static final Block TRIPLE_PIECE = registerBlock("triple_piece",
                        new Block(FabricBlockSettings.of(Material.WOOD).hardness(slot_hardness)), ModItemGroup.A_MATH);
        public static final Block DOUBLE_PIECE = registerBlock("double_piece",
                        new Block(FabricBlockSettings.of(Material.WOOD).hardness(slot_hardness)), ModItemGroup.A_MATH);
        public static final Block BLANK_SLOT = registerBlock("blank_slot",
                        new Block(FabricBlockSettings.of(Material.WOOD).hardness(slot_hardness)), ModItemGroup.A_MATH);
        public static final Block TRIPLE_PIECE_CENTER = registerBlock("triple_piece_center",
                        new Block(FabricBlockSettings.of(Material.WOOD).hardness(slot_hardness)), ModItemGroup.A_MATH);

        public static final Block[] NUMBER_TILES = new Block[21];

        public static final Block ADD_TILE = registerBlock("add_tile",
                        new OperatorTilesBlock("+", (a, b) -> a + b, 1), ModItemGroup.A_MATH);
        public static final Block SUBTRACT_TILE = registerBlock("subtract_tile",
                        new OperatorTilesBlock("-", (a, b) -> a - b, 1), ModItemGroup.A_MATH);
        public static final Block MULTIPLY_TILE = registerBlock("multiply_tile",
                        new OperatorTilesBlock("\u00D7", (a, b) -> a * b, 2), ModItemGroup.A_MATH);
        public static final Block DIVIDE_TILE = registerBlock("divide_tile",
                        new OperatorTilesBlock("\u00F7", (a, b) -> a / b, 2), ModItemGroup.A_MATH);

        public static final Block ADD_SUBTRACT_TILE = registerBlock("add_subtract_tile",
                        MultiFunctionTileBlock.construct("+/-",
                                        new Tile[] { Tile.UNDEFINED, Tile.OP_ADD, Tile.OP_SUBTRACT }),
                        ModItemGroup.A_MATH);
        public static final Block MULTIPLY_DIVIDE_TILE = registerBlock("multiply_divide_tile",
                        MultiFunctionTileBlock.construct("\u00D7/\u00F7",
                                        new Tile[] { Tile.UNDEFINED, Tile.OP_MULTIPLY, Tile.OP_DIVIDE }),
                        ModItemGroup.A_MATH);

        public static final Block BLANK_TILE = registerBlock("blank_tile",
                        new AnyTilesBlock(), ModItemGroup.A_MATH);
        public static final Block EQUAL_TILE = registerBlock("equal_tile",
                        new EqualTilesBlock(), ModItemGroup.A_MATH);

        public static final int[] NUMBER_TILES_POINTS = {
                        1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 3, 6, 4, 4, 4, 6, 4, 7, 5
        };

        static {
                for (int i = 0; i < 21; i++) {
                        NUMBER_TILES[i] = registerBlock("number_" + i + "_tile",
                                        new NumberTilesBlock(i, NUMBER_TILES_POINTS[i]),
                                        ModItemGroup.A_MATH);
                }
        }

        private static Block registerBlock(String name, Block block, ItemGroup group) {
                registerBlockItem(name, block, group);
                return Registry.register(Registry.BLOCK, new Identifier(AMath.MODID, name), block);
        }

        private static Item registerBlockItem(String name, Block block, ItemGroup group) {
                return Registry.register(Registry.ITEM, new Identifier(AMath.MODID, name),
                                new BlockItem(block, new FabricItemSettings().group(group)));
        }

        public static void registerModBlocks() {
        }
}
