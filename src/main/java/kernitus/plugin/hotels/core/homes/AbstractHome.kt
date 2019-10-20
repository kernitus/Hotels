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
 *
 */

package kernitus.plugin.hotels.core.homes

import javax.persistence.Basic
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractHome {

    @Basic(optional = false)
    var x: Int = 0
    @Basic(optional = false)
    var y: Int = 0
    @Basic(optional = false)
    var z: Int = 0
    @Basic(optional = false)
    var pitch: Float = 0.toFloat()
    @Basic(optional = false)
    var yaw: Float = 0.toFloat()
}
