package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_01_add extends BaseClass {

	@Test
	public void verifyAddition() {
		try {
			logger.info("*****Verifying addition started.*****");
			calcObj.clickNumber1();
			calcObj.clickAdd();
			calcObj.clickNumber6();
			calcObj.clickEquals();
			calcObj.getResult();

			Assert.assertEquals(Integer.parseInt(String.valueOf(calcObj.getResult())), (6 + 1));
			throw new ArithmeticException("test exception");
		} catch (Exception e) {
			logger.error("TEST FAILED, due to: " + e.getMessage());
			Assert.fail();
		}
		logger.info("*****Verifying addition completed.*****");
	}

	@Test
	public void verifySubtraction() {
		calcObj.clickNumber1();
		calcObj.clickSubtract();
		calcObj.clickNumber6();
		calcObj.clickEquals();
		calcObj.getResult();
		Assert.assertEquals(Integer.parseInt(String.valueOf(calcObj.getResult())), (1 - 6));

	}

	@Test
	public void AddZeroAndOne() {
		calcObj.ClickWholeEquation("056+44");
		Assert.assertEquals(calcObj.GetDoubleResult(), 100);
	}

	@Test(description = "Addition test of float and int")
	public void AddDecimalTwoPointTwoMinusOne() {
		calcObj.ClickWholeEquation("2.2+1");
		Assert.assertEquals(calcObj.GetDoubleResult(), 3.2);
	}

}
