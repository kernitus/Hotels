package kernitus.plugin.hotels.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.Optional;
import java.util.UUID;

public class Utilities {

    public static Optional<UUID> worldNameToId(String name) {
        return Optional.ofNullable(Bukkit.getWorld(name)).map(World::getUID);
    }
}
