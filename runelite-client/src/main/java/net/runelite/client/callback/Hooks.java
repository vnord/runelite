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
package net.runelite.client.callback;

import com.google.common.eventbus.EventBus;
import com.google.inject.Injector;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
<<<<<<< HEAD
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.RenderingHints;
=======
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
<<<<<<< HEAD
import java.awt.image.VolatileImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MainBufferProvider;
import net.runelite.api.RenderOverview;
import net.runelite.api.WorldMapManager;
import net.runelite.api.events.GameTick;
import net.runelite.api.hooks.Callbacks;
=======
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Hitsplat;
import net.runelite.api.ItemComposition;
import net.runelite.api.KeyFocusListener;
import net.runelite.api.MainBufferProvider;
import net.runelite.api.MenuAction;
import net.runelite.api.MessageNode;
import net.runelite.api.PacketBuffer;
import net.runelite.api.Projectile;
import net.runelite.api.Region;
import net.runelite.api.RenderOverview;
import net.runelite.api.TextureProvider;
import net.runelite.api.WorldMapManager;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PostItemComposition;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.SetMessage;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetInfo.WORLD_MAP_VIEW;
import net.runelite.client.Notifier;
import net.runelite.client.RuneLite;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.task.Scheduler;
<<<<<<< HEAD
import net.runelite.client.ui.ClientUI;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayRenderer;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.DeferredEventBus;
<<<<<<< HEAD

/**
 * This class contains field required for mixins and runelite hooks to work.
 * All remaining method hooks in this class are performance-critical or contain client-specific logic and so they
 * can't just be placed in mixins or sent through event bus.
 */
@Singleton
@Slf4j
public class Hooks implements Callbacks
{
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks
{
	// must be public as the mixins use it
	public static final Logger log = LoggerFactory.getLogger(Hooks.class);

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private static final long CHECK = 600; // ms - how often to run checks

	private static final Injector injector = RuneLite.getInjector();
	private static final Client client = injector.getInstance(Client.class);
<<<<<<< HEAD
	private static final OverlayRenderer renderer = injector.getInstance(OverlayRenderer.class);

	private static final GameTick GAME_TICK = new GameTick();

	@Inject
	private EventBus eventBus;

	@Inject
	private DeferredEventBus deferredEventBus;

	@Inject
	private Scheduler scheduler;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private DrawManager drawManager;

	@Inject
	private Notifier notifier;

	@Inject
	private ClientUI clientUi;

	private Dimension lastStretchedDimensions;
	private VolatileImage stretchedImage;
	private Graphics2D stretchedGraphics;

	private long lastCheck;
	private boolean shouldProcessGameTick;

	@Override
	public void post(Object event)
	{
		eventBus.post(event);
	}

	@Override
	public void postDeferred(Object event)
	{
		deferredEventBus.post(event);
	}

	@Override
	public void clientMainLoop()
=======
	public static final EventBus eventBus = injector.getInstance(EventBus.class); // symbol must match mixin Hook
	private static final DeferredEventBus _deferredEventBus = injector.getInstance(DeferredEventBus.class);
	public static final EventBus deferredEventBus = _deferredEventBus; // symbol must match mixin Hook
	private static final Scheduler scheduler = injector.getInstance(Scheduler.class);
	private static final InfoBoxManager infoBoxManager = injector.getInstance(InfoBoxManager.class);
	private static final ChatMessageManager chatMessageManager = injector.getInstance(ChatMessageManager.class);
	private static final OverlayRenderer renderer = injector.getInstance(OverlayRenderer.class);
	private static final MouseManager mouseManager = injector.getInstance(MouseManager.class);
	private static final KeyManager keyManager = injector.getInstance(KeyManager.class);
	private static final ClientThread clientThread = injector.getInstance(ClientThread.class);
	private static final GameTick tick = new GameTick();
	private static final DrawManager renderHooks = injector.getInstance(DrawManager.class);
	private static final Notifier notifier = injector.getInstance(Notifier.class);

	private static Dimension lastStretchedDimensions;
	private static BufferedImage stretchedImage;
	private static Graphics2D stretchedGraphics;

	private static long lastCheck;
	private static boolean shouldProcessGameTick;

	public static void clientMainLoop(Client client, boolean arg1)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		if (shouldProcessGameTick)
		{
			shouldProcessGameTick = false;

<<<<<<< HEAD
			deferredEventBus.replay();

			eventBus.post(GAME_TICK);
=======
			_deferredEventBus.replay();

			eventBus.post(tick);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			int tick = client.getTickCount();
			client.setTickCount(tick + 1);
		}

		clientThread.invoke();

		long now = System.currentTimeMillis();

		if (now - lastCheck < CHECK)
		{
			return;
		}

		lastCheck = now;

		try
		{
			// tick pending scheduled tasks
			scheduler.tick();

			// cull infoboxes
			infoBoxManager.cull();

			chatMessageManager.process();

			checkWorldMap();
		}
		catch (Exception ex)
		{
			log.warn("error during main loop tasks", ex);
		}
	}

