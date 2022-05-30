import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.*;

public class MapSelectionLayout extends SelectionPanel implements Layouts.MapSelectLayout{
	
	public MapSelectionLayout(JFrame f,JPanel lPanel, int size, int mapNum) {
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,600);
		panel.setLayout(new GridLayout(7,1));
		
		JLabel title = new JLabel();
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 45));
		panel.add(title);
		
		JPanel temp;
		switch (size) {
		case 0: //For 5X5
			title.setText("Map Selection (5X5)");
			for(int j=1;j<=5;j++) {
				if(j<=2) {
					temp = makeSelectionLayout("Map "+j, f, panel, size, j);
					panel.add(temp);
				}
				else {
					temp = new JPanel();
					panel.add(temp);
				}
			}
			break;
		case 1: //For 10X10
			title.setText("Map Selection (10X10)");
			for(int j=1;j<=5;j++) {
				if(j<=4) {
					temp = makeSelectionLayout("Map "+j, f, panel, size, j);
					panel.add(temp);
				}
				else {
					temp = new JPanel();
					panel.add(temp);
				}
			}
			break;
		case 2: //For 20X20
			title.setText("Map Selection (20X20)");
			for(int j=1;j<=5;j++) {
				if(j<=2) {
					temp = makeSelectionLayout("Map "+j, f, panel, size, j);
					panel.add(temp);
				}
				else {
					temp = new JPanel();
					panel.add(temp);
				}
			}
			break;
		case 3: //For other sizes
			title.setText("Map Selection (Other)");
			for(int j=1;j<=5;j++) {
				if(j<=2) {
					temp = makeSelectionLayout("Map "+j, f, panel, size, j);
					panel.add(temp);
				}
				else {
					temp = new JPanel();
					panel.add(temp);
				}
			}
			break;
		default:
			break;
		}
		
		panel.add(makeBackPanel(lPanel, panel, "Back"));
		
		f.add(panel);
	}
	
	
	@Override
	public JPanel makeSelectionLayout(String levelName, JFrame f,JPanel cPanel, int size, int id) {
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
		
		return panel;
	}

}
