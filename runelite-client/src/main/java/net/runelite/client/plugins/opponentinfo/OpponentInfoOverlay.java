/*
<<<<<<< HEAD
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
=======
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
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
package net.runelite.client.plugins.opponentinfo;

import java.awt.Color;
import java.awt.Dimension;
<<<<<<< HEAD
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
=======
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.client.game.HiscoreManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.components.ComponentConstants;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;
import net.runelite.http.api.hiscore.HiscoreResult;

class OpponentInfoOverlay extends Overlay
{
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);
<<<<<<< HEAD
=======
	private static final Duration WAIT = Duration.ofSeconds(3);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	private final Client client;
	private final OpponentInfoPlugin opponentInfoPlugin;
	private final HiscoreManager hiscoreManager;

<<<<<<< HEAD
	private final PanelComponent panelComponent = new PanelComponent();

	private Integer lastMaxHealth;
	private float lastRatio = 0;
	private String opponentName;
	private String opponentsOpponentName;
=======
	private final NPC[] clientNpcs;
	private final PanelComponent panelComponent = new PanelComponent();
	private final Map<String, Integer> oppInfoHealth = OpponentInfoPlugin.loadNpcHealth();

	private Integer lastMaxHealth;
	private float lastRatio = 0;
	private Instant lastTime = Instant.now();
	private String opponentName;
	private String opponentsOpponentName;
	private NPC lastOpponent;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	@Inject
	private OpponentInfoOverlay(Client client, OpponentInfoPlugin opponentInfoPlugin, HiscoreManager hiscoreManager)
	{
		this.client = client;
		this.opponentInfoPlugin = opponentInfoPlugin;
		this.hiscoreManager = hiscoreManager;

<<<<<<< HEAD
=======
		this.clientNpcs = client.getCachedNPCs();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.HIGH);

		panelComponent.setBorder(new Rectangle(2, 2, 2, 2));
		panelComponent.setGap(new Point(0, 2));
	}

<<<<<<< HEAD
	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Actor opponent = opponentInfoPlugin.getLastOpponent();

		if (opponent == null)
		{
			opponentName = null;
			return null;
		}

		if (opponent.getName() != null && opponent.getHealth() > 0)
		{
=======
	private Actor getOpponent()
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		return player.getInteracting();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Actor opponent = getOpponent();

		// If opponent is null, try to use last opponent
		if (opponent == null)
		{
			if (lastOpponent != null && clientNpcs[lastOpponent.getIndex()] != lastOpponent)
			{
				// lastOpponent is no longer valid
				lastOpponent = null;
			}
			else
			{
				opponent = lastOpponent;
			}
		}
		else
		{
			// Update last opponent
			lastOpponent = opponent instanceof NPC ? (NPC) opponent : null;
		}

		if (opponent != null && opponent.getHealth() > 0)
		{
			lastTime = Instant.now();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			lastRatio = (float) opponent.getHealthRatio() / (float) opponent.getHealth();
			opponentName = Text.removeTags(opponent.getName());

			lastMaxHealth = null;
			if (opponent instanceof NPC)
			{
<<<<<<< HEAD
				lastMaxHealth = opponentInfoPlugin.getOppInfoHealth().get(opponentName + "_" + opponent.getCombatLevel());
			}
			else if (opponent instanceof Player)
			{
				final HiscoreResult hiscoreResult = hiscoreManager.lookupAsync(opponentName, opponentInfoPlugin.getHiscoreEndpoint());
				if (hiscoreResult != null)
				{
					final int hp = hiscoreResult.getHitpoints().getLevel();
=======
				lastMaxHealth = oppInfoHealth.get(opponentName + "_" + opponent.getCombatLevel());
			}
			else if (opponent instanceof Player)
			{
				HiscoreResult hiscoreResult = hiscoreManager.lookupAsync(opponentName, opponentInfoPlugin.getHiscoreEndpoint());
				if (hiscoreResult != null)
				{
					int hp = hiscoreResult.getHitpoints().getLevel();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
					if (hp > 0)
					{
						lastMaxHealth = hp;
					}
				}
			}

<<<<<<< HEAD
			final Actor opponentsOpponent = opponent.getInteracting();
=======
			Actor opponentsOpponent = opponent.getInteracting();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			if (opponentsOpponent != null
					&& (opponentsOpponent != client.getLocalPlayer() || client.getVar(Varbits.MULTICOMBAT_AREA) == 1))
			{
				opponentsOpponentName = Text.removeTags(opponentsOpponent.getName());
			}
			else
			{
				opponentsOpponentName = null;
			}
		}

<<<<<<< HEAD
		if (opponentName == null)
		{
			return null;
		}

		final FontMetrics fontMetrics = graphics.getFontMetrics();

		panelComponent.getChildren().clear();

		// Opponent name
		int textWidth = Math.max(ComponentConstants.STANDARD_WIDTH, fontMetrics.stringWidth(opponentName));
		panelComponent.setPreferredSize(new Dimension(textWidth, 0));
=======
		if (Duration.between(Instant.now(), lastTime).abs().compareTo(WAIT) > 0)
		{
			return null; //don't draw anything.
		}

		panelComponent.getChildren().clear();

		// Opponent name
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(opponentName)
			.build());

		// Health bar
		if (lastRatio >= 0)
		{
			final ProgressBarComponent progressBarComponent = new ProgressBarComponent();
			progressBarComponent.setBackgroundColor(HP_RED);
			progressBarComponent.setForegroundColor(HP_GREEN);

			if (lastMaxHealth != null)
			{
				progressBarComponent.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.FULL);
				progressBarComponent.setMaximum(lastMaxHealth);
				progressBarComponent.setValue(lastRatio * lastMaxHealth);
			}
			else
			{
				progressBarComponent.setValue(lastRatio * 100d);
			}

			panelComponent.getChildren().add(progressBarComponent);
		}

		// Opponents opponent
		if (opponentsOpponentName != null)
		{
<<<<<<< HEAD
			textWidth = Math.max(textWidth, fontMetrics.stringWidth(opponentsOpponentName));
			panelComponent.setPreferredSize(new Dimension(textWidth, 0));
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(opponentsOpponentName)
				.build());
		}

		return panelComponent.render(graphics);
	}
}
