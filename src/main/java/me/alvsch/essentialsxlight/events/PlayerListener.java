package me.alvsch.essentialsxlight.events;

import me.alvsch.essentialsxlight.EssentialsXLight;
import me.alvsch.essentialsxlight.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

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


        String message;
        if(player.hasPlayedBefore()) {
            message = plugin.config.getString("custom-join-message");
        } else {
            message = plugin.config.getString("custom-first-join-message");
        }

        if(message == null) {
            e.setJoinMessage("");
        } else {
            if (!Objects.equals(message, "none")) {
                e.setJoinMessage(message
                        .replace("{USERNAME}", player.getName())
                        .replace("{PLAYER}", player.getDisplayName())
                );
            }
        }

    }

    // PlayerQuitEvent
    @EventHandler
    public void playerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        String message = plugin.config.getString("custom-quit-message");
        if(message == null) {
            e.setQuitMessage("");
        } else {
            if (!Objects.equals(message, "none")) {
                e.setQuitMessage(message
                        .replace("{USERNAME}", player.getName())
                        .replace("{PLAYER}", player.getDisplayName())
                );
            }
        }
    }


}
