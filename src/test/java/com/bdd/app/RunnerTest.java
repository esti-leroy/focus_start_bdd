package com.bdd.app;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        tags = {"@sample", "~@ignore"},
        snippets = SnippetType.CAMELCASE
)
public class RunnerTest {
}
