package UserManagement.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleMst {
	private int roldId;
	private String roleName;
	
}
