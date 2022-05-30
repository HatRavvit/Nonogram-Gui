import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class FailLayout {
	JFrame f;
	
	public FailLayout(JFrame f, JPanel lPanel) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 600);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Failed!");
		title.setBounds(0, 100, 600, 100);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 60));
		panel.add(title);
		
		JButton b = new JButton("List");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				lPanel.setVisible(true);
			}
		});
		b.setBounds(235, 400, 130, 40);
		b.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		panel.add(b);
		
		f.add(panel);
	}

}
