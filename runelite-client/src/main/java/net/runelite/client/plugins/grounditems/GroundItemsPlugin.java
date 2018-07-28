/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.grounditems;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
<<<<<<< HEAD
=======
import com.google.common.collect.Lists;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.Boolean.TRUE;
<<<<<<< HEAD
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.ItemLayer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Node;
<<<<<<< HEAD
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.api.events.ItemSpawned;
=======
import net.runelite.api.Player;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemLayerChanged;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.grounditems.config.ItemHighlightMode.OVERLAY;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.BOTH;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.NAME;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.OPTION;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.item.ItemPrice;

@PluginDescriptor(
	name = "Ground Items",
	description = "Highlight ground items and/or show price information",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "highlight", "overlay"}
=======
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.http.api.item.ItemPrice;

@PluginDescriptor(
	name = "Ground Items"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
)
@Slf4j
public class GroundItemsPlugin extends Plugin
{
<<<<<<< HEAD
	private static final Splitter COMMA_SPLITTER = Splitter
		.on(",")
		.omitEmptyStrings()
		.trimResults();

	private static final Joiner COMMA_JOINER = Joiner.on(",").skipNulls();
=======
	//Size of one region
	private static final int REGION_SIZE = 104;
	// The max distance in tiles between the player and the item.
	private static final int MAX_RANGE = 18;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	// Used when getting High Alchemy value - multiplied by general store price.
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	// ItemID for coins
	private static final int COINS = ItemID.COINS_995;

	@Getter(AccessLevel.PACKAGE)
<<<<<<< HEAD
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> textBoxBounds;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> hiddenBoxBounds;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> highlightBoxBounds;
=======
	private final Map<Rectangle, String> hiddenBoxes = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final Map<Rectangle, String> highlightBoxes = new HashMap<>();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

<<<<<<< HEAD
	private List<String> hiddenItemList = new CopyOnWriteArrayList<>();
	private List<String> highlightedItemsList = new CopyOnWriteArrayList<>();
=======
	private List<String> hiddenItemList = new ArrayList<>();
	private List<String> highlightedItemsList = new ArrayList<>();
	private boolean dirty;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Inject
	private GroundItemInputListener inputListener;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
<<<<<<< HEAD
	private OverlayManager overlayManager;

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private GroundItemsConfig config;

	@Inject
	private GroundItemsOverlay overlay;

	@Getter
	private final Map<GroundItem.GroundItemKey, GroundItem> collectedGroundItems = new LinkedHashMap<>();
<<<<<<< HEAD
	private final Map<Integer, Color> priceChecks = new LinkedHashMap<>();
	private LoadingCache<String, Boolean> highlightedItems;
	private LoadingCache<String, Boolean> hiddenItems;

=======
	private final List<GroundItem> groundItems = new ArrayList<>();
	private LoadingCache<String, Boolean> highlightedItems;
	private LoadingCache<String, Boolean> hiddenItems;

	// Collects similar ground items
	private final Collector<GroundItem, ?, Map<GroundItem.GroundItemKey, GroundItem>> groundItemMapCollector = Collectors
		.toMap
			((item) -> new GroundItem.GroundItemKey(item.getItemId(), item.getLocation()), Function.identity(), (a, b) ->
				{
					b.setHaPrice(a.getHaPrice() + b.getHaPrice());
					b.setGePrice(a.getGePrice() + b.getGePrice());
					b.setQuantity(a.getQuantity() + b.getQuantity());
					return b;
				},
				() -> collectedGroundItems);

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Provides
	GroundItemsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundItemsConfig.class);
	}

	@Override
