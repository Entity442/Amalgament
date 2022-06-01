package com.harbinger.amalgament.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class aCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> STRIKE;

    public static final ForgeConfigSpec.ConfigValue<Integer> GLOBAL_HEALTH;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLOBAL_DAMAGE;


    public static final ForgeConfigSpec.ConfigValue<Integer> GLUTTON_HP;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLUTTON_DAMAGE;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLUTTON_RANGE;

    static {
        BUILDER.push("Configs for the Amalgament");

        STRIKE = BUILDER.comment("The lightning damage is based on the " +
                "hp of the entity the lower the values the more damage it does " +
                "while the value of 1 kills it and 0 disables the damage").define("Lightning Strike", 4);

        GLOBAL_HEALTH = BUILDER.comment("Global Health Modifier")
                .define("health modifier", 1);
        GLOBAL_DAMAGE = BUILDER.comment("Global Health Modifier")
                .define("damage modifier", 1);



        GLUTTON_HP = BUILDER.comment("Glutton mob properties")
                .define("health", 25);
        GLUTTON_DAMAGE = BUILDER
                .define("damage", 8);
        GLUTTON_RANGE = BUILDER
                .define("range", 32);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
