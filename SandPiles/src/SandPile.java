import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SandPile extends JFrame{
	int grid = 3;
	GridLayout layout = new GridLayout(grid,grid);
	
	public static void main(String[] args) {
		new SandPile();
	}
	public SandPile() {
		this.setSize(800, 800);
		this.setResizable(false);
		JPanel thePanel = new JPanel();
		thePanel.setLayout(layout);
		for(int x=0; x<grid; x++) {
			for(int y=0; y<grid; y++) {
				JButton button = new JButton("0");
				button.setName(Integer.toString(x)+":"+Integer.toString(y));
				button.setIcon(new ImageIcon("src/untitled-drawing--0-.png"));
				button.addActionListener(new ActionListener()
			    {
					public void actionPerformed(ActionEvent e) {
						button.setText(Integer.toString(Integer.parseInt(button.getText())+1));
						if(button.getText().equals("4")) {
							button.setIcon(new ImageIcon("src/untitled-drawing--0-.png"));
							try {
							    Thread.sleep(200);
							} catch(InterruptedException ex) {
							    Thread.currentThread().interrupt();
							}
							button.setText("0");
							int x = Integer.parseInt(button.getName().split(":")[0]);
							int y = Integer.parseInt(button.getName().split(":")[1]);
							if(y!=0) {
								JButton b = (JButton) thePanel.getComponent(grid*x+y-1);
								b.doClick();
							}
							if(x!=0) {
								JButton b = (JButton) thePanel.getComponent(grid*(x-1)+y);
								b.doClick();
							}
							if(y!=grid-1) {
								JButton b = (JButton) thePanel.getComponent(grid*x+y+1);
								b.doClick();
							}
							if(x!=grid-1) {
								JButton b = (JButton) thePanel.getComponent(grid*(x+1)+y);
								b.doClick();
							}
						}
						switch (button.getText()) {
						case "0": button.setIcon(new ImageIcon("src/untitled-drawing--0-.png")); break;
						case "1": button.setIcon(new ImageIcon("src/untitled-drawing--1-.png")); break;
						case "2": button.setIcon(new ImageIcon("src/untitled-drawing--2-.png")); break;
						case "3": button.setIcon(new ImageIcon("src/untitled-drawing--3-.png")); break;
						}
					}
			    });
				thePanel.add(button);
			}
		}
		this.add(thePanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
