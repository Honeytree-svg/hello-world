package serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : sz
 * @Description :
 * @date : 2022-07-22 14:07
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guoke {

    private String name;
    private transient String pass;
    private Integer age;
}
