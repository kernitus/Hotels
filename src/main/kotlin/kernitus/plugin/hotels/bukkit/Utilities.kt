package kernitus.plugin.hotels.bukkit

import org.bukkit.Bukkit
import java.util.*

object Utilities {

    fun worldNameToId(name: String): UUID? = Bukkit.getWorld(name)?.uid
}
