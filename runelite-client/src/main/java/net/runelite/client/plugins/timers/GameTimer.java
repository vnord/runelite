/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
<<<<<<< HEAD
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.timers;

import java.awt.image.BufferedImage;
<<<<<<< HEAD
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GraphicID;
import net.runelite.api.ItemID;
import net.runelite.api.SpriteID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;

@Slf4j
enum GameTimer
{
	STAMINA(ItemID.STAMINA_POTION4, GameTimerImageType.ITEM, "Stamina", 2, ChronoUnit.MINUTES),
	ANTIFIRE(ItemID.ANTIFIRE_POTION4, GameTimerImageType.ITEM, "Antifire", 6, ChronoUnit.MINUTES),
	EXANTIFIRE(ItemID.EXTENDED_ANTIFIRE4, GameTimerImageType.ITEM, "Extended antifire", 12, ChronoUnit.MINUTES),
	OVERLOAD(ItemID.OVERLOAD_4, GameTimerImageType.ITEM, "Overload", 5, ChronoUnit.MINUTES),
	CANNON(ItemID.CANNON_BARRELS, GameTimerImageType.ITEM, "Cannon", 25, ChronoUnit.MINUTES),
	MAGICIMBUE(SpriteID.SPELL_MAGIC_IMBUE, GameTimerImageType.SPRITE, "Magic imbue", 12, ChronoUnit.SECONDS),
	FULLTB(SpriteID.SPELL_TELE_BLOCK, GameTimerImageType.SPRITE, "Full Teleblock", 5, ChronoUnit.MINUTES),
	HALFTB(SpriteID.SPELL_TELE_BLOCK, GameTimerImageType.SPRITE, "Half Teleblock", 150, ChronoUnit.SECONDS),
	ANTIVENOMPLUS(ItemID.ANTIVENOM4_12913, GameTimerImageType.ITEM, "Anti-venom+", 3, ChronoUnit.MINUTES),
	SUPERANTIFIRE(ItemID.SUPER_ANTIFIRE_POTION4, GameTimerImageType.ITEM, "Super antifire", 3, ChronoUnit.MINUTES),
	ANTIDOTEPLUSPLUS(ItemID.ANTIDOTE4_5952, GameTimerImageType.ITEM, "Antidote++", 12, ChronoUnit.MINUTES),
	BIND(SpriteID.SPELL_BIND, GameTimerImageType.SPRITE, "Bind", GraphicID.BIND, 5, ChronoUnit.SECONDS),
	HALFBIND(SpriteID.SPELL_BIND, GameTimerImageType.SPRITE, "Half Bind", GraphicID.BIND, 2500, ChronoUnit.MILLIS),
	SNARE(SpriteID.SPELL_SNARE, GameTimerImageType.SPRITE, "Snare", GraphicID.SNARE, 10, ChronoUnit.SECONDS),
	HALFSNARE(SpriteID.SPELL_SNARE, GameTimerImageType.SPRITE, "Half Snare", GraphicID.SNARE, 5, ChronoUnit.SECONDS),
	ENTANGLE(SpriteID.SPELL_ENTANGLE, GameTimerImageType.SPRITE, "Engangle", GraphicID.ENTANGLE, 15, ChronoUnit.SECONDS),
	HALFENTANGLE(SpriteID.SPELL_ENTANGLE, GameTimerImageType.SPRITE, "Half Entangle", GraphicID.ENTANGLE, 7500, ChronoUnit.MILLIS),
	ICERUSH(SpriteID.SPELL_ICE_RUSH, GameTimerImageType.SPRITE, "Ice rush", GraphicID.ICE_RUSH, 5, ChronoUnit.SECONDS),
	ICEBURST(SpriteID.SPELL_ICE_BURST, GameTimerImageType.SPRITE, "Ice burst", GraphicID.ICE_BURST, 10, ChronoUnit.SECONDS),
	ICEBLITZ(SpriteID.SPELL_ICE_BLITZ, GameTimerImageType.SPRITE, "Ice blitz", GraphicID.ICE_BLITZ, 15, ChronoUnit.SECONDS),
	ICEBARRAGE(SpriteID.SPELL_ICE_BARRAGE, GameTimerImageType.SPRITE, "Ice barrage", GraphicID.ICE_BARRAGE, 20, ChronoUnit.SECONDS),
	IMBUEDHEART(ItemID.IMBUED_HEART, GameTimerImageType.ITEM, "Imbued heart", GraphicID.IMBUED_HEART, 420, ChronoUnit.SECONDS),
	VENGEANCE(SpriteID.SPELL_VENGEANCE, GameTimerImageType.SPRITE, "Vengeance", GraphicID.VENGEANCE, 30, ChronoUnit.SECONDS),
	VENGEANCEOTHER(SpriteID.SPELL_VENGEANCE_OTHER, GameTimerImageType.SPRITE, "Vengeance Other", GraphicID.VENGEANCE_OTHER, 30, ChronoUnit.SECONDS),
	ANTIDOTEPLUS(ItemID.ANTIDOTE4, GameTimerImageType.ITEM, "Antidote+", 518, ChronoUnit.SECONDS),
	ANTIVENOM(ItemID.ANTIVENOM4, GameTimerImageType.ITEM, "Anti-venom", 12, ChronoUnit.MINUTES),
	EXSUPERANTIFIRE(ItemID.EXTENDED_SUPER_ANTIFIRE4, GameTimerImageType.ITEM, "Extended Super AntiFire", 6, ChronoUnit.MINUTES),
	SANFEW(ItemID.SANFEW_SERUM4, GameTimerImageType.ITEM, "Sanfew serum", 6, ChronoUnit.MINUTES),
	OVERLOAD_RAID(ItemID.OVERLOAD_4_20996, GameTimerImageType.ITEM, "Overload", 5, ChronoUnit.MINUTES),
	PRAYER_ENHANCE(ItemID.PRAYER_ENHANCE_4, GameTimerImageType.ITEM, "Prayer enhance", 275, ChronoUnit.SECONDS),
	GOD_WARS_ALTAR(SpriteID.SKILL_PRAYER, GameTimerImageType.SPRITE, "God wars altar", 10, ChronoUnit.MINUTES),
	ANTIPOISON(ItemID.ANTIPOISON4, GameTimerImageType.ITEM, "Antipoison", 90, ChronoUnit.SECONDS),
	SUPERANTIPOISON(ItemID.SUPERANTIPOISON4, GameTimerImageType.ITEM, "Superantipoison", 346, ChronoUnit.SECONDS),
	CHARGE(SpriteID.SPELL_CHARGE, GameTimerImageType.SPRITE, "Charge", 6, ChronoUnit.MINUTES),
	STAFF_OF_THE_DEAD(ItemID.STAFF_OF_THE_DEAD, GameTimerImageType.ITEM, "Staff of the Dead", 1, ChronoUnit.MINUTES),
	ABYSSAL_SIRE_STUN(ItemID.ABYSSAL_ORPHAN, GameTimerImageType.ITEM, "Abyssal Sire Stun", 30, ChronoUnit.SECONDS);