	/**
	 * When the world map opens it loads about ~100mb of data into memory, which
	 * represents about half of the total memory allocated by the client.
	 * This gets cached and never released, which causes GC pressure which can affect
	 * performance. This method reinitailzies the world map cache, which allows the
	 * data to be garbage collecged, and causes the map data from disk each time
	 * is it opened.
	 */
<<<<<<< HEAD
	private void checkWorldMap()
=======
	private static void checkWorldMap()
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		Widget widget = client.getWidget(WORLD_MAP_VIEW);

		if (widget != null)
		{
			return;
		}

		RenderOverview renderOverview = client.getRenderOverview();

		if (renderOverview == null)
		{
			return;
		}

		WorldMapManager manager = renderOverview.getWorldMapManager();

		if (manager != null && manager.isLoaded())
		{
			log.debug("World map was closed, reinitializing");
			renderOverview.initializeWorldMap(renderOverview.getWorldMapData());
		}
	}

<<<<<<< HEAD
	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
=======
	public static MouseEvent mousePressed(MouseEvent mouseEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMousePressed(mouseEvent);
	}

<<<<<<< HEAD
	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
=======
	public static MouseEvent mouseReleased(MouseEvent mouseEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMouseReleased(mouseEvent);
	}

<<<<<<< HEAD
	@Override
	public MouseEvent mouseClicked(MouseEvent mouseEvent)
=======
	public static MouseEvent mouseClicked(MouseEvent mouseEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMouseClicked(mouseEvent);
	}

<<<<<<< HEAD
	@Override
	public MouseEvent mouseEntered(MouseEvent mouseEvent)
=======
	public static MouseEvent mouseEntered(MouseEvent mouseEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMouseEntered(mouseEvent);
	}

<<<<<<< HEAD
	@Override
	public MouseEvent mouseExited(MouseEvent mouseEvent)
=======
	public static MouseEvent mouseExited(MouseEvent mouseEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMouseExited(mouseEvent);
	}

<<<<<<< HEAD
	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
=======
	public static MouseEvent mouseDragged(MouseEvent mouseEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMouseDragged(mouseEvent);
	}

<<<<<<< HEAD
	@Override
	public MouseEvent mouseMoved(MouseEvent mouseEvent)
=======
	public static MouseEvent mouseMoved(MouseEvent mouseEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMouseMoved(mouseEvent);
	}

<<<<<<< HEAD
	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
=======
	public static MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		return mouseManager.processMouseWheelMoved(event);
	}

<<<<<<< HEAD
	@Override
	public void keyPressed(KeyEvent keyEvent)
=======
	public static void keyPressed(KeyEvent keyEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		keyManager.processKeyPressed(keyEvent);
	}

<<<<<<< HEAD
	@Override
	public void keyReleased(KeyEvent keyEvent)
=======
	public static void keyReleased(KeyEvent keyEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		keyManager.processKeyReleased(keyEvent);
	}

<<<<<<< HEAD
	@Override
	public void keyTyped(KeyEvent keyEvent)
=======
	public static void keyTyped(KeyEvent keyEvent)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		keyManager.processKeyTyped(keyEvent);
	}

<<<<<<< HEAD
	@Override
	public void draw(MainBufferProvider mainBufferProvider, Graphics graphics, int x, int y)
=======
	public static void focusGained(KeyFocusListener l, FocusEvent focusEvent)
	{
		FocusChanged focusChanged = new FocusChanged();
		focusChanged.setFocused(true);

		eventBus.post(focusChanged);
	}

	public static void focusLost(KeyFocusListener l, FocusEvent focusEvent)
	{
		FocusChanged focusChanged = new FocusChanged();
		focusChanged.setFocused(false);

		eventBus.post(focusChanged);
	}

	public static void draw(MainBufferProvider mainBufferProvider, Graphics graphics, int x, int y)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		if (graphics == null)
		{
			return;
		}

<<<<<<< HEAD
		Image image = mainBufferProvider.getImage();
