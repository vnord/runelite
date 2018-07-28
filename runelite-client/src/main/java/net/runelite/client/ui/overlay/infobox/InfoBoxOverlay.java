/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.ui.overlay.infobox;

import com.google.common.base.Strings;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
<<<<<<< HEAD
import javax.inject.Singleton;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.Client;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

@Singleton
public class InfoBoxOverlay extends Overlay
{
	private final PanelComponent panelComponent = new PanelComponent();
=======
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

public class InfoBoxOverlay extends Overlay
{
	private static final int BOXSIZE = 35;
	private static final int SEPARATOR = 2;
	private static final int TOTAL_BOXSIZE = BOXSIZE + SEPARATOR;

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private final InfoBoxManager infoboxManager;
	private final TooltipManager tooltipManager;
	private final Provider<Client> clientProvider;
	private final RuneLiteConfig config;

	@Inject
<<<<<<< HEAD
	private InfoBoxOverlay(
		InfoBoxManager infoboxManager,
		TooltipManager tooltipManager,
		Provider<Client> clientProvider,
		RuneLiteConfig config)
	{
=======
	public InfoBoxOverlay(InfoBoxManager infoboxManager, TooltipManager tooltipManager, Provider<Client> clientProvider, RuneLiteConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		this.tooltipManager = tooltipManager;
		this.infoboxManager = infoboxManager;
		this.clientProvider = clientProvider;
		this.config = config;
<<<<<<< HEAD
		setPosition(OverlayPosition.TOP_LEFT);

		panelComponent.setBackgroundColor(null);
		panelComponent.setBorder(new Rectangle());
		panelComponent.setGap(new Point(1, 1));
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
<<<<<<< HEAD
		final List<InfoBox> infoBoxes = infoboxManager.getInfoBoxes();
=======
		List<InfoBox> infoBoxes = infoboxManager.getInfoBoxes();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		if (infoBoxes.isEmpty())
		{
			return null;
		}

<<<<<<< HEAD
		panelComponent.getChildren().clear();
		panelComponent.setWrapping(config.infoBoxWrap());
		panelComponent.setOrientation(config.infoBoxVertical()
			? PanelComponent.Orientation.VERTICAL
			: PanelComponent.Orientation.HORIZONTAL);
		panelComponent.setPreferredSize(new Dimension(config.infoBoxSize(), config.infoBoxSize()));
=======
		int wrap = config.infoBoxWrap();
		int infoBoxCount = infoBoxes.size();
		boolean vertical = config.infoBoxVertical();

		int width, height;
		if (!vertical)
		{
			width = getWidth(infoBoxCount, wrap);
			height = getHeight(infoBoxCount, wrap);
		}
		else
		{
			width = getHeight(infoBoxCount, wrap);
			height = getWidth(infoBoxCount, wrap);
		}

		int x = 0;
		int y = 0;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		for (InfoBox box : infoBoxes)
		{
			if (!box.render())
			{
				continue;
			}

<<<<<<< HEAD
			final InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
			infoBoxComponent.setColor(box.getTextColor());
			infoBoxComponent.setImage(box.getScaledImage());
			infoBoxComponent.setText(box.getText());
			infoBoxComponent.setTooltip(box.getTooltip());
			panelComponent.getChildren().add(infoBoxComponent);
		}

		final Dimension dimension = panelComponent.render(graphics);
		final Client client = clientProvider.get();

		// Handle tooltips
		if (client != null)
		{
			final Point mouse = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());

			for (final LayoutableRenderableEntity child : panelComponent.getChildren())
			{
				if (child instanceof InfoBoxComponent)
				{
					final InfoBoxComponent component = (InfoBoxComponent) child;

					if (!Strings.isNullOrEmpty(component.getTooltip()))
					{
						final Rectangle intersectionRectangle = new Rectangle(component.getPreferredLocation(), component.getPreferredSize());

						// Move the intersection based on overlay position
						intersectionRectangle.translate(getBounds().x, getBounds().y);

						// Move the intersection based on overlay "orientation"
						final Point transformed = OverlayUtil.transformPosition(getPosition(), intersectionRectangle.getSize());
						intersectionRectangle.translate(transformed.x, transformed.y);

						if (intersectionRectangle.contains(mouse))
						{
							tooltipManager.add(new Tooltip(component.getTooltip()));
						}
					}
=======

			final InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
			infoBoxComponent.setColor(box.getTextColor());
			infoBoxComponent.setImage(box.getImage());
			infoBoxComponent.setText(box.getText());
			infoBoxComponent.setPosition(new Point(x, y));
			final Dimension infoBoxBounds = infoBoxComponent.render(graphics);

			if (!Strings.isNullOrEmpty(box.getTooltip()))
			{
				final Rectangle intersectionRectangle = new Rectangle(infoBoxBounds);
				intersectionRectangle.setLocation(getBounds().getLocation());
				intersectionRectangle.translate(x, y);
				final Point transformed = OverlayUtil.transformPosition(getPosition(), intersectionRectangle.getSize());
				intersectionRectangle.translate(transformed.x, transformed.y);

				final Client client = clientProvider.get();

				if (client != null && intersectionRectangle.contains(new Point(client.getMouseCanvasPosition().getX(),
					client.getMouseCanvasPosition().getY())))
				{
					tooltipManager.add(new Tooltip(box.getTooltip()));
				}
			}

			// Determine which axis to reset/increase
			if (vertical)
			{
				// Reset y if newbox reaches height limit
				if (y + TOTAL_BOXSIZE < height)
				{
					y += TOTAL_BOXSIZE;
				}
				else
				{
					y = 0;
					x += TOTAL_BOXSIZE;
				}
			}
			else
			{
				// Reset x if newbox reaches width limit
				if (x + TOTAL_BOXSIZE < width)
				{
					x += TOTAL_BOXSIZE;
				}
				else
				{
					x = 0;
					y += TOTAL_BOXSIZE;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				}
			}
		}

<<<<<<< HEAD
		return dimension;
=======
		return new Dimension(width, height);
	}

	private static int getHeight(int infoBoxCount, int maxRow)
	{
		return maxRow == 0 ? TOTAL_BOXSIZE : (int) Math.ceil((double)infoBoxCount / maxRow) * TOTAL_BOXSIZE;
	}

	private static int getWidth(int infoBoxCount, int maxRow)
	{
		return maxRow == 0 ? infoBoxCount * TOTAL_BOXSIZE : (maxRow > infoBoxCount ? infoBoxCount : maxRow) * TOTAL_BOXSIZE;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
