package Utility;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Waiter {
    public static final FluentWait wait=new FluentWait(Chrome.getDriver());
    static
    {
        wait.withTimeout(Duration.ofMillis(30000));
        wait.ignoring(NoSuchElementException.class);
    }
}