package kernitus.plugin.hotels.bukkit;

import kernitus.plugin.hotels.core.economy.EconomyAdapter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class BukkitEconomyAdapter implements EconomyAdapter {

    private static Economy economy = Bukkit.getServer().getServicesManager().getRegistration(Economy.class).getProvider();

    @Override
    public double getBalance(OfflinePlayer player) {
        return economy.getBalance(player);
    }

    @Override
    public boolean withdrawAmount(OfflinePlayer player, double amount) {
        return economy.withdrawPlayer(player, amount).transactionSuccess();
    }

    @Override
    public String getCurrencyNameSingular() {
        return economy.currencyNameSingular();
    }

    @Override
    public String getCurrencyNamePlural() {
        return economy.currencyNamePlural();
    }

    @Override
    public String formatCurrency(double amount){
        return economy.format(amount);
    }
}
