package com.pancake.testmod.item;

import java.util.List;

import com.pancake.testmod.init.EffectInit;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class VoidDropItem extends Item {

    public VoidDropItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        
        if(!world.isClientSide){
            player.addEffect(new MobEffectInstance(EffectInit.ERASE.get(), 10, 20));
        }

        return super.use(world, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack item, Level world, Entity entity, int num, boolean tf) {
        if(!world.isClientSide){

            if(entity instanceof LivingEntity){
                LivingEntity living = (LivingEntity) entity;
                if(!living.hasEffect(EffectInit.ERASE.get()) || Math.floor(1.0475*item.getCount()) >= living.getEffect(EffectInit.ERASE.get()).getAmplifier()){
                    living.addEffect(new MobEffectInstance(EffectInit.ERASE_HELPER.get(), 10, (int)Math.floor(Math.pow(1.0475,item.getCount()))));
                }
            }

        }
        super.inventoryTick(item, world, entity, num, tf);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        if(armorType == EquipmentSlot.HEAD){
            return true;
        }
        return super.canEquip(stack, armorType, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, world, list, flag);
        list.add(new TextComponent("You can feel it pulling at your very essence..."));
    }

}
