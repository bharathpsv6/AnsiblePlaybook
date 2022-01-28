package com.subnext.java8;

import com.subnext.java8.Utils.PassingCode;
import com.subnext.java8.entity.Apple;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PassingCodeTest{

    private List<Apple> inventory;

    @Before
    public void setup(){
        this.inventory = new ArrayList<>();
        this.inventory.add(new Apple("Red", 100));
        this.inventory.add(new Apple("Green", 160));
        this.inventory.add(new Apple("Red", 160));
        this.inventory.add(new Apple("Green", 100));
        this.inventory.add(new Apple("Green", 160));
    }

    @Test
    public void testFilter(){
        List<Apple> greenApples = PassingCode.filterApples(this.inventory, PassingCode::isGreenApple);
        Assert.assertEquals(3, greenApples.size());
    }

    @Test
    public void testLambda(){
        List<Apple> greenApples =  PassingCode.filterApples(this.inventory, (Apple a) -> "Green".equals(a.getColor()));
        Assert.assertEquals(3, greenApples.size());
        List<Apple> redApples = PassingCode.filterApples(this.inventory, (Apple a) -> "Red".equals(a.getColor()));
        Assert.assertEquals(2, redApples.size());
    }

    @Test
    public void testStream(){
        List<Apple> greenApples = this.inventory.stream()
                .filter((Apple a) -> "Green".equals(a.getColor()))
                .sorted(Comparator.comparing(Apple::getWeight))
                .collect(Collectors.toList());
        Assert.assertEquals(3, greenApples.size());
        Assert.assertTrue(greenApples.get(0).getWeight() < greenApples.get(2).getWeight());
    }
}
