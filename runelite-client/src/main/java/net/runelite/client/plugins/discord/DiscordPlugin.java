/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
<<<<<<< HEAD
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
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
package net.runelite.client.plugins.discord;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
<<<<<<< HEAD
import java.util.EnumSet;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import net.runelite.api.Client;
<<<<<<< HEAD
import static net.runelite.api.Constants.CHUNK_SIZE;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
=======
import net.runelite.api.GameState;
import net.runelite.api.Skill;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.ConfigManager;
<<<<<<< HEAD
=======
import net.runelite.client.discord.DiscordService;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.TitleToolbar;
import net.runelite.client.util.LinkBrowser;

@PluginDescriptor(
<<<<<<< HEAD
	name = "Discord",
	description = "Show your status and activity in the Discord user panel",
	tags = {"action", "activity", "external", "integration", "status"}
=======
	name = "Discord"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
)
public class DiscordPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DiscordConfig config;

	@Inject
<<<<<<< HEAD
	private TitleToolbar titleToolbar;

	@Inject
	private RuneLiteProperties properties;

	@Inject
	private DiscordState discordState;

	private Map<Skill, Integer> skillExp = new HashMap<>();
	private NavigationButton discordButton;
	private boolean loginFlag;
=======
	private DiscordService discordService;

	@Inject
	private TitleToolbar titleToolbar;

	@Inject
	private RuneLiteProperties properties;

	private final DiscordState discordState = new DiscordState();
	private Map<Skill, Integer> skillExp = new HashMap<>();
	private boolean loggedIn = false;
	private NavigationButton discordButton;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Provides
	private DiscordConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DiscordConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("discord.png"));
		}

		discordButton = NavigationButton.builder()
			.tooltip("Join Discord")
			.icon(icon)
			.onClick(() -> LinkBrowser.browse(properties.getDiscordInvite()))
			.build();

		titleToolbar.addNavigation(discordButton);
<<<<<<< HEAD
		checkForGameStateUpdate();
=======
		updateGameStatus(client.getGameState(), true);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Override
	protected void shutDown() throws Exception
	{
		titleToolbar.removeNavigation(discordButton);
<<<<<<< HEAD
=======
		discordService.clearPresence();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		discordState.reset();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
<<<<<<< HEAD
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
				checkForGameStateUpdate();
				return;
			case LOGGING_IN:
				loginFlag = true;
				break;
			case LOGGED_IN:
				if (loginFlag)
				{
					loginFlag = false;
					checkForGameStateUpdate();
				}

				break;
		}

		checkForAreaUpdate();
	}

	@Subscribe
	public void configChanged(ConfigChanged event)
	{
		if (event.getGroup().equalsIgnoreCase("discord"))
		{
			checkForGameStateUpdate();
			checkForAreaUpdate();
		}
=======
		updateGameStatus(event.getGameState(), false);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onXpChanged(ExperienceChanged event)
	{
		final int exp = client.getSkillExperience(event.getSkill());
		final Integer previous = skillExp.put(event.getSkill(), exp);

		if (previous == null || previous >= exp)
		{
			return;
		}

		final DiscordGameEventType discordGameEventType = DiscordGameEventType.fromSkill(event.getSkill());

<<<<<<< HEAD
		if (discordGameEventType != null && config.showSkillingActivity())
		{
			discordState.triggerEvent(discordGameEventType);
=======
		if (discordGameEventType != null)
		{
			discordState.triggerEvent(discordGameEventType, config.actionDelay());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.MINUTES
	)
	public void checkForValidStatus()
	{
<<<<<<< HEAD
		discordState.checkForTimeout();
	}

	private void checkForGameStateUpdate()
	{
		// Game state update does also full reset of discord state
		discordState.reset();
		discordState.triggerEvent(client.getGameState() == GameState.LOGGED_IN
			? DiscordGameEventType.IN_GAME
			: DiscordGameEventType.IN_MENU);
	}

	private void checkForAreaUpdate()
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		final int playerRegionID = getCurrentRegion();

		if (playerRegionID == 0)
		{
			return;
		}

		final DiscordGameEventType discordGameEventType = DiscordGameEventType.fromRegion(playerRegionID);

		if (discordGameEventType == null)
		{
			// Unknown region, reset to default in-game
			discordState.triggerEvent(DiscordGameEventType.IN_GAME);
			return;
		}

		if (!showArea(discordGameEventType))
		{
			return;
		}

		discordState.triggerEvent(discordGameEventType);
	}

	private boolean showArea(final DiscordGameEventType event)
	{
		if (event == null)
		{
			return false;
		}

		final EnumSet<WorldType> worldType = client.getWorldType();

		// Do not show location in PVP activities
		if (worldType.contains(WorldType.SEASONAL_DEADMAN) ||
			worldType.contains(WorldType.DEADMAN) ||
			worldType.contains(WorldType.PVP) ||
			worldType.contains(WorldType.PVP_HIGH_RISK))
		{
			return false;
		}

		switch (event.getDiscordAreaType())
		{
			case BOSSES: return config.showBossActivity();
			case CITIES: return config.showCityActivity();
			case DUNGEONS: return config.showDungeonActivity();
			case MINIGAMES: return config.showMinigameActivity();
		}

		return false;
	}

	private int getCurrentRegion()
	{
		if (!client.isInInstancedRegion())
		{
			return client.getLocalPlayer().getWorldLocation().getRegionID();
		}

		// get chunk data of current chunk
		final LocalPoint localPoint = client.getLocalPlayer().getLocalLocation();
		final int[][][] instanceTemplateChunks = client.getInstanceTemplateChunks();
		final int z = client.getPlane();
		final int chunkData = instanceTemplateChunks[z][localPoint.getSceneX() / CHUNK_SIZE][localPoint.getSceneY() / CHUNK_SIZE];

		// extract world point from chunk data
		final int chunkY = (chunkData >> 3 & 0x7FF) * CHUNK_SIZE;
		final int chunkX = (chunkData >> 14 & 0x3FF) * CHUNK_SIZE;

		final WorldPoint worldPoint = new WorldPoint(chunkX, chunkY, z);
		return worldPoint.getRegionID();
	}

=======
		if (discordState.checkForTimeout(config.actionTimeout()))
		{
			updateGameStatus(client.getGameState(), true);
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void flushDiscordStatus()
	{
		discordState.flushEvent(discordService);
	}

	private void updateGameStatus(GameState gameState, boolean force)
	{
		if (gameState == GameState.LOGIN_SCREEN)
		{
			skillExp.clear();
			loggedIn = false;
			discordState.triggerEvent(DiscordGameEventType.IN_MENU, config.actionDelay());
		}
		else if (client.getGameState() == GameState.LOGGED_IN && (force || !loggedIn))
		{
			loggedIn = true;
			discordState.triggerEvent(DiscordGameEventType.IN_GAME, config.actionDelay());
		}
	}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