=======
		BufferedImage image = (BufferedImage) mainBufferProvider.getImage();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		final Graphics2D graphics2d = (Graphics2D) image.getGraphics();

		try
		{
			renderer.render(graphics2d, OverlayLayer.ALWAYS_ON_TOP);
		}
		catch (Exception ex)
		{
			log.warn("Error during overlay rendering", ex);
		}

		notifier.processFlash(graphics2d);

		// Stretch the game image if the user has that enabled
		if (!client.isResized() && client.isStretchedEnabled())
		{
<<<<<<< HEAD
			GraphicsConfiguration gc = clientUi.getGraphicsConfiguration();
			Dimension stretchedDimensions = client.getStretchedDimensions();

			if (lastStretchedDimensions == null || !lastStretchedDimensions.equals(stretchedDimensions)
				|| (stretchedImage != null && stretchedImage.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE))
=======
			Dimension stretchedDimensions = client.getStretchedDimensions();

			if (lastStretchedDimensions == null || !lastStretchedDimensions.equals(stretchedDimensions))
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				/*
					Reuse the resulting image instance to avoid creating an extreme amount of objects
				 */
<<<<<<< HEAD
				stretchedImage = gc.createCompatibleVolatileImage(stretchedDimensions.width, stretchedDimensions.height);
=======
				stretchedImage = new BufferedImage(stretchedDimensions.width, stretchedDimensions.height, BufferedImage.TYPE_INT_RGB);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				if (stretchedGraphics != null)
				{
					stretchedGraphics.dispose();
				}
				stretchedGraphics = (Graphics2D) stretchedImage.getGraphics();

				lastStretchedDimensions = stretchedDimensions;
<<<<<<< HEAD

=======
				
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				/*
					Fill Canvas before drawing stretched image to prevent artifacts.
				*/
				graphics.setColor(Color.BLACK);
				graphics.fillRect(0, 0, client.getCanvas().getWidth(), client.getCanvas().getHeight());
			}

			stretchedGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
<<<<<<< HEAD
				client.isStretchedFast()
					? RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
					: RenderingHints.VALUE_INTERPOLATION_BILINEAR);
=======
					client.isStretchedFast()
							? RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
							: RenderingHints.VALUE_INTERPOLATION_BILINEAR);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			stretchedGraphics.drawImage(image, 0, 0, stretchedDimensions.width, stretchedDimensions.height, null);

			image = stretchedImage;
		}

		// Draw the image onto the game canvas
		graphics.drawImage(image, 0, 0, client.getCanvas());

<<<<<<< HEAD
		drawManager.processDrawComplete(image);
	}

	@Override
	public void drawScene()
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		BufferedImage image = (BufferedImage) bufferProvider.getImage();
		Graphics2D graphics2d = image.createGraphics();
=======
		renderHooks.processDrawComplete(image);
	}

	public static void drawRegion(Region region, int var1, int var2, int var3, int var4, int var5, int var6)
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		BufferedImage image = (BufferedImage) bufferProvider.getImage();
		Graphics2D graphics2d = (Graphics2D) image.getGraphics();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		try
		{
			renderer.render(graphics2d, OverlayLayer.ABOVE_SCENE);
		}
		catch (Exception ex)
		{
			log.warn("Error during overlay rendering", ex);
		}
<<<<<<< HEAD
		finally
		{
			graphics2d.dispose();
		}
	}

	@Override
	public void drawAboveOverheads()
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		BufferedImage image = (BufferedImage) bufferProvider.getImage();
		Graphics2D graphics2d = image.createGraphics();
=======
	}

	public static void drawAboveOverheads(TextureProvider textureProvider, int var1)
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		BufferedImage image = (BufferedImage) bufferProvider.getImage();
		Graphics2D graphics2d = (Graphics2D) image.getGraphics();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		try
		{
			renderer.render(graphics2d, OverlayLayer.UNDER_WIDGETS);
		}
		catch (Exception ex)
		{
			log.warn("Error during overlay rendering", ex);
		}
<<<<<<< HEAD
		finally
		{
			graphics2d.dispose();
		}
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	public static void drawAfterWidgets()
	{
		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		BufferedImage image = (BufferedImage) bufferProvider.getImage();
<<<<<<< HEAD
		Graphics2D graphics2d = image.createGraphics();
=======
		Graphics2D graphics2d = (Graphics2D) image.getGraphics();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		try
		{
			renderer.render(graphics2d, OverlayLayer.ABOVE_WIDGETS);
		}
		catch (Exception ex)
		{
			log.warn("Error during overlay rendering", ex);
		}
<<<<<<< HEAD
		finally
		{
			graphics2d.dispose();
		}
	}

	@Override
	public void updateNpcs()
