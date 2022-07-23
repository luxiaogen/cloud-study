import java.time.ZonedDateTime;

/**
 * @author 陆小根
 * date: 2022/07/23
 * Description:
 */

public class T {

  public static void main(String[] args) {
    ZonedDateTime now = ZonedDateTime.now();
    System.out.println(now); // 默认时区
    // 2022-07-23T10:52:17.381+08:00[Asia/Shanghai]
  }

}
