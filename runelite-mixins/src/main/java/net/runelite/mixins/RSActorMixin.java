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

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import net.runelite.api.Actor;
<<<<<<< HEAD
import net.runelite.api.Hitsplat;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.SpritePixels;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GraphicChanged;
<<<<<<< HEAD
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
=======
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import static net.runelite.client.callback.Hooks.eventBus;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSCombatInfo1;
import net.runelite.rs.api.RSCombatInfo2;
import net.runelite.rs.api.RSCombatInfoList;
import net.runelite.rs.api.RSCombatInfoListHolder;
import net.runelite.rs.api.RSModel;
<<<<<<< HEAD
import net.runelite.rs.api.RSNPC;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.rs.api.RSNode;

@Mixin(RSActor.class)
public abstract class RSActorMixin implements RSActor
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	@Override
	public Actor getInteracting()
	{
		int i = getRSInteracting();
<<<<<<< HEAD
		if (i == -1 || i == 65535)
=======
		if (i == -1)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			return null;
		}

		if (i < 0x8000)
		{
			NPC[] npcs = client.getCachedNPCs();
			return npcs[i];
		}

		i -= 0x8000;
		Player[] players = client.getCachedPlayers();
		return players[i];
	}

	@Inject
	@Override
	public int getHealthRatio()
	{
		RSCombatInfoList combatInfoList = getCombatInfoList();
		if (combatInfoList != null)
		{
			RSNode node = combatInfoList.getNode();
			RSNode next = node.getNext();
			if (next instanceof RSCombatInfoListHolder)
			{
				RSCombatInfoListHolder combatInfoListWrapper = (RSCombatInfoListHolder) next;
				RSCombatInfoList combatInfoList1 = combatInfoListWrapper.getCombatInfo1();

				RSNode node2 = combatInfoList1.getNode();
				RSNode next2 = node2.getNext();
				if (next2 instanceof RSCombatInfo1)
				{
					RSCombatInfo1 combatInfo = (RSCombatInfo1) next2;
					return combatInfo.getHealthRatio();
				}
			}
		}
		return -1;
	}

	@Inject
	@Override
	public int getHealth()
	{
		RSCombatInfoList combatInfoList = getCombatInfoList();
		if (combatInfoList != null)
		{
			RSNode node = combatInfoList.getNode();
			RSNode next = node.getNext();
			if (next instanceof RSCombatInfoListHolder)
			{
				RSCombatInfoListHolder combatInfoListWrapper = (RSCombatInfoListHolder) next;
				RSCombatInfo2 cf = combatInfoListWrapper.getCombatInfo2();
				return cf.getHealthScale();
			}
		}
		return -1;
	}

	@Override
	@Inject
	public WorldPoint getWorldLocation()
	{
		return WorldPoint.fromLocal(client,
			this.getPathX()[0] * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
			this.getPathY()[0] * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
			client.getPlane());
	}

	@Inject
	@Override
	public LocalPoint getLocalLocation()
	{
		return new LocalPoint(getX(), getY());
	}

	@Inject
	@Override
	public Polygon getCanvasTilePoly()
	{
		return Perspective.getCanvasTilePoly(client, getLocalLocation());
	}

	@Inject
	@Override
	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset)
	{
		return Perspective.getCanvasTextLocation(client, graphics, getLocalLocation(), text, zOffset);
	}

	@Inject
	@Override
	public Point getCanvasImageLocation(Graphics2D graphics, BufferedImage image, int zOffset)
	{
		return Perspective.getCanvasImageLocation(client, graphics, getLocalLocation(), image, zOffset);
	}

	@Inject
	@Override
	public Point getCanvasSpriteLocation(Graphics2D graphics, SpritePixels sprite, int zOffset)
	{
		return Perspective.getCanvasSpriteLocation(client, graphics, getLocalLocation(), sprite, zOffset);
	}

	@Inject
	@Override
	public Point getMinimapLocation()
	{
		return Perspective.worldToMiniMap(client, getX(), getY());
	}

	@FieldHook("animation")
	@Inject
	public void animationChanged(int idx)
	{
		AnimationChanged animationChange = new AnimationChanged();
		animationChange.setActor(this);
<<<<<<< HEAD
		client.getCallbacks().post(animationChange);
=======
		eventBus.post(animationChange);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@FieldHook("graphic")
	@Inject
	public void graphicChanged(int idx)
	{
		GraphicChanged graphicChanged = new GraphicChanged();
		graphicChanged.setActor(this);
<<<<<<< HEAD
		client.getCallbacks().post(graphicChanged);
	}

	@FieldHook("interacting")
	@Inject
	public void interactingChanged(int idx)
	{
		InteractingChanged interactingChanged = new InteractingChanged(this, getInteracting());
		client.getCallbacks().post(interactingChanged);
=======
		eventBus.post(graphicChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public Polygon getConvexHull()
	{
		RSModel model = getModel();
		if (model == null)
		{
			return null;
		}
		return model.getConvexHull(getX(), getY(), getOrientation());
	}

	@Inject
	@Override
	public WorldArea getWorldArea()
	{
		int size = 1;
		if (this instanceof NPC)
		{
			NPCComposition composition = ((NPC)this).getComposition();
			if (composition != null && composition.getConfigs() != null)
			{
				composition = composition.transform();
			}
			if (composition != null)
			{
				size = composition.getSize();
			}
		}

		return new WorldArea(this.getWorldLocation(), size, size);
	}
<<<<<<< HEAD

	@Inject
	@MethodHook("setCombatInfo")
	public void setCombatInfo(int combatInfoId, int gameCycle, int var3, int var4, int healthRatio, int health)
	{
		if (healthRatio == 0)
		{
			if (this == client.getLocalPlayer())
			{
				client.getLogger().debug("You died!");

				LocalPlayerDeath event = new LocalPlayerDeath();
				client.getCallbacks().post(event);
			}
			else if (this instanceof RSNPC)
			{
				((RSNPC) this).setDead(true);
			}
		}
	}

	/**
	 * Called after a hitsplat has been processed on an actor.
	 * Note that this event runs even if the hitsplat didn't show up,
	 * i.e. the actor already had 4 visible hitsplats.
	 *
	 * @param type The hitsplat type (i.e. color)
	 * @param value The value of the hitsplat (i.e. how high the hit was)
	 * @param var3 unknown
	 * @param var4 unknown
	 * @param gameCycle The gamecycle the hitsplat was applied on
	 * @param duration The amount of gamecycles the hitsplat will last for
	 */
	@Inject
	@MethodHook(value = "applyActorHitsplat", end = true)
	public void applyActorHitsplat(int type, int value, int var3, int var4, int gameCycle, int duration)
	{
		final Hitsplat hitsplat = new Hitsplat(Hitsplat.HitsplatType.fromInteger(type), value, gameCycle + duration);
		final HitsplatApplied event = new HitsplatApplied();
		event.setActor(this);
		event.setHitsplat(hitsplat);
		client.getCallbacks().post(event);
	}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
