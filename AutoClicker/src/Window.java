import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame{
	
	JPanel panel;

	public Window(){
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		
		JPanel sleepPanel = new JPanel();
		sleepPanel.setLayout(new BoxLayout(sleepPanel, BoxLayout.PAGE_AXIS));
		sleepPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		JLabel sleepLabel = new JLabel("Klicks pro Sekunde");
		sleepLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		sleepPanel.add(sleepLabel);
		
		SpinnerModel sleepSpinnerModel = new SpinnerNumberModel(10, 0, 60, 1);
		JSpinner sleepSpinner = new JSpinner(sleepSpinnerModel);
		sleepSpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
		sleepPanel.add(sleepSpinner);
		
		
		
		JPanel delayPanel = new JPanel();
		delayPanel.setLayout(new BoxLayout(delayPanel, BoxLayout.PAGE_AXIS));
		delayPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		JLabel delayLabel = new JLabel("Verzögerung in Sekunden");
		delayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		delayPanel.add(delayLabel);
		
		SpinnerModel delaySpinnerModel = new SpinnerNumberModel(10, 0, 60, 1);
		JSpinner delaySpinner = new JSpinner(delaySpinnerModel);
		delaySpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
		delayPanel.add(delaySpinner);
		
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		JLabel buttonLabel = new JLabel("Wähle eine Taste");
		buttonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(buttonLabel);
		
		String[] buttonList = {"Linke Maustaste", "Rechte Maustaste"};
		JComboBox <String> buttonComboBox = new JComboBox <String> (buttonList);
		buttonPanel.add(buttonComboBox);
		
		

		JLabel titleLabel = new JLabel("AutoClicker");
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(titleLabel);
		
		panel.add(sleepPanel);
		panel.add(delayPanel);
		panel.add(buttonPanel);
		
		JButton startLabel = new JButton("Starten");
		startLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(startLabel);
		
		add(panel);
		setSize(256, 256);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("AutoClicker");
		setVisible(true);
		
	}
	
}
