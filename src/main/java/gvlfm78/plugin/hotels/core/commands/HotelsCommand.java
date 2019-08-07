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

import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgument;
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentOptionality;
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentStatus;
import kernitus.plugin.hotels.core.exceptions.HotelsException;
import kernitus.plugin.hotels.core.exceptions.NoPermissionException;
import kernitus.plugin.hotels.core.exceptions.NotEnoughArgumentsException;
import kernitus.plugin.hotels.core.permissions.HotelsPermission;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

/**
 * A subcommand of the /hotels command
 */
public abstract class HotelsCommand {

    /**
     * Labels and aliases for the subcommand
     */
    private final String[] labels;
    private final Set<HotelsCommandArgument> arguments;
    private final HotelsPermission permission;

    public HotelsCommand(String[] labels, Set<HotelsCommandArgument> arguments, HotelsPermission permission) {
        this.labels = labels;
        this.arguments = arguments;
        this.permission = permission;
    }

    /**
     * Check if the player has permission to execute the command
     * @param playerOptional Player executing the command
     * @return Whether the player can execute this command
     */
    private boolean hasPermission(Optional<Player> playerOptional){
        return permission.checkPermission(playerOptional);
    }

    /**
     * Checks whether the argument requirements are met
     * @return Whether the command can be executed
     */
    private boolean hasRequiredArguments(){
        return arguments.stream().anyMatch(argument -> argument.getStatus() == HotelsCommandArgumentStatus.EMPTY);
    }

    /**
     * Accepts subcommand arguments and sets them accordingly
     * @param args The arguments for the subcommand, excluding the subcommand label itself
     * @param playerOptional The player who sent the command, for inferring of optional arguments
     */
    public void acceptArguments(String[] args, Optional<Player> playerOptional) throws NotEnoughArgumentsException {
        Iterator<HotelsCommandArgument> i = arguments.iterator();
        int j = 0;

        while(j < args.length && i.hasNext()){
            HotelsCommandArgument argument = i.next();
            if(args[j] != null) argument.setValue(args[j]);
            else { //Argument must be inferred from player
                Player player = playerOptional.orElseThrow(NotEnoughArgumentsException::new);

                if (argument.getOptionality() == HotelsCommandArgumentOptionality.PLAYER_NAME)
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
     * @param playerOptional The player who sent the command, for optional arguments inferring
     */
    public void acceptAndExecute(String[] args, Optional<Player> playerOptional) throws HotelsException {
        acceptArguments(args, playerOptional);
        if(hasPermission(playerOptional)) execute(playerOptional);
        else throw new NoPermissionException();
    }

    /**
     * Execute the subcommand
     */
    public abstract void execute(Optional<Player> playerOptional) throws HotelsException;

    public String[] getLabels() {
        return labels;
    }

    protected HotelsCommandArgument getArgument(int index){
        return (HotelsCommandArgument) arguments.toArray()[index];
    }
}
