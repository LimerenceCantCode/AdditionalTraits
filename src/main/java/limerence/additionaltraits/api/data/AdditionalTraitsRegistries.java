package limerence.additionaltraits.api.data;

import codersafterdark.reskillable.api.skill.Skill;
import codersafterdark.reskillable.api.unlockable.Unlockable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class AdditionalTraitsRegistries {
    public final static IForgeRegistry<Skill> SKILLS = GameRegistry.findRegistry(Skill.class);
    public final static IForgeRegistry<Unlockable> UNLOCKABLES = GameRegistry.findRegistry(Unlockable.class);
}