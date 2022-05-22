package com.pancake.testmod.init;

import com.pancake.testmod.TestMod;
import com.pancake.testmod.block.VoidLiquidBlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidInit {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, TestMod.MOD_ID);


    public static final RegistryObject<FlowingFluid> VOID_FLUID
            = FLUIDS.register("void_fluid", () -> new ForgeFlowingFluid.Source(FluidInit.VOID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> VOID_FLOWING
            = FLUIDS.register("void_flowing", () -> new ForgeFlowingFluid.Flowing(FluidInit.VOID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties VOID_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> VOID_FLUID.get(), () -> VOID_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .overlay(WATER_OVERLAY_RL).color(4522069))
            .slopeFindDistance(10).levelDecreasePerBlock(1)
            .block(() -> FluidInit.VOID_FLUID_BLOCK.get()).bucket(() -> ItemInit.VOID_BUCKET.get());

    public static final RegistryObject<LiquidBlock> VOID_FLUID_BLOCK = BlockInit.BLOCKS.register("void_fluid_block",
            () -> new VoidLiquidBlock(() -> FluidInit.VOID_FLUID.get(), 
            BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F, 100.0F).noDrops().speedFactor(0.50F)));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
