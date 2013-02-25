package archomeda.upnp;

import net.minecraft.server.MinecraftServer;

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
