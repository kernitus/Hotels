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

import com.sk89q.worldedit.bukkit.WorldEditPlugin
import com.sk89q.worldedit.regions.CuboidRegion
import com.sk89q.worldedit.regions.Polygonal2DRegion
import com.sk89q.worldedit.regions.Region
import com.sk89q.worldedit.world.World
import com.sk89q.worldguard.WorldGuard
import com.sk89q.worldguard.protection.managers.RegionManager
import com.sk89q.worldguard.protection.managers.RemovalStrategy
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion
import com.sk89q.worldguard.protection.regions.ProtectedPolygonalRegion
import com.sk89q.worldguard.protection.regions.ProtectedRegion
import kernitus.plugin.hotels.core.exceptions.InvalidRegionException
import kernitus.plugin.hotels.core.exceptions.WorldGuardException
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object RegionManager {

    const val REGION_PREFIX = "HOTELS_"

    private val WGINSTANCE = WorldGuard.getInstance()
    private val REGION_CONTAINER = WGINSTANCE.platform.regionContainer
    private val worldEditPlugin = Bukkit.getServer().pluginManager.getPlugin("WorldEdit") as WorldEditPlugin

    private fun getRegionManager(world: World): RegionManager = REGION_CONTAINER?.get(world) ?: throw WorldGuardException()

    fun getRegion(world: World, id: String): ProtectedRegion = getRegionManager(world).getRegion(id) ?: throw InvalidRegionException()
    fun addRegion(world: World, region: ProtectedRegion) = getRegionManager(world).addRegion(region)
    fun removeRegion(world: World, id: String) = getRegionManager(world).removeRegion(id, RemovalStrategy.UNSET_PARENT_IN_CHILDREN)

    /**
     * Get a Protected Region from a player's selection
     * @param id The UUID of the region's object, i.e. a Hotel UUID
     */
    fun getProtectedRegion(player: Player, id: String) = player.getSelection().toProtectedRegion(id)

    fun Region.toProtectedRegion(id: String) =
            when (this) {
            is CuboidRegion -> ProtectedCuboidRegion("$REGION_PREFIX$id", this.minimumPoint, this.maximumPoint)
            is Polygonal2DRegion -> ProtectedPolygonalRegion(id, this.points, this.minimumY, this.maximumY)
            else -> throw InvalidRegionException()
    }

    // WorldEdit
    private fun Player.getSelection(): Region = worldEditPlugin.getSession(this).clipboard.clipboard.region
}
