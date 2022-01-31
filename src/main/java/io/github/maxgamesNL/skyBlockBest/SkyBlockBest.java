package io.github.maxgamesNL.skyBlockBest;

import io.github.maxgamesNL.skyBlockBest.proxy.CommonProxy;
import net.minecraft.event.ClickEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;


//https://skmedix.github.io/ForgeJavaDocs/javadoc/forge/1.9.4-12.17.0.2051/overview-summary.html

@Mod(modid = SkyBlockBest.MODID, version = SkyBlockBest.VERSION)
public class SkyBlockBest
{
    public static final String MODID = "skyblockbest";
    public static final String VERSION = "0.1";
    public static final String NAME = "SkyBlock Best";
    public static final String SERVER_PROXY_CLASS = "io.github.maxgamesNL.skyBlockBest.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "io.github.maxgamesNL.skyBlockBest.proxy.ClientProxy";


    @SidedProxy(clientSide = SkyBlockBest.CLIENT_PROXY_CLASS, serverSide = SkyBlockBest.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance(SkyBlockBest.MODID)
    public static SkyBlockBest instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        proxy.registerRenders();
        proxy.registerEvents();
    }

}

