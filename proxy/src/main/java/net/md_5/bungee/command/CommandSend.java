package net.md_5.bungee.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandSend extends Command
{

    public CommandSend()
    {
        super( "send", "bungeecord.command.send" );
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        if ( args.length != 2 )
        {
            sender.sendMessage( ChatColor.RED + "Недостаточно параметров. Использование: /send <player|all|current> <цель>" );
            return;
        }
        ServerInfo target = ProxyServer.getInstance().getServerInfo( args[1] );
        if ( target == null )
        {
            sender.sendMessage( ProxyServer.getInstance().getTranslation( "no_server" ) );
            return;
        }

        if ( args[0].equalsIgnoreCase( "all" ) )
        {
            for ( ProxiedPlayer p : ProxyServer.getInstance().getPlayers() )
            {
                summon( p, target, sender );
            }
        } else if ( args[0].equalsIgnoreCase( "current" ) )
        {
            if ( !( sender instanceof ProxiedPlayer ) )
            {
                sender.sendMessage( ChatColor.RED + "Только игроки онлайн может использовать данную команду" );
                return;
            }
            ProxiedPlayer player = (ProxiedPlayer) sender;
            for ( ProxiedPlayer p : player.getServer().getInfo().getPlayers() )
            {
                summon( p, target, sender );
            }
        } else
        {
            ProxiedPlayer player = ProxyServer.getInstance().getPlayer( args[0] );
            if ( player == null )
            {
                sender.sendMessage( ChatColor.RED + "Данный игрок не онлайн" );
                return;
            }
            summon( player, target, sender );
        }
        sender.sendMessage( ChatColor.GREEN + "Указанный игрок успешно перемещен к Вам." );
    }

    private void summon(ProxiedPlayer player, ServerInfo target, CommandSender sender)
    {
        if ( player.getServer() != null && !player.getServer().getInfo().equals( target ) )
        {
            player.connect( target );
            player.sendMessage( ChatColor.GOLD + "Вы были перемещены к " + target.getName() + " администратором " + sender.getName() );
        }
    }
}
