package btw.lowercase.viasnapshot.mixins;

import net.raphimc.vialegacy.api.LegacyProtocolVersion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LegacyProtocolVersion.class)
public class Corrections {

    // Redirect the call to modify the name parameter
    @Redirect(
        method = "registerLegacy(Lcom/viaversion/viaversion/api/protocol/version/VersionType;ILjava/lang/String;)Lcom/viaversion/viaversion/api/protocol/version/ProtocolVersion;",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/String;<init>(Ljava/lang/String;)V"
        )
    )
    private static String modifyName(String originalName) {
    	return correctVersionRanges(originalName);
    }

    @Redirect(
        method = "registerLegacy(Lcom/viaversion/viaversion/api/protocol/version/VersionType;ILjava/lang/String;Lcom/viaversion/viaversion/api/protocol/version/SubVersionRange;)Lcom/viaversion/viaversion/api/protocol/version/ProtocolVersion;",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/String;<init>(Ljava/lang/String;)V"
        )
    )
    private static String modifyNameWithRange(String originalName) {
        // Example modification: replace dots with spaces
        return correctVersionRanges(originalName);
    }
    
    private static String correctVersionRanges(String originalName) {
    	String modifiedName = null;
        if(originalName.equals("1.0.0-1.0.1")) {
        	modifiedName = "b1.9 prerelease 6-11w48a"; // 11w49a to 11w50a might have the same protocol as the others but spawn eggs
        } else if(originalName.equals("1.1")) {
        	modifiedName = "12w01a-1.1";
        }
        
        if(modifiedName == null) {
        	modifiedName = originalName;
        }

        return modifiedName;
    }
}
