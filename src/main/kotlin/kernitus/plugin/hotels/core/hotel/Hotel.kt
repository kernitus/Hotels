/*
 * Hotels Bukkit Plugin
 * Copyright (C) 2020 kernitus <kernitus@protonmail.com>
 * Full licence text can be found in LICENCE file
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package kernitus.plugin.hotels.core.hotel

import kernitus.plugin.hotels.core.homes.HotelHome
import kernitus.plugin.hotels.core.regions.HotelRegion
import kernitus.plugin.hotels.core.room.Room
import java.util.*
import javax.persistence.*

/**
 * Represents a Hotel object
 */
@Entity
class Hotel (
    @ManyToOne(optional = false)
    var hotelOwner: HotelOwner,

    @Basic(optional = false)
    var hotelWorldId: String,

    @Basic(optional = false)
    var hotelName: String
){
    @Id @GeneratedValue
    lateinit var id: UUID

    @Transient
    lateinit var hotelRegion: HotelRegion

    @ManyToMany
    val hotelHelpers: MutableSet<HotelHelper> = HashSet()

    @OneToMany
    val hotelRooms: MutableSet<Room> = HashSet()

    @OneToOne
    var hotelHome: HotelHome? = null
}
