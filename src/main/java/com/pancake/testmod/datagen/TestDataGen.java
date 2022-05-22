package com.pancake.testmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import com.pancake.testmod.TestMod;
import com.pancake.testmod.datagen.client.ModBlockStateProvider;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Bus.MOD)
public class TestDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if(event.includeClient()){
            gen.addProvider(new ModBlockStateProvider(gen, helper));
        }
        if(event.includeServer()){
            
        }
    }
    
}
