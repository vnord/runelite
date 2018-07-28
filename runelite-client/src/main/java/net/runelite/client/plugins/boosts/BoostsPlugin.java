/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.boosts;

<<<<<<< HEAD
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
=======
import com.google.common.collect.ObjectArrays;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ConfigChanged;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Boosts Information",
	description = "Show combat and/or skill boost information",
	tags = {"combat", "notifications", "skilling", "overlay"}
)
@Slf4j
@Singleton
public class BoostsPlugin extends Plugin
{
	private static final Set<Skill> BOOSTABLE_COMBAT_SKILLS = ImmutableSet.of(
		Skill.ATTACK,
		Skill.STRENGTH,
		Skill.DEFENCE,
		Skill.RANGED,
		Skill.MAGIC);

	private static final Set<Skill> BOOSTABLE_NON_COMBAT_SKILLS = ImmutableSet.of(
		Skill.MINING, Skill.AGILITY, Skill.SMITHING, Skill.HERBLORE, Skill.FISHING, Skill.THIEVING,
		Skill.COOKING, Skill.CRAFTING, Skill.FIREMAKING, Skill.FLETCHING, Skill.WOODCUTTING, Skill.RUNECRAFT,
		Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER);

	@Inject
	private Notifier notifier;
=======
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Boosts Information"
)
@Slf4j
public class BoostsPlugin extends Plugin
{
	private static final Skill[] COMBAT = new Skill[]
	{
		Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE, Skill.RANGED, Skill.MAGIC
	};
	private static final Skill[] SKILLING = new Skill[]
	{
		Skill.MINING, Skill.AGILITY, Skill.SMITHING, Skill.HERBLORE, Skill.FISHING, Skill.THIEVING,
		Skill.COOKING, Skill.CRAFTING, Skill.FIREMAKING, Skill.FLETCHING, Skill.WOODCUTTING, Skill.RUNECRAFT,
		Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER
	};

	private final int[] lastSkillLevels = new int[Skill.values().length - 1];

	@Getter
	private Instant lastChange;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
<<<<<<< HEAD
	private OverlayManager overlayManager;

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private BoostsOverlay boostsOverlay;

	@Inject
	private BoostsConfig config;

	@Inject
	private SkillIconManager skillIconManager;

	@Getter
<<<<<<< HEAD
	private final Set<Skill> shownSkills = new HashSet<>();

	private boolean isChangedDown = false;
	private boolean isChangedUp = false;
	private final int[] lastSkillLevels = new int[Skill.values().length - 1];
	private int lastChangeDown = -1;
	private int lastChangeUp = -1;
	private boolean preserveBeenActive = false;
	private long lastTickMillis;
=======
	private Skill[] shownSkills;

	private StatChangeIndicator statChangeIndicator;

	private BufferedImage overallIcon;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Provides
	BoostsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BoostsConfig.class);
	}

	@Override
<<<<<<< HEAD
	protected void startUp() throws Exception
	{
		overlayManager.add(boostsOverlay);
		updateShownSkills();
		updateBoostedStats();
		Arrays.fill(lastSkillLevels, -1);

		// Add infoboxes for everything at startup and then determine inside if it will be rendered
		synchronized (ImageIO.class)
		{
			infoBoxManager.addInfoBox(new StatChangeIndicator(true, ImageIO.read(getClass().getResourceAsStream("debuffed.png")), this, config));
			infoBoxManager.addInfoBox(new StatChangeIndicator(false, ImageIO.read(getClass().getResourceAsStream("buffed.png")), this, config));
		}

		for (final Skill skill : Skill.values())
		{
			if (skill != Skill.OVERALL)
			{
				infoBoxManager.addInfoBox(new BoostIndicator(skill, skillIconManager.getSkillImage(skill), this, client, config));
			}
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(boostsOverlay);
		infoBoxManager.removeIf(t -> t instanceof BoostIndicator || t instanceof StatChangeIndicator);
		preserveBeenActive = false;
		lastChangeDown = -1;
		lastChangeUp = -1;
		isChangedUp = false;
		isChangedDown = false;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
				// After world hop and log out timers are in undefined state so just reset
				lastChangeDown = -1;
				lastChangeUp = -1;
		}
=======
	public Overlay getOverlay()
	{
		return boostsOverlay;
	}

	@Override
	protected void startUp()
	{
		updateShownSkills(config.enableSkill());
		Arrays.fill(lastSkillLevels, -1);
		overallIcon = skillIconManager.getSkillImage(Skill.OVERALL);
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof BoostIndicator || t instanceof StatChangeIndicator);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("boosts"))
		{
			return;
		}

