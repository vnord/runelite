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
package net.runelite.client.plugins.discord;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("discord")
=======
@ConfigGroup(
	keyName = "discord",
	name = "Discord",
	description = "Configuration for Discord plugin"
)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public interface DiscordConfig extends Config
{
	@ConfigItem(
		keyName = "actionTimeout",
		name = "Action timeout (minutes)",
<<<<<<< HEAD
		description = "Configures after how long of not updating status will be reset (in minutes)",
		position = 1
=======
		description = "Configures after how long of not updating status will be reset (in minutes)"
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	)
	default int actionTimeout()
	{
		return 5;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "showSkillActivity",
		name = "Show activity while skilling",
		description = "Configures if your activity while training skills should be shown.",
		position = 2
	)
	default boolean showSkillingActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBossActivity",
		name = "Show activity at bosses",
		description = "Configures if your activity at bosses should be shown.",
		position = 3
	)
	default boolean showBossActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCityActivity",
		name = "Show activity at cities",
		description = "Configures if your activity at cities should be shown.",
		position = 4
	)
	default boolean showCityActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDungeonActivity",
		name = "Show activity at dungeons",
		description = "Configures if your activity at dungeons should be shown.",
		position = 5
	)
	default boolean showDungeonActivity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMinigameActivity",
		name = "Show activity at minigames",
		description = "Configures if your activity at minigames should be shown.",
		position = 6
	)
	default boolean showMinigameActivity()
	{
		return true;
=======
		keyName = "actionDelay",
		name = "New action delay (seconds)",
		description = "Configures the delay before new action will be considered as valid"
	)
	default int actionDelay()
	{
		return 10;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
