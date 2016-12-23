package net.hchayburn.gamemodeselector;

import net.hchayburn.gamemodeselector.commands.SwitchCommand;
import net.hchayburn.gamemodeselector.listeners.GamemodeSwitch;
import org.bukkit.plugin.java.JavaPlugin;

public class GamemodeSelector extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GamemodeSwitch(), this);
        getCommand("switch").setExecutor(new SwitchCommand());
    }
}
