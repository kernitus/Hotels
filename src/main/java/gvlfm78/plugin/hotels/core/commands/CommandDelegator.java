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

package kernitus.plugin.hotels.core.commands;

import com.google.common.collect.ImmutableSet;
import com.sk89q.worldguard.LocalPlayer;
import kernitus.plugin.hotels.bukkit.Messaging;
import kernitus.plugin.hotels.core.commands.subcommands.ListAllHotelsCommand;
import kernitus.plugin.hotels.core.commands.subcommands.ListHotelsInWorldCommand;
import kernitus.plugin.hotels.core.exceptions.BruhMoment;
import kernitus.plugin.hotels.core.exceptions.HotelsException;
import kernitus.plugin.hotels.core.exceptions.NoPermissionException;
import kernitus.plugin.hotels.core.exceptions.NotEnoughArgumentsException;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Delegates hotels subcommands to correct handler class
 */
public class CommandDelegator {

    private static final HashMap<String,Set<HotelsCommand>> hotelsCommands = new HashMap<>();

    static {
        //Create ordered sets of each different command
        Set<HotelsCommand> hotelsListCommands = new LinkedHashSet<>(ImmutableSet.of(
                new ListAllHotelsCommand(), new ListHotelsInWorldCommand()
        ));

        HotelsCommand[] hcs = new HotelsCommand[5];
        hotelsListCommands.toArray(hcs);
        for (String label : hcs[0].getLabels()) {
            hotelsCommands.put(label,hotelsListCommands);
        }
    }

    public static void delegate(String subcommand, String[] args) throws HotelsException {
        delegate(subcommand,args,null);
    }

    public static void delegate(String subcommand, String[] args, LocalPlayer player) throws HotelsException {
        Messaging.send("Subcommand: " + subcommand, Optional.ofNullable(player));

        if(hotelsCommands.containsKey(subcommand)) {

            Set<HotelsCommand> hotelsCommandSet = hotelsCommands.get(subcommand);
            //Go through this set in order, and only throw no permission error if none can be run

            boolean ranSuccessfully = false;
            HotelsException lastException = new BruhMoment();

            for (HotelsCommand hotelsCommand : hotelsCommandSet) {
                try {
                    hotelsCommand.acceptAndExecute(args, Optional.ofNullable(player)); //Try to run command
                    ranSuccessfully = true; //If it didn't go to catch clause, the command ran, so we can break here
                    break;
                } catch (NotEnoughArgumentsException |  NoPermissionException e) {
                    lastException = e; //Save last thrown exception, to show user relevant error
                }
            }
            if(!ranSuccessfully) throw lastException;
        }
        else
            Messaging.send("Hotels subcommand not recognised!", Optional.ofNullable(player));
    }
}
