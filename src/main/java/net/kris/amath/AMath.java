package net.kris.amath;

import net.fabricmc.api.ModInitializer;
import net.kris.amath.block.ModBlock;
import net.kris.amath.item.ModItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AMath implements ModInitializer {
	public static final String MODID = "amath";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		AMathBoard.init();
		ModItem.registerModItems();
		ModBlock.registerModBlocks();
		LOGGER.info("AMath initialized");
	}
}
