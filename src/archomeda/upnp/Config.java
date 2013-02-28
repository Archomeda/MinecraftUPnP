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

import net.minecraftforge.common.Configuration;

/**
 * A class that handles and contains all configurations of MinecraftUPnP.
 * 
 * @author Archomeda
 */
public class Config {
    private final static String comment_externalIp = "Used for setting the external IP address of the server manually. If empty, it will be automatically detected from an UPnP enabled router.";
    private final static String comment_autoPortforwardingEnabled = "Enable auto UPnP port forwarding of the server port";

    public static String externalIp;
    public static boolean autoPortforwardingEnabled;

    /**
     * Loads the configuration of the mod.
     * 
     * @param config
     *            The configuration to load.
     */
    public static void load(Configuration config) {
        try {
            config.load();

            externalIp = config.get(Configuration.CATEGORY_GENERAL, "external_ip", "", comment_externalIp).value;
            autoPortforwardingEnabled = config.get(Configuration.CATEGORY_GENERAL, "auto_portforwarding_enabled", true,
                    comment_autoPortforwardingEnabled).getBoolean(true);
        } catch (Exception e) {
            MinecraftUpnp.log.severe("MinecraftUPnP has encountered a problem while loading its configuration");
        } finally {
            config.save();
        }
    }
}
