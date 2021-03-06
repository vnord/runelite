/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.xtea;

import com.google.common.eventbus.Subscribe;
<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.xtea.XteaClient;
import net.runelite.http.api.xtea.XteaKey;
import net.runelite.http.api.xtea.XteaRequest;
=======
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.xtea.XteaClient;
import okhttp3.Response;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@PluginDescriptor(
	name = "Xtea",
	hidden = true
)
@Slf4j
public class XteaPlugin extends Plugin
{
	private final XteaClient xteaClient = new XteaClient();

	private final Set<Integer> sentRegions = new HashSet<>();

	@Inject
	private Client client;

<<<<<<< HEAD
	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
=======
	@Inject
	private ScheduledExecutorService executor;

	@Subscribe
	public void onMapRegionChanged(MapRegionChanged event)
	{
		int idx = event.getIndex();

		if (idx == -1)
		{
			return; // this is the new array being assigned to the field
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}

		int revision = client.getRevision();
		int[] regions = client.getMapRegions();
		int[][] xteaKeys = client.getXteaKeys();

<<<<<<< HEAD
		XteaRequest xteaRequest = new XteaRequest();
		xteaRequest.setRevision(revision);

		for (int idx = 0; idx < regions.length; ++idx)
		{
			int region = regions[idx];
			int[] keys = xteaKeys[idx];

			if (sentRegions.contains(region))
			{
				continue;
			}

			sentRegions.add(region);

			log.debug("Region {} keys {}, {}, {}, {}", region, keys[0], keys[1], keys[2], keys[3]);

			XteaKey xteaKey = new XteaKey();
			xteaKey.setRegion(region);
			xteaKey.setKeys(keys);
			xteaRequest.addKey(xteaKey);
		}

		if (xteaRequest.getKeys().isEmpty())
=======
		int region = regions[idx];
		int[] keys = xteaKeys[idx];

		log.debug("Region {} keys {}, {}, {}, {}", region, keys[0], keys[1], keys[2], keys[3]);

		// No need to ever send more than once
		if (sentRegions.contains(region))
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			return;
		}

<<<<<<< HEAD
		xteaClient.submit(xteaRequest);
=======
		sentRegions.add(region);

		executor.execute(() ->
		{
			try (Response response = xteaClient.submit(revision, region, keys))
			{
				if (!response.isSuccessful())
				{
					log.debug("unsuccessful xtea response");
				}
			}
			catch (IOException ex)
			{
				log.debug("unable to submit xtea keys", ex);
			}
		});
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
