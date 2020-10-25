/**
 * 
 */
package com.teksystems.montyhall.server.main;

//emoji for car U+E01B and for goat U+1f410   use &#128016; for html
/**
 * @author duggi
 *
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

import com.teksystems.montyhall.services.MontyHallGameService;
import com.teksystems.montyhall.utils.MontyHallUtils;

@Controller
@RequestMapping ("/api")
public class MontyHallController {
	
	int iterations=2;
	String[][] resultTable = new String [iterations][7];		
	String[] arr = new String [7];
	int matchCount=0;
	double percentageMatch = 0.0; 
	
	@GetMapping("/play/{iterations}/{choice}")	
	public String playGameNew(	Model model, @PathVariable("iterations") int iterations,@PathVariable("choice") char choice) {
		
		MontyHallGameService gameService = new MontyHallGameService();
		gameService.setGamerChangeOfSelectionYesOrNo(choice);		
		this.iterations = iterations;
		resultTable = new String [iterations][7];		
		for(int i=1;i<iterations;i++) {
			
			arr = getIterationResult();
			arr[0] = Integer.toString(i);			
			arr = MontyHallUtils.stringToEmoji(arr);
			
			if(arr[6] == "True" || arr[6] == "true") {
				matchCount+=1;
				
			}
					
			resultTable[i]= arr;		
		
		}
		resultTable[0] = new String[]{"Iteration", "Door 0", "Door 1","Door 2","Original","Selected","Win"};
		
		
		percentageMatch = ((matchCount * 100) / iterations);
		
		
			model.addAttribute("iterations", iterations);			
			model.addAttribute("percentageMatch", percentageMatch);			
			model.addAttribute("matrix", resultTable);	
			return "play";

	}
	
	public String[] getIterationResult() {
			MontyHallGameService gameService = new MontyHallGameService();
			gameService.setGamerChangeOfSelectionYesOrNo('y');			
			
			gameService.gamerDoorSelection();			
			gameService.intermittentDialogByGameHost();			
			gameService.validateGamerDoorSelection();			
			gameService.updateGameResult();				
			arr = gameService.updateGameResult();	
	
			return arr;
	}

	
	
}



