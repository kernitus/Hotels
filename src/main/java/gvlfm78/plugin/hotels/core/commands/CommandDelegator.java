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

import com.google.common.collect.ImmutableSet;
import com.sk89q.worldguard.LocalPlayer;
import kernitus.plugin.hotels.core.adapters.Adapters;
import kernitus.plugin.hotels.core.commands.subcommands.HotelsListCommand;
import kernitus.plugin.hotels.core.exceptions.NoPermissionException;
import kernitus.plugin.hotels.core.exceptions.NotEnoughArgumentsException;

import java.util.HashMap;
import java.util.Set;

/**
 * Delegates hotels subcommands to correct handler class
 */
public class CommandDelegator {

    private static final HashMap<String,HotelsCommand> hotelsCommands = new HashMap<>();

    static {
        //Create a set of all Hotels Subcommands
        Set<HotelsCommand> commands = ImmutableSet.of(
                new HotelsListCommand()
        );

        //For each subcommand, add the single instance of the subcommand for each label alias to the HashMap
        commands.forEach(command -> {
            for (String label : command.getLabels())
                hotelsCommands.put(label,command);
        });
    }

    public static void delegate(String subcommand, String[] args) throws NotEnoughArgumentsException, NoPermissionException {
        delegate(subcommand,args,null);
    }

    public static void delegate(String subcommand, String[] args, LocalPlayer player) throws NotEnoughArgumentsException, NoPermissionException {
        Adapters.messaging.print("Subcommand: " + subcommand);

        if(hotelsCommands.containsKey(subcommand))
            hotelsCommands.get(subcommand).acceptAndExecute(args, player);
        else
            Adapters.messaging.print("Hotels subcommand not recognised!");
    }
}
