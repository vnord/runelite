/*
 * Copyright (c) 2017, Steve <steve.rs.dev@gmail.com>
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
package net.runelite.client.plugins.xpglobes;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("xpglobes")
=======
@ConfigGroup(
	keyName = "xpglobes",
	name = "XP Globes",
	description = "Configuration for the XP globes plugin"
)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public interface XpGlobesConfig extends Config
{
	@ConfigItem(
		keyName = "enableTooltips",
		name = "Enable Tooltips",
		description = "Configures whether or not to show tooltips",
		position = 0
	)
	default boolean enableTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = "Progress arc color",
		name = "Progress arc color",
		description = "Change the color of the progress arc in the xp orb",
		position = 1
	)
	default Color progressArcColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "Progress orb outline color",
		name = "Progress orb outline color",
		description = "Change the color of the progress orb outline",
		position = 2
	)
	default Color progressOrbOutLineColor()
	{
		return Color.BLACK;
	}

	@ConfigItem(
		keyName = "Progress orb background color",
		name = "Progress orb background color",
		description = "Change the color of the progress orb background",
		position = 3
	)
	default Color progressOrbBackgroundColor()
	{
		return new Color(128, 128, 128, 127);
	}

	@ConfigItem(
		keyName = "Progress arc width",
		name = "Progress arc width",
		description = "Change the stroke width of the progress arc",
		position = 4
	)
	default int progressArcStrokeWidth()
	{
		return 2;
	}

	@ConfigItem(
		keyName = "Orb size",
		name = "Size of orbs",
		description = "Change the size of the xp orbs",
		position = 5
	)
	default int xpOrbSize()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "Center orbs",
		name = "Center orbs",
		description = "Where to center the xp orbs around",
		position = 6
	)
	default OrbCentering centerOrbs()
	{
		return OrbCentering.DYNAMIC;
	}

	@ConfigItem(
		keyName = "Orb duration",
		name = "Duration of orbs",
		description = "Change the duration the xp orbs are visible",
		position = 7
	)
	default int xpOrbDuration()
	{
		return 10;
	}
}
