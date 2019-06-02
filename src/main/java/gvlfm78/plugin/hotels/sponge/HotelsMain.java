package kernitus.plugin.hotels.sponge;

import kernitus.plugin.hotels.core.Adapters;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import javax.inject.Inject;

@Plugin(id ="hotels", name = "Hotels", version = "${project.version}", description = "Allows the making of hotels and renting of rooms")
public class HotelsMain {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event){
        logger.info("Hotels has been enabled");

        Adapters.initialise(new SpongeEconomyAdapter());
    }

    public static PluginContainer getContainer(){
        return Sponge.getPluginManager().getPlugin("hotels").orElse(null);
    }
}
