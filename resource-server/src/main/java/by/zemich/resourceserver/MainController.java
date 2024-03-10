package by.zemich.resourceserver;

import by.zemich.resourceserver.service.api.Access;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping("/secret")
public class MainController {

    private final Access accessService;

    public MainController(Access access) {
        this.accessService = access;
    }

    @GetMapping()
    public ResponseEntity<String> getSecret() {
        System.out.println("Secret");
        return ResponseEntity.ok(accessService.getSecretCode());
    }

}
