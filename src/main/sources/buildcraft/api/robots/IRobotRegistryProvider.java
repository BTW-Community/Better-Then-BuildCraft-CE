package buildcraft.api.robots;

import net.minecraft.World;

public interface IRobotRegistryProvider {

    IRobotRegistry getRegistry(World world);
}
