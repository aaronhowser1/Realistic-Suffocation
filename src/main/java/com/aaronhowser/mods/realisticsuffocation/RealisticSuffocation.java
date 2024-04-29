package com.aaronhowser.mods.realisticsuffocation;

import com.aaronhowser.mods.realisticsuffocation.sounds.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.world.damagesource.DamageTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.slf4j.Logger;

@Mod(RealisticSuffocation.MODID)
public class RealisticSuffocation {

    public static final String MODID = "realisticsuffocation";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RealisticSuffocation(IEventBus modEventBus, ModContainer modContainer) {
        ModSounds.register(modEventBus);
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class CommonEvents {
        @SubscribeEvent
        public static void onLivingDamage(LivingDamageEvent event) {
            if (!event.getSource().is(DamageTypes.IN_WALL)) {
//                event.getEntity().playSound(ModSounds.RAGDOLL);
            }
        }
    }
}
