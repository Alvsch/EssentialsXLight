package me.alvsch.essentialsxlight.utils;

import com.google.gson.JsonObject;
import me.alvsch.essentialsxlight.EssentialsXLight;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.util.function.Consumer;

public class UpdateChecker {

    private EssentialsXLight plugin;
    private final String repo;

    public UpdateChecker(EssentialsXLight plugin, String repo) {
        this.plugin = plugin;
        this.repo = repo;
    }

    public void getLatestVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            JsonObject jsonObject = null;
            try {
                jsonObject = JsonReader.readJsonFromUrl("https://api.github.com/repos/" + repo + "/releases/latest");
            } catch (IOException e) {
                Bukkit.getLogger().info("Unable To Get New Updates! " + e.getMessage());
            }

            String version = jsonObject.get("tag_name").getAsString();
            consumer.accept(version);

        });
    }

}
