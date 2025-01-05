package org.pancake.fantasteam.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.pancake.fantasteam.item.ModItems;

public class FeatherProjectile extends ThrowableItemProjectile {
    public FeatherProjectile(EntityType<FeatherProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public FeatherProjectile(Level pLevel, Player pPlayer) {
        super(ModEntities.VASTAYAN_FEATHER.get(),pLevel);
        setOwner(pPlayer);
        setPos(pPlayer.getEyePosition());
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        pResult.getEntity().hurt(damageSources().thrown(this, getOwner()),Math.max(7-tickCount/3f, 1));
        super.onHitEntity(pResult);
    }



    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        discard();
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.VASTAYAN_FEATHER.get();
    }
}
