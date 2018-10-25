import org.junit.jupiter.api.Test;

public class StationTest {
	
	@Test1
	String L[][] = new String[50][2];
	L[0][0]="10:10";
	L[0][1]="24B";
	L[1][0]="11:00";
	L[1][1]="30";
	
	Station Statia1 = new Station("Pirata Marasti","Culj-Napoca",L);
	Statia1.showTimetableAfterTheHour("12:00");
	
	
  }
}
