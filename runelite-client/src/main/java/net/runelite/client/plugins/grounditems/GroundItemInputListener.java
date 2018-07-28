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
package net.runelite.client.plugins.grounditems;

<<<<<<< HEAD
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
=======
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

public class GroundItemInputListener extends MouseListener implements KeyListener
{
	private static final int HOTKEY = KeyEvent.VK_ALT;

	@Inject
<<<<<<< HEAD
=======
	private Client client;

	@Inject
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private GroundItemsPlugin plugin;

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY)
		{
			plugin.setHotKeyPressed(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY)
		{
			plugin.setHotKeyPressed(false);
<<<<<<< HEAD
			plugin.setTextBoxBounds(null);
			plugin.setHiddenBoxBounds(null);
			plugin.setHighlightBoxBounds(null);
=======
			plugin.getHighlightBoxes().clear();
			plugin.getHiddenBoxes().clear();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent e)
	{
<<<<<<< HEAD
		final Point mousePos = e.getPoint();

		if (plugin.isHotKeyPressed())
		{
			if (SwingUtilities.isLeftMouseButton(e))
			{
				// Process both click boxes for hidden and highlighted items
				if (plugin.getHiddenBoxBounds() != null && plugin.getHiddenBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getHiddenBoxBounds().getValue().getName(), true);
					e.consume();
					return e;
				}

				if (plugin.getHighlightBoxBounds() != null && plugin.getHighlightBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getHighlightBoxBounds().getValue().getName(), false);
					e.consume();
					return e;
				}

				// There is one name click box for left click and one for right click
				if (plugin.getTextBoxBounds() != null && plugin.getTextBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getTextBoxBounds().getValue().getName(), false);
					e.consume();
					return e;
				}
			}
			else if (SwingUtilities.isRightMouseButton(e))
			{
				if (plugin.getTextBoxBounds() != null && plugin.getTextBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getTextBoxBounds().getValue().getName(), true);
					e.consume();
					return e;
=======
		if (plugin.isHotKeyPressed())
		{
			// Check if left click
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				Point mousePos = client.getMouseCanvasPosition();

				for (Map.Entry<Rectangle, String> entry : plugin.getHiddenBoxes().entrySet())
				{
					if (entry.getKey().contains(mousePos.getX(), mousePos.getY()))
					{
						plugin.updateList(entry.getValue(), true);
						e.consume();
						return e;
					}
				}

				for (Map.Entry<Rectangle, String> entry : plugin.getHighlightBoxes().entrySet())
				{
					if (entry.getKey().contains(mousePos.getX(), mousePos.getY()))
					{
						plugin.updateList(entry.getValue(), false);
						e.consume();
						return e;
					}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				}
			}
		}

		return e;
	}
}

