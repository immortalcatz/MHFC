package mhfc.heltrato.common.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


/**
 * @author Heltrato
 * 
 * MHF Configuration Files Created for the fix of ID Conflicts in 1.6.4 however this wouldnt be last as 1.7 will
 * going be release for Forge and MCP .
 * 
 * DN: public<? for easy access;
 * DN: int<? no dec. variables;
 * 
 *
 */

public class MHFCConfig {
	
	
	public static boolean spawnTigrex;
	public static boolean spawnKirin;
	public static boolean setupComplexGraphics = false;// this initialize a improved game graphics for future use .
	
	public static void init(FMLPreInitializationEvent e){
		Configuration config = new Configuration(new File("config/MHFC.cfg"));
		

		spawnTigrex = config.get("MHFC Mobs", "Summon Tigrex", true).getBoolean(true);
		spawnKirin = config.get("MHFC Mobs", "Summon Kirin", true).getBoolean(true);
		
		
		config.save();
}
}