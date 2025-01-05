package btw.lowercase.viasnapshot;

import btw.lowercase.viasnapshot.protocol.v15w31ato1_8.Protocol15w31a_To1_8;
import btw.lowercase.viasnapshot.protocol.v15w31bto15w31a.Protocol15w31b_To15w31a;
import btw.lowercase.viasnapshot.protocol.b1_7_previewtob1_7.Protocolb1_7_previewtob1_7;
import btw.lowercase.viasnapshot.protocol.b1_6_tb3tob1_6.*;
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
            protocolManager.registerProtocol(new Protocol15w31a_To1_8(), SnapshotProtocolVersion.v15w31a, ProtocolVersion.v1_8);
            protocolManager.registerProtocol(new Protocol15w31b_To15w31a(), SnapshotProtocolVersion.v15w31b, SnapshotProtocolVersion.v15w31a);
            protocolManager.registerProtocol(new Protocolb1_7_previewtob1_7(), SnapshotProtocolVersion.b1_7_preview, LegacyProtocolVersion.b1_7tob1_7_3);
            protocolManager.registerProtocol(new Protocolb1_6_tb3tob1_6(), SnapshotProtocolVersion.b1_6_tb3, LegacyProtocolVersion.b1_6tob1_6_6);
            return null;
        });
    }
}
