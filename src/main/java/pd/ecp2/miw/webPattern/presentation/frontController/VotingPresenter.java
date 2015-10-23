package pd.ecp2.miw.webPattern.presentation.frontController;

import java.util.ArrayList;
import java.util.List;

import pd.ecp2.miw.business.BusinessControllerTheme;
import pd.ecp2.miw.business.BusinessControllerVote;
import pd.ecp2.miw.webPattern.dao.entities.Theme;
import pd.ecp2.miw.webPattern.dao.entities.Vote;

public class VotingPresenter {
	
	private String themeName;
	
	private int value;
	
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String process(Model model){
		model.put("msg", "Voting Page");
        return "VotingView";
	}
	
	public String vote(Model model){
		model.put("msg", "Voting Page");
		
		TransferVote transferVote = new BusinessControllerVote().receiveVotes();
		Vote vote = new Vote(transferVote.size(),value,new Theme(transferVote.size(),themeName));
		transferVote.addVote(vote);
		new BusinessControllerVote().sendVotes(transferVote);
		
		transferVote = calculateAverage();
		model.put("TransferVote", transferVote);
		
        return "VotingView";
	}
	
	public TransferVote calculateAverage(){
		List<Theme> themes = new BusinessControllerTheme().receiveThemes();
		List<Vote> averageVotes = new ArrayList<Vote>();
			
		int i=0;
		for(Theme theme : themes){
			int average = 0;
			int numVotes = 0;
			
			TransferVote transferVote = new BusinessControllerVote().receiveVotesByTheme(theme);
			List<Vote> votes = transferVote.getVotes();
			
			for(Vote vote: votes){
				if (vote.getTheme().equals(theme)){
					average += vote.getVote();
					numVotes++;
				}
			}
			if (numVotes != 0)
				average = average / numVotes;
			Vote vote = new Vote(i,average,theme);
			averageVotes.add(vote);
			i++;
		}
		return new TransferVote(averageVotes);
	}
}
