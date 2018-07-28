/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
 * Copyright (c) 2018, Levi <me@levischuck.com>
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

<<<<<<< HEAD
import lombok.Getter;
import lombok.RequiredArgsConstructor;
=======
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import lombok.Data;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Experience;
import net.runelite.api.Skill;

<<<<<<< HEAD
@Slf4j
@RequiredArgsConstructor
class XpStateSingle
{
	private final Skill skill;

	@Getter
	private final int startXp;

	@Getter
	private int xpGained = 0;

	private long skillTime = 0;
	private int actions = 0;
	private int startLevelExp = 0;
	private int endLevelExp = 0;
=======
@Data
@Slf4j
class XpStateSingle
{
	private final Skill skill;
	private final int startXp;
	private Instant skillTimeStart = null;
	private int xpGained = 0;
	private int actions = 0;
	private int nextLevelExp = 0;
	private int startLevelExp = 0;
	private int level = 0;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	private boolean actionsHistoryInitialized = false;
	private int[] actionExps = new int[10];
	private int actionExpIndex = 0;

<<<<<<< HEAD
	private int getCurrentXp()
	{
		return startXp + xpGained;
	}

	private int getActionsHr()
	{
		return toHourly(actions);
	}

	private int toHourly(int value)
	{
		if (skillTime == 0)
		{
			return 0;
		}

		return (int) ((1.0 / (getTimeElapsedInSeconds() / 3600.0)) * value);
	}

	private long getTimeElapsedInSeconds()
	{
		if (skillTime == 0)
=======
	int getXpHr()
	{
		return toHourly(xpGained);
	}

	int getXpSec()
	{
		return getXpHr() / 3600;
	}

	int getActionsHr()
	{
		return toHourly(actions);
	}

	private int toHourly(int value)
	{
		if (skillTimeStart == null)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		{
			return 0;
		}

		// If the skill started just now, we can divide by near zero, this results in odd behavior.
		// To prevent that, pretend the skill has been active for a minute (60 seconds)
		// This will create a lower estimate for the first minute,
		// but it isn't ridiculous like saying 2 billion XP per hour.
<<<<<<< HEAD
		return Math.max(60, skillTime / 1000);
	}

	private int getXpRemaining()
	{
		return endLevelExp - getCurrentXp();
	}

	private int getActionsRemaining()
=======
		long timeElapsedInSeconds = Math.max(60, Duration.between(skillTimeStart, Instant.now()).getSeconds());
		return (int) ((1.0 / (timeElapsedInSeconds / 3600.0)) * value);
	}

	int getXpRemaining()
	{
		return nextLevelExp - (startXp + xpGained);
	}

	int getActionsRemaining()
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		if (actionsHistoryInitialized)
		{
			long xpRemaining = getXpRemaining() * actionExps.length;
<<<<<<< HEAD
			long totalActionXp = 0;

			for (int actionXp : actionExps)
			{
				totalActionXp += actionXp;
			}

			// Let's not divide by zero (or negative)
			if (totalActionXp > 0)
			{
				// Make sure to account for the very last action at the end
				long remainder = xpRemaining % totalActionXp;
				long quotient = xpRemaining / totalActionXp;
=======
			long actionExp = 0;

			for (int i = 0; i < actionExps.length; i++)
			{
				actionExp += actionExps[i];
			}

			// Let's not divide by zero (or negative)
			if (actionExp > 0)
			{
				// Make sure to account for the very last action at the end
				long remainder = xpRemaining % actionExp;
				long quotient = xpRemaining / actionExp;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
				return Math.toIntExact(quotient + (remainder > 0 ? 1 : 0));
			}
		}

		return Integer.MAX_VALUE;
	}

<<<<<<< HEAD
	private int getSkillProgress()
	{
		double xpGained = getCurrentXp() - startLevelExp;
		double xpGoal = endLevelExp - startLevelExp;
		return (int) ((xpGained / xpGoal) * 100);
	}

	private String getTimeTillLevel()
	{
		long seconds = getTimeElapsedInSeconds();

		if (seconds <= 0 || xpGained <= 0)
		{
			// Infinity symbol
			return "\u221e";
		}

		// formula is xpRemaining / xpPerSecond
		// xpPerSecond being xpGained / seconds
		// This can be simplified so division is only done once and we can work in whole numbers!
		long remainingSeconds = (getXpRemaining() * seconds) / xpGained;

		// Java 8 doesn't have good duration / period objects to represent spans of time that can be formatted
		// Rather than importing another dependency like joda time (which is practically built into java 10)
		// below will be a custom formatter that handles spans larger than 1 day

		long durationDays = remainingSeconds / (24 * 60 * 60);
		long durationHours = (remainingSeconds % (24 * 60 * 60)) / (60 * 60);
		long durationMinutes = (remainingSeconds % (60 * 60)) / 60;
		long durationSeconds = remainingSeconds % 60;

		if (durationDays > 1)
		{
			return String.format("%d days %02d:%02d:%02d", durationDays, durationHours, durationMinutes, durationSeconds);
		}
		else if (durationDays == 1)
		{
			return String.format("1 day %02d:%02d:%02d", durationHours, durationMinutes, durationSeconds);
		}
		else if (durationHours > 0)
		{
			return String.format("%02d:%02d:%02d", durationHours, durationMinutes, durationSeconds);
		}

		// Minutes and seconds will always be present
		return String.format("%02d:%02d", durationMinutes, durationSeconds);
	}


