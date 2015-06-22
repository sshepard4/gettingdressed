package com.spencershepard.gettingdressed.command;

import com.spencershepard.gettingdressed.DressCommand;
import com.spencershepard.gettingdressed.DressState;
import com.spencershepard.gettingdressed.DressStateException;

/**
 * Jacket command that returns the appropriate value when dress state is valid.
 * 
 * @author spencer.shepard
 *
 */
public class JacketCommand extends DressCommand {

    /**
     * Index for this command
     */
    public static final Integer INDEX = 5;
    
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
        return "Put on jacket";
    }

    /**
     * Exception is thrown when jacket is put on when it is hot.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeHot(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeHot(DressState dressState) throws DressStateException {
        throw new DressStateException();
    }

    /**
     * If PJs are off, the person has yet to leave the house, shirt is already on, and jacket has not been put on
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
            return "jacket";
        }
        throw new DressStateException();
    }

    /**
     * Is not required when hot.
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
        return true;
    }
}
