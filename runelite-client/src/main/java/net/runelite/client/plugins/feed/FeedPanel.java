/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.feed;

import java.awt.BorderLayout;
import java.awt.Color;
<<<<<<< HEAD
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
=======
import java.awt.Dimension;
import java.awt.Font;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.function.Supplier;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
import net.runelite.client.ui.ColorScheme;
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.LinkBrowser;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.feed.FeedItem;
import net.runelite.http.api.feed.FeedItemType;
import net.runelite.http.api.feed.FeedResult;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Slf4j
class FeedPanel extends PluginPanel
{
<<<<<<< HEAD
	private static final ImageIcon RUNELITE_ICON;
	private static final ImageIcon OSRS_ICON;
=======
	private static BufferedImage RUNELITE_ICON;
	private static BufferedImage OSRS_ICON;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

	private static final Color TWEET_BACKGROUND = new Color(15, 15, 15);
	private static final Color OSRS_NEWS_BACKGROUND = new Color(36, 30, 19);
	private static final Color BLOG_POST_BACKGROUND = new Color(11, 30, 41);

	private static final int MAX_CONTENT_LINES = 3;
	private static final int CONTENT_WIDTH = 148;
	private static final int TIME_WIDTH = 20;

<<<<<<< HEAD
	/**
	 * Holds all feed items.
	 */
	private final JPanel feedContainer = new JPanel();

=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private static final Comparator<FeedItem> FEED_ITEM_COMPARATOR = (o1, o2) ->
	{
		if (o1.getType() != o2.getType())
		{
			if (o1.getType() == FeedItemType.BLOG_POST)
			{
				return -1;
			}
			else if (o2.getType() == FeedItemType.BLOG_POST)
			{
				return 1;
			}
		}

		return -Long.compare(o1.getTimestamp(), o2.getTimestamp());
	};

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
<<<<<<< HEAD
				RUNELITE_ICON = new ImageIcon(ImageIO.read(FeedPanel.class.getResourceAsStream("runelite.png")));
				OSRS_ICON = new ImageIcon(ImageIO.read(FeedPanel.class.getResourceAsStream("osrs.png")));
=======
				RUNELITE_ICON = ImageIO.read(FeedPanel.class.getResourceAsStream("runelite.png"));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}
		}
		catch (IOException e)
		{
<<<<<<< HEAD
			throw new RuntimeException(e);
=======
			log.warn("Client icon failed to load", e);
		}

		try
		{
			synchronized (ImageIO.class)
			{
				OSRS_ICON = ImageIO.read(FeedPanel.class.getResourceAsStream("osrs.png"));
			}
		}
		catch (IOException e)
		{
			log.warn("OSRS icon failed to load", e);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}
	}

	private final FeedConfig config;
	private final Supplier<FeedResult> feedSupplier;

	FeedPanel(FeedConfig config, Supplier<FeedResult> feedSupplier)
	{
		this.config = config;
		this.feedSupplier = feedSupplier;
<<<<<<< HEAD

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		feedContainer.setLayout(new GridLayout(0, 1, 0, 4));
		feedContainer.setBackground(ColorScheme.DARK_GRAY_COLOR);

		JLabel title = new JLabel("News feed");
		title.setBorder(new EmptyBorder(0, 0, 9, 0));
		title.setForeground(Color.WHITE);

		add(title, BorderLayout.NORTH);
		add(feedContainer, BorderLayout.CENTER);
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	void rebuildFeed()
	{
		FeedResult feed = feedSupplier.get();

		if (feed == null)
		{
			return;
		}

		SwingUtilities.invokeLater(() ->
		{
<<<<<<< HEAD
			feedContainer.removeAll();
=======
			removeAll();
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b

			feed.getItems()
				.stream()
				.filter(f -> f.getType() != FeedItemType.BLOG_POST || config.includeBlogPosts())
				.filter(f -> f.getType() != FeedItemType.TWEET || config.includeTweets())
				.filter(f -> f.getType() != FeedItemType.OSRS_NEWS || config.includeOsrsNews())
				.sorted(FEED_ITEM_COMPARATOR)
				.forEach(this::addItemToPanel);
		});
	}

	private void addItemToPanel(FeedItem item)
	{
		JPanel avatarAndRight = new JPanel(new BorderLayout());
		avatarAndRight.setPreferredSize(new Dimension(0, 56));

		JLabel avatar = new JLabel();
		// width = 48+4 to compensate for the border
		avatar.setPreferredSize(new Dimension(52, 48));
		avatar.setBorder(new EmptyBorder(0, 4, 0, 0));

		switch (item.getType())
		{
			case TWEET:
				try
				{
					Request request = new Request.Builder()
						.url(item.getAvatar())
						.build();

					RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
					{
						@Override
						public void onFailure(Call call, IOException e)
						{
							log.warn(null, e);
						}

						@Override
						public void onResponse(Call call, Response response) throws IOException
						{
							try (ResponseBody responseBody = response.body())
							{
								if (!response.isSuccessful())
								{
									log.warn("Failed to download image " + item.getAvatar());
									return;
								}

								BufferedImage icon;
								synchronized (ImageIO.class)
								{
									icon = ImageIO.read(responseBody.byteStream());
								}
								avatar.setIcon(new ImageIcon(icon));
							}
						}
					});
				}
				catch (IllegalArgumentException | NullPointerException e)
				{
					log.warn(null, e);
				}
				avatarAndRight.setBackground(TWEET_BACKGROUND);
				break;
			case OSRS_NEWS:
				if (OSRS_ICON != null)
				{
<<<<<<< HEAD
					avatar.setIcon(OSRS_ICON);
=======
					avatar.setIcon(new ImageIcon(OSRS_ICON));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				}
				avatarAndRight.setBackground(OSRS_NEWS_BACKGROUND);
				break;
			default:
				if (RUNELITE_ICON != null)
				{
<<<<<<< HEAD
					avatar.setIcon(RUNELITE_ICON);
=======
					avatar.setIcon(new ImageIcon(RUNELITE_ICON));
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				}
				avatarAndRight.setBackground(BLOG_POST_BACKGROUND);
				break;
		}

		JPanel upAndContent = new JPanel();
		upAndContent.setLayout(new BoxLayout(upAndContent, BoxLayout.Y_AXIS));
		upAndContent.setBorder(new EmptyBorder(4, 8, 4, 4));
		upAndContent.setBackground(null);

		JPanel titleAndTime = new JPanel();
		titleAndTime.setLayout(new BorderLayout());
		titleAndTime.setBackground(null);

		Color darkerForeground = UIManager.getColor("Label.foreground").darker();

		JLabel titleLabel = new JLabel(item.getTitle());
		titleLabel.setFont(FontManager.getRunescapeSmallFont());
		titleLabel.setBackground(null);
		titleLabel.setForeground(darkerForeground);
		titleLabel.setPreferredSize(new Dimension(CONTENT_WIDTH - TIME_WIDTH, 0));

		Duration duration = Duration.between(Instant.ofEpochMilli(item.getTimestamp()), Instant.now());
		JLabel timeLabel = new JLabel(durationToString(duration));
		timeLabel.setFont(FontManager.getRunescapeSmallFont());
		timeLabel.setForeground(darkerForeground);

		titleAndTime.add(titleLabel, BorderLayout.WEST);
		titleAndTime.add(timeLabel, BorderLayout.EAST);

		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(null);

		JLabel contentLabel = new JLabel(lineBreakText(item.getContent(), FontManager.getRunescapeSmallFont()));
		contentLabel.setBorder(new EmptyBorder(2, 0, 0, 0));
		contentLabel.setFont(FontManager.getRunescapeSmallFont());
		contentLabel.setForeground(darkerForeground);

		content.add(contentLabel, BorderLayout.CENTER);

		upAndContent.add(titleAndTime);
		upAndContent.add(content);
		upAndContent.add(new Box.Filler(new Dimension(0, 0),
			new Dimension(0, Short.MAX_VALUE),
			new Dimension(0, Short.MAX_VALUE)));

		avatarAndRight.add(avatar, BorderLayout.WEST);
		avatarAndRight.add(upAndContent, BorderLayout.CENTER);

		Color backgroundColor = avatarAndRight.getBackground();
		Color hoverColor = backgroundColor.brighter().brighter();
		Color pressedColor = hoverColor.brighter();

		avatarAndRight.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				avatarAndRight.setBackground(hoverColor);
<<<<<<< HEAD
				avatarAndRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				avatarAndRight.setBackground(backgroundColor);
<<<<<<< HEAD
				avatarAndRight.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				avatarAndRight.setBackground(pressedColor);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				avatarAndRight.setBackground(hoverColor);
				LinkBrowser.browse(item.getUrl());
			}
		});

