package com.example.SBNZApp.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.facts.Karakteristika;
import com.example.SBNZApp.facts.Putovanje;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.TipKorisnika;

@RunWith(SpringRunner.class)
public class IzvestajTest {
	private static KieContainer kieContainer;

    private static final String agenda = "neaktivni";
    private RegisteredUser user1;
    
    private RegisteredUser user2;
    
    @Before
    public void setup() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
 
      
        
        //USER NEAKTIVAN
        user1 = new RegisteredUser();
        Set<Karakteristika> karakteristikeKor = new HashSet<>();
        user1.setUsername("kor1@se.cc");
        user1.setPassword("123456");
        
        String date = "2020-08-22";

        
        LocalDate localDate = LocalDate.parse(date);
        user1.setVakcinacija(localDate);
        user1.setPreferences(karakteristikeKor);
        
        String registracija = "2019-08-22";
        LocalDate localRegistracija = LocalDate.parse(registracija);
        user1.setDatumRegistracije(localRegistracija);
        user1.setPreferences(karakteristikeKor);
        List<Putovanje> putovanja = new ArrayList<>();
        putovanja.clear();
        user1.setPutovanja(putovanja);
    
        //USER AKTIVAN
        user2 = new RegisteredUser();
        Set<Karakteristika> karakteristikeKor2 = new HashSet<>();
        user2.setUsername("kor1@se.cc");
        user2.setPassword("123456");
        
        String date2 = "2020-08-22";

        
        LocalDate localDate2 = LocalDate.parse(date2);
        user2.setVakcinacija(localDate2);
        user2.setPreferences(karakteristikeKor2);
        
        String registracija2 = "2020-08-22";
        LocalDate localRegistracija2 = LocalDate.parse(registracija2);
        user2.setDatumRegistracije(localRegistracija2);
        user2.setPreferences(karakteristikeKor2);
        List<Putovanje> putovanja2 = new ArrayList<>();
        putovanja2.clear();
        user2.setPutovanja(putovanja2);
    }
    
    @Test
    public void test_izvestaj_neaktivni() {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("neaktivni").setFocus();


        kieSession.insert(user1);
        kieSession.fireAllRules();

        assertEquals(TipKorisnika.NEAKTIVNI, user1.getTipKorisnika());
    }
    
    
    @Test
    public void test_izvestaj_nije_neaktivni() {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("neaktivni").setFocus();


        kieSession.insert(user2);
        kieSession.fireAllRules();

        assertNull(user2.getTipKorisnika());
    }

}
