package com.MinecraftRpg.common.items;

import com.MinecraftRpg.MinecraftRpg;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MinecraftRpg.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SilverOre {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftRpg.MODID);

    public static final RegistryObject<Item> GOLDCOIN = ITEMS.register("silver_ore", 
        () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    } 
}
