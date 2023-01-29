package UserManagement.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDtl {
	private int roleDtlId;
	private int userId;
	private int roleId;
	
	private RoleMst roleMst;
}
