package com.pancake.testmod.init;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.pancake.testmod.TestMod;
import com.pancake.testmod.item.*;

public class ItemInit{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> VOID_DROP = register("void_drop", 
    () -> new VoidDropItem(new Item.Properties().tab(TestMod.TEST_TAB)));

    public static final RegistryObject<Item> VOID_PICKAXE = register("void_pickaxe",
    () -> new VoidPickaxeItem(TierInit.VOID, 1, -3.0f, new Item.Properties().tab(TestMod.TEST_TAB))); //bonus damage, bonus speed

    public static final RegistryObject<Item> VOID_BUCKET = register("void_bucket", 
    () -> new BucketItem(() -> FluidInit.VOID_FLUID.get(), new Item.Properties().tab(TestMod.TEST_TAB).stacksTo(1)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }
}
