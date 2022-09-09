package com.spa.tower;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.spa.tower.TowerCity.Tower;

class TowerCityTest {
    private TowerCity towerCity = new TowerCity();

    @Test
    void solveOneTowerTestWhenAlreadyAbsolute() throws CycleException {
        var tower = new TowerCity.Tower("WTC1", 22, false, null);

        tower = this.towerCity.solve(tower, new HashSet<>());

        assertEquals(22, tower.height);
    }

    @Test
    void solveOneTowerWhenLinear() throws CycleException {
        var c = new Tower("c", 26, false);
        var b = new Tower("b", 10, true, c);
        var a = new Tower("a", -8, true, b);
        this.towerCity.solve(a, new HashSet<>());

        assertEquals(28, a.height);
        assertEquals(36, b.height);
    }

}
