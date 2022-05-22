package com.pancake.testmod.item;

import com.pancake.testmod.init.EffectInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class VoidPickaxeItem extends PickaxeItem {

    public VoidPickaxeItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void inventoryTick(ItemStack item, Level world, Entity entity, int num, boolean tf) {
        if(!world.isClientSide && entity instanceof LivingEntity){
            LivingEntity livingEntity = (LivingEntity) entity;
            if(livingEntity.getMainHandItem().equals(item, false) || livingEntity.getOffhandItem().equals(item, false)){
                livingEntity.addEffect(new MobEffectInstance(EffectInit.ERASE_HELPER.get(), 4, 5));
            }
        }
        super.inventoryTick(item, world, entity, num, tf);
    }
    
}
