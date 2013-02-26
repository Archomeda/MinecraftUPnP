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
    private final static String comment_external_ip = "Used for setting the external IP address of the server manually. If empty, it will be automatically detected from an UPnP enabled router.";
    private final static String comment_auto_portforwarding_enabled = "Enable auto UPnP port forwarding of the server port";

    public static String external_ip;
    public static boolean auto_portforwarding_enabled;

    public static void load(Configuration config) {
        try {
            config.load();

            external_ip = config.get(Configuration.CATEGORY_GENERAL, "external_ip", "", comment_external_ip).value;
            auto_portforwarding_enabled = config.get(Configuration.CATEGORY_GENERAL, "auto_portforwarding_enabled",
                    true, comment_auto_portforwarding_enabled).getBoolean(true);
        } catch (Exception e) {
            MinecraftUpnp.log.severe("MinecraftUPnP has encountered a problem while loading its configuration");
        } finally {
            config.save();
        }
    }
}
