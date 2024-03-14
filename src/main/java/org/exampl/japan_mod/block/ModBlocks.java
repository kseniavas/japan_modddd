package org.exampl.japan_mod.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.custom.ModFlammableRotatedPillarBlock;
import org.exampl.japan_mod.block.custom.RiceBlock;
import org.exampl.japan_mod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Japan_mod.MODID);

    public static final RegistryObject<Block> PIJERYS = registerBlock("pijerys",
            () -> new FlowerBlock(MobEffects.HEAL, 1,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> GIBISKUS = registerBlock("gibiskus",
            () -> new FlowerBlock(MobEffects.HEAL, 1,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));


public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log",
            () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_LOG).noOcclusion().noCollission()));

    public static final RegistryObject<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves",
            () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion().noCollission()));

    public static final RegistryObject<Block> RICE = BLOCKS.register("rice",
            () -> new RiceBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));


    public static final RegistryObject<Block> LOTOS = BLOCKS.register("lotos",
            () -> new WaterlilyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.LILY_PAD).noOcclusion().pushReaction(PushReaction.DESTROY)));



    public static  <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    public static <T extends Block> RegistryObject<Item>  registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){

        BLOCKS.register(eventBus);
    }
}
