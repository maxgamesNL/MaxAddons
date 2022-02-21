package io.github.maxgamesNL.maxAddons.modules;

import io.github.maxgamesNL.maxAddons.MaxAddons;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.Collections;

public class AutoLavaFish {

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
                System.out.println("item is null");
                continue;
            }
            System.out.println(item.getUnlocalizedName() + " " + inv.indexOf(item));
            if (item.getUnlocalizedName().equals("item.fishingRod")) {
                if (e.player.getHeldItem().equals(Items.fishing_rod)) {
                    continue;
                }
                System.out.println("fishing rod found " + inv.indexOf(item));
                e.player.inventory.currentItem = inv.indexOf(item);

            }
        }


    }

}
