package pd.ecp2.miw.business;

import java.util.List;

import pd.ecp2.miw.webPattern.dao.daos.DaoFactory;
import pd.ecp2.miw.webPattern.dao.entities.Theme;
import pd.ecp2.miw.webPattern.dao.entities.Vote;
import pd.ecp2.miw.webPattern.presentation.frontController.TransferVote;

public class BusinessControllerVote {
	
	public TransferVote receiveVotes() {
		return new TransferVote(getVotesAll());
	}
	
	private List<Vote> getVotesAll() {
		List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
        return votes;
	}
	
	public TransferVote receiveVotesByTheme(Theme theme) {
		List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
		return new TransferVote(votes);
	}
	
	public void sendVotes(TransferVote transferVote){
		Vote vote = transferVote.getVotes().get(transferVote.size()-1);
		
		DaoFactory.getFactory().getVoteDao().create(vote);
	}
}
