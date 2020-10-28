package com.nanoplugins.autoclicker.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AutoClickHitEvent extends Event {

	private final Player player;
	private final LivingEntity livingEntity;
	private final double health, afterDamagedHealth;

    public Player getPlayer() {
		return player;
	}

    public LivingEntity getLivingEntity() {
        return livingEntity;
    }

    public double getHealth() {
        return health;
    }

    public double getAfterDamagedHealth() {
        return afterDamagedHealth;
    }

    public AutoClickHitEvent(Player player, LivingEntity livingEntity, double health, double afterDamagedHealth) {
        this.player = player;
        this.livingEntity = livingEntity;
        this.health = health;
        this.afterDamagedHealth = afterDamagedHealth;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}