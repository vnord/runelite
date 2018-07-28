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
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
<<<<<<< HEAD
import java.awt.image.BufferedImage;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
<<<<<<< HEAD
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
=======
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.vars.Autoweed;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
<<<<<<< HEAD
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
=======
import net.runelite.client.ui.PluginPanel;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@Slf4j
class FarmingTrackerPanel extends PluginPanel
{
	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final FarmingTrackerConfig config;

	private boolean active;

	private List<FarmingPatchPanel> patchPanels = new ArrayList<>();

<<<<<<< HEAD
	/* This is the panel the tabs' respective panels will be displayed on. */
	private final JPanel display = new JPanel();
	private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	FarmingTrackerPanel(
		Client client,
		ItemManager itemManager,
		ConfigManager configManager,
		FarmingTrackerConfig config,
		FarmingWorld farmingWorld
	)
	{
		super(false);

		this.client = client;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;

		setLayout(new BorderLayout());
<<<<<<< HEAD
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		display.setBorder(new EmptyBorder(10, 10, 8, 10));

		tabGroup.setBorder(new EmptyBorder(10, 1, 0, 0));

		add(tabGroup, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);

		farmingWorld.getTabs().forEach((tab, patches) ->
		{
			JPanel container = new JPanel(new GridBagLayout())
=======

		JTabbedPane tabs = new JTabbedPane();
		farmingWorld.getTabs().forEach((tab, patches) ->
		{
			JPanel panel = new JPanel(new GridBagLayout())
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			{
				@Override
				public Dimension getPreferredSize()
				{
					return new Dimension(PluginPanel.PANEL_WIDTH, super.getPreferredSize().height);
				}
			};
<<<<<<< HEAD
			container.setBackground(ColorScheme.DARK_GRAY_COLOR);
=======
			panel.setBorder(new EmptyBorder(2, 6, 6, 6));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;

<<<<<<< HEAD
			PatchImplementation lastImpl = null;

			boolean first = true;
			for (FarmingPatch patch : patches)
			{
				FarmingPatchPanel p = new FarmingPatchPanel(patch);

				/* Show labels to subdivide tabs into sections */
				if (patch.getImplementation() != lastImpl && !Strings.isNullOrEmpty(patch.getImplementation().getName()))
				{
					JLabel groupLabel = new JLabel(patch.getImplementation().getName());

					if (first)
					{
						first = false;
						groupLabel.setBorder(new EmptyBorder(4, 0, 0, 0));
					}
					else
					{
						groupLabel.setBorder(new EmptyBorder(15, 0, 0, 0));
					}

					groupLabel.setFont(FontManager.getRunescapeSmallFont());

					container.add(groupLabel, c);
					c.gridy++;
					lastImpl = patch.getImplementation();
				}

				patchPanels.add(p);
				container.add(p, c);
				c.gridy++;

				/* This is a weird hack to remove the top border on the first tracker of every tab */
				if (first)
				{
					first = false;
					p.setBorder(null);
				}
			}

			JPanel wrapped = new JPanel(new BorderLayout());
			wrapped.add(container, BorderLayout.NORTH);
			wrapped.setBackground(ColorScheme.DARK_GRAY_COLOR);

			JScrollPane scroller = new JScrollPane(wrapped);
			scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroller.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));
			scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 9, 0, 0));
			scroller.setBackground(ColorScheme.DARK_GRAY_COLOR);

			//Use a placeholder icon until the async image gets loaded
			MaterialTab materialTab = new MaterialTab(new ImageIcon(), tabGroup, scroller);
			materialTab.setPreferredSize(new Dimension(30, 27));
			materialTab.setName(tab.getName());

			AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
			Runnable resize = () ->
			{
				BufferedImage subIcon = icon.getSubimage(0, 0, 32, 32);
				materialTab.setIcon(new ImageIcon(subIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
=======
			for (FarmingPatch patch : patches)
			{
				FarmingPatchPanel p = new FarmingPatchPanel(patch);
				patchPanels.add(p);
				panel.add(p, c);
				c.gridy++;
			}

			JPanel wrapped = new JPanel(new BorderLayout());
			wrapped.add(panel, BorderLayout.NORTH);
			JScrollPane scroller = new JScrollPane(wrapped);
			scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroller.getVerticalScrollBar().setUnitIncrement(16);

			AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
			tabs.addTab(null, null, scroller, tab.getName());
			int idx = tabs.getTabCount() - 1;
			Runnable resize = () ->
			{
				tabs.setIconAt(idx, new ImageIcon(icon.getScaledInstance(24, 21, Image.SCALE_SMOOTH)));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			};
			icon.onChanged(resize);
			resize.run();

<<<<<<< HEAD
			materialTab.setOnSelectEvent(() ->
			{
				config.setPatch(tab);
				return true;
			});

			tabGroup.addTab(materialTab);
			if (config.patch() == tab)
			{
				tabGroup.select(materialTab);
			}
		});
=======
			if (config.patch() == tab)
			{
				tabs.setSelectedComponent(scroller);
			}
			tabs.addChangeListener(e ->
			{
				if (tabs.getSelectedComponent() == scroller)
				{
					config.setPatch(tab);
				}
			});
		});
		add(tabs, BorderLayout.CENTER);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	void update()
	{
		if (!active)
		{
			return;
		}

		long unixNow = Instant.now().getEpochSecond();
		log.debug("Updating panel with username {}", client.getUsername());
		boolean autoweed = false;
		{
			String group = FarmingTrackerConfig.KEY_NAME + "." + client.getUsername();
			autoweed = Integer.toString(Autoweed.ON.ordinal())
				.equals(configManager.getConfiguration(group, FarmingTrackerConfig.AUTOWEED));
		}
		for (FarmingPatchPanel panel : patchPanels)
		{
			FarmingPatch patch = panel.getPatch();
			String group = FarmingTrackerConfig.KEY_NAME + "." + client.getUsername() + "." + patch.getRegion().getRegionID();
			String key = Integer.toString(patch.getVarbit().getId());
			String storedValue = configManager.getConfiguration(group, key);
			long unixTime = 0;
			int value = 0;
			if (storedValue != null)
			{
				String[] parts = storedValue.split(":");
				if (parts.length == 2)
				{
					try
					{
						value = Integer.parseInt(parts[0]);
						unixTime = Long.parseLong(parts[1]);
					}
					catch (NumberFormatException e)
					{
					}
				}
			}

			PatchState state = unixTime <= 0 ? null : patch.getImplementation().forVarbitValue(value);
			if (state == null)
			{
<<<<<<< HEAD
				itemManager.getImage(Produce.WEEDS.getItemID()).addTo(panel.getIcon());
				panel.getIcon().setToolTipText("Unknown state");
				panel.getProgress().setMaximumValue(0);
				panel.getProgress().setValue(0);
				panel.getProgress().setVisible(false);
=======
				panel.getIcon().setIcon(null);
				panel.getIcon().setToolTipText("Unknown state");
				panel.getProgress().setMaximum(0);
				panel.getProgress().setValue(0);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				panel.getEstimate().setText("Unknown");
				panel.getProgress().setBackground(null);
			}
			else
			{
				if (state.getProduce().getItemID() < 0)
				{
					panel.getIcon().setIcon(null);
					panel.getIcon().setToolTipText("Unknown state");
				}
				else
				{
					itemManager.getImage(state.getProduce().getItemID()).addTo(panel.getIcon());
					panel.getIcon().setToolTipText(state.getProduce().getName());
				}

				int stage = state.getStage();
				int stages = state.getCropState() == CropState.HARVESTABLE ?
					state.getProduce().getHarvestStages() :
					state.getProduce().getStages();
				int tickrate = 0;
				switch (state.getCropState())
				{
					case HARVESTABLE:
						tickrate = state.getProduce().getRegrowTickrate() * 60;
						break;
					case GROWING:
						tickrate = state.getProduce().getTickrate() * 60;
						break;
				}
				if (autoweed && state.getProduce() == Produce.WEEDS)
				{
					stage = 0;
					stages = 1;
					tickrate = 0;
				}
				if (tickrate > 0)
				{
					long tickNow = unixNow / tickrate;
					long tickTime = unixTime / tickrate;
					int delta = (int) (tickNow - tickTime);

					long doneEstimate = ((stages - 1 - stage) + tickTime) * tickrate;

					stage += delta;
					if (stage >= stages)
					{
						stage = stages - 1;
					}

					if (doneEstimate < unixNow)
					{
						panel.getEstimate().setText("Done");
					}
					else if (config.estimateRelative())
					{
						int remaining = (int) (59 + doneEstimate - unixNow) / 60;
						StringBuilder f = new StringBuilder();
						f.append("Done in ");
						int min = remaining % 60;
						int hours = (remaining / 60) % 24;
						int days = remaining / (60 * 24);
						if (days > 0)
						{
							f.append(days).append("d ");
						}
						if (hours > 0)
						{
							f.append(hours).append("h ");
						}
						if (min > 0)
						{
							f.append(min).append("m ");
						}
						panel.getEstimate().setText(f.toString());
					}
					else
					{
						StringBuilder f = new StringBuilder();
						LocalDateTime ldtTime = LocalDateTime.ofEpochSecond(doneEstimate, 0, OffsetDateTime.now().getOffset());
						LocalDateTime ldtNow = LocalDateTime.now();
						f.append("Done ");
						if (ldtTime.getDayOfWeek() != ldtNow.getDayOfWeek())
						{
							f.append(ldtTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault())).append(" ");
						}
						f.append(String.format("at %d:%02d", ldtTime.getHour(), ldtTime.getMinute()));
						panel.getEstimate().setText(f.toString());
					}
				}
				else
				{
					switch (state.getCropState())
					{
						case HARVESTABLE:
							panel.getEstimate().setText("Done");
							break;
						case GROWING:
							if (stage == stages - 1)
							{
								panel.getEstimate().setText("Done");
							}
							else
							{
								panel.getEstimate().setText("Unknown");
							}
							break;
						case DISEASED:
							panel.getEstimate().setText("Diseased");
							break;
						case DEAD:
							panel.getEstimate().setText("Dead");
							break;
					}
				}

<<<<<<< HEAD
				/* Hide any fully grown weeds' progress bar. */
				if (state.getProduce() != Produce.WEEDS
					|| (state.getProduce() == Produce.WEEDS && !autoweed && stage < stages - 1))
				{
					panel.getProgress().setVisible(true);
					panel.getProgress().setForeground(state.getCropState().getColor().darker());
					panel.getProgress().setMaximumValue(stages - 1);
					panel.getProgress().setValue(stage);
					panel.getProgress().update();
				}
				else
				{
					panel.getProgress().setVisible(false);
				}
=======
				panel.getProgress().setBackground(state.getCropState().getColor().darker());
				panel.getProgress().setMaximum(stages - 1);
				panel.getProgress().setValue(stage);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}
	}

	@Override
	public void onActivate()
	{
		active = true;
		update();
	}

	@Override
	public void onDeactivate()
	{
		active = false;
	}
}
