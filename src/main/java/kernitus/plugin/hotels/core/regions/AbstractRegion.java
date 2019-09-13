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

package kernitus.plugin.hotels.core.regions;

import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import java.util.UUID;

/**
 * Provides an abstraction for interfacing Hotel's classes with WorldGuard regions
 */
public abstract class AbstractRegion {

    private ProtectedRegion region;
    private final String REGION_PREFIX = "HOTELS_";

    protected AbstractRegion(World world, String id) {
        region = WorldGuardManager.getRegion(world,REGION_PREFIX + id);
    }

    private DefaultDomain getMembers(){
        return region.getMembers();
    }

    private DefaultDomain getOwners(){
        return region.getOwners();
    }

    public void addMember(UUID playerId){
        getMembers().addPlayer(playerId);
    }

    public void removeMember(UUID playerId){
        getMembers().removePlayer(playerId);
    }

    public void addOwner(UUID playerId){
        getOwners().addPlayer(playerId);
    }

    public void removeOwner(UUID playerId){
        getOwners().removePlayer(playerId);
    }
}
