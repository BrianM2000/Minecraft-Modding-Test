package com.pancake.testmod.init;

import com.pancake.testmod.TestMod;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID)
public class EventInit {

    @SubscribeEvent
    public static void riseMyMinion(EntityStruckByLightningEvent event){ 
        Level world = event.getEntity().level;
        
        if(!world.isClientSide()){
            ServerLevel server = (ServerLevel) world;

            if(event.getEntity() instanceof ItemEntity){
                ItemEntity item = (ItemEntity) event.getEntity();
                System.out.println(item.getItem().toString());

                if(item.getItem().getItem() == BlockInit.MEAT_BLOCK.get().asItem()){
                    int num = item.getItem().getCount();
                    int i = 0;
                    EntityType<?> type = EntityType.ZOMBIE;
                    
                    for(i = 0; i < num; ++i){

                        double dx = (Math.random() * .25) - .125;
                        double dz = (Math.random() * .25) - .125;
                        
                        type.spawn(server, null, null, event.getEntity().getOnPos(), MobSpawnType.MOB_SUMMONED, true, true)
                        .setDeltaMovement(dx, .5, dz); 
                    }
                }
            }
        }
    }

    /*
    @SubscribeEvent
    public static void testEvent(ItemExpireEvent event){ 
        System.out.println(event.toString());
    }
    */
    
}
