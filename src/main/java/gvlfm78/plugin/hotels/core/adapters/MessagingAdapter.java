/*
 *     Hotels Bukkit and Sponge Plugin
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

package kernitus.plugin.hotels.core.adapters;

import com.sk89q.worldguard.LocalPlayer;

public interface MessagingAdapter {

    /**
     * Send a message to a player
     * @param message Message to send
     * @param player Player the message should be sent to
     */
    void send(String message, LocalPlayer player);

    /**
     * Prints a message in the console
     * @param message Message to print
     */
    void print(String message);

    /**
     * Prints a debug message in the console, if debug is enabled
     * @param message Message to print
     */
    default void debug(String message){
        //TODO if debug enabled
        print(MessagingAdapter.prependDebug(message));
    }

    /**
     * Sends a debug message to a player, if debug is enabled
     * @param message Message to send
     * @param player Player the message should be sent to
     */
    default void debug(String message, LocalPlayer player){
        //TODO if debug enabled
        send(MessagingAdapter.prependDebug(message), player);
    }

    static String prependDebug(String message){
        return "[DEBUG] " + message;
    }
}
