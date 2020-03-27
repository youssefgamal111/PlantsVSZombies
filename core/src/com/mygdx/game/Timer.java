package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public  abstract class Timer {
protected float time;
private float timer=0;
public Timer(float time)
{
    this.time=time;
}
public abstract  void task();
public void render()
{
    timer+= Gdx.graphics.getDeltaTime();
    if(timer>=time)
    {
        task();
        timer=0f;
    }
}
}
