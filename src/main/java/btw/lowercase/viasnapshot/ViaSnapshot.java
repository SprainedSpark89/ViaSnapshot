package btw.lowercase.viasnapshot;

import btw.lowercase.viasnapshot.protocol.v15w31ato1_8.Protocol15w31a_To1_8;
import btw.lowercase.viasnapshot.protocol.v15w31bto15w31a.Protocol15w31b_To15w31a;
import btw.lowercase.viasnapshot.protocol.b1_7_previewtob1_7.Protocolb1_7_previewtob1_7;
import btw.lowercase.viasnapshot.protocol.b1_6_tb3tob1_6.*;
import btw.lowercase.viasnapshot.protocol.b1_6_previewtob1_6_tb3.*;
import btw.lowercase.viasnapshot.protocol.b1_8_pre2tob1_8.*;
import btw.lowercase.viasnapshot.protocol.b1_8_pre1tob1_8_pre2.*;
import btw.lowercase.viasnapshot.protocol.v12w07bto1_2.*;
import btw.lowercase.viasnapshot.protocol.v11w49ato1_1.*;
import btw.lowercase.viasnapshot.protocol.v12w06ato12w07a.*;
import btw.lowercase.viasnapshot.protocol.v12w05ato12w06a.*;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import btw.lowercase.viasnapshot.protocol.v1_21_2to1_21_4_RC2.*;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.ProtocolManager;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;

import net.lenni0451.lambdaevents.EventHandler;
import net.raphimc.vialegacy.api.LegacyProtocolVersion;
import net.raphimc.viaproxy.ViaProxy;
import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import net.raphimc.viaproxy.plugins.events.ProtocolTranslatorInitEvent;

public class ViaSnapshot extends ViaProxyPlugin {
    @Override
    public void onEnable() {
        ViaProxy.EVENT_MANAGER.register(this);
    }

    @EventHandler
    private void onInitializeEvent(ProtocolTranslatorInitEvent event) {
        event.registerPlatform(() -> {
            // Adds this to the VV dump
            Via.getManager().getSubPlatforms().add(String.format("git-ViaSnapshot-%s", getVersion()));
            final ProtocolManager protocolManager = Via.getManager().getProtocolManager();
            protocolManager.registerProtocol(new Protocol1_21_2To1_21_4_RC2(), SnapshotProtocolVersion.v1_21_4_pre1, ProtocolVersion.v1_21_4);
            protocolManager.registerProtocol(new Protocol1_21_2To1_21_4_RC2(), SnapshotProtocolVersion.v1_21_4_pre2, ProtocolVersion.v1_21_4);
            protocolManager.registerProtocol(new Protocol1_21_2To1_21_4_RC2(), SnapshotProtocolVersion.v1_21_4_Pre3, ProtocolVersion.v1_21_4);
            protocolManager.registerProtocol(new Protocol1_21_2To1_21_4_RC2(), SnapshotProtocolVersion.v1_21_4_RC1, ProtocolVersion.v1_21_4);
            protocolManager.registerProtocol(new Protocol1_21_2To1_21_4_RC2(), SnapshotProtocolVersion.v1_21_4_RC2, ProtocolVersion.v1_21_4);
            protocolManager.registerProtocol(new Protocol1_21_2To1_21_4(), SnapshotProtocolVersion.v1_21_4_RC3, ProtocolVersion.v1_21_2);
            protocolManager.registerProtocol(new Protocol15w31a_To1_8(), SnapshotProtocolVersion.v15w31a, ProtocolVersion.v1_8);
            protocolManager.registerProtocol(new Protocol15w31b_To15w31a(), SnapshotProtocolVersion.v15w31b, SnapshotProtocolVersion.v15w31a);
            protocolManager.registerProtocol(new Protocol12w05a_to_12w06a(), SnapshotProtocolVersion.v12w03a, SnapshotProtocolVersion.v12w05a);
            protocolManager.registerProtocol(new Protocol12w05a_to_12w06a(), SnapshotProtocolVersion.v12w05a, SnapshotProtocolVersion.v12w06a);
            protocolManager.registerProtocol(new Protocol12w06a_to12w07a(), SnapshotProtocolVersion.v12w06a, SnapshotProtocolVersion.v12w07b);
            protocolManager.registerProtocol(new Protocol12w07b_To1_2(), SnapshotProtocolVersion.v12w07b, LegacyProtocolVersion.r1_2_1tor1_2_3);
            protocolManager.registerProtocol(new Protocol11w49a_to_1_1(), SnapshotProtocolVersion.v11w49a, LegacyProtocolVersion.r1_1);
            protocolManager.registerProtocol(new Protocolb1_8_pre2tob1_8(), SnapshotProtocolVersion.b1_8_prerelease_2Wink, LegacyProtocolVersion.b1_8tob1_8_1);
            protocolManager.registerProtocol(new Protocolb1_8_pre1tob1_8_pre2(), SnapshotProtocolVersion.b1_8_prerelease_1, SnapshotProtocolVersion.b1_8_prerelease_2Wink);
            protocolManager.registerProtocol(new Protocolb1_7_previewtob1_7(), SnapshotProtocolVersion.b1_7_preview, LegacyProtocolVersion.b1_7tob1_7_3);
            protocolManager.registerProtocol(new Protocolb1_6_tb3tob1_6(), SnapshotProtocolVersion.b1_6_tb3, LegacyProtocolVersion.b1_6tob1_6_6);
            protocolManager.registerProtocol(new Protocolb1_6_previewtob1_6_tb3(), SnapshotProtocolVersion.b1_6_tb3, LegacyProtocolVersion.b1_6tob1_6_6);
            return null;
        });
    }
}
