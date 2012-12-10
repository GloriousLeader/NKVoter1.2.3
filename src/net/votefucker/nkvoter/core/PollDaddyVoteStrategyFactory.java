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

package net.votefucker.nkvoter.core;

import java.util.HashMap;

/**
 * Created by Sini
 */
public final class PollDaddyVoteStrategyFactory extends VoteStrategyFactory {
    private HashMap<String, String[]> candidates;
    
    /**
     * Constructs a new {@link PollDaddyVoteStrategy};
     */
    public PollDaddyVoteStrategyFactory()
    {
        candidates = new HashMap<String, String[]>();
        initCandidates();
    }
    
    @Override
    public VoteStrategy createStrategy()
    {
        return null;
    }
    public VoteStrategy createStrategy(String candID) {
        String[] relevantStrings = candidates.get(candID);
        return new PollDaddyVoteStrategy(relevantStrings[0], relevantStrings[1], relevantStrings[2]);
    }
    
    private void initCandidates()
    {
        String[] Morsi_strings = new String[3];
        Morsi_strings[0] = "Morsi";
        Morsi_strings[1] = "/n/f5feb0194a8f56d8ffa40f1ddd6cb0af/6685628?";
        Morsi_strings[2] = "/vote-js.php?p=6685628&b=1&a=30279855,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129194%2C00.html&n=";
        candidates.put("Morsi", Morsi_strings);
        
        String[] Mitt_strings = new String[3];
        Mitt_strings[0] = "Mitt";
        Mitt_strings[1] = "/n/c5df76aa1b98bdbf60549d280cc7750f/6685564?";
        Mitt_strings[2] = "/vote-js.php?p=6685564&b=1&a=30279595,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129178%2C00.html&n=";
        candidates.put("Mitt", Mitt_strings);
        
        String[] Hillary_strings = new String[3];
        Hillary_strings[0] = "Hillary";
        Hillary_strings[1] = "/n/1893654f84b7a11625b092f4779375c2/6685580?";
        Hillary_strings[2] = "/vote-js.php?p=6685580&b=1&a=30279654,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129184%2C00.html&n=";
        candidates.put("Hillary", Hillary_strings);
        
        String[] AiWeiwei_strings = new String[3];
        AiWeiwei_strings[0] = "AiWeiwei";
        AiWeiwei_strings[1] = "/n/274f014fe83e2dec59c9894b0ba6afa2/6685620?";
        AiWeiwei_strings[2] = "/vote-js.php?p=6685620&b=1&a=30279822,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129193%2C00.html&n=";
        candidates.put("AiWeiwei", AiWeiwei_strings);
        
        String[] Sheldon_strings = new String[3];
        Sheldon_strings[0] = "Sheldon";
        Sheldon_strings[1] = "/n/7a0bb8ade981eb9c2bc955e0587e7180/6685590?";
        Sheldon_strings[2] = "/vote-js.php?p=6685590&b=1&a=30279692,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129186%2C00.html&n=";
        candidates.put("Sheldon", Sheldon_strings);
        
        String[] Christie_strings = new String[3];
        Christie_strings[0] = "Christie";
        Christie_strings[1] = "/n/a1494915370b2c2fa356b26a34428e7b/6685577?";
        Christie_strings[2] = "/vote-js.php?p=6685577&b=1&a=30279644,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129182%2C00.html&n=";
        candidates.put("Christie", Christie_strings);
        
        String[] Pussy_strings = new String[3];
        Pussy_strings[0] = "Pussy";
        Pussy_strings[1] = "/n/e220bcd0b48b1b5d3991f0ae8d6fb965/6685706?";
        Pussy_strings[2] = "/vote-js.php?p=6685706&b=1&a=30280226,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129209%2C00.html&n=";
        candidates.put("Pussy", Pussy_strings);
        
        String[] Bashar_strings = new String[3];
        Bashar_strings[0] = "Bashar";
        Bashar_strings[1] = "/n/cd8babebc20d724de7f9326b90871c31/6685629?";
        Bashar_strings[2] = "/vote-js.php?p=6685629&b=1&a=30279857,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129195%2C00.html&n=";
        candidates.put("Bashar", Bashar_strings);
        
        String[] Undocs_strings = new String[3];
        Undocs_strings[0] = "Undocs";
        Undocs_strings[1] = "/n/e1386f1d203929ebe8c0202ab9b529bf/6685607?";
        Undocs_strings[2] = "/vote-js.php?p=6685607&b=1&a=30279758,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129191%2C00.html&n=";
        candidates.put("Undocs", Undocs_strings);
        
        String[] TheHiggs_strings = new String[3];
        TheHiggs_strings[0] = "TheHiggs";
        TheHiggs_strings[1] = "/n/5ba07c9a693fb34fba3bf3d5319d52ef/6685721?";
        TheHiggs_strings[2] = "/vote-js.php?p=6685721&b=1&a=30280265,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129214%2C00.html&n=";
        candidates.put("TheHiggs", TheHiggs_strings);
        
        String[] TheMars_strings = new String[3];
        TheMars_strings[0] = "TheMars";
        TheMars_strings[1] = "/n/7f17ea5f0930d585cbf26e7c1cf08fcb/6685725?";
        TheMars_strings[2] = "/vote-js.php?p=6685725&b=1&a=30280276,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129215%2C00.html&n=";
        candidates.put("TheMars", TheMars_strings);
        
        String[] Stephen_strings = new String[3];
        Stephen_strings[0] = "Stephen";
        Stephen_strings[1] = "/n/45a54d304efd9783196e1db13da69194/6685714?";
        Stephen_strings[2] = "/vote-js.php?p=6685714&b=1&a=30280244,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129212%2C00.html&n=";
        candidates.put("Stephen", Stephen_strings);
        
        String[] ELJames_strings = new String[3];
        ELJames_strings[0] = "ELJames";
        ELJames_strings[1] = "/n/f25d6b945b051886812e322f2990bacd/6685699?";
        ELJames_strings[2] = "/vote-js.php?p=6685699&b=1&a=30280201,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129207%2C00.html&n=";
        candidates.put("ELJames", ELJames_strings);
        
        String[] Xinping_strings = new String[3];
        Xinping_strings[0] = "Xinping";
        Xinping_strings[1] = "/n/3fcea3992e69661c987f93e93b98ef4f/6685640?";
        Xinping_strings[2] = "/vote-js.php?p=6685640&b=1&a=30279911,&o=&va=16&cookie=0&url=http%3A//www.time.com/time/specials/packages/article/0%2C28804%2C2128881_2128882_2129197%2C00.html&n=";
        candidates.put("Xinping", Xinping_strings);
    }
}