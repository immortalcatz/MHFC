package mhfc.net.common.util;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import net.minecraft.util.ResourceLocation;

public class UtilitiesTest {

	ResourceLocation location = new ResourceLocation("mhfc:sounds.json");
	ResourceLocation location_wrong = new ResourceLocation("mhfc:not_there/en_US.lang");

	@Test
	public void test() throws IOException {
		try (
				InputStream stream = ResourceLocations.openEmbeddedResource(location);
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
			assertTrue(reader.ready());
		}
	}

	@Test(expected = IOException.class)
	public void testWrongFile() throws IOException {
		try (InputStream stream = ResourceLocations.openEmbeddedResource(location_wrong)) {
			assertTrue(stream == null);
		}
	}

}
