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
 */

package kernitus.plugin.hotels.core.adapters;

import kernitus.plugin.hotels.core.configuration.HotelsConfiguration;

import java.nio.file.Path;

/**
 * Handles loading and saving of YAML files
 */
public interface ConfigAdapter {

    /**
     * Extracts a yml file from resources to the plugin folder
     * @param name The name of the file in the resources folder
     */
    void setupConfig(String name);

    HotelsConfiguration getConfig(Path path);
    void saveConfig(HotelsConfiguration config);
}
