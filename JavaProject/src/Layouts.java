import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Layouts {
	interface TitleLayout{
		JPanel makeTitle();
	}
	interface DifficultyLayout{
		JPanel makeDifficultyLayout(String levelName, JFrame f, JPanel cPanel, int size, int mapNum);
	}
	interface MapSelectLayout{
		JPanel makeSelectionLayout(String levelName, JFrame f,JPanel cPanel, int size, int id);
	}
}
