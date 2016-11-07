package com.mygdx.game.Object.DataCollide;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.utils.UserDataType;

/**
 * Created by Boufle on 07/11/2016.
 */
public abstract class UserData {

    protected UserDataType userDataType;
    protected float width;
    protected float height;

    public UserData(float width, float height) {
        this.width = width;
        this.height = height;

    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
