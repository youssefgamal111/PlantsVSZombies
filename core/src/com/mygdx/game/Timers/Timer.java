package com.mygdx.game.Timers;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Factories.TimerFactory;

public abstract class Timer {
    private final float time;
    private float elapsed = 0;
    private boolean Remove;
    private boolean Started;

    public Timer(float time) {
        this.time = time;
        Started = false;
        Remove = false;
        TimerFactory.Add(this);
    }

    public void Start() {
        Started = true;
    }

    public void Stop() {
        Started = false;
    }

    public void Remove() {
        Remove = true;
    }

    public boolean CanRemove() {
        return Remove;
    }

    public abstract void task();

    public void render() {
        if (!Started)
            return;
        elapsed += Gdx.graphics.getDeltaTime();
        if (elapsed >= time) {
            task();
            elapsed = 0f;
        }
    }

}
