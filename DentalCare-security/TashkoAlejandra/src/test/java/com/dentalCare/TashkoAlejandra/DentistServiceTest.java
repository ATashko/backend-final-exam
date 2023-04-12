package com.dentalCare.TashkoAlejandra;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Dentist;
import com.dentalCare.TashkoAlejandra.service.DentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DentistServiceTest {

    private static DentistService dentistService;

  /*  @BeforeClass
    public static void loadDataSet() {
        dentistService.createDentists(new Dentist("Pedro", "Perez", 34574));
    }

    @Test
    public void saveDentist() {
        Dentist dentist = dentistService.createDentists(new Dentist("Juan", "Ramirez", 348971960));
        Assert.assertTrue(dentist.getId() != null);

    }*/

    @Test
    public void deleteDentistTest() throws ResourceNotFoundException {
        dentistService.deleteDentist(1L);
        Assert.assertTrue(dentistService.getDentists(1L) == null);

    }

    @Test
    public void listAllDentists() {
        List<Dentist> dentists = (List<Dentist>) dentistService.findAllDentists();
        Assert.assertTrue(!dentists.isEmpty());
        Assert.assertTrue(dentists.size() > 0);
        System.out.println(dentists);
    }
}
