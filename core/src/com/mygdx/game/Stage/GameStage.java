package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mygdx.game.Object.Actors.BackgroundActor;
import com.mygdx.game.Object.Actors.GroundActors;
import com.mygdx.game.Object.Actors.RunnerActors;
import com.mygdx.game.Object.Actors.StructureActor;
import com.mygdx.game.Object.RunnerUtils;
import com.mygdx.game.Object.StructureUtils;
import com.mygdx.game.Object.WorldUtils;
import com.mygdx.game.utils.BodyUtils;
import com.mygdx.game.utils.Constants;

/**
 * Created by Boufle on 07/11/2016.
 */
public class GameStage extends Stage implements ContactListener{

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private World world;
    private GroundActors ground;
    private RunnerActors runner;
    private BackgroundActor background;
    private StructureActor structure;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    private Rectangle screenRightSide;

    private Vector3 touchPoint;

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        setUpWorld();
        setupCamera();
        setupTouchControlAreas();
        renderer = new Box2DDebugRenderer();
    }

    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    private void setUpWorld() {
        world = WorldUtils.creatWorld();
        world.setContactListener(this);
        setUpBackground();
        setUpGround();
        setUpRunner();
        setUpStructure();

    }

    private void setUpGround() {
        ground = new GroundActors(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void setUpStructure() {
        structure = new StructureActor(StructureUtils.createEnemy(world));
        addActor(structure);
    }


    private void setUpRunner() {
        runner = new RunnerActors(RunnerUtils.createRunner(world));
        addActor(runner);
    }

    private void setupTouchControlAreas() {
        touchPoint = new Vector3();
        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2,
                getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }

    private void setUpBackground() {
        background = new BackgroundActor();
        addActor(background);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Fixed timestep
        accumulator += delta;

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);


        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        //TODO: Implement interpolation

    }


    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {

        translateScreenToWorldCoordinates(x, y);
        if (rightSideTouched(touchPoint.x, touchPoint.y)) {
            runner.jump();
           /* background.stopBackground();
            ground.stopGround();*/
        }

        return super.touchDown(x, y, pointer, button);
    }

    private boolean rightSideTouched(float x, float y) {
        return screenRightSide.contains(x, y);
    }

    /**
     * Helper function to get the actual coordinates in my world
     * @param x
     * @param y
     */
    private void translateScreenToWorldCoordinates(int x, int y) {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))) {
            runner.landed();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
