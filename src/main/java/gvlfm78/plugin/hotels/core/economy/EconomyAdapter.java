package kernitus.plugin.hotels.core.economy;

import com.sk89q.worldguard.LocalPlayer;

import java.math.BigDecimal;

public interface EconomyAdapter {

    BigDecimal getBalance(LocalPlayer player);

    /**
     * Attempts to withdraw amount from player account
     * @param player Player whose account we will be acting on
     * @param amount Amount to withdraw
     * @return Whether we were able to withdraw amount
     */
    boolean withdrawAmount(LocalPlayer player, BigDecimal amount);

    String getCurrencyNameSingular();
    String getCurrencyNamePlural();
    String formatCurrency(BigDecimal amount);
}
