package net.runelite.client.plugins.feed;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

<<<<<<< HEAD
@ConfigGroup("feed")
=======
@ConfigGroup(
	keyName = "feed",
	name = "News Feed",
	description = "Displays client and game-related news"
)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
public interface FeedConfig extends Config
{
	@ConfigItem(
		keyName = "includeBlogPosts",
		name = "Include Blog Posts",
		description = "Configures whether blog posts are displayed",
		position = 0
	)
	default boolean includeBlogPosts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "includeTweets",
		name = "Include Tweets",
		description = "Configures whether tweets are displayed",
		position = 1
	)
	default boolean includeTweets()
	{
		return true;
	}

	@ConfigItem(
		keyName = "includeOsrsNews",
		name = "Include OSRS News",
		description = "Configures whether OSRS news are displayed",
		position = 2
	)
	default boolean includeOsrsNews()
	{
		return true;
	}
}
