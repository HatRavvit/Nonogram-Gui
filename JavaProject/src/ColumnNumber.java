import java.awt.*;

import javax.swing.*;

//Print column numbers
public class ColumnNumber{
	JPanel panel;
	JLabel temp;
	
	public ColumnNumber(int[] colInfo, int cols) {
		int maxCol = colInfo.length;
		int numWidth = 400/cols;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		for(int i=maxCol-1;i>=0;i--) {
			temp = new JLabel(String.valueOf(colInfo[i]));
			temp.setBounds((numWidth-20)/2, 100-13*(maxCol-i), 20, 13);
			temp.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 12));
			temp.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(temp);
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
