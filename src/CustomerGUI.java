import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerGUI extends JFrame
{
	private String username = "";
    public CustomerGUI(String username)
    {
        super("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.username = username;
        setTitle("Welcome "+ username + "!");
        add(new JLabel("Welcome!"));
        pack();
        setVisible(true);
    }
}