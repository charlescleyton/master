import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller {
    @RequestMapping("/formusuario")
    public String usuario() {
        return "formusuario";
    }
}
