package com.pancake.testmod.effects;

import com.pancake.testmod.TestMod;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EraseEffect extends MobEffect {
    public EraseEffect(MobEffectCategory mobEffectCategory, int color){
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amp){
        
        if(!livingEntity.level.isClientSide()){
            DamageSource erased = new DamageSource(TestMod.MOD_ID + "_erased").bypassArmor();
            
            if(amp >= 19){
                livingEntity.hurt(erased, 20);
            }

            if(livingEntity.getHealth() > livingEntity.getMaxHealth()){
                livingEntity.hurt(erased, (1));
            }
        }
        
        super.applyEffectTick(livingEntity, amp);
    }

    @Override
    public boolean isDurationEffectTick(int dur, int amp){
        return true;
    }

}
