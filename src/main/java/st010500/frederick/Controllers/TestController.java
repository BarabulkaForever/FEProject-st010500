package st010500.frederick.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bf on 17.01.18.
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello!";
    }

}