	int getXpHr()
	{
		return toHourly(xpGained);
	}

	boolean update(int currentXp, int goalStartXp, int goalEndXp)
=======
	int getSkillProgress()
	{
		int currentXp = startXp + xpGained;

		double xpGained = currentXp - startLevelExp;
		double xpGoal = nextLevelExp - startLevelExp;
		return (int) ((xpGained / xpGoal) * 100);
	}

	String getTimeTillLevel()
	{
		if (getXpSec() > 0)
		{
			return LocalTime.MIN.plusSeconds( getXpRemaining() / getXpSec() ).toString();
		}
		return "\u221e";
	}


	boolean update(int currentXp)
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	{
		if (startXp == -1)
		{
			log.warn("Attempted to update skill state " + skill + " but was not initialized with current xp");
			return false;
		}

		int originalXp = xpGained + startXp;
		int actionExp = currentXp - originalXp;

<<<<<<< HEAD
		// No experience gained
=======
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
		if (actionExp == 0)
		{
			return false;
		}

		if (actionsHistoryInitialized)
		{
			actionExps[actionExpIndex] = actionExp;
		}
		else
		{
			// So we have a decent average off the bat, lets populate all values with what we see.
			for (int i = 0; i < actionExps.length; i++)
			{
				actionExps[i] = actionExp;
			}

			actionsHistoryInitialized = true;
		}

		actionExpIndex = (actionExpIndex + 1) % actionExps.length;
<<<<<<< HEAD
		actions++;

		// Calculate experience gained
		xpGained = currentXp - startXp;

		// Determine XP goals
		if (goalStartXp <= 0 || currentXp > goalEndXp)
		{
			startLevelExp = Experience.getXpForLevel(Experience.getLevelForXp(currentXp));
		}
		else
		{
			startLevelExp = goalStartXp;
		}

		if (goalEndXp <= 0 || currentXp > goalEndXp)
		{
			int currentLevel = Experience.getLevelForXp(currentXp);
			endLevelExp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL
				? Experience.getXpForLevel(currentLevel + 1)
				: Experience.MAX_SKILL_XP;
		}
		else
		{
			endLevelExp = goalEndXp;
		}

		return true;
	}

	public void tick(long delta)
	{
		// Don't tick skills that have not gained XP or have been reset.
		if (xpGained <= 0)
		{
			return;
		}
		skillTime += delta;
=======

		actions++;
		xpGained = currentXp - startXp;
		startLevelExp = Experience.getXpForLevel(Experience.getLevelForXp(currentXp));

		int currentLevel = Experience.getLevelForXp(currentXp);

		level = currentLevel;

		nextLevelExp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;

		if (skillTimeStart == null)
		{
			skillTimeStart = Instant.now();
		}

		return true;
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	}

	XpSnapshotSingle snapshot()
	{
		return XpSnapshotSingle.builder()
<<<<<<< HEAD
			.startLevel(Experience.getLevelForXp(startLevelExp))
			.endLevel(Experience.getLevelForXp(endLevelExp))
			.xpGainedInSession(xpGained)
			.xpRemainingToGoal(getXpRemaining())
			.xpPerHour(getXpHr())
			.skillProgressToGoal(getSkillProgress())
			.actionsInSession(actions)
			.actionsRemainingToGoal(getActionsRemaining())
			.actionsPerHour(getActionsHr())
			.timeTillGoal(getTimeTillLevel())
			.startGoalXp(startLevelExp)
			.endGoalXp(endLevelExp)
			.build();
	}
}
=======
			.currentLevel(getLevel())
			.xpGainedInSession(getXpGained())
			.xpRemainingToGoal(getXpRemaining())
			.xpPerHour(getXpHr())
			.skillProgressToGoal(getSkillProgress())
			.actionsInSession(getActions())
			.actionsRemainingToGoal(getActionsRemaining())
			.actionsPerHour(getActionsHr())
			.timeTillGoal(getTimeTillLevel())
			.build();
	}
}
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
