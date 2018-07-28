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
package net.runelite.api;

<<<<<<< HEAD
/**
 * Represents the template of a specific item type.
 */
public interface ItemComposition
{
	/**
	 * Gets the items name.
=======
public interface ItemComposition
{
	/**
	 * Returns the item's name as a string.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @return the name of the item
	 */
	String getName();

	/**
<<<<<<< HEAD
	 * Gets the items ID.
	 *
	 * @return the items ID
	 * @see ItemID
=======
	 * Returns the item's ID. A list of item IDs can be found in
	 * ItemID.
	 *
	 * @return the item's ID as an integer
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	int getId();

	/**
<<<<<<< HEAD
	 * Gets a value specifying whether the item is noted.
	 *
	 * @return 799 if noted, -1 otherwise
=======
	 * Returns a result that depends on whether the item is in noted form or
	 * not.
	 *
	 * @return 799 if noted, -1 if unnoted
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	int getNote();

	/**
<<<<<<< HEAD
	 * Gets the item ID of the noted or unnoted variant of this item.
	 * <p>
	 * Calling this method on a noted item will result in the ID of itself
	 * in unnoted form, and on an unnoted item its noted variant.
	 *
	 * @return the noted or unnoted variant of this item
=======
	 * Returns the item ID of the noted/unnoted counterpart. For example, if
	 * you call this on an unnoted monkfish(ID 7946), this method will
	 * return the ID of a noted monkfish(ID 7947), and vice versa.
	 *
	 * @return the ID that is linked to this item in noted/unnoted form.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	int getLinkedNoteId();

	/**
<<<<<<< HEAD
	 * Gets the item ID of the normal or placeholder variant of this item.
	 * <p>
	 * Calling this method on a normal item will result in the ID of itself
	 * in placeholder form, and on a placeholder item its normal variant.
	 *
	 * @return the normal or placeholder variant of this item
=======
	 * Returns the item ID of the normal/placeholder counterpart. For example, if
	 * you call this on a monkfish(ID 7946), this method will
	 * return the ID of a placeholder monkfish(ID 17065), and vice versa.
	 *
	 * @return the ID that is linked to this item in normal/placeholder form.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	int getPlaceholderId();

	/**
<<<<<<< HEAD
	 * Gets a value specifying whether the item is a placeholder.
	 *
	 * @return 14401 if placeholder, -1 otherwise
=======
	 * Returns a result that depends on whether the item is in placeholder form or
	 * not.
	 *
	 * @return 14401 if placeholder, -1 if normal
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	int getPlaceholderTemplateId();

	/**
<<<<<<< HEAD
	 * Gets the store price of the item.
	 * <p>
	 * Although not all items can be found in a store, they have a store price
	 * which can be used to calculate high and low alchemy values. Multiplying
	 * the price by {@code 0.6} and {@code 0.4} gives these high and low
	 * alchemy values, respectively.
=======
	 * Returns the store price of the item. Even if the item cannot be found
	 * in a store, all items have a store price from which the High and Low
	 * Alchemy values are calculated. Multiply the price by 0.6 to get the
	 * High Alchemy value, or 0.4 to get the Low Alchemy value.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @return the general store value of the item
	 */
	int getPrice();

	/**
<<<<<<< HEAD
	 * Checks whether the item is members only.
	 *
	 * @return true if members only, false otherwise.
=======
	 * Returns whether or not the item is members-only.
	 *
	 * @return true if members-only, false otherwise.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	boolean isMembers();

	/**
<<<<<<< HEAD
	 * Checks whether the item is able to stack in a players inventory.
=======
	 * Returns whether or not the item stacks in the players' inventories
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @return true if stackable, false otherwise
	 */
	boolean isStackable();

	/**
<<<<<<< HEAD
	 * Returns whether or not the item can be traded to other players.
	 *
	 * @return true if tradeable, false otherwise
	 */
	boolean isTradeable();

	/**
	 * Gets an array of possible right-click menu actions the item
	 * has in a player inventory.
=======
	 * Returns the menu actions the item has in a players' inventory
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @return the inventory menu actions
	 */
	String[] getInventoryActions();

	/**
<<<<<<< HEAD
	 * Gets the menu action index of the shift-click action.
	 *
	 * @return the index of the shift-click action
	 */
	int getShiftClickActionIndex();

	/**
	 * Sets the menu action index of the shift-click action.
	 *
	 * @param shiftclickActionIndex the new index of the shift-click action
	 */
	void setShiftClickActionIndex(int shiftclickActionIndex);

	/**
	 * Resets the menu action index of the shift-click action to its
	 * default value.
	 */
=======
	 * Returns the menu action index of the shift-click action
	 *
	 * @return menu index of the shift-click action
	 */
	int getShiftClickActionIndex();

	void setShiftClickActionIndex(int shiftclickActionIndex);

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	void resetShiftClickActionIndex();
}
