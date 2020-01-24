package com.sf.interview.SystemDependencies.service;

import java.util.ArrayList;

public interface SystemComponentService {

	public boolean install(String component);

	public boolean remove(String component);

	public ArrayList<String> listOfComponents();
	
	public ArrayList<String> listOfDependencies(String systemComponent);

	public ArrayList<String> dependsOn(String systemComponent, String dependency);

}
