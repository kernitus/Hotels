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
 *
 */

package kernitus.plugin.hotels.bukkit;

import kernitus.plugin.hotels.core.database.QueryTest;
import kernitus.plugin.hotels.core.hotel.Hotel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CommandHandler implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        List<Hotel> before = QueryTest.getAllHotels();
        printHotels(before);
        QueryTest.addHotel();
        List<Hotel> after = QueryTest.getAllHotels();
        printHotels(after);

    return true;
    }

    private void printHotels(List<Hotel> hotels){
        for (Hotel hotel : hotels) {
            System.out.println("ID: " + hotel.getId() + " Name: " + hotel.getHotelName());
        }
    }
}
