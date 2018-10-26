
public class Station {

	private String name;
	private String location;
	private String timetable[][];


	public Station(String name,String location,String timetable[][]) {
		this.name=name;
		this.location=location;
		this.timetable=timetable;
	}
	
	public void showTimetableAfterTheHour(String hour) {
		int verification=1;
		for(int i=0;i<timetable.length;i++)
		{
			if(timetable[i][0].compareTo(hour)>1)
			{
				System.out.println(timetable[i]);
				verification=0;
			}
		}
		if(verification==1)
			System.out.println("Invalid hour");
	}
	
			
}
