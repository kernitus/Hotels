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

package kernitus.plugin.hotels.core.room;

import kernitus.plugin.hotels.core.homes.RoomHome;
import kernitus.plugin.hotels.core.hotel.Hotel;
import kernitus.plugin.hotels.core.regions.RoomRegion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a room in a hotel
 */
@Entity
public class Room {

    @Id //TODO UUID.randomUUID
    private UUID roomId;
    @ManyToOne (optional = false)
    private Hotel hotel;
    @Basic (optional = false)
    private int roomNumber;
    @ManyToOne
    private RoomRenter renter;
    @OneToOne (optional = false)
    private RoomRegion region;
    @OneToMany
    private final Set<RoomFriend> roomFriends;
    @OneToOne
    private RoomHome roomHome;
    @Basic (optional = false)
    private Period rentTime;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime expiryInstant;
    @Basic (optional = false)
    private double cost;
    @Basic (optional = false)
    private boolean roomReset;

    public Room(UUID roomId, Hotel hotel, int roomNumber, RoomRenter renter, RoomRegion region,
                Set<RoomFriend> roomFriends, RoomHome roomHome, Period rentTime, LocalDateTime expiryInstant,
                double cost, boolean roomReset) {
        this.roomId = roomId;
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.renter = renter;
        this.region = region;
        this.roomFriends = roomFriends;
        this.roomHome = roomHome;
        this.rentTime = rentTime;
        this.expiryInstant = expiryInstant;
        this.cost = cost;
        this.roomReset = roomReset;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomRenter getRenter() {
        return renter;
    }

    public void setRenter(RoomRenter renter) {
        this.renter = renter;
    }

    public RoomRegion getRegion() {
        return region;
    }

    public void setRegion(RoomRegion region) {
        this.region = region;
    }

    public Set<RoomFriend> getRoomFriends() {
        return roomFriends;
    }

    public RoomHome getRoomHome() {
        return roomHome;
    }

    public void setRoomHome(RoomHome roomHome) {
        this.roomHome = roomHome;
    }

    public Period getRentTime() {
        return rentTime;
    }

    public void setRentTime(Period rentTime) {
        this.rentTime = rentTime;
    }

    public LocalDateTime getExpiryInstant() {
        return expiryInstant;
    }

    public void setExpiryInstant(LocalDateTime expiryInstant) {
        this.expiryInstant = expiryInstant;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isRoomReset() {
        return roomReset;
    }

    public void setRoomReset(boolean roomReset) {
        this.roomReset = roomReset;
    }

    public boolean addFriend(RoomFriend roomFriend) {
        return roomFriends.add(roomFriend);
    }

    public boolean removeFriend(RoomFriend roomFriend) {
        return roomFriends.remove(roomFriend);
    }

    public void clearFriends() {
        roomFriends.clear();
    }
}
