package me.alvsch.templateplugin.commands.main.subcommands;

import me.alvsch.templateplugin.TemplatePlugin;
import me.alvsch.templateplugin.commands.Command;
import me.alvsch.templateplugin.commands.SubCommand;
import me.alvsch.templateplugin.utils.Utils;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Iterator;

public class Author extends SubCommand {


    public Author(TemplatePlugin plugin, Command command) {
        super(plugin, command);
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Author/s: ");
        Iterator<String> iterator = plugin.getDescription().getAuthors().iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if(iterator.hasNext()) sb.append(", ");
        }
        sender.sendMessage(Utils.color("&a" + sb));
        return true;
    }

    @Override
    public String getName() {
        return "author";
    }

    @Override
    public String getDescription() {
        return "Displays the authors for the plugin";
    }

    @Override
    public String getUsage() {
        return "author";
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public ArrayList<String> getAliases() {
        return null;
    }
}
