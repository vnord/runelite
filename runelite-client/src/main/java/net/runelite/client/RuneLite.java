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
package net.runelite.client;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
<<<<<<< HEAD
import java.io.File;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Provider;
=======
import com.google.inject.Provider;
import java.applet.Applet;
import java.io.File;
import java.util.Locale;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.inject.Singleton;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.util.EnumConverter;
<<<<<<< HEAD
import lombok.Getter;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.account.SessionManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.game.ClanManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.PluginManager;
<<<<<<< HEAD
import net.runelite.client.rs.ClientUpdateCheckMode;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayRenderer;
import net.runelite.client.ui.overlay.WidgetOverlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxOverlay;
import net.runelite.client.ui.overlay.tooltip.TooltipOverlay;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;
=======
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.TitleToolbar;
import net.runelite.client.ui.overlay.OverlayRenderer;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Singleton
@Slf4j
public class RuneLite
{
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File PROFILES_DIR = new File(RUNELITE_DIR, "profiles");
	public static final File SCREENSHOT_DIR = new File(RUNELITE_DIR, "screenshots");
	private static final File LOGS_DIR = new File(RUNELITE_DIR, "logs");
	private static final File LOGS_FILE_NAME = new File(LOGS_DIR, "application");

<<<<<<< HEAD
	@Getter
	private static Injector injector;
=======
	private static Injector injector;
	private static OptionSet options;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Inject
	private PluginManager pluginManager;

	@Inject
	private MenuManager menuManager;

	@Inject
	private EventBus eventBus;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private CommandManager commandManager;

	@Inject
	private OverlayRenderer overlayRenderer;

	@Inject
	private DrawManager drawManager;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private DiscordService discordService;

	@Inject
	private ClientSessionManager clientSessionManager;

	@Inject
	private ClientUI clientUI;

	@Inject
<<<<<<< HEAD
	private Provider<ItemManager> itemManager;

	@Inject
	private ClanManager clanManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InfoBoxOverlay infoBoxOverlay;

	@Inject
	private TooltipOverlay tooltipOverlay;

	@Inject
	private WorldMapOverlay worldMapOverlay;

	@Inject
	@Nullable
	private Client client;
=======
	private TitleToolbar titleToolbar;

	@Inject
	private Provider<ItemManager> itemManager;

	@Inject
	private ClanManager clanManager;

	Client client;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	public static void main(String[] args) throws Exception
	{
		Locale.setDefault(Locale.ENGLISH);

<<<<<<< HEAD
		final OptionParser parser = new OptionParser();
		parser.accepts("developer-mode", "Enable developer tools");
		parser.accepts("debug", "Show extra debugging output");

		final ArgumentAcceptingOptionSpec<ClientUpdateCheckMode> updateMode = parser
			.accepts("rs", "Select client type")
			.withRequiredArg()
			.ofType(ClientUpdateCheckMode.class)
			.defaultsTo(ClientUpdateCheckMode.AUTO)
			.withValuesConvertedBy(new EnumConverter<ClientUpdateCheckMode>(ClientUpdateCheckMode.class)
			{
				@Override
				public ClientUpdateCheckMode convert(String v)
=======
		OptionParser parser = new OptionParser();
		parser.accepts("developer-mode", "Enable developer tools");
		parser.accepts("debug", "Show extra debugging output");
		ArgumentAcceptingOptionSpec<UpdateCheckMode> updateMode = parser.accepts("rs", "Select client type")
			.withRequiredArg()
			.ofType(UpdateCheckMode.class)
			.defaultsTo(UpdateCheckMode.AUTO)
			.withValuesConvertedBy(new EnumConverter<UpdateCheckMode>(UpdateCheckMode.class)
			{
				@Override
				public UpdateCheckMode convert(String v)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				{
					return super.convert(v.toUpperCase());
				}
			});
<<<<<<< HEAD

		parser.accepts("help", "Show this text").forHelp();
		OptionSet options = parser.parse(args);

		if (options.has("help"))
=======
		parser.accepts("help", "Show this text").forHelp();
		setOptions(parser.parse(args));

		if (getOptions().has("help"))
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			parser.printHelpOn(System.out);
			System.exit(0);
		}

<<<<<<< HEAD
		final boolean developerMode = options.has("developer-mode");

		if (developerMode && RuneLiteProperties.getLauncherVersion() == null)
		{
			boolean assertions = false;
			assert assertions = true;
			if (!assertions)
			{
				throw new RuntimeException("Developers should enable assertions; Add `-ea` to your JVM arguments`");
			}
		}

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		PROFILES_DIR.mkdirs();

		// Setup logger
		MDC.put("logFileName", LOGS_FILE_NAME.getAbsolutePath());

		if (options.has("debug"))
		{
			final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
			logger.setLevel(Level.DEBUG);
		}

		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->
		{
			log.error("Uncaught exception:", throwable);
			if (throwable instanceof AbstractMethodError)
			{
				log.error("Classes are out of date; Build with maven again.");
			}
		});

<<<<<<< HEAD
		injector = Guice.createInjector(new RuneLiteModule(
			options.valueOf(updateMode),
			developerMode));

		injector.getInstance(RuneLite.class).start();
	}

