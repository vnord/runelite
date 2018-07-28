/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.ui.overlay.components;

import java.awt.Color;
import java.awt.Dimension;
<<<<<<< HEAD
=======
import java.awt.FontMetrics;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import javax.annotation.Nullable;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import lombok.Getter;
import lombok.Setter;

public class PanelComponent implements LayoutableRenderableEntity
{
	public enum Orientation
	{
		HORIZONTAL,
		VERTICAL;
	}

	@Setter
<<<<<<< HEAD
	@Nullable
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;

	@Setter
	private Point preferredLocation = new Point();

	@Setter
=======
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;

	@Setter
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Getter
	private List<LayoutableRenderableEntity> children = new ArrayList<>();

	@Setter
	private Orientation orientation = Orientation.VERTICAL;

	@Setter
<<<<<<< HEAD
	private int wrapping = -1;

	@Setter
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private Rectangle border = new Rectangle(
		ComponentConstants.STANDARD_BORDER,
		ComponentConstants.STANDARD_BORDER,
		ComponentConstants.STANDARD_BORDER,
		ComponentConstants.STANDARD_BORDER);

	@Setter
	private Point gap = new Point(0, 0);

	private final Dimension childDimensions = new Dimension();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (children.isEmpty())
		{
			return null;
		}

<<<<<<< HEAD
		graphics.translate(preferredLocation.x, preferredLocation.y);

		// Calculate panel dimension
=======
		final FontMetrics metrics = graphics.getFontMetrics();

		// Render background
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		final Dimension dimension = new Dimension(
			border.x + childDimensions.width + border.width,
			border.y + childDimensions.height + border.height);

<<<<<<< HEAD
		// Render background
		if (backgroundColor != null)
		{
			final BackgroundComponent backgroundComponent = new BackgroundComponent();
			backgroundComponent.setRectangle(new Rectangle(dimension));
			backgroundComponent.setBackgroundColor(backgroundColor);
			backgroundComponent.render(graphics);
		}

		// Offset children
		final int baseX = border.x;
		final int baseY = border.y;
=======
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setRectangle(new Rectangle(dimension));
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.render(graphics);

		// Offset children
		final int baseX = border.x;
		final int baseY = border.y + metrics.getHeight();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		int width = 0;
		int height = 0;
		int x = baseX;
		int y = baseY;

		// Create child preferred size
		final Dimension childPreferredSize = new Dimension(
			preferredSize.width - border.x - border.width,
			preferredSize.height - border.y - border.height);

<<<<<<< HEAD
		// Calculate max width/height for infoboxes
		int totalHeight = 0;
		int totalWidth = 0;

		// Render all children
		for (int i = 0; i < children.size(); i ++)
		{
			final LayoutableRenderableEntity child = children.get(i);
			child.setPreferredLocation(new Point(x, y));
			child.setPreferredSize(childPreferredSize);
			final Dimension childDimension = child.render(graphics);
=======
		// Adjust preferred size of children based on orientation and children
		// sizes exceeding the parent size
		switch (orientation)
		{
			case VERTICAL:
				childPreferredSize.setSize(
					Math.max(childDimensions.width, childPreferredSize.width),
					childPreferredSize.height);
				break;
			case HORIZONTAL:
				childPreferredSize.setSize(
					childPreferredSize.width,
					Math.max(childDimensions.height, childPreferredSize.height));
				break;
		}

		// Render all children
		for (final LayoutableRenderableEntity child : children)
		{
			child.setPreferredSize(childPreferredSize);
			graphics.translate(x, y);
			final Dimension childDimension = child.render(graphics);
			graphics.translate(-x, -y);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			switch (orientation)
			{
				case VERTICAL:
					height += childDimension.height + gap.y;
					y = baseY + height;
					width = Math.max(width, childDimension.width);
					break;
				case HORIZONTAL:
					width += childDimension.width + gap.x;
					x = baseX + width;
					height = Math.max(height, childDimension.height);
					break;
			}
<<<<<<< HEAD

			// Calculate total size
			totalWidth = Math.max(totalWidth, width);
			totalHeight = Math.max(totalHeight, height);

			if (wrapping > 0 && i < children.size() - 1 && (i + 1)  % wrapping == 0)
			{
				switch (orientation)
				{
					case VERTICAL:
					{
						height = 0;
						y = baseY;
						int diff = childDimension.width + gap.x;
						x += diff;
						width += diff;
						break;
					}
					case HORIZONTAL:
					{
						width = 0;
						x = baseX;
						int diff = childDimension.height + gap.y;
						y += diff;
						height += diff;
						break;
					}
				}
			}
		}

		// Remove last child gap
		totalWidth -= gap.x;
		totalHeight -= gap.y;

		// Cache children bounds
		childDimensions.setSize(totalWidth, totalHeight);

		graphics.translate(-preferredLocation.x, -preferredLocation.y);
=======
		}

		// Remove last child gap
		width -= gap.x;
		height -= gap.y;

		// Cache children bounds
		childDimensions.setSize(width, height);

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		return dimension;
	}
}
