import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.*;

public class MapSelectionLayout extends JFrame{
	JPanel panel;
	JLabel name;
	JButton btn;
	
	public MapSelectionLayout(String levelName, JFrame f,JPanel cPanel, int size, int id) {
		
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
				cPanel.setVisible(false);
				try {
					f.add(new MapLayout(f,cPanel,size,id).getPanel());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
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
