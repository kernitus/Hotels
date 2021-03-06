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
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class CommandListener : CommandExecutor, TabCompleter {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        try {
            if(args.isEmpty()) CommandDelegator.delegate("", emptyArray(), sender as? Player)
            else CommandDelegator.delegate(args[0], args.copyOfRange(1, args.size), sender as? Player)
        } catch (he: HotelsException) {
            Messaging.send(he.message, sender)
            if(he.printCommandUsage && he.commandUsage != null) Messaging.send(he.commandUsage, sender)
            if(he.printStackTrace) he.printStackTrace()

            return false
        }

        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): MutableList<String> =
            when {
                args.isEmpty() -> mutableListOf()
                args.size == 1 -> CommandDelegator.getPrimaryCommandLabels()
                else -> CommandDelegator.tabComplete(args[0], args.copyOfRange(1, args.size), sender as? Player)
            }

}
