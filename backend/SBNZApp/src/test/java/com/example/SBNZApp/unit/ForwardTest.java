package com.example.SBNZApp.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.facts.Putovanje;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.Smestaj;
import com.example.SBNZApp.facts.TipKorisnika;

@RunWith(SpringRunner.class)
public class ForwardTest {
	private static KieContainer kieContainer;
	private static KieBase kieBase;

    private static final String agenda = "premium";
    private RegisteredUser user1;
    
	private List<Putovanje> putovanja;
    @Before
    public void setup() {
    	 KieServices kieServices = KieServices.Factory.get();
         KieBaseConfiguration config = kieServices.newKieBaseConfiguration();
 		config.setOption(EventProcessingOption.STREAM);
         kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
         kieBase = kieContainer.newKieBase(config);
		Destinacija more = new Destinacija();

        user1 = new RegisteredUser();
        Smestaj s1 = new Smestaj();
		s1.setDestinacija(more);
		Smestaj s2 = new Smestaj();
		s1.setDestinacija(more);
		Smestaj s3 = new Smestaj();
		s1.setDestinacija(more);
		String date2 = "2020-08-22";
		LocalDate localDate2 = LocalDate.parse(date2);
		Putovanje p1 = new Putovanje(s1, user1, 5, localDate2);
		Putovanje p2 = new Putovanje(s2, user1, 2, localDate2);
		Putovanje p3 = new Putovanje(s3, user1, 2, localDate2);
		Putovanje p4 = new Putovanje(s3, user1, 2, localDate2);
		Putovanje p5 = new Putovanje(s3, user1, 2, localDate2);
		Putovanje p6 = new Putovanje(s3, user1, 2, localDate2);
		user1.setVakcinacija(localDate2);
		putovanja = new ArrayList<>();
		putovanja.add(p1);
		putovanja.add(p2);
		putovanja.add(p3);
		putovanja.add(p4);
		putovanja.add(p5);
		putovanja.add(p6);
		
		user1.setPutovanja(putovanja);
    }
    
    @Test
    public void test_izvestaj_premium() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();


        kieSession.insert(user1);
        
        kieSession.fireAllRules();

        assertEquals(TipKorisnika.PREMIUM, user1.getTipKorisnika());
        assertTrue(user1.getPopust()>0);
    }
}
