package kernitus.plugin.hotels.bukkit;

import kernitus.plugin.hotels.core.adapters.UtilitiesAdapter;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.Optional;
import java.util.UUID;

public class BukkitUtilitiesAdapter implements UtilitiesAdapter {

    @Override
    public Optional<UUID> worldNameToId(String name) {
        return Optional.ofNullable(Bukkit.getWorld(name)).map(World::getUID);
    }
}
