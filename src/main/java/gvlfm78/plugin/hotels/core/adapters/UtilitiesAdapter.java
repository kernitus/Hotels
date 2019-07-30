package kernitus.plugin.hotels.core.adapters;

import java.util.Optional;
import java.util.UUID;

public interface UtilitiesAdapter {

    Optional<UUID> worldNameToId(String name);
}
