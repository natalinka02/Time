
public class Watches {

	final int SECONDS_IN_A_DAY = 86400;

	private int seconds;
	private int minutes;
	private int hours;

	private int day;
	private int month;
	private int year;

	public String getTime() {
		return hours + ":" + minutes + ":" + seconds;
	}

	public String getDate() {
		return year + "." + month + "." + day;
	}

	public void setTime(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public void setDate(int year, int month, int day) {
		this.year = year;
		if (month >= 1 && month <= 12)
			this.month = month;
		if (day >= 1 && day <= 31)
			this.day = day;
	}

	private int getDaysInAMonth(int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			return (this.year % 4 == 0) ? 28 : 29;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 0;
		}
	}

	private void advanceMonth() {
		if (this.month == 12) {
			this.month = 1;
			this.year++;
		} else {
			this.month++;
		}
	}

	private void advanceDate(int hoursMinutesSeconds, int advanceSeconds) {
		int advanceDays = (hoursMinutesSeconds + advanceSeconds) / SECONDS_IN_A_DAY;
		advanceSeconds -= advanceDays * SECONDS_IN_A_DAY;
		while (true) {
			int daysInAMonth = getDaysInAMonth(this.month);
			if ((advanceDays + this.day) <= daysInAMonth) {
				this.day += advanceDays;
				break;
			} else {
				advanceMonth();
				advanceDays -= daysInAMonth - this.day;
				this.day = 0;
			}
		}
	}

	void tickTock(int advanceSeconds) {
		int hoursMinutesSeconds = this.hours * 3600 + this.minutes * 60 + this.seconds;
		if ((hoursMinutesSeconds + advanceSeconds) <= SECONDS_IN_A_DAY)
			return;
		advanceDate(hoursMinutesSeconds, advanceSeconds);
	}
}
