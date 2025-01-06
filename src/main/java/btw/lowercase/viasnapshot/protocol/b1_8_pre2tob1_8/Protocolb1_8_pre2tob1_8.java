/*
 * This file is part of ViaLegacy - https://github.com/RaphiMC/ViaLegacy
 * Copyright (C) 2020-2024 RK_01/RaphiMC and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package btw.lowercase.viasnapshot.protocol.b1_8_pre2tob1_8;

import net.raphimc.vialegacy.api.protocol.StatelessProtocol;
import net.raphimc.vialegacy.protocol.beta.b1_8_0_1tor1_0_0_1.packet.*;

public class Protocolb1_8_pre2tob1_8 extends StatelessProtocol<ClientboundPacketsb1_8, ClientboundPacketsb1_8, ServerboundPacketsb1_8, ServerboundPacketsb1_8> {

    public Protocolb1_8_pre2tob1_8() {
        super(ClientboundPacketsb1_8.class, ClientboundPacketsb1_8.class, ServerboundPacketsb1_8.class, ServerboundPacketsb1_8.class);
    }

}
