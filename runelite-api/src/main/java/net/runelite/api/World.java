/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
import java.util.EnumSet;

/**
 * Holds data of a RuneScape world.
=======

import java.util.EnumSet;

/**
 * Holds data of RuneScape world.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
 */
public interface World
{
	/**
<<<<<<< HEAD
	 * Gets all applicable world types for this world.
	 *
	 * @return the world types
=======
	 * Gets world types.
	 *
	 * @return the types
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	EnumSet<WorldType> getTypes();

	/**
	 * Sets world types.
	 *
	 * @param types the types
	 */
	void setTypes(EnumSet<WorldType> types);

	/**
<<<<<<< HEAD
	 * Gets the current number of players logged in the world.
=======
	 * Gets player count.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @return the player count
	 */
	int getPlayerCount();

	/**
<<<<<<< HEAD
	 * Sets the player count of the world.
	 *
	 * @param playerCount the new player count
=======
	 * Sets player count.
	 *
	 * @param playerCount the player count
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	void setPlayerCount(int playerCount);

	/**
<<<<<<< HEAD
	 * Gets the world location value.
	 *
	 * @return the world location
=======
	 * Gets location.
	 *
	 * @return the location
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	int getLocation();

	/**
<<<<<<< HEAD
	 * Sets the world location value.
=======
	 * Sets location.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @param location the location
	 */
	void setLocation(int location);

	/**
<<<<<<< HEAD
	 * Gets the worlds index.
=======
	 * Gets index.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @return the index
	 */
	int getIndex();

	/**
<<<<<<< HEAD
	 *  Sets the worlds index.
=======
	 * Sets index.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @param index the index
	 */
	void setIndex(int index);

	/**
<<<<<<< HEAD
	 * Gets the world number.
	 *
	 * @return the world number
=======
	 * Gets id.
	 *
	 * @return the id
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	int getId();

	/**
<<<<<<< HEAD
	 * Sets the world number.
	 *
	 * @param id the world number
=======
	 * Sets id.
	 *
	 * @param id the id
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	void setId(int id);

	/**
<<<<<<< HEAD
	 * Gets the world activity description.
	 * <p>
	 * For example, world 2 would return "Trade - Members".
	 *
	 * @return the world activity
=======
	 * Gets activity.
	 *
	 * @return the activity
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	String getActivity();

	/**
<<<<<<< HEAD
	 * Sets the world activity description.
=======
	 * Sets activity.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @param activity the activity
	 */
	void setActivity(String activity);

	/**
<<<<<<< HEAD
	 * Gets the address of the world.
	 *
	 * @return the world address
=======
	 * Gets address.
	 *
	 * @return the address
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	String getAddress();

	/**
<<<<<<< HEAD
	 * Sets the address of the world.
=======
	 * Sets address.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 *
	 * @param address the address
	 */
	void setAddress(String address);
}
