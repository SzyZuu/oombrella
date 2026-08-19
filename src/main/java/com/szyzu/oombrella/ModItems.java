package com.szyzu.oombrella;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Oombrella.MODID);
    public static final RegistryObject<Item> OOMBRELLA_HELMET = ITEMS.register("oombrella_helmet", OombrellaHelmetItem::new);
}
