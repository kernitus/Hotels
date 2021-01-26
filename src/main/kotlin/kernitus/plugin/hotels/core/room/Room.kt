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

import kernitus.plugin.hotels.core.homes.RoomHome
import kernitus.plugin.hotels.core.hotel.Hotel
import kernitus.plugin.hotels.core.regions.RoomRegion
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * Represents a room in a hotel
 */
@Entity
class Room (
    @Id
    val id: UUID,
    @ManyToOne(optional = false)
    val hotel: Hotel,
    @Basic(optional = false)
    var roomNumber: Int,
    @Basic(optional = false)
    var rentTime: Long, // in minutes
    @Basic(optional = false)
    var cost: Double,
    @Basic(optional = false)
    var isRoomReset: Boolean,
    @ManyToOne
    var renter: RoomRenter?,
    @OneToMany
    private val roomFriends: MutableSet<RoomFriend> = HashSet(),
    @OneToOne
    var roomHome: RoomHome?,
    @Temporal(TemporalType.TIMESTAMP)
    var expiryInstant: LocalDateTime?,
    @Transient
    var region: RoomRegion
){

    fun getRoomFriends(): Set<RoomFriend> = roomFriends

    fun addFriend(roomFriend: RoomFriend): Boolean = roomFriends.add(roomFriend)

    fun removeFriend(roomFriend: RoomFriend): Boolean = roomFriends.remove(roomFriend)

    fun clearFriends() = roomFriends.clear()
}
