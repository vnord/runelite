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

import com.google.common.base.Strings;
import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
=======
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
<<<<<<< HEAD
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.PluginErrorPanel;
=======
import net.runelite.client.plugins.hiscore.IconTextField;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;

<<<<<<< HEAD
/**
 * This panel holds the search section of the Grand Exchange Plugin.
 * It should display a search bar and either item results or a error panel.
 */
@Slf4j
class GrandExchangeSearchPanel extends JPanel
{
	private static final String ERROR_PANEL = "ERROR_PANEL";
	private static final String RESULTS_PANEL = "RESULTS_PANEL";

	private static final ImageIcon SEARCH_ICON;
	private static final ImageIcon LOADING_ICON;
	private static final ImageIcon ERROR_ICON;

	private final GridBagConstraints constraints = new GridBagConstraints();
	private final CardLayout cardLayout = new CardLayout();
=======
@Slf4j
class GrandExchangeSearchPanel extends JPanel
{
	private static final List<GrandExchangeItems> ITEMS_LIST = new ArrayList<>();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	private final Client client;
	private final ItemManager itemManager;
	private final ScheduledExecutorService executor;

<<<<<<< HEAD
	private final IconTextField searchBox = new IconTextField();

	/*  The main container, this holds the search bar and the center panel */
	private final JPanel container = new JPanel();

	/*  The results container, this will hold all the individual ge item panels */
	private final JPanel searchItemsPanel = new JPanel();

	/*  The center panel, this holds either the error panel or the results container */
	private final JPanel centerPanel = new JPanel(cardLayout);

	/*  The error panel, this displays an error message */
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	/*  The results wrapper, this scrolling panel wraps the results container */
	private JScrollPane resultsWrapper;

	private List<GrandExchangeItems> itemsList = new ArrayList<>();

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				SEARCH_ICON = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search_darker.png")));
				LOADING_ICON = new ImageIcon(IconTextField.class.getResource("loading_spinner.gif"));
				ERROR_ICON = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("error.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
=======
	private Icon search;

	private IconTextField searchBox = new IconTextField();
	private JPanel container = new JPanel();
	private JPanel searchItemsPanel = new JPanel();
	private JLabel searchingLabel = new JLabel();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	GrandExchangeSearchPanel(Client client, ItemManager itemManager, ScheduledExecutorService executor)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.executor = executor;
		init();
	}

