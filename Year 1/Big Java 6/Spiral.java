import java.awt.Graphics; 
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Spiral extends JPanel{
    
    public void paintComponent(Graphics g)
    {
        int width = getSize().width;
        int height = getSize().height;

        int widthCenter = width / 2;
        int heightCenter = height / 2;

        for (int i = 0; i < 4 ; i++)
        {
            g.drawLine(widthCenter + (20 * i), heightCenter - (20 * i), widthCenter + (20 * i), heightCenter + 20 + (20 * i));
            g.drawLine(widthCenter + (20 * i), heightCenter + 20 + (20 * i), widthCenter - 20 - (20 * i), heightCenter + 20 + (20 * i));
            g.drawLine(widthCenter - 20 - (20 * i), heightCenter + 20 + (20 * i), widthCenter - 20 - (20 * i), heightCenter - 20 - (20 * i));
            g.drawLine(widthCenter - 20 - (20 * i), heightCenter - 20 - (20 * i), widthCenter + 20 + (20 * i), heightCenter - 20 - (20 * i));
        }
    }

    public static void main(String[] args)
    {
        Spiral panel = new Spiral();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);      
        application.setSize(300, 300); 
        application.setVisible(true);     
    }
}
