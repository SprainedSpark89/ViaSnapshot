package btw.lowercase.viasnapshot.mixins;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;

@Mixin(ProtocolVersion.class)
public abstract class Corrections {

	 // Shadow the existing getName method to access it
    @Shadow
    public abstract String getName();

    @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
    private void modifyGetName(CallbackInfoReturnable<String> cir) {
        // Modify the output of getName() as desired
        String originalName = getName(); // Call the original method if needed
        String modifiedName = correctVersionRanges(originalName); // Example modification
        cir.setReturnValue(modifiedName); // Override the method's return value
    }

	private static String correctVersionRanges(String originalName) {
		String modifiedName = null;
		if (originalName.equals("1.0.0-1.0.1")) {
			modifiedName = "b1.9 prerelease 6-11w48a"; // 11w49a to 11w50a might have the same protocol as the others
														// but spawn eggs
		} else if (originalName.equals("1.1")) {
			modifiedName = "12w01a-1.1";
		} else if (originalName.equals("1.2.1-1.2.3")) {
			modifiedName = "12w08a-1.2.3";
		} else if (originalName.equals("1.2.4-1.2.5")) {
			modifiedName = "1.2.4-12w15a";
		} else if (originalName.equals("1.3.1-1.3.2")) {
			modifiedName = "12w30c-1.3.2";
		} else if (originalName.equals("1.4.2")) {
			modifiedName = "12w42b-1.4.2";
		} else if (originalName.equals("1.4.6-1.4.7")) {
			modifiedName = "12w50a-1.4.7";
		} else if (originalName.equals("1.5-1.5.1")) {
			modifiedName = "13w09c-1.5.1";
		} else if (originalName.equals("1.5.2")) {
			modifiedName = "1.5.2 Prerelease-1.5.2";
		} else if (originalName.equals("1.6.2")) {
			modifiedName = "1.6.2 Prerelease-1.6.2";
		}

		if (modifiedName == null) {
			modifiedName = originalName;
		}

		return modifiedName;
	}
}
