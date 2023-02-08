package UserManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto<T> {
	private String code;
	private T body;
}
