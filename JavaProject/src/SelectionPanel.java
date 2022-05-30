import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectionPanel {
	JPanel makeBackPanel(JPanel lPanel, JPanel cPanel, String name) {
		JPanel backPanel = new JPanel();
		backPanel.setVisible(true);
		backPanel.setLayout(null);
		
		JButton backButton = new JButton(name);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lPanel.setVisible(true);
				cPanel.setVisible(false);
			}
		});
		backButton.setBounds(10, 20, 120, 45);
		backButton.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		backPanel.add(backButton);
		
		return backPanel;
	}
}
