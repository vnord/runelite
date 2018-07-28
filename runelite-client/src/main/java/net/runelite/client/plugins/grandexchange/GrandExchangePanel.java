/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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
<<<<<<< HEAD
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
=======
import java.awt.image.BufferedImage;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@Slf4j
class GrandExchangePanel extends PluginPanel
{
<<<<<<< HEAD

	// this panel will hold either the ge search panel or the ge offers panel
	private final JPanel display = new JPanel();

	private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);
	private final MaterialTab searchTab;

	@Getter
	private GrandExchangeSearchPanel searchPanel;
	@Getter
	private GrandExchangeOffersPanel offersPanel;
=======
	private static final int MAX_OFFERS = 8;

	@Getter
	private GrandExchangeSearchPanel searchPanel;

	private GrandExchangeOfferSlot[] offerSlotPanels = new GrandExchangeOfferSlot[MAX_OFFERS];

	private JPanel offerPanel = new JPanel();

	private JTabbedPane tabbedPane = new JTabbedPane();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Inject
	GrandExchangePanel(Client client, ItemManager itemManager, ScheduledExecutorService executor)
	{
<<<<<<< HEAD
		super(false);

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);
=======
		setLayout(new BorderLayout());
		add(tabbedPane, BorderLayout.NORTH);

		// Offer Panel
		offerPanel.setLayout(new BoxLayout(offerPanel, BoxLayout.Y_AXIS));
		for (int i = 0; i < offerSlotPanels.length; ++i)
		{
			offerSlotPanels[i] = new GrandExchangeOfferSlot();
			offerPanel.add(offerSlotPanels[i]);
		}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		// Search Panel
		searchPanel = new GrandExchangeSearchPanel(client, itemManager, executor);

<<<<<<< HEAD
		//Offers Panel
		offersPanel = new GrandExchangeOffersPanel(client, itemManager, executor);

		MaterialTab offersTab = new MaterialTab("Offers", tabGroup, offersPanel);
		searchTab = new MaterialTab("Search", tabGroup, searchPanel);

		tabGroup.setBorder(new EmptyBorder(5, 0, 0, 0));
		tabGroup.addTab(offersTab);
		tabGroup.addTab(searchTab);
		tabGroup.select(offersTab); // selects the default selected tab

		add(tabGroup, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);
=======
		tabbedPane.addTab("Offers", offerPanel);
		tabbedPane.addTab("Search", searchPanel);
	}

	void updateOffer(ItemComposition item, BufferedImage itemImage, GrandExchangeOffer newOffer, int slot)
	{
		offerSlotPanels[slot].updateOffer(item, itemImage, newOffer);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	void showSearch()
	{
		if (searchPanel.isShowing())
		{
			return;
		}

<<<<<<< HEAD
		tabGroup.select(searchTab);
		revalidate();
	}
}
=======
		tabbedPane.setSelectedComponent(searchPanel);
		revalidate();
	}
}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
