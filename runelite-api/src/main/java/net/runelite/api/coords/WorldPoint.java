/*
 * Copyright (c) 2018 Abex
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
package net.runelite.api.coords;

import lombok.Value;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;

/**
<<<<<<< HEAD
 * A three-dimensional point representing the coordinate of a Tile.
 * <p>
 * WorldPoints are immutable. Methods that modify the properties create a new
 * instance.
=======
 * WorldPoint is a Three-Dimensional point representing the location of a Tile
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
 */
@Value
public class WorldPoint
{
	/**
<<<<<<< HEAD
	 * X-axis coordinate.
=======
	 * The X coordinate of the Point.
	 * Units are in tiles
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	private final int x;

	/**
<<<<<<< HEAD
	 * Y-axis coordinate.
=======
	 * The Y coordinate of the Point.
	 * Units are in tiles
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	private final int y;

	/**
<<<<<<< HEAD
	 * The plane level of the Tile, also referred as z-axis coordinate.
	 *
	 * @see Client#getPlane()
=======
	 * The plane coordinate of the Point.
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	private final int plane;

	/**
<<<<<<< HEAD
	 * Offsets the x-axis coordinate by the passed value.
	 *
	 * @param dx the offset
	 * @return new instance
=======
	 * Returns a WorldPoint offset on x from this point
	 * @param dx offset
	 * @return
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public WorldPoint dx(int dx)
	{
		return new WorldPoint(x + dx, y, plane);
	}

	/**
<<<<<<< HEAD
	 * Offsets the y-axis coordinate by the passed value.
	 *
	 * @param dy the offset
	 * @return new instance
=======
	 * Returns a WorldPoint offset on y from this point
	 * @param dy offset
	 * @return
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public WorldPoint dy(int dy)
	{
		return new WorldPoint(x, y + dy, plane);
	}

	/**
<<<<<<< HEAD
	 * Offsets the plane by the passed value.
	 *
	 * @param dz the offset
	 * @return new instance
=======
	 * Returns a WorldPoint offset on z from this point
	 * @param dz offset
	 * @return
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public WorldPoint dz(int dz)
	{
		return new WorldPoint(x, y, plane + dz);
	}

<<<<<<< HEAD
	/**
	 * Checks whether a tile is located in the current scene.
	 *
	 * @param client the client
	 * @param x the tiles x coordinate
	 * @param y the tiles y coordinate
	 * @return true if the tile is in the scene, false otherwise
	 */
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public static boolean isInScene(Client client, int x, int y)
	{
		int baseX = client.getBaseX();
		int baseY = client.getBaseY();

		int maxX = baseX + Perspective.SCENE_SIZE;
		int maxY = baseY + Perspective.SCENE_SIZE;

		return x >= baseX && x < maxX && y >= baseY && y < maxY;
	}

<<<<<<< HEAD
	/**
	 * Checks whether this tile is located in the current scene.
	 *
	 * @param client the client
	 * @return true if this tile is in the scene, false otherwise
	 */
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public boolean isInScene(Client client)
	{
		return client.getPlane() == plane && isInScene(client, x, y);
	}

	/**
<<<<<<< HEAD
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param client the client
	 * @param local the local coordinate
	 * @return the tile coordinate containing the local point
=======
	 * Returns a WorldPoint containing the passed LocalPoint
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public static WorldPoint fromLocal(Client client, LocalPoint local)
	{
		return fromLocal(client, local.getX(), local.getY(), client.getPlane());
	}

	/**
<<<<<<< HEAD
	 * Gets the coordinate of the tile that contains the passed local point.
	 *
	 * @param client the client
	 * @param x the local x-axis coordinate
	 * @param y the local x-axis coordinate
	 * @param plane the plane
	 * @return the tile coordinate containing the local point
=======
	 * Returns a WorldPoint containing the passed local coordinates
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public static WorldPoint fromLocal(Client client, int x, int y, int plane)
	{
		return new WorldPoint(
			(x >>> Perspective.LOCAL_COORD_BITS) + client.getBaseX(),
			(y >>> Perspective.LOCAL_COORD_BITS) + client.getBaseY(),
			plane
		);
	}

	/**
<<<<<<< HEAD
	 * Gets the shortest distance from this point to a WorldArea.
	 *
	 * @param other the world area
	 * @return the shortest distance
=======
	 * Find the shortest distance from this point to a WorldArea
	 *
	 * @param other The WorldArea to find the distance to
	 * @return Returns the shortest distance
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public int distanceTo(WorldArea other)
	{
		return new WorldArea(this, 1, 1).distanceTo(other);
	}

	/**
<<<<<<< HEAD
	 * Gets the distance between this point and another.
	 * <p>
	 * If the other point is not on the same plane, this method will return
	 * {@link Integer#MAX_VALUE}. If ignoring the plane is wanted, use the
	 * {@link #distanceTo2D(WorldPoint)} method.
	 *
	 * @param other other point
	 * @return the distance
=======
	 * Find the distance from this point to another point. Returns Integer.MAX_VALUE if other is on
	 * a different plane.
	 *
	 * @param other
	 * @return
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public int distanceTo(WorldPoint other)
	{
		if (other.plane != plane)
		{
			return Integer.MAX_VALUE;
		}

		return distanceTo2D(other);
	}

<<<<<<< HEAD
	/**
	 * Find the distance from this point to another point.
	 * <p>
	 * This method disregards the plane value of the two tiles and returns
	 * the simple distance between the X-Z coordinate pairs.
	 *
	 * @param other other point
	 * @return the distance
=======

	/**
	 * Find the distance from this point to another point.
	 *
	 * @param other
	 * @return
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 */
	public int distanceTo2D(WorldPoint other)
	{
		return Math.max(Math.abs(getX() - other.getX()), Math.abs(getY() - other.getY()));
	}

	/**
<<<<<<< HEAD
	 * Converts the passed scene coordinates to a world space
	 */
	public static WorldPoint fromScene(Client client, int x, int y, int plane)
=======
	 * Returns a WorldPoint from the passed region coords
	 */
	public static WorldPoint fromRegion(Client client, int x, int y, int plane)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return new WorldPoint(
			x + client.getBaseX(),
			y + client.getBaseY(),
			plane
		);
	}

	@Deprecated
	public Point toPoint()
	{
		return new Point(x, y);
	}

<<<<<<< HEAD
	/**
	 * Gets the ID of the region containing this tile.
	 *
	 * @return the region ID
	 */
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public int getRegionID()
	{
		return ((x >> 6) << 8) | (y >> 6);
	}
}
