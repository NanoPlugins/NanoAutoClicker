package com.nanoplugins.autoclicker.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.nanoplugins.autoclicker.NanoAutoClicker;
import com.nanoplugins.autoclicker.NanoAutoClickerAPI;

public class AutoClickCommand implements CommandExecutor {

    private final NanoAutoClickerAPI api;
    private final String noPerm, deactivate, activate, addSender, addTarget,
            removeSender, removeTarget, needArgsAdd, needArgsRemove, playerNotFound;

    public AutoClickCommand(NanoAutoClicker plugin, NanoAutoClickerAPI api) {
        plugin.getCommand("autoclick").setExecutor(this);
        this.api = api;

        FileConfiguration config = plugin.getConfig();

        noPerm = config.getString("messages.no-perm").replace("&", "§");
        deactivate = config.getString("messages.deactivate").replace("&", "§");
        activate = config.getString("messages.activate").replace("&", "§");
        addSender = config.getString("messages.add.sender").replace("&", "§");
        addTarget = config.getString("messages.add.target").replace("&", "§");
        removeSender = config.getString("messages.remove.sender").replace("&", "§");
        removeTarget = config.getString("messages.remove.target").replace("&", "§");
        needArgsAdd = config.getString("messages.add.need-args").replace("&", "§");
        needArgsRemove = config.getString("messages.remove.need-args").replace("&", "§");
        playerNotFound = config.getString("messages.player-not-found").replace("&", "§");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Players com autoclick ativo:");
                for (Player player : api.getUsers()) {
                    sender.sendMessage("> " + player.getName());
                }
                return true;
            }

            if (!sender.hasPermission("autoclick.use")) {
                sender.sendMessage(noPerm);
                return true;
            }

            Player player = (Player) sender;
            if (api.contains(player)) {
                api.remove(player);
                player.sendMessage(deactivate);
            } else {
                api.add(player);
                player.sendMessage(activate);
            }

            return true;
        }

        if (!(sender.hasPermission("autoclick.admin"))) {
            sender.sendMessage(noPerm);
            return true;
        }

        if (args[0].equalsIgnoreCase("add")) {

            if (args.length < 2) {
                sender.sendMessage(needArgsAdd);
                return true;
            }

            Player target = Bukkit.getPlayer(args[1]);

            if (target == null) {
                sender.sendMessage(playerNotFound);
                return true;
            }

            sender.sendMessage(addSender.replace("%player%", target.getName()));
            target.sendMessage(addTarget);
            api.add(target);

        }

        if (args[0].equalsIgnoreCase("remove")) {

            if (args.length < 2) {
                sender.sendMessage(needArgsRemove);
                return true;
            }

            Player target = Bukkit.getPlayer(args[1]);

            if (target == null) {
                sender.sendMessage(playerNotFound);
                return true;
            }

            sender.sendMessage(removeSender.replace("%player%", target.getName()));
            target.sendMessage(removeTarget);
            api.remove(target);

        }

        return false;
    }

}
