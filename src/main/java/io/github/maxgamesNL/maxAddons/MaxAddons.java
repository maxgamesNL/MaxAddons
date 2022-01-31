package io.github.maxgamesNL.maxAddons;

import io.github.maxgamesNL.maxAddons.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


//https://skmedix.github.io/ForgeJavaDocs/javadoc/forge/1.9.4-12.17.0.2051/overview-summary.html

@Mod(modid = MaxAddons.MODID, version = MaxAddons.VERSION)
public class MaxAddons
{
    public static final String MODID = "maxaddons";
    public static final String VERSION = "0.1";
    public static final String NAME = "Max Addons";
    public static final String SERVER_PROXY_CLASS = "io.github.maxgamesNL.maxAddons.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "io.github.maxgamesNL.maxAddons.proxy.ClientProxy";


    @SidedProxy(clientSide = MaxAddons.CLIENT_PROXY_CLASS, serverSide = MaxAddons.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance(MaxAddons.MODID)
    public static MaxAddons instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        proxy.registerRenders();
        proxy.registerEvents();
    }

}

