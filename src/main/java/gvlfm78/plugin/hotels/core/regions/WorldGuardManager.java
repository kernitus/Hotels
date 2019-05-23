/*
 *     Hotels Bukkit and Sponge Plugin
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

package kernitus.plugin.hotels.core.regions;

import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.managers.RemovalStrategy;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;

public class WorldGuardManager {

    private static WorldGuard WGINSTANCE;
    private static RegionContainer REGION_CONTAINER;

    public void initialise(){
        WGINSTANCE = WorldGuard.getInstance();
        REGION_CONTAINER = WGINSTANCE.getPlatform().getRegionContainer();
    }

    private static RegionManager getRegionManager(World world){
        return REGION_CONTAINER.get(world);
    }

    public static ProtectedRegion getRegion(World world, String id){
        return getRegionManager(world).getRegion(id);
    }

    public static void addRegion(World world, ProtectedRegion region){
        getRegionManager(world).addRegion(region);
    }

    public static void removeRegion(World world, String id){
        getRegionManager(world).removeRegion(id, RemovalStrategy.UNSET_PARENT_IN_CHILDREN);
    }
}
