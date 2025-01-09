package org.pancake.fantasteam.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.pancake.fantasteam.Fantasteam;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fantasteam.MODID);

    public static final RegistryObject<CreativeModeTab> PANCAKE_TAB = REGISTRY.register("pancake_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SOLID_LUCK.get()))
                    .title(Component.translatable("creativetab.pancake_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SOLID_LUCK.get());
                        output.accept(ModItems.VASTAYAN_FEATHER.get());
                        output.accept(ModItems.WARP_TOME.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
