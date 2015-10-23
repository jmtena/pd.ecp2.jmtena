package pd.ecp2.miw.webPattern.presentation.frontController;

import java.util.List;

public class TransferTheme {
	private List<String> themeNames;
	
	public TransferTheme(List<String> themeNames){
		this.themeNames = themeNames;
	}

	public List<String> getThemeNames() {
		return this.themeNames;
	}
	
	public void addTheme(String themeName){
		this.themeNames.add(themeName);
	}
	
	public int size(){
		return themeNames.size();
	}

}
