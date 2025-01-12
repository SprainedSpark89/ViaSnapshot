/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2024 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package btw.lowercase.viasnapshot.protocol.v1_21_2to1_21_4_RC2;


import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;

import com.viaversion.viaversion.api.type.types.misc.ParticleType;

import com.viaversion.viaversion.api.type.types.version.Types1_21_4;

import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;

import btw.lowercase.viasnapshot.types.versions.Types1_21_4_RC2;

public final class Protocol1_21_2To1_21_4_RC2 extends Protocol1_21_2To1_21_4 {

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_21_4.initialize(this);
        Types1_21_4.PARTICLE.filler(this)
            .reader("block", ParticleType.Readers.BLOCK)
            .reader("block_marker", ParticleType.Readers.BLOCK)
            .reader("dust_pillar", ParticleType.Readers.BLOCK)
            .reader("falling_dust", ParticleType.Readers.BLOCK)
            .reader("block_crumble", ParticleType.Readers.BLOCK)
            .reader("dust", ParticleType.Readers.DUST1_21_2)
            .reader("dust_color_transition", ParticleType.Readers.DUST_TRANSITION1_21_2)
            .reader("vibration", ParticleType.Readers.VIBRATION1_20_3)
            .reader("sculk_charge", ParticleType.Readers.SCULK_CHARGE)
            .reader("shriek", ParticleType.Readers.SHRIEK)
            .reader("entity_effect", ParticleType.Readers.COLOR)
            .reader("trail", ParticleType.Readers.TRAIL1_21_4)
            .reader("item", ParticleType.Readers.item(itemRewriter.mappedItemType()));
        Types1_21_4_RC2.STRUCTURED_DATA.filler(this).add(StructuredDataKey.CUSTOM_DATA, StructuredDataKey.MAX_STACK_SIZE, StructuredDataKey.MAX_DAMAGE,
            StructuredDataKey.UNBREAKABLE, StructuredDataKey.RARITY, StructuredDataKey.HIDE_TOOLTIP, StructuredDataKey.DAMAGE_RESISTANT,
            StructuredDataKey.CUSTOM_NAME, StructuredDataKey.LORE, StructuredDataKey.ENCHANTMENTS, StructuredDataKey.CAN_PLACE_ON,
            StructuredDataKey.CAN_BREAK, StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP,
            StructuredDataKey.REPAIR_COST, StructuredDataKey.CREATIVE_SLOT_LOCK, StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE,
            StructuredDataKey.INTANGIBLE_PROJECTILE, StructuredDataKey.STORED_ENCHANTMENTS, StructuredDataKey.DYED_COLOR,
            StructuredDataKey.MAP_COLOR, StructuredDataKey.MAP_ID, StructuredDataKey.MAP_DECORATIONS, StructuredDataKey.MAP_POST_PROCESSING,
            StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, StructuredDataKey.WRITABLE_BOOK_CONTENT,
            StructuredDataKey.WRITTEN_BOOK_CONTENT, StructuredDataKey.TRIM1_21_4, StructuredDataKey.DEBUG_STICK_STATE, StructuredDataKey.ENTITY_DATA,
            StructuredDataKey.BUCKET_ENTITY_DATA, StructuredDataKey.BLOCK_ENTITY_DATA, StructuredDataKey.INSTRUMENT1_21_2,
            StructuredDataKey.RECIPES, StructuredDataKey.LODESTONE_TRACKER, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS,
            StructuredDataKey.PROFILE, StructuredDataKey.NOTE_BLOCK_SOUND, StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BASE_COLOR,
            StructuredDataKey.POT_DECORATIONS, StructuredDataKey.BLOCK_STATE, StructuredDataKey.BEES, StructuredDataKey.LOCK,
            StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.TOOL, StructuredDataKey.ITEM_NAME, StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER,
            StructuredDataKey.FOOD1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21,
            StructuredDataKey.REPAIRABLE, StructuredDataKey.ENCHANTABLE, StructuredDataKey.CONSUMABLE1_21_2,
            StructuredDataKey.USE_COOLDOWN, StructuredDataKey.DAMAGE, StructuredDataKey.EQUIPPABLE, StructuredDataKey.ITEM_MODEL,
            StructuredDataKey.GLIDER, StructuredDataKey.TOOLTIP_STYLE, StructuredDataKey.DEATH_PROTECTION,
            // Volatile thanks to containing item
            StructuredDataKey.CHARGED_PROJECTILES1_21_2, StructuredDataKey.BUNDLE_CONTENTS1_21_2, StructuredDataKey.CONTAINER1_21_2, StructuredDataKey.USE_REMAINDER1_21_2);
        super.onMappingDataLoaded();
    }
}