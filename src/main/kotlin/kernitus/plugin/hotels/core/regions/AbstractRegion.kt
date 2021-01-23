/*
 *     Hotels Bukkit Plugin
 *     Copyright (C) 2019 kernitus <kernitus@protonmail.com>
 *     Full licence text can be found in LICENCE file
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package kernitus.plugin.hotels.core.regions

import com.sk89q.worldedit.world.World
import com.sk89q.worldguard.domains.DefaultDomain
import com.sk89q.worldguard.protection.regions.ProtectedRegion
import kernitus.plugin.hotels.core.regions.RegionManager.REGION_PREFIX
import java.util.*

/**
 * Provides an abstraction for interfacing Hotel's classes with WorldGuard regions
 */
abstract class AbstractRegion (val world: World, val id: String, val region: ProtectedRegion){

    /**
     * For already existing regions
     * @param id The UUID of the object representing the region, i.e. a Hotel UUID
     */
    constructor(world: World, id: String) : this(world, id, RegionManager.getRegion(world, "$REGION_PREFIX$id"))

    private val members: DefaultDomain
        get() = region.members

    private val owners: DefaultDomain
        get() = region.owners

    fun addMember(playerId: UUID) = members.addPlayer(playerId)

    fun removeMember(playerId: UUID) = members.removePlayer(playerId)

    fun addOwner(playerId: UUID) = owners.addPlayer(playerId)

    fun removeOwner(playerId: UUID) = owners.removePlayer(playerId)
}
