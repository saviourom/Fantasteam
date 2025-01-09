package org.pancake.fantasteam.item;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class WarpTome extends Item {
    public WarpTome(Properties pProperties) {
        super(pProperties);
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.getOrCreateTag().hasUUID("faust_target"))
        {
            if(!level.isClientSide())
            {
                UUID targetUuid = stack.getTag().getUUID("faust_target");
                ServerPlayer targetPlayer = level.getServer().getPlayerList().getPlayer(targetUuid);

                if (targetPlayer != null)
                {
                    if(!player.level().equals(targetPlayer.level()))
                        player.changeDimension((ServerLevel) targetPlayer.level());
                    player.teleportTo(targetPlayer.getX(), targetPlayer.getY(), targetPlayer.getZ());
                    player.displayClientMessage(Component.literal("squirrel"),false);
                } else return super.use(level, player, hand);
            }

        } else stack.getTag().putUUID("faust_target", player.getUUID());

        return InteractionResultHolder.success(stack);

    }
}