	@Getter
=======
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GraphicID;

@Slf4j
public enum GameTimer
{
	STAMINA("stamina", "Stamina", 2, ChronoUnit.MINUTES),
	ANTIFIRE("antifire", "Antifire", 6, ChronoUnit.MINUTES),
	EXANTIFIRE("exantifire", "Extended antifire", 12, ChronoUnit.MINUTES),
	OVERLOAD("overload", "Overload", 5, ChronoUnit.MINUTES),
	CANNON("cannon", "Cannon", 25, ChronoUnit.MINUTES),
	MAGICIMBUE("magicimbue", "Magic imbue", 12, ChronoUnit.SECONDS),
	FULLTB("teleblock", "Full Teleblock", 5, ChronoUnit.MINUTES),
	HALFTB("teleblock", "Half Teleblock", 150, ChronoUnit.SECONDS),
	ANTIVENOMPLUS("antivenomplus", "Anti-venom+", 3, ChronoUnit.MINUTES),
	SUPERANTIFIRE("superantifire", "Super antifire", 3, ChronoUnit.MINUTES),
	ANTIDOTEPLUSPLUS("antidoteplusplus", "Antidote++", 12, ChronoUnit.MINUTES),
	BIND("bind", "Bind", GraphicID.BIND, 5, ChronoUnit.SECONDS),
	HALFBIND("bind", "Half Bind", GraphicID.BIND, 2500, ChronoUnit.MILLIS),
	SNARE("snare", "Snare", GraphicID.SNARE, 10, ChronoUnit.SECONDS),
	HALFSNARE("snare", "Half Snare", GraphicID.SNARE, 5, ChronoUnit.SECONDS),
	ENTANGLE("entangle", "Engangle", GraphicID.ENTANGLE, 15, ChronoUnit.SECONDS),
	HALFENTANGLE("entangle", "Half Entangle", GraphicID.ENTANGLE, 7500, ChronoUnit.MILLIS),
	ICERUSH("icerush", "Ice rush", GraphicID.ICE_RUSH, 5, ChronoUnit.SECONDS),
	ICEBURST("iceburst", "Ice burst", GraphicID.ICE_BURST, 10, ChronoUnit.SECONDS),
	ICEBLITZ("iceblitz", "Ice blitz", GraphicID.ICE_BLITZ, 15, ChronoUnit.SECONDS),
	ICEBARRAGE("icebarrage", "Ice barrage", GraphicID.ICE_BARRAGE, 20, ChronoUnit.SECONDS),
	IMBUEDHEART("imbuedheart", "Imbued heart", GraphicID.IMBUED_HEART, 420, ChronoUnit.SECONDS),
	VENGEANCE("vengeance", "Vengeance", GraphicID.VENGEANCE, 30, ChronoUnit.SECONDS),
	VENGEANCEOTHER("vengeanceother", "Vengeance Other", -1, 30, ChronoUnit.SECONDS),
	ANTIDOTEPLUS("antidoteplus", "Antidote+", 518, ChronoUnit.SECONDS),
	ANTIVENOM("antivenom", "Anti-venom", 12, ChronoUnit.MINUTES),
	EXSUPERANTIFIRE("exsuperantifire", "Extended Super AntiFire", 6, ChronoUnit.MINUTES),
	SANFEW("sanfew", "Sanfew serum", 6, ChronoUnit.MINUTES),
	OVERLOAD_RAID("overloadraid", "Overload", 5, ChronoUnit.MINUTES),
	PRAYER_ENHANCE("prayerenhance", "Prayer enhance", 275, ChronoUnit.SECONDS),
	GOD_WARS_ALTAR("altar", "God wars altar", 10, ChronoUnit.MINUTES),
	ANTIPOISON("antipoison", "Antipoison", 90, ChronoUnit.SECONDS),
	SUPERANTIPOISON("superantipoison", "Superantipoison", 346, ChronoUnit.SECONDS);

