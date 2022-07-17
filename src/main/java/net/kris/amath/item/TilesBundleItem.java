package net.kris.amath.item;

import net.kris.amath.AMathBoard;
import net.kris.amath.block.ModBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TilesBundleItem extends Item {

    public TilesBundleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        PlayerInventory inv = user.getInventory();
        for (int i = 0; i < 21; i++)
            inv.offerOrDrop(new ItemStack(ModBlock.NUMBER_TILES[i], AMathBoard.TILE_COUNT_LIST[i]));
        inv.offerOrDrop(new ItemStack(ModBlock.ADD_TILE, AMathBoard.TILE_COUNT_LIST[21]));
        inv.offerOrDrop(new ItemStack(ModBlock.SUBTRACT_TILE, AMathBoard.TILE_COUNT_LIST[22]));
        inv.offerOrDrop(new ItemStack(ModBlock.ADD_SUBTRACT_TILE, AMathBoard.TILE_COUNT_LIST[23]));
        inv.offerOrDrop(new ItemStack(ModBlock.MULTIPLY_TILE, AMathBoard.TILE_COUNT_LIST[24]));
        inv.offerOrDrop(new ItemStack(ModBlock.DIVIDE_TILE, AMathBoard.TILE_COUNT_LIST[25]));
        inv.offerOrDrop(new ItemStack(ModBlock.MULTIPLY_DIVIDE_TILE, AMathBoard.TILE_COUNT_LIST[26]));
        inv.offerOrDrop(new ItemStack(ModBlock.EQUAL_TILE, AMathBoard.TILE_COUNT_LIST[27]));
        inv.offerOrDrop(new ItemStack(ModBlock.BLANK_TILE, AMathBoard.TILE_COUNT_LIST[28]));
        itemStack.decrement(1);
        return TypedActionResult.success(itemStack);
    }

}
