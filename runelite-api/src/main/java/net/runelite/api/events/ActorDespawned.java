/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.api.events;

import net.runelite.api.Actor;

<<<<<<< HEAD
/**
 * Represents the base event where an {@link Actor} has despawned.
 * <p>
 * To hook into a more focused actor type, see the {@link PlayerDespawned}
 * or {@link NpcDespawned} events.
 * <p>
 * Examples of when this event may trigger include:
 * <ul>
 *     <li>An actor moving out of render distance</li>
 *     <li>An actor despawning after death</li>
 *     <li>Moving out of or away from a region with Actor entities in it</li>
 * </ul>
 * <p>
 * During a world change, the event is only called for Players,
 * ie. {@link PlayerDespawned} will trigger but {@link NpcDespawned}
 * will not.
 * <p>
 * The client logging out does not trigger this event.
 */
public interface ActorDespawned
{
	/**
	 * Gets the despawned player or NPC.
	 *
	 * @return despawned entity
	 */
=======
public interface ActorDespawned
{
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
	Actor getActor();
}
