package kernitus.plugin.hotels.core.commands.subcommands

import kernitus.plugin.hotels.bukkit.Messaging
import kernitus.plugin.hotels.core.commands.HotelsCommand
import kernitus.plugin.hotels.core.database.HotelsQuery
import kernitus.plugin.hotels.core.hotel.Hotel
import kernitus.plugin.hotels.core.permissions.HotelsPermission
import org.bukkit.entity.Player
import java.util.*

class ListAllHotelsCommand : HotelsCommand(arrayOf("hotellist", "hlist", "list"), LinkedHashSet<HotelsCommandArgument>(), HotelsPermission("hotels.hotellist.all")) {

    override fun execute(playerOptional: Optional<Player>) {
        val resultList = HotelsQuery.getAll<Hotel>(Hotel::class.java!!)

        if (resultList.size < 1)
            Messaging.send("No hotels found at all!", playerOptional)
        else
            resultList.forEach { hotel -> Messaging.send("Hotel: " + hotel.hotelName!!, playerOptional) }
    }
}
