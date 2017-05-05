import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerGUI extends JFrame
{
    public CustomerGUI()
    {
        super("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Empty JFrame"));
        pack();
        setVisible(true);
    }
}