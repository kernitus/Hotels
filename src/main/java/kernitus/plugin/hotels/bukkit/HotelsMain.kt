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

package kernitus.plugin.hotels.bukkit

import kernitus.plugin.hotels.core.database.HotelsQuery
import org.bukkit.plugin.java.JavaPlugin

class HotelsMain : JavaPlugin() {

    override fun onEnable() {
        logger.info("Hotels v" + description.version + " has been enabled")

        //For JPA classloader to work correctly
        Thread.currentThread().contextClassLoader = classLoader

        getCommand("hotels")?.setExecutor(CommandListener())
    }

    override fun onDisable() {
        HotelsQuery.closeEntityManager()
        logger.info("Hotels v" + description.version + " has been disabled")
    }
}
