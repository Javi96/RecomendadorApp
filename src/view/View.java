package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Model;
import controller.Controller;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane mainScroll;
	private JScrollPane recomendedGames;
	private JScrollPane recomendedByCategory;

	private JPanel mainPanel;
	private JPanel recomendedGamesPanel;
	private JPanel recomendedByCategoryPanel;

	public void start(Controller controller) {
		ArrayList<ImageIcon> imageIconList = controller.getImageIconList();
		
		this.setPreferredSize(new Dimension(500, 500));
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.recomendedGamesPanel = new JPanel(new GridLayout(1, imageIconList.size()));
		this.recomendedGamesPanel.setBorder(null);
		this.recomendedGamesPanel.setBackground(Color.WHITE);
		this.recomendedGamesPanel.setPreferredSize(new Dimension(648, 215));
		
		JLabel label;
		for(ImageIcon image : imageIconList){
			label = new JLabel(image);
			label.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					
				}
				
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			this.recomendedGamesPanel.add(new JLabel(image));
		}
		
		this.recomendedGames = new JScrollPane(this.recomendedGamesPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.recomendedByCategoryPanel = new JPanel();
		this.recomendedByCategory = new JScrollPane(this.recomendedByCategoryPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(Color.WHITE);
		this.mainPanel.add(this.recomendedGames);
		//this.mainPanel.add(this.recomendedByCategory);
		this.mainScroll = new JScrollPane(this.mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(this.mainScroll);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		View view  = new View();
		view.start(new Controller(new Model(), view));
	}

}