package com.ostradeledger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("osrs-trade-ledger")
public interface TradeLedgerConfig extends Config
{
    @ConfigItem(
        keyName = "logOfferObservations",
        name = "Log GE observations",
        description = "Write GE slot snapshots to the RuneLite debug log for local testing"
    )
    default boolean logOfferObservations()
    {
        return false;
    }
}
