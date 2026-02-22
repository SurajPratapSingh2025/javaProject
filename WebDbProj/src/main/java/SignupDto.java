import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
	private int sn;
	private String username;
	private String email;
	private String password;
	
	public SignupDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
