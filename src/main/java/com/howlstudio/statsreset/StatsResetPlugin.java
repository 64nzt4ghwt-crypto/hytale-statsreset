package com.howlstudio.statsreset;
import com.hypixel.hytale.server.core.command.system.CommandManager;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
/** StatsResetPlugin — Admin tool to wipe player data. Reset stats, balance, playtime, or all data at once. */
public final class StatsResetPlugin extends JavaPlugin {
    public StatsResetPlugin(JavaPluginInit init){super(init);}
    @Override protected void setup(){CommandManager.get().register(new StatsResetCommand());System.out.println("[StatsReset] Ready.");}
    @Override protected void shutdown(){System.out.println("[StatsReset] Stopped.");}
}
