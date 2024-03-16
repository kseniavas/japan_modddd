package org.exampl.japan_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.exampl.japan_mod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class RiceBlock extends CropBlock implements LiquidBlockContainer {
    public static final int MAX_AGE = 2;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public RiceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId(){
        return ModItems.RICE_SEEDS.get();
    }


    @Override
    protected IntegerProperty getAgeProperty(){
        return AGE;
    }

    @Override
    public int getMaxAge(){
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        FluidState fluidStateUP = pLevel.getFluidState(pPos.above(2));
        return pState.is(BlockTags.DIRT) && fluidStateUP.getType() == Fluids.EMPTY;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return fluidstate.is(FluidTags.WATER)&& fluidstate.getAmount()==8 ? super.getStateForPlacement(pContext) : null;
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player player, BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Fluid fluid) {
        return false;
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return Fluids.WATER.getSource(false);
    }

    @Override
    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        return false;
    }
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.below();
        return this.mayPlaceOn(pLevel.getBlockState(blockpos), pLevel, blockpos);
    }


}


