package net.md_5.bungee.command;

import java.util.Collections;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class CommandFind extends PlayerCommand
{

    public CommandFind()
    {
        super( "find", "bungeecord.command.find" );
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        if ( args.length != 1 )
        {
            sender.sendMessage( ChatColor.RED + "Пожалуйста, укажите имя игрока" );
        } else
        {
            ProxiedPlayer player = ProxyServer.getInstance().getPlayer( args[0] );
            if ( player == null || player.getServer() == null )
            {
                sender.sendMessage( ChatColor.RED + "Игрок не онлайн" );
            } else
            {
                sender.sendMessage( ChatColor.BLUE + args[0] + " онлайн на сервере " + player.getServer().getInfo().getName() );
            }
        }
    }
}
