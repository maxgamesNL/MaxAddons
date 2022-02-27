package io.github.maxgamesNL.maxAddons.modules;

import io.github.maxgamesNL.maxAddons.MaxAddons;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CoordsHUD {

    @SubscribeEvent
    public void render(net.minecraftforge.client.event.RenderGameOverlayEvent.Text e) {
        if(MaxAddons.moduleManager.CoordsToggled) {
            e.right.add("X: " + Math.round(net.minecraft.client.Minecraft.getMinecraft().thePlayer.posX));
            e.right.add("Y: " + Math.round(net.minecraft.client.Minecraft.getMinecraft().thePlayer.posY));
            e.right.add("Z: " + Math.round(net.minecraft.client.Minecraft.getMinecraft().thePlayer.posZ));

        }

    }
}
