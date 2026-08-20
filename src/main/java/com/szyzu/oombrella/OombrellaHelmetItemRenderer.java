package com.szyzu.oombrella;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OombrellaHelmetItemRenderer extends GeoItemRenderer<OombrellaHelmetItem> {
    public OombrellaHelmetItemRenderer(){
        super(new DefaultedItemGeoModel<>(
                new ResourceLocation(
                        "oombrella",
                        "armor/oombrella_helmet_item"
                )
        ));
    }
}
