package view;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.event.ActionListener;

import java.awt.Toolkit;

public class MyFrame extends JFrame {

    private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1.5);

    private MainJPanel panel;
    private JLabel title;

    public MyFrame() {
		super("Calculadora");
        panel = new MainJPanel();
        title = new JLabel("Calculadora");
		init();
        
	}

	private void init() {
        this.setVisible(true);
		this.setSize(width, height);
		this.setLocation((int)(width*0.25), (int)(height*0.5));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        title.setFont(new Font("Arial", Font.ITALIC, 40));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
	}

    public void addListener(ActionListener listener){
        panel.addListener(listener);
    }

    public MainJPanel getMainPanel(){
        return panel;
    }
}
