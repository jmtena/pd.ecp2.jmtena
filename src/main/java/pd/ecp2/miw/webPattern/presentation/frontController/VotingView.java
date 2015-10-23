package pd.ecp2.miw.webPattern.presentation.frontController;

import java.util.List;

import pd.ecp2.miw.webPattern.dao.entities.Vote;

public class VotingView implements View{

	@Override
    public void show(Model model) {
		System.out.println(model.get("msg"));
		
		TransferVote votes = (TransferVote)model.get("TransferVote");
		if (votes != null){
			System.out.print("Temas: [");
			List<Vote> votations = votes.getVotes();
			int i=0;
			for(Vote vote: votations){
				System.out.print("ThemeTransfer [");
				System.out.print("themeName=");
				System.out.print(vote.getTheme().getName());
				System.out.print(", ");
				System.out.print("average=");
				System.out.print(vote.getVote());
				System.out.print("]");
				i++;
				if (i<votations.size())
					System.out.print(", ");
			}
			System.out.println("]");
			
		}
    }
	
}
