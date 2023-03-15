# BDD Cucumber
![image](https://user-images.githubusercontent.com/69948118/225212470-bf0e571b-0e02-4c01-8fed-443b81f2495d.png)
![image](https://user-images.githubusercontent.com/69948118/225212522-e606532e-cee2-455b-900c-59c5e0b75651.png)
![image](https://user-images.githubusercontent.com/69948118/225212606-db082cae-bed8-4123-8a2c-e7ee218298da.png)
![image](https://user-images.githubusercontent.com/69948118/225212630-d8b8bee3-70f3-4fc1-a48b-eefd7351b32e.png)
- Add cucumber plugin in eclipse or intellij
![image](https://user-images.githubusercontent.com/69948118/225212902-709fd837-d617-414f-94fb-1dc5cef91b58.png)
- Add below dependencies
![image](https://user-images.githubusercontent.com/69948118/225213135-9111c003-c834-4e0a-9067-c3d5904cac05.png)
![image](https://user-images.githubusercontent.com/69948118/225213171-aa11e59e-131e-4d9f-93a7-c7c9b237de01.png)
- offer.feature
```feature
Feature: Evaluate percentage

  Scenario: Verify 10% offer
    Given Execute DiscountService Business
    When if i will enter 5001
    Then we should get ten percentage discount

  Scenario: Verify 15% offer
    Given Execute DiscountService Business
    When if i will enter 11000
    Then we should get fifteen percentage discount

     Scenario: Verify No offer
    Given Execute DiscountService Business
    When if i will enter 4000
    Then we shouldn't get any percentage
```
- DiscountService
```java
package com.javatechie.bdd_example;

/**
 * Hello world!
 *
 */
public class DiscountService {
	
	
	public String getDiscount(int amount) {
		String discountPercentage = "";
		if (amount > 5000 && amount < 10000) {
			discountPercentage = "10%";
		} else if (amount > 10000) {
			discountPercentage = "15%";
		}else {
			discountPercentage="NA";
		}
		return discountPercentage;
	}
}
```
- DiscountServiceTest.java

```java
package com.javatechie.bdd_example;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Unit test for simple App.
 */
public class DiscountServiceTest {

	DiscountService service = null;
	String percentage = "";

	@Given("^Execute DiscountService Business$")
	public void execute_DiscountService_Business() throws Throwable {
		service = new DiscountService();
	}

	@When("^if i will enter (\\d+)$")
	public void if_i_will_enter(int arg1) throws Throwable {
		percentage = service.getDiscount(arg1);
	}

	@Then("^we should get ten percentage discount$")
	public void we_should_get_ten_percentage_discount() throws Throwable {
		Assert.assertEquals("10%", percentage);
	}

	@Then("^we should get fifteen percentage discount$")
	public void we_should_get_fifteen_percentage_discount() throws Throwable {
		Assert.assertEquals("15%", percentage);
	}
	@Then("^we shouldn't get any percentage$")
	public void we_shouldn_t_get_any_percentage()  {
		Assert.assertEquals("NA", percentage);
	}
}
```

- TestRunner.java
```java
package com.javatechie.bdd_example;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="offer.feature")
public class TestRunner {

}
```
