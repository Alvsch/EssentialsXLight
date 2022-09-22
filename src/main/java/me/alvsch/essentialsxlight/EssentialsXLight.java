package me.alvsch.essentialsxlight;

import me.alvsch.essentialsxlight.commands.CommandManager;
import me.alvsch.essentialsxlight.commands.main.MainCommand;
import me.alvsch.essentialsxlight.events.InventoryListener;
import me.alvsch.essentialsxlight.events.PlayerListener;
import me.alvsch.essentialsxlight.events.ServerListener;
import me.alvsch.essentialsxlight.utils.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class EssentialsXLight extends JavaPlugin {

    public enum Version{LATEST, OUTDATED, UNSTABLE}
    private Version version;

    public CommandManager commandManager = new CommandManager(this);

    private final UUID author = UUID.fromString("23ccb8ea-8395-4260-9752-d34b634dd38d");

    @Override
    public void onEnable() {
        // Plugin startup logic

        Logger.log(Logger.LogLevel.OUTLINE, "********************");
        Logger.log(Logger.LogLevel.INFO, "Plugin is loading...");

        Logger.log(Logger.LogLevel.INFO, "Commands are loading...");
        registerCommand();
        Logger.log(Logger.LogLevel.INFO, "Commands are loaded!");
        Logger.log(Logger.LogLevel.INFO, "Events are loading...");
        registerEvents();
        Logger.log(Logger.LogLevel.INFO, "Events are loaded!");
        Logger.log(Logger.LogLevel.INFO, "Metrics are loading...");
        try {
            // Metrics metrics = new Metrics(this, 0);
        } catch (Exception ignored){
        }
        Logger.log(Logger.LogLevel.INFO, "Metrics are loaded!");
        Logger.log(Logger.LogLevel.INFO, "Files are loading!");
        createFiles();
        Logger.log(Logger.LogLevel.INFO, "Files are loaded!");
        new UpdateChecker(this, "Alvsch/EssentialsXLight").getLatestVersion(version -> {

            if(this.getDescription().getVersion().equalsIgnoreCase(version)) {
                this.version = Version.LATEST;
            } else {
                this.version = Version.OUTDATED;
            }
        });
        Logger.log(Logger.LogLevel.SUCCESS, "Plugin is loaded!");
        Logger.log(Logger.LogLevel.OUTLINE, "********************");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void registerCommand() {

        // Main
        commandManager.addCommand(new MainCommand(this));


        // Init
        commandManager.init();

    }

    private void registerEvents() {

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new ServerListener(this), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);

    }

    private void loadFile(File file, String resourcePath) {
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            saveResource(resourcePath, false);
        }
    }

    private File configf, languangef;
    public FileConfiguration config, language;

    public boolean createFiles() {
        configf = new File(getDataFolder(), "config.yml");
        languangef = new File(getDataFolder(), "languange.yml");

        loadFile(configf, "config.yml");
        loadFile(languangef, "languange.yml");

        config = new YamlConfiguration();
        language = new YamlConfiguration();
        try {
            config.load(configf);
            language.load(languangef);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public Version getVersion() {
        return version;
    }
    public UUID getAuthor() {
        return author;
    }

    public String getPhrase(String str, String path) {
        return str + getPhrase(path);
    }
    public String getPhrase(ChatColor color, String path) {
        return color + getPhrase(path);
    }
    public String getPhrase(String path) {
        String phrase = language.getString(path);
        if(phrase == null) {
            Logger.log(Logger.LogLevel.WARNING, "Missing phrase in language.yml: " + path);
        }
        return phrase;
    }


}
