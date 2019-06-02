package kernitus.plugin.hotels.core;

import kernitus.plugin.hotels.core.economy.EconomyAdapter;

public class Adapters {

    public static EconomyAdapter economy;

    public static void initialise(EconomyAdapter economyAdapter) {
        economy = economyAdapter;
    }
}
