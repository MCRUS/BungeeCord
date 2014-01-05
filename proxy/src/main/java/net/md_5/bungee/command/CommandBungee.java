package net.md_5.bungee.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class CommandBungee extends Command {

    public CommandBungee() {
        super("bungee");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(new ComponentBuilder("Данный сервер работает на BungeeCord версии " + ProxyServer.getInstance().getVersion() + " от md_5.").color(ChatColor.BLUE).create());
        sender.sendMessage(new ComponentBuilder("Перевод Alex_Bond_UA.").color(ChatColor.BLUE).create());
    }
}
