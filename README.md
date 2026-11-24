# DISCONTINUED!!
This mod is now discontinued and will not receive any more updates due to the original mod having now a NeoForge version.
Please download the [original mod](https://modrinth.com/mod/cobblemon-pasture-loot) instead!

# Cobblemon Pasture Loot NeoForged

> Want to abandon the hunter-gatherer lifestyle and have your pastured pokémon do the work for you? This mod is for you!

Cobblemon mod to make pastured pokémon randomly drop items from their loot table. The items are dropped at the pokémon's location.

Currently available for Cobblemon 1.7.1+ on NeoForge for Minecraft 1.21.1

## NOTE!
This mod is a NeoForge port of the [**Cobblemon Pasture Loot**](https://github.com/dremixam/CobblemonPastureLoot) mod from DrEmixam.
For the Fabric version, please refer to the original mod!

## Settings
Edit the `config/PastureLoot.json` file to change the settings.

- `tick_per_minute`: The number of ticks per minute. Should stay at 1200.
- `drop_chance_per_minute`: The chance for each pokémon dropping an item each minute.
- `item_blacklist`: A list of items that should not be dropped by the pokémons.
- `flatten_item_quantity`: False (default) for using Cobblemon loot table logic, true to have all items on the loot table have their quantities flattened to one (legacy behavior).

```json
{
    "tick_per_minute": 1200,
    "drop_chance_per_minute": 0.05,
    "item_blacklist": [
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
    ],
    "flatten_item_quantity": false
}
```
