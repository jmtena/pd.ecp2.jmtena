package pd.ecp2.miw.webPattern.dao.daos.memory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pd.ecp2.miw.webPattern.dao.daos.VoteDao;
import pd.ecp2.miw.webPattern.dao.entities.Theme;
import pd.ecp2.miw.webPattern.dao.entities.Vote;

public class VoteMemoryDao extends GenericMemoryDao<Vote, Integer> implements VoteDao {

    public VoteMemoryDao() {
        this.setMap(new HashMap<Integer, Vote>());
    }

    @Override
    protected Integer getId(Vote entity) {
        return entity.getId();
    }

    @Override
    public List<Vote> findByTheme(Theme theme) {
        List<Vote> votes = new ArrayList<>();
        List<Vote> votesAll = this.findAll();
        for (Vote vote : votesAll) {
            if (theme.equals(vote.getTheme())) {
                votes.add(vote);
            }
        }
        return votes;
    }

}
