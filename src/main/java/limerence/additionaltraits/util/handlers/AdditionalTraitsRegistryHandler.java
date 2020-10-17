package limerence.additionaltraits.util.handlers;

import codersafterdark.reskillable.api.skill.Skill;
import codersafterdark.reskillable.api.unlockable.Unlockable;
import limerence.additionaltraits.skill.SkillAdditionalTraits;
import limerence.additionaltraits.skill.additionaltraits.TraitBarter;
import limerence.additionaltraits.skill.additionaltraits.TraitBlackBlood;
import limerence.additionaltraits.skill.additionaltraits.TraitBloodSacrifice;
import limerence.additionaltraits.skill.additionaltraits.TraitBonusSaturation;
import limerence.additionaltraits.skill.additionaltraits.TraitBrewingSpeed;
import limerence.additionaltraits.skill.additionaltraits.TraitCombatXP;
import limerence.additionaltraits.skill.additionaltraits.TraitDamageIncrease;
import limerence.additionaltraits.skill.additionaltraits.TraitDamageResist;
import limerence.additionaltraits.skill.additionaltraits.TraitDivineProtection;
import limerence.additionaltraits.skill.additionaltraits.TraitGlobalXP;
import limerence.additionaltraits.skill.additionaltraits.TraitHealthIncrease;
import limerence.additionaltraits.skill.additionaltraits.TraitHolyRush;
import limerence.additionaltraits.skill.additionaltraits.TraitMasterEnchanter;
import limerence.additionaltraits.skill.additionaltraits.TraitNaturalFisher;
import limerence.additionaltraits.skill.additionaltraits.TraitPact;
import limerence.additionaltraits.skill.additionaltraits.TraitPhaseWalk;
import limerence.additionaltraits.util.init.ItemInit;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



@Mod.EventBusSubscriber
public class AdditionalTraitsRegistryHandler{
	


	@SubscribeEvent
	public static void registerMoreSkills(RegistryEvent.Register<Skill> skillRegister) {

	System.out.println("Attempting Skill Registry");
	skillRegister.getRegistry().registerAll(new Skill[]{new SkillAdditionalTraits()});
	}

	@SubscribeEvent
	public static void registerMoreTraits(RegistryEvent.Register<Unlockable> unlockablesRegister) {
		unlockablesRegister.getRegistry().registerAll(new Unlockable[]{new TraitBloodSacrifice(), new TraitCombatXP(),
		new TraitDamageResist(), new TraitHealthIncrease(), new TraitBlackBlood(), new TraitBrewingSpeed(), new TraitDivineProtection(),
		new TraitPact(), new TraitMasterEnchanter(), new TraitHolyRush(), new TraitPhaseWalk(), new TraitGlobalXP(),
		new TraitNaturalFisher(), new TraitBarter(), new TraitBonusSaturation(), new TraitDamageIncrease(),
		});
		System.out.println("MORE TRAITS REGISTERED!");
	}
//new TraitValkyrieBlessing()

}


