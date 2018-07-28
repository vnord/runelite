/*
 * Copyright (c) 2018 Abex
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
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingtracker;

<<<<<<< HEAD
import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.ThinProgressBar;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
=======
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import lombok.Getter;
import net.runelite.client.ui.FontManager;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@Getter
class FarmingPatchPanel extends JPanel
{
	private final FarmingPatch patch;
	private final JLabel icon = new JLabel();
	private final JLabel estimate = new JLabel();
<<<<<<< HEAD
	private final ThinProgressBar progress = new ThinProgressBar();
=======
	private final JProgressBar progress = new JProgressBar();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	FarmingPatchPanel(FarmingPatch patch)
	{
		this.patch = patch;

<<<<<<< HEAD
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(7, 0, 0, 0));

		JPanel topContainer = new JPanel();
		topContainer.setBorder(new EmptyBorder(7, 7, 6, 0));
		topContainer.setLayout(new BorderLayout());
		topContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		icon.setMinimumSize(new Dimension(36, 32));

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		infoPanel.setLayout(new GridLayout(2, 1));
		infoPanel.setBorder(new EmptyBorder(4, 4, 4, 0));

		final JLabel location = new JShadowedLabel(patch.getRegion().getName()
			+ (Strings.isNullOrEmpty(patch.getName()) ? "" : " (" + patch.getName() + ")"));
		location.setFont(FontManager.getRunescapeSmallFont());
		location.setForeground(Color.WHITE);

		estimate.setFont(FontManager.getRunescapeSmallFont());
		estimate.setForeground(Color.GRAY);

		infoPanel.add(location);
		infoPanel.add(estimate);

		topContainer.add(icon, BorderLayout.WEST);
		topContainer.add(infoPanel, BorderLayout.CENTER);

		add(topContainer, BorderLayout.NORTH);
		add(progress, BorderLayout.SOUTH);
=======
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		final JLabel location = new JLabel(patch.getRegion().getName() + " " + patch.getName());
		location.setFont(FontManager.getRunescapeSmallFont());
		icon.setMinimumSize(new Dimension(36, 32));

		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(icon)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addComponent(location)
					.addGap(1)
					.addComponent(estimate)
				)
			)
			.addComponent(progress, 8, 8, 8)
			.addGap(4)
		);

		layout.setHorizontalGroup(layout.createParallelGroup()
			.addGroup(layout.createSequentialGroup()
				.addComponent(icon)
				.addGroup(layout.createParallelGroup()
					.addComponent(location)
					.addComponent(estimate)
				)
			)
			.addComponent(progress)
		);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}
}
