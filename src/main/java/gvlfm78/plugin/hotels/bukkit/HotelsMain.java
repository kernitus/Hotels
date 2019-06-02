/*
 *     Hotels Bukkit and Sponge Plugin
 *     Copyright (C) 2019 kernitus <kernitus@protonmail.com>
 *     Full licence text can be found in LICENCE file
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package kernitus.plugin.hotels.bukkit;

import kernitus.plugin.hotels.core.Adapters;
import org.bukkit.plugin.java.JavaPlugin;

public class HotelsMain extends JavaPlugin {

    @Override
    public void onEnable(){
        getLogger().info("Hotels v" + getDescription().getVersion() + " has been enabled");

        getCommand("hotels").setExecutor(new CommandHandler());

        Adapters.initialise(new BukkitEconomyAdapter());
    }

    @Override
    public void onDisable(){
        getLogger().info("Hotels v" + getDescription().getVersion() + " has been disabled");
    }
}
