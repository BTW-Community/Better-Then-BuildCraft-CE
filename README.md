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
GameType => EnumGameType
ChatComponentTranslation => ChatMessageComponent
INetHandler => NetHandler
NetHandlerPlayServer => NetServerHandler

### FML
cpw.mods.fml.relauncher.EnvType => net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment => net.fabricmc.api.Environment;

## 1.7 method names to 1.6 names:
### Vanilla
Block.registerBlockIcons => registerIcons
## Added shims/extensions
- ForgeDirection
- Forge Fluid API
- Netty Byte Buf