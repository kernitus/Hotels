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

package kernitus.plugin.hotels.bukkit

import org.bukkit.configuration.file.YamlConfiguration

/**
 * YAML Configuration handler
 */
class HotelsConfiguration(private val config: YamlConfiguration) {


    val currentPath: String
        get() = config.getCurrentPath()


    val name: String
        get() = config.getName()


    fun getKeys(deep: Boolean): Set<String> {
        return config.getKeys(deep)
    }


    fun getValues(deep: Boolean): Map<String, Any> {
        return config.getValues(deep)
    }


    operator fun contains(path: String): Boolean {
        return config.contains(path)
    }


    fun contains(path: String, ignoreDefault: Boolean): Boolean {
        return config.contains(path, ignoreDefault)
    }


    fun isSet(path: String): Boolean {
        return config.isSet(path)
    }


    operator fun get(path: String): Any {
        return config.get(path)
    }


    operator fun get(path: String, def: Any): Any {
        return config.get(path, def)
    }


    fun getString(path: String): String {
        return config.getString(path)
    }


    fun getString(path: String, def: String): String {
        return config.getString(path, def)
    }


    fun getInt(path: String): Int {
        return config.getInt(path)
    }


    fun getInt(path: String, def: Int): Int {
        return config.getInt(path, def)
    }


    fun getBoolean(path: String): Boolean {
        return config.getBoolean(path)
    }


    fun getBoolean(path: String, def: Boolean): Boolean {
        return config.getBoolean(path, def)
    }


    fun getDouble(path: String): Double {
        return config.getDouble(path)
    }


    fun getDouble(path: String, def: Double): Double {
        return config.getDouble(path, def)
    }


    fun getLong(path: String): Long {
        return config.getLong(path)
    }


    fun getLong(path: String, def: Long): Long {
        return config.getLong(path, def)
    }


    fun <T> getList(path: String, clazz: Class<T>): List<T> {
        return config.getList(path)
    }


    fun <T> getList(path: String, clazz: Class<T>, def: List<T>): List<T> {
        return config.getList(path, def)
    }


    fun getStringList(path: String): List<String> {
        return config.getStringList(path)
    }


    fun getIntegerList(path: String): List<Int> {
        return config.getIntegerList(path)
    }


    fun getBooleanList(path: String): List<Boolean> {
        return config.getBooleanList(path)
    }


    fun getDoubleList(path: String): List<Double> {
        return config.getDoubleList(path)
    }


    fun getFloatList(path: String): List<Float> {
        return config.getFloatList(path)
    }


    fun getLongList(path: String): List<Long> {
        return config.getLongList(path)
    }


    fun getByteList(path: String): List<Byte> {
        return config.getByteList(path)
    }


    fun getCharacterList(path: String): List<Char> {
        return config.getCharacterList(path)
    }


    fun getShortList(path: String): List<Short> {
        return config.getShortList(path)
    }


    fun <T> getObject(path: String, clazz: Class<T>): T {
        return config.getObject(path, clazz)
    }


    fun <T> getObject(path: String, clazz: Class<T>, def: T): T {
        return config.getObject(path, clazz, def)
    }
}
