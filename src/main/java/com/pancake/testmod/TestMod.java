package com.pancake.testmod;

import com.pancake.testmod.init.*;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("testmod")
public class TestMod {

    public static final String MOD_ID = "testmod"; 

    public static final CreativeModeTab TEST_TAB = new CreativeModeTab(MOD_ID){

        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.VOID_DROP.get());
        }
    };

    public TestMod(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        FluidInit.FLUIDS.register(bus);

        EffectInit.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

}
