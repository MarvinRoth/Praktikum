package de.hfu;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class BaseResidentServiceMockTest {
	@Test
	public void test() throws ResidentServiceException {
		
		List <Resident> bewohner = new ArrayList<Resident>();
		bewohner.add(new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456)));
        bewohner.add(new Resident("Natascha", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456)));
		bewohner.add(new Resident("Leon", "Fleig", "Hauptstraße", "Deilingen", new Date(123456)));
		bewohner.add(new Resident("Tobi", "Utry", "Strasse", "Rottweil", new Date(12345)));

		
		ResidentRepository baseMock = createMock(ResidentRepository.class);
		BaseResidentService base = new BaseResidentService();
		base.setResidentRepository(baseMock);
		
		expect(baseMock.getResidents()).andReturn(bewohner).times(2);
		
		replay(baseMock);
		Resident filter = new Resident();
		filter.setGivenName("Marvin");
		assertEquals(1, base.getFilteredResidentsList(filter).size());
		
		
		Resident control = new Resident("Marvin", "Roth", "Hauptstrasse", "Aichhalden", new Date(123456));
		
		assertEquals(control,base.getUniqueResident(filter));
		
	}
}
