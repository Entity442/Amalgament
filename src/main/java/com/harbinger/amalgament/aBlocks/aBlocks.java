package com.harbinger.amalgament.aBlocks;

import com.harbinger.amalgament.aBlocks.custom.AmalgaSpread;
import com.harbinger.amalgament.aCore.aCreativeTabs;
import com.harbinger.amalgament.aItems.aItems;
import com.harbinger.amalgament.amalgament;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class aBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, amalgament.MOD_ID);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;}
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        aItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(aCreativeTabs.AMALGA)));}
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);}
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }


    public static final RegistryObject<Block> AMALGAM = registerBlock("amalgam",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(2f ,2f)));
    public static final RegistryObject<Block> AMALGAM_SPREAD = registerBlock("amalgam_spread",
            AmalgaSpread::new);


}
