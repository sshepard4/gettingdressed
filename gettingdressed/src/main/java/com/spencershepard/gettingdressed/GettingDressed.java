package com.spencershepard.gettingdressed;

import java.util.HashMap;
import java.util.Map;

import com.spencershepard.gettingdressed.command.FootwearCommand;
import com.spencershepard.gettingdressed.command.HeadwearCommand;
import com.spencershepard.gettingdressed.command.JacketCommand;
import com.spencershepard.gettingdressed.command.LeaveHouseCommand;
import com.spencershepard.gettingdressed.command.PantsCommand;
import com.spencershepard.gettingdressed.command.ShirtCommand;
import com.spencershepard.gettingdressed.command.SocksCommand;
import com.spencershepard.gettingdressed.command.TakeOffPajamasCommand;

/**
 * Application to process getting dressed commands
 * 
 * @author spencer.shepard
 *
 */
public class GettingDressed {

    /**
     * Fail constant
     */
    public static final String FAIL = "fail";
    
    /**
     * Apply the corresponding dress commands to the given arguments and ensure that all rules are followed. Print to
     * standard output.
     * 
     * @param args
     *            Arguments for main application
     */
    public static void main(String[] args) {
        final StringBuilder buf = new StringBuilder();
        try {
            // Verify that there are some arguments
            if (args == null || args.length <= 1) {
                throw new DressStateException();
            }
            final Temperature temp = Temperature.valueOf(args[0]);
            final Map<Integer, DressCommand> map = initMap();
            final DressState dressState = new DressState();
            for (int i = 1; i < args.length; i++) {
                DressCommand dressCommand = map.get(getCommandIndex(args[i]));
                if (dressCommand == null) {
                    throw new DressStateException();                    
                }
                buf.append(dressCommand.execute(temp, dressState));
                if (i < args.length - 1) {
                    buf.append(", ");                    
                }
            }
            // Verify the user has left the house 
            if (!dressState.isLeftHouse()) {
                buf.append(", ");
                throw new DressStateException();
            }
        } catch (IllegalArgumentException | NullPointerException | DressStateException e) {
            buf.append(FAIL);
        }
        System.out.println(buf);
    }
    
    /**
     * Get the index for the command by removing the comma if necessary.
     * 
     * @param s
     *            String to parse
     * @return Command index
     * @throws NumberFormatException
     *             String is not an integer
     */
    private static int getCommandIndex(String s) {
        if (s.endsWith(",")) {
            s = s.substring(0, s.length() - 1);
        }
        return Integer.parseInt(s);
    }
    
    /**
     * Get the initial map of dress commands.
     * 
     * @return map of dress commands 
     */
    private static Map<Integer, DressCommand> initMap() {
        Map<Integer, DressCommand> map = new HashMap<>();
        DressCommand footwearCommand = new FootwearCommand();
        map.put(footwearCommand.getCommandIndex(), footwearCommand);
        DressCommand headwearCommand = new HeadwearCommand();
        map.put(headwearCommand.getCommandIndex(), headwearCommand);
        DressCommand socksCommand = new SocksCommand();
        map.put(socksCommand.getCommandIndex(), socksCommand);
        DressCommand shirtCommand = new ShirtCommand();
        map.put(shirtCommand.getCommandIndex(), shirtCommand);
        DressCommand jacketCommand = new JacketCommand();
        map.put(jacketCommand.getCommandIndex(), jacketCommand);
        DressCommand pantsCommand = new PantsCommand();
        map.put(pantsCommand.getCommandIndex(), pantsCommand);
        DressCommand leaveHouseCommand = new LeaveHouseCommand();
        map.put(leaveHouseCommand.getCommandIndex(), leaveHouseCommand);
        DressCommand takeOffPajamasCommand = new TakeOffPajamasCommand();
        map.put(takeOffPajamasCommand.getCommandIndex(), takeOffPajamasCommand);
        
        return map;
    }
}
