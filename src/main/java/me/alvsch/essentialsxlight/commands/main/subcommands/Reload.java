package me.alvsch.essentialsxlight.commands.main.subcommands;


import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import me.alvsch.essentialsxlight.commands.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class Reload extends SubCommand {


    public Reload(EssentialsXLight plugin, Command command) {
        super(plugin, command);
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        sender.sendMessage(plugin.getPhrase("reloading"));
        if(plugin.createFiles()) {
            sender.sendMessage(plugin.getPhrase("reloaded"));
        } else {
            sender.sendMessage(plugin.getPhrase("not-reloaded"));
        }
        return true;
    }

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reloads the plugin config";
    }

    @Override
    public String getUsage() {
        return "reload";
    }

    @Override
    public String getPermission() {
        return "essentialsxlight.reload";
    }

    @Override
    public ArrayList<String> getAliases() {
        return null;
    }
}
