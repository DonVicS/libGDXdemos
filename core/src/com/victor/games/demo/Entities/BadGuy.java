package com.victor.games.demo.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.victor.games.demo.utils.Constants;


/**
 * Created by Victor Santamaria on 18/09/16.
 */
public class BadGuy {

    public static final String TAG = BadGuy.class.getName();

//    public int id;
//    public String name;

    public final Vector2 startingPoint;
    public final Vector2 endPoint;
    public Vector2 speed;
//    private final Vector2 normalSpeed;
//    private final Vector2 reversedSpeed;

//    private Vector2 distance;

    public Vector2 position;

//    private boolean goBack;

    public BadGuy(Vector2 startingPoint, Vector2 endPoint, Vector2 speed) {
        this.startingPoint = new Vector2(startingPoint);
        this.endPoint = new Vector2(endPoint);
        this.speed = new Vector2(speed);
        this.position = new Vector2(startingPoint);
//        this.goBack = false;
//        this.normalSpeed = new Vector2(speed);
//        this.reversedSpeed = new Vector2(speed.x * -1, speed.y * -1);
//        this.distance = new Vector2(0, 0);
    }

    public void update(float delta) {
//        Vector2 a = new Vector2(0.5f, 0);
//        speed.mulAdd(a, delta);
//        position.mulAdd(speed, delta);
/*

        if (position.x >= endPoint.x) {
            speed.x = reversedSpeed.x;
            position.x = endPoint.x;
        } else if (position.x <= startingPoint.x) {
            speed.x = normalSpeed.x;
            position.x = startingPoint.x;
        }
*/

        position.x += speed.x;
        position.y += speed.y;

//        distance.x += speed.x;
//        distance.y += speed.y;
/*

        if (position.x >= endPoint.x && distance.x >= endPoint.x - startingPoint.x) {
            speed.x = reversedSpeed.x;
            position.x = endPoint.x;
            distance.x = 0;
            return;
        }

        if (position.x <= startingPoint.x && distance.x <= (endPoint.x - startingPoint.x) * -1) {
            speed.x = normalSpeed.x;
            position.x = startingPoint.x;
            distance.x = 0;
            return;
        }
*/
/*
        if (position.x >= endPoint.x && !goBack) {
            speed.x *= -1;
            goBack = true;
        }
        else if (position.x <= startingPoint.x && goBack) {
            speed.x *= -1;
            goBack = false;
        }*/

        if (startingPoint.x < endPoint.x && (position.x >= endPoint.x || position.x <= startingPoint.x))
            speed.x *= -1;
        else if (startingPoint.x > endPoint.x && (position.x <= endPoint.x || position.x >= startingPoint.x))
            speed.x *= -1;
        else if (startingPoint.y < endPoint.y && (position.y >= endPoint.y || position.y <= startingPoint.y))
            speed.y *= -1;
        else if (startingPoint.y > endPoint.y && (position.y <= endPoint.y || position.y >= startingPoint.y))
            speed.y *= -1;

//        if (position == endPoint || position == startingPoint) {
//            speed.x *= -1;
//            speed.y *= -1;
////            a.x *= -1;
////            a.y *= -1;
//        }
//    }
    }

    public void render(ShapeRenderer renderer) {
        renderer.circle(position.x, position.y, Constants.BAD_GUYS_RADIUS, 20);
/*
        renderer.setColor(Color.RED);
        Vector2 p = new Vector2(2 + Constants.BAD_GUYS_RADIUS,
                10 + Constants.BAD_GUYS_RADIUS);
        Vector2 p2 = new Vector2(p.x, p.y);
        renderer.circle(p2.x, p2.y, Constants.BAD_GUYS_RADIUS, 20);
*/


//        renderer.triangle(
//                position.x, position.y,
//                position.x - Constants.BAD_GUYS_SIZE / 2, position.y + Constants.BAD_GUYS_SIZE,
//                position.x + Constants.BAD_GUYS_SIZE / 2, position.y + Constants.BAD_GUYS_SIZE
//        );
    }

    @Override
    public String toString() {
        return "BadGuy{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
                ", startingPoint=" + startingPoint +
                ", endPoint=" + endPoint +
                ", speed=" + speed +
                '}';
    }
}
