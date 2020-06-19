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
 */

package kernitus.plugin.hotels.core.commands.subcommands

import com.google.common.collect.ImmutableSet
import kernitus.plugin.hotels.bukkit.Messaging
import kernitus.plugin.hotels.bukkit.Utilities
import kernitus.plugin.hotels.core.commands.HotelsCommand
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgument
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentOptionality.WORLD_NAME
import kernitus.plugin.hotels.core.database.HotelsQuery
import kernitus.plugin.hotels.core.exceptions.WorldNonExistentException
import kernitus.plugin.hotels.core.hotel.Hotel
import kernitus.plugin.hotels.core.permissions.HotelsPermission
import org.bukkit.entity.Player
import java.util.*

/**
 * Lists the hotels in all/given world(s)
 */
class ListHotelsInWorldCommand : HotelsCommand(arrayOf("hotellist", "hlist", "list"),
        LinkedHashSet(ImmutableSet.of(HotelsCommandArgument(WORLD_NAME, "world"))),
        HotelsPermission("hotels.hotellist.world")) {

    override fun execute(player: Player?) {
        val worldId = Utilities.worldNameToId(getArgument(0).value ?: throw WorldNonExistentException())

        val resultList = HotelsQuery.runSelectQuery("SELECT h FROM Hotel h WHERE hotelWorldId='"
                + worldId + "'", Hotel::class.java)

        if (resultList.isEmpty())
            Messaging.send("No hotels found in this world!", player)
        else
            resultList.forEach { hotel -> Messaging.send("Hotel: " + hotel.hotelName, player) }
    }
}
