package com.mygdx.game.Object.DataCollide;

import com.mygdx.game.utils.UserDataType;

/**
 * Created by Boufle on 07/11/2016.
 */
public class GroundData extends UserData {

    public GroundData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.GROUND;
    }

}
