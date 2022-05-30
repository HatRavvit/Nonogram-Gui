import java.awt.*;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DifficultySelectionLayout extends SelectionPanel implements Layouts.DifficultyLayout{
	
	public DifficultySelectionLayout(JFrame f, JPanel lPanel) {
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,600);
		panel.setLayout(new GridLayout(7,1));
		
		JLabel title = new JLabel("Level Selection");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 60));
		panel.add(title);
		
		panel.add(makeDifficultyLayout("EASY (5X5)", f, panel, 0, 2));
		
		panel.add(makeDifficultyLayout("NORMAL (10X10)", f, panel, 1, 4));
		
		panel.add(makeDifficultyLayout("HARD (20X20)", f, panel, 2, 2));
		
		panel.add(makeDifficultyLayout("Other Size", f, panel, 3, 2));
		
		JPanel temp = new JPanel();
		panel.add(temp);
		
		panel.add(makeBackPanel(lPanel, panel, "Back"));
		
		f.add(panel);
	}

	@Override
	public JPanel makeDifficultyLayout(String levelName, JFrame f, JPanel cPanel, int size, int mapNum) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel name = new JLabel(levelName);
		name.setBounds(0, 0, 450, 85);
		name.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 40));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(name);
		
		JButton btn = new JButton("Select");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MapSelectionLayout mapSelection = new MapSelectionLayout(f, cPanel, size, mapNum);
				cPanel.setVisible(false);
			}
		});
		btn.setBounds(480, 25, 95, 35);
		btn.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 20));
		panel.add(btn);
		
		return panel;
	}
}
