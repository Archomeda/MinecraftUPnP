/*******************************************************************************
 * Copyright (c) 2013 Archomeda.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Archomeda - initial API and implementation
 ******************************************************************************/
package archomeda.upnp;

import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.Mod.ServerStopping;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * The main class for MinecraftUPnP. Handles all mod logic.
 * 
 * @author Archomeda
 */
@Mod(modid = "MinecraftUPnP", name = "MinecraftUPnP", version = "@MOD_VERSION@")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class MinecraftUpnp {
    @Instance("MinecraftUPnP")
    public static MinecraftUpnp instance;

    @SidedProxy(clientSide = "archomeda.upnp.ClientProxy", serverSide = "archomeda.upnp.Proxy")
    public static Proxy proxy;

    public static Logger log = Logger.getLogger("MinecraftUPnP");

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        log.setParent(FMLLog.getLogger());

        Config.load(new Configuration(event.getSuggestedConfigurationFile()));
    }

    @Init
    public void init(FMLInitializationEvent event) {
        proxy.initUpnp();
    }

    @ServerStarting
    public void serverStarting(FMLServerStartingEvent event) {
        if (Config.autoPortforwardingEnabled)
            proxy.registerServerPort();
    }

    @ServerStopping
    public void serverStopping(FMLServerStoppingEvent event) {
        proxy.shutdownUpnp();
    }
}
