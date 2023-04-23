package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {

    WebDriver driver;
    public GenericMethods(WebDriver driver){
        this.driver= driver;

    }

    public WebElement getElement(String locator, String type){

        type=type.toLowerCase();

        if(type.equals("id")){
            System.out.println("element found by id "+ locator);
            return this.driver.findElement(By.id(locator));
        }
        else if (type.equals("xpath")){
            System.out.println("element found by xpath" + locator);
            return this.driver.findElement(By.xpath(locator));}
        else{
            System.out.println("invalid locator type"+ type);
            return null;
        }
    }
    public List<WebElement> getElementList(String locator, String type){

        type=type.toLowerCase();

        List<WebElement> elementList=new ArrayList<WebElement>();
        if(type.equals("id")){
            elementList=this.driver.findElements(By.id(locator));
        }
        else if (type.equals("name")){
            elementList=this.driver.findElements(By.name(locator));}
        else if (type.equals("xpath")){
            elementList=this.driver.findElements(By.xpath(locator));}
        else if (type.equals("css")){
            elementList=this.driver.findElements(By.cssSelector(locator));}
        else if (type.equals("classname")){
            elementList=this.driver.findElements(By.className(locator));}
        else if (type.equals("linktext")){
            elementList=this.driver.findElements(By.linkText(locator));}
        else if (type.equals("partiallinktext")){
            elementList=this.driver.findElements(By.partialLinkText(locator));}
        else{
            System.out.println("Locator type not supported");
        }
        if(elementList.isEmpty()){
            System.out.println("element not found with :"+ locator +","+ type);
        }
        else{
            System.out.println("element found with :"+ locator +","+ type);

        }
        return elementList;

    }
    public boolean isElementPresent(String locator, String type){

        List<WebElement>elementList=getElementList(locator,type);

        int size= elementList.size();

        if(size>0){
            return true;
        }
        else{
            return false;
        }


    }
}

