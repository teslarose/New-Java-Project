import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
//implemented behavior number 2... and it works :D

public class GameBoardTest extends JFrame {
	private int counter = 1;
	private ArrayList<TriangleButton> tiles = new ArrayList<>();
	ButtonEventHandler beh = new ButtonEventHandler();
	public GameBoardTest() {
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("99 Puzzle");

		Container c = getContentPane();
		c.add(createGamePanel());

		setVisible(true);
		

	}

	private JPanel createGamePanel() {
		JPanel p = new JPanel();

		p.setLayout(new GridLayout(10, 10));

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (counter <= 99) {
				TriangleButton t = new TriangleButton(Integer.toString(counter));
				p.add(t);
				counter++;
				tiles.add(t);
				t.addActionListener(beh);
				}
				else {
					TriangleButton t = new TriangleButton("?");
					p.add(t);
					tiles.add(t);
					t.addActionListener(beh);
					counter++;
				}
				
			}
		}

		return p;
	}

	public static void main(String[] args) {
		new GameBoardTest();
	}
	private class ButtonEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			TriangleButton tf = null;
			TriangleButton tq = null;
			String command = ae.getActionCommand(); // get label on button that was clicked
			System.out.println(command);
			if (!command.equals("?")) {
			for (TriangleButton t: tiles) {
				if (t.getText().equals("?")) {
//					tq = t.clone();
					tq = t;
					break;
					}
			}
			for (TriangleButton t: tiles) {
				if (t.getText().equals(command)) {
//					tf = t.clone();
					tf = t;
					break;
					}
			}
			String cs = tf.getText(); // get current String from

			

			int currentValue = Integer.parseInt(cs, 10);
			String ns = Integer.toString(currentValue);
			tf.setText("?");

			
			tq.setText(ns);
			}
			else {
				System.out.println("? clicked");
			}
		}
		
	}
}

