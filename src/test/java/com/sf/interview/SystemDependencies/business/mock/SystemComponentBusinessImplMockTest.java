package com.sf.interview.SystemDependencies.business.mock;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.MockitoAnnotations;

import com.sf.interview.SystemDependencies.business.SystemComponentBusinessImpl;
import com.sf.interview.SystemDependencies.model.SystemComponent;
import com.sf.interview.SystemDependencies.service.SystemComponentService;

public class SystemComponentBusinessImplMockTest {

	//NOTE : really unsure why mockito and related methods like mock, when, then etc not working. Although I added the dependency and trying FORCE update maven dependencies as well.
	// :(
	// but still implemented a mock test just give an idea if any API call is made from the service layer, how we can mock it. 
	
	
	@Test
	public void testList() {
//		SystemComponentService service = mock(SystemComponentService.class);
//		SystemComponentBusinessImpl implementation = new SystemComponentBusinessImpl(service);
//		
//		SystemComponent component = new SystemComponent("TCPIP", null);
//		
//		
//		ArrayList<String> components = new ArrayList<String>();
//		components.add("NETCARD");
//		components.add("BROWSER");
//		when(service.listOfComponents()).thenReturn(components);
		
		
	}
	
}
