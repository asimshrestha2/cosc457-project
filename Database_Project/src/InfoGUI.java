import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InfoGUI extends JFrame implements ActionListener {

    JLabel errorL;
    
    private JTextField emailText;
    public InfoGUI() {
        super("Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel listPane = new JPanel();
        
        listPane.setBackground(SessionData.getBgColor());

        
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
        
        JPanel textFieldPanel = new JPanel();
        		
        String text = "<html><body style=\"background: #333333; color: #FFFFFF; width: 350px; padding 20px;\"><bold><center><H2> <U> Hours of Operation </U> </H2>"
                + "<P>Monday: 11:00 am - 10:00 pm</P>"
                + "<P>Tuesday: 11:00 am - 10:00 pm</P>"
                + "<P>Wendsday: 11:00 am - 10:00 pm</P>"
                + "<P>Thursday: 11:00 am - 10:00 pm</P>"
                + "<P>Friday: 11:00 am - 10:00 pm</P>"
                + "<P>Saturday: 11:00 am - 10:00 pm</P>"
                + "<P>Sunday: 11:00 am - 10:00 pm</P>"
                + "<P> </P>"
                + "<P> </P>"
                + " <H2> <U>Locations</U> </H2>"
                + "<P>500 Kent Narrow Way N,</P>"
                + "<P>Grasonville, MD 21638</P>"
                + "<P> </P>"
                + "<P> 1609 17th St. NW,</P>"
                + "<P>Washington DS 20009</P>"
                + "<P> </P>"
                + "<P> </P>"
                + " <H2> <U>Contact Information</U> </H2>"
                + "<P>Phone: 410-827-7103 (Grasonville Location)</P>"
                + "<P>Phone: 202-232-0395 (DC Location)</P>"
                + "<P> Fax: 410-827-6715 (Grasonville Location) </P>"
                + "Email: info@annies.biz</P>"
                + "<P> </P>"
                + "<P> </P>"
                + " <H2> <U>Annie's Team</U> </H2>"
                + "<P>Owners: Michael & Helen Katinas</P>"
                + "<P>General Manager: Georgeanne McCreary</P>"
                + "<P>Executive Chef: Brett Wingard</P>"
                + "<P>Head Chef: Kurt Lentzsch</P>"
                + "</center></bold></body></html>";
        JLabel informationBox = new JLabel(text);
                
        textFieldPanel.setBackground(SessionData.getBgColor());
		textFieldPanel.add(informationBox);

        pack();
        setVisible(true);
        
        
        JButton backBtn = new JButton("Back" );
        JPanel btnPanel = new JPanel(new BorderLayout());
        
        
        btnPanel.setBackground(SessionData.getBgColor());
        btnPanel.add(backBtn);
                
                
        backBtn.addActionListener(this);
        backBtn.setActionCommand("backback");

        listPane.add(textFieldPanel);		
        listPane.add(btnPanel);
        add(listPane);	
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {    
		String cmd = ae.getActionCommand();
		System.out.println(cmd);
		if(cmd.equals("backback")){
			dispose();
        }
    }
    
}
