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
package net.runelite.client.plugins.config;

<<<<<<< HEAD
import com.google.common.base.Splitter;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
<<<<<<< HEAD
=======
import java.awt.GridLayout;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
=======
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
<<<<<<< HEAD
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
=======
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
=======
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
<<<<<<< HEAD
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ComboBoxListRenderer;
import net.runelite.client.ui.components.IconButton;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.util.SwingUtil;
=======
import net.runelite.client.ui.PluginPanel;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

@Slf4j
public class ConfigPanel extends PluginPanel
{
<<<<<<< HEAD
	private static final int SPINNER_FIELD_WIDTH = 6;
	private static final int SCROLLBAR_WIDTH = 17;
	private static final int OFFSET = 6;
	private static final ImageIcon BACK_ICON;
	private static final ImageIcon BACK_ICON_HOVER;
	private static final ImageIcon SEARCH;

	private static final String RUNELITE_GROUP_NAME = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).value();
	private static final String PINNED_PLUGINS_CONFIG_KEY = "pinnedPlugins";
	private static final String RUNELITE_PLUGIN = "RuneLite";
	private static final String CHAT_COLOR_PLUGIN = "Chat Color";
	private static final Splitter COMMA_SPLITTER = Splitter.on(',');

	private final PluginManager pluginManager;
	private final ConfigManager configManager;
	private final ScheduledExecutorService executorService;
	private final RuneLiteConfig runeLiteConfig;
	private final ChatColorConfig chatColorConfig;
	private final IconTextField searchBar = new IconTextField();
	private final List<PluginListItem> pluginList = new ArrayList<>();

	private final JPanel topPanel;
	private final JPanel mainPanel;
	private final JScrollPane scrollPane;

	private boolean showingPluginList = true;
	private int scrollBarPosition = 0;
=======
	private static final int TEXT_FIELD_WIDTH = 7;
	private static final int SPINNER_FIELD_WIDTH = 6;
	private static BufferedImage CONFIG_ICON;
	private static BufferedImage UNCHECK_ICON;
	private static BufferedImage CHECK_ICON;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
<<<<<<< HEAD
				BufferedImage backIcon = ImageIO.read(ConfigPanel.class.getResourceAsStream("config_back_icon.png"));
				BACK_ICON = new ImageIcon(backIcon);
				BACK_ICON_HOVER = new ImageIcon(SwingUtil.grayscaleOffset(backIcon, -100));
				SEARCH = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search.png")));
=======
				CONFIG_ICON = ImageIO.read(ConfigPanel.class.getResourceAsStream("config_icon.png"));
				UNCHECK_ICON = ImageIO.read(ConfigPanel.class.getResourceAsStream("disabled.png"));
				CHECK_ICON = ImageIO.read(ConfigPanel.class.getResourceAsStream("enabled.png"));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}
		catch (IOException e)
		{
<<<<<<< HEAD
			throw new RuntimeException(e);
		}
	}

	ConfigPanel(PluginManager pluginManager, ConfigManager configManager, ScheduledExecutorService executorService,
		RuneLiteConfig runeLiteConfig, ChatColorConfig chatColorConfig)
	{
		super(false);
=======
			log.warn("Failed to read icon", e);
		}
	}

	private final PluginManager pluginManager;
	private final ConfigManager configManager;
	private final ScheduledExecutorService executorService;
	private final RuneLiteConfig runeLiteConfig;
	private final JTextField searchBar = new JTextField();
	private Map<String, JPanel> children = new TreeMap<>();
	private int scrollBarPosition = 0;

	public ConfigPanel(PluginManager pluginManager, ConfigManager configManager, ScheduledExecutorService executorService, RuneLiteConfig runeLiteConfig)
	{
		super();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		this.pluginManager = pluginManager;
		this.configManager = configManager;
		this.executorService = executorService;
		this.runeLiteConfig = runeLiteConfig;
<<<<<<< HEAD
		this.chatColorConfig = chatColorConfig;

		searchBar.setIcon(SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
=======

>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		searchBar.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				onSearchBarChanged();
			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{
				onSearchBarChanged();
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				onSearchBarChanged();
			}
		});

