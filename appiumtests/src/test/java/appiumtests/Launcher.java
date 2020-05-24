package appiumtests;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public void launcher() {
	device = UiDevice.getInstance(getInstrumentation());
	device.pressHome();

	// Bring up the default launcher by searching for a UI component
	// that matches the content description for the launcher button.
	UiObject allAppsButton = device
	        .findObject(new UiSelector().description("Apps"));

	// Perform a click on the button to load the launcher.
	allAppsButton.clickAndWaitForNewWindow();
}
	
}
