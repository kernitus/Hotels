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

    public abstract void execute();
}
