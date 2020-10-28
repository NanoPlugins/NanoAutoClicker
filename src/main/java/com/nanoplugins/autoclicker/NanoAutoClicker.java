package com.nanoplugins.autoclicker;

import com.nanoplugins.autoclicker.command.AutoClickCommand;
import com.nanoplugins.autoclicker.listener.PlayerQuit;
import com.nanoplugins.autoclicker.task.AutoClickTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;

public class NanoAutoClicker extends JavaPlugin {

    private final Timer timer = new Timer();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        NanoAutoClickerAPI api = new NanoAutoClickerAPI();
        timer.schedule(new AutoClickTask(this, api, getConfig()), 10 * 1000, 1000 * getConfig().getInt("settings.time"));
        new AutoClickCommand(this, api);
        new PlayerQuit(this, api);
    }

    @Override
    public void onDisable() {
        timer.cancel();
    }
}
