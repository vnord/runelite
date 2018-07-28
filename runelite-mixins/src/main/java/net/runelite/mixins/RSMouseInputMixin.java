/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import java.awt.event.MouseEvent;
import net.runelite.api.mixins.Copy;
<<<<<<< HEAD
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
=======
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.client.callback.Hooks;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.rs.api.RSMouseInput;

@Mixin(RSMouseInput.class)
public abstract class RSMouseInputMixin implements RSMouseInput
{
<<<<<<< HEAD
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private int isInEvent;

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Copy("mousePressed")
	abstract void rs$mousePressed(MouseEvent mouseEvent);

	@Copy("mouseReleased")
	abstract void rs$mouseReleased(MouseEvent mouseEvent);

	@Copy("mouseClicked")
	abstract void rs$mouseClicked(MouseEvent mouseEvent);

	@Copy("mouseEntered")
	abstract void rs$mouseEntered(MouseEvent mouseEvent);

	@Copy("mouseExited")
	abstract void rs$mouseExited(MouseEvent mouseEvent);

	@Copy("mouseDragged")
	abstract void rs$mouseDragged(MouseEvent mouseEvent);

	@Copy("mouseMoved")
	abstract void rs$mouseMoved(MouseEvent mouseEvent);

	@Override
	@Replace("mousePressed")
	public synchronized void mousePressed(MouseEvent mouseEvent)
	{
<<<<<<< HEAD
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mousePressed(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mousePressed(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
=======
		mouseEvent = Hooks.mousePressed(mouseEvent);
		if (!mouseEvent.isConsumed())
		{
			rs$mousePressed(mouseEvent);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Override
	@Replace("mouseReleased")
	public synchronized void mouseReleased(MouseEvent mouseEvent)
	{
<<<<<<< HEAD
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseReleased(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseReleased(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
=======
		mouseEvent = Hooks.mouseReleased(mouseEvent);
		if (!mouseEvent.isConsumed())
		{
			rs$mouseReleased(mouseEvent);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Override
	@Replace("mouseClicked")
	public void mouseClicked(MouseEvent event)
	{
<<<<<<< HEAD
		event = client.getCallbacks().mouseClicked(event);
=======
		event = Hooks.mouseClicked(event);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		if (!event.isConsumed())
		{
			rs$mouseClicked(event);
		}
	}

	@Override
	@Replace("mouseEntered")
	public synchronized void mouseEntered(MouseEvent mouseEvent)
	{
<<<<<<< HEAD
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseEntered(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseEntered(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
=======
		mouseEvent = Hooks.mouseEntered(mouseEvent);
		if (!mouseEvent.isConsumed())
		{
			rs$mouseEntered(mouseEvent);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}


	@Override
	@Replace("mouseExited")
	public synchronized void mouseExited(MouseEvent mouseEvent)
	{
<<<<<<< HEAD
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseExited(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseExited(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
=======
		mouseEvent = Hooks.mouseExited(mouseEvent);
		if (!mouseEvent.isConsumed())
		{
			rs$mouseExited(mouseEvent);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Override
	@Replace("mouseDragged")
	public synchronized void mouseDragged(MouseEvent mouseEvent)
	{
<<<<<<< HEAD
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseDragged(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseDragged(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
=======
		mouseEvent = Hooks.mouseDragged(mouseEvent);
		if (!mouseEvent.isConsumed())
		{
			rs$mouseDragged(mouseEvent);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Override
	@Replace("mouseMoved")
	public synchronized void mouseMoved(MouseEvent mouseEvent)
	{
<<<<<<< HEAD
		if (isInEvent == 0)
		{
			mouseEvent = client.getCallbacks().mouseMoved(mouseEvent);
		}
		if (!mouseEvent.isConsumed())
		{
			isInEvent++;
			try
			{
				rs$mouseMoved(mouseEvent);
			}
			finally
			{
				isInEvent--;
			}
=======
		mouseEvent = Hooks.mouseMoved(mouseEvent);
		if (!mouseEvent.isConsumed())
		{
			rs$mouseMoved(mouseEvent);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}
}
