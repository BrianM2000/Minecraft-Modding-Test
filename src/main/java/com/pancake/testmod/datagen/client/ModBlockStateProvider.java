package com.pancake.testmod.datagen.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import com.pancake.testmod.TestMod;
import com.pancake.testmod.init.BlockInit;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TestMod.MOD_ID, exFileHelper);
        
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockInit.MEAT_BLOCK.get());
        simpleBlock(BlockInit.EXAMPLE_BLOCK.get());
    }

}
