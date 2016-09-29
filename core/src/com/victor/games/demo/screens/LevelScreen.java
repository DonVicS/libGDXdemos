package com.victor.games.demo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.victor.games.demo.DemoGame;
import com.victor.games.demo.Entities.BadGuy;
import com.victor.games.demo.Entities.BadGuys;
import com.victor.games.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Santamaria on 17/09/16.
 */
public class LevelScreen extends GenericScreen {

    public static final String TAG = LevelScreen.class.getName();

    private DemoGame game;
    private int difficulty;

    private static final float WORLD_WIDTH = 26;
    private static final float WORLD_HEIGHT = 19;
    private static final float PERIOD = 1.0f;

//    private long initialTime;

    private List<BadGuy> badGuysList;

    private BadGuys badGuys;

    public LevelScreen(DemoGame game, int difficulty) {
        this.game = game;
        this.difficulty = difficulty;

        super.worldWidth = WORLD_WIDTH;
        super.worldHeight = WORLD_HEIGHT;

        badGuysList = new ArrayList<BadGuy>();

        BadGuy badGuy = new BadGuy(new Vector2(2 + Constants.BAD_GUYS_RADIUS,
                                            10 + Constants.BAD_GUYS_RADIUS),
                                    new Vector2(5 + Constants.BAD_GUYS_RADIUS,
                                            10 + Constants.BAD_GUYS_RADIUS),
                                    new Vector2(0.05f, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(5 + Constants.BAD_GUYS_RADIUS,
                                        9 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(15 + Constants.BAD_GUYS_RADIUS,
                                        9 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0.1f, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(20 + Constants.BAD_GUYS_RADIUS,
                                        12 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(10 + Constants.BAD_GUYS_RADIUS,
                                        12 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(-0.01f, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(18 + Constants.BAD_GUYS_RADIUS,
                                        5 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(18 + Constants.BAD_GUYS_RADIUS,
                                        10 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, 0.05f));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                                        10 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                                        2 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, -0.5f));
        badGuysList.add(badGuy);

    }

    @Override
    public void show() {
        super.show();
//        initialTime = TimeUtils.nanoTime();
        badGuys = new BadGuys(viewport, badGuysList);
    }

    @Override
    public void render(float delta) {
        badGuys.update(delta);

        viewport.apply();
        Gdx.gl.glClearColor(Constants.LEVEL_SCREEN_BACKGROUND.r, Constants.LEVEL_SCREEN_BACKGROUND.g, Constants.LEVEL_SCREEN_BACKGROUND.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

//        float elapsedNanoseconds = TimeUtils.nanoTime() - initialTime;
//        float elapsedSeconds = MathUtils.nanoToSec * elapsedNanoseconds;
//        float elapsedPeriods = elapsedSeconds / PERIOD;
//        float cyclePosition = elapsedPeriods % 1;

        renderMap();
        badGuys.render(renderer);

        renderer.end();

    }

    private void renderMap() {
        for (int yStart = 0; yStart < WORLD_HEIGHT; yStart += 1) {
            for (int xStart = 0; xStart < WORLD_WIDTH; xStart += 1) {
                if ((yStart + xStart) % 2 == 0) {
                    renderer.setColor(Color.WHITE);
                } else {
                    renderer.setColor(Color.BLACK);
                }
                renderer.rect(xStart, yStart, 1, 1);
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        badGuys.init(badGuysList);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        game.showMainScreen();
        return true;
    }

}