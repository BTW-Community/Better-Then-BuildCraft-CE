# Forge port info
regex replace: 
```regexp
net\.minecraft\.(?:[a-z]+)?\.?(?:[a-z]+)?\.?(?:[a-z]+)?\.?(?:[a-z]+)?\.?([A-Z_$][a-zA-Z\d_$]+)
```
with `net.minecraft.$1`

1.7 names to 1.6 names:
IIcon => Icon
IIconProvider => IconProvider
IIconRegister => IconRegister