	public void start() throws Exception
	{
		// Load RuneLite or Vanilla client
		final boolean isOutdated = client == null;

		if (!isOutdated)
		{
			// Inject members into client
			injector.injectMembers(client);
=======
		setInjector(Guice.createInjector(new RuneLiteModule()));
		injector.getInstance(RuneLite.class).start(getOptions().valueOf(updateMode));
	}

	public void start(UpdateCheckMode updateMode) throws Exception
	{
		// Load RuneLite or Vanilla client
		final Applet client = new ClientLoader().loadRs(updateMode);

		final boolean isOutdated = !(client instanceof Client);

		if (!isOutdated)
		{
			this.client = (Client) client;
		}

		// Initialize UI
		clientUI.init(client);

		// Initialize Discord service
		discordService.init();

		// Register event listeners
		eventBus.register(clientUI);
		eventBus.register(overlayRenderer);
		eventBus.register(drawManager);
		eventBus.register(menuManager);
		eventBus.register(chatMessageManager);
		eventBus.register(commandManager);
		eventBus.register(pluginManager);
		eventBus.register(clanManager);
		if (this.client != null)
		{
			eventBus.register(itemManager.get());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}

		// Load user configuration
		configManager.load();

		// Tell the plugin manager if client is outdated or not
		pluginManager.setOutdated(isOutdated);

		// Load the plugins, but does not start them yet.
		// This will initialize configuration
		pluginManager.loadCorePlugins();

		// Plugins have provided their config, so set default config
		// to main settings
		pluginManager.loadDefaultPluginConfiguration();

		// Start client session
		clientSessionManager.start();

		// Load the session, including saved configuration
		sessionManager.loadSession();

<<<<<<< HEAD
		// Initialize UI
		clientUI.open(this);

		// Initialize chat colors
		chatMessageManager.loadColors();

		// Initialize Discord service
		discordService.init();

		// Register event listeners
		eventBus.register(clientUI);
		eventBus.register(pluginManager);
		eventBus.register(overlayRenderer);
		eventBus.register(overlayManager);
		eventBus.register(drawManager);
		eventBus.register(menuManager);
		eventBus.register(chatMessageManager);
		eventBus.register(commandManager);
		eventBus.register(clanManager);
		eventBus.register(infoBoxManager);

		if (!isOutdated)
		{
			eventBus.register(itemManager.get());
			WidgetOverlay.createOverlays(client).forEach(overlayManager::add);
		}

		// Add core overlays after configuration has been loaded so their properties will be
		// loaded properly
		overlayManager.add(infoBoxOverlay);
		overlayManager.add(worldMapOverlay);
		overlayManager.add(tooltipOverlay);

		// Start plugins
		pluginManager.startCorePlugins();
=======
		// Start plugins
		pluginManager.startCorePlugins();

		// Refresh title toolbar
		titleToolbar.refresh();

		// Show UI after all plugins are loaded
		clientUI.show();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	public void shutdown()
	{
		clientSessionManager.shutdown();
		discordService.close();
	}

	@VisibleForTesting
<<<<<<< HEAD
=======
	public void setClient(Client client)
	{
		this.client = client;
	}

	public static Injector getInjector()
	{
		return injector;
	}

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	public static void setInjector(Injector injector)
	{
		RuneLite.injector = injector;
	}
<<<<<<< HEAD
=======

	public static OptionSet getOptions()
	{
		return options;
	}

	public static void setOptions(OptionSet options)
	{
		RuneLite.options = options;
	}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
}
