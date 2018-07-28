/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.slayer;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
<<<<<<< HEAD
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
enum Task
{
	//<editor-fold desc="Enums">
	ABERRANT_SPECTRES("Aberrant spectres", ItemID.ABERRANT_SPECTRE, "Spectre"),
	ABYSSAL_DEMONS("Abyssal demons", ItemID.ABYSSAL_DEMON),
	ADAMANT_DRAGONS("Adamant dragons", ItemID.ADAMANTITE_BAR),
	ANKOU("Ankou", ItemID.ANKOU_MASK),
	AVIANSIES("Aviansies", ItemID.ENSOULED_AVIANSIE_HEAD),
	BANSHEES("Banshees", ItemID.BANSHEE),
	BASILISKS("Basilisks", ItemID.BASILISK),
	BATS("Bats", ItemID.GIRAL_BAT_2),
	BEARS("Bears", ItemID.ENSOULED_BEAR_HEAD),
	BIRDS("Birds", ItemID.FEATHER, "Chicken", "Rooster", "Terrorbird", "Seagull"),
	BLACK_DEMONS("Black demons", ItemID.BLACK_DEMON_MASK),
	BLACK_DRAGONS("Black dragons", ItemID.BLACK_DRAGON_MASK),
	BLOODVELD("Bloodveld", ItemID.BLOODVELD),
	BLUE_DRAGONS("Blue dragons", ItemID.BLUE_DRAGON_MASK),
	BRINE_RATS("Brine rats", ItemID.BRINE_RAT),
	BRONZE_DRAGONS("Bronze dragons", ItemID.BRONZE_DRAGON_MASK),
	CATABLEPON("Catablepon", ItemID.LEFT_SKULL_HALF),
	CAVE_BUGS("Cave bugs", ItemID.SWAMP_CAVE_BUG),
	CAVE_CRAWLERS("Cave crawlers", ItemID.CAVE_CRAWLER, "Chasm crawler"),
	CAVE_HORRORS("Cave horrors", ItemID.CAVE_HORROR, "Cave abomination"),
	CAVE_KRAKEN("Cave kraken", ItemID.CAVE_KRAKEN),
	CAVE_SLIMES("Cave slimes", ItemID.SWAMP_CAVE_SLIME),
	COCKATRICE("Cockatrice", ItemID.COCKATRICE, "Cockathrice"),
	COWS("Cows", ItemID.COW_MASK),
	CRAWLING_HANDS("Crawling hands", ItemID.CRAWLING_HAND, "Crushing hand"),
	CROCODILES("Crocodiles", ItemID.SWAMP_LIZARD),
	DAGANNOTH("Dagannoth", ItemID.DAGANNOTH),
	DARK_BEASTS("Dark beasts", ItemID.DARK_BEAST, "Night beast"),
	DESERT_LIZARDS("Desert lizards", ItemID.DESERT_LIZARD, "Small lizard", "Lizard"),
	DOGS("Dogs", ItemID.GUARD_DOG, "Jackal"),
	DUST_DEVILS("Dust devils", ItemID.DUST_DEVIL, "Choke devil"),
	DWARVES("Dwarves", ItemID.DWARVEN_HELMET, "Dwarf"),
	EARTH_WARRIORS("Earth warriors", ItemID.BRONZE_FULL_HELM_T),
	ELVES("Elves", ItemID.ELF, "Elf"),
	FEVER_SPIDERS("Fever spiders", ItemID.FEVER_SPIDER),
	FIRE_GIANTS("Fire giants", ItemID.FIRE_BATTLESTAFF),
	FLESH_CRAWLERS("Flesh crawlers", ItemID.ENSOULED_SCORPION_HEAD),
	FOSSIL_ISLAND_WYVERNS("Fossil island wyverns", ItemID.FOSSIL_ISLAND_WYVERN, "Ancient wyvern", "Long-tailed wyvern", "Spitting wyvern", "Taloned wyvern"),
	GARGOYLES("Gargoyles", ItemID.GARGOYLE),
	GHOSTS("Ghosts", ItemID.GHOSTSPEAK_AMULET, "Tortured soul"),
	GHOULS("Ghouls", ItemID.ZOMBIE_HEAD),
	GOBLINS("Goblins", ItemID.ENSOULED_GOBLIN_HEAD),
	GREATER_DEMONS("Greater demons", ItemID.GREATER_DEMON_MASK),
	GREEN_DRAGONS("Green dragons", ItemID.GREEN_DRAGON_MASK),
	HARPIE_BUG_SWARMS("Harpie bug swarms", ItemID.SWARM),
	HELLHOUNDS("Hellhounds", ItemID.HELLHOUND),
	HILL_GIANTS("Hill giants", ItemID.ENSOULED_GIANT_HEAD),
	HOBGOBLINS("Hobgoblins", ItemID.HOBGOBLIN_GUARD),
	ICE_GIANTS("Ice giants", ItemID.ICE_DIAMOND),
	ICE_WARRIORS("Ice warriors", ItemID.MITHRIL_FULL_HELM_T),
	ICEFIENDS("Icefiends", ItemID.ICE_DIAMOND),
	INFERNAL_MAGES("Infernal mages", ItemID.INFERNAL_MAGE, "Malevolent mage"),
	IRON_DRAGONS("Iron dragons", ItemID.IRON_DRAGON_MASK),
	JELLIES("Jellies", ItemID.JELLY, "Jelly"),
	JUNGLE_HORROR("Jungle horrors", ItemID.ENSOULED_HORROR_HEAD),
	KALPHITE("Kalphite", ItemID.KALPHITE_SOLDIER),
	KILLERWATTS("Killerwatts", ItemID.KILLERWATT),
	KURASK("Kurask", ItemID.KURASK),
	LESSER_DEMONS("Lesser demons", ItemID.LESSER_DEMON_MASK),
	LIZARDMEN("Lizardmen", ItemID.LIZARDMAN_FANG, "Lizardman"),
	MINIONS_OF_SCABARAS("Minions of scabaras", ItemID.GOLDEN_SCARAB, "Scarab swarm", "Locust rider", "Scarab mage"),
	MINOTAURS("Minotaurs", ItemID.ENSOULED_MINOTAUR_HEAD),
	MITHRIL_DRAGONS("Mithril dragons", ItemID.MITHRIL_DRAGON_MASK),
	MOGRES("Mogres", ItemID.MOGRE),
	MOLANISKS("Molanisks", ItemID.MOLANISK),
	MONKEYS("Monkeys", ItemID.ENSOULED_MONKEY_HEAD),
	MOSS_GIANTS("Moss giants", ItemID.HILL_GIANT_CLUB),
	MUTATED_ZYGOMITES("Mutated zygomites", ItemID.MUTATED_ZYGOMITE),
	NECHRYAEL("Nechryael", ItemID.NECHRYAEL, "Nechryarch"),
	OGRES("Ogres", ItemID.ENSOULED_OGRE_HEAD),
	OTHERWORLDLY_BEING("Otherworldly beings", ItemID.GHOSTLY_HOOD),
	PYREFIENDS("Pyrefiends", ItemID.PYREFIEND, "Flaming pyrelord"),
	RATS("Rats", ItemID.RATS_TAIL),
	RED_DRAGONS("Red dragons", ItemID.BABY_RED_DRAGON),
	ROCKSLUGS("Rockslugs", ItemID.ROCKSLUG),
	RUNE_DRAGONS("Rune dragons", ItemID.RUNITE_BAR),
	SCORPIONS("Scorpions", ItemID.ENSOULED_SCORPION_HEAD),
	SEA_SNAKES("Sea snakes", ItemID.SNAKE_CORPSE),
	SHADES("Shades", ItemID.SHADE_ROBE_TOP),
	SHADOW_WARRIORS("Shadow warriors", ItemID.BLACK_FULL_HELM),
	SKELETAL_WYVERNS("Skeletal wyverns", ItemID.SKELETAL_WYVERN),
	SKELETONS("Skeletons", ItemID.SKELETON_GUARD),
	SMOKE_DEVILS("Smoke devils", ItemID.SMOKE_DEVIL),
	SPIDERS("Spiders", ItemID.HUGE_SPIDER),
	SPIRITUAL_CREATURES("Spiritual creatures", ItemID.DRAGON_BOOTS, "Spiritual ranger", "Spiritual mage", "Spiritual warrior"),
	STEEL_DRAGONS("Steel dragons", ItemID.STEEL_DRAGON),
	SUQAHS("Suqahs", ItemID.SUQAH_TOOTH),
	TERROR_DOGS("Terror dogs", ItemID.TERROR_DOG),
	TROLLS("Trolls", ItemID.TROLL_GUARD),
	TUROTH("Turoth", ItemID.TUROTH),
	TZHAAR("Tzhaar", ItemID.ENSOULED_TZHAAR_HEAD),
	VAMPIRES("Vampires", ItemID.STAKE),
	WALL_BEASTS("Wall beasts", ItemID.SWAMP_WALLBEAST),
	WATERFIENDS("Waterfiends", ItemID.WATER_ORB),
	WEREWOLVES("Werewolves", ItemID.WOLFBANE, "Werewolf"),
	WOLVES("Wolves", ItemID.GREY_WOLF_FUR, "Wolf"),
	ZOMBIES("Zombies", ItemID.ZOMBIE_HEAD, "Undead");
=======
import net.runelite.api.ItemID;

enum Task
{
	//<editor-fold desc="Enums">
	ABERRANT_SPECTRES("aberrant spectres", ItemID.ABERRANT_SPECTRE, "spectre"),
	ABYSSAL_DEMONS("abyssal demons", ItemID.ABYSSAL_DEMON),
	ADAMANT_DRAGONS("adamant dragons", ItemID.ADAMANTITE_BAR),
	ANKOU("ankou", ItemID.ANKOU_MASK),
	AVIANSIES("aviansies", ItemID.ENSOULED_AVIANSIE_HEAD),
	BANSHEES("banshees", ItemID.BANSHEE),
	BASILISKS("basilisks", ItemID.BASILISK),
	BATS("bats", ItemID.GIRAL_BAT_2),
	BEARS("bears", ItemID.ENSOULED_BEAR_HEAD),
	BIRDS("birds", ItemID.FEATHER, "chicken", "rooster", "terrorbird"),
	BLACK_DEMONS("black demons", ItemID.BLACK_DEMON_MASK),
	BLACK_DRAGONS("black dragons", ItemID.BLACK_DRAGON_MASK),
	BLOODVELD("bloodveld", ItemID.BLOODVELD),
	BLUE_DRAGONS("blue dragons", ItemID.BLUE_DRAGON_MASK),
	BRINE_RATS("brine rats", ItemID.BRINE_RAT),
	BRONZE_DRAGONS("bronze dragons", ItemID.BRONZE_DRAGON_MASK),
	CATABLEPON("catablepon", ItemID.LEFT_SKULL_HALF),
	CAVE_BUGS("cave bugs", ItemID.SWAMP_CAVE_BUG),
	CAVE_CRAWLERS("cave crawlers", ItemID.CAVE_CRAWLER, "chasm crawler"),
	CAVE_HORRORS("cave horrors", ItemID.CAVE_HORROR, "cave abomination"),
	CAVE_KRAKEN("cave kraken", ItemID.CAVE_KRAKEN),
	CAVE_SLIMES("cave slimes", ItemID.SWAMP_CAVE_SLIME),
	COCKATRICE("cockatrice", ItemID.COCKATRICE, "cockathrice"),
	COWS("cows", ItemID.COW_MASK),
	CRAWLING_HANDS("crawling hands", ItemID.CRAWLING_HAND, "crushing hand"),
	CROCODILES("crocodiles", ItemID.SWAMP_LIZARD),
	DAGANNOTH("dagannoth", ItemID.DAGANNOTH),
	DARK_BEASTS("dark beasts", ItemID.DARK_BEAST, "night beast"),
	DESERT_LIZARDS("desert lizards", ItemID.DESERT_LIZARD),
	DOGS("dogs", ItemID.GUARD_DOG, "jackal"),
	DUST_DEVILS("dust devils", ItemID.DUST_DEVIL, "choke devil"),
	DWARVES("dwarves", ItemID.DWARVEN_HELMET, "dwarf"),
	EARTH_WARRIORS("earth warriors", ItemID.BRONZE_FULL_HELM_T),
	ELVES("elves", ItemID.ELF, "elf"),
	FEVER_SPIDERS("fever spiders", ItemID.FEVER_SPIDER),
	FIRE_GIANTS("fire giants", ItemID.FIRE_BATTLESTAFF),
	FLESH_CRAWLERS("flesh crawlers", ItemID.ENSOULED_SCORPION_HEAD),
	FOSSIL_ISLAND_WYVERNS("fossil island wyverns", ItemID.FOSSIL_ISLAND_WYVERN, "ancient wyvern", "long-tailed wyvern", "spitting wyvern", "taloned wyvern"),
	GARGOYLES("gargoyles", ItemID.GARGOYLE),
	GHOSTS("ghosts", ItemID.GHOSTSPEAK_AMULET, "tortured soul"),
	GHOULS("ghouls", ItemID.ZOMBIE_HEAD),
	GOBLINS("goblins", ItemID.ENSOULED_GOBLIN_HEAD),
	GREATER_DEMONS("greater demons", ItemID.GREATER_DEMON_MASK),
	GREEN_DRAGONS("green dragons", ItemID.GREEN_DRAGON_MASK),
	HARPIE_BUG_SWARMS("harpie bug swarms", ItemID.SWARM),
	HELLHOUNDS("hellhounds", ItemID.HELLHOUND),
	HILL_GIANTS("hill giants", ItemID.ENSOULED_GIANT_HEAD),
	HOBGOBLINS("hobgoblins", ItemID.HOBGOBLIN_GUARD),
	ICE_GIANTS("ice giants", ItemID.ICE_DIAMOND),
	ICE_WARRIORS("ice warriors", ItemID.MITHRIL_FULL_HELM_T),
	ICEFIENDS("icefiends", ItemID.ICE_DIAMOND),
	INFERNAL_MAGES("infernal mages", ItemID.INFERNAL_MAGE, "malevolent mage"),
	IRON_DRAGONS("iron dragons", ItemID.IRON_DRAGON_MASK),
	JELLIES("jellies", ItemID.JELLY, "jelly"),
	JUNGLE_HORROR("jungle horrors", ItemID.ENSOULED_HORROR_HEAD),
	KALPHITE("kalphite", ItemID.KALPHITE_SOLDIER),
	KILLERWATTS("killerwatts", ItemID.KILLERWATT),
	KURASK("kurask", ItemID.KURASK),
	LESSER_DEMONS("lesser demons", ItemID.LESSER_DEMON_MASK),
	LIZARDMEN("lizardmen", ItemID.LIZARDMAN_FANG, "lizardman"),
	MINIONS_OF_SCABARAS("minions of scabaras", ItemID.GOLDEN_SCARAB, "scarab swarm", "locust rider", "scarab mage"),
	MINOTAURS("minotaurs", ItemID.ENSOULED_MINOTAUR_HEAD),
	MITHRIL_DRAGONS("mithril dragons", ItemID.MITHRIL_DRAGON_MASK),
	MOGRES("mogres", ItemID.MOGRE),
	MOLANISKS("molanisks", ItemID.MOLANISK),
	MONKEYS("monkeys", ItemID.ENSOULED_MONKEY_HEAD),
	MOSS_GIANTS("moss giants", ItemID.HILL_GIANT_CLUB),
	MUTATED_ZYGOMITES("mutated zygomites", ItemID.MUTATED_ZYGOMITE),
	NECHRYAEL("nechryael", ItemID.NECHRYAEL, "nechryarch"),
	OGRES("ogres", ItemID.ENSOULED_OGRE_HEAD),
	OTHERWORLDLY_BEING("otherworldly being", ItemID.GHOSTLY_HOOD),
	PYREFIENDS("pyrefiends", ItemID.PYREFIEND, "flaming pyrelord"),
	RATS("rats", ItemID.RATS_TAIL),
	RED_DRAGONS("red dragons", ItemID.BABY_RED_DRAGON),
	ROCKSLUGS("rockslugs", ItemID.ROCKSLUG),
	RUNE_DRAGONS("rune dragons", ItemID.RUNITE_BAR),
	SCORPIONS("scorpions", ItemID.ENSOULED_SCORPION_HEAD),
	SEA_SNAKES("sea snakes", ItemID.SNAKE_CORPSE),
	SHADES("shades", ItemID.SHADE_ROBE_TOP),
	SHADOW_WARRIORS("shadow warriors", ItemID.BLACK_FULL_HELM),
	SKELETAL_WYVERNS("skeletal wyverns", ItemID.SKELETAL_WYVERN),
	SKELETONS("skeletons", ItemID.SKELETON_GUARD),
	SMOKE_DEVILS("smoke devils", ItemID.SMOKE_DEVIL),
	SPIDERS("spiders", ItemID.HUGE_SPIDER),
	STEEL_DRAGONS("steel dragons", ItemID.STEEL_DRAGON),
	SUQAHS("suqahs", ItemID.SUQAH_TOOTH),
	TERROR_DOGS("terror dogs", ItemID.TERROR_DOG),
	TROLLS("trolls", ItemID.TROLL_GUARD),
	TUROTH("turoth", ItemID.TUROTH),
	TZHAAR("tzhaar", ItemID.ENSOULED_TZHAAR_HEAD),
	VAMPIRES("vampires", ItemID.STAKE),
	WALL_BEASTS("wall beasts", ItemID.SWAMP_WALLBEAST),
	WATERFIENDS("waterfiends", ItemID.WATER_ORB),
	WEREWOLVES("werewolves", ItemID.WOLFBANE, "werewolf"),
	WOLVES("wolves", ItemID.GREY_WOLF_FUR, "wolf"),
	ZOMBIES("zombies", ItemID.ZOMBIE_HEAD, "undead");
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	//</editor-fold>

	private static final Map<String, Task> tasks = new HashMap<>();

	private final String name;
	private final int itemSpriteId;
	private final String[] targetNames;

	static
	{
		for (Task task : values())
		{
<<<<<<< HEAD
			tasks.put(task.getName().toLowerCase(), task);
=======
			tasks.put(task.getName(), task);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	Task(String name, int itemSpriteId, String... targetNames)
	{
		Preconditions.checkArgument(itemSpriteId >= 0);
		this.name = name;
		this.itemSpriteId = itemSpriteId;
		this.targetNames = targetNames;
	}

<<<<<<< HEAD
	static Task getTask(String taskName)
	{
		return tasks.get(taskName.toLowerCase());
=======
	public static Task getTask(String taskName)
	{
		return tasks.get(taskName);
	}

	public String getName()
	{
		return this.name;
	}

	public int getItemSpriteId()
	{
		return itemSpriteId;
	}

	public String[] getTargetNames()
	{
		return this.targetNames;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
