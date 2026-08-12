package me.lucasgithuber.obsidianexpansion.utils;

import io.github.mooy1.infinitylib.common.Scheduler;
import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.core.attributes.NotPlaceable;
import com.github.drakescraft_labs.slimefun4.core.attributes.ProtectionType;
import com.github.drakescraft_labs.slimefun4.core.attributes.ProtectiveArmor;
import com.github.drakescraft_labs.slimefun4.core.attributes.Soulbound;
import com.github.drakescraft_labs.slimefun4.implementation.items.armor.SlimefunArmorPiece;
import me.lucasgithuber.obsidianexpansion.Items;
import me.lucasgithuber.obsidianexpansion.ObsidianExpansion;
import me.lucasgithuber.obsidianexpansion.machines.ObsidianForge;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

import static io.github.mooy1.infinitylib.core.AbstractAddon.log;


public final class Armor extends SlimefunArmorPiece implements ProtectiveArmor, Soulbound, NotPlaceable {

    private static final NamespacedKey KEY = ObsidianExpansion.createKey("obsidian_Helmet");

    public Armor(ItemGroup group, SlimefunItemStack item, PotionEffect[] effects, ItemStack[] recipe, Particle[] particles) {
        super(group, item, ObsidianForge.TYPE, recipe, effects);

    }
    @Nonnull
    @Override
    public ProtectionType[] getProtectionTypes() {
        return new ProtectionType[] {
                ProtectionType.BEES, ProtectionType.RADIATION, ProtectionType.FLYING_INTO_WALL
        };
    }

    @Override
    public boolean isFullSetRequired() {
        return false;
    }

    @Nonnull
    @Override
    public NamespacedKey getArmorSetId() {
        return KEY;
    }

}