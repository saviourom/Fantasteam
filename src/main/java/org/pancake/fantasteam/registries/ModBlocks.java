package org.pancake.fantasteam.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.pancake.fantasteam.Fantasteam;
import org.pancake.fantasteam.item.FeatherItem;
import org.pancake.fantasteam.item.WarpTome;

public class ModBlocks {
    public static final DeferredRegister<Block> REGISTRY =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Fantasteam.MODID);

}
