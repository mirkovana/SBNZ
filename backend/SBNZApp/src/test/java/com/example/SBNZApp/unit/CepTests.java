package com.example.SBNZApp.unit;

import java.util.concurrent.TimeUnit;

import org.drools.core.ClockType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import com.example.SBNZApp.facts.PutovanjeEvent;
import com.example.SBNZApp.facts.RegisteredUser;
import org.kie.internal.io.ResourceFactory;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.drools.core.time.SessionPseudoClock;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


//@RunWith(SpringRunner.class)
public class CepTests {
	@Autowired
    private KieContainer kieContainer;
	
	@Test
	public void testCEPRules() {
//		KieServices ks = KieServices.Factory.get();
//		KieContainer kc = ks.newKieClasspathContainer();
//		KieSession ksession = kc.newKieSession();
		
//		KieServices ks = KieServices.Factory.get();
//        KieFileSystem kfs = ks.newKieFileSystem();
//       // kfs.write(ResourceFactory.newClassPathResource("integracija/cep-rules.drl"));
//        KieBuilder kbuilder = ks.newKieBuilder(kfs);
//        kbuilder.buildAll();
//        if (kbuilder.getResults().hasMessages(Message.Level.ERROR)) {
//            throw new IllegalArgumentException("Coudln't build knowledge module" + kbuilder.getResults());
//        }
//        KieContainer kContainer = ks.newKieContainer(kbuilder.getKieModule().getReleaseId());
//        KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
//        kbconf.setOption(EventProcessingOption.STREAM);
//        KieBase kbase = kContainer.newKieBase(kbconf);
//		KieSessionConfiguration ksconf2 = ks.newKieSessionConfiguration();
//        ksconf2.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
//        KieSession ksession = kbase.newKieSession(ksconf2, null);
		
		//ksession.fireAllRules();
		 
	    
	    KieSession kieSession = kieContainer.newKieSession();
		SessionPseudoClock clock = kieSession.getSessionClock();
        //runPseudoClockExample(ksession);
		RegisteredUser user = new RegisteredUser();	
		user.setID(1L);
		for (int i = 0; i < 12; i++) {
			PutovanjeEvent event = new PutovanjeEvent(user);
			kieSession.getAgenda().getAgendaGroup("cep").setFocus();
			kieSession.insert(event);
			int ruleCount = kieSession.fireAllRules();
			clock.advanceTime(500, TimeUnit.MILLISECONDS);
			 assertThat(ruleCount, equalTo(1));
		}
		
		System.out.flush();
		
		 
		
	}
	
	private void runPseudoClockExample(KieSession ksession) {
        SessionPseudoClock clock = ksession.getSessionClock();
        RegisteredUser user = new RegisteredUser();	
		user.setID(1L);
		PutovanjeEvent event1 = new PutovanjeEvent(user);
    	ksession.insert(event1);
        for (int index = 0; index < 11; index++) {
        	PutovanjeEvent event = new PutovanjeEvent(user);
        	ksession.insert(event);
            
            clock.advanceTime(1, TimeUnit.SECONDS);
            ksession.getAgenda().getAgendaGroup("cep").setFocus();
            int ruleCount = ksession.fireAllRules();
           
            assertThat(ruleCount, equalTo(1));
        }
        //We manually advance time 1 minute, without a heart beat
//        clock.advanceTime(1, TimeUnit.MINUTES);
//        int ruleCount = ksession.fireAllRules();
//        assertThat(ruleCount, equalTo(1));
//        Collection<?> newEvents = ksession.getObjects(new ClassObjectFilter(HeartAttackEvent.class));
//        assertThat(newEvents.size(), equalTo(1));
    }
}
