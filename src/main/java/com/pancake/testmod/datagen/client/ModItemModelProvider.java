package com.pancake.testmod.datagen.client;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import com.pancake.testmod.TestMod;
import com.pancake.testmod.init.BlockInit;
import com.pancake.testmod.init.ItemInit;

public class ModItemModelProvider extends ItemModelProvider{

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TestMod.MOD_ID, existingFileHelper);

    }

    protected void simpleBlockItem(Item item){
        getBuilder(item.getRegistryName().toString()).parent(getExistingFile(modLoc("block/" + item.getRegistryName().getPath())));
    }

    protected void oneLayerItem(Item item, ResourceLocation texture){
        ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
        if(existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")){
            getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", itemTexture);
        }
        else{
            System.out.println("Missing texture for " + item.getRegistryName().toString() + " at " + itemTexture.toString());
        }
    }

    protected void oneLayerItem(Item item){
        oneLayerItem(item, item.getRegistryName());
    }

    @Override
    protected void registerModels() {
        simpleBlockItem(BlockInit.EXAMPLE_BLOCK.get().asItem());
        simpleBlockItem(BlockInit.MEAT_BLOCK.get().asItem());
        oneLayerItem(ItemInit.VOID_DROP.get());
    }
    
}
