package me.alvsch.essentialsxlight.commands.commands.teleport;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class TpaHere extends Command {

    public TpaHere(EssentialsXLight plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "tpahere";
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
