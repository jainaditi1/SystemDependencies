package com.sf.interview.SystemDependencies.model;

import java.util.ArrayList;


public class SystemComponent {

	private String name;
	private ArrayList<String> dependencies;
	
	
	public SystemComponent(String name, ArrayList<String> dependencies) {
		this.name = name;
		this.dependencies = dependencies;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<String> getDependencies() {
		return dependencies;
	}


	public void setDependencies(ArrayList<String> dependencies) {
		this.dependencies = dependencies;
	}
	
	
	
	
	
}
