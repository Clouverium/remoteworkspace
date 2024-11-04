
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unknown.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.unknown.procedures.BowPropertyValueProviderProcedure;
import net.mcreator.unknown.item.BowItem;
import net.mcreator.unknown.UnknownMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnknownModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, UnknownMod.MODID);
	public static final RegistryObject<Item> BOW = REGISTRY.register("bow", () -> new BowItem());

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(BOW.get(), new ResourceLocation("unknown:bow_pulling"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) BowPropertyValueProviderProcedure.execute(entity));
		});
	}
}
