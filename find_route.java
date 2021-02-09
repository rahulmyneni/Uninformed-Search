//Rahul Myneni
//1001678634
import java.io.*;
import java.util.*;

public class find_route {
	public static void main(String[ ] args ) {
		String meth = args[0];
		String input_file = args[1];//string declaration for the inputs
		String src= args[2];
		String dest = args[3];
		ArrayList<String> array=new ArrayList<String>();//Creating array list
		try {// to read a input text file

			FileReader file = new FileReader(input_file);
			BufferedReader buffer =new BufferedReader(file);
			String line;
			while((line = buffer.readLine().toString()) .equals("END OF INPUT")==false) {
				array.add(line);

			}


			buffer.close();
		}
		catch(FileNotFoundException err) {
			System.out.println(
					"File Can't be opened"
					);
		} catch (IOException er) {
				}
		node parent_node = new node(null,0,0,src);      // object creations for the node- initial value of root, depth value, cost, name of the src
		ArrayList<node> fringe=new ArrayList<node>();//Creating array list to enter it to the fringe
		fringe.add(parent_node);
		node goal_node=null;
		ArrayList<String> closed_array=new ArrayList<String>();
		while(!(fringe.isEmpty())&& goal_node==null) {
			node current_node  = fringe.remove(0);             // removing the first element of the fringe and adding simultaneously

			if (current_node.present_state.equals(dest))
			{
				goal_node=current_node;
			}
			else{
				if (closed_array.contains(current_node.present_state)) {}
				else {
					closed_array.add (current_node.present_state);
					for(String temp : array)                                    //string,variable,:,list name
					{
						if(temp.contains(current_node.present_state)) {
							StringTokenizer tokenstring=new StringTokenizer(temp, " "); //split using the stringtokenizer by space
							String A=tokenstring.nextToken();
							String B=tokenstring.nextToken();
							float cost=(float)Integer.parseInt(tokenstring.nextToken());
							if(current_node.present_state.equals(A))
							{
								node city_node = new node(current_node,current_node.depth+1,current_node.path_cost+cost,B);
								fringe.add(city_node); //add the successor to the fringe
							}
							else {node city_node = new node(current_node,current_node.depth+1,current_node.path_cost+cost,A);
							fringe.add(city_node);
							}
						}
					}
					Collections.sort(fringe); //sorting the fringe to obtain an optimal solution
				}
			}
		}
		if(goal_node==null) {
			System.out.println("distance:infinity \n route\n none"); //if no route found.
		}
		else {
			goal_node.child=null;  
			System.out.println("Distance : "+goal_node.path_cost+"\nroute : ");
			while(goal_node.parent!=null) {
				goal_node.parent.child=goal_node;
				goal_node=goal_node.parent;
			}
			while(goal_node.child!=null) {
				System.out.println(goal_node.present_state+" to "+goal_node.child.present_state+" "+(goal_node.child.path_cost-goal_node.path_cost));
				goal_node=goal_node.child;
			}
		}
	}
}

