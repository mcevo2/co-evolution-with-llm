package Utilities;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import org.json.JSONObject;

public class ChatGPT {
    public static String chatGPT(String text, double temp) throws Exception {
       // String url = "https://api.openai.com/v1/completions";
    	String url = "https://api.openai.com/v1/chat/completions";
        String response ="";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        System.out.println( "*** THE REQUEST : "+text);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model","gpt-3.5-turbo"); //"text-davinci-003");
       // data.put("prompt", text);
       if(getNbTokens(text)<2000) {
        data.put("messages", Arrays.asList( Map.of("role", "user",  "content", text)));//,Map.of("role", "system",  "content", "Act as a developer")));//"You are a helpful self help guide that provides advice on time management")));
       // data.put("messages", Arrays.asList( Map.of("role", "system",  "content", "Act as a developer")));//"You are a helpful self help guide that provides advice on time management")));
        
        data.put("max_tokens", 2000);
        data.put("temperature",temp);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();
      //chat completion output:
       // System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content"));
        response =new JSONObject(output).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
     return response;
       }
       else
       { 
    	   return response;
    	   
       }
       // Completion output : System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));

     /*  {"finish_reason":"stop",
       * "index":0,"message":{"role":"assistant",
       * 					  "content":"public static final ExecutorProperty _OpaqueExpression__expressionInOCL = new ExecutorProperty(\"expressionInOCL\", Types._OpaqueExpression, 3, new EcoreLibraryProperty(PivotPackage.Literals.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL));"
       * 					}
       * }
      
        */
    }
    
    public static int getNbTokens(String text)
    {
    	return text.toCharArray().length/4+1;
    	
    }
  
    public static void main(String[] args) throws Exception {
      //  chatGPT("Hello, how are you?");
    	String text ="The attribute maxUsedMemoryInBytes is moved from the class Discovery to the class DiscoveryIteration through the reference iterations Considering that calling setIterations from the class Discovery returns a list of DiscoveryIterationobjects Coevolve this java code : discovery.setMaxUsedMemoryInBytes(maxUsedMemory)";
    			/*" The method setIterations is generated from the reference Iteration \n"
    			+ "Considering that calling setIterations from the class Discovery returns a list of DiscoveryIteration objects .\n"
    			+ "The attribute maxUsedMemoryInBytes is moved from the class Discovery to the class DiscoveryIteration through the reference iterations\n"
    			+ " Coevolve this java code snippet  : discovery.setMaxUsedMemoryInBytes(maxUsedMemory)";
    			*/
    			//"Considering that the class  MultiProjectBenchmark is removed. Here is a method signature : private MultiProjectBenchmark buildReportModelAndDiagrams() throws CoreException IOException Coevolve it according to the described change. Give me the updated code without any explanations.";
    
   //	 System.out.println( " number of token is "+ text.toCharArray().length/4);

    	 System.out.println( chatGPT(text, 0.2));
 //chatGPT("Considering an eclipse modeling framework ecore metamodel and considering that the attribute valueExpression is renamed to expressionInOCLin the metaclass OpaqueExpression,"
    		//+ " correct this code: public static final ExecutorProperty _OpaqueExpression__valueExpression = new ExecutorProperty(\"valueExpression\", Types._OpaqueExpression, 3, new EcoreLibraryProperty(PivotPackage.Literals.OPAQUE_EXPRESSION__VALUE_EXPRESSION));");
   // chatGPT("compute 1524*5844");
    	//chatGPT("Once upon a time, in a land far, far away, there was a brave knight named Sir...");
    	
    }
}