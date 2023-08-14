package dev.justdrven.flysystem;

import dev.justdrven.commands.Fly;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlySystem extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.getCommand("fly").setExecutor(new Fly(this));
    }

    public String getMessage(String messageID){
        return ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages." + messageID));
    }

}
