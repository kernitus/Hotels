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

package kernitus.plugin.hotels.core.room;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

/**
 * Represents the renter of a room in a hotel
 */
@Entity
public class RoomRenter {

    @Id
    private UUID playerId;
    @OneToMany
    private Set<Room> rooms;

    public RoomRenter(UUID playerId, Set<Room> rooms) {
        this.playerId = playerId;
        this.rooms = rooms;
    }

    protected RoomRenter() {}

    public UUID getPlayerId() {
        return playerId;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public boolean add(Room room) {
        return rooms.add(room);
    }

    public boolean remove(Room room) {
        return rooms.remove(room);
    }
}