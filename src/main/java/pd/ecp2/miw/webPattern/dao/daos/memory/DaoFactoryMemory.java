package pd.ecp2.miw.webPattern.dao.daos.memory;

import pd.ecp2.miw.webPattern.dao.daos.DaoFactory;
import pd.ecp2.miw.webPattern.dao.daos.ThemeDao;
import pd.ecp2.miw.webPattern.dao.daos.VoteDao;
import pd.ecp2.miw.webPattern.dao.daos.memory.ThemeMemoryDao;
import pd.ecp2.miw.webPattern.dao.daos.memory.VoteMemoryDao;

public class DaoFactoryMemory extends DaoFactory {

    private ThemeDao themeDao;

    private VoteDao voteDao;

    public DaoFactoryMemory() {
    }

    @Override
    public ThemeDao getThemeDao() {
        if (themeDao == null) {
            themeDao = new ThemeMemoryDao();
        }
        return themeDao;
    }

    @Override
    public VoteDao getVoteDao() {
        if (voteDao == null) {
            voteDao = new VoteMemoryDao();
        }
        return voteDao;
    }

}
