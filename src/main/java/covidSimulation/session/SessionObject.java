package covidSimulation.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class SessionObject {
    private String info = null;
    private String filter = null;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getInfo() {
        String result = this.info;
        this.info = null;
        return result;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}

