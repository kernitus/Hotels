package kernitus.plugin.hotels.sponge;

import kernitus.plugin.hotels.core.economy.EconomyAdapter;
import org.bukkit.OfflinePlayer;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.UniqueAccount;
import org.spongepowered.api.service.economy.transaction.ResultType;
import org.spongepowered.api.service.economy.transaction.TransactionResult;

import java.math.BigDecimal;

public class SpongeEconomyAdapter implements EconomyAdapter {

    //TODO Listen for https://jd.spongepowered.org/7.1.0/org/spongepowered/api/event/service/ChangeServiceProviderEvent.html
    private static EconomyService economy = Sponge.getServiceManager().provide(EconomyService.class).get();

    @Override
    public BigDecimal getBalance(OfflinePlayer player) {
        return getAccount(player).getBalance(getDefaultCurrency());
    }

    @Override
    public boolean withdrawAmount(OfflinePlayer player, BigDecimal amount) {
        PluginContainer pluginContainer = HotelsMain.getContainer();

        EventContext eventContext = EventContext.builder().add(EventContextKeys.PLUGIN, pluginContainer).build();

        TransactionResult result = getAccount(player).withdraw(
                getDefaultCurrency(), amount, Cause.of(eventContext, pluginContainer));

        return result.getResult() == ResultType.SUCCESS;
    }

    @Override
    public String getCurrencyNameSingular() {
        return economy.getDefaultCurrency().getDisplayName().toPlain();
    }

    @Override
    public String getCurrencyNamePlural() {
        return economy.getDefaultCurrency().getPluralDisplayName().toPlain();
    }

    @Override
    public String formatCurrency(BigDecimal amount){
        return economy.getDefaultCurrency().format(amount).toPlain();
    }

    private static Currency getDefaultCurrency(){
        return economy.getDefaultCurrency();
    }

    private static UniqueAccount getAccount(OfflinePlayer player){
        return economy.getOrCreateAccount(player.getUniqueId()).get();
    }
}
