package de.hfu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;


public class ResidentRepositoryStub implements ResidentRepository {
    List<Resident> bewohner = new ArrayList<Resident>();
    public ResidentRepositoryStub(){
        super();
        bewohner.add(new Resident("Marvin", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456)));
        bewohner.add(new Resident("Natascha", "Roth", "Schramberger Weg", "Aichhalden", new Date(123456)));
        bewohner.add(new Resident("Leon", "Fleig", "Hauptstraße", "Deilingen", new Date(123456)));
    }

    @Override
    public List<Resident> getResidents() {
        return bewohner;
    }
}
