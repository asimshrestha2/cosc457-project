import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmployeeGUI extends JFrame
{
	private String username = "";
    public EmployeeGUI(String username)
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