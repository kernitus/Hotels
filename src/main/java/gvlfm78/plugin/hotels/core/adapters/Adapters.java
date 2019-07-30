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

public class Adapters {

    public static EconomyAdapter economy;
    public static MessagingAdapter messaging;
    public static UtilitiesAdapter utilities;

    public static void initialise(EconomyAdapter economyAdapter, MessagingAdapter messagingAdapter, UtilitiesAdapter utilitiesAdapter) {
        economy = economyAdapter;
        messaging = messagingAdapter;
        Adapters.utilities = utilitiesAdapter;
    }
}
