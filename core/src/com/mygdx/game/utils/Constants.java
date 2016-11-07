package com.mygdx.game.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Boufle on 07/11/2016.
 */
public class Constants {
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;

    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 28f;
    public static final float GROUND_HEIGHT = 6f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static float RUNNER_DENSITY = 0.5f;

    public static final float STRUCTURE_X = 25f;
    public static final float STRUCTURE_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float STRUCTURE_WIDTH = 6f;
    public static final float STRUCTURE_HEIGHT = 28f;
    public static float STRUCTURE_DENSITY = 0f;
    public static final Vector2 STRUCTURE_LINEAR_VELOCITY = new Vector2(-10f, 0);

    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);

    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String GROUND_IMAGE_PATH = "sol.png";
    public static final String STRUCTURE_IMAGE_PATH = "structure.png";

    public static final String CHARACTERS_ATLAS_PATH = "characters.txt";
    public static final String[] RUNNER_RUNNING_REGION_NAMES = new String[] {"alienGreen_run1", "alienGreen_run2"};
    public static final String RUNNER_DODGING_REGION_NAME = "alienGreen_dodge";
    public static final String RUNNER_HIT_REGION_NAME = "alienGreen_hit";
    public static final String RUNNER_JUMPING_REGION_NAME = "alienGreen_jump";


    public static final float WORLD_TO_SCREEN = 32;

}
