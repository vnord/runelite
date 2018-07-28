/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.kourendlibrary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

class Bookcase
{
<<<<<<< HEAD
	Bookcase(WorldPoint location)
=======
	public Bookcase(WorldPoint location)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		this.location = location;
		this.index = new ArrayList<>();
	}

	@Getter
	private final WorldPoint location;

	@Getter
	private final List<Integer> index;

	@Getter
	private boolean isBookSet;

	/**
	 * Book in this bookcase as found by the player.
	 * Will be correct as long as isBookSet is true, unless the library has reset;
	 */
	@Getter
	private Book book;

	/**
	 * Books that can be in this slot. Will only be populated if library.state != SolvedState.NO_DATA
	 */
	@Getter
	private Set<Book> possibleBooks = new HashSet<>();

<<<<<<< HEAD
	void clearBook()
=======
	public void clearBook()
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		book = null;
		isBookSet = false;
	}

<<<<<<< HEAD
	void setBook(Book book)
=======
	public void setBook(Book book)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		this.book = book;
		this.isBookSet = true;
	}

<<<<<<< HEAD
	String getLocationString()
	{
		StringBuilder b = new StringBuilder();

		// Floors 2 and 3
		boolean north = location.getY() > 3815;
		boolean west = location.getX() < 1625;

		// Floor 1 has slightly different dimensions
		if (location.getPlane() == 0)
		{
			north = location.getY() > 3813;
			west = location.getX() < 1627;
		}

=======
	public String getLocationString()
	{
		StringBuilder b = new StringBuilder();

		boolean north = location.getY() > 3815;
		boolean west = location.getX() < 1625;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		if (north && west)
		{
			b.append("Northwest");
		}
		else if (north)
		{
			b.append("Northeast");
		}
		else if (west)
		{
			b.append("Southwest");
		}
		else
		{
			b.append("Center");
		}

		b.append(" ");

		switch (location.getPlane())
		{
			case 0:
				b.append("ground floor");
				break;
			case 1:
				b.append("middle floor");
				break;
			case 2:
				b.append("top floor");
				break;
		}

		if (KourendLibraryPlugin.debug)
		{
			b.append(" ").append(index.stream().map(Object::toString).collect(Collectors.joining(", ")));
		}
		return b.toString();
	}
}
