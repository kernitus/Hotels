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

    Set<String> getKeys(boolean b);

    Map<String, Object> getValues(boolean b);

    boolean contains(String s);

    boolean contains(String s, boolean b);

    boolean isSet(String s);

    String getCurrentPath();

    String getName();

    Object get(String s);

    Object get(String s, Object o);

    String getString(String s);

    String getString(String s, String s1);

    boolean isString(String s);

    int getInt(String s);

    int getInt(String s, int i);

    boolean isInt(String s);

    boolean getBoolean(String s);

    boolean getBoolean(String s, boolean b);

    boolean isBoolean(String s);

    double getDouble(String s);

    double getDouble(String s, double v);

    boolean isDouble(String s);

    long getLong(String s);

    long getLong(String s, long l);

    boolean isLong(String s);

    List<?> getList(String s);

    List<?> getList(String s, List<?> list);

    boolean isList(String s);

    List<String> getStringList(String s);

    List<Integer> getIntegerList(String s);

    List<Boolean> getBooleanList(String s);

    List<Double> getDoubleList(String s);

    List<Float> getFloatList(String s);

    List<Long> getLongList(String s);

    List<Byte> getByteList(String s);

    List<Character> getCharacterList(String s);

    List<Short> getShortList(String s);

    List<Map<?, ?>> getMapList(String s);

    <T> T getObject(String s, Class<T> aClass);

    <T> T getObject(String s, Class<T> aClass, T t);
}
