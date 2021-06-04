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
import org.kie.api.KieServices;
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

    private static final String agenda = "destinacije";

    private RegisteredUser user1;
    private static  Destinacija more;
    private static Destinacija banja;
    private static List<Destinacija> destinacije;  
    //private Karakteristika sunce;
    
    @Before
    public void setup() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
        
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
        
        Set<Karakteristika> karakteristikeMore = new HashSet<>();
        karakteristikeMore.add(sunce);
        karakteristikeMore.add(voda);
        karakteristikeMore.add(odmorBezAktivnosti);
        karakteristikeMore.add(mir);
        more = new Destinacija();
        more.setPreferences(karakteristikeMore);
        
        
        Set<Karakteristika> karakteristikeBanja = new HashSet<>();
        karakteristikeMore.add(hlad);
        karakteristikeMore.add(svezVazduh);
        karakteristikeMore.add(odmorBezAktivnosti);
        karakteristikeMore.add(mir);
        karakteristikeMore.add(medicinskiNadzor);
        karakteristikeMore.add(kratakPut);
        banja = new Destinacija();
        banja.setPreferences(karakteristikeBanja);
        
        destinacije = new ArrayList<>();
        destinacije.add(more);
        destinacije.add(banja);
    }
    
    
   
    @Test
    public void test_destinacija() {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();


        kieSession.insert(user1);
        for(Destinacija d :destinacije) {
        	  kieSession.insert(d);
        }
      
        kieSession.fireAllRules();

        assertEquals(more, user1.getTrenutnaDestinacija());
    }
}
