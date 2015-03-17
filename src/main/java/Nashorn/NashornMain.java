package Nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by valmir.justo on 3/17/15.
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

        } catch (ScriptException se){
            se.printStackTrace();;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
