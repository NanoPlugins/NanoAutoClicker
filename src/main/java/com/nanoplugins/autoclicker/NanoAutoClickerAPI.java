package com.nanoplugins.autoclicker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class NanoAutoClickerAPI {

	private static NanoAutoClickerAPI instance;

	public static NanoAutoClickerAPI get() {
		if (instance == null)
			instance = new NanoAutoClickerAPI();
		return instance;
	}

	private final List<Player> users = new ArrayList<>();

	public void add(Player player) {
		users.add(player);
	}
	
	public void remove(Player player) {
		users.remove(player);
	}
	
	public boolean contains(Player player) {
		return users.contains(player); 
	}
	
	public List<Player> getUsers() {
		return users;
	}
	
}
