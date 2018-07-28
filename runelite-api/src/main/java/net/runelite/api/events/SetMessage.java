package net.runelite.api.events;

import lombok.Data;
import net.runelite.api.ChatMessageType;
import net.runelite.api.MessageNode;

/**
<<<<<<< HEAD
 * An event where a {@link MessageNode} has had its message set.
 * <p>
 * Called whenever a message is received in the chat box.
 * <p>
 * Editing the {@link #messageNode} properties will reflect the change when
 * the message in the chat is rendered. The original values of the message
 * are held by the other fields of this event.
=======
 * called when a message node's message is set
 *
 * @author Adam
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
 */
@Data
public class SetMessage
{
<<<<<<< HEAD
	/**
	 * The updated message node.
	 */
	private MessageNode messageNode;
	/**
	 * The set message type.
	 */
	private ChatMessageType type;
	/**
	 * The name of the player that sent the message.
	 */
	private String name;
	/**
	 * The sender of the message (ie. clan name).
	 */
	private String sender;
	/**
	 * The new message value.
	 */
=======
	private MessageNode messageNode;
	private ChatMessageType type;
	private String name;
	private String sender;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private String value;
}
