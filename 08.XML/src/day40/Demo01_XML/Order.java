package day40.Demo01_XML;
enum type{
	vip,com,vvip
}
public class Order {
	
	private String type;  // vim, com, vvip
	private String name;
	private String flight;
	private String time;
	private String dest;
	
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Order [type=" + type + ", name=" + name + ", flight=" + flight
				+ ", time=" + time + ", dest=" + dest + "]";
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	
}
