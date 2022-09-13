package net.lunarluned.peculia.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PeculiaTags {
    public static final TagKey<Item> ALERTING_ITEMS = TagKey.of(Registry.ITEM_KEY, new Identifier("peculia", "alerting_items"));
}
