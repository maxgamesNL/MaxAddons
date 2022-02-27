package io.github.maxgamesNL.maxAddons.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class MaxAddonsCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "maxaddons";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        sender.addChatMessage(new ChatComponentText("MaxAddons is a hypixel skyblock mod"));
        sender.addChatMessage(new ChatComponentText("It is made by MaxMods, also called maxgamesNL"));
        sender.addChatMessage(new ChatComponentText("maxgamesNL.github.io"));
        sender.addChatMessage(new ChatComponentText("A list of available modules:"));
        sender.addChatMessage(new ChatComponentText("- EZstonk, Makes ghost blocks for you by right clicking with a golden pick(or any variant of it like stonk)"));
        sender.addChatMessage(new ChatComponentText("- AutoLavaFish, AutoLavaFish is a mod that makes you fish in lava"));
        sender.addChatMessage(new ChatComponentText("- Coords, Shows you your coords"));
        sender.addChatMessage(new ChatComponentText("A list of commands:"));
        sender.addChatMessage(new ChatComponentText("- /toggle <module>, toggles a module on or off"));
    }
}
