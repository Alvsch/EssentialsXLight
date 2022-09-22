package me.alvsch.templateplugin.commands.main;


import me.alvsch.templateplugin.TemplatePlugin;
import me.alvsch.templateplugin.commands.Command;
import me.alvsch.templateplugin.commands.main.subcommands.Author;
import me.alvsch.templateplugin.commands.main.subcommands.Reload;
import org.bukkit.command.CommandSender;

import java.util.List;

public class MainCommand extends Command {


    public MainCommand(TemplatePlugin plugin) {
        super(plugin);

        addSubCommand(new Reload(plugin, this));
        addSubCommand(new Author(plugin, this));
    }

    @Override
    public String getName() {
        return "templateplugin";
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
