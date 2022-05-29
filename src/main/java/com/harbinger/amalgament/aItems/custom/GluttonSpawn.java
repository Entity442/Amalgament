package com.harbinger.amalgament.aItems.custom;

import com.harbinger.amalgament.aEntities.Entities.Glutton;
import com.harbinger.amalgament.aEntities.aEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class GluttonSpawn extends Item {
    public GluttonSpawn(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult retval = super.useOn(context);
        TitanSpawn.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
                context.getClickedPos().getZ(), context.getItemInHand());
        return retval;
    }


    public class TitanSpawn {
        public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = new Glutton(aEntities.GLUTTON.get(), _level);
                entityToSpawn.moveTo(x, y + 1, z, world.getRandom().nextFloat() * 360F, 0);
                if (entityToSpawn instanceof Mob _mobToSpawn)
                    _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                world.addFreshEntity(entityToSpawn);
            }
            {
                ItemStack _ist = itemstack;
                if (_ist.hurt(1, new Random(), null)) {
                    _ist.shrink(1);
                    _ist.setDamageValue(0);
                }
            }
        }
    }
}
