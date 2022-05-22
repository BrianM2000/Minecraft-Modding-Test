package com.pancake.testmod.init;

import com.pancake.testmod.TestMod;
import com.pancake.testmod.block.ExampleBlock;

import java.util.function.Function;

import com.google.common.base.Supplier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TestMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

	public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block",
			() -> new ExampleBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(2.0f)
					.sound(SoundType.METAL).requiresCorrectToolForDrops().emissiveRendering((state, getter, pos) -> {
						return true;
					}).lightLevel(state -> 5)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TestMod.TEST_TAB)));

	public static final RegistryObject<Block> MEAT_BLOCK = register("block_of_meat", 
			() -> new Block(BlockBehaviour.Properties.of(Material.EGG, MaterialColor.COLOR_GREEN).strength(1.0f).sound(SoundType.SLIME_BLOCK)), 
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TestMod.TEST_TAB).
			food(new FoodProperties.Builder().nutrition(20).saturationMod(1.0f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,100,0), 1f).build())));

	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name,
			final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}