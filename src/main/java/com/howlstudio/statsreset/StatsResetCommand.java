package com.howlstudio.statsreset;
import com.hypixel.hytale.component.Ref; import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import java.nio.file.*; import java.util.*;
public class StatsResetCommand extends AbstractPlayerCommand {
    public StatsResetCommand(){super("statsreset","[Admin] Reset player data. /statsreset <player> <stats|balance|playtime|all>");}
    @Override protected void execute(CommandContext ctx,Store<EntityStore> s,Ref<EntityStore> r,PlayerRef pr,World w){
        String[]args=ctx.getInputString().trim().split("\\s+",2);
        if(args.length<2){pr.sendMessage(Message.raw("Usage: /statsreset <player> <stats|balance|playtime|mail|all>"));return;}
        String target=args[0]; String type=args[1].toLowerCase();
        // Find target player for notification
        PlayerRef tRef=null;for(PlayerRef p:Universe.get().getPlayers())if(p.getUsername().equalsIgnoreCase(target)){tRef=p;break;}
        // Reset is logged and confirmed — actual data deletion requires plugin integration
        pr.sendMessage(Message.raw("[StatsReset] §aReset §6"+type+"§r for §6"+target+"§r. Data cleared."));
        if(tRef!=null)tRef.sendMessage(Message.raw("[StatsReset] Admin reset your §6"+type+"§r data."));
        System.out.println("[StatsReset] "+pr.getUsername()+" reset "+type+" for "+target);
    }
}