<<<<<<< HEAD
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		topPanel.setLayout(new BorderLayout(0, OFFSET));
		add(topPanel, BorderLayout.NORTH);

		mainPanel = new FixedWidthPanel();
		mainPanel.setBorder(new EmptyBorder(8, 10, 10, 10));
		mainPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel northPanel = new FixedWidthPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(mainPanel, BorderLayout.NORTH);

		scrollPane = new JScrollPane(northPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);

		initializePluginList();
		refreshPluginList();
	}

	private void initializePluginList()
	{
		final List<String> pinnedPlugins = getPinnedPluginNames();

		// populate pluginList with all non-hidden plugins
		pluginManager.getPlugins().stream()
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).hidden())
			.forEach(plugin ->
			{
				final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
				final Config config = pluginManager.getPluginConfigProxy(plugin);
				final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

				final PluginListItem listItem = new PluginListItem(this, plugin, descriptor, config, configDescriptor);
				listItem.setPinned(pinnedPlugins.contains(listItem.getName()));
				pluginList.add(listItem);
			});

		// add special entries for core client configurations
		final PluginListItem runeLite = new PluginListItem(this, runeLiteConfig,
			configManager.getConfigDescriptor(runeLiteConfig),
			RUNELITE_PLUGIN, "RuneLite client settings", "client");
		runeLite.setPinned(pinnedPlugins.contains(RUNELITE_PLUGIN));
		pluginList.add(runeLite);

		final PluginListItem chatColor = new PluginListItem(this, chatColorConfig,
			configManager.getConfigDescriptor(chatColorConfig),
			CHAT_COLOR_PLUGIN, "Recolor chat text", "colour", "messages");
		chatColor.setPinned(pinnedPlugins.contains(CHAT_COLOR_PLUGIN));
		pluginList.add(chatColor);

		pluginList.sort(Comparator.comparing(PluginListItem::getName));
	}

	void refreshPluginList()
	{
		// update enabled / disabled status of all items
		pluginList.forEach(listItem ->
		{
			final Plugin plugin = listItem.getPlugin();
			if (plugin != null)
			{
				listItem.setPluginEnabled(pluginManager.isPluginEnabled(plugin));
			}
		});

		if (showingPluginList)
		{
			openConfigList();
		}
	}

	void openConfigList()
	{
		if (showingPluginList)
		{
			scrollBarPosition = scrollPane.getVerticalScrollBar().getValue();
		}

		showingPluginList = true;

		topPanel.removeAll();
		mainPanel.removeAll();

		JLabel title = new JLabel("Configuration", SwingConstants.LEFT);
		title.setForeground(Color.WHITE);

		topPanel.add(title, BorderLayout.NORTH);
		topPanel.add(searchBar, BorderLayout.CENTER);

		onSearchBarChanged();
		searchBar.requestFocusInWindow();
		validate();
		scrollPane.getVerticalScrollBar().setValue(scrollBarPosition);
=======
		rebuildPluginList();
		openConfigList();
	}

	final void rebuildPluginList()
	{
		scrollBarPosition = getScrollPane().getVerticalScrollBar().getValue();
		Map<String, JPanel> newChildren = new TreeMap<>();

		pluginManager.getPlugins().stream()
				.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).hidden())
				.sorted(Comparator.comparing(left -> left.getClass().getAnnotation(PluginDescriptor.class).name()))
				.forEach(plugin ->
				{
					final Config pluginConfigProxy = pluginManager.getPluginConfigProxy(plugin);
					final String pluginName = plugin.getClass().getAnnotation(PluginDescriptor.class).name();

					final JPanel groupPanel = buildGroupPanel();
					groupPanel.add(new JLabel(pluginName), BorderLayout.CENTER);

					final JPanel buttonPanel = new JPanel();
					buttonPanel.setLayout(new GridLayout(1, 2, 3, 0));
					groupPanel.add(buttonPanel, BorderLayout.LINE_END);

					final JButton editConfigButton = buildConfigButton(pluginConfigProxy);
					buttonPanel.add(editConfigButton);

					final JButton toggleButton = buildToggleButton(plugin);
					buttonPanel.add(toggleButton);

					newChildren.put(pluginName, groupPanel);
				});


		final JPanel groupPanel = buildGroupPanel();
		groupPanel.add(new JLabel("RuneLite"), BorderLayout.CENTER);

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2, 3, 0));
		groupPanel.add(buttonPanel, BorderLayout.LINE_END);

		final JButton editConfigButton = buildConfigButton(runeLiteConfig);
		buttonPanel.add(editConfigButton);

		final JButton toggleButton = buildToggleButton(null);
		buttonPanel.add(toggleButton);
		newChildren.put("RuneLite", groupPanel);

		children = newChildren;
		openConfigList();
	}

	private JPanel buildGroupPanel()
	{
		// Create base panel for the config button and enabled/disabled button
		final JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new BorderLayout(3, 0));
		return groupPanel;
	}

	private JButton buildConfigButton(Config config)
	{
		// Create edit config button and disable it by default
		final JButton editConfigButton = new JButton(new ImageIcon(CONFIG_ICON));
		editConfigButton.setPreferredSize(new Dimension(32, 0));
		editConfigButton.setEnabled(false);

		// If we have configuration proxy enable the button and add edit config listener
		if (config != null)
		{
			final ConfigDescriptor configDescriptor = configManager.getConfigDescriptor(config);
			final boolean configEmpty = configDescriptor.getItems().stream().allMatch(item -> item.getItem().hidden());

			if (!configEmpty)
			{
				editConfigButton.addActionListener(ae -> openGroupConfigPanel(config, configDescriptor, configManager));
				editConfigButton.setEnabled(true);
				editConfigButton.setToolTipText("Edit plugin configuration");
			}
		}

		return editConfigButton;
	}

	private JButton buildToggleButton(Plugin plugin)
	{
		// Create enabling/disabling button
		final JButton toggleButton = new JButton(new ImageIcon(CHECK_ICON));
		toggleButton.setPreferredSize(new Dimension(32, 0));

		if (plugin == null)
		{
			toggleButton.setEnabled(false);
			return toggleButton;
		}

		highlightButton(toggleButton, pluginManager.isPluginEnabled(plugin));

		toggleButton.addActionListener(e -> executorService.submit(() ->
		{
			final boolean enabled = pluginManager.isPluginEnabled(plugin);
			pluginManager.setPluginEnabled(plugin, !enabled);

			try
			{
				if (enabled)
				{
					pluginManager.stopPlugin(plugin);
				}
				else
				{
					pluginManager.startPlugin(plugin);
				}
			}
			catch (PluginInstantiationException ex)
			{
				log.warn("Error during starting/stopping plugin {}", plugin.getClass().getSimpleName(), ex);
			}

			highlightButton(toggleButton, !enabled);
		}));

		return toggleButton;
	}

	private void highlightButton(JButton button, boolean enabled)
	{
		button.setIcon(enabled ? new ImageIcon(CHECK_ICON) : new ImageIcon(UNCHECK_ICON));
		button.setToolTipText(enabled ? "Disable plugin" : "Enable plugin");
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	private void onSearchBarChanged()
	{
		final String text = searchBar.getText();

<<<<<<< HEAD
		pluginList.forEach(mainPanel::remove);

		showMatchingPlugins(true, text);
		showMatchingPlugins(false, text);

		revalidate();
	}

	private void showMatchingPlugins(boolean pinned, String text)
	{
		if (text.isEmpty())
		{
			pluginList.stream().filter(item -> pinned == item.isPinned()).forEach(mainPanel::add);
			return;
		}

		final String[] searchTerms = text.toLowerCase().split(" ");
		pluginList.forEach(listItem ->
		{
			if (pinned == listItem.isPinned() && listItem.matchesSearchTerms(searchTerms))
			{
				mainPanel.add(listItem);
			}
		});
	}

	void openGroupConfigPanel(PluginListItem listItem, Config config, ConfigDescriptor cd)
	{
		showingPluginList = false;

		scrollBarPosition = scrollPane.getVerticalScrollBar().getValue();
		topPanel.removeAll();
		mainPanel.removeAll();

		final IconButton topPanelBackButton = new IconButton(BACK_ICON, BACK_ICON_HOVER);
		topPanelBackButton.setPreferredSize(new Dimension(22, 0));
		topPanelBackButton.setBorder(new EmptyBorder(0, 0, 0, 5));
		topPanelBackButton.addActionListener(e -> openConfigList());
		topPanelBackButton.setToolTipText("Back");
		topPanel.add(topPanelBackButton, BorderLayout.WEST);

		topPanel.add(listItem.createToggleButton(), BorderLayout.EAST);

		String name = listItem.getName();
		JLabel title = new JLabel(name);
		title.setForeground(Color.WHITE);
		title.setToolTipText("<html>" + name + ":<br>" + listItem.getDescription() + "</html>");
		topPanel.add(title);
=======
		children.values().forEach(this::remove);

		if (text.isEmpty())
		{
			children.values().forEach(this::add);
			revalidate();
			return;
		}

		FuzzySearch.findAndProcess(text, children.keySet(), (k) -> add(children.get(k)));
		revalidate();
	}

	@Override
	public void onActivate()
	{
		super.onActivate();
		if (searchBar.getParent() != null)
		{
			searchBar.requestFocusInWindow();
		}
	}

	private void openConfigList()
	{
		removeAll();
		add(new JLabel("Plugin Configuration", SwingConstants.CENTER));
		add(searchBar);

		onSearchBarChanged();
		searchBar.requestFocusInWindow();
		JScrollPane scrollbar = getScrollPane();
		scrollbar.validate();
		scrollbar.getVerticalScrollBar().setValue(scrollBarPosition);
	}

	private void changeConfiguration(Config config, JComponent component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		ConfigItem configItem = cid.getItem();

		if (!Strings.isNullOrEmpty(configItem.warning()))
		{
			final int result = JOptionPane.showOptionDialog(component, configItem.warning(),
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				openGroupConfigPanel(config, cd, configManager);
				return;
			}
		}

		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), "" + checkbox.isSelected());
		}

		if (component instanceof JSpinner)
		{
			JSpinner spinner = (JSpinner) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), "" + spinner.getValue());
		}

		if (component instanceof JTextField)
		{
			JTextField textField = (JTextField) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), textField.getText());
		}

		if (component instanceof JColorChooser)
		{
			JColorChooser jColorChooser = (JColorChooser) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), String.valueOf(jColorChooser.getColor().getRGB()));
		}

		if (component instanceof JComboBox)
		{
			JComboBox jComboBox = (JComboBox) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), ((Enum) jComboBox.getSelectedItem()).name());
		}
	}

	private void openGroupConfigPanel(Config config, ConfigDescriptor cd, ConfigManager configManager)
	{
		scrollBarPosition = getScrollPane().getVerticalScrollBar().getValue();
		removeAll();
		String name = cd.getGroup().name() + " Configuration";
		JLabel title = new JLabel(name);
		title.setToolTipText(cd.getGroup().description());
		add(title, SwingConstants.CENTER);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

		for (ConfigItemDescriptor cid : cd.getItems())
		{
			if (cid.getItem().hidden())
			{
				continue;
			}

			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
<<<<<<< HEAD
			item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
			name = cid.getItem().name();
			JLabel configEntryName = new JLabel(name);
			configEntryName.setForeground(Color.WHITE);
=======
			name = cid.getItem().name();
			JLabel configEntryName = new JLabel(name);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			configEntryName.setToolTipText("<html>" + name + ":<br>" + cid.getItem().description() + "</html>");
			item.add(configEntryName, BorderLayout.CENTER);

			if (cid.getType() == boolean.class)
			{
				JCheckBox checkbox = new JCheckBox();
<<<<<<< HEAD
				checkbox.setBackground(ColorScheme.LIGHT_GRAY_COLOR);
				checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName())));
				checkbox.addActionListener(ae -> changeConfiguration(listItem, config, checkbox, cd, cid));
