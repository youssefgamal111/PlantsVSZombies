package com.mygdx.game;

public interface IMoveable {
    void OnMoveStart();

    void OnMoveFinished();

    void Move(float x, float y);

    boolean IsMoving();
}
