package com.pancake.testmod.effects;

import com.pancake.testmod.init.EffectInit;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class EraseHelpEffect extends MobEffect {

    public EraseHelpEffect(MobEffectCategory mobEffectCategory, int color){
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amp){
         
        if(!livingEntity.level.isClientSide()){
            
            if(livingEntity.tickCount % 4 == 0){
                if(livingEntity.getHealth() > 21 - amp){
                    livingEntity.setHealth(livingEntity.getHealth() - 1);
                }
                else{
                    livingEntity.addEffect(new MobEffectInstance(EffectInit.ERASE.get(), 10, amp));
                }

            }
        }
        
        super.applyEffectTick(livingEntity, amp);
    }

    @Override
    public boolean isDurationEffectTick(int dur, int amp){
        return true;
    }

}
