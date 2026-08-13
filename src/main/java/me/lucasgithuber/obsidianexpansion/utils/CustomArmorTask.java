package me.lucasgithuber.obsidianexpansion.utils;

import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Renders the complete Obsidian armor aura without creating nested scheduler tasks. */
public final class CustomArmorTask extends BukkitRunnable {
    private static final double RADIUS = 1.5;
    private static final double HEIGHT_OFFSET = 0.4;
    private static final int WAVES = 6;
    private static final int DEGREES_PER_RUN = 12;

    private final Map<UUID, Integer> degrees = new HashMap<>();

    @Override
    public void run() {
        degrees.keySet().removeIf(uuid -> Bukkit.getPlayer(uuid) == null);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.isValid() || player.isDead() || !wearsCompleteSet(player)) {
                degrees.remove(player.getUniqueId());
                continue;
            }

            int degree = degrees.getOrDefault(player.getUniqueId(), 0);
            double radians = Math.toRadians(degree);
            double x = Math.cos(radians) * RADIUS;
            double y = Math.sin(radians * WAVES) * HEIGHT_OFFSET + 1.0;
            double z = Math.sin(radians) * RADIUS;
            Location particleLocation = player.getLocation().add(x, y, z);

            player.getWorld().spawnParticle(Particle.END_ROD, particleLocation, 1, 0, 0, 0, 0);
            degrees.put(player.getUniqueId(), (degree + DEGREES_PER_RUN) % 360);
        }
    }

    private static boolean wearsCompleteSet(Player player) {
        return isArmor(player.getInventory().getHelmet())
            && isArmor(player.getInventory().getChestplate())
            && isArmor(player.getInventory().getLeggings())
            && isArmor(player.getInventory().getBoots());
    }

    private static boolean isArmor(ItemStack stack) {
        return SlimefunItem.getByItem(stack) instanceof Armor;
    }
}
