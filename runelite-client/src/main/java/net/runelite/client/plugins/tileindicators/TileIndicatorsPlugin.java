/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.tileindicators;

import com.google.inject.Provides;
import javax.inject.Inject;
<<<<<<< HEAD
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Tile Indicators",
	description = "Highlight the tile you are currently moving to",
	tags = {"highlight", "overlay"},
=======
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Tile Indicators",
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	enabledByDefault = false
)
public class TileIndicatorsPlugin extends Plugin
{
	@Inject
<<<<<<< HEAD
	private OverlayManager overlayManager;

	@Inject
	private TileIndicatorsOverlay overlay;
=======
	private Client client;

	@Inject
	private TileIndicatorsConfig config;

	private TileIndicatorsOverlay tileIndicatorsOverlay;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Provides
	TileIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TileIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
<<<<<<< HEAD
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
=======
		tileIndicatorsOverlay = new TileIndicatorsOverlay(client, config);
	}

	@Override
	public Overlay getOverlay()
	{
		return tileIndicatorsOverlay;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
