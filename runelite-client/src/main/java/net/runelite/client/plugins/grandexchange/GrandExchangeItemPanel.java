/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
<<<<<<< HEAD
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.grandexchange;

import java.awt.BorderLayout;
import java.awt.Color;
<<<<<<< HEAD
import java.awt.Component;
import java.awt.Cursor;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
=======
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import lombok.extern.slf4j.Slf4j;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.StackFormatter;

<<<<<<< HEAD
/**
 * This panel displays an individual item result in the
 * Grand Exchange search plugin.
 */
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
@Slf4j
class GrandExchangeItemPanel extends JPanel
{
	private static final Dimension ICON_SIZE = new Dimension(32, 32);

	GrandExchangeItemPanel(AsyncBufferedImage icon, String name, int itemID, int gePrice, Double
		haPrice)
	{
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		setLayout(layout);
		setToolTipText(name);
<<<<<<< HEAD
		setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
		
=======

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		Color background = getBackground();

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
<<<<<<< HEAD
				setBackground(background.brighter());
				for (Component component : getComponents())
				{
					component.setBackground(component.getBackground().brighter());
				}
				setCursor(new Cursor(Cursor.HAND_CURSOR));
=======
				setBackground(getBackground().darker().darker());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				setBackground(background);
<<<<<<< HEAD
				for (Component component : getComponents())
				{
					component.setBackground(background);
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				geLink(name, itemID);
			}
		});

<<<<<<< HEAD
		setBorder(new EmptyBorder(5, 5, 5, 0));
=======
		setBorder(new CompoundBorder
		(
			new LineBorder(getBackground().brighter(), 1),
			new EmptyBorder(5, 5, 5, 5)
		));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		// Icon
		JLabel itemIcon = new JLabel();
		itemIcon.setPreferredSize(ICON_SIZE);
		if (icon != null)
		{
			icon.addTo(itemIcon);
		}
		add(itemIcon, BorderLayout.LINE_START);

		// Item details panel
		JPanel rightPanel = new JPanel(new GridLayout(3, 1));
<<<<<<< HEAD
		rightPanel.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);

		// Item name
		JLabel itemName = new JLabel();
		itemName.setForeground(Color.WHITE);
		itemName.setMaximumSize(new Dimension(0, 0));        // to limit the label's size for
		itemName.setPreferredSize(new Dimension(0, 0));    // items with longer names
=======
		rightPanel.setOpaque(false);

		// Item name
		JLabel itemName = new JLabel();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		itemName.setText(name);
		rightPanel.add(itemName);

		// Ge price
		JLabel gePriceLabel = new JLabel();
		if (gePrice > 0)
		{
			gePriceLabel.setText(StackFormatter.formatNumber(gePrice) + " gp");
		}
		else
		{
			gePriceLabel.setText("N/A");
		}
<<<<<<< HEAD
		gePriceLabel.setForeground(ColorScheme.GRAND_EXCHANGE_PRICE);
=======
		gePriceLabel.setForeground(Color.GREEN);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		rightPanel.add(gePriceLabel);

		// Alch price
		JLabel haPriceLabel = new JLabel();
		haPriceLabel.setText(StackFormatter.formatNumber(haPrice.intValue()) + " alch");
<<<<<<< HEAD
		haPriceLabel.setForeground(ColorScheme.GRAND_EXCHANGE_ALCH);
=======
		haPriceLabel.setForeground(Color.orange);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		rightPanel.add(haPriceLabel);

		add(rightPanel, BorderLayout.CENTER);
	}

	private void geLink(String name, int itemID)
	{
		final String url = "http://services.runescape.com/m=itemdb_oldschool/"
			+ name.replaceAll(" ", "_")
			+ "/viewitem?obj="
			+ itemID;

		LinkBrowser.browse(url);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
