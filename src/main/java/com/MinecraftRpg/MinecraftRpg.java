package com.MinecraftRpg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.MinecraftRpg.common.blocks.*;
import com.MinecraftRpg.common.items.*;

@Mod(MinecraftRpg.MODID)
public class MinecraftRpg {
	///////////////////////////
	// public
	///////////////////////////

	// MODID est juste une constante pour ne pas avoir à réécrire l'id du mod
	public static final String MODID = "minecraftrpg";

	// init de log4j pour le débug et la gestion courrante
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	// membre d'initialisation de la classe qui sert de Main à notre mod
	public MinecraftRpg() {
		IEventBus modeEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		initModContext();
		registerItems(modeEventBus);

		// permet d'inscrire le mod dans le registre de minecraft
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	///////////////////////////
	// Private
	///////////////////////////

	private void registerItems(IEventBus modeEventBus){
		///////// ITEMS ////////////
		GoldCoin.register(modeEventBus);
		SilverCoin.register(modeEventBus);
		CopperCoin.register(modeEventBus);
		PressItem.register(modeEventBus);
		SilverOre.register(modeEventBus);
		SilverIngot.register(modeEventBus);

		///////// BLOCKS ////////////
		PressBlocks.register(modeEventBus);
		SilverOreBlock.register(modeEventBus);
		SilverBlock.register(modeEventBus);
	}

	private void initModContext(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
	}

	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("Minecaft Rpg Setup");
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		LOGGER.info("Minecaft Rpg client Setup");
	}

	private void serverSetup(final FMLDedicatedServerSetupEvent event) {
		LOGGER.info("Minecaft Rpg server Setup");
	}
}
