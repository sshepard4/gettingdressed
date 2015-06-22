package com.spencershepard.gettingdressed;

/**
 * Maintain the current state of being dressed.
 * 
 * @author spencer.shepard
 *
 */
public class DressState {
    
    private boolean footwearOn = false;
    
    private boolean headwearOn = false;
    
    private boolean socksOn = false;
    
    private boolean shirtOn = false;
    
    private boolean jacketOn = false;
    
    private boolean pantsOn = false;
    
    private boolean leftHouse = false;
    
    private boolean pjsAreOff = false;

    /**
     * @return the footwearOn
     */
    public boolean isFootwearOn() {
        return footwearOn;
    }

    /**
     * @param footwearOn the footwearOn to set
     */
    public void setFootwearOn(boolean footwearOn) {
        this.footwearOn = footwearOn;
    }

    /**
     * @return the headwearOn
     */
    public boolean isHeadwearOn() {
        return headwearOn;
    }

    /**
     * @param headwearOn the headwearOn to set
     */
    public void setHeadwearOn(boolean headwearOn) {
        this.headwearOn = headwearOn;
    }

    /**
     * @return the socksOn
     */
    public boolean isSocksOn() {
        return socksOn;
    }

    /**
     * @param socksOn the socksOn to set
     */
    public void setSocksOn(boolean socksOn) {
        this.socksOn = socksOn;
    }

    /**
     * @return the shirtOn
     */
    public boolean isShirtOn() {
        return shirtOn;
    }

    /**
     * @param shirtOn the shirtOn to set
     */
    public void setShirtOn(boolean shirtOn) {
        this.shirtOn = shirtOn;
    }

    /**
     * @return the jacketOn
     */
    public boolean isJacketOn() {
        return jacketOn;
    }

    /**
     * @param jacketOn the jacketOn to set
     */
    public void setJacketOn(boolean jacketOn) {
        this.jacketOn = jacketOn;
    }

    /**
     * @return the pantsOn
     */
    public boolean isPantsOn() {
        return pantsOn;
    }

    /**
     * @param pantsOn the pantsOn to set
     */
    public void setPantsOn(boolean pantsOn) {
        this.pantsOn = pantsOn;
    }

    /**
     * @return the leftHouse
     */
    public boolean isLeftHouse() {
        return leftHouse;
    }

    /**
     * @param leftHouse the leftHouse to set
     */
    public void setLeftHouse(boolean leftHouse) {
        this.leftHouse = leftHouse;
    }

    /**
     * @return the pjsAreOff
     */
    public boolean isPjsAreOff() {
        return pjsAreOff;
    }

    /**
     * @param pjsAreOff the pjsAreOff to set
     */
    public void setPjsAreOff(boolean pjsAreOff) {
        this.pjsAreOff = pjsAreOff;
    }
}
