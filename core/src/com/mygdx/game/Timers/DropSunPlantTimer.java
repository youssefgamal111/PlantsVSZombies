/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Timers;

import com.mygdx.game.Plants.SunFlower;

/**
 *
 * @author USER
 */
public class DropSunPlantTimer  extends Timer{
SunFlower sunflower;
    public DropSunPlantTimer(SunFlower sunflower) {
        super(5f);
        this.sunflower=sunflower;
    }

    @Override
    public void task() {
        sunflower.Drop();
    }
    
}
