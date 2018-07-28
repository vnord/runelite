/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
<<<<<<< HEAD
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
=======
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
package net.runelite.client.plugins.xptracker;

import java.awt.BorderLayout;
import java.awt.Color;
<<<<<<< HEAD
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.ProgressBar;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.SwingUtil;
=======
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.JShadowedLabel;
import net.runelite.client.util.LinkBrowser;
import org.pushingpixels.substance.internal.SubstanceSynapse;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@Slf4j
class XpInfoBox extends JPanel
{
<<<<<<< HEAD
	// Templates
	private static final String HTML_TOOL_TIP_TEMPLATE =
		"<html>%s actions done<br/>"
			+ "%s actions/hr<br/>"
			+ "%s till goal lvl</html>";
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// Instance members
	private final JPanel panel;

	@Getter(AccessLevel.PACKAGE)
	private final Skill skill;

	/* The tracker's wrapping container */
	private final JPanel container = new JPanel();

	/* Contains the skill icon and the stats panel */
	private final JPanel headerPanel = new JPanel();

	/* Contains all the skill information (exp gained, per hour, etc) */
	private final JPanel statsPanel = new JPanel();

	private final ProgressBar progressBar = new ProgressBar();

	private final JLabel expGained = new JLabel();
	private final JLabel expHour = new JLabel();
	private final JLabel expLeft = new JLabel();
	private final JLabel actionsLeft = new JLabel();
	private final JMenuItem pauseSkill = new JMenuItem("Pause");

	private boolean paused = false;

	XpInfoBox(XpTrackerPlugin xpTrackerPlugin, Client client, JPanel panel, Skill skill, SkillIconManager iconManager) throws IOException
	{
=======
	private static final Rectangle ICON_BOUNDS = new Rectangle(0, 0, 26, 26);

	private final Client client;
	private final JPanel panel;
	private final Skill skill;

	private final JPanel container = new JPanel();
	private final JPanel statsPanel = new JPanel();
	private final JProgressBar progressBar = new JProgressBar();
	private final JLabel xpHr = new JLabel();
	private final JLabel xpGained = new JLabel();
	private final JLabel xpLeft = new JLabel();
	private final JLabel actionsLeft = new JLabel();
	private final JLabel levelLabel = new JShadowedLabel();

	XpInfoBox(XpTrackerPlugin xpTrackerPlugin, Client client, JPanel panel, Skill skill, SkillIconManager iconManager) throws IOException
	{
		this.client = client;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		this.panel = panel;
		this.skill = skill;

		setLayout(new BorderLayout());
<<<<<<< HEAD
		setBorder(new EmptyBorder(5, 0, 0, 0));

		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// Create open xp tracker menu
		final JMenuItem openXpTracker = new JMenuItem("Open online tracker");
		openXpTracker.addActionListener(e -> LinkBrowser.browse(XpPanel.buildXpTrackerUrl(client.getLocalPlayer(), skill)));

		// Create reset menu
		final JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(e -> xpTrackerPlugin.resetSkillState(skill));

		// Create reset others menu
		final JMenuItem resetOthers = new JMenuItem("Reset others");
		resetOthers.addActionListener(e -> xpTrackerPlugin.resetOtherSkillState(skill));

		// Create reset others menu
		pauseSkill.addActionListener(e -> xpTrackerPlugin.pauseSkill(skill, !paused));

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(openXpTracker);
		popupMenu.add(reset);
		popupMenu.add(resetOthers);
		popupMenu.add(pauseSkill);

		JLabel skillIcon = new JLabel(new ImageIcon(iconManager.getSkillImage(skill)));
		skillIcon.setHorizontalAlignment(SwingConstants.CENTER);
		skillIcon.setVerticalAlignment(SwingConstants.CENTER);
		skillIcon.setPreferredSize(new Dimension(35, 35));

		headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		headerPanel.setLayout(new BorderLayout());

		statsPanel.setLayout(new DynamicGridLayout(2, 2));
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		statsPanel.setBorder(new EmptyBorder(9, 2, 9, 2));

		expGained.setFont(FontManager.getRunescapeSmallFont());
		expHour.setFont(FontManager.getRunescapeSmallFont());
		expLeft.setFont(FontManager.getRunescapeSmallFont());
		actionsLeft.setFont(FontManager.getRunescapeSmallFont());

		statsPanel.add(expGained);
		statsPanel.add(expLeft);
		statsPanel.add(expHour);
		statsPanel.add(actionsLeft);

		headerPanel.add(skillIcon, BorderLayout.WEST);
		headerPanel.add(statsPanel, BorderLayout.CENTER);

		JPanel progressWrapper = new JPanel();
		progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		progressWrapper.setLayout(new BorderLayout());
		progressWrapper.setBorder(new EmptyBorder(0, 7, 7, 7));

		progressBar.setMaximumValue(100);
		progressBar.setBackground(new Color(61, 56, 49));
		progressBar.setForeground(SkillColor.values()[skill.ordinal()].getColor());
		progressBar.setDimmedText("Paused");

		progressWrapper.add(progressBar, BorderLayout.NORTH);

		container.add(headerPanel, BorderLayout.NORTH);
		container.add(progressWrapper, BorderLayout.SOUTH);

		container.setComponentPopupMenu(popupMenu);
		progressBar.setComponentPopupMenu(popupMenu);

		add(container, BorderLayout.NORTH);
=======
		setBorder(new CompoundBorder
		(
			new EmptyBorder(2, 0, 2, 0),
			new LineBorder(getBackground().brighter(), 1)
		));

		// Expand stats panel on click
		Color backgroundColor = getBackground();

		MouseListener panelMouseListener = new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				container.setBackground(backgroundColor.darker().darker());
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				container.setBackground(backgroundColor);
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
				if (SwingUtilities.isLeftMouseButton(e))
				{
					showStatsPanel();
				}
			}
		};

