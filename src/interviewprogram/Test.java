package interviewprogram;
import java.util.List;
import java.util.Arrays;
public class Test {

	public static void main(String[] args) {
	
		String[] board = {"ABCE", "SFCS", "ADEE"};
		
		
		Graph g = new Graph(board, board.length, board[0].length());
		
		g.check("ABCCED");
		g.check("SEE");
		g.check("ABCB");
		
		g.check("AFS");
		g.check("GLRS");
		g.check("CBFA");
	}

}
