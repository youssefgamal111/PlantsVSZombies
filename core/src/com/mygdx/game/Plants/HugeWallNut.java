package com.mygdx.game.Plants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.IAttacker;

public class HugeWallNut extends Plant  {
Animation<TextureRegion> Crack1,Crack2;
    public HugeWallNut(float x, float y) {
        super(x, y, 30);
    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\WallNut.gif").read());
        Crack1 = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Wallnut_cracked1.gif").read());
        Crack2 = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Wallnut_cracked2.gif").read());
        SetCurrentAnimation(Default);
    }

    @Override
    public void ReceiveShot(IAttacker z) {
        if (this.isCanRemove())
            return;
        Health -= z.getPower();
        if(Health>10&&Health<=20)
            SetCurrentAnimation(Crack1);
        else if(Health>1&&Health<=10)
            SetCurrentAnimation(Crack2);
        if (Health <= 0) {
            this.Remove();
            z.StopAttack();
        }
    }
}