<<<<<<< HEAD
	protected void startUp()
	{
		overlayManager.add(overlay);
=======
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	protected void startUp()
	{
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		reset();
		mouseManager.registerMouseListener(inputListener);
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
<<<<<<< HEAD
		overlayManager.remove(overlay);
		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
=======
		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
		groundItems.clear();
		collectedGroundItems.clear();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		highlightedItems.invalidateAll();
		highlightedItems = null;
		hiddenItems.invalidateAll();
		hiddenItems = null;
		hiddenItemList = null;
		highlightedItemsList = null;
<<<<<<< HEAD
		collectedGroundItems.clear();
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("grounditems"))
		{
			reset();
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
<<<<<<< HEAD
		if (event.getGameState() == GameState.LOADING)
		{
			collectedGroundItems.clear();
=======
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			dirty = true;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Subscribe
<<<<<<< HEAD
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		Item item = itemSpawned.getItem();
		Tile tile = itemSpawned.getTile();

		GroundItem groundItem = buildGroundItem(tile, item);

		GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), tile.getWorldLocation());
		GroundItem existing = collectedGroundItems.putIfAbsent(groundItemKey, groundItem);
		if (existing != null)
		{
			existing.setQuantity(existing.getQuantity() + groundItem.getQuantity());
		}
	}

	@Subscribe
	public void onItemDespawned(ItemDespawned itemDespawned)
	{
		Item item = itemDespawned.getItem();
		Tile tile = itemDespawned.getTile();

		GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), tile.getWorldLocation());
		GroundItem groundItem = collectedGroundItems.get(groundItemKey);
		if (groundItem == null)
=======
	public void onItemLayerChanged(ItemLayerChanged event)
	{
		dirty = true;
	}

	void checkItems()
	{
		final Player player = client.getLocalPlayer();

		if (!dirty || player == null || client.getViewportWidget() == null)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			return;
		}

<<<<<<< HEAD
		if (groundItem.getQuantity() <= item.getQuantity())
		{
			collectedGroundItems.remove(groundItemKey);
		}
		else
		{
			groundItem.setQuantity(groundItem.getQuantity() - item.getQuantity());
		}
	}

	@Subscribe
	public void onItemQuantityChanged(ItemQuantityChanged itemQuantityChanged)
	{
		Item item = itemQuantityChanged.getItem();
		Tile tile = itemQuantityChanged.getTile();
		int oldQuantity = itemQuantityChanged.getOldQuantity();
		int newQuantity = itemQuantityChanged.getNewQuantity();

		int diff = newQuantity - oldQuantity;
		GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), tile.getWorldLocation());
		GroundItem groundItem = collectedGroundItems.get(groundItemKey);
		if (groundItem != null)
		{
			groundItem.setQuantity(groundItem.getQuantity() + diff);
		}
	}

=======
		dirty = false;

		final Region region = client.getRegion();
		final Tile[][][] tiles = region.getTiles();
		final int z = client.getPlane();
		final LocalPoint from = player.getLocalLocation();

		final int lowerX = Math.max(0, from.getRegionX() - MAX_RANGE);
		final int lowerY = Math.max(0, from.getRegionY() - MAX_RANGE);

		final int upperX = Math.min(from.getRegionX() + MAX_RANGE, REGION_SIZE - 1);
		final int upperY = Math.min(from.getRegionY() + MAX_RANGE, REGION_SIZE - 1);

		groundItems.clear();

		for (int x = lowerX; x <= upperX; ++x)
		{
			for (int y = lowerY; y <= upperY; ++y)
			{
				Tile tile = tiles[z][x][y];
				if (tile == null)
				{
					continue;
				}

				ItemLayer itemLayer = tile.getItemLayer();
				if (itemLayer == null)
				{
					continue;
				}

				Node current = itemLayer.getBottom();

				// adds the items on the ground to the ArrayList to be drawn
				while (current instanceof Item)
				{
					final Item item = (Item) current;

					// Continue iteration
					current = current.getNext();

					// Build ground item
					final GroundItem groundItem = buildGroundItem(tile, item);

					if (groundItem != null)
					{
						groundItem.setHeight(itemLayer.getHeight());
						groundItems.add(groundItem);
					}
				}
			}
		}

		// Group ground items together and sort them properly
		collectedGroundItems.clear();
		Lists.reverse(groundItems).stream().collect(groundItemMapCollector);
	}

	@Nullable
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private GroundItem buildGroundItem(final Tile tile, final Item item)
	{
		// Collect the data for the item
		final int itemId = item.getId();
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;
		final int alchPrice = Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT);

		final GroundItem groundItem = GroundItem.builder()
			.id(itemId)
			.location(tile.getWorldLocation())
			.itemId(realItemId)
			.quantity(item.getQuantity())
			.name(itemComposition.getName())
<<<<<<< HEAD
			.haPrice(alchPrice)
			.height(tile.getItemLayer().getHeight())
			.tradeable(itemComposition.isTradeable())
