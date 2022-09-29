package net.lunarluned.peculia.misc;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PeculiaTags {

    public static final TagKey<Item> ALERTING_ITEMS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("peculia", "alerting_items"));
    public static final TagKey<Item> SPOOKY_ITEMS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("peculia", "spooky_items"));

}
