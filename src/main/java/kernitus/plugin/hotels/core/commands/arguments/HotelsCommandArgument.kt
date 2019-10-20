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

package kernitus.plugin.hotels.core.commands.arguments

import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentOptionality.TRUE
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentStatus.*

/**
 * Represents an argument to a subcommand of the /hotels command
 */
class HotelsCommandArgument(val optionality: HotelsCommandArgumentOptionality,
                            /**
                             * Label suggested if the command syntax is entered wrongly
                             */
                            val suggestion: String) {

    /**
     * The input the user entered for this argument
     */
    var value: String? = null

    /**
     * Get the status, whether an input was given and the argument is optional
     * @return The status, depending on the input and optionality
     */
    val status: HotelsCommandArgumentStatus
        get() = if (hasInput())
            FULL
        else if (optionality == TRUE)
            IGNORE
        else
            EMPTY

    private fun hasInput(): Boolean {
        return value != null && !value!!.isEmpty()
    }
}
