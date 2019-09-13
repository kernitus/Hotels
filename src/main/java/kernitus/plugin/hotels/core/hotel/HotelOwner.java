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

package kernitus.plugin.hotels.core.hotel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Represents the owner of a hotel
 */
@Entity
public class HotelOwner {

    @Id
    private UUID playerId;

    @OneToMany
    private Set<Hotel> hotels;

    public HotelOwner(UUID playerId, Set<Hotel> hotels) {
        this.playerId = playerId;
        this.hotels = hotels;
    }

    public HotelOwner(UUID playerId) {
        this.playerId = playerId;
        hotels = new HashSet<Hotel>();
    }

    protected HotelOwner() {}

    public UUID getPlayerId() {
        return playerId;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }
}
