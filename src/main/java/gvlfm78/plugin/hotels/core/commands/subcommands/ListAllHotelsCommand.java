package kernitus.plugin.hotels.core.commands.subcommands;

import com.sk89q.worldguard.LocalPlayer;
import kernitus.plugin.hotels.bukkit.Messaging;
import kernitus.plugin.hotels.core.commands.HotelsCommand;
import kernitus.plugin.hotels.core.database.HotelsQuery;
import kernitus.plugin.hotels.core.hotel.Hotel;
import kernitus.plugin.hotels.core.permissions.HotelsPermission;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

public class ListAllHotelsCommand extends HotelsCommand {

    public ListAllHotelsCommand() {
        super(new String[]{"hotellist", "hlist", "list"},
                new LinkedHashSet<>(),
                new HotelsPermission("hotels.hotellist.all"));
    }

    @Override
    public void execute(Optional<LocalPlayer> playerOptional) {
        List<Hotel> resultList = HotelsQuery.getAll(Hotel.class);

        if(resultList.size() < 1) Messaging.send("No hotels found at all!", playerOptional);
        else resultList.forEach(hotel -> Messaging.send("Hotel: " + hotel.getHotelName(), playerOptional));
    }
}
