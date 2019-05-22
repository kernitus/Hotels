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

package kernitus.plugin.hotels.core.homes;

import kernitus.plugin.hotels.core.room.Room;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class RoomHome extends AbstractHome {

    @OneToOne(optional = false)
    private final Room room;

    public RoomHome(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public Location getLocation(){
        return new Location(Bukkit.getWorld(room.getHotel().getHotelWorldId()), x, y, z, yaw, pitch);
    }
}
