package com.example.SBNZApp.unit;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.example.SBNZApp.facts.Karakteristika;
import com.example.SBNZApp.facts.Karakteristike;
import com.example.SBNZApp.facts.RegisteredUser;

@RunWith(SpringRunner.class)
public class DestinacijaTest {

	private static KieContainer kieContainer;
	private static KieBase kieBase;

    private static final String agenda = "destinacije";

    private RegisteredUser user1;
    private RegisteredUser user2;
    private RegisteredUser user3;
    private RegisteredUser user4;
    private RegisteredUser user5;
    private static  Destinacija more;
    private static Destinacija banja;
    private static Destinacija dalekaDestinacija;
    private static Destinacija planina;
    private static Destinacija metropola;
    private static List<Destinacija> destinacije;  
    //private Karakteristika sunce;
    
    @Before
    public void setup() {
        KieServices kieServices = KieServices.Factory.get();
        KieBaseConfiguration config = kieServices.newKieBaseConfiguration();
		config.setOption(EventProcessingOption.STREAM);
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
        kieBase = kieContainer.newKieBase(config);
        
        Karakteristika sunce = new Karakteristika(Karakteristike.Sunce);
        Karakteristika voda = new Karakteristika(Karakteristike.Voda);
        Karakteristika odmorBezAktivnosti = new Karakteristika(Karakteristike.OdmorBezAktivnosti);
        Karakteristika odmorSaAktivnostima = new Karakteristika(Karakteristike.OdmorSaAktivnostima);
        Karakteristika urbano = new Karakteristika(Karakteristike.Urbano);
        Karakteristika mir = new Karakteristika(Karakteristike.Mir);
        Karakteristika hlad = new Karakteristika(Karakteristike.Hlad);
        Karakteristika dugPut = new Karakteristika(Karakteristike.DugPut);
        Karakteristika kratakPut = new Karakteristika(Karakteristike.KratakPut);
        Karakteristika svezVazduh = new Karakteristika(Karakteristike.SvezVazduh);
        Karakteristika individualniObilazak = new Karakteristika(Karakteristike.IndividualniObilazak);
        Karakteristika grupniObilazak = new Karakteristika(Karakteristike.GrupniObilazak);
        Karakteristika medicinskiNadzor = new Karakteristika(Karakteristike.MedicinskiNadzor);
        Karakteristika kulturniSadrzaj = new Karakteristika(Karakteristike.KulturniSadrzaj);
        
        //more
        user1 = new RegisteredUser();
        Set<Karakteristika> karakteristikeKor = new HashSet<>();
        karakteristikeKor.add(sunce);
        karakteristikeKor.add(odmorBezAktivnosti);
        karakteristikeKor.add(mir);
        karakteristikeKor.add(voda);
        karakteristikeKor.add(kratakPut);
        karakteristikeKor.add(individualniObilazak);
        user1.setUsername("kor1@se.cc");
        user1.setPassword("123456");
        String date = "2020-08-22";

  
        LocalDate localDate = LocalDate.parse(date);
        user1.setVakcinacija(localDate);
        user1.setPreferences(karakteristikeKor);
        
        //banja
        user2 = new RegisteredUser();
        Set<Karakteristika> karakteristikeKor2 = new HashSet<>();
        karakteristikeKor2.add(hlad);
        karakteristikeKor2.add(odmorBezAktivnosti);
        karakteristikeKor2.add(mir);
        karakteristikeKor2.add(svezVazduh);
        karakteristikeKor2.add(kratakPut);
        karakteristikeKor2.add(medicinskiNadzor);
        user2.setVakcinacija(localDate);
        user2.setPreferences(karakteristikeKor2);
        user2.setUsername("kor1@sec.cc");
        user2.setPassword("123456");
        
        //daleka destinacija
        user3 = new RegisteredUser();
        Set<Karakteristika> karakteristikeKor3 = new HashSet<>();
        karakteristikeKor3.add(sunce);
        karakteristikeKor3.add(odmorBezAktivnosti);
        karakteristikeKor3.add(mir);
        karakteristikeKor3.add(voda);
        karakteristikeKor3.add(dugPut);
        karakteristikeKor3.add(individualniObilazak);
        user3.setUsername("kor1@se.cc");
        user3.setPassword("123456");
        String date2 = "2021-03-22";

  
        LocalDate localDate2 = LocalDate.parse(date2);
        user3.setVakcinacija(localDate2);
        user3.setPreferences(karakteristikeKor3);
        
        
        //planina
        user4 = new RegisteredUser();
        Set<Karakteristika> karakteristikeKor4 = new HashSet<>();
        karakteristikeKor4.add(hlad);
        karakteristikeKor4.add(odmorSaAktivnostima);
        karakteristikeKor4.add(mir);
        karakteristikeKor4.add(svezVazduh);
        karakteristikeKor4.add(kratakPut);
        karakteristikeKor4.add(individualniObilazak);
        user4.setUsername("kor1@se.cc");
        user4.setPassword("123456");
  
        user4.setVakcinacija(localDate2);
        user4.setPreferences(karakteristikeKor4);
        
        //metropola
        user5 = new RegisteredUser();
        Set<Karakteristika> karakteristikeKor5 = new HashSet<>();
        karakteristikeKor5.add(odmorSaAktivnostima);
        karakteristikeKor5.add(urbano);
        karakteristikeKor5.add(kulturniSadrzaj);
        karakteristikeKor5.add(grupniObilazak);
        karakteristikeKor5.add(dugPut);
        user5.setUsername("kor1@se.cc");
        user5.setPassword("123456");
      
        user5.setVakcinacija(localDate2);
        user5.setPreferences(karakteristikeKor5);
        
        //more
        Set<Karakteristika> karakteristikeMore = new HashSet<>();
        karakteristikeMore.add(sunce);
        karakteristikeMore.add(voda);
        karakteristikeMore.add(odmorBezAktivnosti);
        karakteristikeMore.add(mir);
        more = new Destinacija();
        more.setPreferences(karakteristikeMore);
        
        //banja
        Set<Karakteristika> karakteristikeBanja = new HashSet<>();
        karakteristikeBanja.add(hlad);
        karakteristikeBanja.add(svezVazduh);
        karakteristikeBanja.add(odmorBezAktivnosti);
        karakteristikeBanja.add(mir);
        karakteristikeBanja.add(medicinskiNadzor);
        karakteristikeBanja.add(kratakPut);
        banja = new Destinacija();
        banja.setPreferences(karakteristikeBanja);
        
        //daleka destinacija
        Set<Karakteristika> karakteristikeDalekaDestinacija = new HashSet<>();
        karakteristikeDalekaDestinacija.add(sunce);
        karakteristikeDalekaDestinacija.add(voda);
        karakteristikeDalekaDestinacija.add(odmorBezAktivnosti);
        karakteristikeDalekaDestinacija.add(mir);
        karakteristikeDalekaDestinacija.add(dugPut);
        dalekaDestinacija = new Destinacija();
        dalekaDestinacija.setPreferences(karakteristikeDalekaDestinacija);
        
        //planina
        Set<Karakteristika> karakteristikePlanina = new HashSet<>();
        karakteristikePlanina.add(hlad);
        karakteristikePlanina.add(mir);
        karakteristikePlanina.add(odmorSaAktivnostima);
        karakteristikePlanina.add(svezVazduh);
        karakteristikePlanina.add(individualniObilazak);
        karakteristikePlanina.add(kratakPut);
        planina = new Destinacija();
        planina.setPreferences(karakteristikePlanina);
        
        
        //metropole
        Set<Karakteristika> karakteristikeMetropola = new HashSet<>();
        karakteristikeMetropola.add(urbano);
        karakteristikeMetropola.add(kulturniSadrzaj);
        karakteristikeMetropola.add(odmorSaAktivnostima);
        karakteristikeMetropola.add(grupniObilazak);
        karakteristikeMetropola.add(dugPut);
        metropola = new Destinacija();
        metropola.setPreferences(karakteristikeMetropola);
        
        destinacije = new ArrayList<>();
        destinacije.add(more);
        destinacije.add(banja);
        destinacije.add(dalekaDestinacija);
        destinacije.add(planina);
        destinacije.add(metropola);
        
 
    }
    
    
   
