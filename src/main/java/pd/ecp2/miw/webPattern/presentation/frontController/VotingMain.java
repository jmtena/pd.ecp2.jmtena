package pd.ecp2.miw.webPattern.presentation.frontController;

import pd.ecp2.miw.web.http.HttpMethod;
import pd.ecp2.miw.web.http.HttpRequest;
import pd.ecp2.miw.webPattern.dao.daos.DaoFactory;
import pd.ecp2.miw.webPattern.dao.daos.memory.DaoFactoryMemory;

public class VotingMain {

    public VotingMain() {
    }

    public void voting(){
        HttpRequest request = new HttpRequest("LocalHost", "Voting", HttpMethod.GET);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }
    
    public void votingVoteTheme(String themeName, int value) {
        HttpRequest request = new HttpRequest("LocalHost", "Voting", HttpMethod.POST);
        request.addQueryParam("action", "voteTheme");
        request.addQueryParam("themeName", themeName);
        request.addQueryParam("value", "" + value);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }

    public void themeManager(){
        HttpRequest request = new HttpRequest("LocalHost", "ThemeManager", HttpMethod.GET);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }
    
    public void themeManagerCreateTheme(String themeName){
        HttpRequest request = new HttpRequest("LocalHost", "ThemeManager", HttpMethod.POST);
        request.addQueryParam("action", "createTheme");
        request.addQueryParam("themeName", themeName);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }
    
    public static void main(String[] args) {
        DaoFactory.setFactory(new DaoFactoryMemory());
        VotingMain main = new VotingMain();
        System.out.println("-------Voting--------------------------------------------------------");
        main.voting();
        System.out.println("-------ThemeManager--------------------------------------------------");
        main.themeManager();
        System.out.println("---");
        main.themeManagerCreateTheme("Tema1");
        System.out.println("---");
        main.themeManagerCreateTheme("Tema2");
        System.out.println("-------Voting--------------------------------------------------------");
        main.votingVoteTheme("Tema1", 4);
        System.out.println("---");
        main.votingVoteTheme("Tema1", 6);
        System.out.println("---");
        main.votingVoteTheme("Tema1", 5);
        System.out.println("---");
        main.votingVoteTheme("Tema2", 5);
    }

}
