package me.alvsch.essentialsxlight.commands.commands.gamemode;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import me.alvsch.essentialsxlight.commands.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Gamemode extends Command {

    public Gamemode(EssentialsXLight plugin) {
        super(plugin);

        addRequirement(CommandManager.Requirement.PLAYER);
    }

    @Override
    public String getName() {
        return "gamemode";
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if(!(args.length >= 1)) {
            return false;
        }

        Player target = player;
        if(args.length >= 2) {
            target = Bukkit.getPlayer(args[1]);
            if(target == null) {
                return false;
            }

        }

        switch (args[0]) {
            case "0":
            case "survival":
            case "s":
                if(player.hasPermission("essentials.gamemode.survival") || player.hasPermission("essentials.gamemode.all")) {
                    target.setGameMode(GameMode.SURVIVAL);
                } else {
                    player.sendMessage(plugin.getPhrase("command.permission-message"));
                }
                break;


            case "1":
            case "creative":
            case "c":
                if(player.hasPermission("essentials.gamemode.creative") || player.hasPermission("essentials.gamemode.all")) {
                    target.setGameMode(GameMode.CREATIVE);
                } else {
                    player.sendMessage(plugin.getPhrase("command.permission-message"));
                }
                break;


            case "2":
            case "adventure":
            case "a":
                if(player.hasPermission("essentials.gamemode.advendure") || player.hasPermission("essentials.gamemode.all")) {
                    target.setGameMode(GameMode.ADVENTURE);
                } else {
                    player.sendMessage(plugin.getPhrase("command.permission-message"));
                }
                break;


            case "3":
            case "spectator":
            case "sp":
                if(player.hasPermission("essentials.gamemode.spectator") || player.hasPermission("essentials.gamemode.all")) {
                    target.setGameMode(GameMode.SPECTATOR);
                } else {
                    player.sendMessage(plugin.getPhrase("command.permission-message"));
                }
                break;


        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> completion = new ArrayList<>();

        // Game modes
        if(args.length == 1) {
            if(sender.hasPermission("essentials.gamemode.all")) {
                completion.add("survival");
                completion.add("creative");
                completion.add("adventure");
                completion.add("spectator");
            } else {
                if(sender.hasPermission("essentials.gamemode.survival")) {
                    completion.add("survival");
                }
                if(sender.hasPermission("essentials.gamemode.creative")) {
                    completion.add("creative");
                }
                if(sender.hasPermission("essentials.gamemode.adventure")) {
                    completion.add("adventure");
                }
                if(sender.hasPermission("essentials.gamemode.spectator")) {
                    completion.add("spectator");
                }
            }
        }
        // Online Players
        if(args.length == 2) {
            if(sender.hasPermission("essentials.gamemode.others")) {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    completion.add(p.getName());
                }
            }
        }

        return completion;
    }
}
