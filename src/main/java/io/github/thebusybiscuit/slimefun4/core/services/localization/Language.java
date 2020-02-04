package io.github.thebusybiscuit.slimefun4.core.services.localization;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.cscorelib2.skull.SkullItem;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;

public final class Language {

    private final String id;
    private final ItemStack item;
    private double progress = 100.0;

    private FileConfiguration messages;
    private FileConfiguration researches;

    public Language(String id, String hash) {
        this.id = id;

        item = SkullItem.fromHash(hash);
        SlimefunPlugin.getItemTextureService().setTexture(item, "_UI_LANGUAGE_" + id.toUpperCase());
    }

    public String getID() {
        return id;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public FileConfiguration getMessages() {
        return messages;
    }

    public FileConfiguration getResearches() {
        return researches;
    }

    public void setMessages(FileConfiguration config) {
        this.messages = config;
    }

    public void setResearches(FileConfiguration config) {
        this.researches = config;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getName(Player p) {
        return SlimefunPlugin.getLocal().getMessage(p, "languages." + id);
    }

    public boolean isDefault() {
        return this == SlimefunPlugin.getLocal().getDefaultLanguage();
    }

}