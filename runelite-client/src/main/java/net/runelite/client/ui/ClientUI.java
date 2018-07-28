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
package net.runelite.client.ui;

<<<<<<< HEAD
import com.google.common.eventbus.Subscribe;
import java.applet.Applet;
import java.awt.Canvas;
import java.awt.CardLayout;
=======
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
<<<<<<< HEAD
import java.awt.GraphicsConfiguration;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
<<<<<<< HEAD
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.ConfigManager;
<<<<<<< HEAD
import net.runelite.client.config.ExpandResizeType;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.config.WarningOnExit;
=======
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.events.ClientUILoaded;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.events.PluginToolbarButtonAdded;
import net.runelite.client.events.PluginToolbarButtonRemoved;
import net.runelite.client.events.TitleToolbarButtonAdded;
import net.runelite.client.events.TitleToolbarButtonRemoved;
import net.runelite.client.input.KeyManager;
<<<<<<< HEAD
import net.runelite.client.ui.skin.SubstanceRuneLiteLookAndFeel;
import net.runelite.client.util.OSType;
import net.runelite.client.util.OSXUtil;
import net.runelite.client.util.SwingUtil;
import org.pushingpixels.substance.internal.SubstanceSynapse;
=======
import net.runelite.client.util.OSType;
import net.runelite.client.util.OSXUtil;
import net.runelite.client.util.SwingUtil;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import org.pushingpixels.substance.internal.utils.SubstanceCoreUtilities;
import org.pushingpixels.substance.internal.utils.SubstanceTitlePaneUtilities;

/**
 * Client UI.
 */
@Slf4j
@Singleton
public class ClientUI
{
	private static final String CONFIG_GROUP = "runelite";
	private static final String CONFIG_CLIENT_BOUNDS = "clientBounds";
	private static final String CONFIG_CLIENT_MAXIMIZED = "clientMaximized";
	private static final int CLIENT_WELL_HIDDEN_MARGIN = 160;
	private static final int CLIENT_WELL_HIDDEN_MARGIN_TOP = 10;
	public static final BufferedImage ICON;
	private static final BufferedImage SIDEBAR_OPEN;
	private static final BufferedImage SIDEBAR_CLOSE;

