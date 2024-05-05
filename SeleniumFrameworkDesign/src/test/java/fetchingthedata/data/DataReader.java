package fetchingthedata.data;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getdatafromjson() 
	
	{
		//read json data into the string 
	  String jsondata = FileUtils.readFileToString(new File(System.getProperty("user.dir"))+"//src//test//java//fetchingthedata//data//Data.json", 
			  StandardCharsets.UTF_8);
		
	  //Convert the string to hashMap 
	  
	  ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsondata, new TypeReference<List<HashMap<String, String>>> () {});
	
	return 
			data;
	
		
	}
}
