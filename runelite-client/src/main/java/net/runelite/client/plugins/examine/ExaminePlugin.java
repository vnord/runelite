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
package net.runelite.client.plugins.examine;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.eventbus.Subscribe;
<<<<<<< HEAD
=======
import com.google.inject.Provides;
import java.io.IOException;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
<<<<<<< HEAD
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ChatMessage;
=======
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.api.widgets.WidgetItem;
<<<<<<< HEAD
=======
import net.runelite.client.chat.ChatColor;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
<<<<<<< HEAD
=======
import net.runelite.client.config.ConfigManager;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.examine.ExamineClient;
import net.runelite.http.api.item.ItemPrice;

/**
 * Submits exammine info to the api
 *
 * @author Adam
 */
@PluginDescriptor(
<<<<<<< HEAD
	name = "Examine",
	description = "Send examine information to the API",
	tags = {"npcs", "items", "inventory", "objects"}
=======
	name = "Examine"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
)
@Slf4j
public class ExaminePlugin extends Plugin
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	private final ExamineClient examineClient = new ExamineClient();
	private final Deque<PendingExamine> pending = new ArrayDeque<>();
	private final Cache<CacheKey, Boolean> cache = CacheBuilder.newBuilder()
		.maximumSize(128L)
		.build();

	@Inject
	private Client client;

	@Inject
<<<<<<< HEAD
=======
	private ExamineConfig config;

	@Inject
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ScheduledExecutorService executor;

<<<<<<< HEAD
=======
	@Override
	protected void startUp()
	{
		cacheConfiguredColors();
		chatMessageManager.refreshAll();
	}

	@Provides
	ExamineConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExamineConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("examine"))
		{
			cacheConfiguredColors();
			chatMessageManager.refreshAll();
		}
	}

	private void cacheConfiguredColors()
	{
		chatMessageManager
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.getExamineRecolor(), false),
				ChatMessageType.EXAMINE_ITEM, ChatMessageType.EXAMINE_NPC, ChatMessageType.EXAMINE_OBJECT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.getExamineHRecolor(), false),
				ChatMessageType.EXAMINE_ITEM, ChatMessageType.EXAMINE_NPC, ChatMessageType.EXAMINE_OBJECT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.getTransparentExamineRecolor(), true),
				ChatMessageType.EXAMINE_ITEM, ChatMessageType.EXAMINE_NPC, ChatMessageType.EXAMINE_OBJECT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.getTransparentExamineHRecolor(), true),
				ChatMessageType.EXAMINE_ITEM, ChatMessageType.EXAMINE_NPC, ChatMessageType.EXAMINE_OBJECT);
	}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		pending.clear();
<<<<<<< HEAD
=======

		if (event.getGameState().equals(GameState.LOGIN_SCREEN))
		{
			cacheConfiguredColors();
		}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!event.getMenuOption().equals("Examine"))
		{
			return;
		}

		ExamineType type;
		int id;
		switch (event.getMenuAction())
		{
			case EXAMINE_ITEM:
				type = ExamineType.ITEM;
				id = event.getId();
				break;
			case EXAMINE_ITEM_BANK_EQ:
				type = ExamineType.ITEM_BANK_EQ;
				id = event.getId();
				break;
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
<<<<<<< HEAD
				id = event.getId();
=======
				id = event.getId() >>> 14;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				id = event.getId();
				break;
			default:
				return;
		}

		PendingExamine pendingExamine = new PendingExamine();
		pendingExamine.setWidgetId(event.getWidgetId());
		pendingExamine.setActionParam(event.getActionParam());
		pendingExamine.setType(type);
		pendingExamine.setId(id);
		pendingExamine.setCreated(Instant.now());
		pending.push(pendingExamine);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		ExamineType type;
		switch (event.getType())
		{
			case EXAMINE_ITEM:
				type = ExamineType.ITEM;
				break;
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				break;
			case SERVER:
				type = ExamineType.ITEM_BANK_EQ;
				break;
			default:
				return;
		}

		if (pending.isEmpty())
		{
			log.debug("Got examine without a pending examine?");
			return;
		}

		PendingExamine pendingExamine = pending.pop();

		if (pendingExamine.getType() != type)
		{
			log.debug("Type mismatch for pending examine: {} != {}", pendingExamine.getType(), type);
			pending.clear(); // eh
			return;
		}

		log.debug("Got examine for {} {}: {}", pendingExamine.getType(), pendingExamine.getId(), event.getMessage());

		findExamineItem(pendingExamine);
		CacheKey key = new CacheKey(type, pendingExamine.getId());
		Boolean cached = cache.getIfPresent(key);
		if (cached != null)
		{
			return;
		}

		cache.put(key, Boolean.TRUE);
<<<<<<< HEAD
		submitExamine(pendingExamine, event.getMessage());
