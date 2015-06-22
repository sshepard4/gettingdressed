package com.spencershepard.gettingdressed.command;

import com.spencershepard.gettingdressed.DressCommand;
import com.spencershepard.gettingdressed.DressState;
import com.spencershepard.gettingdressed.DressStateException;

/**
 * Shirt command that returns the appropriate value when dress state is valid.
 * 
 * @author spencer.shepard
 *
 */
public class ShirtCommand extends DressCommand {

    /**
     * Get index command.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#getCommandIndex()
     */
    @Override
    public int getCommandIndex() {
        return 4;
    }

    /**
     * Get description
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#getDescription()
     */
    @Override
    public String getDescription() {
        return "Put on shirt";
    }

    /**
     * If PJs are off, the person has left to leave the house, and a shirt has not been put on
     * yet, return value, else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeHot(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeHot(DressState dressState) throws DressStateException {
        if (dressState.isPjsAreOff() && !dressState.isLeftHouse() && !dressState.isShirtOn()) {
            dressState.setShirtOn(true);
            return "shirt";
        }
        throw new DressStateException();
    }

    /**
     * If PJs are off, the person has yet to leave the house, and a shirt has not been put on
     * yet, return value, else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeCold(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeCold(DressState dressState) throws DressStateException {
        if (dressState.isPjsAreOff() && !dressState.isLeftHouse() && !dressState.isShirtOn()) {
            dressState.setShirtOn(true);
            return "shirt";
        }
        throw new DressStateException();
    }
}
