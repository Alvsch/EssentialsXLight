package me.alvsch.essentialsxlight.commands.commands.fly;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.commands.Command;
import me.alvsch.essentialsxlight.commands.CommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class FlySpeed extends Command {

    public FlySpeed(EssentialsXLight plugin) {
        super(plugin);

        addRequirement(CommandManager.Requirement.PLAYER);
    }

    @Override
    public String getName() {
        return "flyspeed";
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        float speed = Float.parseFloat(args[0]);
        speed = (float) Math.floor(speed);

        if (speed > 10 || speed < 0) {
            return false;
        }

        player.setFlySpeed(speed / 10);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
