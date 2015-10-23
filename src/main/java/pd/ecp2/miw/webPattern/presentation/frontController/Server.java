package pd.ecp2.miw.webPattern.presentation.frontController;

import pd.ecp2.miw.web.http.HttpMethod;
import pd.ecp2.miw.web.http.HttpRequest;
import pd.ecp2.miw.web.http.HttpResponse;
import pd.ecp2.miw.web.http.HttpStatus;

public class Server {

    public HttpResponse send(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        if (HttpMethod.GET.equals(request.getMethod())) {
            new FrontController().doGet(request, response);
        } else if (HttpMethod.POST.equals(request.getMethod())) {
            new FrontController().doPost(request, response);
        }
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
