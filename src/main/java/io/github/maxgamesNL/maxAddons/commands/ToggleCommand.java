package io.github.maxgamesNL.maxAddons.commands;

import io.github.maxgamesNL.maxAddons.MaxAddons;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class ToggleCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "toggle";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText("Usage: /toggle <mod>"));
        } else {
            String mod = args[0];
            if(mod.equalsIgnoreCase("ezstonk")) {
                MaxAddons.moduleManager.StonkToggled = !MaxAddons.moduleManager.StonkToggled;
                sender.addChatMessage(new ChatComponentText("EZstonk toggled to " + MaxAddons.moduleManager.StonkToggled));
            }
            if(mod.equalsIgnoreCase("AutoLavaFish")){
                MaxAddons.moduleManager.AutoLavaFishToggled = !MaxAddons.moduleManager.AutoLavaFishToggled;
                sender.addChatMessage(new ChatComponentText("AutoLavaFish toggled to " + MaxAddons.moduleManager.AutoLavaFishToggled));
            }

        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }


}
