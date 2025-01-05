package org.pancake.fantasteam.item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.pancake.fantasteam.entities.FeatherProjectile;


public class FeatherItem extends Item {
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide) {
            FeatherProjectile $$4 = new FeatherProjectile(pLevel, pPlayer);
            $$4.setItem(itemStack);
            $$4.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.0F, 0.0F);
            pLevel.addFreshEntity($$4);
        }

        pPlayer.getCooldowns().addCooldown(this,15);

        pPlayer.awardStat(Stats.ITEM_USED.get(this));

        return new InteractionResultHolder<>(InteractionResult.SUCCESS,itemStack);


    }

    public FeatherItem(Properties pProperties) {
        super(pProperties);
    }
}
