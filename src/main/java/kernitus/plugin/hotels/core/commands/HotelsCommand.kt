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

package kernitus.plugin.hotels.core.commands

import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgument
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentOptionality
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentStatus
import kernitus.plugin.hotels.core.exceptions.HotelsException
import kernitus.plugin.hotels.core.exceptions.NoPermissionException
import kernitus.plugin.hotels.core.exceptions.NotEnoughArgumentsException
import kernitus.plugin.hotels.core.permissions.HotelsPermission
import org.bukkit.entity.Player

/**
 * A subcommand of the /hotels command
 */
abstract class HotelsCommand(
        /**
         * Labels and aliases for the subcommand
         */
        val labels: Array<String>, private val arguments: Set<HotelsCommandArgument>, private val permission: HotelsPermission) {

    /**
     * Check if the player has permission to execute the command
     * @param player Player executing the command
     * @return Whether the player can execute this command
     */
    private fun hasPermission(player: Player?): Boolean = permission.checkPermission(player)

    /**
     * Checks whether the argument requirements are met
     * @return Whether the command can be executed
     */
    private fun hasRequiredArguments(): Boolean {
        return arguments.stream().anyMatch { argument -> argument.status == HotelsCommandArgumentStatus.EMPTY }
    }

    /**
     * Accepts subcommand arguments and sets them accordingly
     * @param args The arguments for the subcommand, excluding the subcommand label itself
     * @param player The player who sent the command, for inferring of optional arguments
     */
    @Throws(NotEnoughArgumentsException::class)
    fun acceptArguments(args: Array<String>, player: Player?) {
        val i = arguments.iterator()
        val j = 0

        while (j < args.size && i.hasNext()) {
            val argument = i.next()
            if (args[j] != null)
                argument.value = args[j]
            else { //Argument must be inferred from player
                if(player == null) throw NotEnoughArgumentsException()

                when (argument.optionality) {
                    HotelsCommandArgumentOptionality.PLAYER_NAME -> argument.value = player.name
                    HotelsCommandArgumentOptionality.WORLD_NAME -> argument.value = player.world.name
                    else -> throw NotEnoughArgumentsException()
                }
            }
        }
    }

    /**
     * Accepts subcommand arguments and executes the command
     * @param args The arguments for the subcommand, excluding the subcommand label itself
     * @param player The player who sent the command, for optional arguments inferring
     */
    @Throws(HotelsException::class)
    fun acceptAndExecute(args: Array<String>, player: Player?) {
        acceptArguments(args, player)
        if (hasPermission(player))
            execute(player)
        else
            throw NoPermissionException()
    }

    /**
     * Execute the subcommand
     */
    @Throws(HotelsException::class)
    abstract fun execute(player: Player?)

    protected fun getArgument(index: Int): HotelsCommandArgument = arguments.toTypedArray()[index]
}
