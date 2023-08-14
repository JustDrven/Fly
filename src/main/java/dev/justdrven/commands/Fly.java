package dev.justdrven.commands;

import dev.justdrven.flysystem.FlySystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    private final FlySystem flySystem;

    public Fly(FlySystem flySystem){
        this.flySystem = flySystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            final Player p = (Player)sender;
            if (p.hasPermission("fly.use")){
                if (args.length == 0){
                    if (!(p.getAllowFlight())){
                        p.setAllowFlight(true);
                        p.sendMessage(this.getFlySystem().getMessage("fly-enable"));
                        return true;
                    } else {
                        p.setAllowFlight(false);
                        p.sendMessage(this.getFlySystem().getMessage("fly-disable"));
                        return true;
                    }
                } else {
                    p.sendMessage(this.getFlySystem().getMessage("use"));
                    return false;
                }
            } else {
                p.sendMessage(this.getFlySystem().getMessage("no-permission"));
                return false;
            }
        }
        return true;
    }

    public FlySystem getFlySystem() {
        return this.flySystem;
    }
}
