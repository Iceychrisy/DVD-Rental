package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.MainCode;

/**
* Calls the searching movie window.
* @author Chris Lipscombe 14876717
**/

public class SearchingForMovie extends JFrame
{
	private JTextField fieldTitle, fieldAuthor, fieldRating, fieldDate, fieldGenre, fieldCast, fieldSubmit;
	private JButton buttonTitle, buttonAuthor, buttonRating, buttonDate, buttonGenre, buttonCast, buttonSubmit;
	private JTextArea textArea;
	
	/**
	* Calling the making of this window.
	* @return Nothing.
	* @author Chris Lipscombe 14876717
	* */
	
	public SearchingForMovie()
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
						
		fieldGenre = new JTextField(12); //10
		panelForm.add(fieldGenre, c);
		
		buttonSubmit = new JButton("Search");
		buttonSubmit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				List <String> listClone = new ArrayList<String>();
				if(fieldTitle.getText() != null)
				{
					int loop = 0;
			        for (String s : MainCode.movieInformation) 
			        {
			        	if(loop == 2)
			        	{
			        		for(int i = 0; i < listClone.size(); i++)
			        		{
			        			textArea.append(listClone.get(i) + "\n");
			        		}
			        		break;
			        	}
			        	if(s.matches(fieldTitle.getText()))
			            {
			        		int indexNumber = MainCode.movieInformation.indexOf(fieldTitle.getText().trim());
			            	for(int i = 0; i < 6; i++)
			            	{
			            		listClone.add(MainCode.movieInformation.get(indexNumber));
			            		indexNumber++;
			            		loop = 2;
			            	}
			            }			        	
			        	if(s.matches(fieldAuthor.getText()))
			            {
			        		int indexNumber = MainCode.movieInformation.indexOf(fieldAuthor.getText().trim());
			        		indexNumber = indexNumber - 1;
			            	for(int i = 0; i < 5; i++)
			            	{
			            		listClone.add(MainCode.movieInformation.get(indexNumber));
			            		indexNumber++;
					        	loop = 2;
			            	}
			            }
			        	if(s.matches(fieldRating.getText()))
			            {
			        		int indexNumber = MainCode.movieInformation.indexOf(fieldRating.getText().trim());
			        		indexNumber = indexNumber - 2;
			            	for(int i = 0; i < 5; i++)
			            	{
			            		listClone.add(MainCode.movieInformation.get(indexNumber));
			            		indexNumber++;
			            		loop = 2;
			            	}
			            }
			        	if(s.matches(fieldDate.getText()))
			            {
			        		int indexNumber = MainCode.movieInformation.indexOf(fieldDate.getText().trim());
			        		indexNumber = indexNumber - 3;
			            	for(int i = 0; i < 5; i++)
			            	{
			            		listClone.add(MainCode.movieInformation.get(indexNumber));
			            		indexNumber++;
			            		loop = 2;
			            	}
			            }
			        }
				}
			}
		});
		c.gridx = 1;
		c.gridy = 14;
		panelForm.add(buttonSubmit, c);	
		c.gridx = 1;
		c.gridy = 16;
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(220, 70));
		panelForm.add(scrollPane, c);
	}
}