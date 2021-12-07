package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPageObject extends BasePage {
    private WebDriver driver;

    public InventoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInSortDropdown(String itemText) {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectDropdownByText(driver, InventoryPageUI.SORT_DROPDOWN, itemText);
    }

    public boolean isProductNameSortAscending() {
        List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
        List<String> productNameText = productNameElements.stream().map(n -> n.getText()).collect(Collectors.toList());

        System.out.println("\nAfter sort ascending : ---------------------------------");
        productNameText.stream().forEach(System.out::println);

        List<String> productNameTextClone = new ArrayList<String>(productNameText);
        Collections.sort(productNameTextClone);

        System.out.println("\nExpect after sort ascending : ---------------------------------");
        productNameTextClone.stream().forEach(System.out::println);

        return (productNameText.equals(productNameTextClone));
    }

    public boolean isProductNameSortDescending() {
        List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
        List<String> productNameText = productNameElements.stream().map(n -> n.getText()).collect(Collectors.toList());

        System.out.println("\nAfter sort descending : ---------------------------------");
        productNameText.stream().forEach(System.out::println);

        List<String> productNameTextClone = new ArrayList<String>(productNameText);
        Collections.sort(productNameTextClone);
        Collections.reverse(productNameTextClone);

        System.out.println("\nExpect after sort descending : ---------------------------------");
        productNameTextClone.stream().forEach(System.out::println);
        System.out.println(productNameText.equals(productNameTextClone));
        return (productNameText.equals(productNameTextClone));
    }

    public boolean isProductPriceSortAscending() {
        List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
        List<Float> productPrice = productPriceElements.stream().map(n -> Float.parseFloat(n.getText().replace("$", "").trim())).collect(Collectors.toList());

        System.out.println("\nAfter sort ascending : ---------------------------------");
        productPrice.stream().forEach(System.out::println);

        List<Float> productPriceClone = new ArrayList<Float>(productPrice);
        Collections.sort(productPriceClone);

        System.out.println("\nExpect after sort ascending : ---------------------------------");
        productPriceClone.stream().forEach(System.out::println);

        return (productPrice.equals(productPriceClone));
    }

    public boolean isProductPriceSortDescending() {
        List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
        List<Float> productPrice = productPriceElements.stream().map(n -> Float.parseFloat(n.getText().replace("$", "").trim())).collect(Collectors.toList());

        System.out.println("\nAfter sort descending : ---------------------------------");
        productPrice.stream().forEach(System.out::println);

        List<Float> productPriceClone = new ArrayList<Float>(productPrice);
        Collections.sort(productPriceClone);
        Collections.reverse(productPriceClone);

        System.out.println("\nExpect after sort descending : ---------------------------------");
        productPriceClone.stream().forEach(System.out::println);

        return (productPrice.equals(productPriceClone));
    }
}
