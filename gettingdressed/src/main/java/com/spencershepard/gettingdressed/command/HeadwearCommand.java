package com.spencershepard.gettingdressed.command;

import com.spencershepard.gettingdressed.DressCommand;
import com.spencershepard.gettingdressed.DressState;
import com.spencershepard.gettingdressed.DressStateException;

/**
 * Headwear command that returns the appropriate value when dress state is valid.
 * 
 * @author spencer.shepard
 *
 */
public class HeadwearCommand extends DressCommand {

    /**
     * Index for this command
     */
    public static final Integer INDEX = 2;
    
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
        return "Put on headwear";
    }

    /**
     * If PJs are off, the person has yet to leave the house, the shirt is already on, and headwear has not been put on
     * yet, return value, else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeHot(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeHot(DressState dressState) throws DressStateException {
        if (dressState.hasCommandBeenSet(TakeOffPajamasCommand.INDEX)
                && !dressState.hasCommandBeenSet(LeaveHouseCommand.INDEX)
                && dressState.hasCommandBeenSet(ShirtCommand.INDEX)) {
            dressState.setCommand(getCommandIndex());
            return "sunglasses";
        }
        throw new DressStateException();
    }

    /**
     * If PJs are off, the person has yet to leave the house, the shirt is already on, and headwear has not been put on
     * yet, return value, else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeCold(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeCold(DressState dressState) throws DressStateException {
        if (dressState.hasCommandBeenSet(TakeOffPajamasCommand.INDEX)
                && !dressState.hasCommandBeenSet(LeaveHouseCommand.INDEX)
                && dressState.hasCommandBeenSet(ShirtCommand.INDEX)) {
            dressState.setCommand(getCommandIndex());
            return "hat";
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
     * Is required when cold.
     */
    @Override
    public boolean isRequiredWhenCold() {
        return true;
    }

}
