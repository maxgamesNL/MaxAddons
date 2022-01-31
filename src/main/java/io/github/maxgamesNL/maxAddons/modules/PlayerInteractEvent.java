package io.github.maxgamesNL.maxAddons.modules;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerInteractEvent {


    @SubscribeEvent
    public void rightClick(net.minecraftforge.event.entity.player.PlayerInteractEvent e){
        System.out.println(" click");
        if(e.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
            System.out.println("right click");
            if(e.entityPlayer.getCurrentEquippedItem() == null){return;}
            if(e.world.isRemote){
                if(e.entityPlayer.getCurrentEquippedItem().getItem().getRegistryName().equals("minecraft:golden_pickaxe")){
                    if(e.world.getBlockState(e.pos).getBlock().equals(Blocks.chest)){return;}

                    e.world.setBlockToAir(e.pos);
                    e.setCanceled(true);
                }
            }
        }

    }
}
