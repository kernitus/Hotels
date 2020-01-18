package kernitus.plugin.hotels.bukkit

import kernitus.plugin.hotels.core.exceptions.BruhMoment
import net.milkbowl.vault.economy.Economy
import org.bukkit.Bukkit
import org.bukkit.entity.Player

import java.math.BigDecimal

class EconomyAdapter {

    private lateinit var economy: Economy

    fun initialise(){
        economy = Bukkit.getServer().servicesManager.getRegistration(Economy::class.java)?.provider ?:
                throw BruhMoment() // TODO make and handle this exception properly
    }

    private val currencyNameSingular: String
        get() = economy.currencyNameSingular()


    private val currencyNamePlural: String
        get() = economy.currencyNamePlural()


    fun getBalance(player: Player): BigDecimal = BigDecimal.valueOf(economy.getBalance(player))

    /**
     * Attempts to withdraw amount from player account
     * @param player Player whose account we will be acting on
     * @param amount Amount to withdraw
     * @return Whether we were able to withdraw amount
     */

    fun withdrawAmount(player: Player, amount: BigDecimal): Boolean =
            economy.withdrawPlayer(player, amount.toDouble()).transactionSuccess()

    fun formatCurrency(amount: BigDecimal): String = economy.format(amount.toDouble())
}
