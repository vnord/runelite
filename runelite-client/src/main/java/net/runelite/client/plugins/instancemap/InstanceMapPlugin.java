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
package net.runelite.client.plugins.instancemap;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import javax.inject.Inject;
import net.runelite.api.events.GameStateChanged;
<<<<<<< HEAD
=======
import net.runelite.api.events.MapRegionChanged;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.WORLD_MAP_OPTION;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Instance Map",
	description = "Add an instanced map, accessible by right-clicking the map button"
=======
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Instance Map"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
)
public class InstanceMapPlugin extends Plugin
{
	private final WidgetMenuOption openMapOption = new WidgetMenuOption("Show", "Instance Map", WidgetInfo.WORLD_MAP_OPTION);

	@Inject
	private InstanceMapInputListener inputListener;

	@Inject
<<<<<<< HEAD
	private OverlayManager overlayManager;

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private InstanceMapOverlay overlay;

	@Inject
	private MenuManager menuManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MouseManager mouseManager;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(InstanceMapInputListener.class);
	}

	private void addCustomOptions()
	{
		menuManager.addManagedCustomMenu(openMapOption);
	}

	private void removeCustomOptions()
	{
		menuManager.removeManagedCustomMenu(openMapOption);
	}

	@Override
	protected void startUp() throws Exception
	{
<<<<<<< HEAD
		overlayManager.add(overlay);
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		addCustomOptions();
		keyManager.registerKeyListener(inputListener);
		mouseManager.registerMouseListener(inputListener);
		mouseManager.registerMouseWheelListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
<<<<<<< HEAD
		overlayManager.remove(overlay);
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		removeCustomOptions();
		keyManager.unregisterKeyListener(inputListener);
		mouseManager.registerMouseListener(inputListener);
		mouseManager.unregisterMouseWheelListener(inputListener);
	}

	@Subscribe
<<<<<<< HEAD
=======
	public void regionChange(MapRegionChanged event)
	{
		overlay.onRegionChange(event);
	}

	@Subscribe
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public void gameStateChange(GameStateChanged event)
	{
		overlay.onGameStateChange(event);
	}

	private boolean clickedOptionEquals(WidgetMenuOptionClicked event, WidgetMenuOption widgetMenuOption)
	{
		return event.getMenuOption().equals(widgetMenuOption.getMenuOption()) && event.getMenuTarget().equals(widgetMenuOption.getMenuTarget());
	}

	@Subscribe
	public void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getWidget() != WORLD_MAP_OPTION)
		{
			return;
		}

		if (clickedOptionEquals(event, openMapOption))
		{
			if (overlay.isMapShown())
			{
				closeMap();
			}
			else
			{
				showMap();
			}
		}
	}

<<<<<<< HEAD
=======
	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public void showMap()
	{
		overlay.setShowMap(true);
		openMapOption.setMenuOption("Hide");
	}

	public void closeMap()
	{
		overlay.setShowMap(false);
		openMapOption.setMenuOption("Show");
	}

	public void ascendMap()
	{
		overlay.onAscend();
	}

	public void descendMap()
	{
		overlay.onDescend();
	}
}
