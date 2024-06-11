package com.iridium.xskullstest.gui;

import com.iridium.xskullstest.GUI;
import com.iridium.xskullstest.utils.SkullUtils;
import com.iridium.xskullstest.utils.Usernames;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class TestGUI implements GUI {

    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, 54, "Test GUI");
        addContent(inventory);
        return inventory;
    }

    @Override
    public void addContent(Inventory inventory) {
        for (int i = 0; i < 54; i++) {
            inventory.setItem(i, SkullUtils.getSkull(Usernames.usernames.get(i)));
        }
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {

    }
}
