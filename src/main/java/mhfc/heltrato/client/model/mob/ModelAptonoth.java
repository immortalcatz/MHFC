package mhfc.heltrato.client.model.mob;

import mhfc.heltrato.MHFCMain;
import mhfc.heltrato.client.model.MHFCAnimator;
import mhfc.heltrato.common.entity.mob.EntityAptonoth;
import mhfc.heltrato.common.entity.mob.EntityTigrex;
import mhfc.heltrato.common.interfaces.iMHFC;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAptonoth extends ModelBase
{
	protected float animTick;
	public static final float PI = 3.141593F;
	private MHFCAnimator animator;
    ModelRenderer backbody;
    ModelRenderer blefthint;
    ModelRenderer bleftleg;
    ModelRenderer bleftfoot;
    ModelRenderer frontbody;
    ModelRenderer spine;
    ModelRenderer neckspine;
    ModelRenderer chest;
    ModelRenderer neck;
    ModelRenderer flefthint;
    ModelRenderer face;
    ModelRenderer nose;
    ModelRenderer mouth;
    ModelRenderer antler;
    ModelRenderer reard;
    ModelRenderer rearc;
    ModelRenderer leard;
    ModelRenderer learb;
    ModelRenderer antermid;
    ModelRenderer fleftleg;
    ModelRenderer fleftfoot;
    ModelRenderer frighthint;
    ModelRenderer taila;
    ModelRenderer tailb;
    ModelRenderer tailc;
    ModelRenderer taild;
    ModelRenderer frightleg;
    ModelRenderer frightfoot;
    ModelRenderer tailspine;
    ModelRenderer brhint;
    ModelRenderer brleg;
    ModelRenderer brfoot;
    ModelRenderer reara;
    ModelRenderer rearb;
    ModelRenderer taile;
    ModelRenderer chestcore;
    ModelRenderer tailcore;
    ModelRenderer fleftcore;
    ModelRenderer bleftcore;
    ModelRenderer frightcore;
    ModelRenderer brightcore;
  
  public ModelAptonoth()
  {
	  textureWidth = 256;
	  textureHeight = 128;
	  animator = new MHFCAnimator(this);
	  animTick = 0.0F;
      backbody = new ModelRenderer(this, 57, 40);
      backbody.addBox(-10F, 0F, 0F, 20, 19, 17);
      backbody.setRotationPoint(0F, -6F, 4F);
      backbody.setTextureSize(256, 128);
      backbody.mirror = true;
      setRotation(backbody, 0F, 0F, 0F);
      blefthint = new ModelRenderer(this, 161, 0);
      blefthint.addBox(0F, -4F, -4F, 6, 12, 8);
      blefthint.setRotationPoint(0F, 0F, 0F);
      blefthint.setTextureSize(256, 128);
      blefthint.mirror = true;
      setRotation(blefthint, -0.4363323F, 0F, 0F);
      bleftleg = new ModelRenderer(this, 161, 21);
      bleftleg.addBox(0.5F, 4F, -6.5F, 5, 11, 5);
      bleftleg.setRotationPoint(0F, 0F, 0F);
      bleftleg.setTextureSize(256, 128);
      bleftleg.mirror = true;
      setRotation(bleftleg, 0.1919862F, 0F, 0F);
      bleftfoot = new ModelRenderer(this, 161, 38);
      bleftfoot.addBox(0F, 14F, -4.5F, 6, 4, 6);
      bleftfoot.setRotationPoint(0F, 0F, 0F);
      bleftfoot.setTextureSize(256, 128);
      bleftfoot.mirror = true;
      setRotation(bleftfoot, 0F, 0F, 0F);
      frontbody = new ModelRenderer(this, 57, 0);
      frontbody.addBox(-9F, -8F, -18F, 18, 17, 22);
      frontbody.setRotationPoint(0F, 2F, 2F);
      frontbody.setTextureSize(256, 128);
      frontbody.mirror = true;
      setRotation(frontbody, 0F, 0F, 0F);
      spine = new ModelRenderer(this, 132, 49);
      spine.addBox(-2F, -6F, -15F, 4, 7, 34);
      spine.setRotationPoint(0F, -7F, 0F);
      spine.setTextureSize(256, 128);
      spine.mirror = true;
      setRotation(spine, 0F, 0F, 0F);
      neckspine = new ModelRenderer(this, 136, 49);
      neckspine.addBox(-1.5F, -12F, -3.5F, 3, 7, 11);
      neckspine.setRotationPoint(0F, 0F, 0F);
      neckspine.setTextureSize(256, 128);
      neckspine.mirror = true;
      setRotation(neckspine, 0.6108652F, 0F, 0F);
      chest = new ModelRenderer(this, 0, 82);
      chest.addBox(-6F, -6.5F, -6F, 12, 13, 6);
      chest.setRotationPoint(0F, 0F, 0F);
      chest.setTextureSize(256, 128);
      chest.mirror = true;
      setRotation(chest, -0.2617994F, 0F, 0F);
      neck = new ModelRenderer(this, 0, 53);
      neck.addBox(-4F, -3F, -22F, 8, 8, 20);
      neck.setRotationPoint(0F, 0F, 0F);
      neck.setTextureSize(256, 128);
      neck.mirror = true;
      setRotation(neck, -0.5934119F, 0F, 0F);
      flefthint = new ModelRenderer(this, 138, 0);
      flefthint.addBox(0F, -2F, -3F, 5, 12, 6);
      flefthint.setRotationPoint(0F, 0F, 0F);
      flefthint.setTextureSize(256, 128);
      flefthint.mirror = true;
      setRotation(flefthint, 0.2617994F, 0F, 0F);
      face = new ModelRenderer(this, 0, 0);
      face.addBox(-4.5F, -16F, -25.5F, 9, 12, 12);
      face.setRotationPoint(0F, 0F, 0F);
      face.setTextureSize(256, 128);
      face.mirror = true;
      setRotation(face, 0F, 0F, 0F);
      nose = new ModelRenderer(this, 0, 25);
      nose.addBox(-3.5F, -15.5F, -32F, 7, 6, 7);
      nose.setRotationPoint(0F, 0F, 0F);
      nose.setTextureSize(256, 128);
      nose.mirror = true;
      setRotation(nose, 0F, 0F, 0F);
      mouth = new ModelRenderer(this, 0, 39);
      mouth.addBox(-3.5F, -2.5F, -8F, 7, 5, 8);
      mouth.setRotationPoint(0F, -5.5F, -38F);
      mouth.setTextureSize(256, 128);
      mouth.mirror = true;
      setRotation(mouth, 0.0349066F, 0F, 0F);
      antler = new ModelRenderer(this, 1, 102);
      antler.addBox(-2F, -21.5F, -9F, 4, 3, 16);
      antler.setRotationPoint(0F, 0, 0F);
      antler.setTextureSize(256, 128);
      antler.mirror = true;
      setRotation(antler, 0.4363323F, 0F, 0F);
      reard = new ModelRenderer(this, 43, 0);
      reard.addBox(-7F, -11.5F, -21.5F, 14, 3, 3);
      reard.setRotationPoint(0F, 0F, 0F);
      reard.setTextureSize(256, 128);
      reard.mirror = true;
      setRotation(reard, 0F, 0F, 0F);
      rearc = new ModelRenderer(this, 43, 0);
      rearc.addBox(-7F, -14.5F, -17.5F, 14, 3, 3);
      rearc.setRotationPoint(0F, 0F, 0F);
      rearc.setTextureSize(256, 128);
      rearc.mirror = true;
      setRotation(rearc, 0F, 0F, 0F);
      leard = new ModelRenderer(this, 43, 7);
      leard.addBox(0F, -11F, -22F, 4, 2, 2);
      leard.setRotationPoint(0F, 0F, 0F);
      leard.setTextureSize(256, 128);
      leard.mirror = true;
      setRotation(leard, 0F, -0.2617994F, 0F);
      learb = new ModelRenderer(this, 43, 7);
      learb.addBox(2F, -14F, -18F, 4, 2, 2);
      learb.setRotationPoint(0F, 0F, 0F);
      learb.setTextureSize(256, 128);
      learb.mirror = true;
      setRotation(learb, 0F, -0.2617994F, 0F);
      antermid = new ModelRenderer(this, 26, 102);
      antermid.addBox(-5F, -22F, 3F, 10, 4, 5);
      antermid.setRotationPoint(0F, 0F, 0F);
      antermid.setTextureSize(256, 128);
      antermid.mirror = true;
      setRotation(antermid, 0.4363323F, 0F, 0F);
      fleftleg = new ModelRenderer(this, 138, 19);
      fleftleg.addBox(0.5F, 7F, 0F, 4, 10, 5);
      fleftleg.setRotationPoint(0F, 0F, 0F);
      fleftleg.setTextureSize(256, 128);
      fleftleg.mirror = true;
      setRotation(fleftleg, 0F, 0F, 0F);
      fleftfoot = new ModelRenderer(this, 138, 36);
      fleftfoot.addBox(0F, 14F, -0.5F, 5, 4, 6);
      fleftfoot.setRotationPoint(0F, 0F, 0F);
      fleftfoot.setTextureSize(256, 128);
      fleftfoot.mirror = true;
      setRotation(fleftfoot, 0F, 0F, 0F);
      frighthint = new ModelRenderer(this, 138, 0);
      frighthint.addBox(-5F, -2F, -3F, 5, 12, 6);
      frighthint.setRotationPoint(0F, 0F, 0F);
      frighthint.setTextureSize(256, 128);
      frighthint.mirror = true;
      setRotation(frighthint, 0.2617994F, 0F, 0F);
      taila = new ModelRenderer(this, 57, 77);
      taila.addBox(-6F, -6F, 0F, 12, 12, 12);
      taila.setRotationPoint(0F, 0F, 0F);
      taila.setTextureSize(256, 128);
      taila.mirror = true;
      setRotation(taila, -0.1745329F, 0F, 0F);
      tailb = new ModelRenderer(this, 57, 102);
      tailb.addBox(-5F, -5F, 8F, 10, 10, 15);
      tailb.setRotationPoint(0F, 0F, 0F);
      tailb.setTextureSize(256, 128);
      tailb.mirror = true;
      setRotation(tailb, -0.1745329F, 0F, 0F);
      tailc = new ModelRenderer(this, 108, 102);
      tailc.addBox(-4F, -4F, 22F, 8, 8, 17);
      tailc.setRotationPoint(0F, 0F, 0F);
      tailc.setTextureSize(256, 128);
      tailc.mirror = true;
      setRotation(tailc, -0.1745329F, 0F, 0F);
      taild = new ModelRenderer(this, 201, 101);
      taild.addBox(-10F, -2F, 28F, 20, 4, 4);
      taild.setRotationPoint(0F, 0F, 0F);
      taild.setTextureSize(256, 128);
      taild.mirror = true;
      setRotation(taild, -0.1745329F, 0F, 0F);
      frightleg = new ModelRenderer(this, 138, 19);
      frightleg.addBox(-4.5F, 8F, 0F, 4, 10, 5);
      frightleg.setRotationPoint(0F, 0F, 0F);
      frightleg.setTextureSize(256, 128);
      frightleg.mirror = true;
      setRotation(frightleg, 0F, 0F, 0F);
      frightfoot = new ModelRenderer(this, 138, 36);
      frightfoot.addBox(-5F, 15F, -0.5F, 5, 4, 6);
      frightfoot.setRotationPoint(0F, 0F, 0F);
      frightfoot.setTextureSize(256, 128);
      frightfoot.mirror = true;
      setRotation(frightfoot, 0F, 0F, 0F);
      tailspine = new ModelRenderer(this, 176, 49);
      tailspine.addBox(-1.5F, -9F, -9.5F, 3, 7, 15);
      tailspine.setRotationPoint(0F, 0F, 0F);
      tailspine.setTextureSize(256, 128);
      tailspine.mirror = true;
      setRotation(tailspine, -0.7504916F, 0F, 0F);
      brhint = new ModelRenderer(this, 161, 0);
      brhint.addBox(-6F, -4F, -4F, 6, 12, 8);
      brhint.setRotationPoint(0F, 0F, 0F);
      brhint.setTextureSize(256, 128);
      brhint.mirror = true;
      setRotation(brhint, -0.4363323F, 0F, 0F);
      brleg = new ModelRenderer(this, 161, 21);
      brleg.addBox(-5.5F, 4F, -6.5F, 5, 11, 5);
      brleg.setRotationPoint(0F, 0F, 0F);
      brleg.setTextureSize(256, 128);
      brleg.mirror = true;
      setRotation(brleg, 0.1919862F, 0F, 0F);
      brfoot = new ModelRenderer(this, 161, 38);
      brfoot.addBox(-6F, 14F, -4.5F, 6, 4, 6);
      brfoot.setRotationPoint(0F, 0F, 0F);
      brfoot.setTextureSize(256, 128);
      brfoot.mirror = true;
      setRotation(brfoot, 0F, 0F, 0F);
      reara = new ModelRenderer(this, 43, 7);
      reara.addBox(-4F, -11F, -22F, 4, 2, 2);
      reara.setRotationPoint(0F, 0F, 0F);
      reara.setTextureSize(256, 128);
      reara.mirror = true;
      setRotation(reara, 0F, 0.2617994F, 0F);
      rearb = new ModelRenderer(this, 43, 7);
      rearb.addBox(-5F, -14F, -18F, 4, 2, 2);
      rearb.setRotationPoint(0F, 0F, 0F);
      rearb.setTextureSize(256, 128);
      rearb.mirror = true;
      setRotation(rearb, 0F, 0.2617994F, 0F);
      taile = new ModelRenderer(this, 201, 92);
      taile.addBox(-9F, -1F, 33F, 18, 4, 4);
      taile.setRotationPoint(0F, 0F, 0F);
      taile.setTextureSize(256, 128);
      taile.mirror = true;
      setRotation(taile, -0.1745329F, 0F, 0F);
      chestcore = new ModelRenderer(this, 0, 0);
      chestcore.addBox(0F, 0F, 0F, 1, 1, 1);
      chestcore.setRotationPoint(0F, 1F, -14F);
      chestcore.setTextureSize(256, 128);
      chestcore.mirror = true;
      setRotation(chestcore, 0F, 0F, 0F);
      tailcore = new ModelRenderer(this, 0, 0);
      tailcore.addBox(0F, 0F, 0F, 1, 1, 1);
      tailcore.setRotationPoint(0F, 0F, 20F);
      tailcore.setTextureSize(256, 128);
      tailcore.mirror = true;
      setRotation(tailcore, 0F, 0F, 0F);
      fleftcore = new ModelRenderer(this, 0, 0);
      fleftcore.addBox(0F, 0F, 0F, 1, 1, 1);
      fleftcore.setRotationPoint(9F, 5F, -10F);
      fleftcore.setTextureSize(256, 128);
      fleftcore.mirror = true;
      setRotation(fleftcore, 0F, 0F, 0F);
      bleftcore = new ModelRenderer(this, 0, 0);
      bleftcore.addBox(0F, 0F, 0F, 1, 1, 1);
      bleftcore.setRotationPoint(9.5F, 6F, 13F);
      bleftcore.setTextureSize(256, 128);
      bleftcore.mirror = true;
      setRotation(bleftcore, 0F, 0F, 0F);
      frightcore = new ModelRenderer(this, 0, 0);
      frightcore.addBox(0F, 0F, 0F, 1, 1, 1);
      frightcore.setRotationPoint(-9F, 5F, -10F);
      frightcore.setTextureSize(256, 128);
      frightcore.mirror = true;
      setRotation(frightcore, 0F, 0F, 0F);
      brightcore = new ModelRenderer(this, 0, 0);
      brightcore.addBox(0F, 0F, 0F, 1, 1, 1);
      brightcore.setRotationPoint(-9.5F, 6F, 13F);
      brightcore.setTextureSize(256, 128);
      brightcore.mirror = true;
      setRotation(brightcore, 0F, 0F, 0F);
      
      tailcore.addChild(taila);
      tailcore.addChild(tailb);
      tailcore.addChild(tailc);
      tailcore.addChild(taild);
      tailcore.addChild(taile);
      tailcore.addChild(tailspine);
      chestcore.addChild(neck);
      chestcore.addChild(chest);
      chestcore.addChild(face);
      chestcore.addChild(nose);
      chestcore.addChild(rearc);
      chestcore.addChild(rearb);
      chestcore.addChild(reara);
      chestcore.addChild(reard);
      chestcore.addChild(leard);
      chestcore.addChild(learb);
      chestcore.addChild(antler);
      chestcore.addChild(antermid);
      chestcore.addChild(neckspine);
      fleftcore.addChild(flefthint);
      fleftcore.addChild(fleftleg);
      fleftcore.addChild(fleftfoot);
      frightcore.addChild(frighthint);
      frightcore.addChild(frightleg);
      frightcore.addChild(frightfoot);
      bleftcore.addChild(blefthint);
      bleftcore.addChild(bleftleg);
      bleftcore.addChild(bleftfoot);
      brightcore.addChild(brhint);
      brightcore.addChild(brleg);
      brightcore.addChild(brfoot);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	animator.update((iMHFC)entity);
	setAngles();
	EntityAptonoth aptonoth = (EntityAptonoth)entity;
	animTick = MHFCMain.proxy.getPartialTick();
	animate((EntityAptonoth)entity,f,f1,f2,f3,f4,f5);
    backbody.render(f5);
    frontbody.render(f5);
    spine.render(f5);
    mouth.render(f5);
    chestcore.render(f5);
    tailcore.render(f5);
    fleftcore.render(f5);
    bleftcore.render(f5);
    frightcore.render(f5);
    brightcore.render(f5);
    
   
  }
  
  public void animate(EntityAptonoth entity, float f, float f1, float f2,float f3, float f4, float f5) {
	  float walkAnim1 = (MathHelper.sin((f - 0.7F) * 0.4F) + 0.7F) * f1;
      float walkAnim2 = -(MathHelper.sin((f + 0.7F) * 0.4F) - 0.7F) * f1;
      float walkAnim = MathHelper.sin(f * 0.4F) * f1;
      float breatheAnim = MathHelper.cos(f2 * 0.11F);
      float faceYaw = (f3 * 3.141593F) / 180F;
      float facePitch = (f4 * 3.141593F) / 180F;
      float neckAnimY = f3 / (180F / (float)PI);
      float neckAnimX = f4 / (180F / (float)PI);
      float footAnimX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      float footAnimY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
      float tailBreathe = MathHelper.sin(f2 * 0.14F);
      
      chestcore.rotateAngleX -= breatheAnim * 0.018F;
      fleftcore.rotateAngleX = walkAnim2 * 0.6f;
      frightcore.rotateAngleX = walkAnim1 * 0.6f;
      bleftcore.rotateAngleX = walkAnim1 *0.6f;
      brightcore.rotateAngleX = walkAnim2 * 0.6f;
      tailcore.rotateAngleY -= tailBreathe * 0.07f;
  }

  public void setAngles(){
    setRotation(backbody, 0F, 0F, 0F);
    setRotation(blefthint, -0.4363323F, 0F, 0F);
    setRotation(bleftleg, 0.1919862F, 0F, 0F);
    setRotation(bleftfoot, 0F, 0F, 0F);
    setRotation(frontbody, 0F, 0F, 0F);
    setRotation(spine, 0F, 0F, 0F);
    setRotation(neckspine, 0.6108652F, 0F, 0F);
    setRotation(chest, -0.2617994F, 0F, 0F);
    setRotation(neck, -0.5934119F, 0F, 0F);
    setRotation(flefthint, 0.2617994F, 0F, 0F);
    setRotation(face, 0F, 0F, 0F);
    setRotation(nose, 0F, 0F, 0F);
    setRotation(mouth, 0.0349066F, 0F, 0F);
    setRotation(antler, 0.4363323F, 0F, 0F);
    setRotation(reard, 0F, 0F, 0F);
    setRotation(rearc, 0F, 0F, 0F);
    setRotation(leard, 0F, -0.2617994F, 0F);
    setRotation(learb, 0F, -0.2617994F, 0F);
    setRotation(antermid, 0.4363323F, 0F, 0F);
    setRotation(fleftleg, 0F, 0F, 0F);
    setRotation(fleftfoot, 0F, 0F, 0F);
    setRotation(frighthint, 0.2617994F, 0F, 0F);
    setRotation(taila, -0.1745329F, 0F, 0F);
    setRotation(tailb, -0.1745329F, 0F, 0F);
    setRotation(tailc, -0.1745329F, 0F, 0F);
    setRotation(taild, -0.1745329F, 0F, 0F);
    setRotation(frightleg, 0F, 0F, 0F);
    setRotation(frightfoot, 0F, 0F, 0F);
    setRotation(tailspine, -0.7504916F, 0F, 0F);
    setRotation(brhint, -0.4363323F, 0F, 0F);
    setRotation(brleg, 0.1919862F, 0F, 0F);
    setRotation(brfoot, 0F, 0F, 0F);
    setRotation(reara, 0F, 0.2617994F, 0F);
    setRotation(rearb, 0F, 0.2617994F, 0F);
    setRotation(taile, -0.1745329F, 0F, 0F);
    setRotation(chestcore, 0F, 0F, 0F);
    setRotation(tailcore, 0F, 0F, 0F);
    setRotation(fleftcore, 0F, 0F, 0F);
    setRotation(bleftcore, 0F, 0F, 0F);
    setRotation(frightcore, 0F, 0F, 0F);
    setRotation(brightcore, 0F, 0F, 0F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  

}
