package org.exampl.japan_mod.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.worldgen.tree.custom.MapleTrunkPlacer;


public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Japan_mod.MODID);

    public static final RegistryObject<TrunkPlacerType<MapleTrunkPlacer>> MAPLE_TRUNK_PLACER =
            TRUNK_PLACER.register("maple_trunk_placer", () -> new TrunkPlacerType<>(MapleTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
