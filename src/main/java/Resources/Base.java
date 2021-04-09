package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeSuite;

public class Base {
	public Properties prop;
	public void Initial() throws IOException {
	prop= new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\Qualitest\\eclipse-workspace\\TwitterAPI\\src\\main\\java\\MyNewProjectAPI\\TwitterAPI\\data.properties");
	prop.load(fis);
	}
	public static org.apache.logging.log4j.Logger log1;
	@BeforeSuite
	public void Bsuite() throws FileNotFoundException, IOException {
	String log4jConfigFile=("C:\\Users\\Qualitest\\eclipse-workspace\\TwitterAPI\\src\\main\\java\\log4j.xml");
	ConfigurationSource source=new ConfigurationSource(new FileInputStream(log4jConfigFile));
	Configurator.initialize(null,source);
	log1=LogManager.getLogger(Base.class.getName());
	}

}
