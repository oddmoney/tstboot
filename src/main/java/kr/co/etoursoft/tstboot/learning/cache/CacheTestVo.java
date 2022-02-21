package kr.co.etoursoft.tstboot.learning.cache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
 * @Getter 와 @Setter 어노테이션은 Lombok 라이브러리에서 지원해주는 것으로, 자동으로 자바 get method와 set method를 등록해줌.
 * 클래스 내의 getter, setter 매서드의 코드를 줄일 수 있어 가독성을 높일 수 있음.
 */
@Getter
@Setter

/*
 * @RequiredArgsConstructor
 * 생성자를 만들어주는 어노테이션으로 final 또는 @Nonnull인 필드 값만 파라미터로 받는 생성자를 만든다.
 */
@RequiredArgsConstructor

/*
 * @Data
 * Lombok에서 제공하는 필드와 관련된 아래 어노테이션을 모두 포함한다.
 * @Getter @Setter @EqualsAndHashCode @AllArgsConstructor @toString @equals
 */
public class CacheTestVo {
	
    private String testName;
    private String testVal;
    
}