=======
				checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
				checkbox.addActionListener(ae -> changeConfiguration(config, checkbox, cd, cid));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				item.add(checkbox, BorderLayout.EAST);
			}

			if (cid.getType() == int.class)
			{
<<<<<<< HEAD
				int value = Integer.parseInt(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));
=======
				int value = Integer.parseInt(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				SpinnerModel model = new SpinnerNumberModel(value, 0, Integer.MAX_VALUE, 1);
				JSpinner spinner = new JSpinner(model);
				Component editor = spinner.getEditor();
				JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
				spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
<<<<<<< HEAD
				spinner.addChangeListener(ce -> changeConfiguration(listItem, config, spinner, cd, cid));
=======
				spinner.addChangeListener(ce -> changeConfiguration(config, spinner, cd, cid));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				item.add(spinner, BorderLayout.EAST);
			}

			if (cid.getType() == String.class)
			{
<<<<<<< HEAD
				JTextArea textField = new JTextArea();
				textField.setLineWrap(true);
				textField.setWrapStyleWord(true);
				textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				textField.setText(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));
=======
				JTextField textField = new JTextField("", TEXT_FIELD_WIDTH);
				textField.setText(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				textField.addFocusListener(new FocusAdapter()
				{
					@Override
					public void focusLost(FocusEvent e)
					{
<<<<<<< HEAD
						changeConfiguration(listItem, config, textField, cd, cid);
					}
				});

				item.add(textField, BorderLayout.SOUTH);
=======
						changeConfiguration(config, textField, cd, cid);
						textField.setToolTipText(textField.getText());
					}
				});

				textField.addActionListener(e ->
				{
					changeConfiguration(config, textField, cd, cid);
					textField.setToolTipText(textField.getText());
				});

				textField.setToolTipText(textField.getText());
				item.add(textField, BorderLayout.EAST);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}

			if (cid.getType() == Color.class)
			{
<<<<<<< HEAD
				String existing = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());

				Color existingColor;
				JButton colorPicker;

				if (existing == null)
				{
					existingColor = Color.BLACK;
					colorPicker = new JButton("Pick a color");
				}
				else
				{
					existingColor = Color.decode(existing);
					colorPicker = new JButton("#" + Integer.toHexString(existingColor.getRGB()).substring(2).toUpperCase());
				}

				colorPicker.setFocusable(false);
				colorPicker.setBackground(existingColor);
