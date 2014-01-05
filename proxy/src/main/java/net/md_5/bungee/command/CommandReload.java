package net.md_5.bungee.command;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class CommandReload extends Command
{

    public CommandReload()
    {
        super( "greload", "bungeecord.command.reload" );
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        BungeeCord.getInstance().config.load();
        BungeeCord.getInstance().stopListeners();
        BungeeCord.getInstance().startListeners();
        sender.sendMessage( ChatColor.BOLD.toString() + ChatColor.RED.toString() + "Конфигурация BungeeCord была перезагружена."
                + " Данный метод НЕ рекомендуется к использованию так как может привести к ошибкам! Пожалуйста, перезагрузите BungeeCord как можно быстрее." );
    }
}
