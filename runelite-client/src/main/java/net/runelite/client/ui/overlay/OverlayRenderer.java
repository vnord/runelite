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
package net.runelite.client.ui.overlay;

import com.google.common.base.MoreObjects;
import com.google.common.eventbus.Subscribe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.FocusChanged;
<<<<<<< HEAD
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.RuneLiteConfig;
=======
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.events.PluginChanged;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseListener;
import net.runelite.client.input.MouseManager;
<<<<<<< HEAD
import net.runelite.client.ui.FontManager;
=======
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxOverlay;
import net.runelite.client.ui.overlay.tooltip.TooltipOverlay;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@Singleton
@Slf4j
public class OverlayRenderer extends MouseListener implements KeyListener
{
	private static final int BORDER_LEFT_RESIZABLE = 5;
	private static final int BORDER_TOP_RESIZABLE = 20;
	private static final int FRAME_OFFSET = 4;
	private static final int BORDER_LEFT_FIXED = BORDER_LEFT_RESIZABLE + FRAME_OFFSET;
	private static final int BORDER_TOP_FIXED = BORDER_TOP_RESIZABLE + FRAME_OFFSET;
	private static final int BORDER_RIGHT = 2;
	private static final int BORDER_BOTTOM = 2;
	private static final int PADDING = 2;
	private static final Dimension SNAP_CORNER_SIZE = new Dimension(80, 80);
	private static final Color SNAP_CORNER_COLOR = new Color(0, 255, 255, 50);
	private static final Color SNAP_CORNER_ACTIVE_COLOR = new Color(0, 255, 0, 100);
	private static final Color MOVING_OVERLAY_COLOR = new Color(255, 255, 0, 100);
	private static final Color MOVING_OVERLAY_ACTIVE_COLOR = new Color(255, 255, 0, 200);
<<<<<<< HEAD
	private final Provider<Client> clientProvider;
	private final OverlayManager overlayManager;
	private final RuneLiteConfig runeLiteConfig;
=======
	private static final String OVERLAY_CONFIG_PREFERRED_LOCATION = "_preferredLocation";
	private static final String OVERLAY_CONFIG_PREFERRED_POSITION = "_preferredPosition";

	private final PluginManager pluginManager;
	private final Provider<Client> clientProvider;
	private final InfoBoxOverlay infoBoxOverlay;
	private final ConfigManager configManager;
	private final RuneLiteConfig runeLiteConfig;
	private final TooltipOverlay tooltipOverlay;
	private final WorldMapOverlay worldMapOverlay;
	private final List<Overlay> allOverlays = new CopyOnWriteArrayList<>();
	private final String runeliteGroupName = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).keyName();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	// Overlay movement variables
	private final Point overlayOffset = new Point();
	private final Point mousePosition = new Point();
	private Overlay movedOverlay;
	private boolean inOverlayDraggingMode;

	// Overlay state validation
	private Rectangle viewportBounds;
	private Rectangle chatboxBounds;
	private boolean chatboxHidden;
	private boolean isResizeable;
	private OverlayBounds snapCorners;
<<<<<<< HEAD
=======
	private final Map<OverlayLayer, List<Overlay>> overlayLayerOverlayMap = Collections
		.synchronizedMap(new HashMap<>());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Inject
	private OverlayRenderer(
		final Provider<Client> clientProvider,
<<<<<<< HEAD
		final OverlayManager overlayManager,
		final RuneLiteConfig runeLiteConfig,
		final MouseManager mouseManager,
		final KeyManager keyManager)
	{
		this.clientProvider = clientProvider;
		this.overlayManager = overlayManager;
=======
		final PluginManager pluginManager,
		final MouseManager mouseManager,
		final KeyManager keyManager,
		final TooltipOverlay tooltipOverlay,
		final InfoBoxOverlay infoBoxOverlay,
		final WorldMapOverlay worldMapOverlay,
		final ConfigManager configManager,
		final RuneLiteConfig runeLiteConfig)
	{
		this.clientProvider = clientProvider;
		this.pluginManager = pluginManager;
		this.tooltipOverlay = tooltipOverlay;
		this.infoBoxOverlay = infoBoxOverlay;
		this.worldMapOverlay = worldMapOverlay;
		this.configManager = configManager;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		this.runeLiteConfig = runeLiteConfig;
		keyManager.registerKeyListener(this);
		mouseManager.registerMouseListener(this);
	}

	@Subscribe
