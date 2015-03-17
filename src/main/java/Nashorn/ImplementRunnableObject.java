package Nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ImplementRunnableObject {
    public static void main(String[] args) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        engine.eval("var obj = new Object()");
        engine.eval("obj.run = function() { print('obj.run() method called') }");

        Object obj = engine.get("obj");

        Invocable inv = (Invocable) engine;

        Runnable r = inv.getInterface(obj, Runnable.class);

        Thread th = new Thread(r);
        th.start();
        th.join();
    }
}