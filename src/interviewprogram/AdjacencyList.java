package interviewprogram;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;
public class AdjacencyList {
	
	int n;
    List<Node>[] adj;
    public AdjacencyList(int n0) {
        n = n0;
        adj = (List<Node>[])new List[n];
        for (int i = 0; i < n; i++) 
            adj[i] = new LinkedList();
        
    }
    
    //adds an edge to index i
    void addEdge(int i, Node n) {
        adj[i].add(n);
    }
    
    //returns true if there is an edge between two indexes
    boolean hasEdge(int i, String s) {
    	List<String> temp = new LinkedList();
    	for(int j = 0; j<adj[i].size(); j++){
    		temp.add(adj[i].get(j).getName());
    	}
    	
        return temp.contains(s);
    }
    
    //lists all edges for index i
    List<Node> edges(int i) {
        return adj[i];
    }
    
    //checks the index of the last occurrence of s
    int getIndex(int i, String s){
    	List<String> temp = new LinkedList();
    	for(int j = 0; j<adj[i].size(); j++){
    		temp.add(adj[i].get(j).getName());
    	}
    	int index = temp.lastIndexOf(s);
    	Node n = adj[i].get(index);
    	return n.getIndex();
    	
    }
    
    //checks the index of the first occurrence of s
    int getFirstIndex(int i, String s){
    	List<String> temp = new LinkedList();
    	for(int j = 0; j<adj[i].size(); j++){
    		temp.add(adj[i].get(j).getName());
    	}
    	int index = temp.indexOf(s);
    	Node n = adj[i].get(index);
    	return n.getIndex();
    	
    }
	

}
