package com.mygdx.game.Object.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Object.DataCollide.StructureData;
import com.mygdx.game.Object.DataCollide.UserData;
import com.mygdx.game.utils.Constants;
import com.mygdx.game.utils.GameActor;

/**
 * Created by Boufle on 07/11/2016.
 */
public class StructureActor extends GameActor {

    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;

    public StructureActor(Body body) {
        super(body);
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.STRUCTURE_IMAGE_PATH)));
    }

    @Override
    public StructureData getUserData() {
        return (StructureData) userData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, screenRectangle.x, screenRectangle.y, screenRectangle.getWidth(),
                screenRectangle.getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
}
