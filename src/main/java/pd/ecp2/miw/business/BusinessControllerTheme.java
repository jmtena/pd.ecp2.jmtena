package pd.ecp2.miw.business;

import java.util.List;

import pd.ecp2.miw.webPattern.dao.daos.DaoFactory;
import pd.ecp2.miw.webPattern.dao.entities.Theme;
import pd.ecp2.miw.webPattern.presentation.frontController.TransferTheme;

public class BusinessControllerTheme {
	
    public TransferTheme receiveThemeNames() {
        List<String> names = DaoFactory.getFactory().getThemeDao().findAllNames();
        return new TransferTheme(names);
    }
    
    public List<Theme> receiveThemes(){
    	List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
    	return themes;
    }
    
    public void sendThemes(TransferTheme transferTheme) {
        DaoFactory.getFactory().getThemeDao().create(new Theme(transferTheme.size(),transferTheme.getThemeNames().get(0)));
    }
}
