package kernitus.plugin.hotels.core.economy;

import org.bukkit.OfflinePlayer;

public interface EconomyAdapter {

    double getBalance(OfflinePlayer player);

    /**
     * Attempts to withdraw amount from player account
     * @param player Player whose account we will be acting on
     * @param amount Amount to withdraw
     * @return Whether we were able to withdraw amount
     */
    boolean withdrawAmount(OfflinePlayer player, double amount);

    String getCurrencyNameSingular();
    String getCurrencyNamePlural();
    String formatCurrency(double amount);
}
