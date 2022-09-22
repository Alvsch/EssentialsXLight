package me.alvsch.essentialsxlight.commands.commands.teleport;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Teleport extends Command {

    public Teleport(EssentialsXLight plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "teleport";
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {

        if(!(args.length >= 1)) {
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if(target == null) {
            return false;
        }

        if(args.length == 1) {
            if(sender instanceof Player) {
                ((Player) sender).teleport(target);
            }
        }

        if(args.length == 2) {
            Player target2 = Bukkit.getPlayer(args[0]);
            if(target2 == null) {
                return false;
            }
            target.teleport(target2);
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
