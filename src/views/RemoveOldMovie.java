package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.MainCode;

/**
* Calls the removing movie window.
* @author Chris Lipscombe 14876717
**/

public class RemoveOldMovie extends JFrame
{
	private JTextField fieldTitle, fieldAuthor, fieldRating, fieldDate, fieldGenre, fieldCast, fieldSubmit;
	private JButton buttonTitle, buttonRemove, buttonSearch;
	private JTextArea textArea;
	
	/**
	* Calling the making of this window.
	* @return Nothing.
	* @author Chris Lipscombe 14876717
	* */
	
	public RemoveOldMovie()
	{
		createMainView();
		
		setTitle("Search window");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(true);
	}
	
	/**
	* Creating the content that is in the adding a new movie window.
	* @return Nothing.
	* @author Chris Lipscombe 14876717
	* */
	
	public void createMainView() 
	{
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBackground(Color.lightGray);
		panel.setForeground(Color.WHITE);
		
		JPanel panelMain = new JPanel();
		getContentPane().add(panelMain);
		panelMain.setBackground(Color.lightGray);
		
		JPanel panelForm = new JPanel(new GridBagLayout());
		panelMain.add(panelForm);
		panelForm.setBackground(Color.lightGray);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panelForm.add(new JLabel("Title: "), c); //0, 0
		c.gridx = 1;

		fieldTitle = new JTextField(15); 
		panelForm.add(fieldTitle, c); //1, 0
		c.gridx = 1;
		c.gridy = 1;
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.append("Simple type the title of the movie you wish to delete, Remember to refresh after closing");
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(166, 160));
		panelForm.add(scrollPane, c); //0, 1
			
		buttonRemove = new JButton("Remove");
		buttonRemove.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int indexNumber = MainCode.movieInformation.indexOf(fieldTitle.getText().trim());
				for(int i = 0; i < 7; i++)
				{
					MainCode.movieInformation.remove(indexNumber);
				}
				MainCode.rightOutMovies();
			}
		});
		c.gridx = 2;
		c.gridy = 1;
		panelForm.add(buttonRemove, c);	
		
		
	}
}
