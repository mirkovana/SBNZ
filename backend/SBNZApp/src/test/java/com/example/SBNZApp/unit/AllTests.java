package com.example.SBNZApp.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.example.SBNZApp.facts.Smestaj;

@RunWith(Suite.class)
@SuiteClasses({
	 DestinacijaTest.class,
	 IzvestajTest.class,
	 SmestajTest.class,
	 ForwardTest.class,
	 CepTests.class
})

public class AllTests {

}
