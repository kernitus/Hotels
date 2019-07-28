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
 */

package kernitus.plugin.hotels.core.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class HotelsQuery {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HotelsPU");

    static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(){
        entityManagerFactory.close();
    }

    public static <T> List<T> getAll(Class<T> clazz){
        String className = clazz.getSimpleName();
        String queryString = "SELECT a FROM " + className + " a";
        return runSelectQuery(queryString,clazz);
    }

    public static <T> List<T> runSelectQuery(String typedQuery, Class<T> clazz){
        EntityManager entityManager = HotelsQuery.getEntityManager();
        List<T> resultList = entityManager.createQuery(typedQuery, clazz).getResultList();
        entityManager.close();
        return resultList;
    }
}
