package de.hfu;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import de.hfu.ResidentRepositoryStub;

public class StubResidentTest {
    
    @Test
    public void testGetFilteredesidentsList(){
        BaseResidentService brs = new BaseResidentService();
        Resident f = new Resident();
        ResidentRepositoryStub r = new ResidentRepositoryStub();
        brs.setResidentRepository(r);

        f.setGivenName("Marvin");
        assertEquals(1, brs.getFilteredResidentsList(f).size());
        f.setFamilyName("Roth");
        assertEquals(3, brs.getFilteredResidentsList(f).size());
        f.setStreet("Schramberger Weg");
        assertEquals(1, brs.getFilteredResidentsList(f).size());
    }

    @Test
    public void testGetUniqueResident() throws ResidentServiceException{
        BaseResidentService base = new BaseResidentService();
        ResidentRepositoryStub repo = new ResidentRepositoryStub();

        Resident filter = new Resident();
        filter.setGivenName("Marvin");
        Resident control = new Resident("Marvin", "Topkek", "Hauptstrasse", "Aichhalden", new Date(123456));

        base.setResidentRepository(repo);
        Resident ergebnis = base.getUniqueResident(filter);
        assertEquals(control, ergebnis);

    }

    @Test(expected = ResidentServiceException.class)
    public void testNoFoundException() throws ResidentServiceException{
        BaseResidentService base = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();
        base.setResidentRepository(stub);

        Resident filter = new Resident();
        filter.setGivenName("Urf");

        Resident control = new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456));

        assertEquals(control, base.getUniqueResident(filter));
    }

    @Test(expected = ResidentServiceException.class)
    public void testGivenNameException() throws ResidentServiceException{
        BaseResidentService base = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();
        base.setResidentRepository(stub);

        Resident filter = new Resident();
        filter.setGivenName("*");

        Resident control = new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456));

        assertEquals(control, base.getUniqueResident(filter));
    }

    @Test(expected = ResidentServiceException.class)
    public void testFamilyNameException() throws ResidentServiceException{
        BaseResidentService base = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();
        base.setResidentRepository(stub);

        Resident filter = new Resident();
        filter.setFamilyName("*");

        Resident control = new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456));

        assertEquals(control, base.getUniqueResident(filter));
    }

    @Test(expected = ResidentServiceException.class)
    public void testStreetException() throws ResidentServiceException{
        BaseResidentService base = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();
        base.setResidentRepository(stub);

        Resident filter = new Resident();
        filter.setStreet("*");

        Resident control = new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456));

        assertEquals(control, base.getUniqueResident(filter));
    }

    @Test(expected = ResidentServiceException.class)
    public void test() throws ResidentServiceException{
        BaseResidentService base = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();
        base.setResidentRepository(stub);

        Resident filter = new Resident();
        filter.setStreet("*");

        Resident control = new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456));

        assertEquals(control, base.getUniqueResident(filter));
    }

    @Test(expected = ResidentServiceException.class)
    public void testFamilyName() throws ResidentServiceException{
        BaseResidentService base = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();
        base.setResidentRepository(stub);

        Resident filter = new Resident();
        filter.setFamilyName("KEK");

        Resident control = new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456));

        assertEquals(control, base.getUniqueResident(filter));
    }
}
