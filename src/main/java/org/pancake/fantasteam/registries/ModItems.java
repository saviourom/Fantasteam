package org.pancake.fantasteam.registries;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.pancake.fantasteam.Fantasteam;
import org.pancake.fantasteam.item.FeatherItem;
import org.pancake.fantasteam.item.WarpTome;

public class ModItems {
    public static final DeferredRegister<Item> REGISTRY =
            DeferredRegister.create(ForgeRegistries.ITEMS, Fantasteam.MODID);

    public static final RegistryObject<Item> SOLID_LUCK = REGISTRY.register("solid_luck",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LUNAR_LAMP = REGISTRY.register("lunar_lamp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VASTAYAN_FEATHER = REGISTRY.register("vastayan_feather",
            () -> new FeatherItem(new Item.Properties()));

    public static final RegistryObject<Item> WARP_TOME = REGISTRY.register("warp_tome",
            () -> new WarpTome(new Item.Properties()));
}
