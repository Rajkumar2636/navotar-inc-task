package com.navotar.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(monochrome=true,
features="resources/features",
glue="com.navotar.stepdef",
strict=true,
tags="@negativescenario") 
public class Runner1 {

}

