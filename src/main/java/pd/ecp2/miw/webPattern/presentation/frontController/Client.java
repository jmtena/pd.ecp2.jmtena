package pd.ecp2.miw.webPattern.presentation.frontController;

import pd.ecp2.miw.web.http.HttpRequest;
import pd.ecp2.miw.web.http.HttpResponse;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
