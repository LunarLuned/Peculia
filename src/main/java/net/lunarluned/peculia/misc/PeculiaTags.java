package net.lunarluned.peculia.misc;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;

public class PeculiaTags {

    public static final TagKey<Item> ALERTING_ITEMS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("peculia", "alerting_items"));

    public static final TagKey<Instrument> TUSK_HORNS = TagKey.create(Registry.INSTRUMENT_REGISTRY, new ResourceLocation("peculia", "tusk_horns"));

}