=======
		executor.submit(() -> submitExamine(pendingExamine, event.getMessage()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	private void findExamineItem(PendingExamine pendingExamine)
	{
		int quantity = 1;
		int itemId = -1;

		// Get widget
		int widgetId = pendingExamine.getWidgetId();
		int widgetGroup = TO_GROUP(widgetId);
		int widgetChild = TO_CHILD(widgetId);
		Widget widget = client.getWidget(widgetGroup, widgetChild);

		if (widget == null)
		{
			return;
		}

		if (pendingExamine.getType() == ExamineType.ITEM)
		{
			WidgetItem widgetItem = widget.getWidgetItem(pendingExamine.getActionParam());
			quantity = widgetItem != null ? widgetItem.getQuantity() : 1;
			itemId = pendingExamine.getId();
		}
		else if (pendingExamine.getType() == ExamineType.ITEM_BANK_EQ)
		{
			if (WidgetInfo.EQUIPMENT.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(1);
				if (widgetItem != null)
				{
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup
					|| WidgetInfo.RUNE_POUCH_ITEM_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(pendingExamine.getActionParam());
				if (widgetItem != null)
				{
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget[] children = widget.getDynamicChildren();
				if (pendingExamine.getActionParam() < children.length)
				{
					Widget widgetItem = children[pendingExamine.getActionParam()];
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.SHOP_ITEMS_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget[] children = widget.getDynamicChildren();
				if (pendingExamine.getActionParam() < children.length)
				{
					Widget widgetItem = children[pendingExamine.getActionParam()];
					quantity = 1;
					itemId = widgetItem.getItemId();
				}
			}
		}

		if (itemId == -1)
		{
			return;
		}

		final int itemQuantity = quantity;
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);

		if (itemComposition != null)
		{
			executor.submit(() -> getItemPrice(itemComposition, itemQuantity));
		}
	}

	private void getItemPrice(ItemComposition itemComposition, int quantity)
	{
		// convert to unnoted id
		final boolean note = itemComposition.getNote() != -1;
		final int id = note ? itemComposition.getLinkedNoteId() : itemComposition.getId();

<<<<<<< HEAD
		ItemPrice itemPrice = itemManager.getItemPrice(id);
		if (itemPrice == null)
		{
=======
		ItemPrice itemPrice;
		try
		{
			itemPrice = itemManager.getItemPrice(id);
		}
		catch (IOException e)
		{
			log.warn("Error looking up item price", e);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			return;
		}

		int itemCompositionPrice = itemComposition.getPrice();
		final int gePrice = itemPrice == null ? 0 : itemPrice.getPrice();
		final int alchPrice = itemCompositionPrice <= 0 ? 0 : Math.round(itemCompositionPrice * HIGH_ALCHEMY_CONSTANT);

		if (gePrice > 0 || alchPrice > 0)
		{
			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT);

			if (quantity > 1)
			{
				message
					.append(StackFormatter.formatNumber(quantity))
					.append(" x ");
			}

			message
				.append(itemComposition.getName())
				.append(ChatColorType.NORMAL)
				.append(":");

			if (gePrice > 0)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" GE average ")
					.append(ChatColorType.HIGHLIGHT)
					.append(StackFormatter.formatNumber(gePrice * quantity));
			}

			if (quantity > 1)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" (")
					.append(ChatColorType.HIGHLIGHT)
					.append(StackFormatter.formatNumber(gePrice))
					.append(ChatColorType.NORMAL)
					.append("ea)");
			}

			if (alchPrice > 0)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" HA value ")
					.append(ChatColorType.HIGHLIGHT)
					.append(StackFormatter.formatNumber(alchPrice * quantity));
			}

			if (quantity > 1)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" (")
					.append(ChatColorType.HIGHLIGHT)
					.append(StackFormatter.formatNumber(alchPrice))
					.append(ChatColorType.NORMAL)
					.append("ea)");
			}

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.EXAMINE_ITEM)
				.runeLiteFormattedMessage(message.build())
				.build());
		}
	}

	private void submitExamine(PendingExamine examine, String text)
	{
		int id = examine.getId();

<<<<<<< HEAD
		switch (examine.getType())
		{
			case ITEM:
				examineClient.submitItem(id, text);
				break;
			case OBJECT:
				examineClient.submitObject(id, text);
				break;
			case NPC:
				examineClient.submitNpc(id, text);
				break;
=======
		try
		{
			switch (examine.getType())
			{
				case ITEM:
					examineClient.submitItem(id, text);
					break;
				case OBJECT:
					examineClient.submitObject(id, text);
					break;
				case NPC:
					examineClient.submitNpc(id, text);
					break;
			}
		}
		catch (IOException ex)
		{
			log.warn("Error submitting examine", ex);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

}
