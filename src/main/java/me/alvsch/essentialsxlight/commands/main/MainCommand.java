package me.alvsch.essentialsxlight.commands.main;


import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import me.alvsch.essentialsxlight.commands.main.subcommands.Author;
import me.alvsch.essentialsxlight.commands.main.subcommands.Reload;
import org.bukkit.command.CommandSender;

import java.util.List;

public class MainCommand extends Command {


    public MainCommand(EssentialsXLight plugin) {
        super(plugin);

        addSubCommand(new Reload(plugin, this));
        addSubCommand(new Author(plugin, this));
    }

    @Override
    public String getName() {
        return "essentialsxlight";
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
