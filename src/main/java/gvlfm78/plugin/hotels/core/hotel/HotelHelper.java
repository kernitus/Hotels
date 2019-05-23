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

package kernitus.plugin.hotels.core.hotel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a hotel helper, who can build in a hotel region but cannot administer it
 */
@Entity
public class HotelHelper {

    @Id
    private UUID playerId;
    @ManyToMany
    private Set<Hotel> hotels;

    public HotelHelper(UUID playerId, Set<Hotel> hotels) {
        this.playerId = playerId;
        this.hotels = hotels;
    }

    protected HotelHelper(){}

    public UUID getPlayerId() {
        return playerId;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public boolean add(Hotel hotel) {
        return hotels.add(hotel);
    }

    public boolean remove(Hotel hotel) {
        return hotels.remove(hotel);
    }
}
