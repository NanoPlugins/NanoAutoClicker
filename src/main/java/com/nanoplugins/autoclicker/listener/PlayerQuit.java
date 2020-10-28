package com.nanoplugins.autoclicker.listener;

import com.nanoplugins.autoclicker.NanoAutoClicker;
import com.nanoplugins.autoclicker.NanoAutoClickerAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    private final NanoAutoClickerAPI api;

    public PlayerQuit(NanoAutoClicker plugin, NanoAutoClickerAPI api) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.api = api;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (api.contains(event.getPlayer())) api.remove(event.getPlayer());
    }


}
