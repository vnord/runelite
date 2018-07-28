/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.bankvalue;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("bankvalue")
=======
@ConfigGroup(
	keyName = "bankvalue",
	name = "Bank Value",
	description = "Shows the value of your bank and/or current tab")
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public interface BankValueConfig extends Config
{
	@ConfigItem(
		keyName = "showGE",
		name = "Show Grand Exchange price",
<<<<<<< HEAD
		description = "Show grand exchange price total (GE)",
		position = 1
	)
=======
		description = "Show grand exchange price total (GE)")
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	default boolean showGE()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHA",
		name = "Show high alchemy price",
<<<<<<< HEAD
		description = "Show high alchemy price total (HA)",
		position = 2
	)
=======
		description = "Show high alchemy price total (HA)")
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	default boolean showHA()
	{
		return false;
	}
<<<<<<< HEAD

	@ConfigItem(
		keyName = "showExact",
		name = "Show exact bank value",
		description = "Show exact bank value",
		position = 3
	)
	default boolean showExact()
	{
		return false;
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
