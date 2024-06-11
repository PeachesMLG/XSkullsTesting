package com.iridium.xskullstest;

import com.iridium.xskullstest.listeners.PlayerInteractListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class XSkullsTest extends JavaPlugin {

    @Getter
    private static XSkullsTest instance;

    @Override
    public void onEnable() {
        instance = this;

        registerListeners();

        this.getLogger().info("-------------------------------");
        this.getLogger().info("");
        this.getLogger().info(this.getDescription().getName() + " Enabled!");
        this.getLogger().info("");
        this.getLogger().info("-------------------------------");
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }
}