	static
	{
		BufferedImage icon;
		BufferedImage sidebarOpen;
		BufferedImage sidebarClose;

		try
		{
			synchronized (ImageIO.class)
			{
				icon = ImageIO.read(ClientUI.class.getResourceAsStream("/runelite.png"));
				sidebarOpen = ImageIO.read(ClientUI.class.getResourceAsStream("open.png"));
				sidebarClose = ImageIO.read(ClientUI.class.getResourceAsStream("close.png"));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		ICON = icon;
		SIDEBAR_OPEN = sidebarOpen;
		SIDEBAR_CLOSE = sidebarClose;
	}

	@Getter
	private TrayIcon trayIcon;

<<<<<<< HEAD
	private final RuneLiteProperties properties;
	private final RuneLiteConfig config;
	private final KeyManager keyManager;
	private final Applet client;
	private final ConfigManager configManager;
	private final CardLayout cardLayout = new CardLayout();
=======
	private final RuneLite runelite;
	private final RuneLiteProperties properties;
	private final RuneLiteConfig config;
	private final EventBus eventBus;
	private final KeyManager keyManager;
	private Applet client;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private ContainableFrame frame;
	private JPanel navContainer;
	private PluginPanel pluginPanel;
	private ClientPluginToolbar pluginToolbar;
	private ClientTitleToolbar titleToolbar;
	private JButton currentButton;
	private NavigationButton currentNavButton;
	private boolean sidebarOpen;
	private JPanel container;
<<<<<<< HEAD
	private NavigationButton sidebarNavigationButton;
	private JButton sidebarNavigationJButton;
	private Dimension lastClientSize;

	@Inject
	private ClientUI(
		RuneLiteProperties properties,
		RuneLiteConfig config,
		KeyManager keyManager,
		@Nullable Applet client,
		ConfigManager configManager)
	{
		this.properties = properties;
		this.config = config;
		this.keyManager = keyManager;
		this.client = client;
		this.configManager = configManager;
=======
	private PluginPanel lastPluginPanel;
	private NavigationButton sidebarNavigationButton;
	private JButton sidebarNavigationJButton;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientUI(
		RuneLite runelite,
		RuneLiteProperties properties,
		RuneLiteConfig config,
		EventBus eventBus,
		KeyManager keyManager)
	{
		this.runelite = runelite;
		this.properties = properties;
		this.config = config;
		this.eventBus = eventBus;
		this.keyManager = keyManager;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
<<<<<<< HEAD
		if (!event.getGroup().equals("runelite") ||
			event.getKey().equals(CONFIG_CLIENT_MAXIMIZED) ||
			event.getKey().equals(CONFIG_CLIENT_BOUNDS))
=======
		if (!event.getGroup().equals("runelite"))
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			return;
		}

<<<<<<< HEAD
		SwingUtilities.invokeLater(() -> updateFrameConfig(event.getKey().equals("lockWindowSize")));
=======
		SwingUtilities.invokeLater(() ->
		{
			if (event.getKey().equals("gameAlwaysOnTop"))
			{
				if (frame.isAlwaysOnTopSupported())
				{
					frame.setAlwaysOnTop(config.gameAlwaysOnTop());
				}
			}

			if (event.getKey().equals("lockWindowSize"))
			{
				frame.setResizable(!config.lockWindowSize());
			}

			if (event.getKey().equals("automaticResizeType"))
			{
				frame.setExpandResizeType(config.automaticResizeType());
			}

			if (event.getKey().equals("containInScreen") ||
				event.getKey().equals("uiEnableCustomChrome"))
			{
				frame.setContainedInScreen(config.containInScreen() && config.enableCustomChrome());
			}

			if (event.getKey().equals("rememberScreenBounds") && event.getNewValue().equals("false"))
			{
				configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED);
				configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS);
			}

			if (!event.getKey().equals("gameSize"))
			{
				return;
			}

			if (client == null)
			{
				return;
			}

			// The upper bounds are defined by the applet's max size
			// The lower bounds are defined by the client's fixed size
			int width = Math.max(Math.min(config.gameSize().width, 7680), Constants.GAME_FIXED_WIDTH);
			int height = Math.max(Math.min(config.gameSize().height, 2160), Constants.GAME_FIXED_HEIGHT);
			final Dimension size = new Dimension(width, height);

			client.setSize(size);
			client.setPreferredSize(size);
			client.getParent().setPreferredSize(size);
			client.getParent().setSize(size);

			if (frame.isVisible())
			{
				frame.pack();
			}
		});
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onPluginToolbarButtonAdded(final PluginToolbarButtonAdded event)
	{
		SwingUtilities.invokeLater(() ->
		{
<<<<<<< HEAD
			final NavigationButton navigationButton = event.getButton();
			final PluginPanel pluginPanel = navigationButton.getPanel();

			if (pluginPanel != null)
			{
				navContainer.add(pluginPanel.getWrappedPanel(), navigationButton.getTooltip());
			}

			final JButton button = SwingUtil.createSwingButton(navigationButton, 0, (navButton, jButton) ->
=======
			final JButton button = SwingUtil.createSwingButton(event.getButton(), 0, (navButton, jButton) ->
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				final PluginPanel panel = navButton.getPanel();

				if (panel == null)
				{
					return;
				}

				boolean doClose = currentButton != null && currentButton == jButton && currentButton.isSelected();

				if (doClose)
				{
					contract();
					currentButton.setSelected(false);
					currentNavButton.setSelected(false);
					currentButton = null;
					currentNavButton = null;
				}
				else
				{
					if (currentButton != null)
					{
						currentButton.setSelected(false);
					}

					if (currentNavButton != null)
					{
						currentNavButton.setSelected(false);
					}

					currentButton = jButton;
					currentNavButton = navButton;
					currentButton.setSelected(true);
					currentNavButton.setSelected(true);
<<<<<<< HEAD
					expand(navButton);
=======
					expand(panel);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				}
			});

			pluginToolbar.addComponent(event.getIndex(), event.getButton(), button);
		});
	}

	@Subscribe
	public void onPluginToolbarButtonRemoved(final PluginToolbarButtonRemoved event)
	{
<<<<<<< HEAD
		SwingUtilities.invokeLater(() ->
		{
			pluginToolbar.removeComponent(event.getButton());
			final PluginPanel pluginPanel = event.getButton().getPanel();

			if (pluginPanel != null)
			{
				navContainer.remove(pluginPanel.getWrappedPanel());
			}
		});
=======
		SwingUtilities.invokeLater(() -> pluginToolbar.removeComponent(event.getButton()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	@Subscribe
	public void onTitleToolbarButtonAdded(final TitleToolbarButtonAdded event)
	{
		SwingUtilities.invokeLater(() ->
		{
			final int iconSize = ClientTitleToolbar.TITLEBAR_SIZE - 6;
			final JButton button = SwingUtil.createSwingButton(event.getButton(), iconSize, null);

			if (config.enableCustomChrome() || SwingUtil.isCustomTitlePanePresent(frame))
			{
				titleToolbar.addComponent(event.getButton(), button);
				return;
			}

			pluginToolbar.addComponent(-1, event.getButton(), button);
		});
	}

	@Subscribe
	public void onTitleToolbarButtonRemoved(final TitleToolbarButtonRemoved event)
	{
		SwingUtilities.invokeLater(() ->
		{
			if (config.enableCustomChrome() || SwingUtil.isCustomTitlePanePresent(frame))
			{
				titleToolbar.removeComponent(event.getButton());
				return;
			}

			pluginToolbar.removeComponent(event.getButton());
		});
	}

	/**
	 * Initialize UI.
	 *
<<<<<<< HEAD
	 * @param runelite runelite instance that will be shut down on exit
	 * @throws Exception exception that can occur during creation of the UI
	 */
	public void open(final RuneLite runelite) throws Exception
	{
=======
	 * @param client the client
	 * @throws Exception exception that can occur during creation of the UI
	 */
	public void init(@Nullable final Applet client) throws Exception
	{
		this.client = client;

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		SwingUtilities.invokeAndWait(() ->
		{
			// Set some sensible swing defaults
			SwingUtil.setupDefaults();

			// Use substance look and feel
<<<<<<< HEAD
			SwingUtil.setTheme(new SubstanceRuneLiteLookAndFeel());
=======
			SwingUtil.setTheme(new SubstanceGraphiteLookAndFeel());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			// Use custom UI font
			SwingUtil.setFont(FontManager.getRunescapeFont());

			// Create main window
			frame = new ContainableFrame();

			// Try to enable fullscreen on OSX
			OSXUtil.tryEnableFullscreen(frame);

			frame.setTitle(properties.getTitle());
			frame.setIconImage(ICON);
			frame.getLayeredPane().setCursor(Cursor.getDefaultCursor()); // Prevent substance from using a resize cursor for pointing
			frame.setLocationRelativeTo(frame.getOwner());
			frame.setResizable(true);

			SwingUtil.addGracefulExitCallback(frame,
				() ->
				{
					saveClientBoundsConfig();
					runelite.shutdown();
				},
<<<<<<< HEAD
				this::showWarningOnExit
			);
=======
				() -> client != null
					&& client instanceof Client
					&& ((Client) client).getGameState() != GameState.LOGIN_SCREEN);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			container = new JPanel();
			container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
			container.add(new ClientPanel(client));

			navContainer = new JPanel();
<<<<<<< HEAD
			navContainer.setLayout(cardLayout);
			navContainer.setMinimumSize(new Dimension(0, 0));
			navContainer.setMaximumSize(new Dimension(0, 0));
			navContainer.setPreferredSize(new Dimension(0, 0));

			// To reduce substance's colorization (tinting)
			navContainer.putClientProperty(SubstanceSynapse.COLORIZATION_FACTOR, 1.0);
=======
			navContainer.setLayout(new BorderLayout(0, 0));
			navContainer.setMinimumSize(new Dimension(0, 0));
			navContainer.setMaximumSize(new Dimension(0, Integer.MAX_VALUE));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			container.add(navContainer);

			pluginToolbar = new ClientPluginToolbar();
			titleToolbar = new ClientTitleToolbar();
			frame.add(container);

			// Add key listener
			final UiKeyListener uiKeyListener = new UiKeyListener(this);
			frame.addKeyListener(uiKeyListener);
			keyManager.registerKeyListener(uiKeyListener);
<<<<<<< HEAD

			// Update config
			updateFrameConfig(true);

			// Decorate window with custom chrome and titlebar if needed
			final boolean withTitleBar = config.enableCustomChrome();
=======
		});
	}

	/**
	 * Show client UI after everything else is done.
	 *
	 * @throws Exception exception that can occur during modification of the UI
	 */
	public void show() throws Exception
	{
		final boolean withTitleBar = config.enableCustomChrome();

		SwingUtilities.invokeAndWait(() ->
		{
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			frame.setUndecorated(withTitleBar);

			if (withTitleBar)
			{
				frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

				final JComponent titleBar = SubstanceCoreUtilities.getTitlePaneComponent(frame);
				titleToolbar.putClientProperty(SubstanceTitlePaneUtilities.EXTRA_COMPONENT_KIND, SubstanceTitlePaneUtilities.ExtraComponentKind.TRAILING);
				titleBar.add(titleToolbar);

				// Substance's default layout manager for the title bar only lays out substance's components
				// This wraps the default manager and lays out the TitleToolbar as well.
				LayoutManager delegate = titleBar.getLayout();
				titleBar.setLayout(new LayoutManager()
				{
					@Override
					public void addLayoutComponent(String name, Component comp)
					{
						delegate.addLayoutComponent(name, comp);
					}

					@Override
					public void removeLayoutComponent(Component comp)
					{
						delegate.removeLayoutComponent(comp);
					}

					@Override
					public Dimension preferredLayoutSize(Container parent)
					{
						return delegate.preferredLayoutSize(parent);
					}

					@Override
					public Dimension minimumLayoutSize(Container parent)
					{
						return delegate.minimumLayoutSize(parent);
					}

					@Override
					public void layoutContainer(Container parent)
					{
						delegate.layoutContainer(parent);
						final int width = titleToolbar.getPreferredSize().width;
						titleToolbar.setBounds(titleBar.getWidth() - 75 - width, 0, width, titleBar.getHeight());
					}
				});
			}

			// Show frame
			frame.pack();
			frame.revalidateMinimumSize();

			if (config.rememberScreenBounds())
			{
				try
				{
					Rectangle clientBounds = configManager.getConfiguration(
						CONFIG_GROUP, CONFIG_CLIENT_BOUNDS, Rectangle.class);
					if (clientBounds != null)
					{
						frame.setBounds(clientBounds);
					}
					else
					{
						frame.setLocationRelativeTo(frame.getOwner());
					}

					if (configManager.getConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED) != null)
					{
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					}
				}
				catch (Exception ex)
				{
					log.warn("Failed to set window bounds", ex);
					frame.setLocationRelativeTo(frame.getOwner());
				}
			}
			else
			{
				frame.setLocationRelativeTo(frame.getOwner());
			}

			trayIcon = SwingUtil.createTrayIcon(ICON, properties.getTitle(), frame);

			frame.setVisible(true);
			frame.toFront();
			requestFocus();
			giveClientFocus();

			// If the frame is well hidden (e.g. unplugged 2nd screen),
			// we want to move it back to default position as it can be
			// hard for the user to reposition it themselves otherwise.
			Rectangle clientBounds = frame.getBounds();
			Rectangle screenBounds = frame.getGraphicsConfiguration().getBounds();
			if (clientBounds.x + clientBounds.width - CLIENT_WELL_HIDDEN_MARGIN < screenBounds.getX() ||
				clientBounds.x + CLIENT_WELL_HIDDEN_MARGIN > screenBounds.getX() + screenBounds.getWidth() ||
				clientBounds.y + CLIENT_WELL_HIDDEN_MARGIN_TOP < screenBounds.getY() ||
				clientBounds.y + CLIENT_WELL_HIDDEN_MARGIN > screenBounds.getY() + screenBounds.getHeight())
			{
				frame.setLocationRelativeTo(frame.getOwner());
			}

			// Create hide sidebar button
			sidebarNavigationButton = NavigationButton
				.builder()
				.icon(SIDEBAR_CLOSE)
				.onClick(this::toggleSidebar)
				.build();

			sidebarNavigationJButton = SwingUtil.createSwingButton(
				sidebarNavigationButton,
				0,
				null);

			titleToolbar.addComponent(sidebarNavigationButton, sidebarNavigationJButton);
			toggleSidebar();
<<<<<<< HEAD
			log.info("Showing frame {}", frame);
		});

		// Show out of date dialog if needed
		final boolean isOutdated = !(client instanceof Client);
		if (isOutdated)
		{
			SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(frame,
				"RuneLite has not yet been updated to work with the latest\n"
					+ "game update, it will work with reduced functionality until then.",
				"RuneLite is outdated", INFORMATION_MESSAGE));
		}
	}

	private boolean showWarningOnExit()
	{
		if (config.warningOnExit() == WarningOnExit.ALWAYS)
		{
			return true;
		}

		if (config.warningOnExit() == WarningOnExit.LOGGED_IN && client instanceof Client)
		{
			return ((Client) client).getGameState() != GameState.LOGIN_SCREEN;
		}

		return false;
=======
		});

		eventBus.post(new ClientUILoaded());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	/**
	 * Paint this component to target graphics
	 *
	 * @param graphics the graphics
	 */
	public void paint(final Graphics graphics)
	{
		frame.paint(graphics);
	}

	/**
	 * Gets component width.
	 *
	 * @return the width
	 */
	public int getWidth()
	{
		return frame.getWidth();
	}

	/**
	 * Gets component height.
	 *
	 * @return the height
	 */
	public int getHeight()
	{
		return frame.getHeight();
	}

	/**
	 * Returns true if this component has focus.
	 *
	 * @return true if component has focus
	 */
	public boolean isFocused()
	{
		return frame.isFocused();
	}

	/**
	 * Request focus on this component and then on client component
	 */
	public void requestFocus()
	{
		if (OSType.getOSType() == OSType.MacOS)
		{
			OSXUtil.requestFocus();
		}

		frame.requestFocus();
		giveClientFocus();
	}

	/**
	 * Get offset of game canvas in game window
<<<<<<< HEAD
	 *
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	 * @return game canvas offset
	 */
	public Point getCanvasOffset()
	{
		if (client instanceof Client)
		{
			final java.awt.Point point = SwingUtilities.convertPoint(((Client) client).getCanvas(), 0, 0, frame);
			return new Point(point.x, point.y);
		}

		return new Point(0, 0);
	}

<<<<<<< HEAD
	public GraphicsConfiguration getGraphicsConfiguration()
	{
		return frame.getGraphicsConfiguration();
	}

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	void toggleSidebar()
	{
		// Toggle sidebar open
		boolean isSidebarOpen = sidebarOpen;
		sidebarOpen = !sidebarOpen;

		// Select/deselect buttons
		if (currentButton != null)
		{
			currentButton.setSelected(sidebarOpen);
		}

		if (currentNavButton != null)
		{
			currentNavButton.setSelected(sidebarOpen);
		}

		if (isSidebarOpen)
		{
			sidebarNavigationJButton.setIcon(new ImageIcon(SIDEBAR_OPEN));
			sidebarNavigationJButton.setToolTipText("Open SideBar");

<<<<<<< HEAD
=======
			// Save last panel and close current one
			lastPluginPanel = pluginPanel;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			contract();

			// Remove plugin toolbar
			container.remove(pluginToolbar);
		}
		else
		{
			sidebarNavigationJButton.setIcon(new ImageIcon(SIDEBAR_CLOSE));
			sidebarNavigationJButton.setToolTipText("Close SideBar");

			// Try to restore last panel
<<<<<<< HEAD
			expand(currentNavButton);
=======
			expand(lastPluginPanel);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			// Add plugin toolbar back
			container.add(pluginToolbar);
		}

		// Revalidate sizes of affected Swing components
		container.revalidate();
<<<<<<< HEAD
=======
		container.repaint();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		giveClientFocus();

		if (sidebarOpen)
		{
			frame.expandBy(pluginToolbar.getWidth());
		}
		else
		{
			frame.contractBy(pluginToolbar.getWidth());
		}
	}

<<<<<<< HEAD
	private void expand(@Nullable NavigationButton button)
	{
		if (button == null)
		{
			return;
		}

		final PluginPanel panel = button.getPanel();

=======
	private void expand(@Nullable PluginPanel panel)
	{
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		if (panel == null)
		{
			return;
		}

		if (!sidebarOpen)
		{
			toggleSidebar();
		}

<<<<<<< HEAD
		int width = panel.getWrappedPanel().getPreferredSize().width;
		int expandBy = pluginPanel != null ? pluginPanel.getWrappedPanel().getPreferredSize().width - width : width;
		pluginPanel = panel;

		// Expand sidebar
		navContainer.setMinimumSize(new Dimension(width, 0));
		navContainer.setMaximumSize(new Dimension(width, Integer.MAX_VALUE));
		navContainer.setPreferredSize(new Dimension(width, 0));
		navContainer.revalidate();
		cardLayout.show(navContainer, button.getTooltip());
=======
		int expandBy = panel.getWrappedPanel().getPreferredSize().width;

		if (pluginPanel != null)
		{
			expandBy = pluginPanel.getWrappedPanel().getPreferredSize().width - expandBy;
			navContainer.remove(0);
		}

		pluginPanel = panel;
		navContainer.setMinimumSize(new Dimension(pluginPanel.getWrappedPanel().getPreferredSize().width, 0));
		navContainer.setMaximumSize(new Dimension(pluginPanel.getWrappedPanel().getPreferredSize().width, Integer.MAX_VALUE));

		final JPanel wrappedPanel = panel.getWrappedPanel();
		navContainer.add(wrappedPanel);
		navContainer.revalidate();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		// panel.onActivate has to go after giveClientFocus so it can get focus if it needs.
		giveClientFocus();
		panel.onActivate();
<<<<<<< HEAD
=======
		wrappedPanel.repaint();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		// Check if frame was really expanded or contracted
		if (expandBy > 0)
		{
			frame.expandBy(expandBy);
		}
		else if (expandBy < 0)
		{
			frame.contractBy(expandBy);
		}
	}

	private void contract()
	{
		if (pluginPanel == null)
		{
			return;
		}

		pluginPanel.onDeactivate();
<<<<<<< HEAD
		navContainer.setMinimumSize(new Dimension(0, 0));
		navContainer.setMaximumSize(new Dimension(0, 0));
		navContainer.setPreferredSize(new Dimension(0, 0));
=======
		navContainer.remove(0);
		navContainer.setMinimumSize(new Dimension(0, 0));
		navContainer.setMaximumSize(new Dimension(0, 0));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		navContainer.revalidate();
		giveClientFocus();
		frame.contractBy(pluginPanel.getWrappedPanel().getPreferredSize().width);
		pluginPanel = null;
	}

	private void giveClientFocus()
	{
		if (client instanceof Client)
		{
			final Canvas c = ((Client) client).getCanvas();
			c.requestFocusInWindow();
		}
		else if (client != null)
		{
			client.requestFocusInWindow();
		}
	}

<<<<<<< HEAD
	private void updateFrameConfig(boolean updateResizable)
	{
		if (frame == null)
		{
			return;
		}

		if (frame.isAlwaysOnTopSupported())
		{
			frame.setAlwaysOnTop(config.gameAlwaysOnTop());
		}

		if (updateResizable)
		{
			frame.setResizable(!config.lockWindowSize());
		}

		frame.setExpandResizeType(config.automaticResizeType());
		frame.setContainedInScreen(config.containInScreen() && config.enableCustomChrome());

		if (!config.rememberScreenBounds())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED);
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS);
		}

