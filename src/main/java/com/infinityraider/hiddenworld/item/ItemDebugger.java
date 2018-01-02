package com.infinityraider.hiddenworld.item;

import com.google.common.collect.ImmutableList;
import com.infinityraider.hiddenworld.ghostworld.entity.EnumPresence;
import com.infinityraider.hiddenworld.ghostworld.entity.GhostAura;
import com.infinityraider.infinitylib.item.IItemWithModel;
import com.infinityraider.infinitylib.item.ItemDebuggerBase;
import com.infinityraider.infinitylib.utility.debug.DebugMode;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ItemDebugger extends ItemDebuggerBase implements IItemWithModel {
    public ItemDebugger() {
        super();
    }

    @Override
    protected List<DebugMode> getDebugModes() {
        return ImmutableList.of(DebugModeCyclePresence.INSTANCE);
    }

    private static class DebugModeCyclePresence extends DebugMode {
        public static final DebugModeCyclePresence INSTANCE = new DebugModeCyclePresence();

        private DebugModeCyclePresence() {}

        @Override
        public String debugName() {
            return "cycle_presence";
        }

        private void cyclePresence(EntityPlayer player) {
            if(!player.getEntityWorld().isRemote) {
                GhostAura.getAura(player).ifPresent(aura -> {
                    EnumPresence presence = aura.getPresence();
                    int index = (presence.ordinal() + 1) % EnumPresence.values().length;
                    aura.setPresence(EnumPresence.values()[index]);
                });
            }
        }

        @Override
        public void debugActionBlockClicked(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
            cyclePresence(player);
        }

        @Override
        public void debugActionClicked(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
            cyclePresence(player);
        }

        @Override
        public void debugActionEntityClicked(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand) {
            cyclePresence(player);
        }
    }
}