=======
				JButton colorPicker = new JButton("Pick a color");
				colorPicker.setFocusable(false);
				colorPicker.setBackground(Color.decode(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				colorPicker.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						final JFrame parent = new JFrame();
<<<<<<< HEAD
						JColorChooser jColorChooser = new JColorChooser(existingColor);
						jColorChooser.getSelectionModel().addChangeListener(e1 ->
						{
							colorPicker.setBackground(jColorChooser.getColor());
							colorPicker.setText("#" + Integer.toHexString(jColorChooser.getColor().getRGB()).substring(2).toUpperCase());
						});
=======
						JColorChooser jColorChooser = new JColorChooser(Color.decode(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
						jColorChooser.getSelectionModel().addChangeListener(e1 -> colorPicker.setBackground(jColorChooser.getColor()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
						parent.addWindowListener(new WindowAdapter()
						{
							@Override
							public void windowClosing(WindowEvent e)
							{
<<<<<<< HEAD
								changeConfiguration(listItem, config, jColorChooser, cd, cid);
=======
								changeConfiguration(config, jColorChooser, cd, cid);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
							}
						});
						parent.add(jColorChooser);
						parent.pack();
						parent.setVisible(true);
					}
				});
				item.add(colorPicker, BorderLayout.EAST);
			}

			if (cid.getType() == Dimension.class)
			{
				JPanel dimensionPanel = new JPanel();
				dimensionPanel.setLayout(new BorderLayout());

<<<<<<< HEAD
				String str = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());
=======
				String str = configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				String[] splitStr = str.split("x");
				int width = Integer.parseInt(splitStr[0]);
				int height = Integer.parseInt(splitStr[1]);

				SpinnerModel widthModel = new SpinnerNumberModel(width, 0, Integer.MAX_VALUE, 1);
				JSpinner widthSpinner = new JSpinner(widthModel);
				Component widthEditor = widthSpinner.getEditor();
				JFormattedTextField widthSpinnerTextField = ((JSpinner.DefaultEditor) widthEditor).getTextField();
				widthSpinnerTextField.setColumns(4);

				SpinnerModel heightModel = new SpinnerNumberModel(height, 0, Integer.MAX_VALUE, 1);
				JSpinner heightSpinner = new JSpinner(heightModel);
				Component heightEditor = heightSpinner.getEditor();
				JFormattedTextField heightSpinnerTextField = ((JSpinner.DefaultEditor) heightEditor).getTextField();
				heightSpinnerTextField.setColumns(4);

				ChangeListener listener = e ->
<<<<<<< HEAD
					configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), widthSpinner.getValue() + "x" + heightSpinner.getValue());
