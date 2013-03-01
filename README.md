# MinecraftUPnP #
MinecraftUPnP is a mod for Minecraft servers that adds several abilities for UPnP compatible routers and helps mod developers integrating UPnP capabilities to their mods.

Please note that this readme is provided "as is" and may contain incorrect and/or incomplete information. If something is not correct, please file an issue explaining what's wrong or missing.

- [Features](#features)
- [Downloads](#downloads)
- [Setting up the build environment](#setting-up-the-build-environment)
- [Compiling](#compiling)
- [Third party dependencies](#third-party-dependencies)


## Features ##
All features currently available in MinecraftUPnP are listed below. If you want a feature to be added, please submit an issue or fork this repo and do a pull request.

### For users ###
Currently, the feature list for users is a bit limited.

- Ability to automatically forward the Minecraft server port

### For developers ###
Only the main features are listed here. For other (more hidden) features, please take a look at the source.

- Shortcut to get the LAN IP address (`archomeda.upnp.Upnp.getLanIp()`)
- Automatic detection of the external (WAN) IP address (can be retrieved from `archomeda.upnp.Upnp.getExternalIp()`)
- Ability to register and unregister ports that will be forwarded and unforwarded automatically (through `archomeda.upnp.Upnp.registerPort(int)` and `archomeda.upnp.Upnp.unregisterPort(int)`)<br>
  *Note: Please do not abuse this functionality by adding too many ports (like a range of 1,000 passive ports for FTP); some routers do not like this.*<br>
  *Note 2: Registered ports get automatically unforwarded upon server shutdown.*

## Downloads ##
 - [v1.0 for Minecraft 1.4.7 (Forge #497)](https://dl.dropbox.com/u/678063/Minecraft/MinecraftUPnP/MinecraftUPnP-1.4.7-1.0.jar)

## Setting up the build environment ##
*Note: In this section, [Eclipse](http://www.eclipse.org/) will be used as example.*

1. Clone or download the source of MinecraftUPnP.
2. Import the downloaded source into Eclipse.
3. Download the source of [Minecraft Forge](http://files.minecraftforge.net/) build #497 (or the latest build), extract it somewhere (preferably somewhere near the source) and execute `install.bat` (Windows) or `install.sh` (Linux).
4. Compile it once (see below) in order to get all required dependencies.
5. Import the Minecraft project of MCP into Eclipse (can be found in `forge/mcp/eclipse/Minecraft`) and rename it to Forge.
6. Check if the path variable `MCP_LOC` is pointing to the correct directory (`forge/mcp`). If you have linked the Minecraft project, this variable should be set to `${PROJECT_LOC}/../..`, which means it will look two directories up from the project directory.
7. Refresh the projects in order to load and detect their contents properly.


## Compiling ##
*Note: Only tested with Forge #497, it is not guaranteed that it works with other builds of Forge.*

1. Must have followed all steps until step 4 of setting up the build environment (see above).
2. Download [Apache Ant](http://ant.apache.org/) and install it somewhere where you can easily find it later.
3. Inside the `MinecraftUPnP` directory, create a file named `build.properties` with the following properties:
  - `mcp.home=<relative_path_to_mcp_dir>` (most common: `forge/mcp` or `../forge/mcp`)
  - `version.minecraft=<version>` (Minecraft version, current: 1.4.7)
  - `version=<version>` (MinecraftUPnP version, latest: 1.0)
4. Run `ant build` and let it run for a while. Please note that an active internet connection is required when running this for the first time as it will download Maven first in order to resolve and download the dependencies. After that, it will automatically compile and obfuscate the code.
5. If successful, inside the `build` directory, you should see a new .zip file with your version numbers in its name.

## Third party dependencies ##
MinecraftUPnP uses [Cling](http://4thline.org/projects/cling/) from 4th Line.org for its UPnP functionality. This dependency will be downloaded automatically when compiling.