		container.setLayout(new BorderLayout());
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.addMouseListener(panelMouseListener);

		// Create open xp tracker menu
		final JMenuItem openXpTracker = new JMenuItem("Open XP tracker");
		openXpTracker.addActionListener(e -> LinkBrowser.browse(XpPanel.buildXpTrackerUrl(client.getLocalPlayer(), skill)));

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.add(openXpTracker);
		container.setComponentPopupMenu(popupMenu);

		// Create icon panel
		final JPanel iconBarPanel = new JPanel();
		iconBarPanel.setLayout(new BorderLayout(5, 0));
		iconBarPanel.setOpaque(false);

		// Create skill/reset icon
		final BufferedImage skillImage = iconManager.getSkillImage(skill);
		final JButton skillIcon = new JButton();

		skillIcon.putClientProperty(SubstanceSynapse.FLAT_LOOK, Boolean.TRUE);
		skillIcon.putClientProperty(SubstanceSynapse.BUTTON_NEVER_PAINT_BACKGROUND, Boolean.TRUE);
		skillIcon.setIcon(new ImageIcon(skillImage));
		skillIcon.setRolloverIcon(new ImageIcon(createHoverImage(skillImage)));

		skillIcon.setToolTipText("Reset " + skill.getName() + " tracker");
		skillIcon.addActionListener(e -> xpTrackerPlugin.resetSkillState(skill));
		skillIcon.setBounds(ICON_BOUNDS);
		skillIcon.setOpaque(false);
		skillIcon.setFocusPainted(false);

		// Create level label
		levelLabel.setHorizontalAlignment(JLabel.CENTER);
		levelLabel.setForeground(Color.YELLOW);
		levelLabel.setBounds(ICON_BOUNDS);
		levelLabel.setOpaque(false);

		// Create pane for grouping skill icon and level label
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.add(skillIcon, new Integer(1));
		layeredPane.add(levelLabel, new Integer(2));
		layeredPane.setPreferredSize(ICON_BOUNDS.getSize());
		iconBarPanel.add(layeredPane, BorderLayout.LINE_START);

		// Create progress bar
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBackground(Color.RED);
		progressBar.addMouseListener(panelMouseListener);
		iconBarPanel.add(progressBar, BorderLayout.CENTER);

		container.add(iconBarPanel, BorderLayout.NORTH);

		// Stats panel
		statsPanel.setLayout(new GridLayout(2, 2));
		statsPanel.setBorder(new EmptyBorder(3, 0, 0, 0));
		statsPanel.setOpaque(false);

		statsPanel.add(xpGained);
		xpHr.setHorizontalAlignment(SwingConstants.RIGHT);
		statsPanel.add(xpHr);
		statsPanel.add(xpLeft);
		actionsLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		statsPanel.add(actionsLeft);

