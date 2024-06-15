package xueluoanping.dtbeachparty.systems;

import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import net.minecraft.resources.ResourceLocation;
import xueluoanping.dtbeachparty.DTBeachparty;
import xueluoanping.dtbeachparty.systems.growthlogic.CrookedPalmLogic;


public class ModGrowthLogicKits {
    public static final GrowthLogicKit CROOKED_PALM = new CrookedPalmLogic(new ResourceLocation(DTBeachparty.MOD_ID, "crooked_palm"));

    public static void register(final Registry<GrowthLogicKit> registry) {
        registry.register(CROOKED_PALM);
    }
}
