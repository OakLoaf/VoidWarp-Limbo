package org.lushplugins.voidwarplimbo.listener;

import com.loohp.limbo.events.EventHandler;
import com.loohp.limbo.events.Listener;
import com.loohp.limbo.events.player.PlayerMoveEvent;
import com.loohp.limbo.player.Player;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.lushplugins.voidwarplimbo.VoidWarpLimbo;
import org.lushplugins.voidwarplimbo.config.ConfigManager;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerMove(@NotNull PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("voidwarp.admin.bypass")) {
            return;
        }

        ConfigManager configManager = VoidWarpLimbo.getInstance().getConfigManager();
        double currYHeight = player.getLocation().getY();
        if (currYHeight <= configManager.getMinY() || currYHeight >= configManager.getMaxY()) {
            return;
        }

        player.teleport(configManager.getSpawnLocation());
        player.sendActionBar(Component.text(ChatColor.translateAlternateColorCodes('&', configManager.getMessage()
            .replace("%location%", "Spawn"))));
    }
}
