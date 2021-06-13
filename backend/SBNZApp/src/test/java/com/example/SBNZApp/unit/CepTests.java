package com.example.SBNZApp.unit;

import java.util.concurrent.TimeUnit;

import org.drools.core.ClockType;
import org.junit.Before;
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
import com.example.SBNZApp.facts.SmestajAlarm;

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

@RunWith(SpringRunner.class)
public class CepTests {
	private static KieContainer kieContainer;
	private static KieBase kieBase;

	private static final String agenda = "cep";

	@Before
	public void setup() {
		KieServices kieServices = KieServices.Factory.get();
		KieBaseConfiguration config = kieServices.newKieBaseConfiguration();
		config.setOption(EventProcessingOption.STREAM);
		kieContainer = kieServices
				.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
		kieBase = kieContainer.newKieBase(config);
	}

	@Test
	public void testCEPRules() {
		KieSession kieSession = kieBase.newKieSession();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();

		SmestajAlarm smestajAlarm = new SmestajAlarm();
		kieSession.setGlobal("smestajAlarm", smestajAlarm);
		RegisteredUser user = new RegisteredUser();
		user.setID(1L);
		kieSession.insert(new PutovanjeEvent(user));
		kieSession.insert(new PutovanjeEvent(user));
		kieSession.insert(new PutovanjeEvent(user));
		kieSession.insert(new PutovanjeEvent(user));
		kieSession.insert(new PutovanjeEvent(user));
		kieSession.insert(new PutovanjeEvent(user));
		int ruleCount = kieSession.fireAllRules();
		assertThat(ruleCount, equalTo(2));

		System.out.flush();

	}
	
	@Test
	public void testCEPRulesNeispunjeno() {
		KieSession kieSession = kieBase.newKieSession();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();

		SmestajAlarm smestajAlarm = new SmestajAlarm();
		kieSession.setGlobal("smestajAlarm", smestajAlarm);
		RegisteredUser user = new RegisteredUser();
		user.setID(1L);
		kieSession.insert(new PutovanjeEvent(user));
		kieSession.insert(new PutovanjeEvent(user));
		kieSession.insert(new PutovanjeEvent(user));
		int ruleCount = kieSession.fireAllRules();
		assertThat(ruleCount, equalTo(0));

		System.out.flush();

	}

}