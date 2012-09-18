package factual.factualapi;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FactualMapper {

	String version="";
	String status="";
	@JsonProperty("response")
	Response response=new Response();
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	@JsonProperty("response")
	public Response getFactualresp() {
		return response;
		
	}
	
	@JsonProperty("response")
	public void setFactualresp(Response response) {
		this.response = response;
	}
	
	@Override
	public String toString()
	{
	return "";
	}
	
}
