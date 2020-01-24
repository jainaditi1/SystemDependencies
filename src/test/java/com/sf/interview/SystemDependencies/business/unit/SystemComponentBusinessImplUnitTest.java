package com.sf.interview.SystemDependencies.business.unit;

import java.util.ArrayList;

import org.junit.Test;

import com.sf.interview.SystemDependencies.business.SystemComponentBusinessImpl;
import com.sf.interview.SystemDependencies.model.Command;
import com.sf.interview.SystemDependencies.model.SystemComponent;
import com.sf.interview.SystemDependencies.service.SystemComponentService;
import com.sf.interview.SystemDependencies.service.SystemComponentServiceImpl;

import junit.framework.TestCase;

public class SystemComponentBusinessImplUnitTest extends TestCase {

	SystemComponentService systemComponentService = new SystemComponentServiceImpl();
	SystemComponentBusinessImpl systemComponentBusinessImpl = new SystemComponentBusinessImpl(systemComponentService);

	//TODO: More unit test cases needs to be included, especially the negative scenarios. 
	// I wanted to do exception handling, and add exception unit test cases as well. 
	
	@Test
	public void testExecute() {
		SystemComponent component = new SystemComponent("TCPIP", null);
		systemComponentBusinessImpl.execute(Command.REMOVE, component);
		systemComponentBusinessImpl.execute(Command.INSTALL, component);
		systemComponentBusinessImpl.execute(Command.LIST, component);
		systemComponentBusinessImpl.execute(Command.DEPENDSON, component);
	}

	@Test
	public void testListOfComponents() {

		ArrayList<String> listOfComponents = systemComponentBusinessImpl.list();

		assertNotNull(listOfComponents);
		assertEquals(2, listOfComponents.size());
		for (int i=0; i<listOfComponents.size(); i++) {
			assertEquals("NETCARD", listOfComponents.get(0));
			assertEquals("BROWSER", listOfComponents.get(1));
		}
	}

	@Test
	public void testInstall_DependencyExists() {

		SystemComponent component = new SystemComponent("TELNET", null);
		boolean isInstalled = systemComponentBusinessImpl.install(component);

		assertEquals(false, isInstalled);

	}

	@Test
	public void testInstall() {

		SystemComponent component = new SystemComponent("TCPIP", null);
		boolean isInstalled = systemComponentBusinessImpl.install(component);

		assertEquals(false, isInstalled);

	}
	
	@Test
	public void testDependsOn() {
		SystemComponent systemComponent = new SystemComponent("BROWSER", null);
		systemComponent = systemComponentBusinessImpl.dependsOn(systemComponent);
		ArrayList<String> dependencies = systemComponent.getDependencies();
		assertNotNull(dependencies);
		assertEquals(2, dependencies.size());
		for (int i=0; i<dependencies.size(); i++) {
			assertEquals("TELNET", dependencies.get(0));
			assertEquals("TCPIP", dependencies.get(1));
		}

	}

}
