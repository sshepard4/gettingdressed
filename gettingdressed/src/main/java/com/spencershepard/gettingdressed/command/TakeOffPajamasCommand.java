package com.spencershepard.gettingdressed.command;

import com.spencershepard.gettingdressed.DressCommand;
import com.spencershepard.gettingdressed.DressState;
import com.spencershepard.gettingdressed.DressStateException;

/**
 * Take off Pajamas command that returns the appropriate value when dress state is valid.
 * 
 * @author spencer.shepard
 *
 */
public class TakeOffPajamasCommand extends DressCommand {

    /**
     * Index for this command
     */
    public static final Integer INDEX = 8;
    
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
        return "Take off pajamas";
    }

    /**
     * If PJs are not off already off, remove, else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeHot(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeHot(DressState dressState) throws DressStateException {
        dressState.setCommand(getCommandIndex());
        return "Removing PJs";
    }

    /**
     * f PJs are not off already off, remove, else exception.
     * 
     * @see com.spencershepard.gettingdressed.command.DressCommand#executeCold(com.spencershepard.gettingdressed.DressState)
     */
    @Override
    protected String executeCold(DressState dressState) throws DressStateException {
        dressState.setCommand(getCommandIndex());
        return "Removing PJs";
    }

    /**
     * Is required when hot.
     */
    @Override
    public boolean isRequiredWhenHot() {
        return true;
    }

    /**
     * Is required when cold.
     */
    @Override
    public boolean isRequiredWhenCold() {
        return true;
    }
}
