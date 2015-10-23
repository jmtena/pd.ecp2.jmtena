package pd.ecp2.miw.webPattern.presentation.frontController;

import pd.ecp2.miw.business.BusinessControllerTheme;

public class ThemeManagerPresenter {

	String themeName;
	
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String process(Model model){
		model.put("msg", "Theme Manager Page");
        return "ThemeManagerView";
	}
	
	public String createTheme(Model model){
		model.put("msg", "Theme Manager Page");
		TransferTheme transferTheme = new BusinessControllerTheme().receiveThemeNames();
		transferTheme.addTheme(themeName);
		new BusinessControllerTheme().sendThemes(transferTheme);
		model.put("TransferTheme", transferTheme);
        return "ThemeManagerView";
	}
}