<<<<<<< HEAD
		updateShownSkills();

		if (config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER)
		{
			lastChangeDown = -1;
		}

		if (config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.NEVER)
		{
			lastChangeUp = -1;
=======
		if (event.getKey().equals("displayIndicators") || event.getKey().equals("displayNextChange"))
		{
			addStatChangeIndicator();
			return;
		}

		Skill[] old = shownSkills;
		updateShownSkills(config.enableSkill());

		if (!Arrays.equals(old, shownSkills))
		{
			infoBoxManager.removeIf(t -> t instanceof BoostIndicator
				&& !Arrays.asList(shownSkills).contains(((BoostIndicator) t).getSkill()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Subscribe
<<<<<<< HEAD
	public void onBoostedLevelChange(BoostedLevelChanged boostedLevelChanged)
	{
		Skill skill = boostedLevelChanged.getSkill();

		if (!BOOSTABLE_COMBAT_SKILLS.contains(skill) && !BOOSTABLE_NON_COMBAT_SKILLS.contains(skill))
=======
	void onBoostedLevelChange(BoostedLevelChanged boostedLevelChanged)
	{
		Skill skill = boostedLevelChanged.getSkill();

		// Ignore changes to hitpoints or prayer
		if (skill == Skill.HITPOINTS || skill == Skill.PRAYER)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			return;
		}

		int skillIdx = skill.ordinal();
		int last = lastSkillLevels[skillIdx];
		int cur = client.getBoostedSkillLevel(skill);

<<<<<<< HEAD
		if (cur == last - 1)
		{
			// Stat was restored down (from buff)
			lastChangeDown = client.getTickCount();
		}

		if (cur == last + 1)
		{
			// Stat was restored up (from debuff)
			lastChangeUp = client.getTickCount();
		}

		lastSkillLevels[skillIdx] = cur;
		updateBoostedStats();

		int boostThreshold = config.boostThreshold();

		if (boostThreshold != 0)
		{
			int real = client.getRealSkillLevel(skill);
			int lastBoost = last - real;
			int boost = cur - real;
			if (boost <= boostThreshold && boostThreshold < lastBoost)
			{
				notifier.notify(skill.getName() + " level is getting low!");
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		lastTickMillis = System.currentTimeMillis();

		if (getChangeUpTicks() <= 0)
		{
			switch (config.displayNextDebuffChange())
			{
				case ALWAYS:
					if (lastChangeUp != -1)
					{
						lastChangeUp = client.getTickCount();
					}

					break;
				case BOOSTED:
				case NEVER:
					lastChangeUp = -1;
					break;
			}
		}

		if (getChangeDownTicks() <= 0)
		{
			switch (config.displayNextBuffChange())
			{
				case ALWAYS:
					if (lastChangeDown != -1)
					{
						lastChangeDown = client.getTickCount();
					}

					break;
				case BOOSTED:
				case NEVER:
					lastChangeDown = -1;
					break;
			}
		}
	}

	private void updateShownSkills()
	{
		if (config.enableSkill())
		{
			shownSkills.addAll(BOOSTABLE_NON_COMBAT_SKILLS);
		}
		else
		{
			shownSkills.removeAll(BOOSTABLE_NON_COMBAT_SKILLS);
		}

		shownSkills.addAll(BOOSTABLE_COMBAT_SKILLS);
	}

	private void updateBoostedStats()
	{
		// Reset is boosted
		isChangedDown = false;
		isChangedUp = false;

		// Check if we are still boosted
		for (final Skill skill : Skill.values())
		{
			if (!BOOSTABLE_COMBAT_SKILLS.contains(skill) && !BOOSTABLE_NON_COMBAT_SKILLS.contains(skill))
			{
				continue;
			}

			final int boosted = client.getBoostedSkillLevel(skill);
			final int base = client.getRealSkillLevel(skill);

			if (boosted > base)
			{
				isChangedUp = true;
			}
			else if (boosted < base)
			{
				isChangedDown = true;
			}
		}
	}

	boolean canShowBoosts()
	{
		return isChangedDown || isChangedUp;
	}

	/**
	 * Calculates the amount of time until boosted stats decay,
	 * accounting for the effect of preserve prayer.
	 * Preserve extends the time of boosted stats by 50% while active.
	 * The length of a boost is split into 4 sections of 15 seconds each.
	 * If the preserve prayer is active for the entire duration of the final
	 * section it will "activate" adding an additional 15 second section
	 * to the boost timing. If again the preserve prayer is active for that
	 * entire section a second 15 second section will be added.
	 *
	 * Preserve is only required to be on for the 4th and 5th sections of the boost timer
	 * to gain full effect (seconds 45-75).
	 *
	 * @return integer value in ticks until next boost change
	 */
	int getChangeDownTicks()
	{
		if (lastChangeDown == -1 ||
				config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
				(config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED && !isChangedUp))
		{
			return -1;
		}

		int ticksSinceChange = client.getTickCount() - lastChangeDown;
		boolean isPreserveActive = client.isPrayerActive(Prayer.PRESERVE);

		if ((isPreserveActive && (ticksSinceChange < 75 || preserveBeenActive)) || ticksSinceChange > 125)
		{
			preserveBeenActive = true;
			return 150 - ticksSinceChange;
		}

		preserveBeenActive = false;
		return (ticksSinceChange > 100) ? 125 - ticksSinceChange : 100 - ticksSinceChange;
	}

	/**
	 * Restoration from debuff is separate timer as restoration from buff because of preserve messing up the buff timer.
	 * Restoration timer is always in 100 tick cycles.
	 *
	 * @return integer value in ticks until next stat restoration up
	 */
	int getChangeUpTicks()
	{
		if (lastChangeUp == -1 ||
				config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
				(config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED && !isChangedDown))
		{
			return -1;
		}

		int ticksSinceChange = client.getTickCount() - lastChangeUp;
		return 100 - ticksSinceChange;
	}


	/**
	 * Converts tick-based time to accurate second time
	 * @param time tick-based time
	 * @return second-based time
	 */
	int getChangeTime(final int time)
	{
		final long diff = System.currentTimeMillis() - lastTickMillis;
		return time != -1 ? (int)(time * 0.6 - (diff / 1000d)) : time;
=======
		// Check if stat goes +1 or -2
		if (cur == last + 1 || cur == last - 1)
		{
			log.debug("Skill {} healed", skill);
			lastChange = Instant.now();
			addStatChangeIndicator();
		}
		lastSkillLevels[skillIdx] = cur;
	}

	private void updateShownSkills(boolean showSkillingSkills)
	{
		if (showSkillingSkills)
		{
			shownSkills = ObjectArrays.concat(COMBAT, SKILLING, Skill.class);
		}
		else
		{
			shownSkills = COMBAT;
		}
	}

	public void addStatChangeIndicator()
	{
		infoBoxManager.removeInfoBox(statChangeIndicator);
		statChangeIndicator = null;

		if (lastChange != null
			&& config.displayIndicators()
			&& config.displayNextChange())
		{
			statChangeIndicator = new StatChangeIndicator(getChangeTime(), ChronoUnit.SECONDS, overallIcon, this);
			infoBoxManager.addInfoBox(statChangeIndicator);
		}
	}

	public int getChangeTime()
	{
		return 60 - (int) Duration.between(lastChange, Instant.now()).getSeconds();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
