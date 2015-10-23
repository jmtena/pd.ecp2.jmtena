package pd.ecp2.miw.webPattern.presentation.frontController;

public class ThemeManagerView implements View{

	@Override
    public void show(Model model) {
		System.out.println(model.get("msg"));
		TransferTheme themes = (TransferTheme)model.get("TransferTheme");
		if (themes != null)
			System.out.println("Temas: " + themes.getThemeNames());
    }
	
}
