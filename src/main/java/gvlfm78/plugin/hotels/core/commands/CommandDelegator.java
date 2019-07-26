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

package kernitus.plugin.hotels.core.commands;

import com.sk89q.worldguard.LocalPlayer;
import kernitus.plugin.hotels.core.adapters.Adapters;
import kernitus.plugin.hotels.core.exceptions.NotEnoughArgumentsException;

/**
 * Delegates hotels subcommands to correct handler class
 */
public class CommandDelegator {

    public static void delegate(String subcommand, String[] args) throws NotEnoughArgumentsException {
        delegate(subcommand,args,null);
    }

    public static void delegate(String subcommand, String[] args, LocalPlayer player) throws NotEnoughArgumentsException {
        switch (subcommand) {
            case "list": new HotelsListCommand().acceptAndExecute(args, player); break;
            default:
                Adapters.messaging.print("Hotels subcommand not recognised!");
        }
    }
}
