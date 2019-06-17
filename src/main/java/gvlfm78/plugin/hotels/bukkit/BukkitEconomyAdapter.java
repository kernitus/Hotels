package kernitus.plugin.hotels.bukkit;

import kernitus.plugin.hotels.core.economy.EconomyAdapter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.math.BigDecimal;

public class BukkitEconomyAdapter implements EconomyAdapter {

    private static Economy economy;

    public BukkitEconomyAdapter(){
        economy = Bukkit.getServer().getServicesManager().getRegistration(Economy.class).getProvider();
    }

    @Override
    public BigDecimal getBalance(OfflinePlayer player) {
        return BigDecimal.valueOf(economy.getBalance(player));
    }

    @Override
    public boolean withdrawAmount(OfflinePlayer player, BigDecimal amount) {
        return economy.withdrawPlayer(player, amount.doubleValue()).transactionSuccess();
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
    public String formatCurrency(BigDecimal amount){
        return economy.format(amount.doubleValue());
    }
}
