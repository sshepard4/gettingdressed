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
     * Index for this command
     */
    public static final Integer INDEX = 7;
    
    /**
     * Get index command.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#getCommandIndex()
     */
    @Override
    public int getCommandIndex() {
        return INDEX;
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
        if (dressState.areAllHotCommandsCalled()) {
            dressState.setCommand(getCommandIndex());
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
        if (dressState.areAllColdCommandsCalled()) {
            dressState.setCommand(getCommandIndex());
            return "leaving house";
        }
        throw new DressStateException();
    }

    /**
     * Is required when hot.
     */
    @Override
    public boolean isRequiredWhenHot() {
        return false;
    }

    /**
     * Is required when cold
     */
    @Override
    public boolean isRequiredWhenCold() {
        return false;
    }
}
