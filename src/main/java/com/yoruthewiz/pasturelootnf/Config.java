package com.yoruthewiz.pasturelootnf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE = "config/PastureLoot.json";

    private int tickPerMinute;
    private float dropChance;
    private String[] itemBlacklist;
    private boolean FlattenItemQuantity;

    private double dropChancePerTick;

    private Config() {
        this.tickPerMinute = Defaults.TICK_PER_MINUTE;
        this.dropChance = Defaults.DROP_CHANCE;
        this.itemBlacklist = Defaults.ITEM_BLACKLIST;
        this.FlattenItemQuantity = Defaults.FLATTEN_ITEM_QUANTITY;
        this.updateDropChancePerTick();
    }

    public static class Defaults {
        public static final int TICK_PER_MINUTE = 1200;
        public static final float DROP_CHANCE = 0.05f;
        public static final String[] ITEM_BLACKLIST = new String[]{
                "minecraft:porkchop",
                "minecraft:beef",
                "minecraft:chicken",
                "minecraft:mutton",
                "minecraft:rabbit",
                "minecraft:fish",
                "minecraft:cooked_porkchop",
                "minecraft:cooked_beef",
                "minecraft:cooked_chicken",
                "minecraft:cooked_mutton",
                "minecraft:cooked_rabbit",
                "minecraft:cooked_fish",
                "minecraft:leather",
                "minecraft:bone",
                "minecraft:spider_eye",
                "minecraft:rotten_flesh",
                "minecraft:rabbit_hide",
                "minecraft:rabbit_foot",
                "minecraft:cod",
                "minecraft:pufferfish",
                "minecraft:bone_block",
                "minecraft:bone_meal",
                "cobblemon:sharp_beak",
                "minecraft:honey_bottle",
                "minecraft:salmon",
                "minecraft:white_wool"
        };
        public static final boolean FLATTEN_ITEM_QUANTITY = false;
    }

    public int getTickPerMinute() {
        return tickPerMinute;
    }

    public float getDropChance() {
        return dropChance;
    }

    private void updateDropChancePerTick() {
        dropChancePerTick = 1 - Math.pow(1 - dropChance, 1.0 / tickPerMinute);
    }

    public double getDropChancePerTick() {
        return dropChancePerTick;
    }

    public String[] getItemBlacklist() {
        return itemBlacklist;
    }

    public boolean legacyFlattenItemQuantity() {
        return FlattenItemQuantity;
    }

    public static Config load() {
        Config config = new Config(); // Set defaults
        boolean needsSave = false;

        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            config.tickPerMinute = json.get("tick_per_minute").getAsInt();
            config.dropChance = json.get("drop_chance_per_minute").getAsFloat();
            config.itemBlacklist = GSON.fromJson(json.get("item_blacklist"), String[].class);
            if (json.has("flatten_item_quantity")) {
                config.FlattenItemQuantity = json.get("flatten_item_quantity").getAsBoolean();
            } else {
                needsSave = true;
            }
            config.updateDropChancePerTick();
        } catch (IOException e) {
            config = new Config();
            config.save();
        }

        if (needsSave) {
            config.save();
        }

        return config;
    }

    private void save() {
        JsonObject json = new JsonObject();
        json.addProperty("tick_per_minute", tickPerMinute);
        json.addProperty("drop_chance_per_minute", dropChance);
        json.add("item_blacklist", GSON.toJsonTree(itemBlacklist));
        json.addProperty("flatten_item_quantity", FlattenItemQuantity);
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(json, writer);
        } catch (IOException e) {}
    }

}
