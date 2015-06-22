package com.spencershepard.gettingdressed;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Maintain the current state of being dressed.
 * 
 * @author spencer.shepard
 *
 */
public class DressState {
    
    /**
     * Command that have already been set
     */
    private final Set<Integer> commandsAlreadySet = new LinkedHashSet<>(); 
    
    /**
     * Remaining commands required for hot.
     */
    private final Set<Integer> stillRequiredForHot = new HashSet<>();
    
    /**
     * Remaining commands required for cold.
     */
    private final Set<Integer> stillRequiredForCold = new HashSet<>();
    
    /**
     * Set the command for the dress state. Throw an exception if already set.
     * 
     * @param command
     *            Command to set
     * @throws DressStateException
     *             If command is already set.
     */
    public void setCommand(Integer command) throws DressStateException {
        if (!commandsAlreadySet.add(command)) {
            throw new DressStateException();
        }
        stillRequiredForHot.remove(command);
        stillRequiredForCold.remove(command);
    }
    
    /**
     * Has the command been set?
     * 
     * @param command
     *            command to test
     * @return true if already set
     */
    public boolean hasCommandBeenSet(Integer command) {
        return commandsAlreadySet.contains(command);
    }
    
    /**
     * Set that the command is required for hot.
     * 
     * @param command
     *            Command required
     */
    public void setRequiredForHot(Integer command) {
        stillRequiredForHot.add(command);
    }

    /**
     * Set that the command is required for cold.
     * 
     * @param command
     *            Command required
     */
    public void setRequiredForCold(Integer command) {
        stillRequiredForCold.add(command);
    }
    
    /**
     * Have all hot commands required been called?
     * 
     * @return true if yes
     */
    public boolean areAllHotCommandsCalled() {
       return stillRequiredForHot.isEmpty(); 
    }
    
    /**
     * Have all cold commands required been called?
     * 
     * @return true if yes
     */
    public boolean areAllColdCommandsCalled() {
        return stillRequiredForCold.isEmpty();
    }
}
