import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class SuccessLayout extends SelectionPanel{
	JPanel panel, lPanel;
	JLabel name;
	Board board;
	
	public SuccessLayout(JFrame f, JPanel lPanel, Board board) {
		this.board = board;
		this.lPanel = lPanel;
		panel = new JPanel();
		panel.setBounds(0,0,600,600);
		panel.setLayout(null);
		
		name = new JLabel("Success");
		name.setBounds(0, 0, 600, 85);
		name.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 40));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(name);
		
		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(100, 110, 400, 400);
		panel.add(mapPanel);
		mapPanel.setLayout(new GridLayout(board.getRow(), board.getColumn(), 0, 0));
		
		//For main board
		for(int i = 0;i<board.getRow();i++) {
			for(int j=0;j<board.getColumn();j++) {
				JPanel temp = new JPanel();
				int topB=0, leftB=0, bottomB=0, rightB=0;
				if(i==0) {
					topB = 1;
				}
				if(i==board.getRow()-1) {
					bottomB = 1;
				}
				if(j==0) {
					leftB = 1;
				}
				if(j==board.getColumn()-1) {
					rightB = 1;
				}
				temp.setBorder(new MatteBorder(topB, leftB, bottomB, rightB, Color.black));
				if(board.ans[i][j]=='O') {
					temp.setBackground(Color.black);
					mapPanel.add(temp);
				}
				else {
					temp.setBackground(Color.white);
					mapPanel.add(temp);
				}
			}
		}
		
		JPanel btnPanel = makeBackPanel(lPanel, panel, "List");
		btnPanel.setBounds(0, 512, 600, 80);
		panel.add(btnPanel);
		
		f.getContentPane().add(panel);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
