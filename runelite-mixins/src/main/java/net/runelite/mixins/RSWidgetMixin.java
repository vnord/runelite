/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
<<<<<<< HEAD
import net.runelite.api.HashTable;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.Node;
import net.runelite.api.Point;
import net.runelite.api.WidgetNode;
import net.runelite.api.events.WidgetHiddenChanged;
<<<<<<< HEAD
import net.runelite.api.events.WidgetPositioned;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.api.widgets.WidgetItem;
<<<<<<< HEAD
=======
import static net.runelite.client.callback.Hooks.eventBus;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSHashTable;
import net.runelite.rs.api.RSNode;
import net.runelite.rs.api.RSWidget;

@Mixin(RSWidget.class)
public abstract class RSWidgetMixin implements RSWidget
{
	private static final int ITEM_SLOT_SIZE = 32;

	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
<<<<<<< HEAD
	private static int rl$widgetLastPosChanged;

	@Inject
	private int rl$parentId;

	@Inject
	private int rl$x;

	@Inject
	private int rl$y;

	@Inject
	RSWidgetMixin()
	{
		rl$parentId = -1;
		rl$x = -1;
		rl$y = -1;
	}

	@Inject
	@Override
	public void setRenderParentId(int parentId)
	{
		rl$parentId = parentId;
	}

	@Inject
	@Override
	public void setRenderX(int x)
	{
		rl$x = x;
	}

	@Inject
	@Override
	public void setRenderY(int y)
	{
		rl$y = y;
	}

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Override
	public Widget getParent()
	{
		int id = getParentId();
		if (id == -1)
		{
			return null;
		}

		return client.getWidget(TO_GROUP(id), TO_CHILD(id));
	}

