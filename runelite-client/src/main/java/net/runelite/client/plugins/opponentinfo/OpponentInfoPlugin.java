/*
<<<<<<< HEAD
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
=======
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.opponentinfo;

import com.google.common.eventbus.Subscribe;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
<<<<<<< HEAD
import com.google.inject.Provides;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
=======
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.util.EnumSet;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
<<<<<<< HEAD
import net.runelite.api.Actor;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameStateChanged;
<<<<<<< HEAD
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.hiscore.HiscoreEndpoint;

@PluginDescriptor(
	name = "Opponent Information",
	description = "Show name and hitpoints information about the NPC you are fighting",
	tags = {"combat", "health", "hitpoints", "npcs", "overlay"}
)
public class OpponentInfoPlugin extends Plugin
{
	private static final Duration WAIT = Duration.ofSeconds(5);

=======
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.http.api.hiscore.HiscoreEndpoint;

@PluginDescriptor(
	name = "Opponent Information"
)
public class OpponentInfoPlugin extends Plugin
{
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Inject
	private Client client;

	@Inject
<<<<<<< HEAD
	private OpponentInfoConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private OpponentInfoOverlay opponentInfoOverlay;

	@Inject
	private PlayerComparisonOverlay playerComparisonOverlay;
=======
	private OpponentInfoOverlay overlay;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Getter(AccessLevel.PACKAGE)
	private HiscoreEndpoint hiscoreEndpoint = HiscoreEndpoint.NORMAL;

<<<<<<< HEAD
	@Getter(AccessLevel.PACKAGE)
	private Actor lastOpponent;

	private Instant lastTime;

	@Getter(AccessLevel.PACKAGE)
	private final Map<String, Integer> oppInfoHealth = loadNpcHealth();

	@Provides
	OpponentInfoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OpponentInfoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(opponentInfoOverlay);
		overlayManager.add(playerComparisonOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		lastOpponent = null;
		lastTime = null;
		overlayManager.remove(opponentInfoOverlay);
		overlayManager.remove(playerComparisonOverlay);
=======
	@Override
	public Overlay getOverlay()
	{
		return overlay;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		EnumSet<WorldType> worldType = client.getWorldType();
<<<<<<< HEAD
		if (worldType.contains(WorldType.SEASONAL_DEADMAN))
		{
			hiscoreEndpoint = HiscoreEndpoint.SEASONAL_DEADMAN;
		}
		else if (worldType.contains(WorldType.DEADMAN))
		{
			hiscoreEndpoint = HiscoreEndpoint.DEADMAN;
=======
		if (worldType.contains(WorldType.DEADMAN))
		{
			hiscoreEndpoint = HiscoreEndpoint.DEADMAN;
		}
		else if (worldType.contains(WorldType.SEASONAL_DEADMAN))
		{
			hiscoreEndpoint = HiscoreEndpoint.SEASONAL_DEADMAN;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		else
		{
			hiscoreEndpoint = HiscoreEndpoint.NORMAL;
		}
	}

<<<<<<< HEAD
	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}

		Actor opponent = event.getTarget();

		if (opponent == null)
		{
			lastTime = Instant.now();
			return;
		}

		lastOpponent = opponent;
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (lastOpponent != null && client.getLocalPlayer().getInteracting() == null)
		{
			if (Duration.between(lastTime, Instant.now()).compareTo(WAIT) > 0)
			{
				lastOpponent = null;
			}
		}
	}

	private Map<String, Integer> loadNpcHealth()
=======
	public static Map<String, Integer> loadNpcHealth()
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Integer>>()
		{
		}.getType();

		InputStream healthFile = OpponentInfoPlugin.class.getResourceAsStream("/npc_health.json");
		return gson.fromJson(new InputStreamReader(healthFile), type);
	}
}
