package com.iridium.xskullstest;

import com.iridium.xskullstest.listeners.PlayerInteractListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

public class XSkullsTest extends JavaPlugin {

    @Getter
    private static XSkullsTest instance;

    @Override
    public void onEnable() {
        instance = this;

        registerListeners();

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.getServer().getOnlinePlayers().forEach(player -> {
            InventoryHolder inventoryHolder = player.getOpenInventory().getTopInventory().getHolder();
            if (inventoryHolder instanceof GUI) {
                ((GUI) inventoryHolder).addContent(player.getOpenInventory().getTopInventory());
            }
        }), 0, 20);

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
