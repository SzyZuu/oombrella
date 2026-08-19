package com.szyzu.oombrella;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class OombrellaHelmetRenderer extends GeoArmorRenderer<OombrellaHelmetItem> {
    public OombrellaHelmetRenderer() {
        super(new DefaultedItemGeoModel<>(
                new ResourceLocation(
                        "oombrella",
                        "armor/oombrella_helmet"
                )
        ));
    }
}
