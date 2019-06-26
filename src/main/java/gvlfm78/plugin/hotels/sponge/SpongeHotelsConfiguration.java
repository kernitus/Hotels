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

package kernitus.plugin.hotels.sponge;

import com.google.common.reflect.TypeToken;
import kernitus.plugin.hotels.core.configuration.HotelsConfiguration;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpongeHotelsConfiguration implements HotelsConfiguration {

    private final ConfigurationNode node;

    public SpongeHotelsConfiguration(ConfigurationNode node) {
        this.node = node;
    }

    /**
     * Converts from bukkit-style path to Sponge-style
     * @param path The path using '.' separators
     * @return The path as an array of node names
     */
    private String[] toSpongePath(String path){
        return path.split(".");
    }

    @Override
    public Set<String> getKeys(boolean deep) {
        Set<String> keys = new HashSet<>();
        node.getChildrenList().forEach(key -> keys.add(key.toString()));
        return keys;
    }

    @Override
    public Map<String, Object> getValues(boolean deep) {
        return null;
    }

    @Override
    public boolean contains(String path) {
        return node.getNode(toSpongePath(path)).getValue() != null;
    }

    @Override
    public boolean contains(String path, boolean ignoreDefault) {
        return false;
    }

    @Override
    public boolean isSet(String path) {
        return false;
    }

    @Override
    public String getCurrentPath() {
        return node.getPath().toString();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Object get(String path) {
        return node.getNode(toSpongePath(path)).getValue();
    }

    @Override
    public Object get(String path, Object def) {
        return node.getNode(toSpongePath(path)).getValue(def);
    }

    @Override
    public String getString(String path) {
        return node.getNode(toSpongePath(path)).getString();
    }

    @Override
    public String getString(String path, String def) {
        return node.getNode(toSpongePath(path)).getString(def);
    }

    @Override
    public int getInt(String path) {
        return node.getNode(toSpongePath(path)).getInt();
    }

    @Override
    public int getInt(String path, int def) {
        return node.getNode(toSpongePath(path)).getInt(def);
    }

    @Override
    public boolean getBoolean(String path) {
        return node.getNode(toSpongePath(path)).getBoolean();
    }

    @Override
    public boolean getBoolean(String path, boolean def) {
        return node.getNode(toSpongePath(path)).getBoolean(def);
    }

    @Override
    public double getDouble(String path) {
        return node.getNode(toSpongePath(path)).getDouble();
    }

    @Override
    public double getDouble(String path, double def) {
        return node.getNode(toSpongePath(path)).getDouble(def);
    }

    @Override
    public long getLong(String path) {
        return node.getNode(toSpongePath(path)).getLong();
    }

    @Override
    public long getLong(String path, long def) {
        return node.getNode(toSpongePath(path)).getLong(def);
    }

    @Override
    public <T> List<T> getList(String path, Class<T> clazz) {
        try {
            return node.getNode(toSpongePath(path)).getList(TypeToken.of(clazz));
        } catch (ObjectMappingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> getList(String path, Class<T> clazz, List<T> def) {
        try {
            List<T> list = node.getNode(toSpongePath(path)).getList(TypeToken.of(clazz));
            if(!list.isEmpty()) return list;
        } catch (ObjectMappingException e) {
            e.printStackTrace();
        }
        return def;
    }

    @Override
    public List<String> getStringList(String path) {
        return getList(path, String.class);
    }

    @Override
    public List<Integer> getIntegerList(String path) {
        return getList(path, Integer.class);
    }

    @Override
    public List<Boolean> getBooleanList(String path) {
        return getList(path, Boolean.class);
    }

    @Override
    public List<Double> getDoubleList(String path) {
        return getList(path, Double.class);
    }

    @Override
    public List<Float> getFloatList(String path) {
        return getList(path, Float.class);
    }

    @Override
    public List<Long> getLongList(String path) {
        return getList(path, Long.class);
    }

    @Override
    public List<Byte> getByteList(String path) {
        return getList(path, Byte.class);
    }

    @Override
    public List<Character> getCharacterList(String path) {
        return getList(path, Character.class);
    }

    @Override
    public List<Short> getShortList(String path) {
        return getList(path, Short.class);
    }

    @Override
    public <T> T getObject(String path, Class<T> clazz) {
        return (T) node.getNode(toSpongePath(path)).getValue();
    }

    @Override
    public <T> T getObject(String path, Class<T> clazz, T def) {
        return (T) node.getNode(toSpongePath(path)).getValue(def);
    }
}
