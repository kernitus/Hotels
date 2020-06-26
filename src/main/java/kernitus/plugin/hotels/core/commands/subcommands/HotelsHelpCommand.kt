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

import kernitus.plugin.hotels.bukkit.Messaging
import kernitus.plugin.hotels.core.commands.CommandDelegator
import kernitus.plugin.hotels.core.commands.HotelsCommand
import kernitus.plugin.hotels.core.permissions.HotelsPermission
import org.bukkit.entity.Player

class HotelsHelpCommand : HotelsCommand(arrayOf("help", ""),
        emptySet(), HotelsPermission("hotels.help")
) {

    override fun execute(player: Player?) {
        CommandDelegator.getPrimaryCommandLabels().forEach { Messaging.send(it, player)}
    }
}