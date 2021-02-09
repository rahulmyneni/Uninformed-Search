Programming language: Java 

Code Structure:

1) The input arguments are declared.
2)The input text file is read and stored in an array list.
3) A seperate class node_properties is created to store the properties of a node that is path_cost, depth and the present_state.
4) Initialise these properties and add the nodes to the fringe_array using array list.
5) The first element from the fringe_array is removed and added it to the current_node and also to goal_node.
6)The array is now checked and all the successor nodes are added and also the cost is calculated.
7)The loop created checks for all the nodes to find the destination.
8)once the goal state is reached it is re-traced back in the same order and the final cost is displayed.
9)The fringe list is sorted to obtain an optimal solution.

Compilation Instructions:

javac find_route.java
java find_route input.txt source destination

Referred links: 

https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
https://www.javatpoint.com/java-arraylist
http://www.baeldung.com/java-stringtokenizer
http://www.benchresources.net/sorting-arraylist-using-comparable-and-comparator-in-java/



