package net.kris.amath.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kris.amath.AMath;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItem {
        public static final Item GAME_BOARD = registerItem("game_board",
                        new BoardBuilderItem(new FabricItemSettings().group(ModItemGroup.A_MATH)));
        public static final Item GAME_BOARD_REMOVER = registerItem("game_board_remover",
                        new BoardRemoverItem(new FabricItemSettings().group(ModItemGroup.A_MATH)));
        public static final Item TILE_BUNDLE = registerItem("tile_bundle",
                        new TilesBundleItem(new FabricItemSettings().group(ModItemGroup.A_MATH)));

        private static Item registerItem(String name, Item item) {
                return Registry.register(Registry.ITEM, new Identifier(AMath.MODID, name), item);
        }

        public static void registerModItems() {
        }
}
