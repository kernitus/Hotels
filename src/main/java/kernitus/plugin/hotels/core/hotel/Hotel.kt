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
class Hotel {

    @Id
    var id: UUID? = null
        private set

    @ManyToOne(optional = false)
    var hotelOwner: HotelOwner? = null

    @ManyToMany
    var hotelHelpers: Set<HotelHelper>? = null
        private set

    @OneToMany
    var hotelRooms: Set<Room>? = null
        private set

    @Basic(optional = false)
    var hotelWorldId: UUID? = null
        private set

    @OneToOne
    var hotelHome: HotelHome? = null

    @Basic(optional = false)
    var hotelName: String? = null

    @Transient
    var hotelRegion: HotelRegion? = null

    constructor(id: UUID, hotelOwner: HotelOwner, hotelRegion: HotelRegion, hotelHelpers: Set<HotelHelper>,
                hotelRooms: Set<Room>, hotelWorldId: UUID, hotelHome: HotelHome, hotelName: String) {
        this.id = id
        this.hotelOwner = hotelOwner
        this.hotelRegion = hotelRegion
        this.hotelHelpers = hotelHelpers
        this.hotelRooms = hotelRooms
        this.hotelWorldId = hotelWorldId
        this.hotelHome = hotelHome
        this.hotelName = hotelName
    }

    constructor(id: UUID, hotelOwner: HotelOwner, hotelRegion: HotelRegion, hotelWorldId: UUID, hotelHome: HotelHome, hotelName: String) {
        this.id = id
        this.hotelOwner = hotelOwner
        this.hotelRegion = hotelRegion
        this.hotelHelpers = HashSet()
        this.hotelRooms = HashSet()
        this.hotelWorldId = hotelWorldId
        this.hotelHome = hotelHome
        this.hotelName = hotelName
    }

    protected constructor() {}
}
