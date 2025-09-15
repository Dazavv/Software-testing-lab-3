package org.example.base;

import org.openqa.selenium.*;

public abstract class BaseComponent extends BaseUiElement{
    public BaseComponent(WebDriver driver) {
        super(driver);
    }
}
