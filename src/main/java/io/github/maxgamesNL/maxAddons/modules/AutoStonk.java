package io.github.maxgamesNL.maxAddons.modules;

import io.github.maxgamesNL.maxAddons.MaxAddons;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoStonk {


    @SubscribeEvent
    public void rightClick(net.minecraftforge.event.entity.player.PlayerInteractEvent e){

        if (e.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            if(!MaxAddons.moduleManager.StonkToggled){
                return;
            }
            if (e.entityPlayer.getCurrentEquippedItem() == null) {
                return;
            }

            if (e.world.isRemote) {
                if (e.entityPlayer.getCurrentEquippedItem().getItem().getRegistryName().equals("minecraft:golden_pickaxe")) {
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.chest)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.lever)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.redstone_torch)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.stone_button)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.wooden_button)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.skull)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.coal_block)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.command_block)) {
                        return;
                    }
                    if (e.world.getBlockState(e.pos).getBlock().equals(Blocks.trapped_chest)) {
                        return;
                    }
                    e.world.setBlockToAir(e.pos);
                    e.setCanceled(true);
                }
            }
        }

    }
}