	@Inject
	@Override
	public int getParentId()
	{
<<<<<<< HEAD
		int rsParentId = getRSParentId();
		if (rsParentId != -1)
		{
			return rsParentId;
		}

		final int id = getId();
		if (TO_GROUP(id) == client.getWidgetRoot())
		{
			// this is a root widget
			return -1;
		}

		int parentId = rl$parentId;
		if (parentId != -1)
		{
			// if this happens, the widget is or was nested.
			// rl$parentId is updated when drawing, but will not be updated when
			// the widget is no longer reachable in the tree, leaving
			// parent id potentially incorrect

			// check the parent in the component table
			HashTable<WidgetNode> componentTable = client.getComponentTable();
			WidgetNode widgetNode = componentTable.get(parentId);
			if (widgetNode == null || widgetNode.getId() != TO_GROUP(id))
			{
				// invalidate parent
				rl$parentId = -1;
			}
			else
			{
				return parentId;
			}
		}

		// also the widget may not have been drawn, yet
		int groupId = TO_GROUP(getId());
		RSHashTable componentTable = client.getComponentTable();
		RSNode[] buckets = componentTable.getBuckets();
		for (RSNode node : buckets)
		{
=======
		int parentId = getRSParentId();
		if (parentId != -1)
		{
			return parentId;
		}

		int groupId = TO_GROUP(getId());
		RSHashTable componentTable = client.getComponentTable();
		RSNode[] buckets = componentTable.getBuckets();
		for (int i = 0; i < buckets.length; ++i)
		{
			Node node = buckets[i];

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			// It looks like the first node in the bucket is always
			// a sentinel
			Node cur = node.getNext();
			while (cur != node)
			{
				WidgetNode wn = (WidgetNode) cur;

				if (groupId == wn.getId())
				{
					return (int) wn.getHash();
				}
<<<<<<< HEAD

				cur = cur.getNext();
			}
		}

=======
				cur = cur.getNext();
			}
		}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		return -1;
	}

	@Inject
	@Override
	public String getText()
	{
		return getRSText().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public String getName()
	{
		return getRSName().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public void setName(String name)
	{
		setRSName(name.replace(' ', '\u00A0'));
	}

	@Inject
	@Override
	public boolean isHidden()
	{
<<<<<<< HEAD
		if (isSelfHidden())
		{
			return true;
		}

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		Widget parent = getParent();

		if (parent == null)
		{
			if (TO_GROUP(getId()) != client.getWidgetRoot())
			{
				// Widget has no parent and is not the root widget (which is always visible),
				// so it's not visible.
				return true;
			}
		}
		else if (parent.isHidden())
		{
			// If the parent is hidden, this widget is also hidden.
			return true;
		}

<<<<<<< HEAD
		return false;
=======
		return isSelfHidden();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public Point getCanvasLocation()
	{
<<<<<<< HEAD
		return new Point(rl$x, rl$y);
=======
		int x = 0;
		int y = 0;
		RSWidget cur;

		for (cur = this; cur.getParent() != null; cur = (RSWidget) cur.getParent())
		{
			x += cur.getRelativeX();
			y += cur.getRelativeY();

			x -= cur.getScrollX();
			y -= cur.getScrollY();
		}

		// cur is now the root
		int[] widgetBoundsWidth = client.getWidgetPositionsX();
		int[] widgetBoundsHeight = client.getWidgetPositionsY();

		int boundsIndex = cur.getBoundsIndex();
		if (boundsIndex != -1)
		{
			x += widgetBoundsWidth[boundsIndex];
			y += widgetBoundsHeight[boundsIndex];

			if (cur.getType() > 0)
			{
				x += cur.getRelativeX();
				y += cur.getRelativeY();
			}
		}
		else
		{
			x += cur.getRelativeX();
			y += cur.getRelativeY();
		}

		return new Point(x, y);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public Rectangle getBounds()
	{
		Point canvasLocation = getCanvasLocation();
		return new Rectangle(canvasLocation.getX(), canvasLocation.getY(), getWidth(), getHeight());
	}

	@Inject
	@Override
	public Collection<WidgetItem> getWidgetItems()
	{
		int[] itemIds = getItemIds();

		if (itemIds == null)
		{
			return null;
		}

		List<WidgetItem> items = new ArrayList<WidgetItem>(itemIds.length);

		for (int i = 0; i < itemIds.length; ++i)
		{
			WidgetItem item = getWidgetItem(i);

			if (item != null)
			{
				items.add(item);
			}
		}

		return items;
	}

	@Inject
	@Override
	public WidgetItem getWidgetItem(int index)
	{
		int[] itemIds = getItemIds();
		int[] itemQuantities = getItemQuantities();

		if (itemIds == null || itemQuantities == null)
		{
			return null;
		}

		int columns = getWidth(); // the number of item slot columns is stored here
		int paddingX = getPaddingX();
		int paddingY = getPaddingY();
		int itemId = itemIds[index];
		int itemQuantity = itemQuantities[index];

		Point widgetCanvasLocation = getCanvasLocation();

		if (itemId <= 0 || itemQuantity <= 0 || columns <= 0)
		{
			return null;
		}

		int row = index / columns;
		int col = index % columns;
		int itemX = widgetCanvasLocation.getX() + ((ITEM_SLOT_SIZE + paddingX) * col);
		int itemY = widgetCanvasLocation.getY() + ((ITEM_SLOT_SIZE + paddingY) * row);

		Rectangle bounds = new Rectangle(itemX - 1, itemY - 1, ITEM_SLOT_SIZE, ITEM_SLOT_SIZE);
		return new WidgetItem(itemId - 1, itemQuantity, index, bounds);
	}

	@Inject
	@Override
	public Widget getChild(int index)
	{
		RSWidget[] widgets = getChildren();

		if (widgets == null || widgets[index] == null)
		{
			return null;
		}

		return widgets[index];
	}

	@Inject
	@Override
	public Widget[] getDynamicChildren()
	{
		RSWidget[] children = getChildren();

		if (children == null)
		{
			return new Widget[0];
		}

		List<Widget> widgets = new ArrayList<Widget>();
<<<<<<< HEAD
		for (RSWidget widget : children)
		{
			if (widget != null && widget.getRSParentId() == getId())
=======
		for (Widget widget : children)
		{
			if (widget != null && widget.getParentId() == getId())
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				widgets.add(widget);
			}
		}
		return widgets.toArray(new Widget[widgets.size()]);
	}

	@Inject
	@Override
	public Widget[] getStaticChildren()
	{
<<<<<<< HEAD
		if (getRSParentId() == getId())
		{
			// This is a dynamic widget, so it can't have static children
			return new Widget[0];
		}

		List<Widget> widgets = new ArrayList<Widget>();
		for (RSWidget widget : client.getGroup(TO_GROUP(getId())))
		{
			if (widget != null && widget.getRSParentId() == getId())
=======
		List<Widget> widgets = new ArrayList<Widget>();
		for (Widget widget : client.getGroup(TO_GROUP(getId())))
		{
			if (widget != null && widget.getParentId() == getId())
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				widgets.add(widget);
			}
		}
<<<<<<< HEAD
		return widgets.toArray(new RSWidget[widgets.size()]);
=======
		return widgets.toArray(new Widget[widgets.size()]);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public Widget[] getNestedChildren()
	{
<<<<<<< HEAD
		if (getRSParentId() == getId())
		{
			// This is a dynamic widget, so it can't have nested children
			return new Widget[0];
		}

		HashTable<WidgetNode> componentTable = client.getComponentTable();

		WidgetNode wn = componentTable.get(getId());
		if (wn == null)
		{
			return new RSWidget[0];
		}

		int group = wn.getId();

		List<RSWidget> widgets = new ArrayList<RSWidget>();
		for (RSWidget widget : client.getGroup(group))
		{
			if (widget != null && widget.getRSParentId() == -1)
=======
		RSHashTable componentTable = client.getComponentTable();
		int group = -1;

		// XXX can actually use hashtable lookup instead of table
		// iteration here...
		for (Node node : componentTable.getNodes())
		{
			WidgetNode wn = (WidgetNode) node;

			if (wn.getHash() == getId())
			{
				group = wn.getId();
				break;
			}
		}

		if (group == -1)
		{
			return new Widget[0];
		}

		List<Widget> widgets = new ArrayList<Widget>();
		for (Widget widget : client.getGroup(group))
		{
			if (widget != null && widget.getParentId() == getId())
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				widgets.add(widget);
			}
		}
<<<<<<< HEAD
		return widgets.toArray(new RSWidget[widgets.size()]);
=======
		return widgets.toArray(new Widget[widgets.size()]);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public boolean contains(Point point)
	{
		Rectangle bounds = getBounds();
		return bounds != null && bounds.contains(new java.awt.Point(point.getX(), point.getY()));
	}

	@Inject
	@Override
	public void broadcastHidden(boolean hidden)
	{
		WidgetHiddenChanged event = new WidgetHiddenChanged();
		event.setWidget(this);
		event.setHidden(hidden);

<<<<<<< HEAD
		client.getCallbacks().post(event);
=======
		eventBus.post(event);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		RSWidget[] children = getChildren();

		if (children != null)
		{
			// recursive through children
			for (RSWidget child : children)
			{
				// if the widget is hidden it will not magically unhide from its parent changing
				if (child == null || child.isSelfHidden())
<<<<<<< HEAD
				{
					continue;
				}
=======
					continue;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				child.broadcastHidden(hidden);
			}
		}

		// make sure we iterate nested children as well
		// cannot be null
		Widget[] nestedChildren = getNestedChildren();

		for (Widget nestedChild : nestedChildren)
		{
			if (nestedChild == null || nestedChild.isSelfHidden())
<<<<<<< HEAD
			{
				continue;
			}
=======
				continue;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			((RSWidget) nestedChild).broadcastHidden(hidden);
		}
	}

	@FieldHook("isHidden")
	@Inject
	public void onHiddenChanged(int idx)
	{
		int id = getId();

		if (id == -1)
		{
			return;
		}

		Widget parent = getParent();

		// if the parent is hidden then changes in this widget don't have any visual effect
		// so ignore them
		if (parent != null)
		{
			if (parent.isHidden())
			{
				return;
			}
		}
		else if (TO_GROUP(id) != client.getWidgetRoot())
		{
			return;
		}

		broadcastHidden(isSelfHidden());
	}
<<<<<<< HEAD

	@FieldHook("relativeY")
	@Inject
	public void onPositionChanged(int idx)
	{
		int id = getId();
		if (id == -1)
		{
			return;
		}

		int tick = client.getGameCycle();
		if (tick == rl$widgetLastPosChanged)
		{
			return;
		}

		rl$widgetLastPosChanged = tick;

		client.getLogger().trace("Posting widget position changed");

		WidgetPositioned widgetPositioned = new WidgetPositioned();
		client.getCallbacks().postDeferred(widgetPositioned);
	}

	@Inject
	@Override
	public Widget createChild(int index, int type)
	{
		RSWidget w = client.createWidget();
		w.setType(type);
		w.setParentId(getId());
		w.setId(getId());
		w.setIsIf3(true);

		RSWidget[] siblings = getChildren();

		if (index < 0)
		{
			if (siblings == null)
			{
				index = 0;
			}
			else
			{
				index = siblings.length;
			}
		}

		if (siblings == null)
		{
			siblings = new RSWidget[index + 1];
			setChildren(siblings);
		}
		else if (siblings.length <= index)
		{
			RSWidget[] newSiblings = new RSWidget[index + 1];
			System.arraycopy(siblings, 0, newSiblings, 0, siblings.length);
			siblings = newSiblings;
			setChildren(siblings);
		}

		siblings[index] = w;
		w.setIndex(index);

		return w;
	}

	@Inject
	@Override
	public void revalidate()
	{
		client.revalidateWidget(this);
	}

	@Inject
	@Override
	public void revalidateScroll()
	{
		client.revalidateWidget(this);
		client.revalidateWidgetScroll(client.getWidgets()[TO_GROUP(this.getId())], this, false);
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
