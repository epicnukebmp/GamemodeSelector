package com.sgerlyn.gamemodeselector;

import com.sgerlyn.gamemodeselector.commands.SwitchCommand;
import com.sgerlyn.gamemodeselector.listeners.GamemodeSwitch;
import org.bukkit.plugin.java.JavaPlugin;

public class GamemodeSelector extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GamemodeSwitch(), this);
        getCommand("switch").setExecutor(new SwitchCommand());
    }
}
