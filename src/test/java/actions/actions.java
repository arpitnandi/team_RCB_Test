/* Created by: ARPIT NANDI
This file contains the reusable methods to perform different actions under the tests
*/

package functions;
 
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class actions
{
    JSONParser parseJson = new JSONParser() ;
    FileReader reader ;
    

    // The function checks the number of minnimum players in a team having the required quality
    public int validateData(String fileName , String category , String attribute , String validation , String value )
    {
        int number = 0;
        String testDataDirector = "src/test/java/testData/" ;

        try{
            reader = new FileReader( testDataDirector + fileName + ".json" ) ;
            Object obj = parseJson.parse( reader ) ;
            JSONObject teamRCB = ( JSONObject ) obj ;
            JSONArray players = ( JSONArray ) teamRCB.get( category ) ;

            Iterator iterator = players.iterator() ;

            while( iterator.hasNext() ) {
                JSONObject info = ( JSONObject ) iterator.next() ;
                
                String actualInfo = ( String ) info.get( attribute ) ;

                if( validation.equals( "==" ))
                {
                    if( actualInfo.equals( value ) )
                    {
                        number++ ;
                    }
                }
                if( validation.equals( "!=" ))
                {
                    if( !actualInfo.equals( value ) )
                    {
                        number++ ;
                    }
                }
            }

        }
        catch( Throwable e ) {
            e.printStackTrace() ;
        }
        
        return number ;
    }

}