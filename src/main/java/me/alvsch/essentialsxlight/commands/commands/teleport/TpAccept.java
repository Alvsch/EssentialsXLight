package me.alvsch.essentialsxlight.commands.commands.teleport;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class TpAccept extends Command {

    public TpAccept(EssentialsXLight plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "tpaccept";
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
