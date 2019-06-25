package kernitus.plugin.hotels.bukkit;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import kernitus.plugin.hotels.core.adapters.EconomyAdapter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;

import java.math.BigDecimal;

public class BukkitEconomyAdapter implements EconomyAdapter {

    private static Economy economy;

    public BukkitEconomyAdapter(){
        economy = Bukkit.getServer().getServicesManager().getRegistration(Economy.class).getProvider();
    }

    @Override
    public BigDecimal getBalance(LocalPlayer player) {
        return BigDecimal.valueOf(economy.getBalance(BukkitAdapter.adapt(player)));
    }

    @Override
    public boolean withdrawAmount(LocalPlayer player, BigDecimal amount) {
        return economy.withdrawPlayer(BukkitAdapter.adapt(player),
                amount.doubleValue()).transactionSuccess();
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
