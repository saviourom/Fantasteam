package org.pancake.fantasteam.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.pancake.fantasteam.Fantasteam;
import org.pancake.fantasteam.entities.ModEntities;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Fantasteam.MODID);

    public static final RegistryObject<Item> SOLID_LUCK = ITEMS.register("solid_luck",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VASTAYAN_FEATHER = ITEMS.register("vastayan_feather",
            () -> new FeatherItem(new Item.Properties()));

    public static final RegistryObject<Item> WARP_TOME = ITEMS.register("warp_tome",
            () -> new WarpTome(new Item.Properties()));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
        ModEntities.ENTITIES.register(eventBus);
    }
}
