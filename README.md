# OSRS Trade Ledger

A personal Old School RuneScape ledger for Grand Exchange flips, holdings, and membership-cycle results.

## Current prototype

The RuneLite plugin can log **observations** of GE offer slots for local testing. It does not yet store trades, infer fills, calculate profit, or import GE History. The first goal is to learn which offer states and cumulative values RuneLite exposes during partial fills, cancellations, relists, and logins.

Run the development client with `./gradlew run`. In the plugin settings, enable **Log GE observations**. The observations appear at DEBUG level in the development client's logs. Test with small offers, and compare each log line against the GE screen and history. Do not publish logs containing your activity or account information.

An observation records slot, state, item ID, offered price, requested quantity, cumulative filled quantity, and cumulative GP. The log time is when RuneLite observed that state; it is **not necessarily the transaction time**. A fill must be reconstructed from consecutive observations only after we test the behavior in game.

The application will eventually support trade grouping, partial fills, weighted average costs, realized results, held positions, and editable membership-bond cycles. Mobile trades recovered through GE History will enter a review flow when sufficient data is available.
