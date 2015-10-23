package pd.ecp2.miw.webPattern.presentation.frontController;

import java.util.List;

import pd.ecp2.miw.webPattern.dao.entities.Vote;

public class TransferVote {
	List<Vote> votes;
	
	public TransferVote(List<Vote> votes){
		this.votes = votes;
	}

	public List<Vote> getVotes() {
		return votes;
	}
	
	public void addVote(Vote vote){
		votes.add(vote);
	}
	
	public int size(){
		return votes.size();
	}
}
