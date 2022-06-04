/* Created by: ARPIT NANDI
The scope of this test:
1) How many players are not belongs to India in team RCB
2) How many wicket keepers are there in team RCB
*/

package test_cases;

import org.testng.annotations.Test;
import org.testng.Assert;
import functions.*;


/* To run the test:
 * 1) Install maven in the system
 * 2) Navigate to the framework core directory
 * 3) Run the commands in a sequence - "mvn clean" >> "mvn compile" >> "mvn test"
 */

public class test1
{
    actions Actions = new actions();
    int actualCount = 0 ;
    int expectedCount = 0 ;

    @Test
    public void Test_Case_1_validates_that_the_team_has_only_4_foreign_players()
    {
        actualCount = Actions.validateData( "team_RCB", "player" , "country" , "!=" , "India" ) ;
        expectedCount = 4 ;
        Assert.assertEquals( actualCount , expectedCount ) ;
        System.out.println( "[Foreigners = " + actualCount + "]" );
    };
    
    @Test
    public void Test_Case_2_Velidate_that_there_is_at_least_one_wicket_keeper()
    {
        actualCount = Actions.validateData( "team_RCB" , "player" , "role" , "==" , "Wicket-keeper" ) ;
        expectedCount = 1 ;
        Assert.assertTrue( actualCount >= expectedCount ) ;
        System.out.println( "[Wicket Keepers = " + actualCount + "]" );
    };
    
}