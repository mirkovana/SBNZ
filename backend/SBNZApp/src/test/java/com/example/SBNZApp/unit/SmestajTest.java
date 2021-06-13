package com.example.SBNZApp.unit;

import static org.junit.Assert.assertEquals;

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
import com.example.SBNZApp.facts.RegisteredUser.Pol;
import com.example.SBNZApp.facts.RegisteredUser.RadniStatus;
import com.example.SBNZApp.facts.RegisteredUser.TipLjubimca;
import com.example.SBNZApp.facts.Smestaj;
import com.example.SBNZApp.facts.TrenutniUser;

@RunWith(SpringRunner.class)
public class SmestajTest {
	private static KieContainer kieContainer;
	private static KieBase kieBase;

	private TrenutniUser trenutniUser;

	private RegisteredUser user1;
	private RegisteredUser user2;

	private List<RegisteredUser> korisnici;
	private List<Putovanje> putovanja;

	@Before
	public void setup() {
		KieServices kieServices = KieServices.Factory.get();
        KieBaseConfiguration config = kieServices.newKieBaseConfiguration();
		config.setOption(EventProcessingOption.STREAM);
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
        kieBase = kieContainer.newKieBase(config);
		Destinacija more = new Destinacija();
		trenutniUser = new TrenutniUser(1998, Pol.MUSKO, TipLjubimca.MALI, RadniStatus.STUDENT, more);

		user1 = new RegisteredUser();
		user1.setTipLjubimca(TipLjubimca.MALI);
		user1.setRadniStatus(RadniStatus.STUDENT);
		String date2 = "2020-08-22";
		LocalDate localDate2 = LocalDate.parse(date2);
		user1.setVakcinacija(localDate2);

		user2 = new RegisteredUser();
		user2.setTipLjubimca(TipLjubimca.VELIKI);
		user2.setRadniStatus(RadniStatus.PENZIONER);
		String date = "2020-08-22";
		LocalDate localDate = LocalDate.parse(date);
		user2.setVakcinacija(localDate);

		korisnici = new ArrayList<RegisteredUser>();
		korisnici.add(user1);
		korisnici.add(user2);

		/*----------------------------------------------------------------------*/
		Smestaj s1 = new Smestaj();
		s1.setDestinacija(more);
		Smestaj s2 = new Smestaj();
		s1.setDestinacija(more);

		Putovanje p1 = new Putovanje(s1, user1, 5);
		Putovanje p2 = new Putovanje(s2, user1, 2);
		putovanja = new ArrayList<>();
		putovanja.add(p1);
		putovanja.add(p2);
	}

	@Test
	public void test_slicni_korisnici() {
		KieSession kieSession = kieBase.newKieSession();
		kieSession.getAgenda().getAgendaGroup("slican").setFocus();

		kieSession.insert(trenutniUser);
		for (RegisteredUser u : korisnici) {
			kieSession.insert(u);
		}

		kieSession.fireAllRules();

		assertEquals(1, trenutniUser.getSlicni().size());
	}

	@Test
	public void test_smestaj_po_oceni() {
		KieSession kieSession = kieBase.newKieSession();
		kieSession.getAgenda().getAgendaGroup("ocena").setFocus();

		kieSession.insert(trenutniUser);
		for (Putovanje p : putovanja) {
			kieSession.insert(p);

		}

		kieSession.fireAllRules();

		assertEquals(1, trenutniUser.getPreporuceniSmestaj().size());
	}
}
