package me.alvsch.templateplugin.commands;

import me.alvsch.templateplugin.TemplatePlugin;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public abstract class SubCommand {

    protected TemplatePlugin plugin;

    private final ArrayList<CommandManager.Requirement> requirements = new ArrayList<>();
    private final Command command;

    public SubCommand(TemplatePlugin plugin, Command command) {
        this.plugin = plugin;
        this.command = command;
    }

    public abstract boolean onCommand(CommandSender sender, String[] args);

    public abstract String getName();
    public abstract String getDescription();
    public abstract String getUsage();

    public abstract String getPermission();
    public abstract ArrayList<String> getAliases();

    public void addRequirement(CommandManager.Requirement requirement) {
        this.requirements.add(requirement);
    }
    public ArrayList<CommandManager.Requirement> getRequirements() {
        return requirements;
    }
    public Command getCommand() {
        return command;
    }


}
