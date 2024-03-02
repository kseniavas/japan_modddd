package org.exampl.japan_mod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RICE_BOWL = new FoodProperties.Builder().nutrition(2).fast().
            saturationMod(0.2f).effect(()-> new MobEffectInstance(MobEffects.HEAL, 2), 0.1f).build();

}
