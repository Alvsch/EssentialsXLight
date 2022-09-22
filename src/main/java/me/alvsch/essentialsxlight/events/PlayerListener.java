package me.alvsch.essentialsxlight.events;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    EssentialsXLight plugin;

    public PlayerListener(EssentialsXLight plugin) {
        this.plugin = plugin;
    }

    // PlayerJoinEvent
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(!player.hasPermission("essentials.debug") && !player.getUniqueId().equals(plugin.getAuthor())) {
            return;
        }
        if(plugin.getVersion().equals(EssentialsXLight.Version.OUTDATED)) {
            player.sendMessage(Utils.color("&cThis version of " + plugin.getName() + " is outdated"));
        }
        if(plugin.getVersion().equals(EssentialsXLight.Version.UNSTABLE)) {
            player.sendMessage(Utils.color("&4This version of " + plugin.getName() + " is unstable"));
        }

    }


}
