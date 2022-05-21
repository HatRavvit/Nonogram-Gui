import java.awt.*;

import javax.swing.*;

//Print row number
public class RowNumber extends JFrame{
	JPanel panel;
	JLabel temp;
	
	public RowNumber(int[] rowInfo, int rows) {
		int maxRow = rowInfo.length;
		int numHeight = 400/rows;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		for(int i=maxRow-1;i>=0;i--) {
			temp = new JLabel(String.valueOf(rowInfo[i]));
			temp.setBounds(100-13*(maxRow-i), (numHeight-20)/2, 13, 20);
			temp.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 12));
			temp.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(temp);
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
