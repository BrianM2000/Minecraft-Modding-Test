package com.pancake.testmod.block;

import java.util.function.Supplier;

import com.pancake.testmod.init.EffectInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class VoidLiquidBlock extends LiquidBlock{
    public VoidLiquidBlock(Supplier<? extends FlowingFluid> p_54694_, Properties p_54695_) {
        super(p_54694_, p_54695_);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if(!world.isClientSide){
            if(entity instanceof LivingEntity){
                LivingEntity livingEntity = (LivingEntity) entity;

                int amp = 0;

                if(livingEntity.getActiveEffects().contains(livingEntity.getEffect(EffectInit.ERASE_HELPER.get()))
                 && livingEntity.tickCount % 20 == 0){
                    amp = livingEntity.getEffect(EffectInit.ERASE_HELPER.get()).getAmplifier() + 1;
                }

                livingEntity.addEffect(new MobEffectInstance(EffectInit.ERASE_HELPER.get(), 40, amp));
            }
        }
        super.entityInside(state, world, pos, entity);
    }

}
