/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.bankvalue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
=======
import java.util.concurrent.CompletableFuture;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemComposition;
<<<<<<< HEAD
import net.runelite.api.ItemID;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import static net.runelite.api.ItemID.COINS_995;
import static net.runelite.api.ItemID.PLATINUM_TOKEN;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
<<<<<<< HEAD
import net.runelite.client.game.ItemMapping;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.util.QueryRunner;
import net.runelite.http.api.item.ItemPrice;

@Slf4j
class BankCalculation
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	private final QueryRunner queryRunner;
	private final BankValueConfig config;
	private final ItemManager itemManager;

	// Used to avoid extra calculation if the bank has not changed
	private int itemsHash;

	@Getter
	private long gePrice;

	@Getter
	private long haPrice;

<<<<<<< HEAD
=======
	@Getter
	private boolean finished;

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Inject
	BankCalculation(QueryRunner queryRunner, ItemManager itemManager, BankValueConfig config)
	{
		this.queryRunner = queryRunner;
		this.itemManager = itemManager;
		this.config = config;
	}

	/**
	 * Calculate the bank based on the cache, price can be 0 if bank not active, or cache not set
	 */
	void calculate()
	{
		WidgetItem[] widgetItems = queryRunner.runQuery(new BankItemQuery());

		if (widgetItems.length == 0 || !isBankDifferent(widgetItems))
		{
			return;
		}

		log.debug("Calculating new bank value...");

		gePrice = haPrice = 0;
<<<<<<< HEAD

=======
		finished = false;

		List<ItemComposition> itemCompositions = new ArrayList<>();
		Map<Integer, WidgetItem> itemMap = new HashMap<>();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		List<Integer> itemIds = new ArrayList<>();

		// Generate our lists (and do some quick price additions)
		for (WidgetItem widgetItem : widgetItems)
		{
<<<<<<< HEAD
			int quantity = widgetItem.getQuantity();

			if (widgetItem.getId() <= 0 || quantity == 0)
=======
			if (widgetItem.getId() <= 0 || widgetItem.getQuantity() == 0)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				continue;
			}

			if (widgetItem.getId() == COINS_995)
			{
<<<<<<< HEAD
				gePrice += quantity;
				haPrice += quantity;
=======
				gePrice += widgetItem.getQuantity();
				haPrice += widgetItem.getQuantity();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				continue;
			}

			if (widgetItem.getId() == PLATINUM_TOKEN)
			{
<<<<<<< HEAD
				gePrice += quantity * 1000L;
				haPrice += quantity * 1000L;
=======
				gePrice += widgetItem.getQuantity() * 1000L;
				haPrice += widgetItem.getQuantity() * 1000L;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				continue;
			}

			final ItemComposition itemComposition = itemManager.getItemComposition(widgetItem.getId());
<<<<<<< HEAD
=======
			itemCompositions.add(itemComposition);
			itemMap.put(widgetItem.getId(), widgetItem);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			if (config.showGE())
			{
				itemIds.add(widgetItem.getId());
			}
<<<<<<< HEAD

			if (config.showHA())
			{
				int price = itemComposition.getPrice();

				if (price > 0)
				{
					haPrice += (long) Math.round(price * HIGH_ALCHEMY_CONSTANT) *
						(long) quantity;
				}
			}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}

		// Now do the calculations
		if (config.showGE() && !itemIds.isEmpty())
		{
<<<<<<< HEAD
			for (WidgetItem widgetItem : widgetItems)
			{
				int itemId = widgetItem.getId();
				int quantity = widgetItem.getQuantity();

				if (itemId <= 0 || quantity == 0
					|| itemId == ItemID.COINS_995 || itemId == ItemID.PLATINUM_TOKEN)
				{
					continue;
				}

				long price = 0;
				for (int mappedItemId : ItemMapping.map(itemId))
				{
					ItemPrice cachedItemPrice = itemManager.getItemPrice(mappedItemId);
					if (cachedItemPrice == null)
					{
						// this happens to items which have no ge price
						continue;
					}

					price += cachedItemPrice.getPrice();
				}

				gePrice += price * quantity;
=======
			CompletableFuture<ItemPrice[]> future = itemManager.getItemPriceBatch(itemIds);
			future.whenComplete((ItemPrice[] itemPrices, Throwable ex) ->
			{
				if (ex != null)
				{
					log.debug("Error looking up item prices", ex);
					return;
				}

				if (itemPrices == null)
				{
					log.debug("Error looking up item prices");
					return;
				}

				log.debug("Price lookup is complete. {} prices.", itemPrices.length);

				try
				{
					for (ItemPrice itemPrice : itemPrices)
					{
						if (itemPrice.getItem() == null)
						{
							continue; // cached no price
						}

						gePrice += (long) itemPrice.getPrice() * (long) itemMap.get(itemPrice.getItem().getId()).getQuantity();
					}
				}
				catch (Exception ex2)
				{
					log.warn("error calculating price", ex2);
				}
				finally
				{
					finished = true;
				}
			});
		}
		else
		{
			finished = true;
		}

		if (config.showHA())
		{
			for (ItemComposition itemComposition : itemCompositions)
			{
				int price = itemComposition.getPrice();

				if (price > 0)
				{
					haPrice += (long) Math.round(price * HIGH_ALCHEMY_CONSTANT) *
						(long) itemMap.get(itemComposition.getId()).getQuantity();
				}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}
	}

	private boolean isBankDifferent(WidgetItem[] widgetItems)
	{
		Map<Integer, Integer> mapCheck = new HashMap<>();

		for (WidgetItem widgetItem : widgetItems)
		{
			mapCheck.put(widgetItem.getId(), widgetItem.getQuantity());
		}

		int curHash = mapCheck.hashCode();

		if (curHash != itemsHash)
		{
			itemsHash = curHash;
			return true;
		}

		return false;
	}
}
