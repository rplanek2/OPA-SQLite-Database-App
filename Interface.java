import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class Interface extends JFrame {
	private JLabel ui;
	public static void main(String[] args){
		JFrame x = new JFrame();
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setVisible(true);
	}
	
	public Interface(){
		super("Interface");
		setLayout(new FlowLayout());
		
		ui=new JLabel("UI");
		ui.setToolTipText("hover");
		add(ui);
	}
}
