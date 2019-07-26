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
import kernitus.plugin.hotels.core.commands.HotelsCommandArgument;
import kernitus.plugin.hotels.core.commands.HotelsPermission;
import kernitus.plugin.hotels.core.database.Query;
import kernitus.plugin.hotels.core.hotel.Hotel;

import javax.persistence.TypedQuery;
import java.util.LinkedHashSet;
import java.util.List;

import static kernitus.plugin.hotels.core.commands.HotelsCommandArgumentOptionality.WORLD_NAME;

/**
 * Lists the hotels in all/given world(s)
 */
public class HotelsListCommand extends HotelsCommand {

    public HotelsListCommand() {
        super(new String[]{"hotellist", "hlist"},
                new LinkedHashSet<>(ImmutableSet.of(new HotelsCommandArgument(WORLD_NAME, "world"))),
                new HotelsPermission("hotels.hotellist"));
    }

    @Override
    public void execute() {
        TypedQuery<Hotel> query = Query.getEntityManager().createQuery("SELECT h FROM Hotel h", Hotel.class);
        List<Hotel> resultList = query.getResultList();
        if(resultList.size() < 1) Adapters.messaging.print("No hotels found!");
        resultList.forEach(hotel -> Adapters.messaging.print("Hotel: " + hotel.getHotelName()));
    }
}
