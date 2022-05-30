package com.harbinger.amalgament.aEntities;

import com.harbinger.amalgament.procedures.ColdTolerance;
import com.harbinger.amalgament.procedures.LightningStrike;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class AmalgamEntity extends Monster {

    protected AmalgamEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }




    @Override
    public void baseTick() {
        super.baseTick();
        ColdTolerance.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
    }
    @Override
    public void thunderHit(ServerLevel serverWorld, LightningBolt lightningBolt) {
        super.thunderHit(serverWorld, lightningBolt);
        LightningStrike.execute(this);
    }
    @Override
    public void die(DamageSource source) {
        super.die(source);

    }
}
