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

import com.sk89q.worldedit.sponge.SpongeAdapter;
import com.sk89q.worldguard.LocalPlayer;
import kernitus.plugin.hotels.core.adapters.MessagingAdapter;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;

public class SpongeMessagingAdapter implements MessagingAdapter {
    @Override
    public void send(String message, LocalPlayer player) {
        MessageChannel.fixed(SpongeAdapter.adapt(player)).send(Text.of(message));
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
