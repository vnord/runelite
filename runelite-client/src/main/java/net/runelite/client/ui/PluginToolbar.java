/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui;

<<<<<<< HEAD
import com.google.common.collect.ComparisonChain;
import com.google.common.eventbus.EventBus;
=======
import com.google.common.eventbus.EventBus;
import java.util.Comparator;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.util.TreeSet;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.events.PluginToolbarButtonAdded;
import net.runelite.client.events.PluginToolbarButtonRemoved;

/**
 * Plugin toolbar buttons holder.
 */
@Singleton
public class PluginToolbar
{
	private final EventBus eventBus;
<<<<<<< HEAD
	private final TreeSet<NavigationButton> buttons = new TreeSet<>((a, b) ->
		ComparisonChain.start()
			.compare(a.getPriority(), b.getPriority())
			.compare(a.getTooltip(), b.getTooltip())
			.result());
=======
	private final TreeSet<NavigationButton> buttons = new TreeSet<>(Comparator.comparing(NavigationButton::getName));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Inject
	private PluginToolbar(final EventBus eventBus)
	{
		this.eventBus = eventBus;
	}

	/**
	 * Add navigation.
	 *
	 * @param button the button
	 */
	public void addNavigation(final NavigationButton button)
	{
		if (buttons.contains(button))
		{
			return;
		}

		if (buttons.add(button))
		{
			int index = buttons.headSet(button).size();
			eventBus.post(new PluginToolbarButtonAdded(button, index));
		}
	}

	/**
	 * Remove navigation.
	 *
	 * @param button the button
	 */
	public void removeNavigation(final NavigationButton button)
	{
		int index = buttons.headSet(button).size();

		if (buttons.remove(button))
		{
			eventBus.post(new PluginToolbarButtonRemoved(button, index));
		}
	}
}
