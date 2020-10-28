package com.nanoplugins.autoclicker.task;

import java.util.TimerTask;

import com.nanoplugins.autoclicker.NanoAutoClicker;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.nanoplugins.autoclicker.NanoAutoClickerAPI;
import com.nanoplugins.autoclicker.event.AutoClickHitEvent;

public class AutoClickTask extends TimerTask {

    private final NanoAutoClicker plugin;
    private final NanoAutoClickerAPI api;
    private final int x, y, z, damage;

    public AutoClickTask(NanoAutoClicker plugin, NanoAutoClickerAPI api, FileConfiguration config) {
        this.plugin = plugin;
        this.api = api;
        x = config.getInt("settings.range.x");
        y = config.getInt("settings.range.x");
        z = config.getInt("settings.range.x");
        damage = config.getInt("settings.damage");
    }


    @Override
    public void run() {
        if (api.getUsers() == null) return;
        for (Player player : api.getUsers()) {
            for (Entity entity : player.getNearbyEntities(x, y, z)) {
                if (entity instanceof LivingEntity && !entity.getType().equals(EntityType.PLAYER)) {
                    LivingEntity livingEntity = (LivingEntity) entity;
                    Bukkit.getPluginManager().callEvent(new AutoClickHitEvent(player, livingEntity, livingEntity.getHealth(), (livingEntity.getHealth() - damage)));
                    if (!livingEntity.isDead())
                        Bukkit.getScheduler().runTask(plugin, () -> livingEntity.damage(damage));
                }
            }
        }

    }


}
