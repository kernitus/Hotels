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

package kernitus.plugin.hotels.core.room

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

/**
 * Represents the renter of a room in a hotel
 */
@Entity
class RoomRenter (
    @Id
    val playerId: UUID,
    @OneToMany
    private val rooms: MutableSet<Room>
){

    fun getRooms(): Set<Room> = rooms

    fun add(room: Room): Boolean = rooms.add(room)

    fun remove(room: Room): Boolean = rooms.remove(room)
}
