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

package kernitus.plugin.hotels.core.database

import com.sk89q.worldedit.bukkit.BukkitAdapter
import kernitus.plugin.hotels.core.exceptions.WorldNonExistentException
import kernitus.plugin.hotels.core.hotel.Hotel
import kernitus.plugin.hotels.core.hotel.HotelOwner
import kernitus.plugin.hotels.core.regions.HotelRegion
import org.bukkit.Bukkit
import java.util.*

object QueryTest {

    val allHotels: List<Hotel>
        get() = HotelsQuery.runSelectQuery("SELECT h FROM Hotel h", Hotel::class.java)

    val allOwners: List<HotelOwner>
        get() = HotelsQuery.runSelectQuery("SELECT o FROM HotelOwner o", HotelOwner::class.java)

    fun addOwner() {
        val owner = HotelOwner(UUID.randomUUID())
        val entityManager = HotelsQuery.entityManager
        val transaction = entityManager.transaction

        try {
            transaction.begin()
            entityManager.persist(owner)
            transaction.commit()
        } catch (e: Exception) {
            transaction.rollback()
            e.printStackTrace()
        }

        entityManager.close()
    }

    fun addHotel() {
        val owner = HotelOwner(UUID.randomUUID())

        val hotel = Hotel(
                id = UUID.randomUUID(),
                hotelOwner = owner,
                hotelWorldId = Bukkit.getWorld("world")?.uid ?: throw WorldNonExistentException(),
                hotelName = "Test",
                hotelRegion = HotelRegion(BukkitAdapter.adapt(Bukkit.getWorld("world")) ?: throw WorldNonExistentException(), "test")
        )

        val entityManager = HotelsQuery.entityManager
        val transaction = entityManager.transaction

        try {
            transaction.begin()
            entityManager.persist(owner)
            entityManager.persist(hotel)
            transaction.commit()
        } catch (e: Exception) {
            transaction.rollback()
            e.printStackTrace()
        }

        entityManager.close()
    }
}
