package org.pancake.fantasteam;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.pancake.fantasteam.entities.renderer.SpinProjectileRenderer;
import org.pancake.fantasteam.registries.ModBlocks;
import org.pancake.fantasteam.registries.ModCreativeModeTabs;
import org.pancake.fantasteam.registries.ModEntities;
import org.pancake.fantasteam.registries.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Fantasteam.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Fantasteam {

	// Define mod id in a common place for everything to reference
	public static final String MODID = "fantasteam";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();


	public Fantasteam() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);


		ModItems.REGISTRY.register(modEventBus);
		ModCreativeModeTabs.REGISTRY.register(modEventBus);
		ModBlocks.REGISTRY.register(modEventBus);
		ModEntities.REGISTRY.register(modEventBus);

		// Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
		//ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event)
	{
		EntityRenderers.register(ModEntities.VASTAYAN_FEATHER.get(), SpinProjectileRenderer::new);
	}
}
