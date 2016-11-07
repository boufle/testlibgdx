package com.mygdx.game.Object.DataCollide;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.utils.Constants;
import com.mygdx.game.utils.UserDataType;

/**
 * Created by Boufle on 07/11/2016.
 */
public class RunnerData extends UserData {

    private Vector2 jumpingLinearImpulse;

    public RunnerData(float width, float height) {
        super(width, height);
        jumpingLinearImpulse = Constants.RUNNER_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.RUNNER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

}
