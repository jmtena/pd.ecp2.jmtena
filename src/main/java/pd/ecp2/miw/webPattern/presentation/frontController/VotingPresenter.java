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
		
		BusinessControllerVote businessControllerVote = new BusinessControllerVote();
		TransferVote transferVote = businessControllerVote.receiveVotes();
		Vote vote = new Vote(transferVote.size(),value,new Theme(transferVote.size(),themeName));
		transferVote.addVote(vote);
		businessControllerVote.sendVotes(transferVote);
		
		transferVote = calculateAverage();
		model.put("TransferVote", transferVote);
		
        return "VotingView";
	}
	
	public TransferVote calculateAverage(){
		List<Vote> averageVotes = new ArrayList<Vote>();

		TransferVote transferVote = new BusinessControllerVote().receiveVotes();
		List<Vote> votes = transferVote.getVotes();
		List<String> temas = new ArrayList<String>();
		
		for(Vote vote : votes){
			String theme = vote.getTheme().getName();
			if (!contains(temas, theme))
				temas.add(theme);
		}
		
		int i=0;
		for(String theme : temas){
			double average = 0;
			int numVotes = 0;
			
			for(Vote vote: votes){
				if (vote.getTheme().getName().equalsIgnoreCase(theme)){
					average += vote.getVote();
					numVotes++;
				}
			}
			if (numVotes != 0)
				average = (double)average / numVotes;
			Vote vote = new Vote(i,average,new Theme(i,theme));
			averageVotes.add(vote);
			i++;
		}
		return new TransferVote(averageVotes);
	}
	
	private boolean contains(List<String> list, String str){
		boolean contain = false;
		
		for(String s : list){
			if (s.equalsIgnoreCase(str)){
				contain = true;
				break;
			}
		}
		
		return contain;
	}
}
