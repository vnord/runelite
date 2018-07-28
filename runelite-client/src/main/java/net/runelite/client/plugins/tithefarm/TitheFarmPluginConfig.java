/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.tithefarm;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("tithefarmplugin")
=======
@ConfigGroup(
	keyName = "tithefarmplugin",
	name = "Tithe Farm",
	description = "Configuration for the Tithe Farm plugin"
)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public interface TitheFarmPluginConfig extends Config
{
	@ConfigItem(
		position = 0,
<<<<<<< HEAD
=======
		keyName = "showWateringCanOverlay",
		name = "Show watering can doses",
		description = "Configures whether or not the watering can doses are displayed"
	)
	default boolean showWateringCanOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		keyName = "showSack",
		name = "Show fruit sack",
		description = "Configures whether or not the fruit sack is displayed"
	)
	default boolean showSack()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 1,
=======
		position = 2,
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		keyName = "hexColorUnwatered",
		name = "Unwatered plant",
		description = "Color of unwatered plant timer"
	)
	default Color getColorUnwatered()
	{
		return new Color(255, 187, 0);
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 2,
=======
		position = 3,
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		keyName = "hexColorWatered",
		name = "Watered plant",
		description = "Color of watered plant timer"
	)
	default Color getColorWatered()
	{
		return new Color(0, 153, 255);
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 3,
=======
		position = 4,
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		keyName = "hexColorGrown",
		name = "Grown plant",
		description = "Color of grown plant timer"
	)
	default Color getColorGrown()
	{
		return new Color(0, 217, 0);
	}
}
