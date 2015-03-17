package Nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by valmir.justo on 3/17/15.
 *
 * Documentacao
 * http://docs.oracle.com/javase/8/docs/technotes/guides/scripting/prog_guide/api.html
 *
 */
public class NashornMain {

    public static final String ENGINE_NASHORN = "nashorn";

    public static void main(String[] args) {

        try {

            ScriptEngineManager scriptManager = new ScriptEngineManager();
            ScriptEngine engine = scriptManager.getEngineByName(ENGINE_NASHORN);

            engine.eval("print('Hello, World')");

            // Criando um metodo chamado Execute
            engine.eval("function execute(name) { print('Hello, ' + name) }");

            // fazendo o casting para o objeto Invocable
            Invocable inv = (Invocable) engine;

            // Chama o Metodo criado anteriormente passando o parametro
            inv.invokeFunction("execute", "Scripting!");

            // Criando um objeto no Javascript e associando o metodo ao mesmo
            engine.eval("var obj = new Object()");
            engine.eval("obj.helloWorld = function(name) { print('Hello, ' + name) }");

            // converte o objeto Javacript em objeto Java
            Object obj = engine.get("obj");

            // Faz um Casting do Engine para o Invocable
            inv = (Invocable) engine;

            // Invoca o metodo que esta dentro do Objeto java, passando um parametro
            inv.invokeMethod(obj, "helloWorld", "Script Method!");


        } catch (ScriptException se){
            se.printStackTrace();;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
