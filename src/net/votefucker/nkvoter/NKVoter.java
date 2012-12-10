/**
 * Copyright (c) 2012, Sini
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN 
 * THE SOFTWARE.
 */

package net.votefucker.nkvoter;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import net.votefucker.nkvoter.core.VoteEngine;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.votefucker.nkvoter.core.VoteDispatcher;
import net.votefucker.nkvoter.task.TaskManager;
import net.votefucker.nkvoter.timestamp.TimeStamp;

/**
 * Created by Sini
 */
public final class NKVoter {

            
    /**
     * The pattern used for grabbing how many times to vote per each dispatcher.
     */
    private static final Pattern VOTE_PATTERN = Pattern.compile("'(.+)' => (.+),");
    
    /**
     * The singleton instance.
     */
    private static final NKVoter singleton = new NKVoter();
    
    /**
     * The executor for this application.
     */
    private static final Executor executor = Executors.newSingleThreadExecutor();
    
    /**
     * The vote engine for the application.
     */
    private final VoteEngine engine = new VoteEngine();
    
    /**
     * The task manager for the application.
     */
    private final TaskManager taskManager = new TaskManager();
    
    /**
     * The map that contains how many times to vote for each candidate.
     */
    private final Map<String, Integer> voteAmounts = new HashMap<String, Integer>();
    
    /**
     * Constructs a new {@link NKVoter};
     */
    public NKVoter() {}
    
    /**
     * Updates the vote amounts.
     */
    public void updateVoteAmounts() {
        String[] candidateNames = new String[] {"Morsi", "Mitt", "Hillary", "AiWeiwei", "Sheldon", "Christie", "Pussy", "Bashar", "Undocs", "TheHiggs", "TheMars", "Stephen", "ELJames", "Xinping"};
       int[] amountVotes = {50, 45, 40, 35, 30, 25, 23, 21, 19, 16, 15, 13, 11, 9, 4};
       System.out.println("Updating Voteamounts (time=" + TimeStamp.getTimeStampString() + ")");
        try {
            URL url = new URL("http://www.stullig.com/nkfiles/numbers.txt");
            Scanner scanner = new Scanner(url.openStream());
            String response = "";
            while(scanner.hasNextLine()) {
                response += scanner.nextLine() + "\n";
            }    
            
            /* Close the scanner */
            scanner.close();
            
            /* TEMPORARY */

            String[] URLamounts = response.split("[,\n]");
        
            //Matcher matcher = VOTE_PATTERN.matcher(response);
            //while(matcher.find()) {
            for(int i = 0; i < candidateNames.length; i++) {
                if(URLamounts.equals("")) {
                    continue;
                }
                
                String candidateName = candidateNames[i];//matcher.group(1);
                amountVotes[i] = Integer.parseInt(URLamounts[i]);
            }
            //}
            
        }catch(IOException ex){
             System.out.println("Wasn't able to retrieve votesPerCandidate values from the server; using defaults.");
        }
           try{ for(int i=0; i<candidateNames.length; i++) {
                voteAmounts.put(candidateNames[i], amountVotes[i]);
                System.out.println(candidateNames[i]+" "+amountVotes[i]);
            }
           } catch (NumberFormatException e) {}
    }
    
    /**
     * Gets the amount of times to vote for a candidate.
     * 
     * @param candidateName The name of the candidate.
     * @return              The amount of times to vote.
     */
    public int getAmountToVote(String candidateName) {
        if(!voteAmounts.containsKey(candidateName)) {
            return 0;
        }
        return voteAmounts.get(candidateName);
    }
    
    /**
     * Gets the task manager.
     * 
     * @return  The task manager.
     */
    public TaskManager getTaskManager() {
        return taskManager;
    }
    
    /**
     * Gets the vote engine for the application.
     * 
     * @return  The vote engine.
     */
    public VoteEngine getEngine() {
        return engine;
    }
    
    /**
     * Gets the singleton instance.
     * 
     * @return  The singleton instance.
     */
    public static NKVoter getSingleton() {
        return singleton;
    }
}
