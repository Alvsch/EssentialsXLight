package me.alvsch.templateplugin.events;

import me.alvsch.templateplugin.TemplatePlugin;
import me.alvsch.templateplugin.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    TemplatePlugin plugin;

    public PlayerListener(TemplatePlugin plugin) {
        this.plugin = plugin;
    }

    // PlayerJoinEvent
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(!player.hasPermission("templateplugin.debug") && !player.getUniqueId().equals(plugin.getAuthor())) {
            return;
        }
        if(plugin.getVersion().equals(TemplatePlugin.Version.OUTDATED)) {
            player.sendMessage(Utils.color("&cThis version of " + plugin.getName() + " is outdated"));
        }
        if(plugin.getVersion().equals(TemplatePlugin.Version.UNSTABLE)) {
            player.sendMessage(Utils.color("&4This version of " + plugin.getName() + " is unstable"));
        }

    }


}
