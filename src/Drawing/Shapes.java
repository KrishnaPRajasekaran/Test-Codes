package Drawing;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class Shapes extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Shapes(){
        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(450,450);
setDefaultCloseOperation(3);
        JButton button =new JButton("press");
        panel.add(button);
    }

    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        Rectangle2D rect=new Rectangle2D.Float(10, 10,100, 100);
        g2.draw(lin);
        g2.draw(rect);
    }

    public static void main(String []args){
        Shapes s=new Shapes();
        s.setVisible(true);
    }
}