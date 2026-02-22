import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
	
	private int rollno;
	private String fullname;
	private String course;
	private float fee;
	private String college;
	private String address;
}
