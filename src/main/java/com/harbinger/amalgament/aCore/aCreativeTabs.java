package com.harbinger.amalgament.aCore;

import com.harbinger.amalgament.aItems.aItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class aCreativeTabs {
    public static final CreativeModeTab AMALGA = new CreativeModeTab("amalga") {
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(aItems.GLUTTON_SPAWN_EGG.get());
    }
};
}

