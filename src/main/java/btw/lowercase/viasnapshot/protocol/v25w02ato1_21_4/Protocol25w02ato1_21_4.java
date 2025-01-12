package btw.lowercase.viasnapshot.protocol.v25w02ato1_21_4;

import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;

import btw.lowercase.viasnapshot.protocol.v25w02ato1_21_4.packet.ClientboundPacket1_21_4;
import btw.lowercase.viasnapshot.protocol.v25w02ato1_21_4.packet.ClientboundPackets1_21_4;

public class Protocol25w02ato1_21_4 extends AbstractProtocol<ClientboundPacket1_21_4, ClientboundPacket1_21_4, ServerboundPacket1_21_4, ServerboundPacket1_21_4> {
	public static final MappingData MAPPINGS = new MappingDataBase("1.21.4", "25w02a");
	public Protocol25w02ato1_21_4() {
		super(ClientboundPacket1_21_4.class, ClientboundPacket1_21_4.class, ServerboundPacket1_21_4.class, ServerboundPacket1_21_4.class);
	}
	@Override
    protected void registerPackets() {
		super.registerPackets();
		/*this.registerClientbound(ClientboundPackets1_21_4.ADD_ENTITY, new PacketHandlers() {
			@Override
			protected void register() {
				map(Types.VAR_INT); // entity id
				map(Types.UUID); // entity uuid
				map(Types.DOUBLE); // x
				map(Types.DOUBLE); // y
				map(Types.DOUBLE); // z
				map(Types.BYTE); // pitch
				map(Types.BYTE); // yaw
				map(Types.BYTE); // head yaw
				map(Types.VAR_INT); // data
				map(Types.SHORT); // vel x
				map(Types.SHORT); // vel y
				map(Types.SHORT); // vel z
			}
		});*/
		// packet 0x5D, sets data of an entity
		this.registerClientbound(ClientboundPackets1_21_4.SET_ENTITY_DATA, new PacketHandlers() {

			@Override
			protected void register() {
				// TODO Auto-generated method stub
				map(Types.VAR_INT); // entity id
				map(Types1_21_4.ENTITY_DATA); // entity metadata
				handler(wrapper -> {
					//if()
				});
				
			}
			
		});
	}
	
	@Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }
}
