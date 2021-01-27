/*
 * Hotels Bukkit Plugin
 * Copyright (C) 2020 kernitus <kernitus@protonmail.com>
 * Full licence text can be found in LICENCE file
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package kernitus.plugin.hotels.core.database

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object HotelsQuery {

    private lateinit var entityManagerFactory : EntityManagerFactory

    fun initialise() {
        entityManagerFactory = Persistence.createEntityManagerFactory("HotelsPU")
    }

    fun getEntityManager(): EntityManager = entityManagerFactory.createEntityManager()

    fun closeEntityManagerFactory() = entityManagerFactory.close()

    fun <T> getAll(clazz: Class<T>): List<T> {
        val className = clazz.simpleName
        val queryString = "SELECT a FROM $className a"
        return runSelectQuery(queryString, clazz)
    }

    fun <T> runSelectQuery(typedQuery: String, clazz: Class<T>): List<T> {
        val entityManager = getEntityManager()
        val resultList = entityManager.createQuery(typedQuery, clazz).resultList
        entityManager.close()
        return resultList
    }
}
