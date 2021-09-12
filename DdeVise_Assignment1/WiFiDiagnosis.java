/*
Donovan deVise
Prof Tsai
Assignment 1 Implementation
9/12/2021
*/
import java.util.Scanner;
public class WiFiDiagnosis {
    public static void main(String args[]) {
      //Initialize Scanner Var
      Scanner myObj = new Scanner(System.in);
      //Check if Rebooting Computer Works
      System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n\nFirst step: reboot your computer\nAre you able to connect with the internet? (yes or no)");
      String answer = myObj.nextLine();
      if (answer.equalsIgnoreCase("yes"))
      {
          System.out.println("Rebooting your computer seemed to work");
      }
      else
      {
          //Check if Rebooting Router Works
          System.out.println("Second step: reboot your router\nNow are you able to connect with the internet? (yes or no)");
          answer = myObj.nextLine();
          if (answer.equalsIgnoreCase("yes"))
          {
              System.out.println("Rebooting your router seemed to work");
          }
          else
          {
              //Check if Plugging in Cables Works
              System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power\nNow are you able to connect with the internet? (yes or no)");
              answer = myObj.nextLine();
              if (answer.equalsIgnoreCase("yes"))
              {
                  System.out.println("Checking your cables seemed to work");
              }
              else
              {
                  //Check if Moving Computer Works
                  System.out.println("Fourth step: move your computer closer to your router\nNow are you able to connect with the internet? (yes or no)");
                  answer = myObj.nextLine();
                  if (answer.equalsIgnoreCase("yes"))
                  {
                      System.out.println("Moving your computer seemed to work");
                  }
                  else
                  {
                      //End of Program
                      System.out.println("Fifth step: contact your ISP\nMake sure your ISP is hooked up to your router.");
                  }
              }
          }
      }
    }
}



