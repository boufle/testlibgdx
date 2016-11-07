package com.mygdx.game.Object.DataCollide;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.utils.Constants;
import com.mygdx.game.utils.UserDataType;

/**
 * Created by Boufle on 07/11/2016.
 */
public class StructureData extends UserData {

    private Vector2 linearVelocity;

    public StructureData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.STRUCTURE;
        linearVelocity = Constants.STRUCTURE_LINEAR_VELOCITY;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }
}
