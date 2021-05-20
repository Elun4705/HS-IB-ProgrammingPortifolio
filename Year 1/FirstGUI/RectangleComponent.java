import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.geom.Line2D;

public class RectangleComponent extends JComponent{
  public void paintComponent(Graphics g){
    Day today = new Day();
    int year = today.getYear();
    Day dadBday = new Day(year - 1, 12, 18);
    Day momBday = new Day(year, 1, 15);
    Day broBday = new Day(year - 1, 11, 12);
    Day meBday = new Day(year, 1, 8);

    int dBday = 365 - today.daysFrom(dadBday);
    int mBday = 365 - today.daysFrom(momBday);
    int bBday = 365 - today.daysFrom(broBday);
    int myBday = 365 - today.daysFrom(meBday);


    Graphics2D g2 = (Graphics2D) g;
    
    Rectangle box1 = new Rectangle(100, 100, dBday, 30);
    String dadB = Integer.toString(dBday);
    g2.setColor(Color.BLUE);
    g2.drawString(dadB, dBday + 110, 120);
    g2.drawString("Dad", 70, 120);
    g2.fill(box1);
    
    Rectangle box2 = new Rectangle(100, 200, mBday, 30);
    String momB = Integer.toString(mBday);
    g2.setColor(Color.MAGENTA);
    g2.drawString(momB, mBday + 110, 220);
    g2.drawString("Mom", 65, 220);
    g2.fill(box2);
   
    Rectangle box3 = new Rectangle(100, 300, bBday, 30);
    String broB = Integer.toString(bBday);
    g2.drawString(broB, bBday + 110, 320);
    g2.drawString("Little Bro", 45, 320);
    
    
    Rectangle box4 = new Rectangle(100, 400, myBday, 30);
    String myB = Integer.toString(myBday);
    g2.setColor(Color.GRAY);
    g2.drawString(myB, myBday + 110, 420);
    g2.drawString("Me(Emmanuel)", 10, 420);
    g2.fill(box4);

    Line2D.Double xaxis = new Line2D.Double(100, 100, 100, 430);
    g2.setColor(Color.BLACK);
    g2.draw(xaxis);

    Line2D.Double yaxis = new Line2D.Double(100, 430, 400, 430);
    g2.setColor(Color.BLACK);
    g2.draw(yaxis);

    g2.draw(box1);
    g2.draw(box2);
    g2.draw(box3);
    g2.draw(box4);
  }
}