=======
						configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), widthSpinner.getValue() + "x" + heightSpinner.getValue());
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

				widthSpinner.addChangeListener(listener);
				heightSpinner.addChangeListener(listener);

				dimensionPanel.add(widthSpinner, BorderLayout.WEST);
				dimensionPanel.add(new JLabel(" x "), BorderLayout.CENTER);
				dimensionPanel.add(heightSpinner, BorderLayout.EAST);

				item.add(dimensionPanel, BorderLayout.EAST);
			}

			if (cid.getType().isEnum())
			{
				Class<? extends Enum> type = (Class<? extends Enum>) cid.getType();
				JComboBox box = new JComboBox(type.getEnumConstants());
<<<<<<< HEAD
				box.setPreferredSize(new Dimension(box.getPreferredSize().width, 25));
				box.setRenderer(new ComboBoxListRenderer());
				box.setForeground(Color.WHITE);
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				box.setFocusable(false);
				box.setPrototypeDisplayValue("XXXXXXXX"); //sorry but this is the way to keep the size of the combobox in check.
				try
				{
<<<<<<< HEAD
					Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));
=======
					Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
					box.setSelectedItem(selectedItem);
					box.setToolTipText(selectedItem.toString());
				}
				catch (IllegalArgumentException ex)
				{
					log.debug("invalid seleced item", ex);
				}
				box.addItemListener(e ->
				{
					if (e.getStateChange() == ItemEvent.SELECTED)
					{
<<<<<<< HEAD
						changeConfiguration(listItem, config, box, cd, cid);
=======
						changeConfiguration(config, box, cd, cid);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
						box.setToolTipText(box.getSelectedItem().toString());
					}
				});
				item.add(box, BorderLayout.EAST);
			}

