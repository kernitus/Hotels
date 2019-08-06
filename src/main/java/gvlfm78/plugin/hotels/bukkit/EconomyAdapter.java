package kernitus.plugin.hotels.bukkit;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;

import java.math.BigDecimal;

public class EconomyAdapter {

    private static Economy economy;

    public EconomyAdapter(){
        economy = Bukkit.getServer().getServicesManager().getRegistration(Economy.class).getProvider();
    }

    
    public BigDecimal getBalance(LocalPlayer player) {
        return BigDecimal.valueOf(economy.getBalance(BukkitAdapter.adapt(player)));
    }

    /**
     * Attempts to withdraw amount from player account
     * @param player Player whose account we will be acting on
     * @param amount Amount to withdraw
     * @return Whether we were able to withdraw amount
     */
    
    public boolean withdrawAmount(LocalPlayer player, BigDecimal amount) {
        return economy.withdrawPlayer(BukkitAdapter.adapt(player),
                amount.doubleValue()).transactionSuccess();
    }

    
    public String getCurrencyNameSingular() {
        return economy.currencyNameSingular();
    }

    
    public String getCurrencyNamePlural() {
        return economy.currencyNamePlural();
    }

    
    public String formatCurrency(BigDecimal amount){
        return economy.format(amount.doubleValue());
    }
}
