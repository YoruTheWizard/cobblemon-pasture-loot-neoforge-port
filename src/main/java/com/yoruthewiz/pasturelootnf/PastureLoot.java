package com.yoruthewiz.pasturelootnf;

import org.slf4j.Logger;

import net.neoforged.fml.common.Mod;
import org.slf4j.LoggerFactory;

@Mod(PastureLoot.MOD_ID)
public class PastureLoot {
    public static final String MOD_ID = "pasturelootnf";
    public static final Logger LOGGER = LoggerFactory.getLogger(PastureLoot.class);
    public static PastureLoot INSTANCE;
    private final Config config;

    public PastureLoot() {
        INSTANCE = this;
        config = Config.load();
    }

    public Config getConfig() {
        return config;
    }
}
