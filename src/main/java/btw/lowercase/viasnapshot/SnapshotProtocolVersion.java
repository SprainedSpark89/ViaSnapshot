package btw.lowercase.viasnapshot;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.SubVersionRange;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import com.viaversion.viaversion.protocol.RedirectProtocolVersion;

import net.raphimc.vialegacy.api.LegacyProtocolVersion;

public class SnapshotProtocolVersion {
	public static final ProtocolVersion b1_6_preview = registerLegacy(VersionType.BETA_LATER, 11, "b1.6-preview");
	public static final ProtocolVersion b1_6_tb3 = registerLegacy(VersionType.BETA_LATER, 12, "b1.6-tb3");
	public static final ProtocolVersion b1_7_preview = registerLegacy(VersionType.BETA_LATER, 13, "b1.7-preview");
	public static final ProtocolVersion b1_8_prerelease_1 = registerLegacy(VersionType.BETA_LATER, 15, "b1.8 prerelease 1 (leaked)-b1.8-prerelease 1 (reupload)");
	public static final ProtocolVersion b1_8_prerelease_2Wink = registerLegacy(VersionType.BETA_LATER, 16, "b1.8 prerelease 2 ;)");
	public static final ProtocolVersion v11w49a = registerSnapshot(22, "11w49a-11w50a", LegacyProtocolVersion.r1_1);
	public static final ProtocolVersion v12w03a = registerSnapshot(24, "12w03a", LegacyProtocolVersion.r1_2_1tor1_2_3);
	public static final ProtocolVersion v12w05a = registerSnapshot(24, "12w04a-12w05a", LegacyProtocolVersion.r1_2_1tor1_2_3);
	public static final ProtocolVersion v12w06a = registerSnapshot(25, "12w06a", LegacyProtocolVersion.r1_2_1tor1_2_3);
	public static final ProtocolVersion v12w07b = registerSnapshot(27, "12w07a/b", LegacyProtocolVersion.r1_2_1tor1_2_3);
    public static final ProtocolVersion v15w31a = registerSnapshot1_8(49, "15w31a (Client Only)");
    public static final ProtocolVersion v15w31b = registerSnapshot1_8(50, "15w31b (Client Only)");
    //kennytv commits to viaversion just copied over to here for addition of snapshots and stuff:
    public static final ProtocolVersion v1_21_4_RC3 = ProtocolVersion.register(769, 228, "1.21.4-rc3");
    public static final ProtocolVersion v1_21_4_RC2 = ProtocolVersion.register(769, 227, "1.21.4-rc2");
    public static final ProtocolVersion v1_21_4_RC1 = ProtocolVersion.register(769, 226, "1.21.4-rc1");
    public static final ProtocolVersion v1_21_4_Pre3 = ProtocolVersion.register(769, 225, "1.21.4-pre3");
    public static final ProtocolVersion v1_21_4_pre2 = ProtocolVersion.register(769, 224, "1.21.4-pre2");
    public static final ProtocolVersion v1_21_4_pre1 = ProtocolVersion.register(769, 223, "1.21.4-pre1");
    // custom stuff
    public static final ProtocolVersion v25w02a = ProtocolVersion.register(770 /*< assuming the next release version is that protocol*/ , decodeSnapshotVersion(1073742053) /*229*/, "25w02a");
	public static final ProtocolVersion v25w03a = ProtocolVersion.register(770 /*< assuming the next release version is that protocol*/ , decodeSnapshotVersion(1073742054) /*230*/, "25w03a");
	public static final ProtocolVersion v25w04a = ProtocolVersion.register(770 /*< assuming the next release version is that protocol*/ , decodeSnapshotVersion(1073742055) /*231*/, "25w04a");

    private static ProtocolVersion registerSnapshot1_8(final int version, final String name) {
        final ProtocolVersion protocolVersion = new RedirectProtocolVersion(version, name, ProtocolVersion.v1_8);
        ProtocolVersion.register(protocolVersion);
        return protocolVersion;
    }
    
    private static ProtocolVersion registerSnapshot(final int version, final String name, ProtocolVersion baseVersion) {
        final ProtocolVersion protocolVersion = new RedirectProtocolVersion(version, name, baseVersion);
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
    
    // chatgpt thing:
    public static int decodeSnapshotVersion(int encodedNumber) {
        // Mask to extract the lower 30 bits
        int mask = (1 << 30) - 1;
        return encodedNumber & mask;
    }
}
