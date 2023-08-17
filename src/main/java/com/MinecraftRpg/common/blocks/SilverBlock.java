package com.MinecraftRpg.common.blocks;

import com.MinecraftRpg.MinecraftRpg;
import com.MinecraftRpg.common.items.PressItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = MinecraftRpg.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SilverBlock {


    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftRpg.MODID);

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(0.5f).requiresCorrectToolForDrops()),
        null);

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return PressItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    } 
}