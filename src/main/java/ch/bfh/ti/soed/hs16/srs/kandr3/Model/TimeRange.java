package ch.bfh.ti.soed.hs16.srs.kandr3;
import java.util.Date;
public class TimeRange {
	private Date date1;
	private Date date2;
	
	public TimeRange(Date date1,Date  date2){
		this.date1 = date1;
		this.date2 = date2;
	}

	@Override
	public String toString() {
		return "TimeRange [date1=" + date1 + ", date2=" + date2 + "]";
	}
}
