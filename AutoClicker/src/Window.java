import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	
	private JPanel panel;
	private Clicker clicker;

	public Window(){
		
		clicker = null;
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		
		
		JLabel titleLabel = new JLabel("AutoClicker");
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(titleLabel);
		
		
		
		JPanel sleepPanel = new JPanel();
		sleepPanel.setLayout(new BoxLayout(sleepPanel, BoxLayout.PAGE_AXIS));
		sleepPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		JLabel sleepLabel = new JLabel("Clicks per Second");
		sleepLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		sleepPanel.add(sleepLabel);
		
		SpinnerModel sleepSpinnerModel = new SpinnerNumberModel(10, 1, 100, 1);
		JSpinner sleepSpinner = new JSpinner(sleepSpinnerModel);
		sleepSpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
		sleepPanel.add(sleepSpinner);
		
		panel.add(sleepPanel);
		
		
		
		JPanel delayPanel = new JPanel();
		delayPanel.setLayout(new BoxLayout(delayPanel, BoxLayout.PAGE_AXIS));
		delayPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		JLabel delayLabel = new JLabel("Delay in Seconds");
		delayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		delayPanel.add(delayLabel);
		
		SpinnerModel delaySpinnerModel = new SpinnerNumberModel(10, 1, 100, 1);
		JSpinner delaySpinner = new JSpinner(delaySpinnerModel);
		delaySpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
		delayPanel.add(delaySpinner);
		
		panel.add(delayPanel);
		
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		JLabel buttonLabel = new JLabel("Select a Button");
		buttonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(buttonLabel);
		
		String[] buttonList = {"Left Mouse Button", "Right Mouse Button"};
		JComboBox <String> buttonComboBox = new JComboBox <String> (buttonList);
		buttonPanel.add(buttonComboBox);
		
		panel.add(buttonPanel);
		
		
		
		JButton startButton = new JButton("Start");
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(startButton);
		
		startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(clicker == null) {
            		int button = 0;
            		int index = buttonComboBox.getSelectedIndex();
            		switch(index) {
            		case 0:
            			button = InputEvent.BUTTON1_MASK;
            			break;
            		case 1:
            			button = InputEvent.BUTTON3_MASK;
            			break;
            		}
            		clicker = new Clicker((int) sleepSpinner.getValue(), (int) delaySpinner.getValue(), button);
            		clicker.start();
            		
            		startButton.setText("Stop");
            	}else {
            		clicker.shutdown();
            		clicker = null;
            		
            		startButton.setText("Start");
            	}
            }
        });
		
		add(panel);
		setSize(256, 256);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("AutoClicker");
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(clicker != null) {
					clicker.shutdown();
					clicker = null;
				}
			}
		});
		
	}

}
