package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static spark.Spark.*;

/**
 * Created by Joginder on 2016-03-30.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
