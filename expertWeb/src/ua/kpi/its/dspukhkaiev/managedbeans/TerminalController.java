package ua.kpi.its.dspukhkaiev.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "terminalController")
@ViewScoped
public class TerminalController {

    public String handleCommand(String command, String[] params) {
        if (command.equals("greet"))
            return "Hello " + params[0];
        else
            return command + " not found";
    }
}
