import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Cell extends JFrame{
	JPanel cellPanel;
	JLabel xLabel;
	int row, col;
	int mode;
	int topB, botB, leftB, rightB;
	char state;
	
	public Cell(int row, int col, int maxRow, int maxCol) {
		this.row = row;
		this.col = col;
		mode = 0;
		topB = 0;botB = 0;leftB = 0;rightB = 0;
		state = 'E';
		
		setBorder(maxRow, maxCol);
		
		cellPanel = new JPanel();
		cellPanel.setBorder(new MatteBorder(topB, leftB, botB, rightB, Color.black));
		cellPanel.setLayout(null);
		cellPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(mode==0) {
					if(state=='O') {
						cellPanel.setBackground(new Color(240, 240, 240));
						state = 'E';
					}
					else {
						cellPanel.setBackground(Color.black);
						xLabel.setVisible(false);
						state = 'O';
					}
				}
				else if(mode==1) {
					if(state=='O') {
						cellPanel.setBackground(new Color(240, 240, 240));
					}
					if(state=='X') {
						xLabel.setVisible(false);
						state = 'E';
					}
					else {
						xLabel.setVisible(true);
						state = 'X';
					}
				}
			}
		});
		
		xLabel = new JLabel("X");
		xLabel.setVisible(false);
		xLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if(maxCol>maxRow) {
			xLabel.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 500/maxCol));
		}
		else {
			xLabel.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 500/maxRow));
		}
		xLabel.setBounds(1, 0, 400/maxCol, 400/maxRow);
		
		cellPanel.add(xLabel);
		//xLabel.setVisible(false);
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public JPanel getPanel() {
		return cellPanel;
	}
	
	//Border line function
	public void setBorder(int maxRow, int maxCol) {
		if(row==0) {
			topB = 3;
		}
		else if(row==maxRow-1) {
			topB = 1;
			botB = 3;
		}
		else if(row%5==0) {
			topB = 3;
		}else {
			topB = 1;
		}
		
		if(col==0) {
			leftB = 3;
		}
		else if(col==maxCol-1) {
			leftB = 1;
			rightB = 3;
		}
		else if(col%5==0) {
			leftB = 3;
		}
		else {
			leftB = 1;
		}
	}
	
	public char getCellInfo() {
		return state;
	}
	
	public void setCellInfo(char in) {
		if(in=='O') {
			cellPanel.setBackground(Color.black);
			xLabel.setVisible(false);
			state = 'O';
		}
		else if(in=='X') {
			cellPanel.setBackground(new Color(240, 240, 240));
			xLabel.setVisible(true);
			state = 'X';
		}
		else {
			cellPanel.setBackground(new Color(240, 240, 240));
			xLabel.setVisible(false);
			state = 'E';
		}
	}
	
}
