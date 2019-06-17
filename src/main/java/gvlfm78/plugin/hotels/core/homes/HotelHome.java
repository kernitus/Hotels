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

import kernitus.plugin.hotels.core.hotel.Hotel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class HotelHome extends AbstractHome {

    @OneToOne (optional = false)
    private Hotel hotel;
    @Id
    private UUID hotelId;

    public HotelHome(Hotel hotel) {
        this.hotel = hotel;
        hotelId = hotel.getId();
    }

    public HotelHome() {}

    public Hotel getHotel() {
        return hotel;
    }
}
