package com.szyzu.oombrella;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class OombrellaHelmetItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public OombrellaHelmetItem() {
        super(
                ArmorMaterials.LEATHER,
                Type.HELMET,
                new Item.Properties()
        );
    }

    @Override
    public void initializeClient(
            Consumer<IClientItemExtensions> consumer) {

        consumer.accept(new IClientItemExtensions() {

            private GeoArmorRenderer<?> renderer;

            @Override
            public HumanoidModel<?> getHumanoidArmorModel(
                    LivingEntity entity,
                    ItemStack stack,
                    EquipmentSlot slot,
                    HumanoidModel<?> original) {

                if (renderer == null)
                    renderer = new OombrellaHelmetRenderer();

                renderer.prepForRender(
                        entity, stack, slot, original
                );

                return renderer;
            }
        });
    }

    @Override
    public void registerControllers(
            AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache
    getAnimatableInstanceCache() {
        return cache;
    }
}
