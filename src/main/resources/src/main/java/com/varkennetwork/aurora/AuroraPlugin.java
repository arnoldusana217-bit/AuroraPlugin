package com.varkennetwork.aurora;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AuroraPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Registrar eventos del servidor
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info(color("&a[VARKEN NETWORK] ¡Plugin Aurora cargado correctamente en Paper!"));
    }

    @Override
    public void onDisable() {
        getLogger().info(color("&c[VARKEN NETWORK] Plugin Aurora desactivado."));
    }

    // Evento al entrar un jugador
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        // Mensaje global de entrada
        event.setJoinMessage(color("&8[&a+&8] &f" + player.getName() + " &7ha ingresado a &bVARKEN NETWORK"));
        
        // Mensaje privado al jugador
        player.sendMessage(color("&e&l--------------------------------------"));
        player.sendMessage(color("&a&l¡Bienvenido/a a VARKEN NETWORK, " + player.getName() + "!"));
        player.sendMessage(color("&7Disfruta tu estancia en el servidor."));
        player.sendMessage(color("&e&l--------------------------------------"));
    }

    // Comando /varken
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("varken")) {
            if (sender instanceof Player player) {
                player.sendMessage(color("&b&l[VARKEN NETWORK] &fServidor de Minecraft activo y optimizado en Paper."));
            } else {
                sender.sendMessage("Comando ejecutado desde la consola de VARKEN NETWORK.");
            }
            return true;
        }
        return false;
    }

    // Método auxiliar para códigos de color (&)
    private String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
