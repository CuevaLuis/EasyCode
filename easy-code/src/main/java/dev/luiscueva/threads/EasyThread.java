package dev.luiscueva.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Este objeto necesita ser instaciado como una clase anónima
 * en la que se sobreescriba el método start, propio de Thread
 * 
 * @author Luis Cueva
 *
 */

public class EasyThread extends Thread{

	private List<Object> sharedResources;
	
	public  EasyThread() {
		super();
		this.sharedResources = null;
	}
	
	public  EasyThread(List<Object> sharedResources) {
		super();
		this.sharedResources = sharedResources;
	}
	
	public EasyThread(Object sharedResources) {
		super();
		this.sharedResources = new ArrayList<Object>();
		this.sharedResources.add(sharedResources);
	}	

	public List<Object> getSharedResources() {
		return sharedResources;
	}

	public void setSharedResources(List<Object> sharedResources) {
		this.sharedResources = sharedResources;
	}
	
}
