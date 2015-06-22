package com.spencershepard.gettingdressed;

/**
 * Abstract class corresponding to a getting dressed command.
 * 
 * @author spencer.shepard
 *
 */
public abstract class DressCommand {

    /**
     * Get the command index for this command.
     * 
     * @return index
     */
    public abstract int getCommandIndex();
    
    /**
     * Get the description for the command.
     * 
     * @return description
     */
    public abstract String getDescription();
    
    /**
     * Execute the command validating and updating the dress state.
     * 
     * @param temp
     *            Temperature outside
     * @param dressState
     *            Current dress state.
     * @return what was accomplished
     * @throws DressStateException
     *             Invalid dress state
     */
    public String execute(Temperature temp, DressState dressState) throws DressStateException {
        if (Temperature.HOT == temp) {
            return executeHot(dressState);
        } else if (Temperature.COLD == temp) {
            return executeCold(dressState);
        }
        throw new DressStateException();
    }

    /**
     * Execute the command when the outside temperature is hot
     * 
     * @param dressState
     *            Current dress state
     * @return what was accomplished
     * @throws DressStateException
     *             Invalid dress state
     */
    protected abstract String executeHot(DressState dressState) throws DressStateException;

    /**
     * Execute the command when the outside temperature is cold
     * 
     * @param dressState
     *            Current dress state
     * @return what was accomplished
     * @throws DressStateException
     *             Invalid dress state
     */
    protected abstract String executeCold(DressState dressState) throws DressStateException;
    
    /**
     * Is this command required when hot?
     * 
     * @return true if required
     */
    public abstract boolean isRequiredWhenHot();
    
    /**
     * Is this command required when cold?
     * 
     * @return true if required
     */
    public abstract boolean isRequiredWhenCold();
}
