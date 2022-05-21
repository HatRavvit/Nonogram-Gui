import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
	int rows, columns;
	int[][] rowInfo, colInfo;
	
	public Board(int type, int num) throws FileNotFoundException {
		//Open file
		String fileName = "problems\\P-"+type+num+".txt";
		Scanner efs = new Scanner(new File(fileName));
		//Get row & column from file
		String[] inputSize = efs.next().split(",");
		rows = Integer.parseInt(inputSize[0]);
		columns = Integer.parseInt(inputSize[1]);
		rowInfo = new int[rows][];
		colInfo = new int[columns][];
		//Get row information
		for(int i=0;i<rows;i++) {
			String[] rowInfos = efs.next().split(",");
			rowInfo[i] = new int[rowInfos.length];
			for(int j=0;j<rowInfos.length;j++) {
					rowInfo[i][j] = Integer.parseInt(rowInfos[j]);
			}
		}
		//Get column information
		for(int i=0;i<columns;i++) {
			String[] colInfos = efs.next().split(",");
			colInfo[i] = new int[colInfos.length];
			for(int j=0;j<colInfos.length;j++) {
				colInfo[i][j] = Integer.parseInt(colInfos[j]);
			}
		}
		
		efs.close();
	}
	
	public int getRow() {
		return rows;
	}
	
	public int getColumn() {
		return columns;
	}
	
}
