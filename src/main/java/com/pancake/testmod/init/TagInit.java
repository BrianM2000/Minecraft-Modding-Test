package com.pancake.testmod.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import com.pancake.testmod.TestMod;

public final class TagInit {
    
    public static final class Blocks {
		
		private static TagKey<Block> mod(String path) {
			return BlockTags.create(new ResourceLocation(TestMod.MOD_ID, path));
		}
		
	}

    public static final class Items {
		
		public static final TagKey<Item> MEATS = mod("meats");
		
		
		private static TagKey<Item> mod(String path) {
			return ItemTags.create(new ResourceLocation(TestMod.MOD_ID, path));
		}
		
	}

}
