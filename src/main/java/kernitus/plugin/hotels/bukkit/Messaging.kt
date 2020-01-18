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

package kernitus.plugin.hotels.bukkit

import org.bukkit.Bukkit
import org.bukkit.entity.Player

object Messaging {

    /**
     * Send a message to a player, or console if null
     * @param message Message to send
     * @param player Player the message should be sent to
     */
    fun send(message: String, player: Player?) =
        player?.sendMessage(message) ?: Bukkit.getLogger().info(message)

    /**
     * Sends a debug message to a player, if debug is enabled
     * @param message Message to send
     * @param player Player the message should be sent to
     */
    fun debug(message: String, player: Player?) {
        //TODO if debug enabled
        send(prependDebug(message), player)
    }

    private fun prependDebug(message: String): String {
        return "[DEBUG] $message"
    }
}
