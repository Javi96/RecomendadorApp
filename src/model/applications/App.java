package model.applications;

import conection.VO;

public interface App extends VO{

	
	abstract void filter();
	
	abstract void show();
}
