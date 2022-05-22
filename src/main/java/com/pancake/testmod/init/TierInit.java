package com.pancake.testmod.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TierInit {
    public static final ForgeTier VOID = new ForgeTier(5, 4096, 20.0f, 5f, 1, BlockTags.NEEDS_DIAMOND_TOOL, 
    () -> Ingredient.of(ItemInit.VOID_DROP.get()));
}
