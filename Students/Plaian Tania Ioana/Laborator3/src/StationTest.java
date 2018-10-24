import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StationTest {


	@Test
	public void AddBusTest() {
		 List<Bus> buses = new ArrayList<Bus>();
		 Station s = new Station("Cipariu","Cluj", buses);
		 Assertions.assertEquals(0, buses.size());
		 s.AddBus("BMW", "ROZ", 10);
		 s.AddBus("SKODA", "MOV", 26);
		 s.AddBus("AUDI", "TICLAM", 5);
		 Assertions.assertEquals(3, buses.size());
		 s.AddBus("AUDI", "TICLAM", 5);
		 Assertions.assertEquals(4, buses.size());
	}
	
	
	@Test
	public void RemoveBusTest() {
		List<Bus> buses = new ArrayList<Bus>();
		Station s = new Station("Cipariu","Cluj", buses);
		s.AddBus("BMW", "ROZ", 10);
	    s.AddBus("SKODA", "MOV", 26);
	    s.AddBus("SKODA", "MOV", 34);
	    s.AddBus("SKODA", "MOV", 46);
	    s.RemoveBus(30);
	    Assertions.assertEquals(2, buses.size());	 
		
	}

	@Test
	public void FillArrayTest() {
		 List<Bus> buses = new ArrayList<Bus>();
		 Station s = new Station("Cipariu","Cluj", buses);
		 s.FillArray();
		 s.PrintBuses(); 
	}
}
