package com.harbinger.amalgament.procedures;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LightningStrike {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        entity.hurt(DamageSource.LIGHTNING_BOLT, (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4));
    }

}
