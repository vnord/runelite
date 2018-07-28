/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.runecraft;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("runecraft")
=======
@ConfigGroup(
	keyName = "runecraft",
	name = "Runecraft",
	description = "Configuration for the runecrafting plugin"
)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public interface RunecraftConfig extends Config
{
	@ConfigItem(
		keyName = "showPouch",
		name = "Show Pouch count",
<<<<<<< HEAD
		description = "Configures whether the pouch ess count is displayed",
		position = 1
=======
		description = "Configures whether the pouch ess count is displayed"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showPouch()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBindNeck",
		name = "Show Binding Neck charges",
<<<<<<< HEAD
		description = "Configures whether the binding neck charge is displayed",
		position = 2
=======
		description = "Configures whether the binding neck charge is displayed"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showBindNeck()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRifts",
		name = "Show Rifts in Abyss",
<<<<<<< HEAD
		description = "Configures whether the rifts in the abyss will be displayed",
		position = 3
=======
		description = "Configures whether the rifts in the abyss will be displayed"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showRifts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAir",
		name = "Show Air rift",
<<<<<<< HEAD
		description = "Configures whether to display the air rift",
		position = 4
=======
		description = "Configures whether to display the air rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showAir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBlood",
		name = "Show Blood rift",
<<<<<<< HEAD
		description = "Configures whether to display the Blood rift",
		position = 5
=======
		description = "Configures whether to display the Blood rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showBlood()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBody",
		name = "Show Body rift",
<<<<<<< HEAD
		description = "Configures whether to display the Body rift",
		position = 6
=======
		description = "Configures whether to display the Body rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showBody()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showChaos",
		name = "Show Chaos rift",
<<<<<<< HEAD
		description = "Configures whether to display the Chaos rift",
		position = 7
=======
		description = "Configures whether to display the Chaos rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showChaos()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCosmic",
		name = "Show Cosmic rift",
<<<<<<< HEAD
		description = "Configures whether to display the Cosmic rift",
		position = 8
=======
		description = "Configures whether to display the Cosmic rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showCosmic()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDeath",
		name = "Show Death rift",
<<<<<<< HEAD
		description = "Configures whether to display the Death rift",
		position = 9
=======
		description = "Configures whether to display the Death rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showDeath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEarth",
		name = "Show Earth rift",
<<<<<<< HEAD
		description = "Configures whether to display the Earth rift",
		position = 10
=======
		description = "Configures whether to display the Earth rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showEarth()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFire",
		name = "Show Fire rift",
<<<<<<< HEAD
		description = "Configures whether to display the Fire rift",
		position = 11
=======
		description = "Configures whether to display the Fire rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLaw",
		name = "Show Law rift",
<<<<<<< HEAD
		description = "Configures whether to display the Law rift",
		position = 12
=======
		description = "Configures whether to display the Law rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showLaw()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMind",
		name = "Show Mind rift",
<<<<<<< HEAD
		description = "Configures whether to display the Mind rift",
		position = 13
=======
		description = "Configures whether to display the Mind rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showMind()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showNature",
		name = "Show Nature rift",
<<<<<<< HEAD
		description = "Configures whether to display the Nature rift",
		position = 14
=======
		description = "Configures whether to display the Nature rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showNature()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSoul",
		name = "Show Soul rift",
<<<<<<< HEAD
		description = "Configures whether to display the Soul rift",
		position = 15
=======
		description = "Configures whether to display the Soul rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showSoul()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWater",
		name = "Show Water rift",
<<<<<<< HEAD
		description = "Configures whether to display the Water rift",
		position = 16
=======
		description = "Configures whether to display the Water rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showWater()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showClickBox",
		name = "Show Rift click box",
<<<<<<< HEAD
		description = "Configures whether to display the click box of the rift",
		position = 17
=======
		description = "Configures whether to display the click box of the rift"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean showClickBox()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hightlightDarkMage",
		name = "Highlight Dark Mage NPC",
<<<<<<< HEAD
		description = "Configures whether to highlight the Dark Mage when pouches are degraded",
		position = 18
=======
		description = "Configures whether to highlight the Dark Mage when pouches are degraded"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default boolean hightlightDarkMage()
	{
		return true;
	}
<<<<<<< HEAD

	@ConfigItem(
		keyName = "degradingNotification",
		name = "Notify when pouch degrades",
		description = "Send a notification when a pouch degrades",
		position = 19
	)
	default boolean degradingNotification()
	{
		return true;
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
