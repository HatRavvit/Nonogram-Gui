import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class NonogramGui extends JFrame{
	JPanel titlePanel, difficultySelectPanel, gamePanel;
	ArrayList<JPanel> mapSelectionPanel;
	ArrayList<JPanel> size5List;
	Container c;

	public NonogramGui() {
		//
		setTitle("NONOGRAM");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(606, 629);
		getContentPane().setLayout(null);
		
		c = getContentPane();
		
		titlePanel = makeTitlePanel();
		c.add(titlePanel);
		
		size5List = new ArrayList<>();
		for(int i=0;i<2;i++) {
		}
		
		mapSelectionPanel = new ArrayList<>();
		for(int i=0;i<5;i++) {
			mapSelectionPanel.add(makeMapSelectionPanel(i));
			mapSelectionPanel.get(i).setVisible(false);
			c.add(mapSelectionPanel.get(i));
		}
		
		difficultySelectPanel = makeDifficultySelectionPanel();
		c.add(difficultySelectPanel);
		difficultySelectPanel.setVisible(false);
		
		setVisible(true);
	}
	
	public JPanel makeTitlePanel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 600);
		panel.setLayout(null);
		
		JLabel title = new JLabel("NoNoGram");
		title.setBounds(0, 100, 600, 100);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 50));
		panel.add(title);
		
		JButton b = new JButton("START");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				titlePanel.setVisible(false);
				difficultySelectPanel.setVisible(true);
			}
		});
		b.setBounds(235, 400, 130, 40);
		b.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		panel.add(b);
		
		return panel;
	}
	
	public JPanel makeDifficultySelectionPanel() {
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,600);
		panel.setLayout(new GridLayout(7,1));
		
		JLabel title = new JLabel("Level Selection");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 60));
		panel.add(title);
		
		DifficultySelectionLayout level1 = new DifficultySelectionLayout("BASIC (5X5)", panel, mapSelectionPanel.get(0));
		panel.add(level1.getPanel());
		
		DifficultySelectionLayout level2 = new DifficultySelectionLayout("EASY (10X10)", panel, mapSelectionPanel.get(1));
		panel.add(level2.getPanel());
		
		DifficultySelectionLayout level3 = new DifficultySelectionLayout("NORMAL (15X15)", panel, mapSelectionPanel.get(2));
		panel.add(level3.getPanel());
		
		DifficultySelectionLayout level4 = new DifficultySelectionLayout("HARD (20X20)", panel, mapSelectionPanel.get(3));
		panel.add(level4.getPanel());
		
		DifficultySelectionLayout other = new DifficultySelectionLayout("Other Size", panel, mapSelectionPanel.get(4));
		panel.add(other.getPanel());
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		panel.add(backPanel);
		
		JButton backButton = new JButton("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				titlePanel.setVisible(true);
				difficultySelectPanel.setVisible(false);
			}
		});
		backButton.setBounds(10, 20, 120, 45);
		backButton.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		backPanel.add(backButton);
		
		return panel;
	}
	
	public JPanel makeMapSelectionPanel(int i) {
		JPanel temp;
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,600);
		panel.setLayout(new GridLayout(7,1));
		
		JLabel title = new JLabel();
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 45));
		panel.add(title);
		
		switch (i) {
		case 0: //For 5X5
			title.setText("Map Selection (5X5)");
			for(int j=1;j<=5;j++) {
				if(j<=2) {
					temp = new MapSelectionLayout("Map "+j, this, panel, i, j).getPanel();
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
					temp = new MapSelectionLayout("Map "+j, this, panel, i, j).getPanel();
					panel.add(temp);
				}
				else {
					temp = new JPanel();
					panel.add(temp);
				}
			}
			break;
		case 2: //For 15X15
			title.setText("Map Selection (15X15)");
			break;
		case 3: //For 20X20
			title.setText("Map Selection (20X20)");
			for(int j=1;j<=5;j++) {
				if(j<=2) {
					temp = new MapSelectionLayout("Map "+j, this, panel, i, j).getPanel();
					panel.add(temp);
				}
				else {
					temp = new JPanel();
					panel.add(temp);
				}
			}
			break;
		case 4: //For other sizes
			title.setText("Map Selection (Other)");
			for(int j=1;j<=5;j++) {
				if(j<=2) {
					temp = new MapSelectionLayout("Map "+j, this, panel, i, j).getPanel();
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
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		panel.add(backPanel);
		
		JButton backButton = new JButton("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				difficultySelectPanel.setVisible(true);
				panel.setVisible(false);
			}
		});
		backButton.setBounds(10, 20, 120, 45);
		backButton.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		backPanel.add(backButton);
		
		return panel;
	}
	
}