	@Getter
	private final String imageResource;
	@Getter
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private final Duration duration;
	@Getter
	private final Integer graphicId;
	@Getter
	private final String description;
<<<<<<< HEAD
	private int imageId = -1;
	private GameTimerImageType imageType;

	private BufferedImage image;

	GameTimer(int imageId, GameTimerImageType idType, String description, Integer graphicId, long time, ChronoUnit unit)
	{
		this.description = description;
		this.graphicId = graphicId;
		this.duration = Duration.of(time, unit);
		this.imageId = imageId;
		this.imageType = idType;
	}

	GameTimer(int imageId, GameTimerImageType idType, String description, long time, ChronoUnit unit)
	{
		this(imageId, idType, description, null, time, unit);
	}

	BufferedImage getImage(ItemManager itemManager, SpriteManager spriteManager)
=======

	private BufferedImage image;

	GameTimer(String imageResource, String description, Integer graphicId, long time, ChronoUnit unit)
	{
		this.imageResource = imageResource;
		this.description = description;
		this.graphicId = graphicId;
		this.duration = Duration.of(time, unit);
	}

	GameTimer(String imageResource, String description, long time, ChronoUnit unit)
	{
		this(imageResource, description, null, time, unit);
	}

	public BufferedImage getImage()
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		if (image != null)
		{
			return image;
		}

<<<<<<< HEAD
		switch (imageType)
		{
			case ITEM:
				image = itemManager.getImage(imageId);
				break;
			case SPRITE:
				image = spriteManager.getSprite(imageId, 0);
				break;
=======
		try
		{
			synchronized (ImageIO.class)
			{
				image = ImageIO.read(GameTimer.class.getResourceAsStream(imageResource + ".png"));
			}
		}
		catch (IOException ex)
		{
			log.warn("unable to load image", ex);
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		}

		return image;
	}
}