    @Test
    public void test_destinacija_more() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();


        kieSession.insert(user1);
        for(Destinacija d :destinacije) {
        	  kieSession.insert(d);
        }
      
        kieSession.fireAllRules();

        assertEquals(more, user1.getTrenutnaDestinacija());
    }
    @Test
    public void test_destinacija_banja() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();


        kieSession.insert(user2);
        for(Destinacija d :destinacije) {
        	  kieSession.insert(d);
        }
      
        kieSession.fireAllRules();

        assertEquals(banja, user2.getTrenutnaDestinacija());
    }
    
    @Test
    public void test_destinacija_daleka_destinacija() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();


        kieSession.insert(user3);
        for(Destinacija d :destinacije) {
        	  kieSession.insert(d);
        }
      
        kieSession.fireAllRules();

        assertEquals(dalekaDestinacija, user3.getTrenutnaDestinacija());
    }
    
    @Test
    public void test_destinacija_planina() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();


        kieSession.insert(user4);
        for(Destinacija d :destinacije) {
        	  kieSession.insert(d);
        }
      
        kieSession.fireAllRules();

        assertEquals(planina, user4.getTrenutnaDestinacija());
    }
    
    @Test
    public void test_destinacija_metropola() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();


        kieSession.insert(user5);
        for(Destinacija d :destinacije) {
        	  kieSession.insert(d);
        }
      
        kieSession.fireAllRules();

        assertEquals(metropola, user5.getTrenutnaDestinacija());
    }
}
