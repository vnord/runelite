/*
 * Copyright (c) 2018, Rheon <https://github.com/Rheon-D>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.friendnotes;

import com.google.common.base.Strings;
import com.google.common.collect.ObjectArrays;
import com.google.common.eventbus.Subscribe;
<<<<<<< HEAD
import javax.annotation.Nullable;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Nameable;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NameableNameChanged;
import net.runelite.api.events.RemovedFriend;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ChatboxInputManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Friend Notes",
	description = "Store notes about your friends"
)
public class FriendNotesPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "friendNotes";
	private static final int CHARACTER_LIMIT = 128;
	private static final String KEY_PREFIX = "note_";
=======
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(name = "Friend Notes")
public class FriendNotesPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "friendNotes";

	private static final int CHARACTER_LIMIT = 128;

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private static final String ADD_NOTE = "Add Note";
	private static final String EDIT_NOTE = "Edit Note";
	private static final String NOTE_PROMPT_FORMAT = "%s's Notes<br>" +
		"<col=0000AA>(Limit %s Characters)";

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
<<<<<<< HEAD
	private OverlayManager overlayManager;

	@Inject
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private FriendNoteOverlay overlay;

	@Inject
	private ChatboxInputManager chatboxInputManager;

	@Getter
	private HoveredFriend hoveredFriend = null;

	@Override
<<<<<<< HEAD
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	/**
	 * Set a friend note, or unset by passing a null/empty note.
	 */
	private void setFriendNote(String displayName, String note)
	{
		if (Strings.isNullOrEmpty(note))
		{
			configManager.unsetConfiguration(CONFIG_GROUP, KEY_PREFIX + displayName);
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, KEY_PREFIX + displayName, note);
		}
	}

	/**
	 * Get the friend note of a display name, or null if no friend note exists for it.
	 */
	@Nullable
	private String getFriendNote(String displayName)
	{
		return configManager.getConfiguration(CONFIG_GROUP, KEY_PREFIX + displayName);
	}

	/**
	 * Migrate a friend note to a new display name, and remove the previous one.
	 * If current name already has a note, or previous name had none, do nothing.
	 */
	private void migrateFriendNote(String currentDisplayName, String prevDisplayName)
	{
		final String currentNote = getFriendNote(currentDisplayName);
		if (currentNote == null)
		{
			final String prevNote = getFriendNote(prevDisplayName);
			if (prevNote != null)
			{
				log.debug("Update friend's username: '{}' -> '{}'", prevDisplayName, currentDisplayName);
				setFriendNote(prevDisplayName, null);
				setFriendNote(currentDisplayName, prevNote);
=======
	public Overlay getOverlay()
	{
		return overlay;
	}

	private void setFriendNote(String friend, String note)
	{
		if (!Strings.isNullOrEmpty(note))
		{
			configManager.setConfiguration(CONFIG_GROUP, "note_" + friend, note);
		}
		else
		{
			configManager.unsetConfiguration(CONFIG_GROUP, "note_" + friend);
		}
	}

	private String getFriendNote(String friend)
	{
		return configManager.getConfiguration(CONFIG_GROUP, "note_" + friend);
	}

	private void checkNameChange(String currentDisplayName, String previousDisplayName)
	{
		String currentNote = getFriendNote(currentDisplayName);
		if (currentNote == null)
		{
			String prevNote = getFriendNote(previousDisplayName);
			if (prevNote != null)
			{
				setFriendNote(previousDisplayName, null);
				setFriendNote(currentDisplayName, prevNote);
				log.debug("Updating friends username: '{}' '{}'", currentDisplayName, previousDisplayName);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}
	}

<<<<<<< HEAD
	/**
	 * Set the currently hovered display name, if a friend note exists for it.
	 */
	private void setHoveredFriend(String displayName)
	{
		hoveredFriend = null;

		if (!Strings.isNullOrEmpty(displayName))
		{
			final String note = getFriendNote(displayName);
			if (note != null)
			{
				hoveredFriend = new HoveredFriend(displayName, note);
=======
	private void setCurrentFriend(String target)
	{
		hoveredFriend = null;

		if (!Strings.isNullOrEmpty(target))
		{
			target = Text.removeTags(target);
			String targetNote = getFriendNote(target);
			if (targetNote != null)
			{
				hoveredFriend = new HoveredFriend(target, targetNote);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		final int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());

<<<<<<< HEAD
		// Look for "Message" on friends list
		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() && event.getOption().equals("Message"))
		{
			// Friends have color tags
			setHoveredFriend(Text.removeTags(event.getTarget()));

			// Build "Add Note" or "Edit Note" menu entry
			final MenuEntry addNote = new MenuEntry();
			addNote.setOption(hoveredFriend == null || hoveredFriend.getNote() == null ? ADD_NOTE : EDIT_NOTE);
			addNote.setType(MenuAction.RUNELITE.getId());
			addNote.setTarget(event.getTarget()); //Preserve color codes here
=======
		// look for "Message" on friends list
		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() && event.getOption().equals("Message"))
		{
			setCurrentFriend(event.getTarget());

			final MenuEntry addNote = new MenuEntry();
			addNote.setOption(hoveredFriend == null || hoveredFriend.getNote() == null ? ADD_NOTE : EDIT_NOTE);
			addNote.setType(MenuAction.RUNELITE.getId());
			addNote.setTarget(event.getTarget());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			addNote.setParam0(event.getActionParam0());
			addNote.setParam1(event.getActionParam1());

			// Add menu entry
<<<<<<< HEAD
			final MenuEntry[] menuEntries = ObjectArrays.concat(client.getMenuEntries(), addNote);
=======
			MenuEntry[] menuEntries = ObjectArrays.concat(client.getMenuEntries(), addNote);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			client.setMenuEntries(menuEntries);
		}
		else if (hoveredFriend != null)
		{
			hoveredFriend = null;
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (WidgetInfo.TO_GROUP(event.getWidgetId()) == WidgetInfo.FRIENDS_LIST.getGroupId())
		{
			if (Strings.isNullOrEmpty(event.getMenuTarget()))
			{
				return;
			}

<<<<<<< HEAD
			//Friends have color tags
			final String sanitizedTarget = Text.removeTags(event.getMenuTarget());

			// Handle clicks on "Add Note" or "Edit Note"
=======
			final String sanitizedTarget = Text.removeTags(event.getMenuTarget());

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			if (event.getMenuOption().equals(ADD_NOTE) || event.getMenuOption().equals(EDIT_NOTE))
			{
				event.consume();

<<<<<<< HEAD
				final String note = getFriendNote(sanitizedTarget);

				// Open the chatbox input dialog
=======
				String note = getFriendNote(sanitizedTarget);

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				chatboxInputManager.openInputWindow(String.format(NOTE_PROMPT_FORMAT, sanitizedTarget,
					CHARACTER_LIMIT), Strings.nullToEmpty(note), CHARACTER_LIMIT, (content) ->
				{
					if (content == null)
					{
						return;
					}

					content = Text.removeTags(content).trim();
					log.debug("Set note for '{}': '{}'", sanitizedTarget, content);
					setFriendNote(sanitizedTarget, content);
				});
			}
		}

	}

	@Subscribe
<<<<<<< HEAD
	public void onNameableNameChange(NameableNameChanged event)
	{
		final Nameable nameable = event.getNameable();

		if (nameable instanceof Friend)
		{
			// Migrate a friend's note to their new display name
			final Friend friend = (Friend) nameable;
			migrateFriendNote(friend.getName(), friend.getPrevName());
=======
	public void onNameableNameChange(NameableNameChanged nameableNameChanged)
	{
		Nameable nameable = nameableNameChanged.getNameable();

		if (nameable instanceof Friend)
		{
			Friend friend = (Friend) nameable;
			String name = friend.getName();
			String prevName = friend.getPrevName();
			checkNameChange(name, prevName);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	@Subscribe
<<<<<<< HEAD
	public void onRemoveFriend(RemovedFriend event)
	{
		// Delete a friend's note if they are removed
		final String displayName = event.getName();
		log.debug("Remove friend: '{}'", displayName);
		setFriendNote(displayName, null);
=======
	public void onRemoveFriend(RemovedFriend removedFriend)
	{
		String name = removedFriend.getName();
		log.debug("Removed friend: '{}'", name);
		setFriendNote(name, null);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
