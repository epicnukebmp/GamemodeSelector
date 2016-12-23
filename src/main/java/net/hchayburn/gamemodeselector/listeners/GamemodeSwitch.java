package net.hchayburn.gamemodeselector.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GamemodeSwitch implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (!(inventory.getTitle() == "Gamemode Selector")) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (item.getType() == Material.MOB_SPAWNER) {
            if (player.hasPermission("selector.creative")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.GREEN + "Your gamemode has been swapped to creative!");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have the required permission to do this!");
            }
        } else if (item.getType() == Material.DIAMOND_SWORD) {
            if (player.hasPermission("selector.survival")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.GREEN + "Your gamemode has been swapped to survival!");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have the required permission to do this!");
            }
        }
        event.setCancelled(true);
        player.closeInventory();
    }
}
