package org.exampl.japan_mod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.exampl.japan_mod.Japan_mod;


import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;

import static org.exampl.japan_mod.block.ModBlocks.LOTOS;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Japan_mod.MODID);

    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            () -> new ItemNameBlockItem(ModBlocks.RICE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            () -> new Item(new Item.Properties()));



    public static final RegistryObject<Item> RICE_BOWL = ITEMS.register("rice_bowl",
            () -> new Item(new Item.Properties().food(ModFoods.RICE_BOWL)));
    public static final RegistryObject<BlockItem> LOTOS = ITEMS.register("lotos", () -> new PlaceOnWaterBlockItem(ModBlocks.LOTOS.get(), new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


