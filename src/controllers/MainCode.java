package controllers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import views.AddingNewMovie;
import views.RemoveOldMovie;
import views.SearchingForMovie;

/**
* Main code, sets up and calls the windows.
* @author Chris Lipscombe 14876717
**/

public class MainCode extends JFrame
{
	//Setting JFrames.
	private JTextArea textArea;
	private JButton buttonClear, buttonAdd, buttonSearch, buttonRemove;
	private JTextField fieldMessage;
	private JLabel label;
	
	//Setting input files.
	public static ArrayList<String> movieInformation = new ArrayList<String>();
	
	public MainCode()
	{
		readInMovies();	//Sets up reading in a file and populating string array fieldJLabel.
		createMainView();
		
		setTitle("Assignment 3 Main Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 630);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	/**
	* Crating every window.
	* @return Nothing.
	* @author Chris Lipscombe 14876717
	* */
	
	private void createMainView() 
	{		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBackground(Color.darkGray);
		
		/**
		* Adding the add movie button.
		* @return Nothing.
		* @author Chris Lipscombe 14876717
		* */
				
		buttonAdd = new JButton("Add a movie");
		buttonAdd.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						new AddingNewMovie().setVisible(true); //Run adding window.
						revalidate();
					}
				});
			}
		});
		panel.add(buttonAdd);
		
		/**
		* Adding the search for a movie button.
		* @return Nothing.
		* @author Chris Lipscombe 14876717
		* */
		
		buttonSearch = new JButton("Search for a movie");
		buttonSearch.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						new SearchingForMovie().setVisible(true); //Run search window.
						revalidate();
					}
				});
			}
		});
		panel.add(buttonSearch);
		
		/**
		* Adding the remove a movie button.
		* @return Nothing.
		* @author Chris Lipscombe 14876717
		* */
		
		buttonRemove = new JButton("Remove a movie");
		buttonRemove.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						new RemoveOldMovie().setVisible(true); //Run remove window.
						revalidate();
					}
				});
			}
		});
		panel.add(buttonRemove);

		textArea = new JTextArea();
		mergingTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(650, 510));
		panel.add(scrollPane);
		
		/**
		* Adding the refresh button.
		* @return Nothing.
		* @author Chris Lipscombe 14876717
		* */
		
		buttonClear = new JButton("Refresh after adding/removing a new movie");
		buttonClear.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText("");
				mergingTextArea();
				revalidate();
			}	
		});
		panel.add(buttonClear);
	}
	
	/**
	* Adding the movies into the main window to display it.
	* @return Nothing
	* @author Chris Lipscombe 14876717
	* */
	
	public void mergingTextArea()
	{
		for(int i = 0; i < movieInformation.size(); i++)
		{
			textArea.append(movieInformation.get(i) + "\n");
		}
	}
	
	/**
	* Putting the content inside the text file into an array list.
	* @return Returning an array list with the input files content.
	* @author Chris Lipscombe 14876717
	* */
	
	public static void readInMovies()
	{	
		Scanner fileScanner;
		try 
		{
			fileScanner = new Scanner(new File("input/textFile.txt"));
			
			while(fileScanner.hasNextLine())
			{
				movieInformation.add(fileScanner.nextLine());
			}
			fileScanner.close();
		} 
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	* Exporting out the text file.
	* @return Nothing
	* @author Chris Lipscombe 14876717
	* */
	
	public static void rightOutMovies()
	{
		FileWriter writer = null;
		try 
		{
			writer = new FileWriter("input/textFile.txt");
			for(String s : movieInformation)
			{
				writer.write(s+"\n");
			}
		} 
		catch (IOException e) 
		{
			System.out.println("There was a problem writing out to file.");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(writer!=null)
				{
					writer.close();
				}
			} 
			catch (IOException e) 
			{
				System.out.println("There was a problem closing the file");
				e.printStackTrace();
			}
		}
	}
	
	/**
	* Converting the String array list into an array.
	* @return Returning an array.
	* @author Chris Lipscombe 14876717
	* */
	
	public static String[] movieInformationAsArray() 
	{
		return movieInformation.toArray(new String[0]);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new MainCode().setVisible(true);
			}
		});
	}
}
