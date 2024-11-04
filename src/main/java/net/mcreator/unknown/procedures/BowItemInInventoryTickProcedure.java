package net.mcreator.unknown.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.unknown.init.UnknownModItems;

public class BowItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("BowLoading")) {
			if ((entity instanceof LivingEntity _entUseItem1 ? _entUseItem1.getUseItem() : ItemStack.EMPTY).getItem() == UnknownModItems.BOW.get()) {
				if ((entity instanceof LivingEntity _entUseItem3 ? _entUseItem3.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()
						&& entity.getPersistentData().getDouble("BowPull") < itemstack.getOrCreateTag().getDouble("BowMaxPull")) {
					entity.getPersistentData().putDouble("BowPull", (entity.getPersistentData().getDouble("BowPull") + 1));
				}
			} else {
				entity.getPersistentData().putBoolean("BowLoading", true);
				entity.getPersistentData().putDouble("BowPull", 0);
			}
		} else {
			entity.getPersistentData().putBoolean("BowLoading", true);
			entity.getPersistentData().putDouble("BowPull", 0);
		}
	}
}
