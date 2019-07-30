package kernitus.plugin.hotels.sponge;

import kernitus.plugin.hotels.core.adapters.UtilitiesAdapter;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.World;

import java.util.Optional;
import java.util.UUID;

public class SpongeUtilitiesAdapter implements UtilitiesAdapter {

    @Override
    public Optional<UUID> worldNameToId(String name) {
        return Sponge.getServer().getWorld(name).map(World::getUniqueId);
    }
}