=======
	}

	public static boolean menuActionHook(int actionParam, int widgetId, int menuAction, int id, String menuOption, String menuTarget, int var6, int var7)
	{
		/* Along the way, the RuneScape client may change a menuAction by incrementing it with 2000.
		 * I have no idea why, but it does. Their code contains the same conditional statement.
		 */
		if (menuAction >= 2000)
		{
			menuAction -= 2000;
		}

		MenuOptionClicked menuOptionClicked = new MenuOptionClicked();
		menuOptionClicked.setActionParam(actionParam);
		menuOptionClicked.setMenuOption(menuOption);
		menuOptionClicked.setMenuTarget(menuTarget);
		menuOptionClicked.setMenuAction(MenuAction.of(menuAction));
		menuOptionClicked.setId(id);
		menuOptionClicked.setWidgetId(widgetId);

		log.debug("Menu action clicked: {}", menuOptionClicked);

		eventBus.post(menuOptionClicked);

		return menuOptionClicked.isConsumed();
	}

	public static void addChatMessage(int type, String name, String message, String sender)
	{
		if (log.isDebugEnabled())
		{
			log.debug("Chat message type {}: {}", ChatMessageType.of(type), message);
		}

		ChatMessageType chatMessageType = ChatMessageType.of(type);
		ChatMessage chatMessage = new ChatMessage(chatMessageType, name, message, sender);

		eventBus.post(chatMessage);
	}

	/**
	 * Called when a projectile is set to move towards a point. For
	 * projectiles that target the ground, like AoE projectiles from
	 * Lizardman Shamans, this is only called once
	 *
	 * @param projectile The projectile being moved
	 * @param targetX X position of where the projectile is being moved to
	 * @param targetY Y position of where the projectile is being moved to
	 * @param targetZ Z position of where the projectile is being moved to
	 * @param cycle
	 */
	public static void projectileMoved(Projectile projectile, int targetX, int targetY, int targetZ, int cycle)
	{
		LocalPoint position = new LocalPoint(targetX, targetY);
		ProjectileMoved projectileMoved = new ProjectileMoved();
		projectileMoved.setProjectile(projectile);
		projectileMoved.setPosition(position);
		projectileMoved.setZ(targetZ);
		eventBus.post(projectileMoved);
	}

	public static void setMessage(MessageNode messageNode, int type, String name, String sender, String value)
	{
		SetMessage setMessage = new SetMessage();
		setMessage.setMessageNode(messageNode);
		setMessage.setType(ChatMessageType.of(type));
		setMessage.setName(name);
		setMessage.setSender(sender);
		setMessage.setValue(value);

		eventBus.post(setMessage);
	}

	public static void onNpcUpdate(boolean var0, PacketBuffer var1)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		// The NPC update event seem to run every server tick,
		// but having the game tick event after all packets
		// have been processed is typically more useful.
		shouldProcessGameTick = true;
	}
<<<<<<< HEAD
=======

	public static void onSetCombatInfo(Actor actor, int combatInfoId, int gameCycle, int var3, int var4, int healthRatio, int health)
	{
		if (healthRatio == 0)
		{
			ActorDeath death = new ActorDeath();
			death.setActor(actor);
			eventBus.post(death);
		}
	}

	public static void postItemComposition(ItemComposition itemComposition)
	{
		PostItemComposition event = new PostItemComposition();
		event.setItemComposition(itemComposition);
		eventBus.post(event);
	}

	public static void menuOpened(Client client, int var1, int var2)
	{
		MenuOpened event = new MenuOpened();
		event.setMenuEntries(client.getMenuEntries());
		eventBus.post(event);
	}

	/**
	 * Called after a hitsplat has been processed on an actor.
	 * Note that this event runs even if the hitsplat didn't show up,
	 * i.e. the actor already had 4 visible hitsplats.
	 *
	 * @param actor The actor the hitsplat was applied to
	 * @param type The hitsplat type (i.e. color)
	 * @param value The value of the hitsplat (i.e. how high the hit was)
	 * @param var3
	 * @param var4
	 * @param gameCycle The gamecycle the hitsplat was applied on
	 * @param duration The amount of gamecycles the hitsplat will last for
	 */
	public static void onActorHitsplat(Actor actor, int type, int value, int var3, int var4,
		int gameCycle, int duration)
	{
		Hitsplat hitsplat = new Hitsplat(Hitsplat.HitsplatType.fromInteger(type), value,
			gameCycle + duration);

		HitsplatApplied event = new HitsplatApplied();
		event.setActor(actor);
		event.setHitsplat(hitsplat);
		eventBus.post(event);
	}

	public static void onGraphicsObjectCreated(GraphicsObject go, int var1, int var2, int var3, int var4, int var5, int var6, int var7)
	{
		GraphicsObjectCreated event = new GraphicsObjectCreated(go);
		eventBus.post(event);
	}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
