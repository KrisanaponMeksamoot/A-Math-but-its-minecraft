package net.kris.amath.item;

import net.kris.amath.AMathBoard;
import net.kris.amath.block.ModBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BoardBuilderItem extends Item {

    public BoardBuilderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        if (world.getBlockState(pos).getBlock() == ModBlock.TRIPLE_PIECE_CENTER) {
            for (int x = -7; x < 8; x++) {
                for (int z = -7; z < 8; z++) {
                    BlockPos cpos = pos.add(x, 0, z);
                    if (x == 0 && z == 0)
                        continue;
                    if (world.getBlockState(cpos).getBlock() != Blocks.AIR) {
                        player.sendMessage(new LiteralText("Block at: X: " + cpos.getX() + " Z: " + cpos.getZ()),
                                true);
                        return ActionResult.FAIL;
                    }
                }
            }
            BlockPos bpos = pos.add(-7, 0, -7);
            for (int x = 0; x < 15; x++) {
                for (int z = 0; z < 15; z++) {
                    BlockPos cpos = bpos.add(x, 0, z);
                    world.setBlockState(cpos, AMathBoard.defaultBoard[z][x].block.getDefaultState());
                }
            }
            PlayerInventory inventory = player.getInventory();
            if (context.getPlayer().isCreative()) {
                if (inventory.count(ModItem.GAME_BOARD_REMOVER) == 0)
                    inventory.insertStack(new ItemStack(ModItem.GAME_BOARD_REMOVER));
            } else {
                context.getStack().decrement(1);
                inventory.offerOrDrop(new ItemStack(ModItem.GAME_BOARD_REMOVER));
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

}
