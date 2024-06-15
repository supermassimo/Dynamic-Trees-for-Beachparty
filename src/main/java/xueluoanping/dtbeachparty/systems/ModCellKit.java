package xueluoanping.dtbeachparty.systems;


import com.ferreusveritas.dynamictrees.api.cell.CellKit;
import com.ferreusveritas.dynamictrees.api.registry.Registry;
import net.minecraft.resources.ResourceLocation;
import xueluoanping.dtbeachparty.DTBeachparty;
import xueluoanping.dtbeachparty.systems.cell.CoconutCellKit;


public class ModCellKit {
    public static final CoconutCellKit COCONUT_CELL_KIT = new CoconutCellKit(regName("coconut"));


    private static ResourceLocation regName(String name) {
        return DTBeachparty.rl(name);
    }

    public static void register(final Registry<CellKit> registry) {
        registry.register(COCONUT_CELL_KIT);
    }
}
