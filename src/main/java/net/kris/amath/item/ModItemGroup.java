package net.kris.amath.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kris.amath.AMath;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup A_MATH = FabricItemGroupBuilder.build(new Identifier(AMath.MODID, "a_math"),
            () -> new ItemStack(ModItem.GAME_BOARD));
}
