/*
 *     Hotels Bukkit Plugin
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

package kernitus.plugin.hotels.bukkit;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * YAML Configuration handler
 */
public class HotelsConfiguration {

    private final YamlConfiguration config;

    public HotelsConfiguration(YamlConfiguration config) {
        this.config = config;
    }

    
    public Set<String> getKeys(boolean deep) {
        return config.getKeys(deep);
    }

    
    public Map<String, Object> getValues(boolean deep) {
        return config.getValues(deep);
    }

    
    public boolean contains(String path) {
        return config.contains(path);
    }

    
    public boolean contains(String path, boolean ignoreDefault) {
        return config.contains(path,ignoreDefault);
    }

    
    public boolean isSet(String path) {
        return config.isSet(path);
    }

    
    public String getCurrentPath() {
        return config.getCurrentPath();
    }

    
    public String getName() {
        return config.getName();
    }

    
    public Object get(String path) {
        return config.get(path);
    }

    
    public Object get(String path, Object def) {
        return config.get(path,def);
    }

    
    public String getString(String path) {
        return config.getString(path);
    }

    
    public String getString(String path, String def) {
        return config.getString(path,def);
    }

    
    public int getInt(String path) {
        return config.getInt(path);
    }

    
    public int getInt(String path, int def) {
        return config.getInt(path,def);
    }

    
    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    
    public boolean getBoolean(String path, boolean def) {
        return config.getBoolean(path,def);
    }

    
    public double getDouble(String path) {
        return config.getDouble(path);
    }

    
    public double getDouble(String path, double def) {
        return config.getDouble(path,def);
    }

    
    public long getLong(String path) {
        return config.getLong(path);
    }

    
    public long getLong(String path, long def) {
        return config.getLong(path,def);
    }

    
    public <T> List<T> getList(String path, Class<T> clazz) {
        return (List<T>) config.getList(path);
    }

    
    public <T> List<T> getList(String path, Class<T> clazz, List<T> def) {
        return (List<T>) config.getList(path,def);
    }

    
    public List<String> getStringList(String path) {
        return config.getStringList(path);
    }

    
    public List<Integer> getIntegerList(String path) {
        return config.getIntegerList(path);
    }

    
    public List<Boolean> getBooleanList(String path) {
        return config.getBooleanList(path);
    }

    
    public List<Double> getDoubleList(String path) {
        return config.getDoubleList(path);
    }

    
    public List<Float> getFloatList(String path) {
        return config.getFloatList(path);
    }

    
    public List<Long> getLongList(String path) {
        return config.getLongList(path);
    }

    
    public List<Byte> getByteList(String path) {
        return config.getByteList(path);
    }

    
    public List<Character> getCharacterList(String path) {
        return config.getCharacterList(path);
    }

    
    public List<Short> getShortList(String path) {
        return config.getShortList(path);
    }

    
    public <T> T getObject(String path, Class<T> clazz) {
        return config.getObject(path,clazz);
    }

    
    public <T> T getObject(String path, Class<T> clazz, T def) {
        return config.getObject(path,clazz,def);
    }
}
