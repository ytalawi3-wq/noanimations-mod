package com.bedro.noanim.mixin;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Modded by Bedro
 */
@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> {

    @Inject(method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at = @At("HEAD"), cancellable = true)
    private void cancelBipedAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo ci) {
        BipedEntityModel<?> model = (BipedEntityModel<?>)(Object)this;
        
        model.rightArm.pitch = 0.0F;
        model.leftArm.pitch = 0.0F;
        model.rightLeg.pitch = 0.0F;
        model.leftLeg.pitch = 0.0F;
        
        model.head.yaw = headYaw * ((float)Math.PI / 180F);
        model.head.pitch = headPitch * ((float)Math.PI / 180F);

        ci.cancel();
    }
}
