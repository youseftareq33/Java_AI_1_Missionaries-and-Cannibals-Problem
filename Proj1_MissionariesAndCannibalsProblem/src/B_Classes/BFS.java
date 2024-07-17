// yousef sharbi 1202057
// anas karakra 1200467

package B_Classes;

import StoreData_Queue.Queue;
import java.util.ArrayList;
import java.util.Collections;

public class BFS {
	
	
	//=== Methods ============================================================
	
	// run BFS search to get solution
	public State BFS_MandC(State initState) {
		State state=initState;
		
		Queue<State> queue_list=new Queue<>();
		ArrayList<State> visited_list=new ArrayList<>();
		
		// At first enqueue the state inside queue list.
		queue_list.enqueue(state);
		for(;;) {
			if(queue_list.isEmpty()) { // if the queue empty then there is no solution.
				return null;
			}
			else {
				State s=queue_list.dequeue(); // dequeue state from queue list and store it in variable s to add it to visited list.
				
				visited_list.add(s); 
				ArrayList<State> listValidCases=s.validCases(); // store all valid cases to that state on listValidCases.
				
				for(int i=0;i<listValidCases.size();i++) {
					// check if this valid case not on visited list and not on queue list
					if( (!visited_list.contains(listValidCases.get(i))) || (!queue_list.isContains(listValidCases.get(i))) ) {
						
						/* if it achieve that cannibal and missionary are all cross the river then it success, else 
						 * it will enqueue the valid cases till the search success or fail.
						*/
						if(listValidCases.get(i).getLeft_cannibal()==0 && listValidCases.get(i).getLeft_missionary()==0) { 
							return listValidCases.get(i); 
						}
						else {
							queue_list.enqueue(listValidCases.get(i));
						}
					}
				}
			}
		}
		
	}

	// print BFS
	public void printBFS(State sol) {
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
	public ArrayList<State> BFS_Data(State sol){
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
