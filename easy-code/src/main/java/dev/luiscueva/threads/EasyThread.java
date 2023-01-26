package dev.luiscueva.threads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EasyThread extends Thread{

	@SuppressWarnings("rawtypes")
	private ArrayList sharedResources;
	private Method method;
	
	public <T> EasyThread(ArrayList<T> sharedResources, Method method) {
		super();
		this.sharedResources = sharedResources;
		this.method = method;
	}
	
	@SuppressWarnings("unchecked")
	public <T> EasyThread(T sharedResources) {
		super();
		this.sharedResources = new ArrayList<T>();
		this.sharedResources.add(sharedResources);
	}
	
	@Override
	public synchronized void start() {
		super.start();
		try {
			method.invoke(this, method.getParameters());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<?> getSharedResources() {
		return sharedResources;
	}

	public void setSharedResources(ArrayList<?> sharedResources) {
		this.sharedResources = sharedResources;
	}
	
}
