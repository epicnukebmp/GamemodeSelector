package net.hchayburn.gamemodeselector.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SwitchCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Inventory inventory = Bukkit.createInventory(null, 27, "Gamemode Selector");
        ItemStack sword = craftItem(Material.DIAMOND_SWORD, ChatColor.RED + "Survival");
        ItemStack spawner = craftItem(Material.MOB_SPAWNER, ChatColor.BLUE + "Creative");

        inventory.setItem(11, spawner);
        inventory.setItem(13, sword);
        ((Player) sender).openInventory(inventory);
        return true;
    }

    private ItemStack craftItem(Material item, String name) {
        return createItem(new ItemStack(item), name);
    }

    private ItemStack createItem(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}
