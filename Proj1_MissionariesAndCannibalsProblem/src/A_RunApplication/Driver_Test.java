// yousef sharbi 1202057
// anas karakra 1200467

package A_RunApplication;


import java.util.ArrayList;
import java.util.Scanner;

import B_Classes.BFS;
import B_Classes.Boat;
import B_Classes.DFS;
import B_Classes.State;

public class Driver_Test {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("---------------- Missionaries and Cannibals Problem by BFS and DFS ----------------"+"\n");
		long endTime;
		long startTime;
		
		for(;;) {
			System.out.println("Please choose the type of search:");
			System.out.println("1. BFS");
			System.out.println("2. DFS");
			System.out.println("3. Exit from the program");
			
			int choice;
			System.out.print("\n"+"choice number: ");
			choice=in.nextInt();
			
			switch (choice) {
				case 1:{
					startTime = System.nanoTime();
					BFS sol=new BFS();
					State sol_bfs=sol.BFS_MandC(new State(3, 3, new Boat("Empty", "Empty", "Left"), 0, 0));
					System.out.println("\n"+"printBFS: "+"\n");
					System.out.println("[Left Cannibals, Left Missionaries, Boat(Passenger1, Passenger2, Position), Right Cannibals, Right Missionaries]");
					sol.printBFS(sol_bfs);
					System.out.println("--------------------------"+"\n");
					System.out.println("BFS Data: "+"\n");
					ArrayList<State> al_sol=sol.BFS_Data(sol_bfs);
					System.out.println(al_sol.toString());
					System.out.println("\n========================================================================");
					endTime = System.nanoTime();
					System.out.println("BFS Execution time: "+(endTime - startTime));
					break;
				}
				case 2:{
					startTime = System.nanoTime();
					DFS sol=new DFS();
					State sol_bfs=sol.DFS_MandC(new State(3, 3, new Boat("Empty", "Empty", "Left"), 0, 0));
					System.out.println("\n"+"printDFS: "+"\n");
					System.out.println("[Left Cannibals, Left Missionaries, Boat(Passenger1, Passenger2, Position), Right Cannibals, Right Missionaries]");
					sol.printDFS(sol_bfs);
					System.out.println("--------------------------"+"\n");
					System.out.println("DFS Data: "+"\n");
					ArrayList<State> al_sol=sol.DFS_Data(sol_bfs);
					System.out.println(al_sol.toString());
					System.out.println("\n========================================================================");
					endTime = System.nanoTime();
					System.out.println("DFS Execution time: "+(endTime - startTime));
					break; 
				}
				case 3:{
					System.exit(0);
					break;
				}
			}
			
			
		}

		
	}
	
	
}
