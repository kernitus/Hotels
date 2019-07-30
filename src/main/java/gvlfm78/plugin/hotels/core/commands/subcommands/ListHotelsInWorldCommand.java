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

package kernitus.plugin.hotels.core.commands.subcommands;

import com.google.common.collect.ImmutableSet;
import kernitus.plugin.hotels.core.adapters.Adapters;
import kernitus.plugin.hotels.core.commands.HotelsCommand;
import kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgument;
import kernitus.plugin.hotels.core.database.HotelsQuery;
import kernitus.plugin.hotels.core.exceptions.WorldNonExistentException;
import kernitus.plugin.hotels.core.hotel.Hotel;
import kernitus.plugin.hotels.core.permissions.HotelsPermission;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static kernitus.plugin.hotels.core.commands.arguments.HotelsCommandArgumentOptionality.WORLD_NAME;

/**
 * Lists the hotels in all/given world(s)
 */
public class ListHotelsInWorldCommand extends HotelsCommand {

    public ListHotelsInWorldCommand() {
        super(new String[]{"hotellist", "hlist", "list"},
                new LinkedHashSet<>(ImmutableSet.of(new HotelsCommandArgument(WORLD_NAME, "world"))),
                new HotelsPermission("hotels.hotellist.world"));
    }

    @Override
    public void execute() throws WorldNonExistentException {
        Optional<UUID> worldId = Adapters.utilities.worldNameToId(getArgument(0).getValue());
        if(!worldId.isPresent()) throw new WorldNonExistentException();

        List<Hotel> resultList = HotelsQuery.runSelectQuery("SELECT h FROM Hotel h WHERE hotelWorldId='"
        + worldId.get() + "'", Hotel.class);

        if(resultList.size() < 1) Adapters.messaging.print("No hotels found in this world!");
        else resultList.forEach(hotel -> Adapters.messaging.print("Hotel: " + hotel.getHotelName()));
    }
}
