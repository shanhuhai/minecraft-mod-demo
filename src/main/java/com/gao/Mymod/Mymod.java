package com.gao.Mymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid="mymod", name="mymod", version="1.12.2-1.0",useMetadata=true)
public class Mymod {

    // modid 必须小写
    @Mod.Instance("mymod")
    public static Mymod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event ){

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event) {

    }

}
