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

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
<<<<<<< HEAD
import javax.inject.Named;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMember;
import net.runelite.api.Friend;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GraphicsObject;
<<<<<<< HEAD
import net.runelite.api.HashTable;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.HintArrowType;
import net.runelite.api.IndexedSprite;
import net.runelite.api.InventoryID;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.PLAYER_EIGTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIFTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIRST_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FOURTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SECOND_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SEVENTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SIXTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_THIRD_OPTION;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Node;
<<<<<<< HEAD
import net.runelite.api.PacketBuffer;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import static net.runelite.api.Perspective.LOCAL_TILE_SIZE;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.Skill;
import net.runelite.api.SpritePixels;
import net.runelite.api.Tile;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.WidgetNode;
import net.runelite.api.WorldType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.BoostedLevelChanged;
<<<<<<< HEAD
import net.runelite.api.events.ChatMessage;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.events.ClanChanged;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
<<<<<<< HEAD
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
=======
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.MenuEntryAdded;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerMenuOptionsChanged;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
<<<<<<< HEAD
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
=======
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
<<<<<<< HEAD
=======
import net.runelite.client.callback.Hooks;
import static net.runelite.client.callback.Hooks.deferredEventBus;
import static net.runelite.client.callback.Hooks.eventBus;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.rs.api.RSClanMemberManager;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSDeque;
import net.runelite.rs.api.RSFriendContainer;
import net.runelite.rs.api.RSFriendManager;
import net.runelite.rs.api.RSHashTable;
import net.runelite.rs.api.RSIndexedSprite;
<<<<<<< HEAD
import net.runelite.rs.api.RSItem;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.rs.api.RSItemContainer;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSName;
import net.runelite.rs.api.RSNameable;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSWidget;
<<<<<<< HEAD
import org.slf4j.Logger;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@Mixin(RSClient.class)
public abstract class RSClientMixin implements RSClient
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
<<<<<<< HEAD
	@javax.inject.Inject
	private Callbacks callbacks;

	@Inject
	@javax.inject.Inject
	@Named("Core Logger")
	private Logger logger;

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private static int tickCount;

	@Inject
	private static boolean interpolatePlayerAnimations;

	@Inject
	private static boolean interpolateNpcAnimations;

	@Inject
	private static boolean interpolateObjectAnimations;

	@Inject
	private static RSPlayer[] oldPlayers = new RSPlayer[2048];

	@Inject
	private static int itemPressedDurationBuffer;

	@Inject
	private static int inventoryDragDelay;

	@Inject
	private static int oldMenuEntryCount;

	@Inject
<<<<<<< HEAD
	private static RSItem lastItemDespawn;

	@Inject
	@Override
	public Callbacks getCallbacks()
	{
		return callbacks;
	}

	@Inject
	@Override
	public Logger getLogger()
	{
		return logger;
	}

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Override
	public boolean isInterpolatePlayerAnimations()
	{
		return interpolatePlayerAnimations;
	}

	@Inject
	@Override
	public void setInterpolatePlayerAnimations(boolean interpolate)
	{
		interpolatePlayerAnimations = interpolate;
	}

	@Inject
	@Override
	public boolean isInterpolateNpcAnimations()
	{
		return interpolateNpcAnimations;
	}

	@Inject
	@Override
	public void setInterpolateNpcAnimations(boolean interpolate)
	{
		interpolateNpcAnimations = interpolate;
	}

	@Inject
	@Override
	public boolean isInterpolateObjectAnimations()
	{
		return interpolateObjectAnimations;
	}

	@Inject
	@Override
	public void setInterpolateObjectAnimations(boolean interpolate)
	{
		interpolateObjectAnimations = interpolate;
	}

	@Inject
	@Override
	public void setInventoryDragDelay(int delay)
	{
		inventoryDragDelay = delay;
	}

	@Inject
	@Override
	public AccountType getAccountType()
	{
		int varbit = getVar(Varbits.ACCOUNT_TYPE);

		switch (varbit)
		{
			case 1:
				return AccountType.IRONMAN;
			case 2:
				return AccountType.ULTIMATE_IRONMAN;
			case 3:
				return AccountType.HARDCORE_IRONMAN;
		}

		return AccountType.NORMAL;
	}

	@Inject
	@Override
