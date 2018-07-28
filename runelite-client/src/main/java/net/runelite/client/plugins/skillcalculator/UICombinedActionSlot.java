/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

package net.runelite.client.plugins.skillcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
=======
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.JShadowedLabel;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

class UICombinedActionSlot extends JPanel
{

	private JShadowedLabel uiLabelActions;
	private JShadowedLabel uiLabelTitle;
	private static final Dimension ICON_SIZE = new Dimension(32, 32);

	UICombinedActionSlot()
	{
<<<<<<< HEAD
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);
		setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));

		JLabel uiIcon = new JLabel();
		uiIcon.setBorder(new EmptyBorder(0, 0, 0, 5));
=======
		BorderLayout layout = new BorderLayout();
		layout.setHgap(8);
		setLayout(layout);

		setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

		JLabel uiIcon = new JLabel();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		SkillCalculator.spriteManager.addSpriteTo(uiIcon, 582, 0);

		uiIcon.setMinimumSize(ICON_SIZE);
		uiIcon.setMaximumSize(ICON_SIZE);
		uiIcon.setPreferredSize(ICON_SIZE);
		uiIcon.setHorizontalAlignment(JLabel.CENTER);
		add(uiIcon, BorderLayout.LINE_START);

		JPanel uiInfo = new JPanel(new GridLayout(2, 1));
<<<<<<< HEAD
		uiInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		uiLabelTitle = new JShadowedLabel("No Action Selected");
		uiLabelTitle.setForeground(Color.WHITE);

		uiLabelActions = new JShadowedLabel("Shift-click to select multiple");
		uiLabelActions.setFont(FontManager.getRunescapeSmallFont());
		uiLabelActions.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		uiInfo.add(uiLabelTitle);
		uiInfo.add(uiLabelActions);

=======
		uiInfo.setOpaque(false);

		uiLabelTitle = new JShadowedLabel("No Action Selected");
		uiInfo.add(uiLabelTitle);

		uiLabelActions = new JShadowedLabel("Shift-click to select multiple");
		uiLabelActions.setFont(FontManager.getRunescapeSmallFont());
		uiInfo.add(uiLabelActions);

		setBackground(Color.orange);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		add(uiInfo, BorderLayout.CENTER);
	}

	void setText(String text)
	{
		uiLabelActions.setText(text);
	}

	void setTitle(String text)
	{
		uiLabelTitle.setText(text);
	}
}