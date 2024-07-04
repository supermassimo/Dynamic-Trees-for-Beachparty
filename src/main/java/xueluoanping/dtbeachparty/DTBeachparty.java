package xueluoanping.dtbeachparty;

import com.ferreusveritas.dynamictrees.api.GatherDataHelper;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;

import com.ferreusveritas.dynamictrees.block.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.block.rooty.SoilProperties;
import com.ferreusveritas.dynamictrees.resources.Resources;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xueluoanping.dtbeachparty.data.start;

import java.util.List;
import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DTBeachparty.MOD_ID)
public class DTBeachparty {
    public static final String MOD_ID = "dtbeachparty";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final boolean useLogger=Objects.equals(System.getProperty("forgegradle.runs.dev"), "true");

    public DTBeachparty() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::gatherData);
        DTBeachpartyRegistries.SOUNDS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // MinecraftForge.EVENT_BUS.register(TreeGrowHandler.instance);
        RegistryHandler.setup(MOD_ID);



    }

    public void gatherData(final GatherDataEvent event) {
         Resources.MANAGER.gatherData();
         GatherDataHelper.gatherAllData(MOD_ID, event,
                 SoilProperties.REGISTRY,
                 Family.REGISTRY,
                 Species.REGISTRY,
                 LeavesProperties.REGISTRY
         );
        start.dataGen(event);
    }

    public static void logger(Object... x) {

        // if (General.bool.get())
        if (useLogger) {
            StringBuilder output = new StringBuilder();

            for (Object i : x) {
                if (i == null) output.append(", ").append("null");
                else if (i.getClass().isArray()) {
                    output.append(", [");
                    for (Object c : (int[]) i) {
                        output.append(c).append(",");
                    }
                    output.append("]");
                } else if (i instanceof List) {
                    output.append(", [");
                    for (Object c : (List) i) {
                        output.append(c);
                    }
                    output.append("]");
                } else
                    output.append(", ").append(i);
            }
            LOGGER.info(output.substring(1));
        }
    }

    public static ResourceLocation rl(String name) {
        return new ResourceLocation(DTBeachparty.MOD_ID, name);
    }
}
