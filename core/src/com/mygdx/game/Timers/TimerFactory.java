package com.mygdx.game.Timers;

import java.util.ArrayList;
import java.util.Iterator;

public class TimerFactory {
    private static ArrayList<Timer> Timers;
    private static ArrayList<Timer> TimersToAdd;

    public static void initialize() {
        Timers = new ArrayList<>();
        TimersToAdd = new ArrayList<>();
    }

    public static void Add(Timer t) {
        TimersToAdd.add(t);
    }

    public static void Render() {
        for (Iterator<Timer> iterator = Timers.iterator(); iterator.hasNext(); ) {
            Timer timer = iterator.next();
            if (timer.CanRemove()) {
                iterator.remove();
                continue;
            }
            timer.render();
        }
        Timers.addAll(TimersToAdd);
        TimersToAdd.clear();
    }

}
