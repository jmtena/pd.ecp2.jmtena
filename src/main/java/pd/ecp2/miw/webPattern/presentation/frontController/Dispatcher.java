package pd.ecp2.miw.webPattern.presentation.frontController;

import pd.ecp2.miw.web.http.HttpRequest;
import pd.ecp2.miw.web.http.HttpResponse;

public class Dispatcher {
	
	public void doGet(HttpRequest request, HttpResponse response) {
		Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";
        
        switch (presenter) {
        case "VotingPresenter":
        	VotingPresenter votingPresenter = new VotingPresenter();
        	//Injectar parámetros mediante helper1Presenter.setters()
            nextView = votingPresenter.process(model);
        	break;
        case "ThemeManagerPresenter":
        	ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
        	//Injectar parámetros mediante helper1Presenter.setters()
            nextView = themeManagerPresenter.process(model);
        	break;
        }
        this.show(nextView, model);
	}
	
	public void doPost(HttpRequest request, HttpResponse response) {
		Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";
        
        switch (presenter) {
        case "VotingPresenter":
        	VotingPresenter votingPresenter = new VotingPresenter();
        	if ("voteTheme".equals(action)) {
        		votingPresenter.setThemeName(request.getParams().get("themeName"));
        		votingPresenter.setValue(Integer.valueOf(request.getParams().get("value")));
        		nextView = votingPresenter.vote(model);
        	} else {
                model.put("error", "Acción no permitida: " + action);
            }
        	break;
        case "ThemeManagerPresenter":
        	ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
        	if ("createTheme".equals(action)) {
        		themeManagerPresenter.setThemeName(request.getParams().get("themeName"));
        		nextView = themeManagerPresenter.createTheme(model);
        	} else {
                model.put("error", "Acción no permitida: " + action);
            }
        	break;
        }
        this.show(nextView, model);
	}
	
    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "VotingView":
            view = new VotingView();
            break;
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }
	
}
