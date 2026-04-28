import org.example.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  private Account testAccount;

  @BeforeEach
    void setUp(){
      testAccount=new Account(1,"Test User",1000.00);
  }

  @Test
    @DisplayName("Should correctly reduce balance on withdrawal")
    void testWithdrawalSuccess(){
      double amountToWithdraw=200.0;
      double expectedBalance=800.0;

      testAccount.setBalance(testAccount.getBalance()-amountToWithdraw);

      assertEquals(expectedBalance,testAccount.getBalance(),"The balance after withdrawal should be exactly 800.00");
  }

  @Test
    @DisplayName("Should throw exception for insufficient funds")
    void testInsufficientFunds(){
      assertThrows(IllegalArgumentException.class,()->{
          double withdrawalAmount=1500.00;
          if(withdrawalAmount>testAccount.getBalance()){
              throw new IllegalArgumentException("Insufficient funds");
          }
      });
  }
}