<<<<<<< HEAD
=======
	public void onGameStateChanged(GameStateChanged event)
	{
		final Client client = clientProvider.get();

		if (client == null)
		{
			return;
		}

		if (event.getGameState().equals(GameState.LOGGED_IN))
		{
			rebuildOverlays();
		}
	}

	@Subscribe
	public void onPluginChanged(PluginChanged event)
	{
		rebuildOverlays();
	}

	@Subscribe
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			inOverlayDraggingMode = false;
		}
	}

<<<<<<< HEAD
	public void render(Graphics2D graphics, final OverlayLayer layer)
	{
		final Client client = clientProvider.get();
		final List<Overlay> overlays = overlayManager.getLayer(layer);
=======
	private void rebuildOverlays()
	{
		final List<Overlay> overlays = Stream
			.concat(
				pluginManager.getPlugins()
					.stream()
					.filter(pluginManager::isPluginEnabled)
					.flatMap(plugin -> plugin.getOverlays().stream()),
				Stream.of(infoBoxOverlay, tooltipOverlay, worldMapOverlay))
			.filter(Objects::nonNull)
			.collect(Collectors.toList());

		sortOverlays(overlays);
		allOverlays.clear();
		allOverlays.addAll(overlays);

		final Client client = clientProvider.get();

		if (client == null)
		{
			return;
		}

		for (final Overlay overlay : overlays)
		{
			final Point location = loadOverlayLocation(overlay);

			if (location != null
				&& client.getCanvas() != null
				&& !client.getCanvas().contains(location))
			{
				overlay.setPreferredLocation(null);
				saveOverlayLocation(overlay);
			}
			else
			{
				overlay.setPreferredLocation(location);
			}

			final OverlayPosition position = loadOverlayPosition(overlay);
			overlay.setPreferredPosition(position);
		}

		rebuildOverlayLayers();
	}

	private void rebuildOverlayLayers()
	{
		overlayLayerOverlayMap.clear();

		for (final Overlay overlay : allOverlays)
		{
			OverlayLayer layer = overlay.getLayer();

			if (overlay.getPreferredLocation() != null && overlay.getPreferredPosition() == null)
			{
				// When UNDER_WIDGET overlays are in preferred locations, move to
				// ABOVE_WIDGETS so that it can draw over interfaces
				if (layer == OverlayLayer.UNDER_WIDGETS)
				{
					layer = OverlayLayer.ABOVE_WIDGETS;
				}
			}

			overlayLayerOverlayMap.compute(layer, (key, value) ->
			{
				if (value == null)
				{
					value = new CopyOnWriteArrayList<>();
				}

				value.add(overlay);
				return value;
			});
		}
	}

	static void sortOverlays(List<Overlay> overlays)
	{
		overlays.sort((a, b) ->
		{
			if (a.getPosition() != b.getPosition())
			{
				// This is so non-dynamic overlays render after dynamic
				// overlays, which are generally in the scene
				return a.getPosition().compareTo(b.getPosition());
			}

			// For dynamic overlays, higher priority means to
			// draw *later* so it is on top.
			// For non-dynamic overlays, higher priority means
			// draw *first* so that they are closer to their
			// defined position.
			return a.getPosition() == OverlayPosition.DYNAMIC
				? a.getPriority().compareTo(b.getPriority())
				: b.getPriority().compareTo(a.getPriority());
		});
	}

	public void render(Graphics2D graphics, final OverlayLayer layer)
	{
		final Client client = clientProvider.get();
		final List<Overlay> overlays = overlayLayerOverlayMap.get(layer);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		if (client == null
			|| overlays == null
			|| overlays.isEmpty()
			|| client.getGameState() != GameState.LOGGED_IN
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
			|| client.getViewportWidget() == null)
		{
			return;
		}

		if (shouldInvalidateBounds())
		{
			snapCorners = buildSnapCorners();
		}

		// Create copy of snap corners because overlays will modify them
		OverlayBounds snapCorners = new OverlayBounds(this.snapCorners);
		OverlayUtil.setGraphicProperties(graphics);

		// Draw snap corners
<<<<<<< HEAD
		if (layer == OverlayLayer.UNDER_WIDGETS && movedOverlay != null && movedOverlay.getPosition() != OverlayPosition.DETACHED)
=======
		if (layer == OverlayLayer.UNDER_WIDGETS && movedOverlay != null)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			final OverlayBounds translatedSnapCorners = snapCorners.translated(
				-SNAP_CORNER_SIZE.width,
				-SNAP_CORNER_SIZE.height);

			final Color previous = graphics.getColor();

			for (final Rectangle corner : translatedSnapCorners.getBounds())
			{
				graphics.setColor(corner.contains(mousePosition) ? SNAP_CORNER_ACTIVE_COLOR : SNAP_CORNER_COLOR);
				graphics.fill(corner);
			}

			graphics.setColor(previous);
		}

		for (Overlay overlay : overlays)
		{
			OverlayPosition overlayPosition = overlay.getPosition();

			if (overlay.getPreferredPosition() != null)
			{
				overlayPosition = overlay.getPreferredPosition();
			}

			if (overlayPosition == OverlayPosition.ABOVE_CHATBOX_RIGHT && !isResizeable)
			{
				// On fixed mode, ABOVE_CHATBOX_RIGHT is in the same location as
				// BOTTOM_RIGHT. Just use BOTTOM_RIGHT to prevent overlays from
				// drawing over each other.
				overlayPosition = OverlayPosition.BOTTOM_RIGHT;
			}

			if (overlayPosition == OverlayPosition.DYNAMIC || overlayPosition == OverlayPosition.TOOLTIP)
			{
				safeRender(client, overlay, layer, graphics, new Point());
			}
			else
			{
				final Point location = overlay.getBounds().getLocation();
				final Dimension dimension = overlay.getBounds().getSize();

				// If the final position is not modified, layout it
<<<<<<< HEAD
				if (overlayPosition != OverlayPosition.DETACHED && (overlay.getPreferredLocation() == null || overlay.getPreferredPosition() != null))
=======
				if (overlay.getPreferredLocation() == null || overlay.getPreferredPosition() != null)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				{
					final Rectangle snapCorner = snapCorners.forPosition(overlayPosition);
					final Point translation = OverlayUtil.transformPosition(overlayPosition, dimension);
					location.setLocation(snapCorner.getX() + translation.x, snapCorner.getY() + translation.y);
					final Point padding = OverlayUtil.padPosition(overlayPosition, dimension, PADDING);
					snapCorner.translate(padding.x, padding.y);
				}
				else
				{
<<<<<<< HEAD
					final Point preferredLocation = overlay.getPreferredLocation();

					if (preferredLocation != null)
					{
						final Dimension realDimensions = client.getRealDimensions();
						final int x = Math.min(realDimensions.width - 5, preferredLocation.x);
						final int y = Math.min(realDimensions.height - 5, preferredLocation.y);
						location.setLocation(x, y);
					}
				}

				if (overlay.getPreferredSize() != null)
				{
					overlay.getBounds().setSize(overlay.getPreferredSize());
				}

				safeRender(client, overlay, layer, graphics, location);
				final Rectangle bounds = overlay.getBounds();

				if (bounds.isEmpty())
=======
					location.setLocation(overlay.getPreferredLocation());
				}

				safeRender(client, overlay, layer, graphics, location);
				dimension.setSize(overlay.getBounds().getSize());

				if (dimension.width == 0 && dimension.height == 0)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				{
					continue;
				}

				if (inOverlayDraggingMode)
				{
					final Color previous = graphics.getColor();
					graphics.setColor(movedOverlay == overlay ? MOVING_OVERLAY_ACTIVE_COLOR : MOVING_OVERLAY_COLOR);
<<<<<<< HEAD
					graphics.draw(bounds);
=======
					graphics.drawRect(location.x, location.y, dimension.width - 1, dimension.height - 1);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
					graphics.setColor(previous);
				}
			}
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		if (!inOverlayDraggingMode)
		{
			return mouseEvent;
		}

		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);

