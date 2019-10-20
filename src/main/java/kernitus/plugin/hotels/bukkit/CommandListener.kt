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

import kernitus.plugin.hotels.core.commands.CommandDelegator
import kernitus.plugin.hotels.core.exceptions.HotelsException
import kernitus.plugin.hotels.core.exceptions.NoArgumentsException
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandListener : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        try {
            if (args.isEmpty()) throw NoArgumentsException()

            if (sender is Player) {
                CommandDelegator.delegate(args[0],
                        args.copyOfRange(1, args.size),
                        sender as Player)
            } else {
                CommandDelegator.delegate(args[0], args.copyOfRange(1, args.size))
            }
        } catch (he: HotelsException) {
            he.printStackTrace()
        }

        return true
    }
}
