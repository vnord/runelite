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
package net.runelite.client.plugins.account;

import com.google.common.eventbus.Subscribe;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.TitleToolbar;
import net.runelite.client.util.RunnableExceptionLogger;

@PluginDescriptor(
	name = "Account",
<<<<<<< HEAD
	description = "Sync RuneLite config settings with your Google account",
	tags = {"external", "google", "integration"},
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	loadWhenOutdated = true
)
@Slf4j
public class AccountPlugin extends Plugin
{
	@Inject
	private SessionManager sessionManager;

	@Inject
	private TitleToolbar titleToolbar;

	@Inject
	private ScheduledExecutorService executor;

	private NavigationButton loginButton;
	private NavigationButton logoutButton;

	private static final BufferedImage LOGIN_IMAGE, LOGOUT_IMAGE;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				LOGIN_IMAGE = ImageIO.read(AccountPlugin.class.getResourceAsStream("login_icon.png"));
				LOGOUT_IMAGE = ImageIO.read(AccountPlugin.class.getResourceAsStream("logout_icon.png"));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		loginButton = NavigationButton.builder()
			.icon(LOGIN_IMAGE)
			.tooltip("Login to RuneLite")
			.onClick(this::loginClick)
			.build();

		logoutButton = NavigationButton.builder()
			.icon(LOGOUT_IMAGE)
			.tooltip("Logout of RuneLite")
			.onClick(this::logoutClick)
			.build();

		addAndRemoveButtons();
	}

	private void addAndRemoveButtons()
	{
		titleToolbar.removeNavigation(loginButton);
		titleToolbar.removeNavigation(logoutButton);
		titleToolbar.addNavigation(sessionManager.getAccountSession() == null
			? loginButton
			: logoutButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		titleToolbar.removeNavigation(loginButton);
		titleToolbar.removeNavigation(logoutButton);
	}

	private void loginClick()
	{
		executor.execute(RunnableExceptionLogger.wrap(sessionManager::login));
	}

	private void logoutClick()
	{
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
				"Are you sure you want to logout from RuneLite?", "Logout Confirmation",
				JOptionPane.YES_NO_OPTION))
		{
			sessionManager.logout();
		}
	}

	@Subscribe
	public void onSessionClose(SessionClose e)
	{
		addAndRemoveButtons();
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		AccountSession session = sessionManager.getAccountSession();

		if (session.getUsername() == null)
		{
			return; // No username yet
		}

		log.debug("Session opened as {}", session.getUsername());

		addAndRemoveButtons();
	}

}
