import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyMazeSolver implements IMazeSolver {

	int ADJACENT_POINTS_COUNT = 4, PAIR_SIZE = 2;
	
	public int[][] solveBFS(File maze) {
		
		int n = 0, m = 0;
		char[][] theMaze = null;
		boolean[][] visited = null;
		int[][] route = null;
		int routeCounter = 0;
		
		try {
			Scanner sc = new Scanner(maze);
			n = sc.nextInt();
			m = sc.nextInt();
			theMaze = new char[n][m];
			visited = new boolean[n][m];
			route = new int[n * m][2];
			for(int i = 0; i < n; ++i) {
				char[] currentLine = sc.next().toCharArray();
				for(int j = 0; j < m; ++j) {
					theMaze[i][j] = currentLine[j];
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
				System.out.println("Unexpected Error occured on Reading the File");
		}
		MyQueue S = new MyQueue();
		Object[] T = new Object[PAIR_SIZE];
		Point T0 = new Point();
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(theMaze[i][j] == 'S') {
					T0 = new Point(i, j);
					break;
				}
			}
		}
		T[0] = T0;
		T[1] = null;
		S.enqueue(T);
		boolean exitReached = false;
		
		while(!S.isEmpty()) {
			T = (Object[])S.dequeue();
			visited[((Point)T[0]).x][((Point)T[0]).y] = true;
			if(theMaze[((Point)T[0]).x][((Point)T[0]).y] == 'E') {
				exitReached = true;
				break;
			}
			int[][] adjPoints = new int[ADJACENT_POINTS_COUNT][PAIR_SIZE];
			
			adjPoints[0][0] = ((Point)T[0]).x - 1;
			adjPoints[0][1] = ((Point)T[0]).y;
			
			adjPoints[1][0] = ((Point)T[0]).x;
			adjPoints[1][1] = ((Point)T[0]).y + 1;
			
			adjPoints[2][0] = ((Point)T[0]).x + 1;
			adjPoints[2][1] = ((Point)T[0]).y;
			
			adjPoints[3][0] = ((Point)T[0]).x;
			adjPoints[3][1] = ((Point)T[0]).y - 1;
			
			for(int i = 0; i < ADJACENT_POINTS_COUNT; ++i) {
				if(adjPoints[i][0] < n && adjPoints[i][1] < m 
						&& adjPoints[i][0] >= 0 && adjPoints[i][1] >= 0) {
							if(theMaze[adjPoints[i][0]][adjPoints[i][1]] != '#' 
									&& visited[adjPoints[i][0]][adjPoints[i][1]] == false) {
										Point validPoint = new Point(adjPoints[i][0], adjPoints[i][1]);
										Object[] newT = new Object[PAIR_SIZE];
										newT[0] = validPoint;
										newT[1] = T;
										S.enqueue(newT);
							}
				}
			}
		}
		int c = 0;
		if(exitReached) {
			while(T[1] != null) {
				route[routeCounter][0] = ((Point)T[0]).x;
				route[routeCounter++][1] = ((Point)T[0]).y;
				T = (Object[])T[1];
				c++;
			}
			route[routeCounter][0] = ((Point)T[0]).x;
			route[routeCounter++][1] = ((Point)T[0]).y;
			c++;
		}
		routeCounter = 0;
		int[][] finalRoute = new int[c][2];
		for(int i = c - 1; i >= 0; --i) {
			finalRoute[i][0] = route[routeCounter][0];
			finalRoute[i][1] = route[routeCounter++][1];
		}
		return finalRoute;
	}

	public int[][] solveDFS(File maze) {
		
		int n = 0, m = 0;
		char[][] theMaze = null;
		boolean[][] visited = null;
		int[][] route = null;
		int routeCounter = 0;
		
		try {
			Scanner sc = new Scanner(maze);
			n = sc.nextInt();
			m = sc.nextInt();
			theMaze = new char[n][m];
			visited = new boolean[n][m];
			route = new int[n * m][2];
			for(int i = 0; i < n; ++i) {
				char[] currentLine = sc.next().toCharArray();
				for(int j = 0; j < m; ++j) {
					theMaze[i][j] = currentLine[j];
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
				System.out.println("Unexpected Error occured on Reading the File");
		}
		MyStack S = new MyStack();
		Object[] T = new Object[PAIR_SIZE];
		Point T0 = new Point();
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(theMaze[i][j] == 'S') {
					T0 = new Point(i, j);
					break;
				}
			}
		}
		T[0] = T0;
		T[1] = null;
		S.push(T);
		boolean exitReached = false;
		
		while(!S.isEmpty()) {
			T = (Object[])S.pop();
			visited[((Point)T[0]).x][((Point)T[0]).y] = true;
			if(theMaze[((Point)T[0]).x][((Point)T[0]).y] == 'E') {
				exitReached = true;
				break;
			}
			int[][] adjPoints = new int[ADJACENT_POINTS_COUNT][PAIR_SIZE];
			
			adjPoints[3][0] = ((Point)T[0]).x - 1;
			adjPoints[3][1] = ((Point)T[0]).y;
			
			adjPoints[2][0] = ((Point)T[0]).x;
			adjPoints[2][1] = ((Point)T[0]).y + 1;
			
			adjPoints[1][0] = ((Point)T[0]).x + 1;
			adjPoints[1][1] = ((Point)T[0]).y;
			
			adjPoints[0][0] = ((Point)T[0]).x;
			adjPoints[0][1] = ((Point)T[0]).y - 1;
			
			for(int i = 0; i < ADJACENT_POINTS_COUNT; ++i) {
				if(adjPoints[i][0] < n && adjPoints[i][1] < m 
						&& adjPoints[i][0] >= 0 && adjPoints[i][1] >= 0) {
							if(theMaze[adjPoints[i][0]][adjPoints[i][1]] != '#' 
									&& visited[adjPoints[i][0]][adjPoints[i][1]] == false) {
										Point validPoint = new Point(adjPoints[i][0], adjPoints[i][1]);
										Object[] newT = new Object[PAIR_SIZE];
										newT[0] = validPoint;
										newT[1] = T;
										S.push(newT);
							}
				}
			}
		}
		int c = 0;
		if(exitReached) {
			while(T[1] != null) {
				route[routeCounter][0] = ((Point)T[0]).x;
				route[routeCounter++][1] = ((Point)T[0]).y;
				T = (Object[])T[1];
				c++;
			}
			route[routeCounter][0] = ((Point)T[0]).x;
			route[routeCounter++][1] = ((Point)T[0]).y;
			c++;
		}
		routeCounter = 0;
		int[][] finalRoute = new int[c][2];
		for(int i = c - 1; i >= 0; --i) {
			finalRoute[i][0] = route[routeCounter][0];
			finalRoute[i][1] = route[routeCounter++][1];
		}
		return finalRoute;
	}
	
	public static void main(final String[] args) {
		
		MyMazeSolver x = new MyMazeSolver();
		File theMaze = new File("C:\\maze.txt");
		int[][] BFS_route = x.solveBFS(theMaze);
		System.out.println("BFS: ");
		for (int i = 0; i < BFS_route.length; ++i) {
			System.out.print("(" + BFS_route[i][0] + ", " + BFS_route[i][1] + ")");
			if(i != BFS_route.length - 1) {
				System.out.print(", ");
			}
		}
		int[][] DFS_route = x.solveDFS(theMaze);
		System.out.println();
		System.out.println("DFS: ");
		for (int i = 0; i < DFS_route.length; ++i) {
			System.out.print("(" + DFS_route[i][0] + ", " + DFS_route[i][1] + ")");
			if(i != DFS_route.length - 1) {
				System.out.print(", ");
			}
		}
		
	    
	}
	
}
