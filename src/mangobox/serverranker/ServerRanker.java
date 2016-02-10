package mangobox.serverranker;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerRanker extends JavaPlugin {

	
	@Override
	public void onEnable () {
		getLogger().info("Server Ranker has been loaded, now go and dominate the world >:D");
		new ServerRankerMenu(this);
		File rankFile = new File(this.getDataFolder(), "rankFile.yml");
		if(rankFile.exists()) {
			FileConfiguration rankConfig = YamlConfiguration.loadConfiguration(rankFile);
		}
		
	}
	
	@Override
	public void onDisable () {
		getLogger().info("Server Ranker has been unloaded :)");
	
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args) {
		if (cmd.getName().equalsIgnoreCase("rank") && sender instanceof Player) {
				Player player = (Player) sender;
				ServerRankerMenu.OpenRankMenu(player);
				
				
				return true;
		}
		
		return false;
		
		
	}

}
