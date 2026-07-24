# Forge port info
regex replace: 
```regexp
net\.minecraft[^f]\.?(?:[a-z]+)?\.?(?:[a-z]+)?\.?(?:[a-z]+)?\.?(?:[a-z]+)?\.([A-Z_$][a-zA-Z\d_$]+)
```
with `net.minecraft.src.$1`

## 1.7 names to 1.6 names:
### Vanilla 
IIcon => Icon
IIconProvider => IconProvider
IIconRegister => IconRegister
BlockFalling => FallingBlock
BlockLiquid => BlockFluid

### FML
cpw.mods.fml.relauncher.EnvType => EnvType;
import cpw.mods.fml.relauncher.SideOnly => Environment;
## Added shims/extensions
- ForgeDirection
- Forge Fluid API
- Netty Byte Buf