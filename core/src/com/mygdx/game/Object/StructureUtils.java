package com.mygdx.game.Object;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Object.DataCollide.RunnerData;
import com.mygdx.game.Object.DataCollide.StructureData;
import com.mygdx.game.utils.Constants;

/**
 * Created by Boufle on 07/11/2016.
 */
public class StructureUtils  {

    public static Body createEnemy(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(Constants.STRUCTURE_X, Constants.STRUCTURE_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.STRUCTURE_WIDTH / 2, Constants.STRUCTURE_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, Constants.STRUCTURE_DENSITY);
        body.resetMassData();
        body.setUserData(new StructureData(Constants.RUNNER_WIDTH, Constants.RUNNER_HEIGHT));
        shape.dispose();
        return body;
    }
}
