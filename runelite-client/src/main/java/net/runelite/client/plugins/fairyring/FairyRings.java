/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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

package net.runelite.client.plugins.fairyring;

<<<<<<< HEAD
import lombok.Getter;

=======
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public enum FairyRings
{
	// A
	AIQ("Mudskipper Point"),
	AIR("(Island) South-east of Ardougne"),
	AJQ("Cave south of Dorgesh-Kaan"),
	AJR("Slayer cave"),
	AJS("Penguins near Miscellania"),
	AKQ("Piscatoris Hunter area"),
	AKS("Feldip Hunter area"),
	ALP("(Island) Lighthouse"),
	ALQ("Haunted Woods east of Canifis"),
	ALR("Abyssal Area"),
	ALS("McGrubor's Wood"),

	// B
	BIP("(Island) South-west of Mort Myre"),
	BIQ("Kalphite Hive"),
	BIS("Ardougne Zoo - Unicorns"),
	BJR("Realm of the Fisher King"),
<<<<<<< HEAD
	BJS("(Island) Near Zul-Andra", "zulrah"),
=======
	BJS("(Island) Near Zul-Andra"),
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	BKP("South of Castle Wars"),
	BKQ("Enchanted Valley"),
	BKR("Mort Myre Swamp, south of Canifis"),
	BKS("Zanaris"),
	BLP("TzHaar area"),
	BLR("Legends' Guild"),

	// C
	CIP("(Island) Miscellania"),
	CIQ("North-west of Yanille"),
	CIS("North of the Arceuus House Library"),
	CJR("Sinclair Mansion (east)"),
	CKP("Cosmic entity's plane"),
	CKR("South of Tai Bwo Wannai Village"),
	CKS("Canifis"),
	CLP("(Island) South of Draynor Village"),
	CLR("(Island) Ape Atoll"),
	CLS("(Island) Hazelmere's home"),

	// D
	DIP("(Sire Boss) Abyssal Nexus"),
	DIR("Gorak's Plane"),
<<<<<<< HEAD
	DIQ("Player-owned house", "poh home"),
=======
	DIQ("Player-owned house"),
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	DIS("Wizards' Tower"),
	DJP("Tower of Life"),
	DJR("Chasm of Fire"),
	DKP("South of Musa Point"),
	DKR("Edgeville, Grand Exchange"),
	DKS("Polar Hunter area"),
	DLQ("North of Nardah"),
	DLR("(Island) Poison Waste south of Isafdar"),
	DLS("Myreque hideout under The Hollows");

	@Getter
	private final String destination;
<<<<<<< HEAD

	@Getter
	private final String tags;

	FairyRings(String destination)
	{
		this(destination, "");
	}

	FairyRings(String destination, String tags)
	{
		this.destination = destination;
		this.tags = tags.toLowerCase() + " " + destination.toLowerCase();
	}

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