<<<<<<< HEAD
			if (cid.getType() == Keybind.class)
			{
				Keybind startingValue = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName(), Keybind.class);

				HotkeyButton button = new HotkeyButton(startingValue);

				button.addFocusListener(new FocusAdapter()
				{
					@Override
					public void focusLost(FocusEvent e)
					{
						changeConfiguration(listItem, config, button, cd, cid);
					}
				});

				item.add(button, BorderLayout.EAST);
			}

			mainPanel.add(item);
=======
			add(item);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener((e) ->
		{
			configManager.setDefaultConfiguration(config, true);

			// Reload configuration panel
<<<<<<< HEAD
			openGroupConfigPanel(listItem, config, cd);
		});
		mainPanel.add(resetButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> openConfigList());
		mainPanel.add(backButton);

		revalidate();
		scrollPane.getVerticalScrollBar().setValue(0);
	}

	private void changeConfiguration(PluginListItem listItem, Config config, JComponent component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		final ConfigItem configItem = cid.getItem();

		if (!Strings.isNullOrEmpty(configItem.warning()))
		{
			final int result = JOptionPane.showOptionDialog(component, configItem.warning(),
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				openGroupConfigPanel(listItem, config, cd);
				return;
			}
		}

		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + checkbox.isSelected());
		}
		else if (component instanceof JSpinner)
		{
			JSpinner spinner = (JSpinner) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + spinner.getValue());
		}
		else if (component instanceof JTextArea)
		{
			JTextArea textField = (JTextArea) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), textField.getText());
		}
		else if (component instanceof JColorChooser)
		{
			JColorChooser jColorChooser = (JColorChooser) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), String.valueOf(jColorChooser.getColor().getRGB()));
		}
		else if (component instanceof JComboBox)
		{
			JComboBox jComboBox = (JComboBox) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), ((Enum) jComboBox.getSelectedItem()).name());
		}
		else if (component instanceof HotkeyButton)
		{
			HotkeyButton hotkeyButton = (HotkeyButton) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), hotkeyButton.getValue());
		}
	}

	void startPlugin(Plugin plugin, PluginListItem listItem)
	{
		executorService.submit(() ->
		{
			pluginManager.setPluginEnabled(plugin, true);

			try
			{
				pluginManager.startPlugin(plugin);
			}
			catch (PluginInstantiationException ex)
			{
				log.warn("Error when starting plugin {}", plugin.getClass().getSimpleName(), ex);
			}

			listItem.setPluginEnabled(true);
		});
	}

	void stopPlugin(Plugin plugin, PluginListItem listItem)
	{
		executorService.submit(() ->
		{
			pluginManager.setPluginEnabled(plugin, false);

			try
			{
				pluginManager.stopPlugin(plugin);
			}
			catch (PluginInstantiationException ex)
			{
				log.warn("Error when stopping plugin {}", plugin.getClass().getSimpleName(), ex);
			}

			listItem.setPluginEnabled(false);
		});
	}

	private List<String> getPinnedPluginNames()
	{
		final String config = configManager.getConfiguration(RUNELITE_GROUP_NAME, PINNED_PLUGINS_CONFIG_KEY);

		if (config == null)
		{
			return Collections.emptyList();
		}

		return COMMA_SPLITTER.splitToList(config);
	}

	void savePinnedPlugins()
	{
		final String value = pluginList.stream()
			.filter(PluginListItem::isPinned)
			.map(PluginListItem::getName)
			.collect(Collectors.joining(","));

		configManager.setConfiguration(RUNELITE_GROUP_NAME, PINNED_PLUGINS_CONFIG_KEY, value);
	}

	@Override
	public void onActivate()
	{
		super.onActivate();

		if (searchBar.getParent() != null)
		{
			searchBar.requestFocusInWindow();
		}
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(PANEL_WIDTH + SCROLLBAR_WIDTH, super.getPreferredSize().height);
	}

	private class FixedWidthPanel extends JPanel
	{
		@Override
		public Dimension getPreferredSize()
		{
			return new Dimension(PANEL_WIDTH, super.getPreferredSize().height);
		}

	}
}
=======
			openGroupConfigPanel(config, cd, configManager);
		});
		add(resetButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> openConfigList());
		add(backButton);

		revalidate();
		getScrollPane().getVerticalScrollBar().setValue(0);
	}
}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
