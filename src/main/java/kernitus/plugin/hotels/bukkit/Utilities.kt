package kernitus.plugin.hotels.bukkit

import org.bukkit.Bukkit
import org.bukkit.World
import java.util.*

object Utilities {

    fun worldNameToId(name: String): Optional<UUID> {
        return Optional.ofNullable(Bukkit.getWorld(name)).map(Function<T, UUID> { World.getUID() })
    }
}
