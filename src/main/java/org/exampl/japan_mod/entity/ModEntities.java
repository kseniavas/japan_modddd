package org.exampl.japan_mod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.entity.custom.FireflyEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Japan_mod.MODID);

    public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY =
            ENTITY_TYPES.register("firefly", ()-> EntityType.Builder.of(FireflyEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("firefly"));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}

