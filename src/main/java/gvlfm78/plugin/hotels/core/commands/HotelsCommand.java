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
import kernitus.plugin.hotels.core.exceptions.NotEnoughArgumentsException;

import java.util.Iterator;
import java.util.Set;

/**
 * A subcommand of the /hotels command
 */
public abstract class HotelsCommand {

    /**
     * Labels and aliases for the subcommand
     */
    private String[] labels;
    //TODO permission
    private Set<HotelsCommandArgument> arguments;

    public HotelsCommand(String[] labels, Set<HotelsCommandArgument> arguments) {
        this.labels = labels;
        this.arguments = arguments;
    }

    private boolean canExecute(){
        return arguments.stream().anyMatch(argument -> argument.getStatus() == HotelsCommandArgumentStatus.EMPTY);
    }

    /**
     * Accepts subcommand arguments and sets them accordingly
     * @param args The arguments for the subcommand, excluding the subcommand label itself
     * @param player The player who sent the command, for optional arguments inferring
     */
    public void acceptArguments(String[] args, LocalPlayer player) throws NotEnoughArgumentsException {
        Iterator<HotelsCommandArgument> i = arguments.iterator();
        int j = 0;

        while(j < args.length && i.hasNext()){
            HotelsCommandArgument argument = i.next();
            if(args[j] != null) argument.setValue(args[j]);

            else { //Argument must be inferred from player
                if (player == null) throw new NotEnoughArgumentsException();
            else if (argument.getOptionality() == HotelsCommandArgumentOptionality.PLAYER_NAME)
                    argument.setValue(player.getName());
            else if (argument.getOptionality() == HotelsCommandArgumentOptionality.WORLD_NAME)
                    argument.setValue(player.getWorld().getName());
            else throw new NotEnoughArgumentsException();
            }
        }
    }

    /**
     * Accepts subcommand arguments and executes the command
     * @param args The arguments for the subcommand, excluding the subcommand label itself
     */
    public void acceptAndExecute(String[] args) throws NotEnoughArgumentsException {
        acceptArguments(args, null);
        execute();
    }

    /**
     * Accepts subcommand arguments and executes the command
     * @param args The arguments for the subcommand, excluding the subcommand label itself
     * @param player The player who sent the command, for optional arguments inferring
     */
    public void acceptAndExecute(String[] args, LocalPlayer player) throws NotEnoughArgumentsException {
        acceptArguments(args, player);
        execute();
    }

    /**
     * Execute the subcommand
     */
    public abstract void execute();
}
