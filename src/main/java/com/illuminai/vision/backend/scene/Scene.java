package com.illuminai.vision.backend.scene;

import com.illuminai.vision.backend.math.Vector3d;
import com.illuminai.vision.backend.render.Color;
import com.illuminai.vision.backend.scene.light.DistantLight;
import com.illuminai.vision.backend.scene.light.Light;
import com.illuminai.vision.backend.scene.material.DiffuseMaterial;
import com.illuminai.vision.backend.scene.material.FresnelMaterial;
import com.illuminai.vision.backend.scene.material.SpecularMaterial;
import com.illuminai.vision.backend.scene.shape.Plane;
import com.illuminai.vision.backend.scene.shape.Shape;
import com.illuminai.vision.backend.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.List;

/**
 * A scene
 */
public class Scene {

    /**
     * the shapes
     */
    private List<Shape> shapes;

    private List<Light> lights;

    /**
     * Constructs and initializes a Scene.
     */
    public Scene() {
        shapes = new ArrayList<>();
        lights = new ArrayList<>();
    }

    /**
     * @return the shapes
     */
    public List<Shape> getShapes() {
        return shapes;
    }

    public List<Light> getLights() {
        return lights;
    }

    //TODO: Remove hard coded stuff

    private double time = 0;

    public void tick() {
        time++;
    }

    //Sphere red, green, blue;
    public void sceneInit() {
        /*SphereSDF s1 = new SphereSDF(new Vector3d(0, 0, 0), .3);
        TorusSDF s2 = new TorusSDF(.1, .3);
        IntersectionSDF sdf = new IntersectionSDF(s1, s2);

        SphereSDF s3 = new SphereSDF(new Vector3d(.2,.2,.2), .2);
        SubtractionSDF sdf2 = new SubtractionSDF(s3, sdf);*/

        shapes.add(new Sphere(new Vector3d(2, 0, 1), .15, new DiffuseMaterial(0.2, new Color(1, 1, 1))));

        shapes.add(new Sphere(new Vector3d(2, .5, 1), .15, new SpecularMaterial(0.9)));
        shapes.add(new Sphere(new Vector3d(2, 1, 1), .15, new FresnelMaterial(1.333)));

        shapes.add(new Plane(new Vector3d(0, 0, .75), new DiffuseMaterial(.4, new Color(0, 0, 0)), new Vector3d(0, 0, 1)));

        lights.add(new DistantLight(new Color(1, 0, 1), 15, new Vector3d(2, 1, -3)));
        //lights.add(new PointLight(new Color(1, 1, 0), 15, new Vector3d(1, 0, 1)));
    }
}
