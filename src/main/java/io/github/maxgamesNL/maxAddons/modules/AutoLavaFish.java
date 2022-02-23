package io.github.maxgamesNL.maxAddons.modules;

import io.github.maxgamesNL.maxAddons.MaxAddons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.Collections;

public class AutoLavaFish {

    Minecraft mc = Minecraft.getMinecraft();
    int tickCounter = 0;

    @SubscribeEvent
    public void onTick(net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent e) {
        if(!e.side.isClient()) return;
        if (!MaxAddons.moduleManager.AutoLavaFishToggled) return;

        //check if in crystal hollows
        //if(!mc.ingameGUI.getTabList().toString().contains("Lava Fish")) {return;}
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
                        }
                    }

                }

            }
        }


    }

}
