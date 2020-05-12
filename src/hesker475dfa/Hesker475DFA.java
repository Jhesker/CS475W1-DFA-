/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hesker475dfa;

import hesker475dfa.model.*;
import java.io.*;
import static java.lang.System.exit;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Contains the main method
 * @author jhesk
 */
public class Hesker475DFA
{

    /**
     * method() - prompts the user and executes main functions of the program
     * @param args
     */
    public static void main(String[] args) 
    {
        JFileChooser jFile = new JFileChooser("input");
        int returnVal = jFile.showOpenDialog(null);
        boolean loop = true;
        FiniteAutomata auto = new FiniteAutomata();
        
        /**
         * while loop used to prevent user from repeatedly running application
         * if an error occurs or the user exits without choosing a file.
         * 
         * Big-O The big O of this code is O(N) this is because the code never 
         * enters into a nested loop. During the reading of the input file. 
         */
        while(loop == true)
        {
            // if file opend correctly 
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                loop = false;//exiting loop         
            }
            //Error output for file not opened 
            else
            {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Open file was Cancelled by" +
                      " user or another error occcured./n Please try opening" +
                     " your file again");
            }  
        }
        
        File input = jFile.getSelectedFile();
        try 
        {
            
            Scanner scan = new Scanner(input); 
            
            
            
            //set start state from first line
            auto.setStartState(scan.nextLine());
                    
            //test start state input
            System.out.println(auto.getStartState());
                    
            //set accept states 
            String acceptStates = scan.nextLine();
            String str[] = acceptStates.split(" ");
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(Arrays.asList(str));
            auto.setAcceptStates(arrayList);
                    
            //test acceptStates input
            System.out.println(auto.getAcceptStates().toString());
                    
                    
            // Create Transitions list from input and set list in auto
            
            ArrayList<Transition> tranList = new ArrayList<>();
             
            while(scan.hasNext())
            {
                Transition transition = new Transition();
                transition.setFromState(scan.next());
                transition.setLabel(scan.next().charAt(returnVal));
                transition.setToState(scan.next());
                tranList.add(transition);
                System.out.println(transition.getFromState() + " " +
                        transition.getLabel() + " " + 
                        transition.getToState());
            }
                    
            auto.setTransitions(tranList);
            
            //Testing inputs and methods 
            ArrayList<Transition> transitions = auto.getTransitions();
            System.out.print("Transitions List - ");
            transitions.forEach((transition) -> 
            {
            System.out.print("[ " + transition.getFromState() + " " +
                    transition.getLabel() + " " +
                    transition.getToState() + " ]");
            });
            System.out.println();
            System.out.println("Alphabet - " + auto.alphabet());
            System.out.println("States - " + auto.states().toString());
                    
            scan.close();
                    
        }
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Hesker475DFA.class.getName()).log(
                 Level.SEVERE, null, ex);
        }
                
        // user input to get test string and testing via run method      
        JFrame frame = new JFrame("InputDialog Example #1");
        String inputString = JOptionPane.showInputDialog(frame, 
                "Please enter the " + "String to be tested.");
        boolean successful = auto.run(inputString);
        if(successful)
        {
            JOptionPane.showMessageDialog(frame, "Your String was accepted " +
                    "by the DFA");
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Your String was not accepted "
                    + "by the DFA");
        }
        exit(0);   
    }   
}
