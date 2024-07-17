// yousef sharbi 1202057
// anas karakra 1200467

package B_Classes;

import java.util.ArrayList;


public class State {
	
	//=== Attributes --------------------------------------------------------
	private int left_cannibal;
	private int left_missionary;
	private Boat boat;
	private int right_cannibal;
	private int right_missionary;
	private State prevState;
	
	
	//=== Constructor --------------------------------------------------------
	public State(int left_cannibal, int left_missionary, Boat boat, int right_cannibal, int right_missionary) {
		this.left_cannibal = left_cannibal;
		this.left_missionary = left_missionary;
		this.boat = boat;
		this.right_cannibal = right_cannibal;
		this.right_missionary = right_missionary;
	}


	//=== Getter and Setter --------------------------------------------------
	public int getLeft_cannibal() {
		return left_cannibal;
	}
	public void setLeft_cannibal(int left_cannibal) {
		this.left_cannibal = left_cannibal;
	}
	/////////////////////////////////////
	public int getLeft_missionary() {
		return left_missionary;
	}
	public void setLeft_missionary(int left_missionary) {
		this.left_missionary = left_missionary;
	}
	/////////////////////////////////////
	public Boat getBoat() {
		return boat;
	}
	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	/////////////////////////////////////
	public int getRight_cannibal() {
		return right_cannibal;
	}
	public void setRight_cannibal(int right_cannibal) {
		this.right_cannibal = right_cannibal;
	}
	/////////////////////////////////////
	public int getRight_missionary() {
		return right_missionary;
	}
	public void setRight_missionary(int right_missionary) {
		this.right_missionary = right_missionary;
	}
	/////////////////////////////////////
	public State getPrevState() {
		return prevState;
	}
	public void setPrevState(State prevState) {
		this.prevState = prevState;
	}
	

	//=== Methods ============================================================
	
	// check if the case valid to state
	public boolean isValidCase() {
		if((left_cannibal>=0 && left_missionary>=0 && right_cannibal>=0 && right_missionary>=0) && 
		   (left_missionary>=left_cannibal || left_missionary==0)&& 
		   (right_missionary>=right_cannibal) || right_missionary==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// valid cases list for status
	public ArrayList<State> validCases(){
		ArrayList<State> listValidCases=new ArrayList<>();
		
		// Cases:
		
		
		// Cases when boat left position:
	
		// case 1: (one cannibal) go from left to right.
		State case1_boat_left=new State(left_cannibal-1 , left_missionary ,new Boat("Cannibal", "Empty", "Right") , right_cannibal+1 , right_missionary);
		
		// case 2: (one missionary) go from left to right.
		State case2_boat_left=new State(left_cannibal , left_missionary-1 ,new Boat("Missionary", "Empty", "Right") , right_cannibal , right_missionary+1);
		
		// case 3: (one missionary and one cannibal) go from left to right.
		State case3_boat_left=new State(left_cannibal-1 , left_missionary-1 ,new Boat("Cannibal", "Missionary", "Right") , right_cannibal+1 , right_missionary+1);
		
		// case 4: (two cannibals) go from left to right.
		State case4_boat_left=new State(left_cannibal-2 , left_missionary ,new Boat("Cannibal", "Cannibal", "Right") , right_cannibal+2 , right_missionary);
		
		// case 5: (two missionaries) go from left to right.
		State case5_boat_left=new State(left_cannibal , left_missionary-2 ,new Boat("Missionary", "Missionary", "Right") , right_cannibal , right_missionary+2);
		
		
		// array of state to store possible cases that when boat on left position.
		State listCases_boatLeft[]= {case1_boat_left,case2_boat_left,case3_boat_left,case4_boat_left,case5_boat_left};
		
		/* if the boat had left position then --> list all left position cases
		 * then check if they are valid to that state and if they, then set this state(parent) the previous state for valid state(child).
		 * finally store that valid state(child) on listValidCases.
		*/
		if(boat.isPositionLeft()) {
			for(int i=0;i<listCases_boatLeft.length;i++) {
				if(listCases_boatLeft[i].isValidCase()) {
					listCases_boatLeft[i].setPrevState(this);
					listValidCases.add(listCases_boatLeft[i]);
				}
			}
		}
		
		
		//----------------------------------------------------------------------------------------------------------------------------------------------------
		
		// Cases when boat right position:
		
		// case 1: (one cannibal) go from right to left.
		State case1_boat_right=new State(left_cannibal+1 , left_missionary ,new Boat("Cannibal", "Empty", "Left") , right_cannibal-1 , right_missionary);
		
		// case 2: (one missionary) go from right to left.
		State case2_boat_right=new State(left_cannibal , left_missionary+1 ,new Boat("Missionary", "Empty", "Left") , right_cannibal , right_missionary-1);
		
		// case 3: (one missionary and one cannibal) go from right to left.
		State case3_boat_right=new State(left_cannibal+1 , left_missionary+1 ,new Boat("Missionary", "Cannibal", "Left") , right_cannibal-1 , right_missionary-1);
		
		// case 4: (two cannibals) go from right to left.
		State case4_boat_right=new State(left_cannibal+2 , left_missionary ,new Boat("Cannibal", "Cannibal", "Left") , right_cannibal-2 , right_missionary);
		
		// case 5: (two missionaries) go from right to left.
		State case5_boat_right=new State(left_cannibal , left_missionary+2 ,new Boat("Missionary", "Missionary", "Left") , right_cannibal , right_missionary-2);
		
		
		// array of state to store possible cases that when boat on right position.
		State listCases_boatRight[]= {case1_boat_right,case2_boat_right,case3_boat_right,case4_boat_right,case5_boat_right};
		
		/* if the boat had right position then --> list all right position cases
		 * then check if they are valid to that state and if they, then set this state(parent) the previous state for valid state(child).
		 * finally store that valid state(child) on listValidCases.
		*/
		if(boat.isPositionRight()) {
			for(int i=0;i<listCases_boatRight.length;i++) {
				if(listCases_boatRight[i].isValidCase()) {
					listCases_boatRight[i].setPrevState(this);
					listValidCases.add(listCases_boatRight[i]);
				}
			}
		}
		
		
		
		
		return listValidCases;
	}

	// equals
	@Override
    public boolean equals(Object obj) {
		// check if the object are instance of class state, and if it, then compares specific attributes of the objects.
        if (!(obj instanceof State)) {
            return false;
        }
        State s= (State)obj;
        return s.left_cannibal==left_cannibal && s.left_missionary==left_missionary &&
                s.right_cannibal==right_cannibal && s.right_missionary==right_missionary &&
                s.boat.getPosition().equals(boat.getPosition());
    }
		
	// toString
	@Override
	public String toString() {
		return "["+left_cannibal + ", " + left_missionary + ", (" + boat.toString()
		+ "), " + right_cannibal + ", " + right_missionary+"]";		
	}
	
	
}

