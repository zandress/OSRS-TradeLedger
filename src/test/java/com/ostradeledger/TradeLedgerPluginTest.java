package com.ostradeledger;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class TradeLedgerPluginTest
{
    public static void main(String[] args) throws Exception
    {
        ExternalPluginManager.loadBuiltin(TradeLedgerPlugin.class);
        RuneLite.main(args);
    }
}
