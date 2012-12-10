/**
 * Copyright (c) 2012, Hadyn Richard
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

package net.votefucker.nkvoter.task.impl;

import net.votefucker.nkvoter.NKVoter;
import net.votefucker.nkvoter.core.VoteEngine;
import net.votefucker.nkvoter.task.Task;


public final class UpdateVoteAmountsTask extends Task {
    
    private boolean firstrun = true;

    
    /**
     * Constructs a new {@link UpdateVoteAmountsTask};
     * 
     * @param delay     The delay between pulses.
     */
    public UpdateVoteAmountsTask(long delay) {
        super(delay);
    }

    @Override
    public void execute() {
        if(!firstrun){
            NKVoter.getSingleton().updateVoteAmounts();
        }
        else {
            firstrun = false;
        
        }
}
}
