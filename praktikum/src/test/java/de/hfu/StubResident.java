package de.hfu;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;

public class StubResident {
    
    @Test
    public void testFilteredResidentsList(){
        BaseResidentService base = new BaseResidentService();
        Resident filter = new Resident();
        TestStub repo = new TestStub();
        base.setResidentRepository(repo);
        assertEquals(1, base.getFilteredResidentsList(filter).size());

    }
}
