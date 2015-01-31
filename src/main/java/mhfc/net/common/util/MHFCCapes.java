package mhfc.net.common.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;

public class MHFCCapes {
	public static void addDevCapes() {
		String capeURL = "http://i.imgur.com/p0JW7NF.png";
		String[] devs = {"XxHeltratoxX", "hewman3000", "NightCroweler",
				"karseius", "dracowhite", "danmanr98", "WorldSEnder"};
		String[] youtubersStrings = {"FuriousDestroyer"};
		ResourceLocation defaultCapeRes = null;

		ThreadDownloadImageData image = new ThreadDownloadImageData(null,
				capeURL, defaultCapeRes, null); // No postprocessing

		for (String username : devs) {
			Minecraft.getMinecraft().renderEngine.loadTexture(
					new ResourceLocation("cloaks/" + username), image);
		}
	}

}