<<<<<<< HEAD
		feedContainer.add(avatarAndRight);
=======
		add(avatarAndRight);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	private String durationToString(Duration duration)
	{
		if (duration.getSeconds() >= 60 * 60 * 24)
		{
			return (int) (duration.getSeconds() / (60 * 60 * 24)) + "d";
		}
		else if (duration.getSeconds() >= 60 * 60)
		{
			return (int) (duration.getSeconds() / (60 * 60)) + "h";
		}
		return (int) (duration.getSeconds() / 60) + "m";
	}

	private String lineBreakText(String text, Font font)
	{
		StringBuilder newText = new StringBuilder("<html>");

		FontRenderContext fontRenderContext = new FontRenderContext(font.getTransform(),
			true, true);

		int lines = 0;
		int pos = 0;
		String[] words = text.split(" ");
		String line = "";

		while (lines < MAX_CONTENT_LINES && pos < words.length)
		{
			String newLine = pos > 0 ? line + " " + words[pos] : words[pos];
			double width = font.getStringBounds(newLine, fontRenderContext).getWidth();

			if (width >= CONTENT_WIDTH)
			{
				newText.append(line);
				newText.append("<br>");
				line = "";
				lines++;
			}
			else
			{
				line = newLine;
				pos++;
			}
		}

		newText.append(line);
		newText.append("</html>");

		return newText.toString();
	}
}
