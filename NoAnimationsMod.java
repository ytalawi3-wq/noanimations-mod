package com.bedro.noanim;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Developed by: Bedro
 */
public class NoAnimationsMod implements ClientModInitializer {
    public static final String MOD_ID = "no_animations_bedro";
    public static final Logger LOGGER = LoggerFactory.getLogger("NoAnimations-Bedro");

    @Override
    public void onInitializeClient() {
        LOGGER.info("========================================");
        LOGGER.info(" No Animations Mod Loaded Successfully!");
        LOGGER.info(" Created with love BY BEDRO");
        LOGGER.info("========================================");
    }
}
