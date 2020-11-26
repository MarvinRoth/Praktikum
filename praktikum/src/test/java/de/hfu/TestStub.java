package de.hfu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;


public class TestStub implements ResidentRepository {
    List<Resident> bewohner = new ArrayList<Resident>();
    public TestStub(){
        super();
        bewohner.add(new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date()));
        bewohner.add(new Resident("Natascha", "Roth", "Schramberger Weg", "Aichhalden", new Date()));
    }
    public List<Resident> getResidents(){
        return null;
    }
}
