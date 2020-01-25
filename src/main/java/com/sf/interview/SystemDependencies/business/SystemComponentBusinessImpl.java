package com.sf.interview.SystemDependencies.business;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.logging.LogManager;

import com.sf.interview.SystemDependencies.model.Command;
import com.sf.interview.SystemDependencies.model.SystemComponent;
import com.sf.interview.SystemDependencies.resources.SystemMessages;
import com.sf.interview.SystemDependencies.service.SystemComponentService;

public class SystemComponentBusinessImpl {

	SystemComponentService componentService;

	public SystemComponentBusinessImpl(SystemComponentService componentService) {
		this.componentService = componentService;
	}

	public void execute(Command command, SystemComponent component) {
		if (command.equals(Command.REMOVE)) {
			remove(component);

		} else if (command.equals(Command.INSTALL)) {

			install(component);

		} else if (command.equals(Command.LIST)) {

			list();

		} else if (command.equals(Command.DEPENDSON)) {
			dependsOn(component);
		}
	}

	public SystemComponent dependsOn(SystemComponent component) {
		// In case if someone wants to query all the dependencies on a certain system
		// component
		ArrayList<String> dependencies = getDependencies(component.getName());

		if (dependencies != null && dependencies.size() > 0) {
			for (String dependency : dependencies) {
				System.out.println(dependency);
			}
		} else {
			System.out.println(SystemMessages.NO_DEPENDENCY_FOUND + " for component : " + component.getName());
			return new SystemComponent(component.getName(), null);
		}
		component.setDependencies(dependencies);
		return component;
	}

	public ArrayList<String> list() {
		// In case if someone wants to query list of all components exist in system
		// TODO: Ideally it should return list of all components in the system and their
		// sub-dependencies as well,
		// but in the interst of time, I am skipping returning sub-dependencies

		ArrayList<String> components = componentService.listOfComponents();

		if (components != null && components.size() > 0) {
			for (String systemComponent : components) {
				System.out.println(systemComponent);
			}
		} else {
			System.out.println(SystemMessages.NO_COMPONENT_FOUND + " in the system.");
			return new ArrayList<String>();
		}

		return components;
	}

	public boolean install(SystemComponent component) {
		// Its a good idea to check if the software component we are trying to install
		// already exists or not
		ArrayList<String> dependencies = getDependencies(component.getName());

		// Make sure all dependencies are removed before removing final component
		if (dependencies != null && dependencies.size() > 0) {
			for (String dependency : dependencies) {
				if (dependency.equals(component.getName())) {
					// TODO: Implement Logger on project level.
					// Note: I tried to add logger but surprised to see if getLogger() is probably
					// deprecated, so considering time limit I ended with sysout
					System.out.println(SystemMessages.DEPENDENCY_EXISTS);
					return false;
				}
			}
		}

		return componentService.install(component.getName());
	}

	public void remove(SystemComponent component) {
		// First : get the list of dependent components
		// If the list is greater than 0, delete each component
		// Once all dependencies are deleted
		// remove the software component

		ArrayList<String> dependencies = getDependencies(component.getName());

		// Make sure all dependencies are removed before removing final component
		if (dependencies != null && dependencies.size() > 0) {
			for (String dependency : dependencies) {
				componentService.remove(dependency);
			}
		}

		// Remove the parent system component
		componentService.remove(component.getName());
	}

	private ArrayList<String> getDependencies(String componentName) {
		ArrayList<String> dependencies = componentService.listOfDependencies(componentName);
		return dependencies;
	}

}
