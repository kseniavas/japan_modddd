package org.exampl.japan_mod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.exampl.japan_mod.Japan_mod;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> MODFLOWERS_BIOME_MODIFIER = registerKey("pijerys_biome_modifier");
    public static final ResourceKey<BiomeModifier> ADD_TREE_MAPLE = registerKey("add_tree_maple");
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        context.register(MODFLOWERS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier((biomes.getOrThrow(Tags.Biomes.IS_PLAINS)), HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MODFLOWERS_PLACED_KEY)), GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TREE_MAPLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MAPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
    private static ResourceKey<BiomeModifier> registerKey(String name){
            return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Japan_mod.MODID, name));
    }
}
