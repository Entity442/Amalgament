package com.harbinger.amalgament.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class ColdTolerance {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity.isOnFire()) {
            if (entity instanceof LivingEntity _entity)
                _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 1, (false), (false)));
        } else if (world.getBiome(new BlockPos(x, y, z)).value().getBaseTemperature() * 100f <= 0.25) {
            new Vec3(0.6, 1, 0.6);
            if (world.getBiome(new BlockPos(x, y, z)).value().getBaseTemperature() * 100f <= 0) {
                new Vec3(0.4, 1, 0.4);
            }}
        else if (entity.isInPowderSnow) {
            if (entity instanceof LivingEntity _entity)
                _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, (false), (false)));
            new Vec3(0.4, 0.2, 0.4);
            }
    }
}

