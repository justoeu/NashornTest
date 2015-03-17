package Nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ImplementRunnable {

    public static void main(String[] args) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // Criando um funcao run dentro do Javascript
        engine.eval("function run() { print('run() function called') }");

        // Efetua o Casting para o Invocable
        Invocable inv = (Invocable) engine;

        // Pega a interface Runnable da classe Invocable
        Runnable r = inv.getInterface(Runnable.class);

        // cria uma threand
        Thread th = new Thread(r);
        th.start();
        th.join();
    }
}