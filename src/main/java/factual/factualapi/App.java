package factual.factualapi;

import com.factual.driver.Circle;
import com.factual.driver.Factual;
import com.factual.driver.Query;
import com.factual.driver.ReadResponse;

import java.io.File; 
import java.io.IOException; 
import java.util.HashMap;

import org.codehaus.jackson.JsonFactory; 
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper; 
import org.codehaus.jackson.type.TypeReference;
/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	Factual factual = new Factual("xxFiqmh1H26jMWUXmmVrexYbwIIL3RE269Dk8hUx", "mFEshzJuARYclNyoBPmeOZr9wyduWGq9LTm5aQpT");
    	
    	ReadResponse resp=factual.fetch("places",new Query().within(new Circle(40.746402,-73.983663, 10000)).search("google").field("name").beginsWith("google"));
    	String factualResp=resp.toString();
    	 try { 
             parseResponseToMap(factualResp); 
         } catch (Exception e){ 
             System.out.println("Exception " + e); 
         }      
    }

	private static void parseResponseToMap(String factualResp) throws JsonParseException, JsonMappingException, IOException {
	        JsonFactory factory = new JsonFactory(); 
	        ObjectMapper mapper = new ObjectMapper(factory); 
	        /*TypeReference<HashMap<String,Object>> typeRef 
	              = new TypeReference< 
	                     HashMap<String,Object> 
	                   >() {};*/ 
	        FactualMapper o 
	             = mapper.readValue(factualResp, FactualMapper.class); 
	        //System.out.println("Got " + o.getFactualresp().getData().get(0).address); 
	        int len=o.getFactualresp().getData().size();
	        
	        for (int i = 0; i < len; i++) {
				System.out.println(o.getFactualresp().getData().get(i).getLatitude() +", " +o.getFactualresp().getData().get(i).getLongitude() + "," + o.getFactualresp().getData().get(i).getName());
			}

		
	}
}
