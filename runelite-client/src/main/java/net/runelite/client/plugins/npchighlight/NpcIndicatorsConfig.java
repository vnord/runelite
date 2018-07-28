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
package net.runelite.client.plugins.npchighlight;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("npcindicators")
=======
@ConfigGroup(
	keyName = "npcindicators",
	name = "NPC Indicators",
	description = "Configuration for the NPC indicators plugin"
)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public interface NpcIndicatorsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "highlightStyle",
		name = "Highlight Style",
		description = "Highlight setting"
	)
	default RenderStyle renderStyle()
	{
		return RenderStyle.HULL;
	}

	@ConfigItem(
		position = 1,
		keyName = "npcToHighlight",
		name = "NPCs to Highlight",
		description = "List of NPC names to highlight"
	)
	default String getNpcToHighlight()
	{
		return "";
	}

	@ConfigItem(
		position = 2,
		keyName = "npcColor",
		name = "Highlight Color",
		description = "Color of the NPC highlight"
	)
<<<<<<< HEAD
	default Color getHighlightColor()
=======
	default Color getNpcColor()
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return Color.CYAN;
	}

	@ConfigItem(
		position = 3,
		keyName = "enableTag",
		name = "Enable Tag Option",
		description = "Enable the NPC tag menu option"
	)
	default boolean isTagEnabled()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
<<<<<<< HEAD
=======
		keyName = "tagColor",
		name = "Tag Color",
		description = "Color of the NPC tag highlight"
	)
	default Color getTagColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		position = 5,
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		keyName = "drawNames",
		name = "Draw names above NPC",
		description = "Configures whether or not NPC names should be drawn above the NPC"
	)
	default boolean drawNames()
	{
		return false;
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 5,
=======
		position = 6,
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not NPC names should be drawn on the minimap"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}
<<<<<<< HEAD

	@ConfigItem(
		position = 6,
		keyName = "showRespawnTimer",
		name = "Show respawn timer",
		description = "Show respawn timer of tagged NPCs")
	default boolean showRespawnTimer()
	{
		return false;
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}