<<<<<<< HEAD
	public Tile getSelectedSceneTile()
	{
		int tileX = getSelectedSceneTileX();
		int tileY = getSelectedSceneTileY();
=======
	public Tile getSelectedRegionTile()
	{
		int tileX = getSelectedRegionTileX();
		int tileY = getSelectedRegionTileY();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		if (tileX == -1 || tileY == -1)
		{
			return null;
		}

<<<<<<< HEAD
		return getScene().getTiles()[getPlane()][tileX][tileY];
=======
		return getRegion().getTiles()[getPlane()][tileX][tileY];
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public List<Player> getPlayers()
	{
		int validPlayerIndexes = getPlayerIndexesCount();
		int[] playerIndexes = getPlayerIndices();
		Player[] cachedPlayers = getCachedPlayers();
		List<Player> players = new ArrayList<Player>(validPlayerIndexes);

		for (int i = 0; i < validPlayerIndexes; ++i)
		{
			players.add(cachedPlayers[playerIndexes[i]]);
		}

		return players;
	}

	@Inject
	@Override
	public List<NPC> getNpcs()
	{
		int validNpcIndexes = getNpcIndexesCount();
		int[] npcIndexes = getNpcIndices();
		NPC[] cachedNpcs = getCachedNPCs();
		List<NPC> npcs = new ArrayList<NPC>(validNpcIndexes);

		for (int i = 0; i < validNpcIndexes; ++i)
		{
			npcs.add(cachedNpcs[npcIndexes[i]]);
		}

		return npcs;
	}

	@Inject
	@Override
	public int getBoostedSkillLevel(Skill skill)
	{
		int[] boostedLevels = getBoostedSkillLevels();
		return boostedLevels[skill.ordinal()];
	}

	@Inject
	@Override
	public int getRealSkillLevel(Skill skill)
	{
		int[] realLevels = getRealSkillLevels();
		return realLevels[skill.ordinal()];
	}

	@Inject
	@Override
	public void addChatMessage(ChatMessageType type, String name, String message, String sender)
	{
		addChatMessage(type.getType(), name, message, sender);
	}

	@Inject
	@Override
	public GameState getGameState()
	{
		return GameState.of(getRSGameState());
	}

	@Inject
	@Override
	public Point getMouseCanvasPosition()
	{
		return new Point(getMouseX(), getMouseY());
	}

	@Inject
	@Override
	public Widget[] getWidgetRoots()
	{
		int topGroup = getWidgetRoot();
		List<Widget> widgets = new ArrayList<Widget>();
<<<<<<< HEAD
		for (RSWidget widget : getWidgets()[topGroup])
		{
			if (widget != null && widget.getRSParentId() == -1)
=======
		for (Widget widget : getWidgets()[topGroup])
		{
			if (widget != null && widget.getParentId() == -1)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				widgets.add(widget);
			}
		}
		return widgets.toArray(new Widget[widgets.size()]);
	}

	@Inject
	@Override
	public Widget getWidget(WidgetInfo widget)
	{
		int groupId = widget.getGroupId();
		int childId = widget.getChildId();

		return getWidget(groupId, childId);
	}

	@Inject
	@Override
<<<<<<< HEAD
	public RSWidget[] getGroup(int groupId)
=======
	public Widget[] getGroup(int groupId)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		RSWidget[][] widgets = getWidgets();

		if (widgets == null || groupId < 0 || groupId >= widgets.length || widgets[groupId] == null)
		{
			return null;
		}

<<<<<<< HEAD
		return widgets[groupId];
=======
		List<Widget> w = new ArrayList<Widget>();
		for (Widget widget : widgets[groupId])
		{
			if (widget != null)
			{
				w.add(widget);
			}
		}
		return w.toArray(new Widget[w.size()]);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public Widget getWidget(int groupId, int childId)
	{
		RSWidget[][] widgets = getWidgets();

		if (widgets == null || widgets.length <= groupId)
		{
			return null;
		}

		RSWidget[] childWidgets = widgets[groupId];
		if (childWidgets == null || childWidgets.length <= childId)
		{
			return null;
		}

		return childWidgets[childId];
	}

	@Inject
	@Override
	public int getVar(VarPlayer varPlayer)
	{
		int[] varps = getVarps();
		return varps[varPlayer.getId()];
	}

	@Inject
	@Override
<<<<<<< HEAD
	public int getVarpValue(int[] varps, int varpId)
	{
		return varps[varpId];
	}

	@Inject
	@Override
	public void setVarpValue(int[] varps, int varpId, int value)
	{
		varps[varpId] = value;
	}

	@Inject
	@Override
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public boolean isPrayerActive(Prayer prayer)
	{
		return getVar(prayer.getVarbit()) == 1;
	}

	/**
	 * Returns the local player's current experience in the specified
	 * {@link Skill}.
	 *
	 * @param skill the {@link Skill} to retrieve the experience for
	 * @return the local player's current experience in the specified
	 * {@link Skill}, or -1 if the {@link Skill} isn't valid
	 */
	@Inject
	@Override
	public int getSkillExperience(Skill skill)
	{
		int[] experiences = getSkillExperiences();

		if (skill == Skill.OVERALL)
		{
			int totalExperience = 0;

			for (int experience : experiences)
			{
				totalExperience += experience;
			}

			return totalExperience;
		}

		int idx = skill.ordinal();

		// I'm not certain exactly how needed this is, but if the Skill enum is updated in the future
		// to hold something else that's not reported it'll save us from an ArrayIndexOutOfBoundsException.
		if (idx >= experiences.length)
		{
			return -1;
		}

		return experiences[idx];
	}

	@Inject
	@Override
	public void refreshChat()
	{
		setChatCycle(getCycleCntr());
	}

	@Inject
	@Override
	public Widget getViewportWidget()
	{
		if (isResized())
		{
			if (getVar(Varbits.SIDE_PANELS) == 1)
			{
				return getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE);
			}
			else
			{
				return getWidget(WidgetInfo.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX);
			}
		}
		return getWidget(WidgetInfo.FIXED_VIEWPORT);
	}

	@Inject
	@Override
	public MenuEntry[] getMenuEntries()
	{
		int count = getMenuOptionCount();
		String[] menuOptions = getMenuOptions();
		String[] menuTargets = getMenuTargets();
		int[] menuIdentifiers = getMenuIdentifiers();
		int[] menuTypes = getMenuTypes();
		int[] params0 = getMenuActionParams0();
		int[] params1 = getMenuActionParams1();

		MenuEntry[] entries = new MenuEntry[count];
		for (int i = 0; i < count; ++i)
		{
			MenuEntry entry = entries[i] = new MenuEntry();
			entry.setOption(menuOptions[i]);
			entry.setTarget(menuTargets[i]);
			entry.setIdentifier(menuIdentifiers[i]);
			entry.setType(menuTypes[i]);
			entry.setParam0(params0[i]);
			entry.setParam1(params1[i]);
		}
		return entries;
	}

	@Inject
	@Override
	public void setMenuEntries(MenuEntry[] entries)
	{
		int count = 0;
		String[] menuOptions = getMenuOptions();
		String[] menuTargets = getMenuTargets();
		int[] menuIdentifiers = getMenuIdentifiers();
		int[] menuTypes = getMenuTypes();
		int[] params0 = getMenuActionParams0();
		int[] params1 = getMenuActionParams1();

		for (MenuEntry entry : entries)
		{
			menuOptions[count] = entry.getOption();
			menuTargets[count] = entry.getTarget();
			menuIdentifiers[count] = entry.getIdentifier();
			menuTypes[count] = entry.getType();
			params0[count] = entry.getParam0();
			params1[count] = entry.getParam1();
			++count;
		}

		setMenuOptionCount(count);
		oldMenuEntryCount = count;
	}

	@FieldHook("menuOptionCount")
	@Inject
	public static void onMenuOptionsChanged(int idx)
	{
		int oldCount = oldMenuEntryCount;
		int newCount = client.getMenuOptionCount();

		oldMenuEntryCount = newCount;

		if (newCount == oldCount + 1)
		{
			MenuEntryAdded event = new MenuEntryAdded(
				client.getMenuOptions()[newCount - 1],
				client.getMenuTargets()[newCount - 1],
				client.getMenuTypes()[newCount - 1],
				client.getMenuIdentifiers()[newCount - 1],
				client.getMenuActionParams0()[newCount - 1],
				client.getMenuActionParams1()[newCount - 1]
			);

<<<<<<< HEAD
			client.getCallbacks().post(event);
=======
			eventBus.post(event);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Inject
	@Override
	public List<Projectile> getProjectiles()
	{
		List<Projectile> projectiles = new ArrayList<Projectile>();
		RSDeque projectileDeque = this.getProjectilesDeque();
		Node head = projectileDeque.getHead();

		for (Node node = head.getNext(); node != head; node = node.getNext())
		{
			projectiles.add((Projectile) node);
		}

		return projectiles;
	}

	@Inject
	@Override
	public List<GraphicsObject> getGraphicsObjects()
	{
		List<GraphicsObject> graphicsObjects = new ArrayList<GraphicsObject>();
		RSDeque graphicsObjectDeque = this.getGraphicsObjectDeque();
		Node head = graphicsObjectDeque.getHead();

		for (Node node = head.getNext(); node != head; node = node.getNext())
		{
<<<<<<< HEAD
			graphicsObjects.add((GraphicsObject) node);
=======
			graphicsObjects.add((GraphicsObject)node);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}

		return graphicsObjects;
	}

	@Inject
	@Override
	public void setModIcons(IndexedSprite[] modIcons)
	{
		setRSModIcons((RSIndexedSprite[]) modIcons);
	}

	@Inject
	@Override
	@Nullable
	public LocalPoint getLocalDestinationLocation()
	{
<<<<<<< HEAD
		int sceneX = getDestinationX();
		int sceneY = getDestinationY();
		if (sceneX != 0 && sceneY != 0)
		{
			return LocalPoint.fromScene(sceneX, sceneY);
=======
		int regionX = getDestinationX();
		int regionY = getDestinationY();
		if (regionX != 0 && regionY != 0)
		{
			return LocalPoint.fromRegion(regionX, regionY);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
		return null;
	}

	@Inject
	@Override
	public void changeMemoryMode(boolean lowMemory)
	{
		setLowMemory(lowMemory);
<<<<<<< HEAD
		setSceneLowMemory(lowMemory);
=======
		setRegionLowMemory(lowMemory);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		setAudioHighMemory(true);
		setObjectCompositionLowDetail(lowMemory);
	}

	@Inject
	@Override
	public RSItemContainer getItemContainer(InventoryID inventory)
	{
		RSHashTable itemContainers = getItemContainers();
		return (RSItemContainer) itemContainers.get(inventory.getId());
	}

	@Inject
	@Override
	public boolean isFriended(String name, boolean mustBeLoggedIn)
	{
		RSName rsName = createName(name, getLoginType());
		return getFriendManager().isFriended(rsName, mustBeLoggedIn);
	}

	@Inject
	@Override
	public int getClanChatCount()
	{
		final RSClanMemberManager clanMemberManager = getClanMemberManager();
		return clanMemberManager != null ? clanMemberManager.getCount() : 0;
	}

	@Inject
	@Override
	public ClanMember[] getClanMembers()
	{
		final RSClanMemberManager clanMemberManager = getClanMemberManager();
		return clanMemberManager != null ? (ClanMember[]) getClanMemberManager().getNameables() : null;
	}

	@Inject
	@Override
	public Friend[] getFriends()
	{
		final RSFriendManager friendManager = getFriendManager();
		if (friendManager == null)
		{
			return null;
		}

		final RSFriendContainer friendContainer = friendManager.getFriendContainer();
		if (friendContainer == null)
		{
			return null;
		}

		RSNameable[] nameables = friendContainer.getNameables();
		return (Friend[]) nameables;
	}

	@Inject
	@Override
	public boolean isClanMember(String name)
	{
		final RSClanMemberManager clanMemberManager = getClanMemberManager();
		return clanMemberManager != null && clanMemberManager.isMember(createName(name, getLoginType()));
	}

	@FieldHook("draggingWidget")
	@Inject
	public static void draggingWidgetChanged(int idx)
	{
		DraggingWidgetChanged draggingWidgetChanged = new DraggingWidgetChanged();
		draggingWidgetChanged.setDraggingWidget(client.isDraggingWidget());
<<<<<<< HEAD
		client.getCallbacks().post(draggingWidgetChanged);
=======
		eventBus.post(draggingWidgetChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public SpritePixels createItemSprite(int itemId, int quantity, int border, int shadowColor, int stackable, boolean noted, int scale)
	{
		assert isClientThread();
		int zoom = get3dZoom();
		set3dZoom(scale);
		try
		{
			return createItemSprite(itemId, quantity, border, shadowColor, stackable, noted);
		}
		finally
		{
			set3dZoom(zoom);
		}
	}

<<<<<<< HEAD
=======
	@Copy("closeWidget")
	public static void rs$closeWidget(WidgetNode widget, boolean b)
	{
		throw new RuntimeException();
	}

	@Replace("closeWidget")
	public static void rl$closeWidget(WidgetNode widget, boolean b)
	{
		MenuEntry[] entries = client.getMenuEntries();
		rs$closeWidget(widget, b);
		client.setMenuEntries(entries);
	}

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Copy("runWidgetOnLoadListener")
	public static void rs$runWidgetOnLoadListener(int groupId)
	{
		throw new RuntimeException();
	}

	@Replace("runWidgetOnLoadListener")
	public static void rl$runWidgetOnLoadListener(int groupId)
	{
		rs$runWidgetOnLoadListener(groupId);

		RSWidget[][] widgets = client.getWidgets();
		boolean loaded = widgets != null && widgets[groupId] != null;

		if (loaded)
		{
			WidgetLoaded event = new WidgetLoaded();
			event.setGroupId(groupId);
<<<<<<< HEAD
			client.getCallbacks().post(event);
=======
			eventBus.post(event);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@FieldHook("itemPressedDuration")
	@Inject
	public static void itemPressedDurationChanged(int idx)
	{
		if (client.getItemPressedDuration() > 0)
		{
			itemPressedDurationBuffer++;
			if (itemPressedDurationBuffer >= inventoryDragDelay)
			{
				client.setItemPressedDuration(itemPressedDurationBuffer);
			}
			else
			{
				client.setItemPressedDuration(0);
			}
		}
		else
		{
			itemPressedDurationBuffer = 0;
		}
	}

	@FieldHook("skillExperiences")
	@Inject
	public static void experiencedChanged(int idx)
	{
		ExperienceChanged experienceChanged = new ExperienceChanged();
		Skill[] possibleSkills = Skill.values();

		// We subtract one here because 'Overall' isn't considered a skill that's updated.
		if (idx < possibleSkills.length - 1)
		{
			Skill updatedSkill = possibleSkills[idx];
			experienceChanged.setSkill(updatedSkill);
<<<<<<< HEAD
			client.getCallbacks().post(experienceChanged);
=======
			eventBus.post(experienceChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@FieldHook("boostedSkillLevels")
	@Inject
	public static void boostedSkillLevelsChanged(int idx)
	{
		Skill[] skills = Skill.values();

		if (idx >= 0 && idx < skills.length - 1)
		{
			Skill updatedSkill = skills[idx];
			BoostedLevelChanged boostedLevelChanged = new BoostedLevelChanged();
			boostedLevelChanged.setSkill(updatedSkill);
<<<<<<< HEAD
			client.getCallbacks().post(boostedLevelChanged);
		}
	}

=======
			eventBus.post(boostedLevelChanged);
		}
	}

	@FieldHook("mapRegions")
	@Inject
	public static void mapRegionsChanged(int idx)
	{
		MapRegionChanged regionChanged = new MapRegionChanged();
		regionChanged.setIndex(idx);
		eventBus.post(regionChanged);
	}

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@FieldHook("playerOptions")
	@Inject
	public static void playerOptionsChanged(int idx)
	{
		// Reset the menu type
		MenuAction[] playerActions = {PLAYER_FIRST_OPTION, PLAYER_SECOND_OPTION, PLAYER_THIRD_OPTION, PLAYER_FOURTH_OPTION,
			PLAYER_FIFTH_OPTION, PLAYER_SIXTH_OPTION, PLAYER_SEVENTH_OPTION, PLAYER_EIGTH_OPTION};
		if (idx >= 0 && idx < playerActions.length)
		{
			MenuAction playerAction = playerActions[idx];
			client.getPlayerMenuTypes()[idx] = playerAction.getId();
		}

		PlayerMenuOptionsChanged optionsChanged = new PlayerMenuOptionsChanged();
		optionsChanged.setIndex(idx);
<<<<<<< HEAD
		client.getCallbacks().post(optionsChanged);
=======
		eventBus.post(optionsChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@FieldHook("gameState")
	@Inject
	public static void gameStateChanged(int idx)
	{
		GameStateChanged gameStateChange = new GameStateChanged();
		gameStateChange.setGameState(client.getGameState());
<<<<<<< HEAD
		client.getCallbacks().post(gameStateChange);
=======
		eventBus.post(gameStateChange);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}


	@FieldHook("cachedNPCs")
	@Inject
	public static void cachedNPCsChanged(int idx)
	{
		RSNPC[] cachedNPCs = client.getCachedNPCs();
		if (idx < 0 || idx >= cachedNPCs.length)
		{
			return;
		}

		RSNPC npc = cachedNPCs[idx];
		if (npc != null)
		{
			npc.setIndex(idx);

<<<<<<< HEAD
			client.getCallbacks().postDeferred(new NpcSpawned(npc));
=======
			deferredEventBus.post(new NpcSpawned(npc));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@FieldHook("cachedPlayers")
	@Inject
	public static void cachedPlayersChanged(int idx)
	{
		RSPlayer[] cachedPlayers = client.getCachedPlayers();
		if (idx < 0 || idx >= cachedPlayers.length)
		{
			return;
		}

		RSPlayer player = cachedPlayers[idx];
		RSPlayer oldPlayer = oldPlayers[idx];
		oldPlayers[idx] = player;

		if (oldPlayer != null)
		{
<<<<<<< HEAD
			client.getCallbacks().post(new PlayerDespawned(oldPlayer));
		}
		if (player != null)
		{
			client.getCallbacks().postDeferred(new PlayerSpawned(player));
=======
			eventBus.post(new PlayerDespawned(oldPlayer));
		}
		if (player != null)
		{
			deferredEventBus.post(new PlayerSpawned(player));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Inject
	@FieldHook("grandExchangeOffers")
	public static void onGrandExchangeOffersChanged(int idx)
	{
		if (idx == -1)
		{
			return;
		}

		GrandExchangeOffer internalOffer = client.getGrandExchangeOffers()[idx];

		if (internalOffer == null)
		{
			return;
		}

		GrandExchangeOfferChanged offerChangedEvent = new GrandExchangeOfferChanged();
		offerChangedEvent.setOffer(internalOffer);
		offerChangedEvent.setSlot(idx);
<<<<<<< HEAD
		client.getCallbacks().post(offerChangedEvent);
=======
		eventBus.post(offerChangedEvent);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@FieldHook("clientVarps")
	@Inject
	public static void settingsChanged(int idx)
	{
		VarbitChanged varbitChanged = new VarbitChanged();
<<<<<<< HEAD
		client.getCallbacks().post(varbitChanged);
=======
		eventBus.post(varbitChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@FieldHook("isResized")
	@Inject
	public static void resizeChanged(int idx)
	{
		//maybe couple with varbitChanged. resizeable may not be a varbit but it would fit with the other client settings.
		ResizeableChanged resizeableChanged = new ResizeableChanged();
		resizeableChanged.setResized(client.isResized());
<<<<<<< HEAD
		client.getCallbacks().post(resizeableChanged);
=======
		eventBus.post(resizeableChanged);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@FieldHook("clanMemberManager")
	@Inject
	public static void clanMemberManagerChanged(int idx)
	{
<<<<<<< HEAD
		client.getCallbacks().post(new ClanChanged(client.getClanMemberManager() != null));
=======
		eventBus.post(new ClanChanged(client.getClanMemberManager() != null));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public boolean hasHintArrow()
	{
<<<<<<< HEAD
		return client.getHintArrowTargetType() != HintArrowType.NONE.getValue();
	}

	@Inject
	@Override
	public HintArrowType getHintArrowType()
	{
		int type = client.getHintArrowTargetType();
		if (type == HintArrowType.NPC.getValue())
		{
			return HintArrowType.NPC;
		}
		else if (type == HintArrowType.PLAYER.getValue())
		{
			return HintArrowType.PLAYER;
		}
		else if (type == HintArrowType.WORLD_POSITION.getValue())
		{
			return HintArrowType.WORLD_POSITION;
		}
		else
		{
			return HintArrowType.NONE;
		}
=======
		return client.getHintArrowTargetType() == HintArrowType.NONE.getValue();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Inject
	@Override
	public void clearHintArrow()
	{
		client.setHintArrowTargetType(HintArrowType.NONE.getValue());
	}

	@Inject
	@Override
	public void setHintArrow(NPC npc)
	{
		client.setHintArrowTargetType(HintArrowType.NPC.getValue());
		client.setHintArrowNpcTargetIdx(npc.getIndex());
	}

	@Inject
	@Override
	public void setHintArrow(Player player)
	{
		client.setHintArrowTargetType(HintArrowType.PLAYER.getValue());
		client.setHintArrowPlayerTargetIdx(((RSPlayer) player).getPlayerId());
	}

	@Inject
	@Override
	public void setHintArrow(WorldPoint point)
	{
		client.setHintArrowTargetType(HintArrowType.WORLD_POSITION.getValue());
		client.setHintArrowX(point.getX());
		client.setHintArrowY(point.getY());
		// position the arrow in center of the tile
		client.setHintArrowOffsetX(LOCAL_TILE_SIZE / 2);
		client.setHintArrowOffsetY(LOCAL_TILE_SIZE / 2);
	}

<<<<<<< HEAD
	@Inject
	@Override
	public WorldPoint getHintArrowPoint()
	{
		if (getHintArrowType() == HintArrowType.WORLD_POSITION)
		{
			int x = client.getHintArrowX();
			int y = client.getHintArrowY();
			return new WorldPoint(x, y, client.getPlane());
		}

		return null;
	}

	@Inject
	@Override
	public Player getHintArrowPlayer()
	{
		if (getHintArrowType() == HintArrowType.PLAYER)
		{
			int idx = client.getHintArrowPlayerTargetIdx();
			RSPlayer[] players = client.getCachedPlayers();

			if (idx < 0 || idx >= players.length)
			{
				return null;
			}

			return players[idx];
		}

		return null;
	}

	@Inject
	@Override
	public NPC getHintArrowNpc()
	{
		if (getHintArrowType() == HintArrowType.NPC)
		{
			int idx = client.getHintArrowNpcTargetIdx();
			RSNPC[] npcs = client.getCachedNPCs();

			if (idx < 0 || idx >= npcs.length)
			{
				return null;
			}

			return npcs[idx];
		}

		return null;
	}

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	@Copy("menuAction")
	static void rs$menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7)
	{
		throw new RuntimeException();
	}

	@Replace("menuAction")
<<<<<<< HEAD
	static void rl$menuAction(int actionParam, int widgetId, int menuAction, int id, String menuOption, String menuTarget, int var6, int var7)
	{
		/* Along the way, the RuneScape client may change a menuAction by incrementing it with 2000.
		 * I have no idea why, but it does. Their code contains the same conditional statement.
		 */
		if (menuAction >= 2000)
		{
			menuAction -= 2000;
		}

		final MenuOptionClicked menuOptionClicked = new MenuOptionClicked();
		menuOptionClicked.setActionParam(actionParam);
		menuOptionClicked.setMenuOption(menuOption);
		menuOptionClicked.setMenuTarget(menuTarget);
		menuOptionClicked.setMenuAction(MenuAction.of(menuAction));
		menuOptionClicked.setId(id);
		menuOptionClicked.setWidgetId(widgetId);
		client.getCallbacks().post(menuOptionClicked);

		if (menuOptionClicked.isConsumed())
		{
			return;
		}

		rs$menuAction(actionParam, widgetId, menuAction, id, menuOption, menuTarget, var6, var7);
=======
	static void rl$menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7)
	{
		if (Hooks.menuActionHook(var0, var1, var2, var3, var4, var5, var6, var7))
		{
			return;
		}
		rs$menuAction(var0, var1, var2, var3, var4, var5, var6, var7);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@FieldHook("username")
	@Inject
	public static void onUsernameChanged(int idx)
	{
<<<<<<< HEAD
		client.getCallbacks().post(new UsernameChanged());
=======
		eventBus.post(new UsernameChanged());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Override
	@Inject
	public int getTickCount()
	{
		return tickCount;
	}

	@Override
	@Inject
	public void setTickCount(int tick)
	{
		tickCount = tick;
	}

	@Inject
	@Override
	public EnumSet<WorldType> getWorldType()
	{
		int flags = getFlags();
		return WorldType.fromMask(flags);
	}
<<<<<<< HEAD

	@Inject
	@MethodHook("openMenu")
	public void menuOpened(int var1, int var2)
	{
		final MenuOpened event = new MenuOpened();
		event.setMenuEntries(getMenuEntries());
		callbacks.post(event);
	}

	@Inject
	@MethodHook("updateNpcs")
	public static void updateNpcs(boolean var0, PacketBuffer var1)
	{
		client.getCallbacks().updateNpcs();
	}

	@Inject
	@MethodHook("addChatMessage")
	public static void onAddChatMessage(int type, String name, String message, String sender)
	{
		Logger logger = client.getLogger();
		if (logger.isDebugEnabled())
		{
			logger.debug("Chat message type {}: {}", ChatMessageType.of(type), message);
		}

		final ChatMessageType chatMessageType = ChatMessageType.of(type);
		final ChatMessage chatMessage = new ChatMessage(chatMessageType, name, message, sender);
		client.getCallbacks().post(chatMessage);
	}

	@Inject
	@MethodHook("methodDraw")
	public void methodDraw(boolean var1)
	{
		callbacks.clientMainLoop();
	}

	@MethodHook("gameDraw")
	@Inject
	public static void gameDraw(Widget[] widgets, int parentId, int var2, int var3, int var4, int var5, int x, int y, int var8)
	{
		for (Widget rlWidget : widgets)
		{
			RSWidget widget = (RSWidget) rlWidget;
			if (widget == null || widget.getRSParentId() != parentId)
			{
				continue;
			}

			if (parentId != -1)
			{
				widget.setRenderParentId(parentId);
			}
			widget.setRenderX(x + widget.getRelativeX());
			widget.setRenderY(y + widget.getRelativeY());

			HashTable<WidgetNode> componentTable = client.getComponentTable();
			WidgetNode childNode = componentTable.get(widget.getId());
			if (childNode != null)
			{
				int widgetId = widget.getId();
				int groupId = childNode.getId();
				RSWidget[] children = client.getWidgets()[groupId];

				for (RSWidget child : children)
				{
					if (child.getRSParentId() == -1)
					{
						child.setRenderParentId(widgetId);
					}
				}
			}
		}
	}

	@Inject
	@Override
	public RSItem getLastItemDespawn()
	{
		return lastItemDespawn;
	}

	@Inject
	@Override
	public void setLastItemDespawn(RSItem lastItemDespawn)
	{
		RSClientMixin.lastItemDespawn = lastItemDespawn;
	}
}
=======
}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
