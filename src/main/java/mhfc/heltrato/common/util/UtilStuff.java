package mhfc.heltrato.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mhfc.heltrato.MHFCMain;
import mhfc.heltrato.common.core.registry.MHFCRegItem;
import mhfc.heltrato.common.core.registry.MHFCRegPotion;
import mhfc.heltrato.common.entity.type.EntityWyvernHostile;
import mhfc.heltrato.common.entity.type.EntityWyvernPeaceful;
import mhfc.heltrato.common.interfaces.iMHFC;
import mhfc.heltrato.common.network.message.MessageAIAnim;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class UtilStuff {
	
	private static MHFCRegItem item;
	private static Random rand;
	
	
	public UtilStuff() {
		rand = new Random();
	}
	
	
	public static void sendAnimPacket(iMHFC entity, int animID) {
		if(MHFCMain.isEffectiveClient()) return;
		entity.setAnimID(animID);
		Entity e = (Entity)entity;
		MHFCMain.network.sendToAll(new MessageAIAnim((byte)animID, e.getEntityId()));
	}
	
	
	public static ArrayList<Entity> getCollidingEntities(Entity entity, World world, AxisAlignedBB box)
	{
		ArrayList list = new ArrayList();
	    List entities = world.getEntitiesWithinAABBExcludingEntity(entity, box.expand(4.0D, 4.0D, 4.0D));
	    for (int i = 0; i < entities.size(); i++) {
	    Entity entity1 = (Entity)entities.get(i);
	    AxisAlignedBB box1 = entity1.boundingBox;
	    if ((box1 != null) && (box.intersectsWith(box1))) list.add(entity1);
	    }
	    return list;
	}
	
	 public static void removeAttackers(EntityLiving living) {
		 List list = living.worldObj.getEntitiesWithinAABB(EntityLiving.class, living.boundingBox.expand(16.0D, 10.0D, 16.0D));
		 for (int i = 0; i < list.size(); i++) {
			 EntityLiving attacker = (EntityLiving)list.get(i);
			 if ((attacker != living) && 
					 (attacker.getAttackTarget() == living)) {
				 		attacker.setAttackTarget(null);
				 		attacker.setRevengeTarget(null);
	       }
	   }
	
	 }
	 
	 public static void changeAttackInto(EntityLiving living, float movespeed, EntityLiving e) {
		 List list = living.worldObj.getEntitiesWithinAABB(EntityLiving.class, living.boundingBox.expand(16.0D, 10.0D, 16.0D));
		 for ( int i = 0; i < list.size(); i++) {
			 EntityLiving attacker = (EntityLiving)list.get(i);
			 if(attacker != living){
				 attacker.setAttackTarget(e);
				 attacker.setRevengeTarget(e);
			 }
		 }
 		
	 }
	 
	 public static void getFeedMob(EntityWyvernHostile wyvern, float amountHp ){
		 List list = wyvern.worldObj.getEntitiesWithinAABB(EntityWyvernHostile.class, wyvern.boundingBox.expand(12.0D, 3.0D, 12.0D));
		 for ( int i = 0; i < list.size(); i++) {
			 EntityLiving food = (EntityLiving)list.get(i);
			 if(food instanceof EntityWyvernPeaceful || food instanceof EntityAnimal){
				 wyvern.setAttackTarget(food);
				 wyvern.heal(amountHp);
			 }
		 }
	 }
	 
	 
	 
	 public static void chargeMobToEntity(EntityWyvernHostile chargingEntity, Entity target, float distance, float moveSpeed, boolean dependsonWater){
		 PathEntity pathentity = chargingEntity.worldObj.getPathEntityToEntity(chargingEntity, target, 16, false, false, dependsonWater, true);
		 if((pathentity != null) && (distance < 12.0F)){
			 chargingEntity.setPathToEntity(pathentity);
			 chargingEntity.speed = moveSpeed;
		 }
	 }
	 
	 public static int countPlayers(WorldServer worldObj, int dimension) {
		 int players = 0;
		 for( int i = 0; i < worldObj.playerEntities.size() ; i++ ) {
			 EntityPlayerMP entityplayermp = (EntityPlayerMP)worldObj.playerEntities.get(i);
			 
			 if(entityplayermp.dimension == dimension) {
				 players++;
			 }
		 }
		 System.out.println(players);
		 return players;
	 }
	 
	 public static void updateArmorTick(World world,EntityPlayer player) {
		 ItemStack[] armorstack = new ItemStack[4];
		 	armorstack[0] = player.inventory.armorItemInSlot(0);
		 	armorstack[1] = player.inventory.armorItemInSlot(1);
		 	armorstack[2] = player.inventory.armorItemInSlot(2);
		 	armorstack[3] = player.inventory.armorItemInSlot(3);
		 	
		if((armorstack[0] != null) && (armorstack[0].getItem() == item.mhfcitemkirinhelm) && (armorstack[1] != null) && (armorstack[1].getItem() == item.mhfcitemkirinchest) && (armorstack[2] != null) && (armorstack[2].getItem() == item.mhfcitemkirinlegs) && (armorstack[3] != null) && (armorstack[3].getItem() == item.mhfcitemkirinboots)) {
			return;
		}
		if((armorstack[0] != null) && (armorstack[0].getItem() == item.mhfcitemkirinShelm) && (armorstack[1] != null) && (armorstack[1].getItem() == item.mhfcitemkirinSchest) && (armorstack[2] != null) && (armorstack[2].getItem() == item.mhfcitemkirinSlegs) && (armorstack[3] != null) && (armorstack[3].getItem() == item.mhfcitemkirinSboots)) {
			int duration = 15;
			player.addPotionEffect(new PotionEffect(MHFCRegPotion.mhfcpotionkirinbless.id, duration++, 1));
			world.spawnParticle("cloud", player.posX + rand.nextFloat() * 2.0F - 1.0D, player.posY + rand.nextFloat() * 3.0F + 1.0D, player.posZ + rand.nextFloat() * 2.0F - 1.0D, 0.0D, 0.0D, 0.0D);
			return;
		}
		if((armorstack[0] != null) && (armorstack[0].getItem() == item.mhfcitemtigrexhelm) && (armorstack[1] != null) && (armorstack[1].getItem() == item.mhfcitemtigrexchest) && (armorstack[2] != null) && (armorstack[2].getItem() == item.mhfcitemtigrexlegs) && (armorstack[3] != null) && (armorstack[3].getItem() == item.mhfcitemtigrexboots)) {
			return;
		}
		
		if((armorstack[0] != null) && (armorstack[0].getItem() == item.mhfcitemrathaloshelm) && (armorstack[1] != null) && (armorstack[1].getItem() == item.mhfcitemrathaloschest) && (armorstack[2] != null) && (armorstack[2].getItem() == item.mhfcitemrathaloslegs) && (armorstack[3] != null) && (armorstack[3].getItem() == item.mhfcitemrathalosboots)) {
			return;
		}
		 	
	 }
	 
		 
	 
	 
}
