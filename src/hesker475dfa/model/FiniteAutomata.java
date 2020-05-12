/*
 * 
 */
package hesker475dfa.model;

import java.util.*;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Defines the methods and variables of the FiniteAutomata class. Contains
 * default constructor as well as standard getters and setters for the three
 * class variables 
 * startState (String)
 * acceptStates (ArrayList-String)
 * states (ArrayList-String).
 * @author jhesk
 */
public class FiniteAutomata 
{
    
    // Class level Variables
    private String startState;
    private ArrayList<String> acceptStates;
    private ArrayList<String> states;
    private ArrayList<Transition> transitions;


    /**
     * @FiniteAutomata()-
     * Default Constructor for the FiniteAutomata Object
     */
    public FiniteAutomata() 
    {
        
    }

    /**
     * @getStartState()-
     * method returns the current value of startState from the current 
     * Finite Automata Object
     * 
     * @return String - startState
     */
    public String getStartState() 
    {
        return startState;
    }

    /**
     * @setStartState(String startState)-
     * method sets the current value of startState from the current 
     * Finite Automata Object
     * 
     * @param startState
     */
    public void setStartState(String startState) 
    {
        this.startState = startState;
    }

    /** 
     * @getAcceptStates()-
     * method returns the current value of acceptStates from the current 
     * Finite Automata Object
     *
     * @return ArrayList(String) - acceptStates
     */
    public ArrayList<String> getAcceptStates() 
    {
        return acceptStates;
    }

    /**
     * @setAcceptStates(ArrayList<String> acceptStates)-
     * method sets the current value of acceptStates from the current 
     * Finite Automata Object
     * 
     * @param acceptStates
     */
    public void setAcceptStates(ArrayList<String> acceptStates) 
    {
        this.acceptStates = acceptStates;
    }

    /**
     * @ArrayList<String> getStates()-
     * method returns the current value of states from the current 
     * Finite Automata Object
     * 
     * @return ArrayList(String) - states
     */
    public ArrayList<String> getStates() 
    {
        return states;
    }

    /**
     * @setStates(ArrayList<String> states)-
     * method sets the current value of states from the current 
     * Finite Automata Object
     * 
     * @param states
     */
    public void setStates(ArrayList<String> states) 
    {
        this.states = states;
    }
    
    /**
     * method returns the current value of Transitions ArrayList
     * @return ArrayList<Transition> transitions
     */
    public ArrayList<Transition> getTransitions() 
    {
        return transitions;
    }

    /**
     * setTransitions(ArrayList<Transition> transitions)-
     * method sets the current value of Transitions ArrayList
     * @param transitions
     */
    public void setTransitions(ArrayList<Transition> transitions) 
    {
        this.transitions = transitions;
    }
    
    /**
     * @alphabet() - takes Transitions list and creates and alphabet from 
     * all of the transition labels
     *
     * @return ArrayList<Character> alphabet
     */
    public ArrayList<Character> alphabet()
    {
        ArrayList<Character> alphabet = new ArrayList<>();
        Transition temp;
        for(int i = 0; i < transitions.size(); i++)
        {
            temp = transitions.get(i);
            alphabet.add(temp.getLabel());
        }
        List<Character> list = alphabet.stream().distinct().
                collect(Collectors.toList());
        ArrayList<Character> a2 = new ArrayList(list);
        return a2;
    }
    
    /**
     * @run(String input)- 
     * requests a user input for the DFA and tests the 
     * input against the previously loaded DFA
     * 
     * Due to the nested loops in the run method this has a big-O value of 
     * O(N^2)
     * 
     * @param input
     * @return
     */
    public boolean run(String input)
    {
        String currState = this.startState;
        char currChar;
        
        for(int i = 0; i < input.length(); i++)
        {
            currChar = input.charAt(i);
            for(int j = 0; j< this.transitions.size(); j++) {
                Transition transition = this.transitions.get(j);
                if (transition.getFromState().matches(currState) &&
                        currChar == transition.getLabel())
                {
                      currState = transition.getToState();
                }
            }
        }
        return acceptStates.contains(currState);
    }
    
    public ArrayList<String> states()
    {
        ArrayList<String> states1 = new ArrayList<>(); 
        this.transitions.forEach((transition) -> {
              String fromState = transition.getFromState();
              String toState = transition.getToState();
              states1.add(fromState);
              states1.add(toState);
        });
        Set<String> set = new LinkedHashSet<>(states1);
        ArrayList<String> states2 = new ArrayList<>(set);
        this.states = states2;
        return states;
    }
}
