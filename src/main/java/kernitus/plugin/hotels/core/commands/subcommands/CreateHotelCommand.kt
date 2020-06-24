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

package kernitus.plugin.hotels.core.commands.subcommands

import com.google.common.collect.ImmutableSet
import kernitus.plugin.hotels.core.commands.HotelsCommand
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgument
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentOptionality
import kernitus.plugin.hotels.core.exceptions.PlayerOnlyException
import kernitus.plugin.hotels.core.permissions.HotelsPermission
import org.bukkit.entity.Player

class CreateHotelCommand : HotelsCommand(arrayOf("create", "c"),
        ImmutableSet.of(HotelsCommandArgument(HotelsCommandArgumentOptionality.FALSE, "name")),
        HotelsPermission("hotels.create")) {

    override fun execute(player: Player?) {
        if(player == null) throw PlayerOnlyException()
        val hotelName = getArgument(0).value

        player.sendMessage("Creating hotel $hotelName")

        // PRECONDITIONS:
        // player must have a region selected

        // region must not intersect already existing hotel regions
        // must not intersect regions with custom flag (no hotels)
        // they must have enough money to create hotel, (money scaling with size of region?)
    }
}