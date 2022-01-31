package io.github.maxgamesNL.skyBlockBest.modules;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerInteractEvent {


    @SubscribeEvent
    public void rightClick(net.minecraftforge.event.entity.player.PlayerInteractEvent e){
        System.out.println(" click");
        if(e.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
            if(e.entityPlayer.getCurrentEquippedItem() == null){return;}
                if(e.entityPlayer.getCurrentEquippedItem().getItem().getRegistryName().equals("minecraft:golden_pickaxe")){
                    System.out.println("right click");
                    e.world.setBlockToAir(e.pos);
                    e.setCanceled(true);
                }

        }

    }
}
