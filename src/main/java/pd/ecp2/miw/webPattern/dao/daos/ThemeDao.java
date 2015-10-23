package pd.ecp2.miw.webPattern.dao.daos;

import java.util.List;

import pd.ecp2.miw.webPattern.dao.entities.Theme;

public interface ThemeDao  extends GenericDao<Theme,Integer>{
	Theme findByName(String themeName);
	List<String> findAllNames();	
}
