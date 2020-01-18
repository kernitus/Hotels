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

import kernitus.plugin.hotels.bukkit.Messaging
import kernitus.plugin.hotels.core.exceptions.BruhMoment
import kernitus.plugin.hotels.core.exceptions.HotelsException
import kernitus.plugin.hotels.core.exceptions.NoPermissionException
import kernitus.plugin.hotels.core.exceptions.NotEnoughArgumentsException
import org.bukkit.entity.Player
import java.util.*

/**
 * Delegates hotels subcommands to correct handler class
 */
object CommandDelegator {

    private val hotelsCommands = HashMap<String, Set<HotelsCommand>>()

    /*init {
        //Create ordered sets of each different command
        val hotelsListCommands = LinkedHashSet(ImmutableSet.of(ListAllHotelsCommand(), ListHotelsInWorldCommand()))
    }*/

    fun delegate(subcommand: String, args: Array<String>, player: Player? = null) {
        Messaging.send("Subcommand: $subcommand", player)

        if (hotelsCommands.containsKey(subcommand)) {

            val hotelsCommandSet = hotelsCommands[subcommand]
            //Go through this set in order, and only throw no permission error if none can be run

            var ranSuccessfully = false
            var lastException: HotelsException = BruhMoment()

            if(hotelsCommandSet == null) throw lastException

            for (hotelsCommand in hotelsCommandSet) {
                try {
                    hotelsCommand.acceptAndExecute(args, player) //Try to run command
                    ranSuccessfully = true //If it didn't go to catch clause, the command ran, so we can break here
                    break
                } catch (e: NotEnoughArgumentsException) {
                    lastException = e //Save last thrown exception, to show user relevant error
                } catch (e: NoPermissionException) {
                    lastException = e
                }

            }
            if (!ranSuccessfully) throw lastException
        } else
            Messaging.send("Hotels subcommand not recognised!", player)
    }
}
