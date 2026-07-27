package buildcraft.core.command;

import buildcraft.core.Version;
import buildcraft.core.lib.commands.SubCommand;
import buildcraft.core.proxy.CoreProxy;
import net.minecraft.src.*;

public class SubCommandVersion extends SubCommand {

    public SubCommandVersion() {
        super("version");
    }

    @Override
    public void processSubCommand(ICommandSender sender, String[] args) {
        sender.sendChatToPlayer(
                new ChatMessageComponent().addFormatted(
                        "command.buildcraft.version",
                        Version.getVersion(),
                        CoreProxy.proxy.getMinecraftVersion(),
                        Version.getRecommendedVersion()).setColor(
                                Version.isOutdated() ? EnumChatFormatting.RED : EnumChatFormatting.GREEN));

        if (Version.needsUpdateNoticeAndMarkAsSeen()) {
            sender.sendChatToPlayer(
                    new ChatMessageComponent().addFormatted(
                            "bc_update.new_version",
                            Version.getRecommendedVersion(),
                            CoreProxy.proxy.getMinecraftVersion()));
            sender.sendChatToPlayer(new ChatMessageComponent().addKey("bc_update.download"));
            sender.sendChatToPlayer(new ChatMessageComponent().addKey("bc_update.changelog"));
        }
    }
}
