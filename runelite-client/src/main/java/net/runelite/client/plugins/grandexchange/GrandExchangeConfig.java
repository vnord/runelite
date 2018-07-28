/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.grandexchange;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("grandexchange")
public interface GrandExchangeConfig extends Config
{
	@ConfigItem(
		position = 1,
=======
@ConfigGroup(
	keyName = "grandexchange",
	name = "Grand Exchange",
	description = "Configuration for the Grand Exchange"
)
public interface GrandExchangeConfig extends Config
{
	@ConfigItem(
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		keyName = "quickLookup",
		name = "Hotkey lookup (Alt + Left click)",
		description = "Configures whether to enable the hotkey lookup for ge searches"
	)
	default boolean quickLookup()
	{
		return true;
	}
<<<<<<< HEAD

	@ConfigItem(
		position = 2,
		keyName = "enableNotifications",
		name = "Enable Notifications",
		description = "Configures whether to enable notifications when an offer updates"
	)
	default boolean enableNotifications()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "enableOsbPrices",
		name = "Enable OSB actively traded prices",
		description = "Shows the OSBuddy actively traded price at the GE"
	)
	default boolean enableOsbPrices()
	{
		return false;
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
