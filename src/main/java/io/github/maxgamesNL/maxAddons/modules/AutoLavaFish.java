package io.github.maxgamesNL.maxAddons.modules;

import io.github.maxgamesNL.maxAddons.MaxAddons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFishWakeFX;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.Collections;

public class AutoLavaFish {

    Minecraft mc = Minecraft.getMinecraft();
    int tickCounter = 0;
    int postThrowCounter= 0;


    @SubscribeEvent
    public void onTick(net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent e) {
        if(!e.side.isClient()) return;
        if (!MaxAddons.moduleManager.AutoLavaFishToggled) return;

        //check if in crystal hollows
        //if(!mc.ingameGUI.getTabList().toString().contains("Lava Fish")) {return;}

        if(e.player.getCurrentEquippedItem() != null && e.player.getCurrentEquippedItem().getItem() == Items.fishing_rod && e.player.fishEntity != null) {
            postThrowCounter++;
            System.out.println("Currently fishing with counter at: " + postThrowCounter);


            if(postThrowCounter > 80){
                if(!(e.player.fishEntity.isInLava() || e.player.fishEntity.isInWater())) {
                    mc.playerController.sendUseItem(e.player, mc.theWorld, mc.thePlayer.getCurrentEquippedItem());
                }else if(e.player.fishEntity.lastTickPosY > e.player.fishEntity.posY + 0.05) {
                    mc.playerController.sendUseItem(e.player, mc.theWorld, mc.thePlayer.getCurrentEquippedItem());
                }



            }

            return;
        }
        ArrayList<ItemStack> inv = new ArrayList<ItemStack>();
        Collections.addAll(inv, e.player.inventory.mainInventory);
        for (ItemStack item : inv) {
            if(item == null) {
                continue;
            }
            if (item.getUnlocalizedName().equals("item.fishingRod")) {
                if(inv.indexOf(item) < 9) {
                    e.player.inventory.currentItem = inv.indexOf(item);
                }

                if (e.player.getHeldItem().getUnlocalizedName().equals("item.fishingRod")) {
                    if(e.player.fishEntity == null) {
                        if (tickCounter >= 1) {
                            if(tickCounter >= 10) {
                                tickCounter = 0;
                            }else {
                                tickCounter++;
                            }
                        }else {
                            tickCounter++;
                            mc.playerController.sendUseItem(e.player, e.player.worldObj, item);
                            postThrowCounter = 0;
                        }
                    }

                }

            }
        }


    }


}
