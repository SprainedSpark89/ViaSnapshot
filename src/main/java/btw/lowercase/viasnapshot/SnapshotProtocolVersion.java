package btw.lowercase.viasnapshot;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.SubVersionRange;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import com.viaversion.viaversion.protocol.RedirectProtocolVersion;

import net.raphimc.vialegacy.api.LegacyProtocolVersion;

public class SnapshotProtocolVersion {
	public static final ProtocolVersion b1_7_preview = registerLegacy(VersionType.BETA_LATER, 13, "b1.7-preview");
    public static final ProtocolVersion v15w31a = registerSnapshot1_8(49, "15w31a (Client Only)");
    public static final ProtocolVersion v15w31b = registerSnapshot1_8(50, "15w31b (Client Only)");

    private static ProtocolVersion registerSnapshot1_8(final int version, final String name) {
        final ProtocolVersion protocolVersion = new RedirectProtocolVersion(version, name, ProtocolVersion.v1_8);
        ProtocolVersion.register(protocolVersion);
        return protocolVersion;
    }
    // vialegacy
    private static ProtocolVersion registerLegacy(final VersionType versionType, final int version, final String name) {
        return registerLegacy(versionType, version, name, null);
    }

    private static ProtocolVersion registerLegacy(final VersionType versionType, final int version, final String name, final SubVersionRange versionRange) {
        final ProtocolVersion protocolVersion = new ProtocolVersion(versionType, version, -1, name, versionRange);
        ProtocolVersion.register(protocolVersion);
        LegacyProtocolVersion.PROTOCOLS.add(protocolVersion);
        return protocolVersion;
    }
}
