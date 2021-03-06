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

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Actor;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.Constants;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.Item;
import net.runelite.api.ItemLayer;
import net.runelite.api.Node;
=======
import net.runelite.api.Actor;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.DecorativeObjectChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
<<<<<<< HEAD
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
=======
import net.runelite.api.events.ItemLayerChanged;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
<<<<<<< HEAD
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSCollisionData;
import net.runelite.rs.api.RSDeque;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSItem;
import net.runelite.rs.api.RSItemLayer;
import net.runelite.rs.api.RSNode;
=======
import static net.runelite.client.callback.Hooks.eventBus;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSCollisionData;
import net.runelite.rs.api.RSGameObject;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.rs.api.RSTile;

@Mixin(RSTile.class)
public abstract class RSTileMixin implements RSTile
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private static GameObject lastGameObject;

	@Inject
<<<<<<< HEAD
	private static RSDeque[][][] lastGroundItems = new RSDeque[Constants.MAX_Z][Constants.SCENE_SIZE][Constants.SCENE_SIZE];

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private WallObject previousWallObject;

	@Inject
	private DecorativeObject previousDecorativeObject;

	@Inject
	private GroundObject previousGroundObject;

	@Inject
	private GameObject[] previousGameObjects;

	@Inject
	@Override
	public WorldPoint getWorldLocation()
	{
<<<<<<< HEAD
		return WorldPoint.fromScene(client, getX(), getY(), getPlane());
=======
		return WorldPoint.fromRegion(client, getX(), getY(), getPlane());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
<<<<<<< HEAD
	public Point getSceneLocation()
=======
	public Point getRegionLocation()
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return new Point(getX(), getY());
	}

	@Inject
	@Override
	public LocalPoint getLocalLocation()
	{
<<<<<<< HEAD
		return LocalPoint.fromScene(getX(), getY());
=======
		return LocalPoint.fromRegion(getX(), getY());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@FieldHook("wallObject")
	@Inject
	public void wallObjectChanged(int idx)
	{
		WallObject previous = previousWallObject;
		WallObject current = getWallObject();

		previousWallObject = current;

		if (current == null && previous != null)
		{
			WallObjectDespawned wallObjectDespawned = new WallObjectDespawned();
			wallObjectDespawned.setTile(this);
			wallObjectDespawned.setWallObject(previous);
<<<<<<< HEAD
			client.getCallbacks().post(wallObjectDespawned);
=======
			eventBus.post(wallObjectDespawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		else if (current != null && previous == null)
		{
			WallObjectSpawned wallObjectSpawned = new WallObjectSpawned();
			wallObjectSpawned.setTile(this);
			wallObjectSpawned.setWallObject(current);
<<<<<<< HEAD
			client.getCallbacks().post(wallObjectSpawned);
=======
			eventBus.post(wallObjectSpawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		else if (current != null && previous != null)
		{
			WallObjectChanged wallObjectChanged = new WallObjectChanged();
			wallObjectChanged.setTile(this);
			wallObjectChanged.setPrevious(previous);
			wallObjectChanged.setWallObject(current);
<<<<<<< HEAD
			client.getCallbacks().post(wallObjectChanged);
=======
			eventBus.post(wallObjectChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@FieldHook("decorativeObject")
	@Inject
	public void decorativeObjectChanged(int idx)
	{
		DecorativeObject previous = previousDecorativeObject;
		DecorativeObject current = getDecorativeObject();

		previousDecorativeObject = current;

		if (current == null && previous != null)
		{
			DecorativeObjectDespawned decorativeObjectDespawned = new DecorativeObjectDespawned();
			decorativeObjectDespawned.setTile(this);
			decorativeObjectDespawned.setDecorativeObject(previous);
<<<<<<< HEAD
			client.getCallbacks().post(decorativeObjectDespawned);
=======
			eventBus.post(decorativeObjectDespawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		else if (current != null && previous == null)
		{
			DecorativeObjectSpawned decorativeObjectSpawned = new DecorativeObjectSpawned();
			decorativeObjectSpawned.setTile(this);
			decorativeObjectSpawned.setDecorativeObject(current);
<<<<<<< HEAD
			client.getCallbacks().post(decorativeObjectSpawned);
=======
			eventBus.post(decorativeObjectSpawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		else if (current != null && previous != null)
		{
			DecorativeObjectChanged decorativeObjectChanged = new DecorativeObjectChanged();
			decorativeObjectChanged.setTile(this);
			decorativeObjectChanged.setPrevious(previous);
			decorativeObjectChanged.setDecorativeObject(current);
<<<<<<< HEAD
			client.getCallbacks().post(decorativeObjectChanged);
=======
			eventBus.post(decorativeObjectChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@FieldHook("groundObject")
	@Inject
	public void groundObjectChanged(int idx)
	{
		GroundObject previous = previousGroundObject;
		GroundObject current = getGroundObject();

		previousGroundObject = current;

		if (current == null && previous != null)
		{
			GroundObjectDespawned groundObjectDespawned = new GroundObjectDespawned();
			groundObjectDespawned.setTile(this);
			groundObjectDespawned.setGroundObject(previous);
<<<<<<< HEAD
			client.getCallbacks().post(groundObjectDespawned);
=======
			eventBus.post(groundObjectDespawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		else if (current != null && previous == null)
		{
			GroundObjectSpawned groundObjectSpawned = new GroundObjectSpawned();
			groundObjectSpawned.setTile(this);
			groundObjectSpawned.setGroundObject(current);
<<<<<<< HEAD
			client.getCallbacks().post(groundObjectSpawned);
=======
			eventBus.post(groundObjectSpawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		else if (current != null && previous != null)
		{
			GroundObjectChanged groundObjectChanged = new GroundObjectChanged();
			groundObjectChanged.setTile(this);
			groundObjectChanged.setPrevious(previous);
			groundObjectChanged.setGroundObject(current);
<<<<<<< HEAD
			client.getCallbacks().post(groundObjectChanged);
=======
			eventBus.post(groundObjectChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@FieldHook("objects")
	@Inject
	public void gameObjectsChanged(int idx)
	{
		if (idx == -1) // this happens from the field assignment
		{
			return;
		}

		if (previousGameObjects == null)
		{
			previousGameObjects = new GameObject[5];
		}

		// Previous game object
		GameObject previous = previousGameObjects[idx];

		// GameObject that was changed.
		RSGameObject current = (RSGameObject) getGameObjects()[idx];

		// Last game object
		GameObject last = lastGameObject;

		// Update last game object
		lastGameObject = current;

		// Update previous object to current
		previousGameObjects[idx] = current;

		// Duplicate event, return
		if (current != null && current.equals(last))
		{
			return;
		}

		// Characters seem to generate a constant stream of new GameObjects
		if (current == null || !(current.getRenderable() instanceof Actor))
		{
			if (current == null && previous != null)
			{
				GameObjectDespawned gameObjectDespawned = new GameObjectDespawned();
				gameObjectDespawned.setTile(this);
				gameObjectDespawned.setGameObject(previous);
<<<<<<< HEAD
				client.getCallbacks().post(gameObjectDespawned);
=======
				eventBus.post(gameObjectDespawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
			else if (current != null && previous == null)
			{
				GameObjectSpawned gameObjectSpawned = new GameObjectSpawned();
				gameObjectSpawned.setTile(this);
				gameObjectSpawned.setGameObject(current);
<<<<<<< HEAD
				client.getCallbacks().post(gameObjectSpawned);
=======
				eventBus.post(gameObjectSpawned);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
			else if (current != null && previous != null)
			{
				GameObjectChanged gameObjectsChanged = new GameObjectChanged();
				gameObjectsChanged.setTile(this);
				gameObjectsChanged.setPrevious(previous);
				gameObjectsChanged.setGameObject(current);
<<<<<<< HEAD
				client.getCallbacks().post(gameObjectsChanged);
=======
				eventBus.post(gameObjectsChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}
	}

	@FieldHook("itemLayer")
	@Inject
	public void itemLayerChanged(int idx)
	{
<<<<<<< HEAD
		int x = getX();
		int y = getY();
		int z = client.getPlane();
		RSDeque[][][] groundItemDeque = client.getGroundItemDeque();

		RSDeque oldQueue = lastGroundItems[z][x][y];
		RSDeque newQueue = groundItemDeque[z][x][y];

		if (oldQueue != newQueue)
		{
			if (oldQueue != null)
			{
				// despawn everything in old ..
				RSNode head = oldQueue.getHead();
				for (RSNode cur = head.getNext(); cur != head; cur = cur.getNext())
				{
					RSItem item = (RSItem) cur;
					client.getLogger().debug("Item despawn (chunk reset): {} ({})", item.getId(), item.getQuantity());
					ItemDespawned itemDespawned = new ItemDespawned(this, item);
					client.getCallbacks().post(itemDespawned);
				}
			}
			lastGroundItems[z][x][y] = newQueue;
		}

		RSItem lastUnlink = client.getLastItemDespawn();
		if (lastUnlink != null)
		{
			client.setLastItemDespawn(null);
		}

		RSItemLayer itemLayer = (RSItemLayer) getItemLayer();
		if (itemLayer == null)
		{
			if (lastUnlink != null)
			{
				client.getLogger().debug("Item despawn: {} ({})", lastUnlink.getId(), lastUnlink.getQuantity());
				ItemDespawned itemDespawned = new ItemDespawned(this, lastUnlink);
				client.getCallbacks().post(itemDespawned);
			}
			return;
		}

		RSDeque itemDeque = newQueue;

		if (itemDeque == null)
		{
			if (lastUnlink != null)
			{
				client.getLogger().debug("Item despawn: {} ({})", lastUnlink.getId(), lastUnlink.getQuantity());
				ItemDespawned itemDespawned = new ItemDespawned(this, lastUnlink);
				client.getCallbacks().post(itemDespawned);
			}
			return;
		}

		// The new item gets added to either the head, or the tail, depending on its price
		RSNode head = itemDeque.getHead();
		RSNode current = null;
		RSNode previous = head.getPrevious();
		boolean forward = false;
		if (head != previous)
		{
			RSItem prev = (RSItem) previous;
			if (x != prev.getX() || y != prev.getY())
			{
				current = prev;
			}
		}

		RSNode next = head.getNext();
		if (current == null && head != next)
		{
			RSItem n = (RSItem) next;
			if (x != n.getX() || y != n.getY())
			{
				current = n;
				forward = true;
			}
		}

		if (lastUnlink != null && lastUnlink != previous && lastUnlink != next)
		{
			client.getLogger().debug("Item despawn: {} ({})", lastUnlink.getId(), lastUnlink.getQuantity());
			ItemDespawned itemDespawned = new ItemDespawned(this, lastUnlink);
			client.getCallbacks().post(itemDespawned);
		}

		if (current == null)
		{
			return; // already seen this spawn, or no new item
		}

		do
		{
			RSItem item = (RSItem) current;
			client.getLogger().debug("Item spawn: {} ({})", item.getId(), item.getQuantity());
			item.setX(x);
			item.setY(y);

			ItemSpawned itemSpawned = new ItemSpawned(this, item);
			client.getCallbacks().post(itemSpawned);

			current = forward ? current.getNext() : current.getPrevious();

			// Send spawn events for anything on this tile which is at the wrong location, which happens
			// when the scene base changes
		} while (current != head && (((RSItem) current).getX() != x || ((RSItem) current).getY() != y));
=======
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			// during region loading this gets set to null 104x104 times
			return;
		}

		ItemLayerChanged itemLayerChanged = new ItemLayerChanged(this);
		eventBus.post(itemLayerChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public boolean hasLineOfSightTo(Tile other)
	{
		// Thanks to Henke for this method :)

		if (this.getPlane() != other.getPlane())
		{
			return false;
		}

		RSCollisionData[] collisionData = client.getCollisionMaps();
		int z = this.getPlane();
		int[][] collisionDataFlags = collisionData[z].getFlags();

<<<<<<< HEAD
		Point p1 = this.getSceneLocation();
		Point p2 = other.getSceneLocation();
=======
		Point p1 = this.getRegionLocation();
		Point p2 = other.getRegionLocation();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		if (p1.getX() == p2.getX() && p1.getY() == p2.getY())
		{
			return true;
		}

		int dx = p2.getX() - p1.getX();
		int dy = p2.getY() - p1.getY();
		int dxAbs = Math.abs(dx);
		int dyAbs = Math.abs(dy);

		int xFlags = CollisionDataFlag.BLOCK_LINE_OF_SIGHT_FULL;
		int yFlags = CollisionDataFlag.BLOCK_LINE_OF_SIGHT_FULL;
		if (dx < 0)
		{
			xFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST;
		}
		else
		{
			xFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST;
		}
		if (dy < 0)
		{
			yFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH;
		}
		else
		{
			yFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH;
		}

		if (dxAbs > dyAbs)
		{
			int x = p1.getX();
			int yBig = p1.getY() << 16; // The y position is represented as a bigger number to handle rounding
			int slope = (dy << 16) / dxAbs;
			yBig += 0x8000; // Add half of a tile
			if (dy < 0)
			{
				yBig--; // For correct rounding
			}
			int direction = dx < 0 ? -1 : 1;

			while (x != p2.getX())
			{
				x += direction;
				int y = yBig >>> 16;
				if ((collisionDataFlags[x][y] & xFlags) != 0)
				{
					// Collision while traveling on the x axis
					return false;
				}
				yBig += slope;
				int nextY = yBig >>> 16;
				if (nextY != y && (collisionDataFlags[x][nextY] & yFlags) != 0)
				{
					// Collision while traveling on the y axis
					return false;
				}
			}
		}
		else
		{
			int y = p1.getY();
			int xBig = p1.getX() << 16; // The x position is represented as a bigger number to handle rounding
			int slope = (dx << 16) / dyAbs;
			xBig += 0x8000; // Add half of a tile
			if (dx < 0)
			{
				xBig--; // For correct rounding
			}
			int direction = dy < 0 ? -1 : 1;

			while (y != p2.getY())
			{
				y += direction;
				int x = xBig >>> 16;
				if ((collisionDataFlags[x][y] & yFlags) != 0)
				{
					// Collision while traveling on the y axis
					return false;
				}
				xBig += slope;
				int nextX = xBig >>> 16;
				if (nextX != x && (collisionDataFlags[nextX][y] & xFlags) != 0)
				{
					// Collision while traveling on the x axis
					return false;
				}
			}
		}

		// No collision
		return true;
	}
<<<<<<< HEAD

	@Inject
	@Override
	public List<Item> getGroundItems()
	{
		ItemLayer layer = this.getItemLayer();
		if (layer == null)
		{
			return null;
		}

		List<Item> result = new ArrayList<Item>();
		Node node = layer.getBottom();
		while (node instanceof Item)
		{
			result.add((Item) node);
			node = node.getNext();
		}
		return result;
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
