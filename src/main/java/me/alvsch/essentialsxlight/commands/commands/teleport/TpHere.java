package me.alvsch.essentialsxlight.commands.commands.teleport;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import me.alvsch.essentialsxlight.commands.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TpHere extends Command {

    public TpHere(EssentialsXLight plugin) {
        super(plugin);

        addRequirement(CommandManager.Requirement.PLAYER);
    }

    @Override
    public String getName() {
        return "tphere";
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {

        if(!sender.hasPermission("essentials.tphere")) {
            sender.sendMessage(plugin.getPhrase("command.permission-message"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if(target == null) {
            return false;
        }
        target.teleport((Player) sender);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> completion = new ArrayList<>();

        for(Player p : Bukkit.getOnlinePlayers()) {
            completion.add(p.getName());
        }

        return completion;
    }
}
