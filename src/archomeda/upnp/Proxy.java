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

import net.minecraft.server.MinecraftServer;

/**
 * The main entry point for both Minecraft servers and clients.
 * 
 * @author Archomeda
 */
public class Proxy {
    public Proxy() {
    }

    /**
     * Initializes the UPnP service.
     */
    void initUpnp() {
        Upnp.init();
    }

    /**
     * Shuts down the UPnP service.
     */
    void shutdownUpnp() {
        Upnp.shutdown();
    }

    /**
     * Registers the server port to the list of forwarded ports.
     */
    void registerServerPort() {
        MinecraftServer server = MinecraftServer.getServer();
        int port = server.getServerPort();
        Upnp.registerPort(port);
    }
}
