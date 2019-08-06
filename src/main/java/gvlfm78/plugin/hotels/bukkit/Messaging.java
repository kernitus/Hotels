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

package kernitus.plugin.hotels.bukkit;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import org.bukkit.Bukkit;

import java.util.Optional;

public class Messaging {

    /**
     * Send a message to a player, or console if null
     * @param message Message to send
     * @param player Player the message should be sent to
     */
    public static void send(String message, Optional<LocalPlayer> player) {
        if(player.isPresent())
            BukkitAdapter.adapt(player.get()).sendMessage(message);
        else Bukkit.getLogger().info(message);
    }

    /**
     * Sends a debug message to a player, if debug is enabled
     * @param message Message to send
     * @param player Player the message should be sent to
     */
    public static void debug(String message, Optional<LocalPlayer> player){
        //TODO if debug enabled
        send(prependDebug(message), player);
    }

    private static String prependDebug(String message){
        return "[DEBUG] " + message;
    }
}
