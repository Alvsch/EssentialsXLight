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
import java.util.Objects;

public class GamemodeCreative extends Command {

    public GamemodeCreative(EssentialsXLight plugin) {
        super(plugin);

        addRequirement(CommandManager.Requirement.PLAYER);

    }

    @Override
    public String getName() {
        return "gmc";
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if(!player.hasPermission("essentials.gamemode.creative") && !player.hasPermission("essentials.gamemode.all")) {
            player.sendMessage(plugin.getPhrase("command.permission-message"));
            return true;
        }

        if(!(args.length >= 1)) {
            player.setGameMode(GameMode.CREATIVE);
            return true;
        }

        if(Objects.equals(args[0], "*")) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                p.setGameMode(GameMode.CREATIVE);
            }
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if(target == null) {
            return false;
        }

        target.setGameMode(GameMode.CREATIVE);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> completion = new ArrayList<>();

        if(sender.hasPermission("essentials.gamemode.others")) {
            completion.add("*");
            for(Player p : Bukkit.getOnlinePlayers()) {
                completion.add(p.getName());
            }
        }

        return completion;
    }
}
