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
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package kernitus.plugin.hotels.core.exceptions

open class HotelsException(override val message: String, val commandUsage: String? = null,
                           val printCommandUsage: Boolean = true, val printStackTrace: Boolean = false) : Exception()

class NoArgumentsException(commandUsage: String?) : HotelsException("No arguments!", commandUsage)
class NoPermissionException : HotelsException("No permission!", printCommandUsage = false)
class NotEnoughArgumentsException(commandUsage: String?) : HotelsException("Not enough arguments!", commandUsage)
class WorldNonExistentException(commandUsage: String?) : HotelsException("Specified world does not exist!", commandUsage)
class WorldGuardException : HotelsException("WorldGuard error!", printStackTrace = true)
class PlayerOnlyException : HotelsException("This command can only be run by a player", printCommandUsage = false)
class InvalidRegionException : HotelsException("Region is not valid!", printCommandUsage = false)
class InvalidHotelException : HotelsException("Specified hotel is not valid!")

/**
 * For when there shouldn't be an exception thrown
 */
class BruhMoment : HotelsException("Unknown error has occurred", null, false, true)
