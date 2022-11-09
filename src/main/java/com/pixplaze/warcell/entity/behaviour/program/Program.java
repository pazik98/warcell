package com.pixplaze.warcell.entity.behaviour.program;

import java.util.HashMap;
import java.util.Map;

public class Program {
    private String name = "Program";
    private String codeText = "";

    private Block mainBlock;

    private Map<String, Variable> variableMap = new HashMap<>();

    public Program() {

    }

    public void initVariable(String name, Variable variable) {
        variableMap.put(name, variable);
    }

    public void setVariableValue(String name, Object value) {
        variableMap.get(name).setValue(value);
    }

    public Object getVariableValue(String name) {
        return variableMap.get(name).getValue();
    }

    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }
}