		add(container, BorderLayout.CENTER);
	}

	private void showStatsPanel()
	{
		if (statsPanel.isShowing())
		{
			container.remove(statsPanel);
			revalidate();
		}
		else
		{
			container.add(statsPanel, BorderLayout.SOUTH);
			revalidate();
		}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	void reset()
	{
		container.remove(statsPanel);
		panel.remove(this);
		panel.revalidate();
	}

<<<<<<< HEAD
	void update(boolean updated, boolean paused, XpSnapshotSingle xpSnapshotSingle)
	{
		SwingUtilities.invokeLater(() -> rebuildAsync(updated, paused, xpSnapshotSingle));
	}

	private void rebuildAsync(boolean updated, boolean skillPaused, XpSnapshotSingle xpSnapshotSingle)
=======
	void update(boolean updated, XpSnapshotSingle xpSnapshotSingle)
	{
		SwingUtilities.invokeLater(() -> rebuildAsync(updated, xpSnapshotSingle));
	}

	private void rebuildAsync(boolean updated, XpSnapshotSingle xpSnapshotSingle)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		if (updated)
		{
			if (getParent() != panel)
			{
				panel.add(this);
				panel.revalidate();
			}

<<<<<<< HEAD
			paused = skillPaused;

			// Update information labels
			expGained.setText(htmlLabel("XP Gained: ", xpSnapshotSingle.getXpGainedInSession()));
			expLeft.setText(htmlLabel("XP Left: ", xpSnapshotSingle.getXpRemainingToGoal()));
			actionsLeft.setText(htmlLabel("Actions: ", xpSnapshotSingle.getActionsRemainingToGoal()));

			// Update progress bar
			progressBar.setValue(xpSnapshotSingle.getSkillProgressToGoal());
			progressBar.setCenterLabel(xpSnapshotSingle.getSkillProgressToGoal() + "%");
			progressBar.setLeftLabel("Lvl. " + xpSnapshotSingle.getStartLevel());
			progressBar.setRightLabel(xpSnapshotSingle.getEndGoalXp() == Experience.MAX_SKILL_XP
				? "200M"
				: "Lvl. " + xpSnapshotSingle.getEndLevel());

			progressBar.setToolTipText(String.format(
				HTML_TOOL_TIP_TEMPLATE,
				xpSnapshotSingle.getActionsInSession(),
				xpSnapshotSingle.getActionsPerHour(),
				xpSnapshotSingle.getTimeTillGoal()));

			progressBar.setDimmed(skillPaused);

			progressBar.repaint();
		}
		else if (!paused && skillPaused)
		{
			// React to the skill state now being paused
			progressBar.setDimmed(true);
			progressBar.repaint();
			paused = true;
			pauseSkill.setText("Unpause");
		}
		else if (paused && !skillPaused)
		{
			// React to the skill being unpaused (without update)
			progressBar.setDimmed(false);
			progressBar.repaint();
			paused = false;
			pauseSkill.setText("Pause");
		}

		// Update exp per hour separately, every time (not only when there's an update)
		expHour.setText(htmlLabel("XP/Hour: ", xpSnapshotSingle.getXpPerHour()));
	}

	static String htmlLabel(String key, int value)
	{
		String valueStr = StackFormatter.quantityToRSDecimalStack(value);
		return String.format(HTML_LABEL_TEMPLATE, SwingUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
=======
			levelLabel.setText(String.valueOf(xpSnapshotSingle.getCurrentLevel()));
			xpGained.setText(XpPanel.formatLine(xpSnapshotSingle.getXpGainedInSession(), "xp gained"));
			xpLeft.setText(XpPanel.formatLine(xpSnapshotSingle.getXpRemainingToGoal(), "xp left"));
			actionsLeft.setText(XpPanel.formatLine(xpSnapshotSingle.getActionsRemainingToGoal(), "actions left"));

			final int progress = xpSnapshotSingle.getSkillProgressToGoal();

			progressBar.setValue(progress);
			progressBar.setBackground(Color.getHSBColor((progress / 100.f) * (120.f / 360.f), 1, 1));

			progressBar.setToolTipText("<html>"
				+ XpPanel.formatLine(xpSnapshotSingle.getActionsInSession(), "actions")
				+ "<br/>"
				+ XpPanel.formatLine(xpSnapshotSingle.getActionsPerHour(), "actions/hr")
				+ "<br/>"
				+ xpSnapshotSingle.getTimeTillGoal() + " till next lvl"
				+ "</html>");
		}

		// Always update xp/hr as time always changes
		xpHr.setText(XpPanel.formatLine(xpSnapshotSingle.getXpPerHour(), "xp/hr"));
	}

	private static BufferedImage createHoverImage(BufferedImage image)
	{
		LookupTable lookup = new LookupTable(0, 4)
		{
			@Override
			public int[] lookupPixel(int[] src, int[] dest)
			{
				if (dest[3] != 0)
				{
					dest[3] = 60;
				}

				return dest;
			}
		};

		LookupOp op = new LookupOp(lookup, new RenderingHints(null));
		return op.filter(image, null);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
