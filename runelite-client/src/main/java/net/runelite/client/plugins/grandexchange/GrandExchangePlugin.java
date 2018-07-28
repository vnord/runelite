/*
 *
 * Copyright (c) 2017, Robbie <https://github.com/rbbi>
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
<<<<<<< HEAD
import java.util.concurrent.ScheduledExecutorService;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.ItemComposition;
<<<<<<< HEAD
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
=======
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
<<<<<<< HEAD
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.osbuddy.GrandExchangeClient;
import net.runelite.http.api.osbuddy.GrandExchangeResult;

@PluginDescriptor(
	name = "Grand Exchange",
	description = "Provide additional and/or easier access to Grand Exchange information",
	tags = {"external", "integration", "notifications", "panel", "prices", "trade"}
)
@Slf4j
public class GrandExchangePlugin extends Plugin
{
	private static final int OFFER_CONTAINER_ITEM = 21;
	private static final int OFFER_DEFAULT_ITEM_ID = 6512;
	private static final GrandExchangeClient CLIENT = new GrandExchangeClient();

	static final String SEARCH_GRAND_EXCHANGE = "Search Grand Exchange";

=======

@PluginDescriptor(
	name = "Grand Exchange"
)
public class GrandExchangePlugin extends Plugin
{
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Getter(AccessLevel.PACKAGE)
	private NavigationButton button;

	@Getter(AccessLevel.PACKAGE)
	private GrandExchangePanel panel;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	@Inject
	private GrandExchangeInputListener inputListener;

	@Inject
	private ItemManager itemManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private Client client;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private GrandExchangeConfig config;

<<<<<<< HEAD
	@Inject
	private Notifier notifier;

	@Inject
	private ScheduledExecutorService executorService;

	private Widget grandExchangeText;
	private Widget grandExchangeItem;

	private int lastItem = -1;

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Provides
	GrandExchangeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GrandExchangeConfig.class);
	}

	@Override
	protected void startUp() throws IOException
	{
		panel = injector.getInstance(GrandExchangePanel.class);

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("ge_icon.png"));
		}

		button = NavigationButton.builder()
<<<<<<< HEAD
			.tooltip("Grand Exchange")
			.icon(icon)
			.priority(3)
=======
			.name("GE Offers")
			.icon(icon)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			.panel(panel)
			.build();

		pluginToolbar.addNavigation(button);

		if (config.quickLookup())
		{
			mouseManager.registerMouseListener(inputListener);
			keyManager.registerKeyListener(inputListener);
		}
	}

	@Override
	protected void shutDown()
	{
		pluginToolbar.removeNavigation(button);
		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
	}

	@Subscribe
	public void onConfigChange(ConfigChanged event)
	{
		if (event.getGroup().equals("grandexchange"))
		{
			if (event.getKey().equals("quickLookup"))
			{
				if (config.quickLookup())
				{
					mouseManager.registerMouseListener(inputListener);
					keyManager.registerKeyListener(inputListener);
				}
				else
				{
					mouseManager.unregisterMouseListener(inputListener);
					keyManager.unregisterKeyListener(inputListener);
				}
			}
		}
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged offerEvent)
	{
		GrandExchangeOffer offer = offerEvent.getOffer();
		ItemComposition offerItem = itemManager.getItemComposition(offer.getItemId());
		boolean shouldStack = offerItem.isStackable() || offer.getTotalQuantity() > 1;
		BufferedImage itemImage = itemManager.getImage(offer.getItemId(), offer.getTotalQuantity(), shouldStack);
<<<<<<< HEAD
		SwingUtilities.invokeLater(() -> panel.getOffersPanel().updateOffer(offerItem, itemImage, offerEvent.getOffer(), offerEvent.getSlot()));
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!this.config.enableNotifications() || event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		String message = Text.removeTags(event.getMessage());

		if (message.startsWith("Grand Exchange:"))
		{
			this.notifier.notify(message);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			panel.getOffersPanel().resetOffers();
		}
=======
		SwingUtilities.invokeLater(() -> panel.updateOffer(offerItem, itemImage, offerEvent.getOffer(), offerEvent.getSlot()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		// At the moment, if the user disables quick lookup, the input listener gets disabled. Thus, isHotKeyPressed()
		// should always return false when quick lookup is disabled.
		// Replace the default option with "Search ..." when holding alt
		if (client.getGameState() != GameState.LOGGED_IN || !hotKeyPressed)
		{
			return;
		}

		final MenuEntry[] entries = client.getMenuEntries();
		final MenuEntry menuEntry = entries[entries.length - 1];
		final int widgetId = menuEntry.getParam1();
		final int groupId = WidgetInfo.TO_GROUP(widgetId);

		switch (groupId)
		{
			case WidgetID.BANK_GROUP_ID:
				// Don't show for view tabs and such
				if (WidgetInfo.TO_CHILD(widgetId) != WidgetInfo.BANK_ITEM_CONTAINER.getChildId())
				{
					break;
				}
			case WidgetID.INVENTORY_GROUP_ID:
			case WidgetID.BANK_INVENTORY_GROUP_ID:
<<<<<<< HEAD
			case WidgetID.GRAND_EXCHANGE_INVENTORY_GROUP_ID:
			case WidgetID.SHOP_INVENTORY_GROUP_ID:
				menuEntry.setOption(SEARCH_GRAND_EXCHANGE);
				menuEntry.setType(MenuAction.RUNELITE.getId());
=======
				menuEntry.setOption("Search Grand Exchange");
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				client.setMenuEntries(entries);
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			setHotKeyPressed(false);
		}
	}
<<<<<<< HEAD

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			// Grand exchange was opened.
			case WidgetID.GRAND_EXCHANGE_GROUP_ID:
				if (!config.enableOsbPrices())
				{
					return;
				}

				Widget grandExchangeOffer = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER);
				grandExchangeText = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TEXT);
				grandExchangeItem = grandExchangeOffer.getDynamicChildren()[OFFER_CONTAINER_ITEM];
				lastItem = -1;
				break;

			// Grand exchange was closed (if it was open before).
			case WidgetID.INVENTORY_GROUP_ID:
				grandExchangeText = null;
				grandExchangeItem = null;
				lastItem = -1;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (grandExchangeText == null || grandExchangeItem == null)
		{
			return;
		}

		int itemId = grandExchangeItem.getItemId();
		if (itemId == OFFER_DEFAULT_ITEM_ID
			|| itemId == -1
			|| lastItem == itemId)
		{
			return;
		}

		lastItem = itemId;
		final Widget geText = grandExchangeText;

		executorService.submit(() ->
		{
			try
			{
				final GrandExchangeResult result = CLIENT.lookupItem(itemId);

				if (result.getItem_id() != lastItem)
				{
					// something else has since been looked up?
					return;
				}

				final String text = geText.getText() + "<br>OSBuddy Actively traded price: " + StackFormatter.formatNumber(result.getOverall_average());
				geText.setText(text);
			}
			catch (IOException e)
			{
				log.debug("Error getting price of item {}", itemId, e);
			}
		});
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
