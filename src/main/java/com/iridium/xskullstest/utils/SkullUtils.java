package com.iridium.xskullstest.utils;

import com.cryptomorin.xseries.XSkull;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SkullUtils {
    private static final HashMap<String, SkullData> skullRequests = new HashMap<>();

    public static ItemStack getSkull(String playerName) {
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);

        if (!skullRequests.containsKey(playerName) || skullRequests.get(playerName).hasTimeout()) {
            XSkull.of(itemStack).profile(playerName).applyAsync().thenRun(() -> skullRequests.put(playerName, new SkullData(SkullState.LOADED)));
            skullRequests.put(playerName, new SkullData(SkullState.LOADING));
        }
        if (skullRequests.get(playerName).skullState == SkullState.LOADED) {
            itemStack = XSkull.of(itemStack).profile(playerName).apply();
        }

        return itemStack;
    }

    @AllArgsConstructor
    private static class SkullData {
        SkullState skullState;
        LocalDateTime localDateTime;

        public SkullData(SkullState skullState) {
            this.skullState = skullState;
            this.localDateTime = LocalDateTime.now();
        }

        public boolean hasTimeout() {
            return skullState == SkullState.LOADING && localDateTime.isBefore(LocalDateTime.now().minusSeconds(5));
        }
    }

    private enum SkullState {
        NONE, LOADING, LOADED;
    }
}
