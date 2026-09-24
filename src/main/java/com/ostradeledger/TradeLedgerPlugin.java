package com.ostradeledger;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
    name = "OSRS Trade Ledger",
    internalName = "osrs-trade-ledger",
    description = "Track personal Grand Exchange trades"
)
public class TradeLedgerPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private TradeLedgerConfig config;

    @Subscribe
    public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged event)
    {
        if (!config.logOfferObservations() || client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }

        GrandExchangeOffer offer = event.getOffer();
        // An observation is a cumulative slot snapshot, not a fill or a trade.
        log.debug("GE observation: slot={}, state={}, itemId={}, offeredPrice={}, "
            + "requestedQuantity={}, filledQuantity={}, cumulativeGp={}",
            event.getSlot(), offer.getState(), offer.getItemId(), offer.getPrice(),
            offer.getTotalQuantity(), offer.getQuantitySold(), offer.getSpent());
    }

    @Provides
    TradeLedgerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TradeLedgerConfig.class);
    }
}
