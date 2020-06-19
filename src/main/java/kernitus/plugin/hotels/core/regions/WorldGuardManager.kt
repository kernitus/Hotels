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
import com.sk89q.worldguard.WorldGuard
import com.sk89q.worldguard.protection.managers.RegionManager
import com.sk89q.worldguard.protection.managers.RemovalStrategy
import com.sk89q.worldguard.protection.regions.ProtectedRegion
import kernitus.plugin.hotels.core.exceptions.WorldGuardException

object WorldGuardManager {

    private val WGINSTANCE = WorldGuard.getInstance()
    private val REGION_CONTAINER = WGINSTANCE.platform.regionContainer

    private fun getRegionManager(world: World): RegionManager {
        return REGION_CONTAINER?.get(world) ?: throw WorldGuardException()
    }

    fun getRegion(world: World, id: String): ProtectedRegion {
        return getRegionManager(world).getRegion(id) ?: throw WorldGuardException()
    }

    fun addRegion(world: World, region: ProtectedRegion) {
        getRegionManager(world).addRegion(region)
    }

    fun removeRegion(world: World, id: String) {
        getRegionManager(world).removeRegion(id, RemovalStrategy.UNSET_PARENT_IN_CHILDREN)
    }
}
