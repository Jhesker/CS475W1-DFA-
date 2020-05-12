/*
 *
 */
package hesker475dfa.model;

/**
 * Defines the methods and class level variables for the Transition Object
 * Contains a default constructor for the object and the getters and setters 
 * for the class level variables
 * String fromState
 * char label
 * String toState
 * @author jhesker
 */
public class Transition 
{

    
    
    // Class level Variables
    private String fromState;
    private char label;
    private String toState;
    
    /**
     * Transition()-
     * Default Constructor for the Transition Object
     */
    public Transition() 
    {
        
    }
    
    /**
     * String getFromState()-
     * method returns the current value of fromState
     * @return String-fromState
     */
    public String getFromState() 
    {
        return fromState;
    }

    /**
     * setFromState(String fromState)-
     * method sets the current value of fromState
     * @param fromState
     */
    public void setFromState(String fromState)
    {
        this.fromState = fromState;
    }

    /**
     * getLabel()-
     * method returns the current value of label
     * @return label
     */
    public char getLabel() 
    {
        return label;
    }

    /**
     * setLabel(char label)-
     * method sets the current value of label
     * @param label
     */
    public void setLabel(char label) 
    {
        this.label = label;
    }

    /**
     * String getToState()-
     * method returns the current value of toState
     * @return toState
     */
    public String getToState() 
    {
        return toState;
    }

    /**
     * setToState(String toState)-
     * method sets the current value of toState
     * @param toState
     */
    public void setToState(String toState) 
    {
        this.toState = toState;
    }
}
