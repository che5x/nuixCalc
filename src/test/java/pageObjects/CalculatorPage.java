package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage{

	WebDriver driver;
	public CalculatorPage(WebDriver driver) {
		super(driver);
	}

	//xpaths
	@FindBy(xpath="//div[@id='display']/div")
	 WebElement Result;
	@FindBy(xpath="//input[@value='0']")
	 WebElement Number0;
	@FindBy(xpath="//input[@value='1']")
	 WebElement Number1;
	@FindBy(xpath="//input[@value='2']")
	 WebElement Number2;
	@FindBy(xpath="//input[@value='3']")
	 WebElement Number3;
	@FindBy(xpath="//input[@value='4']")
	 WebElement Number4;
	@FindBy(xpath="//input[@value='5']")
	 WebElement Number5;
	@FindBy(xpath="//input[@value='6']")
	 WebElement Number6;
	@FindBy(xpath="//input[@value='7']")
	 WebElement Number7;
	@FindBy(xpath="//input[@value='8']")
	 WebElement Number8;
	@FindBy(xpath="//input[@value='9']")
	 WebElement Number9;

	@FindBy(xpath="//input[@value='.']")
	 WebElement dot;
	@FindBy(xpath="//input[@id='add']")
	 WebElement add;
	@FindBy(xpath="//input[@id='subtract']")
	 WebElement subtract;
	@FindBy(xpath="//input[@id='multiply']")
	 WebElement multiply;
	@FindBy(xpath="//input[@id='divide']")
	 WebElement divide;
	@FindBy(xpath="//input[@value='=']")
	 WebElement equals;
	@FindBy(xpath="//input[@value='C']")
	 WebElement C;
	
	
	//Methods/Actions:
	public void clickAdd() {
		add.click(); 
	}

	public void clickSubtract() {
		subtract.click();
	}

	public void clickMultiply() {
		multiply.click();
	}

	public void clickDivide() {
		divide.click();
	}

	public void clickEquals() {
		equals.click();
	}

	public void clickClear() {
		C.click();
	}

	
	public void clickNumber0() {
		Number0.click();
	}
	public void clickNumber1() {
		Number1.click();
	}
	public void clickNumber2() {
		Number2.click();
	}
	public void clickNumber3() {
		Number3.click();
	}
	public void clickNumber4() {
		Number4.click();
	}
	public void clickNumber5() {
		Number5.click();
	}
	public void clickNumber6() {
		Number6.click();
	}
	public void clickNumber7() {
		Number7.click();
	}
	public void clickNumber8() {
		Number8.click();
	}
	public void clickNumber9() {
		Number9.click();
	}
	


    public double GetDoubleResult()
    {
    	equals.click();
        String result = Result.getText().trim();
        return Double.parseDouble(result);
    }
	public String getResult() {
		System.out.println("Result.getText():  "+Result.getText());
		equals.click();
		return Result.getText(); 
	}
	
    public void ClickWholeEquation(String equation)
    {
        //todo: filter only acceptable chars
        for (char character : equation.trim().toCharArray())
            ClickElement(character);
    }
	
	 private void ClickElement(char character)
	    {
	        // Without explicit char parsing, it should be faster.
	        switch ((int)character)
	        {

	            case 42:
	                multiply.click();
	                break;

	            case 43:
	                add.click();
	                break;

	            case 45:
	                subtract.click();
	                break;

	            case 46: // .
	                dot.click();
	                break;

	            case 47:
	                divide.click();
	                break;

	            case 48:
	                Number0.click();
	                break;

	            case 49:
	                Number1.click();
	                break;

	            case 50:
	                Number2.click();
	                break;

	            case 51:
	                Number3.click();
	                break;

	            case 52:
	                Number4.click();
	                break;

	            case 53:
	                Number5.click();
	                break;

	            case 54:
	                Number6.click();
	                break;

	            case 55:
	                Number7.click();
	                break;

	            case 56:
	                Number8.click();
	                break;

	            case 57:
	                Number9.click();
	                break;

	            case 61:
	                equals.click();
	                break;
	        }
	    }


}
