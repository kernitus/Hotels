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

import static kernitus.plugin.hotels.core.commands.HotelsCommandArgumentStatus.*;

/**
 * Represents an argument to a subcommand of the /hotels command
 */
public class HotelsCommandArgument {

    private final boolean optional;
    /**
     * Label suggested if the command syntax is entered wrongly
     */
    private final String suggestion;

    /**
     * The input the user entered for this argument
     */
    private String input;


    public HotelsCommandArgument(boolean optional, String suggestion) {
        this.optional = optional;
        this.suggestion = suggestion;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Get the status, whether an input was given and the argument is optional
     * @return The status, depending on the input and optionality
     */
    public HotelsCommandArgumentStatus getStatus(){
        if(hasInput()) return FULL;
        else if(optional) return IGNORE;
        else return EMPTY;
    }

    private boolean hasInput(){
        return input != null && !input.isEmpty();
    }
}
