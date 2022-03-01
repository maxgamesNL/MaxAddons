package io.github.maxgamesNL.maxAddons.modules;

import io.github.maxgamesNL.maxAddons.MaxAddons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collections;

public class AutoLavaFish {

    Minecraft mc = Minecraft.getMinecraft();
    int tickCounter = 0;
    int postThrowCounter= 0;
    boolean isKilling = false;
    int fishingTime = 0;
    ArrayList<Entity> entities2Kill = new ArrayList<Entity>();


    @SubscribeEvent
    public void onTick(net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent e) {
        if(!e.side.isClient()) return;
        if (!MaxAddons.moduleManager.AutoLavaFishToggled) return;


        entities2Kill.remove(null);
        if(isKilling) {
            if(entities2Kill.isEmpty()) {
                isKilling = false;
                return;
            }
            else if (entities2Kill.size() == 1) {
                if(!entities2Kill.get(0).isEntityAlive()){
                    entities2Kill.clear();
                }
                if(getDistanceToEntity(e.player, entities2Kill.get(0)) < 5) {
                    mc.playerController.attackEntity(mc.thePlayer, entities2Kill.get(0));

                }else if (getDistanceToEntity(e.player, entities2Kill.get(0)) < 100) {
                    //In the future, add a way to get the entity's position and move the player to it.
                    //for now, just remove the entity from the list.
                    entities2Kill.clear();
                }else {
                    entities2Kill.clear();
                }
                return;
            }else {
                for(Entity entity : entities2Kill) {
                    if(entity == null) {
                        entities2Kill.remove(entity);
                        return;
                    }
                    if(entity.isEntityAlive()) {
                        if(getDistanceToEntity(e.player, entity) < 5){
                            mc.playerController.attackEntity(mc.thePlayer, entity);
                            return;
                        }
                    }else {
                        entities2Kill.remove(entity);
                    }
                }
                entities2Kill.clear();
            }
            return;
        }

        //check if in crystal hollows
        //if(!mc.ingameGUI.getTabList().toString().contains("Lava Fish")) {return;}

        fishingTime++;
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

        if(fishingTime > 400) {
            isKilling = true;
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


    @SubscribeEvent
    public void onEntitySpawn(EntityEvent.EntityConstructing e) {

        if (!MaxAddons.moduleManager.AutoLavaFishToggled) return;


        if(e.entity instanceof EntityPlayer || e.entity instanceof EntityFX) {
            return;
        }

        if(e.entity instanceof EntitySilverfish) {
            if(!isKilling) {
                entities2Kill.add(e.entity);
            }
        }
    }

    public static double getDistanceToEntity(Entity entity1, Entity entity2) {
        double deltaX = entity1.posX - entity2.posX;
        double deltaY = entity1.posY - entity2.posY;
        double deltaZ = entity1.posZ - entity2.posZ;

        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
    }


}
