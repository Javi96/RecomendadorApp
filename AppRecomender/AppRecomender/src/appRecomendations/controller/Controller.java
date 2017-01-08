package appRecomendations.controller;


import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import appRecomendations.DataBase;
import appRecomendations.model.User;
import appRecomendations.model.observer.Observer;
import appRecomendations.view.View;



public class Controller implements Observer{

	private DataBase model;
	
	private View view;
	
	private User user;
		
	public Controller(DataBase model, View view){
		this.model = model;
		this.view = view;
		this.model.addObserver(this);
		//this.user = (User) model.getUsers();
	}
	
	public void add(Observer o) {
		model.addObserver(o);
	}
	
	public static void main(String[] args) {
		Controller ctrl = new Controller(new DataBase(), new View());
		ctrl.start();
	}

	public void start() {
		view.start(this);
		model.start();
	}

	public ArrayList<ImageIcon> getImageIconList(){
		return model.getImageIconList();
	}

	public void actUserApp (int counter){
		//model.
	}
	
	public void opAppEnd() {
		// TODO Auto-generated method stub
		
	}

	public void opAppStart(List<Image> actList) {
		// TODO Auto-generated method stub
		
	}

	public void OnUserLogOut() {
		// TODO Auto-generated method stub
		
	}

	public void OnListAct(List<Image> l) {
		// TODO Auto-generated method stub
		
	}

	public String getImageId(int i) {
		return model.getImageId(i);
	}
	
	
	
}