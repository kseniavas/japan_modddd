package org.exampl.japan_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.entity.ModEntities;
import org.exampl.japan_mod.entity.client.FireflyRenderer;
import org.exampl.japan_mod.entity.custom.FireflyEntity;
import org.exampl.japan_mod.item.ModCreativeTabs;
import org.exampl.japan_mod.item.ModItems;
import org.slf4j.Logger;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static net.minecraft.core.registries.Registries.ENTITY_TYPE;
import static org.exampl.japan_mod.entity.ModEntities.ENTITY_TYPES;
import static org.exampl.japan_mod.entity.ModEntities.FIREFLY;
import org.exampl.japan_mod.entity.ModEntities.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Japan_mod.MODID)
public class Japan_mod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "japanmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "japan_mod" namespace


    public Japan_mod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);

        ModEntities.register(modEventBus);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.PIJERYS);
        }

        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.GIBISKUS);
        }

        if(event.getTabKey()==CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.RICE_SEEDS);
        }


        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModItems.RICE);
        }

        if(event.getTabKey()==CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.RICE_BOWL);

        }
        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.LOTOS);

        }
        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.MAPLE_LOG);
        }
        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.MAPLE_LEAVES);
        }
        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.MAPLE_WOOD);
        }
        if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.MAPLE_SAPLING);
        }

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.FIREFLY.get(), FireflyRenderer::new);
        }
    }
}
