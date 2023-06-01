package me.fortlisa.fortlisaconfiglistener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConfigListenerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("ConfigListenerPlugin has started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
