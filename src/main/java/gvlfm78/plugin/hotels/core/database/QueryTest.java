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

package kernitus.plugin.hotels.core.database;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import kernitus.plugin.hotels.core.homes.HotelHome;
import kernitus.plugin.hotels.core.hotel.Hotel;
import kernitus.plugin.hotels.core.hotel.HotelOwner;
import kernitus.plugin.hotels.core.regions.HotelRegion;
import org.bukkit.Bukkit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class QueryTest {

    public static List<Hotel> getAllHotels(){
        TypedQuery<Hotel> findAllHotels = Query.getEntityManager().createQuery("SELECT h FROM Hotel h", Hotel.class);
        return findAllHotels.getResultList();
    }

    public static List<HotelOwner> getAllOwners(){
        TypedQuery<HotelOwner> query = Query.getEntityManager().createQuery("SELECT o FROM HotelOwner o", HotelOwner.class);
        return query.getResultList();
    }

    public static void addOwner(){
        HotelOwner owner = new HotelOwner(UUID.randomUUID());
        EntityManager entityManager = Query.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(owner);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

        entityManager.close();
    }

    public static void addHotel(){
        HotelOwner owner = new HotelOwner(UUID.randomUUID());
        Hotel hotel = new Hotel(UUID.randomUUID(),
                owner,
                new HotelRegion(BukkitAdapter.adapt(Bukkit.getWorld("world")),"boh"),
                Bukkit.getWorld("world").getUID(),
                new HotelHome(),
                "test"
                );

        EntityManager entityManager = Query.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(owner);
            entityManager.persist(hotel);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

        entityManager.close();
    }
}
