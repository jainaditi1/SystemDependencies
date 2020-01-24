package com.sf.interview.SystemDependencies.service;

import java.util.ArrayList;

public class SystemComponentServiceImpl implements SystemComponentService {

	public boolean install(String dependency) {
		//Make a DB, API, or datasource call to ADD/INSTALL the component from the system. 
		//Assuming it success for this demo sake.
		
		//If success : return true
		//If fail : return false
	
		return true;
	}

	public boolean remove(String dependency) {
		//Make a DB, API, or datasource call to remove the component from the system. 
		//Assuming it success for this demo sake.
		
		//If success : return true
		//If fail : return false
		
		return true;
		

	}

	/**
	 * List of existing components in a system
	 * return ArrayList<String>  
	*/
	public ArrayList<String> listOfComponents() {
		// List of existing components in a system
		ArrayList<String> dependentComponentsList = new ArrayList<String>();
		dependentComponentsList.add("NETCARD");
		dependentComponentsList.add("BROWSER");
		return dependentComponentsList;
	}

	

	/**
	 * List of dependencies for an existing component in a system
	 * parameter String 
	 * return ArrayList<String>  
	*/
	public ArrayList<String> listOfDependencies(String systemComponent) {
		// Creating Arraylist with dummy values
		ArrayList<String> dependentComponentsList = new ArrayList<String>();
		dependentComponentsList.add("TELNET");
		dependentComponentsList.add("TCPIP");
		return dependentComponentsList;
	}

	
	
	public ArrayList<String> dependsOn(String systemComponent, String dependency) {
		ArrayList<String> dependencies = listOfDependencies(systemComponent);
		return dependencies;
	}

}
