package com.szyzu.oombrella;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class OombrellaLightManager {
    private static final int LIGHT_LEVEL = 0;
    private static final Map<UUID, BlockPos> PLAYER_LIGHTS = new HashMap<>();

    public static void update(Player player){
        Level level = player.level();

        if(level.isClientSide)
            return;

        BlockPos oldPos = PLAYER_LIGHTS.getOrDefault(player.getUUID(), new BlockPos(0, 0, 0));
        BlockPos newPos = player.blockPosition();

        // add Light

        if(oldPos != newPos && level.getBlockState(oldPos).is(Blocks.LIGHT))
            level.removeBlock(oldPos, false);

        PLAYER_LIGHTS.put(player.getUUID(), newPos);
    }

    private static void addLight(Level level, BlockPos pos){
        if(!level.getBlockState(pos).isAir())
            return;

        BlockState light = Blocks.LIGHT.defaultBlockState()
                .setValue(
                        LightBlock.LEVEL,
                        LIGHT_LEVEL
                );

        level.setBlockAndUpdate(pos, light);
    }

    public static void remove(Player player){
        BlockPos pos = PLAYER_LIGHTS.remove(player.getUUID());
        if(pos == null)
            return;

        Level level = player.level();

        if(level.getBlockState(pos).is(Blocks.LIGHT)){
            level.removeBlock(pos, false);
        }
    }
}
