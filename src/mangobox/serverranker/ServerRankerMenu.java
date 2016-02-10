package mangobox.serverranker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerRankerMenu implements Listener {
	
	public ServerRankerMenu(ServerRanker plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		}
	
	public static void OpenRankMenu(Player player) {
		Inventory rankerMenu = Bukkit.createInventory(null, 18, ChatColor.GREEN + "Rank Menu");
		
		ItemStack challengeItem = new ItemStack(Material.SIGN);
		ItemMeta challengeItemMeta = challengeItem.getItemMeta();
		
		ItemStack exitItem = new ItemStack(Material.BARRIER);
		ItemMeta exitItemMeta = exitItem.getItemMeta();
		
		ItemStack barItem = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta barItemMeta = barItem.getItemMeta();
		
		challengeItemMeta.setDisplayName(ChatColor.GREEN + "Challenge Menu");
		challengeItem.setItemMeta(challengeItemMeta);
		
		exitItemMeta.setDisplayName(ChatColor.RED + "Exit");
		exitItem.setItemMeta(exitItemMeta);
		
		barItemMeta.setDisplayName(" ");
		barItem.setItemMeta(barItemMeta);
		
		rankerMenu.setItem(13, challengeItem);
		rankerMenu.setItem(8, exitItem);
		
		for (int i = 0; i<=7; i++) {
			rankerMenu.setItem(i, barItem);
			
		}
		
		
		player.openInventory(rankerMenu);
	}
	
	public static void OpenChallengeMenu(Player player) {
		Inventory rankerMenu = Bukkit.createInventory(null, 18, ChatColor.GREEN + "Challenges");
		
		ItemStack challengeItem = new ItemStack(Material.SIGN);
		ItemMeta challengeItemMeta = challengeItem.getItemMeta();
		
		ItemStack barItem = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta barItemMeta = barItem.getItemMeta();
		
		ItemStack exitItem = new ItemStack(Material.BARRIER);
		ItemMeta exitItemMeta = exitItem.getItemMeta();
		
		ItemStack backItem = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta backItemMeta = backItem.getItemMeta();
		
		ItemStack challenge = new ItemStack(Material.MAP);
		ItemMeta challengeMeta = challenge.getItemMeta();
		
		challengeItemMeta.setDisplayName(ChatColor.GREEN + "Challenge Menu");
		challengeItem.setItemMeta(challengeItemMeta);
		
		barItemMeta.setDisplayName(" ");
		barItem.setItemMeta(barItemMeta);

		exitItemMeta.setDisplayName(ChatColor.RED + "Exit");
		exitItem.setItemMeta(exitItemMeta);
		
		backItemMeta.setDisplayName(ChatColor.RED + "Back");
		backItem.setItemMeta(backItemMeta);
		
		for (int i = 0; i<=7; i++) {
			rankerMenu.setItem(i, barItem);
			
		}
		
		rankerMenu.setItem(0, backItem);
		rankerMenu.setItem(8, exitItem);
		
		player.openInventory(rankerMenu);
	}
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Rank Menu") && !ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Challenges"))
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
	if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
		player.closeInventory();
		return;
	}
		switch (event.getCurrentItem().getType()) {
		case SIGN:
			player.closeInventory();
			OpenChallengeMenu(player);
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			OpenRankMenu(player);
			break;
		case BARRIER:
			player.closeInventory();
			break;
		default:
			player.closeInventory();
			player.sendMessage(ChatColor.RED + "Unknown Error Occured, item not recgonised by switch case");
		}
	
	}
	
	public static void getChallengeCompleted(int challengeNo, Player player) {
		
	}
	
	

}
