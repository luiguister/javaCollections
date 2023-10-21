package org.curso;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Collection<Car> cars;
    Car kia, byd, honda;

    @BeforeEach
    void setUp(TestInfo info) {
        System.out.format("%nPerforming %s%n", info.getTestMethod().get().getName());

        this.cars = new ArrayList<>();
        this.kia = new Car("kia", "model1", 52000);
        this.byd = new Car("byd", "model2", 42000);
        this.honda = new Car("honda", "model3", 32000);

        this.cars.addAll(Arrays.asList(kia, this.byd, this.honda));

    }

    @AfterEach
    void tearDown() {
        System.out.format("%nResult%n");

        this.cars.stream()
                .map(c -> String.format("%s %s", c.getMake(), c.getModel()))
                .forEach(System.out::println);
    }
    @Test
    public void removeTest(){
        this.cars.remove(honda);
        this.cars.remove(new Car("byd", "model2", 42000));

        assertEquals(1, this.cars.size());
    }

    @Test
    public void containTest(){
        assertTrue(this.cars.contains(new Car("honda", "model3", 32000)));
        assertTrue(this.cars.contains(byd));
        assertTrue(this.cars.contains(kia));
    }

    @Test
    public void removeAllIdentityTest(){
        this.cars.removeAll(Arrays.asList(this.kia, this.byd, new Car("Honda", "civic", 10000)));
    }
}