package com.iridium.xskullstest.listeners;

import com.iridium.xskullstest.gui.TestGUI;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        event.getPlayer().openInventory(new TestGUI().getInventory());

    }
}
