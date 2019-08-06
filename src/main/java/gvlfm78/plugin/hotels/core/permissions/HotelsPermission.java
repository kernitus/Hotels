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
 */

package kernitus.plugin.hotels.core.permissions;

import com.sk89q.worldguard.LocalPlayer;

import java.util.Optional;

/**
 * Represents a checkable Hotels permission
 */
public class HotelsPermission {

    private String permission;

    public HotelsPermission(String permission){
        this.permission = permission;
    }

    public boolean checkPermission(Optional<LocalPlayer> playerOptional){
        return !playerOptional.isPresent() || playerOptional.get().hasPermission(permission);
    }

    //TODO must include ways to check that player is owner of hotel and thus can run certain commands etc.
}
