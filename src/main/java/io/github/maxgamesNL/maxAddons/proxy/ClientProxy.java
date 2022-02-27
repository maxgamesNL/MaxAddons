package io.github.maxgamesNL.maxAddons.proxy;

import io.github.maxgamesNL.maxAddons.modules.AutoLavaFish;
import io.github.maxgamesNL.maxAddons.modules.AutoStonk;
import io.github.maxgamesNL.maxAddons.modules.CoordsHUD;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        MinecraftForge.EVENT_BUS.register(new CoordsHUD());
    }

    @Override
    public void registerEvents() {

        MinecraftForge.EVENT_BUS.register(new AutoStonk());
        MinecraftForge.EVENT_BUS.register(new AutoLavaFish());

    }
}
