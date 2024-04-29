package com.aaronhowser.mods.realisticsuffocation.sounds;

import com.aaronhowser.mods.realisticsuffocation.RealisticSuffocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {

    public static DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(
                    BuiltInRegistries.SOUND_EVENT,
                    RealisticSuffocation.MODID);

    public SoundEvent RAGDOLL = registerSoundEvent("ragdoll").get();

    @SuppressWarnings("SameParameterValue")
    private DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(
                name,
                () -> SoundEvent.createFixedRangeEvent(
                        new ResourceLocation("realisticsuffocation", name),
                        1f
                )
        );
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