=======
			.haPrice(alchPrice * item.getQuantity())
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			.build();


		// Update item price in case it is coins
		if (realItemId == COINS)
		{
<<<<<<< HEAD
			groundItem.setHaPrice(1);
			groundItem.setGePrice(1);
		}
		else
		{
			final ItemPrice itemPrice = itemManager.getItemPrice(realItemId);
			if (itemPrice != null)
			{
				groundItem.setGePrice(itemPrice.getPrice());
			}
=======
			groundItem.setHaPrice(groundItem.getQuantity());
			groundItem.setGePrice(groundItem.getQuantity());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}

		return groundItem;
	}

	private void reset()
	{
<<<<<<< HEAD
		// gets the hidden items from the text box in the config
		hiddenItemList = COMMA_SPLITTER.splitToList(config.getHiddenItems());

		// gets the highlighted items from the text box in the config
		highlightedItemsList = COMMA_SPLITTER.splitToList(config.getHighlightItems());
=======
		Splitter COMMA_SPLITTER = Splitter.on(Pattern.compile("\\s*,\\s*"));

		// gets the hidden items from the text box in the config
		hiddenItemList = COMMA_SPLITTER.splitToList(config.getHiddenItems().trim());

		// gets the highlighted items from the text box in the config
		highlightedItemsList = COMMA_SPLITTER.splitToList(config.getHighlightItems().trim());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		highlightedItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(highlightedItemsList));

		hiddenItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(hiddenItemList));

<<<<<<< HEAD
		// Cache colors
		priceChecks.clear();

		if (config.insaneValuePrice() > 0)
		{
			priceChecks.put(config.insaneValuePrice(), config.insaneValueColor());
		}

		if (config.highValuePrice() > 0)
		{
			priceChecks.put(config.highValuePrice(), config.highValueColor());
		}

		if (config.mediumValuePrice() > 0)
		{
			priceChecks.put(config.mediumValuePrice(), config.mediumValueColor());
		}

		if (config.lowValuePrice() > 0)
		{
			priceChecks.put(config.lowValuePrice(), config.lowValueColor());
		}

		if (config.getHighlightOverValue() > 0)
		{
			priceChecks.put(config.getHighlightOverValue(), config.highlightedColor());
=======
		dirty = true;
	}

	private ItemPrice getItemPrice(ItemComposition itemComposition)
	{
		if (itemComposition.getNote() != -1)
		{
			return itemManager.getItemPriceAsync(itemComposition.getLinkedNoteId());
		}
		else
		{
			return itemManager.getItemPriceAsync(itemComposition.getId());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (config.itemHighlightMode() != OVERLAY
			&& event.getOption().equals("Take")
			&& event.getType() == MenuAction.GROUND_ITEM_THIRD_OPTION.getId())
		{
			int itemId = event.getIdentifier();
<<<<<<< HEAD
			Scene scene = client.getScene();
			Tile tile = scene.getTiles()[client.getPlane()][event.getActionParam0()][event.getActionParam1()];
			ItemLayer itemLayer = tile.getItemLayer();

=======
			ItemComposition itemComposition = client.getItemDefinition(itemId);

			if (isHidden(itemComposition.getName()))
			{
				return;
			}

			Region region = client.getRegion();
			Tile tile = region.getTiles()[client.getPlane()][event.getActionParam0()][event.getActionParam1()];
			ItemLayer itemLayer = tile.getItemLayer();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			if (itemLayer == null)
			{
				return;
			}

			MenuEntry[] menuEntries = client.getMenuEntries();
			MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

			int quantity = 1;
			Node current = itemLayer.getBottom();
<<<<<<< HEAD

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			while (current instanceof Item)
			{
				Item item = (Item) current;
				if (item.getId() == itemId)
				{
					quantity = item.getQuantity();
				}
				current = current.getNext();
			}

<<<<<<< HEAD
			final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
			final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemComposition.getId();
			final ItemPrice itemPrice = itemManager.getItemPrice(realItemId);
			final int price = itemPrice == null ? itemComposition.getPrice() : itemPrice.getPrice();
			final int haPrice = Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT) * quantity;
			final int gePrice = quantity * price;
			final Color hidden = getHidden(itemComposition.getName(), gePrice, haPrice, itemComposition.isTradeable());
			final Color highlighted = getHighlighted(itemComposition.getName(), gePrice, haPrice);
			final Color color = getItemColor(highlighted, hidden);
			final boolean canBeRecolored = highlighted != null || (hidden != null && config.recolorMenuHiddenItems());

			if (color != null && canBeRecolored && !color.equals(config.defaultColor()))
=======
			ItemPrice itemPrice = getItemPrice(itemComposition);
			int price = itemPrice == null ? itemComposition.getPrice() : itemPrice.getPrice();
			int cost = quantity * price;
			Color color = overlay.getCostColor(cost, isHighlighted(itemComposition.getName()),
				isHidden(itemComposition.getName()));

			if (!color.equals(config.defaultColor()))
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				String hexColor = Integer.toHexString(color.getRGB() & 0xFFFFFF);
				String colTag = "<col=" + hexColor + ">";
				final MenuHighlightMode mode = config.menuHighlightMode();

				if (mode == BOTH || mode == OPTION)
				{
					lastEntry.setOption(colTag + "Take");
				}

				if (mode == BOTH || mode == NAME)
				{
					String target = lastEntry.getTarget().substring(lastEntry.getTarget().indexOf(">") + 1);
					lastEntry.setTarget(colTag + target);
				}
			}

			if (config.showMenuItemQuantities() && itemComposition.isStackable() && quantity > 1)
			{
				lastEntry.setTarget(lastEntry.getTarget() + " (" + quantity + ")");
			}

			client.setMenuEntries(menuEntries);
		}
	}

	void updateList(String item, boolean hiddenList)
	{
<<<<<<< HEAD
		final Set<String> hiddenItemSet = new HashSet<>(hiddenItemList);
		final Set<String> highlightedItemSet = new HashSet<>(highlightedItemsList);

		if (hiddenList)
		{
			highlightedItemSet.removeIf(item::equalsIgnoreCase);
		}
		else
		{
			hiddenItemSet.removeIf(item::equalsIgnoreCase);
		}

		final Set<String> items = hiddenList ? hiddenItemSet : highlightedItemSet;

		if (!items.removeIf(item::equalsIgnoreCase))
=======
		List<String> items = new ArrayList<>((hiddenList) ? hiddenItemList : highlightedItemsList);

		items.removeIf(s -> s.isEmpty());
		if (!items.removeIf(s -> s.equalsIgnoreCase(item)))
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			items.add(item);
		}

