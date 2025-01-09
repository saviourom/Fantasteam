package org.pancake.fantasteam.registries;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.pancake.fantasteam.Fantasteam;
import org.pancake.fantasteam.entities.FeatherProjectile;

import java.util.function.UnaryOperator;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Fantasteam.MODID);

    private static <T extends Entity> RegistryObject <EntityType<T>> register(String key, EntityType.EntityFactory<T> factory, MobCategory category, UnaryOperator<EntityType.Builder<T>> params)
    {
        return REGISTRY.register(key, () -> params.apply(EntityType.Builder.of(factory, category))
                .build(key));
    }
    public static final RegistryObject<EntityType<FeatherProjectile>> VASTAYAN_FEATHER = register("vastayan_feather", FeatherProjectile::new, MobCategory.MISC, featherProjectileBuilder -> featherProjectileBuilder.sized(0.25f,0.25f));
}
