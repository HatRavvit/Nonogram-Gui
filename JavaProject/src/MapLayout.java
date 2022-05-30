import java.awt.*;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Random;

public class MapLayout{
	JFrame f;
	JPanel panel, lPanel;
	JLabel lifeLabel;
	Cell[][] cells;
	Board board;
	int mode;
	int life;
	int hint;
	
	public MapLayout(JFrame f, JPanel lPanel, int size, int id) throws FileNotFoundException {
		this.f = f;
		board = new Board(size, id);
		mode = 0;
		life = 5;
		hint = 3;
		this.lPanel = lPanel;
		panel = new JPanel();
		panel.setBounds(0,0,600,600);
		panel.setLayout(null);
		
		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(150, 110, 400, 400);
		panel.add(mapPanel);
		mapPanel.setLayout(new GridLayout(board.getRow(), board.getColumn(), 0, 0));
		cells = new Cell[board.getRow()][board.getColumn()];
		
		//For column number side
		JPanel colPanel = new JPanel();
		colPanel.setBounds(150, 10, 400, 100);
		panel.add(colPanel);
		colPanel.setLayout(new GridLayout(1, board.getColumn(), 0, 0));
		
		for(int i=0;i<board.getColumn();i++) {
			colPanel.add(new ColumnNumber(board.colInfo[i], board.getColumn()).getPanel());
		}
		//For row number side
		JPanel rowPanel = new JPanel();
		rowPanel.setBounds(50, 110, 100, 400);
		panel.add(rowPanel);
		rowPanel.setLayout(new GridLayout(board.getRow(), 1, 0, 0));
		
		for(int i=0;i<board.getRow();i++) {
			rowPanel.add(new RowNumber(board.rowInfo[i], board.getRow()).getPanel());
		}
		//For main board
		for(int i = 0;i<board.getRow();i++) {
			for(int j=0;j<board.getColumn();j++) {
				cells[i][j] = new Cell(i,j, board.getRow(),board.getColumn(),board.ans[i][j], this);
				mapPanel.add(cells[i][j].getPanel());
			}
		}
		//Life
		lifeLabel = new JLabel("Life: "+life);
		lifeLabel.setBounds(10, 10, 100, 45);
		lifeLabel.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		panel.add(lifeLabel);
		
		makeLower();
		
		f.getContentPane().add(panel);
	}

	public JPanel getPanel() {
		return panel;
	}
	//If paint wrong cell
	public void lifeDecrement() {
		life--;
		lifeLabel.setText("Life: "+life);
		if(life==0) {
			panel.setVisible(false);
			FailLayout failLayout = new FailLayout(f, lPanel);
		}
	}
	//Make lower 4 button
	public void makeLower() {
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 520, 600, 80);
		btnPanel.setLayout(null);
		panel.add(btnPanel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				lPanel.setVisible(true);
			}
		});
		btnBack.setBounds(10, 12, 120, 45);
		btnBack.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		btnPanel.add(btnBack);
		
		JButton btnO = new JButton("O");
		btnO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0;i<board.getRow();i++) {
					for(int j=0;j<board.getColumn();j++) {
						cells[i][j].setMode(0);
					}
				}
			}
		});
		btnO.setBounds(210, 5, 60, 60);
		btnO.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		btnPanel.add(btnO);
		
		JButton btnX = new JButton("X");
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0;i<board.getRow();i++) {
					for(int j=0;j<board.getColumn();j++) {
						cells[i][j].setMode(1);
					}
				}
			}
		});
		btnX.setBounds(330, 5, 60, 60);
		btnX.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 30));
		btnPanel.add(btnX);
		
		JButton hintButton = new JButton("Hint: "+hint);
		hintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random rand = new Random();
				int temp, count = 0;
				for(int i = 0;i<board.getRow();i++) {
					for(int j=0;j<board.getColumn();j++) {
						if(cells[i][j].getCellInfo()=='E') {
							count++;
						}
					}
				}
				temp = rand.nextInt(count);
				count = 0;
				Loop:
				for(int i = 0;i<board.getRow();i++) {
					for(int j=0;j<board.getColumn();j++) {
						if(count==temp&&hint!=0) {
							cells[i][j].setCellInfo(board.getAnswer(i, j));
							hint--;
							hintButton.setText("Hint: "+hint);
							break Loop;
						}
						else {
							count++;
						}
					}
				}
			}
		});
		hintButton.setBounds(430, 15, 120, 40);
		hintButton.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 25));
		btnPanel.add(hintButton);
	}
	
	public void lineFinish() {
		//For row
		for(int i = 0;i<board.getRow();i++) {
			int count = 0;
			for(int j=0;j<board.getColumn();j++) {
				if(board.ans[i][j]=='O' && cells[i][j].getCellInfo()!='O') {
					count++;
				}
			}
			if(count==0) {
				for(int j=0;j<board.getColumn();j++) {
					if(board.ans[i][j]=='X') {
						cells[i][j].setCellInfo('X');;
					}
				}
			}
		}
		//For column
		for(int i = 0;i<board.getColumn();i++) {
			int count = 0;
			for(int j=0;j<board.getRow();j++) {
				if(board.ans[j][i]=='O' && cells[j][i].getCellInfo()!='O') {
					count++;
				}
			}
			if(count==0) {
				for(int j=0;j<board.getRow();j++) {
					if(board.ans[j][i]=='X') {
						cells[j][i].setCellInfo('X');;
					}
				}
			}
		}
	}
	
	public void whenFinish() {
		int count = 0;
		for(int i = 0;i<board.getRow();i++) {
			for(int j=0;j<board.getColumn();j++) {
				if(board.ans[i][j]!=cells[i][j].getCellInfo()) {
					count++;
				}
			}
		}
		if(count==0) {
			panel.setVisible(false);
			f.add(new SuccessLayout(f, lPanel, board).getPanel());
		}
	}

	
}
