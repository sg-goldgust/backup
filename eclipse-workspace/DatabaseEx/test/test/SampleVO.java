package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude= {"val3", "val4"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class SampleVO {
	@EqualsAndHashCode.Include
	private String val1;
	private String val2;
	private String val3;
	private String val4;
	
	
}
