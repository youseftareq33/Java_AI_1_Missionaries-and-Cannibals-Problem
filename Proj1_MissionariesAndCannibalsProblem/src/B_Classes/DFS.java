// yousef sharbi 1202057
// anas karakra 1200467

package B_Classes;

import StoreData_Stack.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class DFS {
   
	
	//=== Methods ============================================================
	
	// run DFS search to get solution
	public State DFS_MandC(State initState) {
	    State state = initState;
	  
        Stack<State> stack_list = new Stack<>();
        ArrayList<State> visited_list = new ArrayList<>();
        
        // At first push the state inside stack list.
        stack_list.push(state);
        while (!stack_list.isEmpty()) {
            State s = stack_list.pop(); // pop state from stack list and store it in variable s to add it to visited list.
            
            visited_list.add(s);
            ArrayList<State> listValidCases = s.validCases(); // store all valid cases to that state on listValidCases.
            
            for(int i=0;i<listValidCases.size();i++) {
            	// check if this valid case not on visited list and not on stack list
            	if (!visited_list.contains(listValidCases.get(i)) && !stack_list.isContains(listValidCases.get(i))) {
            		
            		/* if it achieve that cannibal and missionary are all cross the river then it success, else 
					 * it will push the valid cases till the search success or fail.
					*/ 
            		if(listValidCases.get(i).getLeft_cannibal()==0 && listValidCases.get(i).getLeft_missionary()==0) {
            			return listValidCases.get(i);
            		}
            		else {
            			stack_list.push(listValidCases.get(i));
            		}
            	}
            }
        }
	       
	    
        // if the stack empty then there is no solution.
	    return null;
	}
	
	// print BFS
	public void printDFS(State sol) {
		if(sol==null) {
			System.out.println("there is no solution.");
		}
		else {
			
			ArrayList<State> path=new ArrayList<State>();
			State s=sol;
			while(s!=null) {
				path.add(s);
				s=s.getPrevState();
			}
			
			int step_num=0;
			for(int i=path.size()-1;i>=0;i--) { // backtrack from solution to initial state
				s=path.get(i);
				
				if(s.getLeft_cannibal()==0 && s.getLeft_missionary()==0) {
					System.out.println(step_num+": "+s.toString());
				}
				else {
					System.out.print(step_num+": "+s.toString()+"\n");
					System.out.println("             "+"|");
					System.out.println("             "+"V");
				}
				
				step_num++;
			}
			
		}
	}

	// data of BFS
	public ArrayList<State> DFS_Data(State sol){
		ArrayList<State> path=new ArrayList<State>();
		State s=sol;
		while(s!=null) {
			path.add(s);
			s=s.getPrevState();
		}
		
		Collections.reverse(path);
		
		return path;
	}

    
}
