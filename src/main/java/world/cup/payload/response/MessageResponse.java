package world.cup.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse<T> {

	private boolean success=true;
	private String message;
	private String detail;
	private T object;
	public MessageResponse(String message) {
		super();
		this.message = message;
	} 

}

