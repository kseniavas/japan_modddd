package org.exampl.japan_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Japan_mod.MODID);
    public static final RegistryObject<CreativeModeTab> JAPAN_MOD_TAB = CREATIVE_TAB.register("japan_mod_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RICE_BOWL.get())).title(Component.translatable("creative_tab_japan_mod")).displayItems((pDisplayParameters, pItemOutput) -> {
        pItemOutput.accept(ModItems.LOTOS.get());
        pItemOutput.accept(ModBlocks.PIJERYS.get());
        pItemOutput.accept(ModBlocks.GIBISKUS.get());
        pItemOutput.accept(ModBlocks.MAPLE_LOG.get());
        pItemOutput.accept(ModBlocks.MAPLE_LEAVES.get());
        pItemOutput.accept(ModItems.RICE.get());
        pItemOutput.accept(ModItems.RICE_SEEDS.get());
        pItemOutput.accept(ModItems.RICE_BOWL.get());
    }).build());
    public static void register(IEventBus eventBus){
        CREATIVE_TAB.register(eventBus);
    }
}
