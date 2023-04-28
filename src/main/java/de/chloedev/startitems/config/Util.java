package de.chloedev.startitems.config;

import de.chloedev.startitems.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<ItemStack> getStartItems() {
        FileConfiguration config = Main.getInstance().getConfig();
        List<ItemStack> items = new ArrayList<>();
        config.getStringList("items").forEach(s -> {
            Material m = Material.getMaterial(s.split(":")[0].toUpperCase());
            if (m != null) {
                try {
                    items.add(new ItemStack(m, Integer.parseInt(s.split(":")[1])));
                } catch (NumberFormatException e) {
                    System.out.println("INVALID ENTRY 1: " + s);
                }
            } else {
                System.out.println("INVALID ENTRY 2: " + s);
            }
        });
        return items;
    }
}