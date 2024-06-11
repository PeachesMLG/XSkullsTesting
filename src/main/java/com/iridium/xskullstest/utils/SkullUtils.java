package com.iridium.xskullstest.utils;

import com.cryptomorin.xseries.XSkull;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.CompletableFuture;

public class SkullUtils {

    public static CompletableFuture<ItemStack> getSkull(String playerName) {
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);

        return XSkull.of(itemStack).profile(playerName).applyAsync();
    }
}
