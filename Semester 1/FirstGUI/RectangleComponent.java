import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.geom.Color;


public class RectangleComponent extends JComponent{
  public void paintComponent(Graphics g){
    Day today = new Day();
    int year = today.getYear();
    Day dadBday = new Day(1974, 12, 18);
    Day momBday = new Day(1978, 1, 15);
    Day broBday = new Day(2007, 11, 12);
    Day meBday = new Day(2003, 1, 8);

    int dBday = 365 - today.daysFrom(dadBday);
    int mBday = 365 - today.daysFrom(momBday);
    int bBday = 365 - today.daysFrom(broBday);
    int myBday = 365 - today.daysFrom(meBday);


    Graphics2D g2 = (Graphics2D) g;
    Rectangle box = new Rectangle(5, 10, dBDay, 30);
    Rectangle box = new Rectangle(25, 10, mBDay, 30);
    Rectangle box = new Rectangle(45, 10, bBDay, 30);
    Rectangle box = new Rectangle(65, 10, mBDay, 30);

    g2.draw(box);
  }
}
