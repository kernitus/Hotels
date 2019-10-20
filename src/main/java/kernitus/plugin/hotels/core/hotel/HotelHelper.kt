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

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

/**
 * Represents a hotel helper, who can build in a hotel region but cannot administer it
 */
@Entity
class HotelHelper {

    @Id
    val playerId: UUID
    @ManyToMany
    private val hotels: MutableSet<Hotel>

    constructor(playerId: UUID, hotels: MutableSet<Hotel>) {
        this.playerId = playerId
        this.hotels = hotels
    }

    protected constructor() {}

    fun getHotels(): Set<Hotel> {
        return hotels
    }

    fun add(hotel: Hotel): Boolean {
        return hotels.add(hotel)
    }

    fun remove(hotel: Hotel): Boolean {
        return hotels.remove(hotel)
    }
}
