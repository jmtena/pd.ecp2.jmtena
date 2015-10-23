package pd.ecp2.miw.webPattern.dao.daos;

import java.util.List;

import pd.ecp2.miw.webPattern.dao.entities.Theme;
import pd.ecp2.miw.webPattern.dao.entities.Vote;

public interface VoteDao extends GenericDao<Vote,Integer>{
	List<Vote> findByTheme(Theme theme);
	List<Vote> findAll();
}
