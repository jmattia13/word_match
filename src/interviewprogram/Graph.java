package interviewprogram;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class Graph {
    AdjacencyList adj;
    int size;
	
	Graph(String[] s, int Rows, int Columns){
		int rows = Rows;
		int columns = Columns;
		size = rows*columns;
		String board = "";
		
		for(int i=0; i<rows; i++)//combines each row of the board into one string
			board = board + s[i];
		
		String[] boardArray = board.split("");//splits string into individual letters and places in array
		Node[] node = new Node[size];
		
		for(int i=1; i<boardArray.length;i++){//places letters into nodes
			node[i-1] = new Node(boardArray[i], i-1);
		}
			
		
		adj = new AdjacencyList(size);
		
		//initial input for each letter into adjacency list
		for(int i = 0; i<size; i++){
			adj.addEdge(i, node[i]);		
		}
		
		
		//adds right edges to adjList
		for(int i= 0; i<size-1; i++){
			if((i+1)%columns == 0){//skips the last node in each row 
				continue;				
			}
			else{
				adj.addEdge(i, node[i + 1]);
			}
		}
		
		//adds left edges to adjList
		for(int i=1; i<size; i++){
			if(i%4 == 0){//skips the first node in each row
				continue;
				
			}
			else{
				adj.addEdge(i, node[i-1]);
			}
		}
		
		//adds top edges to adjList
		for(int i = columns; i<12; i++){//skips the first row
			adj.addEdge(i, node[i-columns]);
		}
		
		
		//adds bottom edges to adjList
		for(int i=0; i<size-columns; i++){//skips the last row
			adj.addEdge(i, node[i+columns]);
		}
		
	}
	
	//check adj list for matching edges that correspond to input string
	public void check(String s){
		String[] sArray = s.split("");//splits input string into individual letters
	
		for(int m = 0; m<size; m++){
			int j = 1;
			if(adj.hasEdge(m, sArray[j])){
				if((j==1) && (adj.getFirstIndex(m, sArray[j]) == m)){//brute force search for correct initial vertex
					int temp = m;
					boolean done = false;
					while(!done){
						if(j==sArray.length)
							done = true;
						else if(adj.hasEdge(temp, sArray[j])){
							temp = adj.getIndex(temp, sArray[j]);
							j++;
						}
						else
							done=true;
					}
				}
			}	
			if(j==sArray.length){
				System.out.println("Word exists within board");
				break;
			}
			if(m==size-1){
				System.out.println("Word does not exits within board");
				break;
			}
				
				
		}
	}
}