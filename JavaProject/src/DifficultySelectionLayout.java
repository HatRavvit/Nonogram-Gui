import java.awt.*;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DifficultySelectionLayout extends JFrame{
	JPanel panel;
	JLabel name;
	JButton btn;
	
	public DifficultySelectionLayout(String levelName, JPanel cPanel, JPanel nPanel) {
		
		panel = new JPanel();
		panel.setLayout(null);
		
		name = new JLabel(levelName);
		name.setBounds(0, 0, 450, 85);
		name.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 40));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(name);
		
		btn = new JButton("Select");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nPanel.setVisible(true);
				cPanel.setVisible(false);
			}
		});
		btn.setBounds(480, 25, 95, 35);
		btn.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 20));
		panel.add(btn);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
