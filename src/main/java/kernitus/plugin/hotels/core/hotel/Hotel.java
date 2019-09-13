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

import kernitus.plugin.hotels.core.homes.HotelHome;
import kernitus.plugin.hotels.core.regions.HotelRegion;
import kernitus.plugin.hotels.core.room.Room;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a Hotel object
 */
@Entity
public class Hotel {

    @Id
    private UUID id;

    @ManyToOne (optional = false)
    private HotelOwner hotelOwner;

    @ManyToMany
    private Set<HotelHelper> hotelHelpers;

    @OneToMany
    private Set<Room> hotelRooms;

    @Basic (optional = false)
    private UUID hotelWorldId;

    @OneToOne
    private HotelHome hotelHome;

    @Basic (optional = false)
    private String hotelName;

    @Transient
    private HotelRegion hotelRegion;

    public Hotel(UUID id, HotelOwner hotelOwner, HotelRegion hotelRegion, Set<HotelHelper> hotelHelpers,
                 Set<Room> hotelRooms, UUID hotelWorldId, HotelHome hotelHome, String hotelName) {
        this.id = id;
        this.hotelOwner = hotelOwner;
        this.hotelRegion = hotelRegion;
        this.hotelHelpers = hotelHelpers;
        this.hotelRooms = hotelRooms;
        this.hotelWorldId = hotelWorldId;
        this.hotelHome = hotelHome;
        this.hotelName = hotelName;
    }

    public Hotel(UUID id, HotelOwner hotelOwner, HotelRegion hotelRegion, UUID hotelWorldId, HotelHome hotelHome, String hotelName) {
        this.id = id;
        this.hotelOwner = hotelOwner;
        this.hotelRegion = hotelRegion;
        this.hotelHelpers = new HashSet<>();
        this.hotelRooms = new HashSet<>();
        this.hotelWorldId = hotelWorldId;
        this.hotelHome = hotelHome;
        this.hotelName = hotelName;
    }

    protected Hotel(){}

    public UUID getId() {
        return id;
    }

    public HotelOwner getHotelOwner() {
        return hotelOwner;
    }

    public void setHotelOwner(HotelOwner hotelOwner) {
        this.hotelOwner = hotelOwner;
    }

    public HotelRegion getHotelRegion() {
        return hotelRegion;
    }

    public void setHotelRegion(HotelRegion hotelRegion) {
        this.hotelRegion = hotelRegion;
    }

    public Set<HotelHelper> getHotelHelpers() {
        return hotelHelpers;
    }

    public Set<Room> getHotelRooms() {
        return hotelRooms;
    }

    public UUID getHotelWorldId() {
        return hotelWorldId;
    }

    public HotelHome getHotelHome() {
        return hotelHome;
    }

    public void setHotelHome(HotelHome hotelHome) {
        this.hotelHome = hotelHome;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
