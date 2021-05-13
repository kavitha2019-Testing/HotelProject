package Com.UtilitiesPackage;

import Com.BasePackage.OpenBrowser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

public class dimensions  extends OpenBrowser {

    public dimensions() throws IOException {

    }
    public static void Diemen(WebElement dimele){
     //selenium 3 concepts.
        Dimension  D = dimele.getSize();
        System.out.println(D.getHeight());
        System.out.println(D.getWidth());
        Point p =dimele.getLocation();
        System.out.println(p.getX());
        System.out.println(p.getY());
        // selenium 4 concepts.

        Rectangle R = dimele.getRect();
        System.out.println(R.getHeight());
        System.out.println(R.getWidth());
        System.out.println(R.getX());
        System.out.println(R.getY());
    }
}
