package me.lucasgithuber.obsidianexpansion.machines;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import lombok.Setter;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.ItemSetting;
import com.github.drakescraft_labs.slimefun4.api.items.settings.IntRangeSetting;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.core.attributes.RecipeDisplayItem;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;
import com.github.drakescraft_labs.slimefun4.legacy.api.inventory.BlockMenu;
import com.github.drakescraft_labs.slimefun4.legacy.api.inventory.BlockMenuPreset;

/**
 * Machines that generate materials at the cost of energy
 *
 * @author Mooy1
 */
public final class VoidObsidianGenerator extends AbstractMachineBlock implements RecipeDisplayItem {

    private static final int[] OUTPUT_SLOTS = { 13 };
    private static final int STATUS_SLOT = 4;

    /**
     * Obsidianas por ciclo. El ciclo corre una vez por tick de Slimefun, que en DrakesCraft es
     * un segundo (URID.custom-ticker-delay = 20), asi que este numero es directamente
     * obsidianas por segundo.
     *
     * Venia en 64: 230.400 a la hora, sin tope de entrada. Con un almacenamiento cuantico
     * infinito detras eso no es una maquina, es una imprenta de dinero -- un jugador junto
     * 85.000 en unos veinte minutos. Se baja a 16, que sigue siendo cuatro veces el generador
     * avanzado y justifica su coste, sin romper la economia.
     *
     * Va como ItemSetting a proposito: aparece en Items.yml y se afina sin recompilar.
     */
    private final ItemSetting<Integer> speedSetting =
            new IntRangeSetting(this, "obsidiana-por-ciclo", 1, 16, 64);

    @Setter
    public Material material = Material.OBSIDIAN;

    public VoidObsidianGenerator(ItemGroup category, SlimefunItemStack item, RecipeType type, ItemStack[] recipe) {
        super(category, item, type, recipe);
        addItemSetting(speedSetting);
    }

    private int getSpeed() {
        return speedSetting.getValue();
    }

    @Override
    protected void setup(@Nonnull BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.drawBackground(new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 14, 15, 16, 17
        });
    }

    @Override
    protected int getStatusSlot() {
        return STATUS_SLOT;
    }

    @Override
    protected int[] getInputSlots() {
        return new int[0];
    }

    @Override
    protected int[] getOutputSlots() {
        return OUTPUT_SLOTS;
    }

    @Override
    public void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {

    }

    @Nonnull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> items = new ArrayList<>();
        items.add(null);
        items.add(new ItemStack(this.material, getSpeed()));
        return items;
    }

    @Nonnull
    @Override
    public String getRecipeSectionLabel(@Nonnull Player p) {
        return "&7Genera";
    }

    @Override
    protected boolean process(@Nonnull Block b, @Nonnull BlockMenu inv) {
        ItemStack output = new ItemStack(this.material, getSpeed());

        if (!inv.fits(output, OUTPUT_SLOTS)) {

            if (inv.hasViewer()) {
                inv.replaceExistingItem(STATUS_SLOT, NO_ROOM_ITEM);
            }
            return false;

        }

        inv.pushItem(output, OUTPUT_SLOTS);

        if (inv.hasViewer()) {
            inv.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.LIME_STAINED_GLASS_PANE, "&aProduciendo..."));
        }

        return true;
    }

}
