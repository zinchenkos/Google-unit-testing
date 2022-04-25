package Utility;

import Elements.element;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import java.lang.reflect.*;
import java.util.List;

public class Decorator extends DefaultFieldDecorator {             //for LAZY initialization of custom fields via annotations
    public Decorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field){
        Class<element> decoratableClass = decoratableClass(field);
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null)
                return null;
            if (List.class.isAssignableFrom(field.getType()))
                return createList(loader, locator, decoratableClass);
            try {
                return createElement(loader, locator, decoratableClass);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return super.decorate(loader, field);
    }
    private Class<element> decoratableClass(Field field) {
        Class<?> clazz = field.getType();
        if (List.class.isAssignableFrom(clazz)) {
            if (field.getAnnotation(FindBy.class) == null && field.getAnnotation(FindBys.class) == null)
                return null;
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType))
                return null;
            clazz = (Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
        }
        if (element.class.isAssignableFrom(clazz))
            return (Class<element>) clazz;
        else
            return null;
    }
    protected element createElement(ClassLoader loader, ElementLocator locator, Class<element> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        WebElement proxy = proxyForLocator(loader, locator);
        return clazz.getConstructor(WebElement.class).newInstance(proxy);
    }
    protected List<element> createList(ClassLoader loader, ElementLocator locator, Class<element> clazz) {
        InvocationHandler handler = new LocatingCustomElementListHandler(locator, clazz);
        List<element> elements = (List<element>) Proxy.newProxyInstance(loader, new Class[] {List.class}, handler);
        return elements;
    }
}