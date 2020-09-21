import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
//import java.awt.geom.Color;


public class RectangleComponent extends JComponent{
  public void paintComponent(Graphics g){
    Day today = new Day();
    int year = today.getYear();
    Day dadBday = new Day(year - 1, 12, 18);
    Day momBday = new Day(year - 1, 13, 15);
    Day broBday = new Day(year - 1, 11, 12);
    Day meBday = new Day(year -1, 13, 8);

    int dBday = today.daysFrom(dadBday);
    int mBday = today.daysFrom(momBday);
    int bBday = today.daysFrom(broBday);
    int myBday = today.daysFrom(meBday);


    Graphics2D g2 = (Graphics2D) g;
    Rectangle box1 = new Rectangle(50, 100, dBday, 30);
    Rectangle box2 = new Rectangle(50, 200, mBday, 30);
    Rectangle box3 = new Rectangle(50, 300, bBday, 30);
    Rectangle box4 = new Rectangle(50, 400, myBday, 30);

    g2.draw(box1);
    g2.draw(box2);
    g2.draw(box3);
    g2.draw(box4);
  }
}
