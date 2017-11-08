import java.awt.Dimension;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import javax.swing.JButton;

public class TriangleButton extends JButton {


	/*private static int width = 100, height = 100;
	

	public GameTileTest(String label) {
		setPreferredSize(new Dimension(width, height));
		setText(label);
		
	}
	
	public GameTileTest(GameTileTest t) {
		// TODO Auto-generated constructor stub
		setPreferredSize(t.getPreferredSize());
		setText(t.getText());
	}

	public GameTileTest clone() {
		return this.clone();
	}*/


//	public class TriangleButton extends JButton {
//	  public TriangleButton(String label) {
	public TriangleButton (String label){
	    super(label);

	    // These statements enlarge the button so that it 
	    // becomes a circle rather than an oval.
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, 
	      size.height);
	    setPreferredSize(size);

	    // This call causes the JButton not to paint 
	    // the background.
	    // This allows us to paint a round background.
	    setContentAreaFilled(false);
	  }

	  // Paint the round background and label.
	  protected void paintComponent(Graphics g) {
	    if (getModel().isArmed()) {
	      // You might want to make the highlight color 
	      // a property of the RoundButton class.
	      g.setColor(Color.lightGray);
	    } else {
	      g.setColor(getBackground());
	    }
	    
	    int x3Points[] = {0, 0, getSize().width};
	    int y3Points[] = {0, getSize().height, getSize().height};
	    g.fillPolygon(x3Points, y3Points, x3Points.length); 

	    // This call will paint the label and the 
	    // focus rectangle.
	    super.paintComponent(g);
	  }

	  // Paint the border of the button using a simple stroke.
	  protected void paintBorder(Graphics g) {
	    g.setColor(getForeground());
//	    int x3Points[] = {getSize().width/2, 0, getSize().width};
	    int x3Points[] = {0, 0, getSize().width-1};
	    int y3Points[] = {0, getSize().height-1, getSize().height-1};
	    g.drawPolygon(x3Points, y3Points, x3Points.length); 
//	    g.drawPolygon(x3Points, y3Points, 4); 
	  }

	  // Hit detection.
	  Polygon polygon;
	  public boolean contains(int x, int y) {
	    // If the button has changed size, 
	    // make a new shape object.
	    if (polygon == null || 
	      !polygon.getBounds().equals(getBounds())) {
//	      int x3Points[] = {0, 0, getSize().width};
//	      int y3Points[] = {0, getSize().height, getSize().height};
//	      polygon = new Polygon(x3Points,y3Points,3);
	      int x3Points[] = {0, 0, getSize().width,getSize().width};
	      int y3Points[] = {0, getSize().height, getSize().height,0};
	      polygon = new Polygon(x3Points,y3Points,4);
	    }
	    return polygon.contains(x, y);
	  }

	  // Test routine.
	  public static void main(String[] args) {
	    // Create a button with the label "Jackpot".
	    JButton button = new TriangleButton("Jackpot");
	    button.setBackground(Color.green);

	    // Create a frame in which to show the button.
	    JFrame frame = new JFrame();
	    frame.getContentPane().setBackground(Color.yellow);
	    frame.getContentPane().add(button);
	    frame.getContentPane().setLayout(new FlowLayout());
	    frame.setSize(150, 150);
	    frame.setVisible(true);
	  }	
}
