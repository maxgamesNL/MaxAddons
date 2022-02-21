package io.github.maxgamesNL.maxAddons.proxy;

import io.github.maxgamesNL.maxAddons.modules.AutoLavaFish;
import io.github.maxgamesNL.maxAddons.modules.AutoStonk;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {

    }

    @Override
    public void registerEvents() {

        MinecraftForge.EVENT_BUS.register(new AutoStonk());
        MinecraftForge.EVENT_BUS.register(new AutoLavaFish());
    }
}
