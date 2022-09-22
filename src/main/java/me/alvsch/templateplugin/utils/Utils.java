package me.alvsch.templateplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class Utils {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String title(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static boolean hasPermission(CommandSender sender, String perm) {
        return perm == null || sender.hasPermission(perm);
    }

    public static String nullToEmpty(String str) {
        if(str == null) {
            return "";
        } else {
            return str;
        }
    }

}
