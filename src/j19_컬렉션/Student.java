package j19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;

//@RequiredArgsConstructor
//@NoArgsConstructor // 기본 생성자
/*  
 *  Data
 *  @Getter
 *  @Setter
 *  @EqualsAndHashCode
 *  @ToString
 * 
 */

@AllArgsConstructor// 전체 생성자
@Data
//그 외가 필요하면 커스텀 해서 쓴다.
public class Student {
	
	
	//@Getter // 특정 변수의 getter가 필요할 때 변수 위에 쓴다. //Target -> 어떤 곳에 어노테이션을 쓸 수 있는지 보여준다.
	private String name;// 이름
	private int year;// 학년
	//private final String address;
	
}
