package dev.luiscueva.threads;

import java.util.ArrayList;

public class EasyThread extends Thread{

	private ArrayList<Object> sharedResources;
	
	public  EasyThread(ArrayList<Object> sharedResources) {
		super();
		this.sharedResources = sharedResources;
	}
	
	public EasyThread(Object sharedResources) {
		super();
		this.sharedResources = new ArrayList<Object>();
		this.sharedResources.add(sharedResources);
	}

	public ArrayList<Object> getSharedResources() {
		return sharedResources;
	}

	public void setSharedResources(ArrayList<Object> sharedResources) {
		this.sharedResources = sharedResources;
	}
	
}
