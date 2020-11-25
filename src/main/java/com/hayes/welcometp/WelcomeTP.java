package com.hayes.welcometp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WelcomeTP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Load config
        this.getConfig().addDefault("spawn.x", 0);
        this.getConfig().addDefault("spawn.y", 0);
        this.getConfig().addDefault("spawn.z", 0);
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Register Events
        Bukkit.getPluginManager().registerEvents(this, this);
        // Display to console
        System.out.println("WelcomeTP has initialized");
    }

    @Override
    public void onDisable() {
        // Display to console
        System.out.println("WelcomeTP has uninitialized");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        // Get player
        Player player = e.getPlayer();
        // Broadcast Message
        Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "WelcomeTP" + ChatColor.GRAY + " - Welcome" + player.getName() + " to MK-Test!");
        // Fetch values from Config
        double x = this.getConfig().getInt("spawn.x");
        double y = this.getConfig().getInt("spawn.y");
        double z = this.getConfig().getInt("spawn.z");
        // Create new Spawn Location
        Location spawnLoc = new Location(player.getWorld(), x, y, z);
        // Teleport the player
        player.teleport(spawnLoc);
    }

}
