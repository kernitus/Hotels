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
 *      This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package kernitus.plugin.hotels.core.configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * YAML Configuration interface (read only)
 */
public interface HotelsConfiguration {

    Set<String> getKeys(boolean deep);

    Map<String, Object> getValues(boolean deep);

    boolean contains(String path);

    boolean contains(String path, boolean ignoreDefault);

    boolean isSet(String path);

    String getCurrentPath();

    String getName();

    Object get(String path);

    Object get(String path, Object def);

    String getString(String path);

    String getString(String path, String def);

    int getInt(String path);

    int getInt(String path, int def);
    boolean getBoolean(String path);

    boolean getBoolean(String path, boolean def);

    double getDouble(String path);

    double getDouble(String path, double def);

    long getLong(String path);

    long getLong(String path, long def);

    <T> List<T> getList(String path, Class<T> clazz);

    <T> List<T> getList(String path, Class<T> clazz, List<T> def);

    List<String> getStringList(String path);

    List<Integer> getIntegerList(String path);

    List<Boolean> getBooleanList(String path);

    List<Double> getDoubleList(String path);

    List<Float> getFloatList(String path);

    List<Long> getLongList(String path);

    List<Byte> getByteList(String path);

    List<Character> getCharacterList(String path);

    List<Short> getShortList(String path);

    <T> T getObject(String path, Class<T> clazz);

    <T> T getObject(String path, Class<T> clazz, T def);
}