	void init()
	{
		setLayout(new BorderLayout());
<<<<<<< HEAD
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		container.setLayout(new BorderLayout(5, 5));
		container.setBorder(new EmptyBorder(10, 10, 10, 10));
		container.setBackground(ColorScheme.DARK_GRAY_COLOR);

		searchBox.setPreferredSize(new Dimension(100, 30));
		searchBox.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
		searchBox.setHoverBackgroundColor(ColorScheme.MEDIUM_GRAY_COLOR.brighter());
		searchBox.setIcon(SEARCH_ICON);
		searchBox.addActionListener(e -> executor.execute(() -> priceLookup(false)));

		searchItemsPanel.setLayout(new GridBagLayout());
		searchItemsPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		/* This panel wraps the results panel and guarantees the scrolling behaviour */
		JPanel wrapper = new JPanel(new BorderLayout());
		wrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		wrapper.add(searchItemsPanel, BorderLayout.NORTH);

		resultsWrapper = new JScrollPane(wrapper);
		resultsWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		resultsWrapper.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		resultsWrapper.getVerticalScrollBar().setBorder(new EmptyBorder(0, 5, 0, 0));
		resultsWrapper.setVisible(false);

		/* This panel wraps the error panel and limits its height */
		JPanel errorWrapper = new JPanel(new BorderLayout());
		errorWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		errorWrapper.add(errorPanel, BorderLayout.NORTH);

		errorPanel.setContent("Grand Exchange Search",
			"Here you can search for an item by its name to find price information.");

		centerPanel.add(resultsWrapper, RESULTS_PANEL);
		centerPanel.add(errorWrapper, ERROR_PANEL);

		cardLayout.show(centerPanel, ERROR_PANEL);

		container.add(searchBox, BorderLayout.NORTH);
		container.add(centerPanel, BorderLayout.CENTER);

		add(container, BorderLayout.CENTER);
=======
		container.setLayout(new BorderLayout());

		// Search Box
		try
		{
			BufferedImage icon;
			synchronized (ImageIO.class)
			{
				icon = ImageIO.read(GrandExchangePlugin.class.getResourceAsStream("search.png"));
			}
			search = new ImageIcon(icon);
		}
		catch (IOException e)
		{
			log.warn("Failed to read icon", e);
		}

		searchBox.setIcon(search);
		searchBox.addActionListener(e -> executor.execute(() -> priceLookup(false)));

		container.add(searchBox, BorderLayout.NORTH);

		// Searching label
		searchingLabel.setHorizontalAlignment(JLabel.CENTER);
		searchingLabel.setForeground(Color.YELLOW);

		// Items Panel
		searchItemsPanel.setLayout(new GridLayout(0, 1, 0, 3));
		searchItemsPanel.setBorder(new EmptyBorder(3, 0, 0, 0));

		container.add(searchItemsPanel, BorderLayout.SOUTH);
		add(container, BorderLayout.NORTH);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	void priceLookup(String item)
	{
		searchBox.setText(item);
		executor.execute(() -> priceLookup(true));
	}

	private void priceLookup(boolean exactMatch)
	{
		String lookup = searchBox.getText();

		if (Strings.isNullOrEmpty(lookup))
		{
			searchItemsPanel.removeAll();
<<<<<<< HEAD
			SwingUtilities.invokeLater(searchItemsPanel::updateUI);
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			return;
		}

		// Input is not empty, add searching label
		searchItemsPanel.removeAll();
<<<<<<< HEAD
		searchBox.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
		searchBox.setEditable(false);
		searchBox.setIcon(LOADING_ICON);
=======
		showSearchString("Searching...");
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		SearchResult result;

		try
		{
			result = itemManager.searchForItem(lookup);
		}
<<<<<<< HEAD
		catch (Exception ex) // handle com.google.common.cache.CacheLoader$InvalidCacheLoadException
		{
			log.warn("Unable to search for item {}", lookup, ex);
			searchBox.setIcon(ERROR_ICON);
			searchBox.setEditable(true);
			errorPanel.setContent("Error fetching results", "An error occurred while trying to fetch item data, please try again later.");
			cardLayout.show(centerPanel, ERROR_PANEL);
			return;
		}

		itemsList.clear();

		if (result != null && !result.getItems().isEmpty())
		{
			cardLayout.show(centerPanel, RESULTS_PANEL);

=======
		catch (ExecutionException ex)
		{
			log.warn("Unable to search for item {}", lookup, ex);
			showSearchString("Error performing search");
			return;
		}


		if (result != null && !result.getItems().isEmpty())
		{
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			for (Item item : result.getItems())
			{
				int itemId = item.getId();

				ItemComposition itemComp = client.getItemDefinition(itemId);
				if (itemComp == null)
				{
					continue;
				}

<<<<<<< HEAD
				ItemPrice itemPrice = itemManager.getItemPrice(itemId);
				AsyncBufferedImage itemImage = itemManager.getImage(itemId);

				itemsList.add(new GrandExchangeItems(itemImage, item.getName(), itemId, itemPrice != null ? itemPrice.getPrice() : 0, itemComp.getPrice() * 0.6));
=======
				ItemPrice itemPrice = null;
				try
				{
					itemPrice = itemManager.getItemPrice(itemId);
				}
				catch (IOException ex)
				{
					log.warn("Unable to fetch item price for {}", itemId, ex);
				}

				AsyncBufferedImage itemImage = itemManager.getImage(itemId);

				ITEMS_LIST.add(new GrandExchangeItems(itemImage, item.getName(), itemId, itemPrice != null ? itemPrice.getPrice() : 0, itemComp.getPrice() * 0.6));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				// If using hotkey to lookup item, stop after finding match.
				if (exactMatch && item.getName().equalsIgnoreCase(lookup))
				{
					break;
				}
			}
		}
<<<<<<< HEAD
		else
		{
			searchBox.setIcon(ERROR_ICON);
			errorPanel.setContent("No results found.", "No items were found with that name, please try again.");
			cardLayout.show(centerPanel, ERROR_PANEL);
		}

		SwingUtilities.invokeLater(() ->
		{
			int index = 0;
			for (GrandExchangeItems item : itemsList)
			{
				GrandExchangeItemPanel panel = new GrandExchangeItemPanel(item.getIcon(), item.getName(),
					item.getItemId(), item.getGePrice(), item.getHaPrice());

				/*
				Add the first item directly, wrap the rest with margin. This margin hack is because
				gridbaglayout does not support inter-element margins.
				 */
				if (index++ > 0)
				{
					JPanel marginWrapper = new JPanel(new BorderLayout());
					marginWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
					marginWrapper.setBorder(new EmptyBorder(5, 0, 0, 0));
					marginWrapper.add(panel, BorderLayout.NORTH);
					searchItemsPanel.add(marginWrapper, constraints);
				}
				else
				{
					searchItemsPanel.add(panel, constraints);
				}
				
				constraints.gridy++;
			}

			// if exactMatch was set, then it came from the applet, so don't lose focus
			if (!exactMatch)
			{
				searchItemsPanel.requestFocusInWindow();
			}
			searchBox.setEditable(true);

			// Remove searching label after search is complete
			if (!itemsList.isEmpty())
			{
				searchBox.setIcon(SEARCH_ICON);
=======

		SwingUtilities.invokeLater(() ->
		{
			if (ITEMS_LIST.isEmpty())
			{
				showSearchString("No results found.");
			}
			else
			{
				for (GrandExchangeItems item : ITEMS_LIST)
				{
					GrandExchangeItemPanel panel = new GrandExchangeItemPanel(item.getIcon(), item.getName(),
						item.getItemId(), item.getGePrice(), item.getHaPrice());

					searchItemsPanel.add(panel);
				}

				// Remove searching label after search is complete
				showSearchString(null);
				ITEMS_LIST.clear();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		});
	}

<<<<<<< HEAD
}
=======
	private void showSearchString(String str)
	{
		if (str != null)
		{
			remove(searchingLabel);
			searchingLabel.setText(str);
			add(searchingLabel, BorderLayout.CENTER);
		}
		else
		{
			remove(searchingLabel);
		}

		revalidate();
		repaint();
	}
}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
