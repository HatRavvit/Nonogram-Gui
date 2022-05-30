import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NonogramGui implements Layouts.TitleLayout{
	JFrame f;
	JPanel titlePanel;
	Container c;

	public NonogramGui() {
		f = new JFrame();
		
		f.setTitle("NONOGRAM");
		f.setResizable(false);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setSize(606, 629);
		f.getContentPane().setLayout(null);
		
		c = f.getContentPane();
		
		titlePanel = makeTitle();
		c.add(titlePanel);
		
		f.setVisible(true);
	}

	@Override
	public JPanel makeTitle() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 600);
		panel.setLayout(null);
		
		JLabel title = new JLabel("NoNoGram");
		title.setBounds(0, 100, 600, 100);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 60));
		panel.add(title);
		
		JButton b = new JButton("START");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				titlePanel.setVisible(false);
				DifficultySelectionLayout difficultySelectionLayout = new DifficultySelectionLayout(f, titlePanel);
			}
		});
		b.setBounds(235, 400, 130, 40);
		b.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		panel.add(b);
		
		return panel;
	}
	
	
}
