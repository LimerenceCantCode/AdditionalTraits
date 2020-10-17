package limerence.additionaltraits.entity.events;

import java.util.List;

import javax.annotation.Nonnegative;

import com.google.common.base.Preconditions;

import limerence.additionaltraits.entity.EntityNatFishHook;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class DifferentItemFishedEvent extends PlayerEvent  {

		private final NonNullList<ItemStack> stacks = NonNullList.create();
		private final EntityNatFishHook hook;
		private int rodDamage;

		public DifferentItemFishedEvent(List<ItemStack> stacks, EntityNatFishHook entityNatFishHook) {
			super(entityNatFishHook.getAngler());
			this.stacks.addAll(stacks);
			this.rodDamage = rodDamage;
			this.hook = entityNatFishHook;
		}

		public int getRodDamage() {
			return rodDamage;
		}

		public void damageRodBy(@Nonnegative int rodDamage) {
			Preconditions.checkArgument(rodDamage >= 0);
			this.rodDamage = rodDamage;
		}

		public NonNullList<ItemStack> getDrops() {
			return stacks;
		}

		public EntityNatFishHook getHookEntity() {
			return hook;
		}
	}


