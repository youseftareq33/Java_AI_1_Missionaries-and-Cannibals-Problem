// yousef sharbi 1202057
// anas karakra 1200467

package B_Classes;

public class Boat {
	
	//=== Attributes --------------------------------------------------------
	private String passenger1;
	private String passenger2;
	private String position;
	
	
	//=== Constructor --------------------------------------------------------
	public Boat(String passenger1, String passenger2, String position) {
		this.passenger1 = passenger1;
		this.passenger2 = passenger2;
		this.position = position;
	}


	//=== Getter and Setter --------------------------------------------------
	public String getPassenger1() {
		return passenger1;
	}
	public void setPassenger1_Cannibal() {
		this.passenger1 = "Cannibal";
	}
	public void setPassenger1_Missionary() {
		this.passenger1 = "Missionary";
	}
	/////////////////////////////////////
	public String getPassenger2() {
		return passenger2;
	}
	public void setPassenger2_Cannibal(String passenger2) {
		this.passenger2 = "Cannibal";
	}
	public void setPassenger2_Missionary(String passenger2) {
		this.passenger2 = "Missionary";
	}
	public void setPassenger2_Empty(String passenger2) {
		this.passenger2 = "Empty";
	}
	/////////////////////////////////////
	public String getPosition() {
		return position;
	}
	public void setPositionLeft() {
		this.position = "Left";
	}
	public void setPositionRight() {
		this.position = "Right";
	}

	
	//=== Methods ============================================================
	
	// check if boat position left
	public boolean isPositionLeft() {
		if(position.equals("Left")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// check if boat position right
	public boolean isPositionRight() {
		if(position.equals("Right")) {
			return true;
		}
		else {
			return false;
		}
	}

	// toString
	@Override
	public String toString() {
		return passenger1 + ", " + passenger2 + ", " + position;
	}
	
	
	
}
