package me.alvsch.essentialsxlight.events;

import me.alvsch.essentialsxlight.EssentialsXLight;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener implements Listener {

    EssentialsXLight plugin;

    public ServerListener(EssentialsXLight plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void serverListPing(ServerListPingEvent e) {
        String motd = plugin.config.getString("custom-motd");
        if(motd == null) {
            e.setMotd("");
        } else {
            if(!motd.equals("none")) {
                e.setMotd(motd);
            }

        }
    }

}