<<<<<<< HEAD
		config.setHiddenItems(COMMA_JOINER.join(hiddenItemSet));
		config.setHighlightedItem(COMMA_JOINER.join(highlightedItemSet));
	}

	Color getHighlighted(String item, int gePrice, int haPrice)
	{
		if (TRUE.equals(highlightedItems.getUnchecked(item)))
		{
			return config.highlightedColor();
		}

		// Explicit hide takes priority over implicit highlight
		if (TRUE.equals(hiddenItems.getUnchecked(item)))
		{
			return null;
		}

		for (Map.Entry<Integer, Color> entry : priceChecks.entrySet())
		{
			if (gePrice > entry.getKey() || haPrice > entry.getKey())
			{
				return entry.getValue();
			}
		}

		return null;
	}

	Color getHidden(String item, int gePrice, int haPrice, boolean isTradeable)
	{
		final boolean isExplicitHidden = TRUE.equals(hiddenItems.getUnchecked(item));
		final boolean isExplicitHighlight = TRUE.equals(highlightedItems.getUnchecked(item));
		final boolean canBeHidden = gePrice > 0 || isTradeable || !config.dontHideUntradeables();
		final boolean underGe = gePrice < config.getHideUnderValue();
		final boolean underHa = haPrice < config.getHideUnderValue();

		// Explicit highlight takes priority over implicit hide
		return isExplicitHidden || (!isExplicitHighlight && canBeHidden && underGe && underHa)
			? config.hiddenColor()
			: null;
	}

	Color getItemColor(Color highlighted, Color hidden)
	{
		if (highlighted != null)
		{
			return highlighted;
		}

		if (hidden != null)
		{
			return hidden;
		}

		return config.defaultColor();
=======
		String newList = Joiner.on(", ").join(items);
		// This triggers the config update which updates the list
		if (hiddenList)
		{
			config.setHiddenItems(newList);
		}
		else
		{
			config.setHighlightedItem(newList);
		}
	}

	public boolean isHighlighted(String item)
	{
		return TRUE.equals(highlightedItems.getUnchecked(item));
	}

	public boolean isHidden(String item)
	{
		return TRUE.equals(hiddenItems.getUnchecked(item));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			setHotKeyPressed(false);
		}
	}
}
