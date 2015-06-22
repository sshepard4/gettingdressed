package com.spencershepard.gettingdressed.command;

import com.spencershepard.gettingdressed.DressCommand;
import com.spencershepard.gettingdressed.DressState;
import com.spencershepard.gettingdressed.DressStateException;

/**
 * Leave House command that returns the appropriate value when dress state is valid.
 * 
 * @author spencer.shepard
 *
 */
public class LeaveHouseCommand extends DressCommand {

    /**
     * Get index command.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#getCommandIndex()
     */
    @Override
    public int getCommandIndex() {
        return 7;
    }

    /**
     * Get description
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#getDescription()
     */
    @Override
    public String getDescription() {
        return "Leave house";
    }

    /**
     * If PJs are off, person has yet to leave the house, and footwear, headwear, shirt, and pants are on, return value,
     * else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeHot(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeHot(DressState dressState) throws DressStateException {
        if (dressState.isPjsAreOff() && !dressState.isLeftHouse() && dressState.isFootwearOn()
                && dressState.isHeadwearOn() && dressState.isShirtOn() && dressState.isPantsOn()) {
            dressState.setLeftHouse(true);
            return "leaving house";
        }
        throw new DressStateException();
    }

    /**
     * If PJs are off, person has yet to leave the house, and footwear, headwear, socks, shirt, jacket, and pants are
     * on, return value, else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeCold(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeCold(DressState dressState) throws DressStateException {
        if (dressState.isPjsAreOff() && !dressState.isLeftHouse() && dressState.isFootwearOn()
                && dressState.isHeadwearOn() && dressState.isSocksOn() && dressState.isShirtOn()
                && dressState.isJacketOn() && dressState.isPantsOn()) {
            dressState.setLeftHouse(true);
            return "leaving house";
        }
        throw new DressStateException();
    }
}
