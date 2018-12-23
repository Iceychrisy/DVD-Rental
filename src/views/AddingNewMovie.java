package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.MainCode;

/**
* Calls the adding movie window.
* @author Chris Lipscombe 14876717
**/

public class AddingNewMovie extends JFrame
{
	private JButton buttonSubmit;
	private JTextField fieldTitle, fieldAuthor, fieldRating, fieldCast, fieldDate;
	private JLabel label;
	private JComboBox comboGenreFirst, comboGenreSecond, comboGenreThird;
	private String[] comboFields = {"Not too sure", "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Drama", "Documentary", "Fantasy", "Family", "Film-Noir", "History", "Musical", "Porn", "Romance", "Science fiction", "Thriller", "War"};
	private String linebreaker = "-------------------------------------------------------------------------------"; 
			
	/**
	* Calling the making of this window.
	* @return Nothing.
	* @author Chris Lipscombe 14876717
	* */
	
	public AddingNewMovie()
	{
		createMainView();
		
		setTitle("Adding new movie window");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(true);
	}
	
	/**
	* Creating the content that is in the adding a new movie window.
	* @return Nothing.
	* @author Chris Lipscombe 14876717
	* */
	
	private void createMainView() 
	{
		JPanel panelMain = new JPanel();
		getContentPane().add(panelMain);
		panelMain.getRootPane().setDefaultButton(buttonSubmit); //Setting enter button for Submit
		panelMain.setBackground(Color.lightGray);
		
		JPanel panelForm = new JPanel(new GridBagLayout());
		panelMain.add(panelForm);
		panelForm.setBackground(Color.lightGray);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_END;
		panelForm.add(new JLabel("Title: "), c);
		c.gridy += 2;
		panelForm.add(new JLabel("Author: "), c);
		c.gridy += 2;
		panelForm.add(new JLabel("Rating out of 10: "), c);
		c.gridy += 2;
		panelForm.add(new JLabel("Date: "), c);
		c.gridy += 2;
		panelForm.add(new JLabel("Cast: "), c);
		
		for(int i = 1; i <=3; i++)
		{
			c.gridy += 2;
			panelForm.add(new JLabel("Genre " + i +": "), c);
		}
		
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		fieldTitle = new JTextField(12); //0
		panelForm.add(fieldTitle, c);
		c.gridy += 2;
		
		fieldAuthor = new JTextField(12); //2
		panelForm.add(fieldAuthor, c);
		c.gridy += 2; 
		
		fieldRating = new JTextField(12); //4
		panelForm.add(fieldRating, c);
		c.gridy += 2; 
		
		fieldDate = new JTextField(12); //6
		panelForm.add(fieldDate, c);
		c.gridy += 2;
		
		fieldCast = new JTextField(12); //8
		panelForm.add(fieldCast, c);
		c.gridy += 2;
				
		comboGenreFirst = new JComboBox(comboFields); //10
		panelForm.add(comboGenreFirst, c);
		c.gridy += 2;
		
		comboGenreSecond = new JComboBox(comboFields); //10
		panelForm.add(comboGenreSecond, c);
		c.gridy += 2;
		
		comboGenreThird = new JComboBox(comboFields); //10
		panelForm.add(comboGenreThird, c);
		c.gridy += 2;
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(fieldTitle.getText() != null && fieldAuthor.getText() != null && fieldRating.getText() != null && fieldCast.getText() != null && fieldDate.getText() != null)
				{
					MainCode.movieInformation.add(fieldTitle.getText().trim());
					MainCode.movieInformation.add(fieldAuthor.getText().trim());
					MainCode.movieInformation.add(fieldRating.getText().trim() + "/10");
					MainCode.movieInformation.add(fieldCast.getText().trim());
					MainCode.movieInformation.add(fieldDate.getText().trim());
					MainCode.movieInformation.add((String) comboGenreFirst.getSelectedItem() + ", " + (String) comboGenreSecond.getSelectedItem() + ", " + (String) comboGenreThird.getSelectedItem());
					MainCode.movieInformation.add(linebreaker);
					MainCode.rightOutMovies();
					setVisible(false);
				}
				else
				{
					System.out.println("Sorry, You havent fulled out or got the rating of this new movie wrong.");
				}
			}
		});	
		c.gridx = 1;
		c.gridy = 16;
		panelForm.add(buttonSubmit, c);		
	}
}