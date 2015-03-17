package Nashorn;

import javax.script.*;
import java.util.List;

public class MultipleScopes {
    public static void main(String[] args) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // set global variable
        engine.put("x", "hello");

        // evaluate JavaScript code that prints the variable (x = "hello")
        engine.eval("print(x)");

        // define a different script context
        ScriptContext newContext = new SimpleScriptContext();
        newContext.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
        Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);

        List<Integer> listScopes = newContext.getScopes();
        for (int i = 0; i < listScopes.size(); i++) {

            engine.eval("print('"+ listScopes.get(i).toString() +"')");

        }

        // set the variable to a different value in another scope
        engineScope.put("x", "world");

        // evaluate the same code but in a different script context (x = "world")
        engine.eval("print(x)", newContext);
    }
}