		if (client == null)
		{
			return;
		}

		// The upper bounds are defined by the applet's max size
		// The lower bounds are defined by the client's fixed size
		int width = Math.max(Math.min(config.gameSize().width, 7680), Constants.GAME_FIXED_WIDTH);
		int height = Math.max(Math.min(config.gameSize().height, 2160), Constants.GAME_FIXED_HEIGHT);
		final Dimension size = new Dimension(width, height);

		if (!size.equals(lastClientSize))
		{
			lastClientSize = size;
			client.setSize(size);
			client.setPreferredSize(size);
			client.getParent().setPreferredSize(size);
			client.getParent().setSize(size);

			if (frame.isVisible())
			{
				frame.pack();
			}
		}
	}

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private void saveClientBoundsConfig()
	{
		if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) != 0)
		{
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED, true);
		}
		else
		{
			final Rectangle bounds = frame.getBounds();

<<<<<<< HEAD
			if (config.automaticResizeType() == ExpandResizeType.KEEP_GAME_SIZE)
			{
				// Try to contract sidebar
				if (sidebarOpen)
				{
					bounds.width -= pluginToolbar.getWidth();
				}

				// Try to contract plugin panel
				if (pluginPanel != null)
				{
					bounds.width -= pluginPanel.getWrappedPanel().getPreferredSize().width;
				}
=======
			// Try to contract sidebar
			if (sidebarOpen)
			{
				bounds.width -= pluginToolbar.getWidth();
			}

			// Try to contract plugin panel
			if (pluginPanel != null)
			{
				bounds.width -= pluginPanel.getWrappedPanel().getPreferredSize().width;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}

			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED);
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS, bounds);
		}
	}
}
