package kernitus.plugin.hotels.core.commands.subcommands;

import kernitus.plugin.hotels.core.adapters.Adapters;
import kernitus.plugin.hotels.core.commands.HotelsCommand;
import kernitus.plugin.hotels.core.database.HotelsQuery;
import kernitus.plugin.hotels.core.hotel.Hotel;
import kernitus.plugin.hotels.core.permissions.HotelsPermission;

import java.util.LinkedHashSet;
import java.util.List;

public class ListAllHotelsCommand extends HotelsCommand {

    public ListAllHotelsCommand() {
        super(new String[]{"hotellist", "hlist", "list"},
                new LinkedHashSet<>(),
                new HotelsPermission("hotels.hotellist.all"));
    }

    @Override
    public void execute() {
        List<Hotel> resultList = HotelsQuery.getAll(Hotel.class);

        if(resultList.size() < 1) Adapters.messaging.print("No hotels found at all!");
        else resultList.forEach(hotel -> Adapters.messaging.print("Hotel: " + hotel.getHotelName()));
    }
}
