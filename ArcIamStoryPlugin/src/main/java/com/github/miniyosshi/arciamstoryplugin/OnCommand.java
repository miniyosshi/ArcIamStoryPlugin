package com.github.miniyosshi.arciamstoryplugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OnCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {	
		
		
		//main classへの登録をお忘れなく！
		
		
		//エリア登録
		if (cmd.getName().equalsIgnoreCase("setarea")){
			if(sender instanceof Player) {
												
				if(args.length >= 2) {
					
					boolean exist = false;
					Location loc = ((Player) sender).getLocation();
					
					for (AreaData a : CSVReader.areadata) {
						if (a.getName().equalsIgnoreCase(args[0])) {
							
							a.setLocation(Integer.parseInt(args[1]),loc);					
							exist = true;
							sender.sendMessage("登録しました。");
						}
					}
					//新しい名前の場所
					if(exist == false) {
						
						AreaData a = new AreaData(args[0], loc, loc);
						CSVReader.areadata.add(a);
						sender.sendMessage("新しい名前の場所, "+a.getName()+"を登録しました。");
					}
					
					//ここでcsvに書き込み
					CSVExporter.exportCSV("AreaData.csv");
										
					return true;
				}
				else {
					//不要
					//sender.sendMessage("/setarea + name of area + 0or1");
					return false;
				}
			}
			else {
				sender.sendMessage("playerからしか受け付けません");
				return false;
				}
			
		}
		
		if(cmd.getName().equalsIgnoreCase("showarea")){
			for(AreaData a : CSVReader.areadata) {
				sender.sendMessage(a.getName());
			}
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("deletearea")){
			
			sender.sendMessage("まだ対応していません。");
			
			return true;
		}
		
		
		if(cmd.getName().equalsIgnoreCase("reloadcsv")){
			
			CSVReader.reload();
			sender.sendMessage("delete completed.");
			return true;
		}
		
		else
			sender.sendMessage("そのようなコマンドは存在しません。");
			return false;
	}
		
}
