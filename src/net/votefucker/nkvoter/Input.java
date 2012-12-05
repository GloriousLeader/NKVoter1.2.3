/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.votefucker.nkvoter;

/**
 *
 * @author Stullig
 */

public class Input {
        public static String inString;
        public static String getString() {
    	inString = "";

    	// Wait for input
    	while (inString == "") {
    		try{
    			Thread.sleep(100);
    		} catch (Exception e) {}
    	}

    	return inString;
    }
    
}
