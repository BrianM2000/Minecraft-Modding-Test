package com.pancake.testmod.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.pancake.testmod.TestMod;
import com.pancake.testmod.effects.EraseEffect;
import com.pancake.testmod.effects.EraseHelpEffect;

public class EffectInit {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TestMod.MOD_ID);

    public static final RegistryObject<MobEffect> ERASE = MOB_EFFECTS.register("erasure", 
    () -> new EraseEffect(MobEffectCategory.HARMFUL, 4522069)
    .addAttributeModifier(Attributes.MAX_HEALTH, "c9d31fdd-dcb6-47e3-8772-a88deb904e6e", -1.0D, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> ERASE_HELPER = MOB_EFFECTS.register("erasure_helper",
     () -> new EraseHelpEffect(MobEffectCategory.HARMFUL, 4522069));

    public static void register(IEventBus bus){
        MOB_EFFECTS.register(bus);
    }

}