<<<<<<< HEAD
		synchronized (overlayManager)
		{
			for (Overlay overlay : overlayManager.getOverlays())
			{
				if (overlay.getBounds().contains(mousePoint))
				{
					if (SwingUtilities.isRightMouseButton(mouseEvent))
					{
						overlayManager.resetOverlay(overlay);
					}
					else
					{
						final Point offset = new Point(mousePoint.x, mousePoint.y);
						offset.translate(-overlay.getBounds().x, -overlay.getBounds().y);
						overlayOffset.setLocation(offset);

						mousePoint.translate(-offset.x, -offset.y);
						movedOverlay = overlay;
						movedOverlay.setPreferredPosition(null);
						movedOverlay.setPreferredLocation(mousePoint);
						overlayManager.saveOverlay(movedOverlay);
					}

					mouseEvent.consume();
					break;
				}
=======
		for (Overlay overlay : allOverlays)
		{
			if (overlay.getBounds().contains(mousePoint))
			{
				if (SwingUtilities.isRightMouseButton(mouseEvent))
				{
					overlay.setPreferredLocation(null);
					overlay.setPreferredPosition(null);
					saveOverlayPosition(overlay);
					saveOverlayLocation(overlay);
					rebuildOverlayLayers();
				}
				else
				{
					mousePoint.translate(-overlay.getBounds().x, -overlay.getBounds().y);
					overlayOffset.setLocation(mousePoint);
					movedOverlay = overlay;
				}

				mouseEvent.consume();
				break;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		if (!inOverlayDraggingMode)
		{
			return mouseEvent;
		}

		final Client client = clientProvider.get();

		if (client == null)
		{
			return mouseEvent;
		}

		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);
		final Rectangle canvasRect = new Rectangle(client.getRealDimensions());

		if (!canvasRect.contains(mousePoint))
		{
			return mouseEvent;
		}

		if (movedOverlay != null)
		{
			mousePoint.translate(-overlayOffset.x, -overlayOffset.y);
			movedOverlay.setPreferredPosition(null);
			movedOverlay.setPreferredLocation(mousePoint);
<<<<<<< HEAD
=======
			rebuildOverlayLayers();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			mouseEvent.consume();
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		if (movedOverlay != null)
		{
			mousePosition.setLocation(-1, -1);
<<<<<<< HEAD

			// do not snapcorner detached overlays
			if (movedOverlay.getPosition() != OverlayPosition.DETACHED)
			{
				final OverlayBounds snapCorners = this.snapCorners.translated(-SNAP_CORNER_SIZE.width, -SNAP_CORNER_SIZE.height);

				for (Rectangle snapCorner : snapCorners.getBounds())
				{
					if (snapCorner.contains(mouseEvent.getPoint()))
					{
						OverlayPosition position = snapCorners.fromBounds(snapCorner);

						if (position == movedOverlay.getPosition())
						{
							// overlay moves back to default position
							position = null;
						}

						movedOverlay.setPreferredPosition(position);
						movedOverlay.setPreferredLocation(null); // from dragging
						break;
					}
				}
			}

			overlayManager.saveOverlay(movedOverlay);
=======
			final OverlayBounds snapCorners = this.snapCorners.translated(-SNAP_CORNER_SIZE.width, -SNAP_CORNER_SIZE.height);

			for (Rectangle snapCorner : snapCorners.getBounds())
			{
				if (snapCorner.contains(mouseEvent.getPoint()))
				{
					OverlayPosition position = snapCorners.fromBounds(snapCorner);
					if (position == movedOverlay.getPosition())
					{
						// overlay moves back to default position
						position = null;
					}
					movedOverlay.setPreferredPosition(position);
					movedOverlay.setPreferredLocation(null); // from dragging
					break;
				}
			}

			saveOverlayPosition(movedOverlay);
			saveOverlayLocation(movedOverlay);
			rebuildOverlayLayers();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			movedOverlay = null;
			mouseEvent.consume();
		}

		return mouseEvent;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.isAltDown())
		{
			inOverlayDraggingMode = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (!e.isAltDown())
		{
			inOverlayDraggingMode = false;
		}
	}

	private void safeRender(Client client, Overlay overlay, OverlayLayer layer, Graphics2D graphics, Point point)
	{
		final Graphics2D subGraphics = (Graphics2D) graphics.create();

		if (!isResizeable && (layer == OverlayLayer.ABOVE_SCENE || layer == OverlayLayer.UNDER_WIDGETS))
		{
			subGraphics.setClip(client.getViewportXOffset(),
				client.getViewportYOffset(),
				client.getViewportWidth(),
				client.getViewportHeight());
		}

		final OverlayPosition position = overlay.getPosition();

		// Set font based on configuration
		if (position == OverlayPosition.DYNAMIC)
		{
			subGraphics.setFont(runeLiteConfig.fontType().getFont());
		}
		else if (position == OverlayPosition.TOOLTIP)
		{
			subGraphics.setFont(runeLiteConfig.tooltipFontType().getFont());
		}
		else
		{
			subGraphics.setFont(FontManager.getRunescapeFont());
		}

<<<<<<< HEAD
=======

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		subGraphics.translate(point.x, point.y);
		final Dimension dimension = MoreObjects.firstNonNull(overlay.render(subGraphics), new Dimension());
		subGraphics.dispose();
		overlay.setBounds(new Rectangle(point, dimension));
	}

	private boolean shouldInvalidateBounds()
	{
		final Client client = clientProvider.get();
		final Widget chatbox = client.getWidget(WidgetInfo.CHATBOX_MESSAGES);
		final boolean resizeableChanged = isResizeable != client.isResized();
		boolean changed = false;

		if (resizeableChanged)
		{
			isResizeable = client.isResized();
			changed = true;
		}

		final boolean chatboxBoundsChanged = chatbox == null || !chatbox.getBounds().equals(chatboxBounds);

		if (chatboxBoundsChanged)
		{
			chatboxBounds = chatbox != null ? chatbox.getBounds() : new Rectangle();
			changed = true;
		}

		final boolean chatboxHiddenChanged = chatboxHidden != (chatbox == null || chatbox.isHidden());

		if (chatboxHiddenChanged)
		{
			chatboxHidden = chatbox == null || chatbox.isHidden();
			changed = true;
		}

		final boolean viewportChanged = !client.getViewportWidget().getBounds().equals(viewportBounds);

		if (viewportChanged)
		{
			viewportBounds = client.getViewportWidget().getBounds();
			changed = true;
		}

		return changed;
	}

	private OverlayBounds buildSnapCorners()
	{
		final Point topLeftPoint = new Point(
			isResizeable ? BORDER_LEFT_RESIZABLE : BORDER_LEFT_FIXED,
			isResizeable ? BORDER_TOP_RESIZABLE : BORDER_TOP_FIXED);

		final Point topRightPoint = new Point(
			viewportBounds.x + viewportBounds.width - BORDER_RIGHT,
			BORDER_TOP_FIXED);

		final Point bottomLeftPoint = new Point(
			isResizeable ? BORDER_LEFT_RESIZABLE : BORDER_LEFT_FIXED,
			viewportBounds.y + viewportBounds.height - BORDER_BOTTOM);

		final Point bottomRightPoint = new Point(
			viewportBounds.x + viewportBounds.width - BORDER_RIGHT,
			viewportBounds.y + viewportBounds.height - BORDER_BOTTOM);

		final Point rightChatboxPoint = new Point(
			viewportBounds.x + chatboxBounds.width - BORDER_RIGHT,
			viewportBounds.y + viewportBounds.height - BORDER_BOTTOM);

		// Check to see if chat box is minimized
		if (isResizeable && chatboxHidden)
		{
			rightChatboxPoint.y += chatboxBounds.height;
			bottomLeftPoint.y += chatboxBounds.height;
		}

		return new OverlayBounds(
			new Rectangle(topLeftPoint, SNAP_CORNER_SIZE),
			new Rectangle(topRightPoint, SNAP_CORNER_SIZE),
			new Rectangle(bottomLeftPoint, SNAP_CORNER_SIZE),
			new Rectangle(bottomRightPoint, SNAP_CORNER_SIZE),
			new Rectangle(rightChatboxPoint, SNAP_CORNER_SIZE));
	}
<<<<<<< HEAD
=======

	private void saveOverlayLocation(final Overlay overlay)
	{
		final String key = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		if (overlay.getPreferredLocation() != null)
		{
			configManager.setConfiguration(
				runeliteGroupName,
				key,
				overlay.getPreferredLocation());
		}
		else
		{
			configManager.unsetConfiguration(
				runeliteGroupName,
				key);
		}
	}

	private void saveOverlayPosition(final Overlay overlay)
	{
		final String key = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_POSITION;
		if (overlay.getPreferredPosition() != null)
		{
			configManager.setConfiguration(
				runeliteGroupName,
				key,
				overlay.getPreferredPosition());
		}
		else
		{
			configManager.unsetConfiguration(
				runeliteGroupName,
				key);
		}
	}

	private Point loadOverlayLocation(final Overlay overlay)
	{
		final String key = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		return configManager.getConfiguration(runeliteGroupName, key, Point.class);
	}

	private OverlayPosition loadOverlayPosition(final Overlay overlay)
	{
		final String locationKey = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_POSITION;
		return configManager.getConfiguration(runeliteGroupName, locationKey, OverlayPosition.class);
	}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
