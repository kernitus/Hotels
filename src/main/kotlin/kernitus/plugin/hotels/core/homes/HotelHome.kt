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

package kernitus.plugin.hotels.core.homes

import kernitus.plugin.hotels.core.hotel.Hotel
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class HotelHome(@OneToOne(optional = false) val hotel: Hotel,
                     x: Int, y: Int, z: Int, pitch: Float, yaw: Float) :
        AbstractHome(x,y,z,pitch,yaw) {
    @Id
    private val hotelId = hotel.id
}
