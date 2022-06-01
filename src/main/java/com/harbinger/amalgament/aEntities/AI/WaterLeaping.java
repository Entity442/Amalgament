package com.harbinger.amalgament.aEntities.AI;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;

public class WaterLeaping extends LeapAtTargetGoal {
    private Entity mob;

    public WaterLeaping(Mob p_25492_, float p_25493_) {
        super(p_25492_, p_25493_);
    }

    public boolean canUse() {
        if (this.mob.isInWater() || this.mob.isSwimming()) {
            return true;

        }
        return false;
    }
    public boolean canContinueToUse() {
        return (this.mob.isInWater() || this.mob.isSwimming());
    }



}
